import React from 'react';
import './App.css';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div className="App">
      <CalculateScore Name="John Doe" School="High School" Total={250} Goal={5} />
    </div>
  );
}

export default App;
