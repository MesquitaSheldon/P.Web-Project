// src/components/Sidebar.js
import { useState } from 'react';
import { BrowserRouter as Router, Routes, Route, Link, useNavigate } from 'react-router-dom';
import './index.css'; // Importe seu arquivo CSS para estilização

function Sidebar() {
    const [name, setUsername] = useState(sessionStorage.getItem('userName'));
    const [cpf, setUserCpf] = useState(sessionStorage.getItem('userCpf'));

    const LogOutExecution = () => {
        return(
            alert(`Deslogando com user: ${name} , cpf: ${cpf}`),
            sessionStorage.clear()
        )
    }

    return (
        <div className="sidebar">
            <h1>
                Olá {name},<br/>seja bem-vido(a)!
            </h1>
            <nav className="navegation">
                    <div> opcao 1 </div>
                    <div> opcao 2 </div>
                    <div> opcao 3 </div>
                    <div><button onClick={LogOutExecution}><Link to="/login">Logout</Link></button></div>
            </nav>
        </div>
    );
}

export default Sidebar;
