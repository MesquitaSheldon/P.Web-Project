// src/components/LoginForm/index.jsx
import React, { useState } from 'react';
import './index.css'; // Importa o arquivo CSS

function LoginForm() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleInputChange = (event) => {
        const { name, value } = event.target;
        if (name === 'username') {
            setUsername(value);
        } else if (name === 'password') {
            setPassword(value);
        }
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        console.log('Dados de Login:', { username, password });
        alert(`Tentando logar com Usuário: ${username} e Senha: ${password}`);
        // Opcional: Limpar os campos após o envio
        // setUsername('');
        // setPassword('');
    };

    return (
        <div className="login-container"> {/* Aplica a classe CSS */}
            <h2>Login</h2>
            <form onSubmit={handleSubmit} className="login-form"> {/* Aplica a classe CSS */}
            <div className="form-group"> {/* Aplica a classe CSS */}
                <label htmlFor="username">Usuário:</label>
                <input
                    type="text"
                    id="username"
                    name="username"
                    placeholder="Nome de Usuario"
                    value={username}
                    onChange={handleInputChange}
                    required
                />
            </div>
            <div className="form-group"> {/* Aplica a classe CSS */}
                <label htmlFor="password">Senha:</label>
                <input
                    type="password"
                    id="password"
                    name="password"
                    placeholder="*******"
                    value={password}
                    onChange={handleInputChange}
                    required
                />
            </div>
            <button type="submit" className="login-button"> {/* Aplica a classe CSS */}
                Entrar
            </button>
            </form>
        </div>
    );
}

export default LoginForm;
