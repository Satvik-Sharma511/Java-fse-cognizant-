import React from 'react';
import './App.css';

function App() {
  const offices = [
    { Name: 'DBS', Rent: 50000, Address: 'Chennai' },
    { Name: 'Ozone', Rent: 70000, Address: 'Bangalore' }
  ];

  const imgUrl = "https://images.unsplash.com/photo-1497366216548-37526070297c?auto=format&fit=crop&w=400&q=80";

  return (
    <div className="App" style={{ padding: '20px' }}>
      <h1>Office Space for Rent</h1>
      <img src={imgUrl} alt="Office Space" style={{ width: '400px', borderRadius: '10px' }} />
      <h2>Available Locations</h2>
      {offices.map((office, index) => {
        const rentStyle = { color: office.Rent < 60000 ? 'red' : 'green' };
        return (
          <div key={index} style={{ border: '1px solid #ccc', margin: '10px 0', padding: '10px' }}>
            <p><strong>Name:</strong> {office.Name}</p>
            <p><strong>Rent:</strong> <span style={rentStyle}>Rs. {office.Rent}</span></p>
            <p><strong>Address:</strong> {office.Address}</p>
          </div>
        );
      })}
    </div>
  );
}

export default App;
