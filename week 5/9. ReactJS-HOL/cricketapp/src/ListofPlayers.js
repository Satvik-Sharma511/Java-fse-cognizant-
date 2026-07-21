import React from 'react';

const players = [
    { name: "Virat Kohli", score: 105 },
    { name: "Rohit Sharma", score: 85 },
    { name: "Shikhar Dhawan", score: 65 },
    { name: "KL Rahul", score: 45 },
    { name: "MS Dhoni", score: 72 },
    { name: "Hardik Pandya", score: 55 },
    { name: "Ravindra Jadeja", score: 34 },
    { name: "Bhuvneshwar Kumar", score: 12 },
    { name: "Jasprit Bumrah", score: 8 },
    { name: "Mohammed Shami", score: 5 },
    { name: "Yuzvendra Chahal", score: 2 }
];

const ListofPlayers = () => {
    const filteredPlayers = players.filter(player => player.score < 70);

    return (
        <div>
            <h2>List of All Players</h2>
            <ul>
                {players.map((p, index) => (
                    <li key={index}>{p.name} - Score: {p.score}</li>
                ))}
            </ul>

            <h2>Players with Scores Below 70</h2>
            <ul>
                {filteredPlayers.map((p, index) => (
                    <li key={index}>{p.name} - Score: {p.score}</li>
                ))}
            </ul>
        </div>
    );
}

export default ListofPlayers;
