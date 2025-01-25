import React, { useState } from 'react';
import { Link } from 'react-router-dom';

function Layout(props) {

  return (
    <>
      <nav className="navbar">
        ScheduleApp
        <ul>
          <li>
            <Link to="/">Home</Link>
          </li>
          <li>
            <Link to="/blogs">Blogs</Link>
          </li>
          <li>
            <Link to="/contact">Contact</Link>
          </li>
        </ul>
      </nav>

    </>
  );
}

export default Layout;