import React from 'react';

const IndianPlayers = () => {
    const teamPlayers = ["Player1", "Player2", "Player3", "Player4", "Player5", "Player6"];
    const [odd1, even1, odd2, even2, odd3, even3] = teamPlayers;

    const T20players = ["Rohit", "Virat", "Rahul"];
    const RanjiTrophyPlayers = ["Pujara", "Rahane"];
    const allPlayers = [...T20players, ...RanjiTrophyPlayers];

    return (
        <div>
            <h2>Odd and Even Players</h2>
            <p>Odd Players: {odd1}, {odd2}, {odd3}</p>
            <p>Even Players: {even1}, {even2}, {even3}</p>
            
            <h2>Merged Players</h2>
            <ul>
                {allPlayers.map((p, index) => (
                    <li key={index}>{p}</li>
                ))}
            </ul>
        </div>
    );
};

export default IndianPlayers;
