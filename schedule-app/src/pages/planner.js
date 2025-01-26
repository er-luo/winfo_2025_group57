import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import Calendar from "./calendar";
import Popup from './popup';

function Layout(props) {
  return (
    <>
      <div className="homeHeading"><h1>Plan your week ☆⌒(≧▽​° ) </h1></div>
      <div className="centered-container "><Link to="/stats">View Stats 📊</Link></div>
      <Calendar/>
      <Popup/>
    </>
  );
}

export default Layout;