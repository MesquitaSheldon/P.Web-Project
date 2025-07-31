// src/components/Sidebar.js
import { useState } from 'react';
import { toast } from 'react-toastify'; // Importe o toast
import { Link, useNavigate } from 'react-router-dom';
import './index.css'; // Importe seu arquivo CSS para estilização

function Sidebar() {
    const navigate = useNavigate();
    const [name, setUsername] = useState(sessionStorage.getItem('userName'));
    const [cpf, setUserCpf] = useState(sessionStorage.getItem('userCpf'));

    const LogOutExecution = () => {
        toast.success(`Deslogando com user: ${name}, cpf: ${cpf}`, {
            position: "top-center",
            autoClose: 2000,
            hideProgressBar: false,
            closeOnClick: true,
            pauseOnHover: true,
            draggable: true,
            progress: undefined,
        });
        sessionStorage.clear()
        navigate('/login');
    }

    return (
        <div className="sidebar">
            <div className="Fofis-Bank-logo-container">
                <img src="/src/assets/images/Fofis-Bank.png"
                    alt="Fofis Bank Logo"
                    className="Fofis-Bank-logo-image" />
            </div>
            <h1>
                Olá {name},<br/>seja bem-vido(a)!
            </h1>
            <nav className="navegation">
                    <div><Link to="/Deposito" className="sidebar-link">Deposito</Link></div>
                    <div><Link to="/Saque" className="sidebar-link">Saque</Link></div>
                    <div><Link to="/Pagamento" className="sidebar-link">Pagamento</Link></div>
                    <div><Link to="/Extrato" className="sidebar-link">Extrato</Link></div>
                    <div className="logout-div"><button onClick={LogOutExecution} className="logout-button">Logout</button></div>
            </nav>
        </div>
    );
}

export default Sidebar;
