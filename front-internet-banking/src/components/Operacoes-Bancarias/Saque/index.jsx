// src/components/Operacoes-Bancarias/Saque/index.jsx
import { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import Sidebar from '../../Sidebar';
import { toast } from 'react-toastify'; // Importe o toast
//import './index.css'; // Importa o arquivo CSS

function Saque() {
    const navigate = useNavigate(); // Hook para navegação programática

    return (
        <div className='saque'>

            <Sidebar />
            <div className="main-content shifted">
                <h1>
                    Fazer Saque
                </h1>
            </div>
        </div>
    )

} export default Saque;
