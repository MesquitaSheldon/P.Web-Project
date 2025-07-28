import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import LoginForm from './components/LoginForm';
import SigninForm from './components/SigninForm';

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <SigninForm/>
  </StrictMode>,
)
