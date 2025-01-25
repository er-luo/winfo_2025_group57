import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import Calendar from "./calendar";
import Popup from 'reactjs-popup';

function Layout(props) {

  return (
    <>
      <div className="homeHeading"><h1>Plan your week ☆⌒(≧▽​° ) </h1></div>
      <Calendar/>

      <div>
            <Popup trigger=
                {<button type="submit" className="add-button" > + Add a Task</button>} 
                modal nested>
                {
                    close => (
                        <div className='modal'>
                            <div className='content'>
                                <h2>Create New Task:</h2>
                                <form>
                                  <label>
                                    Task Name
                                      <input
                                          type="text"
                                      />
                                  </label><br/>
                                  <label for="difficulty">How hard is this for you?</label>
                                  <select id="difficulty" name="difficulty">
                                    <option value="easy">Easy</option>
                                    <option value="ok">OK</option>
                                    <option value="difficult">Difficult</option>
                                  </select>
                                  <br/>
                                  <label for="dueDate">When is this due?</label>
                                  <input type="date" id="dueDate" name="dueDate"></input>
                              </form>
                            </div>
                            <div>
                                <button>Add</button>
                                <button onClick=
                                    {() => close()}>
                                        cancel
                                </button>
                            </div>
                        </div>
                    )
                }
            </Popup>
        </div>
    </>
  );
}

export default Layout;