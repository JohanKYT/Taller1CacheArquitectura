import React, { useState } from "react";
import "./App.css";

function App() {
    const [greeting, setGreeting] = useState("");
    const [sumResult, setSumResult] = useState("");
    const [hora, setHora] = useState("");
    const [mensaje, setMensaje] = useState("");
    const [name, setName] = useState("");
    const [a, setA] = useState("");
    const [b, setB] = useState("");

    const API_URL = "http://localhost:8080";

    const handleGreeting = async () => {
        try {
            const res = await fetch(`${API_URL}/greeting?name=${name}`);
            const data = await res.json();
            setGreeting(data.content);
        } catch (error) {
            setGreeting("Error: " + error.message);
        }
    };

    const handleSumar = async () => {
        try {
            const res = await fetch(`${API_URL}/sumar?a=${a}&b=${b}`);
            const data = await res.text();
            setSumResult(data);
        } catch (error) {
            setSumResult("Error: " + error.message);
        }
    };

    const handleHora = async () => {
        try {
            const res = await fetch(`${API_URL}/hora`);
            const data = await res.text();
            setHora(data);
        } catch (error) {
            setHora("Error: " + error.message);
        }
    };

    const handleMensaje = async () => {
        try {
            const res = await fetch(`${API_URL}/mensaje`);
            const data = await res.text();
            setMensaje(data);
        } catch (error) {
            setMensaje("Error: " + error.message);
        }
    };

    const handleClearCache = async () => {
        try {
            const res = await fetch(`${API_URL}/clear-cache`, { method: "POST" });
            const data = await res.text();
            setMensaje(data);
        } catch (error) {
            setMensaje("Error: " + error.message);
        }
    };


    return (
        <div className="container">
            <h1>Taller 1: Cache + Front(Spring)</h1>

            <div className="card">
                <h2>/greeting</h2>
                <input
                    type="text"
                    value={name}
                    placeholder="Tu nombre"
                    onChange={(e) => setName(e.target.value)}
                />
                <button onClick={handleGreeting}>Saludar</button>
                <p className="response">{greeting}</p>
            </div>

            <div className="card">
                <h2>/sumar</h2>
                <input
                    type="number"
                    value={a}
                    placeholder="Número A"
                    onChange={(e) => setA(e.target.value)}
                />
                <input
                    type="number"
                    value={b}
                    placeholder="Número B"
                    onChange={(e) => setB(e.target.value)}
                />
                <button onClick={handleSumar}>Sumar</button>
                <p className="response">{sumResult}</p>
            </div>

            <div className="card">
                <h2>/hora</h2>
                <button onClick={handleHora}>Obtener hora</button>
                <p className="response">{hora}</p>
            </div>

            <div className="card">
                <h2>/mensaje</h2>
                <button onClick={handleMensaje}>Obtener mensaje</button>
                <button className="clear-cache" onClick={handleClearCache}>
                    Limpiar caché
                </button>
                <p className="response">{mensaje}</p>
            </div>

        </div>
    );
}

export default App;

