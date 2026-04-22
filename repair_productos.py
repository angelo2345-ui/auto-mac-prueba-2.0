from pathlib import Path
import re
import unicodedata

ROOT = Path(r"c:\Users\Admin\Downloads\copia automac\auto-mac-prueba-2.0-clean")
FILE_PATH = ROOT / "src" / "pages" / "Productos.vue"
BASE = "/images/productos/"

def repair_mojibake(value: str) -> str:
    try:
        return value.encode("latin-1").decode("utf-8")
    except Exception:
        return value

def normalize_segment(segment: str) -> str:
    normalized = unicodedata.normalize("NFD", segment)
    normalized = "".join(
        ch for ch in normalized if unicodedata.category(ch) != "Mn"
    )
    normalized = normalized.lower()
    normalized = re.sub(r"[^a-z0-9._-]+", "-", normalized)
    normalized = re.sub(r"-{2,}", "-", normalized).strip("-.")
    return normalized

def normalize_relative_path(relative: str) -> str:
    parts = [part for part in relative.replace("\\", "/").split("/") if part]
    normalized_parts = []
    for part in parts:
        if "." in part:
            name, ext = part.rsplit(".", 1)
            normalized_parts.append(f"{normalize_segment(name)}.{ext.lower()}")
        else:
            normalized_parts.append(normalize_segment(part))
    return "/".join(normalized_parts)

def replace_image_path(match):
    prefix, original_path, suffix = match.groups()
    relative = original_path[len(BASE):]
    normalized = normalize_relative_path(relative)
    return f"{prefix}{BASE}{normalized}{suffix}"

text = FILE_PATH.read_text(encoding="utf-8")
text = repair_mojibake(text)
pattern = re.compile(r"(image:\s*')(/images/productos/[^']+)(')")
text = pattern.sub(replace_image_path, text)
FILE_PATH.write_text(text, encoding="utf-8", newline="\n")

print("Productos.vue reparado y rutas de imagen normalizadas.")