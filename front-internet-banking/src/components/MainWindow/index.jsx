// src/components/MainWindow
import React, { useState } from 'react';
import Sidebar from '../Sidebar';
import './index.css'; // Estilos globais se necessário

function MainWindow() {

    return(
        <div className='mainwindow'>

            <Sidebar/>

            <div className="main-content shifted">
                <h1>Conteúdo Principal</h1>
                <p>Este é o conteúdo principal da sua aplicação.</p>
                <p>A sidebar pode ser controlada por um estado.</p>
            </div>
        </div>
    );
}

export default MainWindow;
