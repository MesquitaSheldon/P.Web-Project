// src/main.jsx
import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import { ToastContainer } from 'react-toastify';
import App from './App';

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <App/>
    <ToastContainer />
  </StrictMode>
)
