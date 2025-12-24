import { initializeApp } from "firebase/app";
import { getAuth } from "firebase/auth";
import { getFirestore } from "firebase/firestore";
import { getStorage } from "firebase/storage";

const firebaseConfig = {
  apiKey: "AIzaSyC0EIGduwOGJr2xgeSLMgbUvtXY4iebkC0",
  authDomain: "automac-blog.firebaseapp.com",
  projectId: "automac-blog",
  storageBucket: "automac-blog.firebasestorage.app",
  messagingSenderId: "605756706622",
  appId: "1:605756706622:web:d4bcd05971f43b1845a66f"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);

// Export services
export const auth = getAuth(app);
export const db = getFirestore(app);
export const storage = getStorage(app);
