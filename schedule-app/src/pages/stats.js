import React, { useState } from 'react';
import { Link } from 'react-router-dom';

function Layout(props) {
  return (
    <>
      <div className="homeHeading"><h1>Your Stats _〆(￣ー￣ )</h1></div>
      <div className="container">
        <Link to="/">back to Planner!</Link>
      </div>
      
    </>
  );
}

export default Layout;