import React, { useState } from 'react';
import './App.css';

const GuestPage = () => {
  return (
    <div>
      <h2>Guest Page</h2>
      <p>Flight Details: Flight 101 to New York, Flight 202 to London.</p>
      <p>Please log in to book a ticket.</p>
    </div>
  );
};

const UserPage = () => {
  return (
    <div>
      <h2>User Page</h2>
      <p>Welcome back! You can now book your tickets.</p>
      <button>Book Flight 101</button>
      <button>Book Flight 202</button>
    </div>
  );
};

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  let pageContent;
  if (isLoggedIn) {
    pageContent = <UserPage />;
  } else {
    pageContent = <GuestPage />;
  }

  return (
    <div className="App" style={{ padding: '20px' }}>
      <h1>Ticket Booking App</h1>
      <div style={{ marginBottom: '20px' }}>
        {isLoggedIn ? (
          <button onClick={() => setIsLoggedIn(false)}>Logout</button>
        ) : (
          <button onClick={() => setIsLoggedIn(true)}>Login</button>
        )}
      </div>
      <hr />
      {pageContent}
    </div>
  );
}

export default App;
