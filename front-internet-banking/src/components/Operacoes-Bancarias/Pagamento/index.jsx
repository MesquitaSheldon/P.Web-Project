// src/components/Operacoes-Bancarias/Pagamento/index.jsx
import { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import Sidebar from '../../Sidebar';
import { toast } from 'react-toastify'; // Importe o toast
//import './index.css'; // Importa o arquivo CSS

function Pagamento() {
    const navigate = useNavigate(); // Hook para navegação programática

    return (
        <div className='deposito'>

        <Sidebar/>
            <div className="main-content shifted">
                <h1>
                    Fazer Pagamento
                </h1>
            </div>
        </div>
    )

} export default Pagamento;
