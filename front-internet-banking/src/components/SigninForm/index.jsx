// src/components/SigninForm/index.jsx
import React, { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import './index.css';

function SigninForm(){
    const navigate = useNavigate(); // Hook para navegação programática
    const [name, setName] = useState('');
    const [cpf, setCpf] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    const formatCpf = (value) => {
        // Remove tudo que não for dígito
        value = value.replace(/\D/g, '');

        // Aplica a máscara
        if (value.length > 0) {
            value = value.replace(/^(\d{3})(\d)/, '$1.$2');
            value = value.replace(/^(\d{3})\.(\d{3})(\d)/, '$1.$2.$3');
            value = value.replace(/\.(\d{3})(\d)/, '.$1-$2');
        }

        // Limita o tamanho máximo do CPF
        if (value.length > 14) {
            value = value.substring(0, 14);
        }

        return value;
    };

    const handleSubmit = (event) => {
        navigate('/login');
    }

    const handleInputChange = (event) => {
        const { name, value } = event.target;
        if (name === "name"){
            setName(value);
        } else if (name === "cpf") {
            setCpf(formatCpf(value));
        } else if (name === "email") {
            setEmail(value);
        } else if (name === "password"){
            setPassword(value);
        }
    };

    return(
        <div className="signin-container">
            <h2>Signin</h2>
            <form onSubmit={handleSubmit} className="signin-form">
                <div className="form-group">
                    <label htmlForm="Name">Name:</label>
                    <input
                    type="text"
                    id="nameInput"
                    name="name"
                    placeholder="Enter your name here"
                    value={name}
                    onChange={handleInputChange}
                    required
                    />
                </div>
                <div className="form-group">
                    <label htmlForm="CPF">CPF:</label>
                    <input
                    type="text"
                    id="cpfInput"
                    name="cpf"
                    placeholder="___.___.___-__"
                    value={cpf}
                    onChange={handleInputChange}
                    required
                    />
                </div>
                <div className="form-group">
                    <label htmlForm="email">Email:</label>
                    <input
                    type="email"
                    id="emailInput"
                    name="email"
                    placeholder="your.email@example.com"
                    value={email}
                    onChange={handleInputChange}
                    required
                    />
                </div>
                <div className="form-group">
                    <label htmlForm="password">Password:</label>
                    <input
                    type="password"
                    id="passwordInput"
                    name="password"
                    placeholder="*******"
                    value={password}
                    onChange={handleInputChange}
                    required
                    />
                </div>
                <button type="submit" className="signin-button">
                    Signin
                </button>
                 <div className="signin-footer">Já tem uma conta? <Link to="/login">Clique aqui</Link> </div>
            </form>
        </div>
    );


} export default SigninForm;
