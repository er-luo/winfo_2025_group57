import React, { useState } from 'react';
import { Link } from 'react-router-dom';

function Layout(props) {
  return (
    <>
      <div className="homeHeading"><h1>Your Stats _〆(￣ー￣ )</h1></div>
      <div className="centered-container">
        <Link to="/">⬅️ back to Planner!</Link>
        <div className="stats">
            <ul> <h3>Last week: </h3>
                <li>You completed 6 out of 10 tasks!</li>
                <li>You spent 5.4 hours on Exams</li>
                <li>You spent 6.2 hours on Assignments</li>
                <li>You spent 2.1 hours on Projects</li>
                <li>You spent 3.8 hours on Quizzes</li>
            </ul>
        </div>
      </div>
      
    </>
  );
}

export default Layout;