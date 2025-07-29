import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link, useNavigate } from 'react-router-dom';
import LoginForm from './components/LoginForm';
import SignInForm from './components/SignInForm';
import MainWindow from './components/MainWindow';

// Um componente simples para o menu de navegação (opcional)
function NavigationMenu() {
    return (
        <nav>
        <ul>
        <li><Link to="/login">Login</Link></li>
        <li><Link to="/signin">Cadastro</Link></li>
        <li><Link to="/main">Principal</Link></li>
        </ul>
        </nav>
    );
}

function App() {
    return (
        <Router>
        <div className="App">
        <NavigationMenu /> {/* Opcional: para navegar entre as telas */}
        <Routes>
        {/* Rota padrão: redireciona para /login */}
        <Route path="/" element={<LoginRedirect />} />
        <Route path="/login" element={<LoginForm />} />
        <Route path="/signin" element={<SignInForm />} />
        <Route path="/main" element={<MainWindow />} />
        {/* Você pode adicionar uma rota para 404 Not Found */}
        {/* <Route path="*" element={<h2>404 - Página Não Encontrada</h2>} /> */}
        </Routes>
        </div>
        </Router>
    );
}

// Componente para redirecionar para o login ao acessar a raiz
function LoginRedirect() {
    const navigate = useNavigate();
    React.useEffect(() => {
        navigate('/login');
    }, [navigate]);
    return null;
}

export default App;
