// src/components/LoginForm/index.jsx
import { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import { toast } from 'react-toastify'; // Importe o toast
import './index.css'; // Importa o arquivo CSS

function LoginForm() {
    const navigate = useNavigate(); // Hook para navegação programática
    const [cpf, setCpf] = useState('');
    const [password, setPassword] = useState('');
    const [users, setUsers] = useState([
        { name: 'Sheldon', cpf: '123.123.123-12', password:'123' },
        { name: 'Teste', cpf: '123.123.123-11', password:'1234' }
    ]);

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

    const handleInputChange = (event) => {
        const { name, value } = event.target;
        if (name === "cpf") {
            setCpf(formatCpf(value));
        } else if (name === "password") {
            setPassword(value);
        }
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        const foundUser = users.find(user => user.cpf === cpf);

        if(!foundUser){
            toast.error(`Login e senha não encontrados. Login: ${cpf} e Senha: ${password}`, {
                position: "top-center",
                autoClose: 2000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
            });
            setPassword('');
            setCpf('');
            navigate('/login');
        }

        if(foundUser.password === password){
            sessionStorage.setItem('userName', foundUser.name);
            sessionStorage.setItem('userCpf', cpf);
            toast.success(`Bem-vindo(a), ${foundUser.name}!`, {
                position: "top-center",
                autoClose: 2000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
            });
            navigate('/main');
        }

        if(foundUser.password !== password){
            toast.error(`Senha incorreta: ${password}`, {
                position: "top-center",
                autoClose: 2000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
            });
            setPassword('');
        }
    };

    return (
        <div className="login-container">
            <h2>Login</h2>
            <form onSubmit={handleSubmit} className="login-form">
            <div className="form-group">
                <label htmlFor="CPF">CPF:</label>
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
                <label htmlFor="password">Password:</label>
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
            <button type="submit" className="login-button">
                Login
            </button>
            <div className="login-footer">Ainda não tem conta? <Link to="/signin">Clique aqui</Link> </div>
            </form>
        </div>
    );

} export default LoginForm;
