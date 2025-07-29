// src/components/MainWindow/index.jsx
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function MainWindow() {
    const navigate = useNavigate(); // Hook para navegação programática

    const handleLogout = (event) => {
        navigate('/login');
    };

    return (
        <div className="login-container">
        <h2>MainWindow<br/><br/></h2>
        <form onSubmit={handleLogout} className="login-form">
        <button type="submit" className="login-button">
            LogOut
        </button>
        </form>
        </div>
    );

} export default MainWindow;
