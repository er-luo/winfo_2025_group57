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
                <li>You spent 5.4 hours on Exams! That is an average of 3 hours per exam.</li>
                <li>You spent 6.2 hours on Assignments! That is an average of 2.3 hours per assignment.</li>
                <li>You spent 2.1 hours on Projects! That is an average of 2.1 hours per project.</li>
                <li>You spent 3.8 hours on Quizzes! That is an average of 1.6 per quiz.</li>
            </ul>
        </div>
      </div>
      
    </>
  );
}

export default Layout;