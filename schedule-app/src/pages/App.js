import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate} from 'react-router-dom';
import Planner from './planner';
import Stats from './stats';

function App(props) {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Planner/>} />
        <Route path="/stats" element={<Stats/>} />
      </Routes>
    </Router>
  );
}

export default App;