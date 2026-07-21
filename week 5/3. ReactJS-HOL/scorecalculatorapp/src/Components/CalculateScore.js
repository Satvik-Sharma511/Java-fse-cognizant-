import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore({ Name, School, Total, Goal }) {
    const calcScore = (Total, Goal) => {
        return (Total / Goal).toFixed(2);
    };
    return (
        <div>
            <h1 className="format1">Student Details</h1>
            <p className="format2"><b>Name:</b> {Name}</p>
            <p className="format2"><b>School:</b> {School}</p>
            <p className="format2"><b>Total:</b> {Total}</p>
            <p className="format2"><b>Goal:</b> {Goal}</p>
            <p className="format2"><b>Score:</b> {calcScore(Total, Goal)}</p>
        </div>
    );
}

export default CalculateScore;
