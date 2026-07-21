import React from 'react';
import './App.css';
import CohortDetails from './CohortDetails';

function App() {
  return (
    <div className="App">
        <h2>Dashboard</h2>
        <CohortDetails name="Java FSE" status="ongoing" startDate="01-01-2026" endDate="01-07-2026" />
        <CohortDetails name="React Training" status="completed" startDate="01-05-2026" endDate="01-06-2026" />
    </div>
  );
}

export default App;
