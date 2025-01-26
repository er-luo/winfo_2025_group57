import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate} from 'react-router-dom';
import Planner from './planner';

function App(props) {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Planner/>} />
      </Routes>
    </Router>
  );
}

export default App;