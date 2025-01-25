import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import Calendar from "./calendar";


function Layout(props) {

  return (
    <>
      <div className="homeHeading"><h1>Plan your week ☆⌒(≧▽​° ) </h1></div>
      <Calendar/>
      <button type="submit" className="add-button" > + Add a Task</button>

    </>
  );
}

export default Layout;