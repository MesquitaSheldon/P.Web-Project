// src/components/Operacoes-Bancarias/Extrato/index.jsx
import { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import Sidebar from '../../Sidebar';
import { toast } from 'react-toastify'; // Importe o toast
//import './index.css'; // Importa o arquivo CSS

function Extrato() {
    const navigate = useNavigate(); // Hook para navegação programática

    return (
        <div className='extrato'>

        <Sidebar/>
        <div className="main-content shifted">
            <h1>
                Fazer Extrato
            </h1>
        </div>
    </div>
    )

} export default Extrato;
