// src/components/Operacoes-Bancarias/Deposito/index.jsx
import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import Sidebar from "../../Sidebar";
import { toast } from "react-toastify"; // Importe o toast
import axios from "axios";
//import './index.css'; // Importa o arquivo CSS

function Deposito() {
  const navigate = useNavigate(); // Hook para navegação programática

  const getUser = async () => {
    try {
      const response = await axios.get("http://localhost:8080/api/user");
      console.log(response.data); // Exibe a lista de produtos recebida
      return response.data;
    } catch (e) {
      console.error("Erro ao buscar usuarios:", e);
    }
  };

  return (
    <div className="deposito">
      <Sidebar />
      <div className="main-content shifted">
        <h1>Fazer deposito</h1>
        <button onClick={getUser}> AQUI</button>
      </div>
    </div>
  );
}
export default Deposito;
