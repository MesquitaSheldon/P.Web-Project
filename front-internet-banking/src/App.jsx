// src/App.jsx
import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link, useNavigate } from 'react-router-dom';
import LoginForm from './components/LoginForm';
import SignInForm from './components/SignInForm';
import MainWindow from './components/MainWindow';
import Deposito from './components/Operacoes-Bancarias/Deposito';
import Saque from './components/Operacoes-Bancarias/Saque';
import Pagamento from './components/Operacoes-Bancarias/Pagamento';
import Extrato from './components/Operacoes-Bancarias/Extrato';

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
            <Routes>
                {/* Rota padrão: redireciona para /login */}
                <Route path="/" element={<LoginRedirect />} />
                <Route path="/login" element={<LoginForm />} />
                <Route path="/signin" element={<SignInForm />} />
                <Route path="/main" element={<MainWindow />} />
                <Route path="/Deposito" element={<Deposito />} />
                <Route path="/Saque" element={<Saque />} />
                <Route path="/Pagamento" element={<Pagamento />} />
                <Route path="/Extrato" element={<Extrato />} />
                {/* TO-DO adicionar uma rota para 404 Not Found */}
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
