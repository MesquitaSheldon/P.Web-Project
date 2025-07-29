// src/components/Sidebar.js
import { useState } from 'react';
import { BrowserRouter as Router, Routes, Route, Link, useNavigate } from 'react-router-dom';
import './index.css'; // Importe seu arquivo CSS para estilização

function Sidebar() {
    const [userName, setUsername] = useState(sessionStorage.getItem('userName'));
    const [userCpf, setUserCpf] = useState(sessionStorage.getItem('userCpf'));

    return (
        <div className="sidebar">
            <h1>
                Olá {userName},<br/>seja bem-vido(a)!
            </h1>
            <nav className="navegation">
                <ul>
                    <li><Link to="/login">Login</Link></li>
                    <li><Link to="/signin">Cadastro</Link></li>
                    <li><Link to="/main">Principal</Link></li>
                </ul>
            </nav>
        </div>
    );
}

export default Sidebar;
