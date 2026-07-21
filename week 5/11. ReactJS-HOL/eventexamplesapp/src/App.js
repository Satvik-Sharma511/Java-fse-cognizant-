import React, { useState } from 'react';
import './App.css';

const CurrencyConvertor = () => {
  const [rupees, setRupees] = useState('');
  const [euros, setEuros] = useState(null);

  const handleSubmit = (e) => {
    e.preventDefault();
    // Assuming 1 Euro = 90 INR
    const converted = parseFloat(rupees) / 90;
    setEuros(converted.toFixed(2));
  }

  return (
    <div style={{ marginTop: '20px', padding: '10px', border: '1px solid black' }}>
      <h3>Currency Convertor (INR to Euro)</h3>
      <form onSubmit={handleSubmit}>
        <input 
          type="number" 
          value={rupees} 
          onChange={(e) => setRupees(e.target.value)} 
          placeholder="Enter INR" 
          required 
        />
        <button type="submit">Convert</button>
      </form>
      {euros !== null && <p>Equivalent Euros: €{euros}</p>}
    </div>
  );
}

function App() {
  const [counter, setCounter] = useState(0);
  const [msg, setMsg] = useState('');

  const handleIncrement = () => {
    setCounter(prev => prev + 1);
    setMsg("Hello, the counter was incremented!");
  };

  const handleDecrement = () => {
    setCounter(prev => prev - 1);
    setMsg("");
  };

  const sayWelcome = (arg) => {
    alert("Message: " + arg);
  };

  const handlePress = (e) => {
    console.log("Event details:", e);
    alert("I was clicked");
  };

  return (
    <div className="App" style={{ padding: '20px' }}>
      <h1>Event Handling in React</h1>
      
      <div>
        <h3>Counter: {counter}</h3>
        <button onClick={handleIncrement}>Increment</button>
        <button onClick={handleDecrement}>Decrement</button>
        <p style={{ color: 'blue' }}>{msg}</p>
      </div>

      <div style={{ marginTop: '20px' }}>
        <button onClick={() => sayWelcome('welcome')}>Say Welcome</button>
      </div>

      <div style={{ marginTop: '20px' }}>
        <button onClick={handlePress}>OnPress (Synthetic Event)</button>
      </div>

      <CurrencyConvertor />
    </div>
  );
}

export default App;
