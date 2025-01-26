import React, { useState } from 'react';
import Popup from 'reactjs-popup';


export default function PopUp() {
    const [seen, setSeen] = useState(false)

    function togglePop () {
        setSeen(!seen);
    };

    return (
        <div>
            <Popup trigger= {<button type="submit" className="add-button" > + Add a Task</button>} modal nested>
                {
                    close => (
                        <div className='modal'>
                            <div className='content'>
                            <form>
                                <h2>Create New Task:</h2>
                                <label>
                                    Task Name
                                      <input
                                          type="text"
                                      />
                                  </label><br/>
                                  <label for="category">What type of task is this?</label>
                                  <select id="category" name="category">
                                    <option value="exam">Exam</option>
                                    <option value="quiz">Quiz</option>
                                    <option value="assignment">Assignment</option>
                                    <option value="project">Project</option>
                                  </select>
                                  <br/>
                                  <label for="difficulty">How hard is this for you?</label>
                                  <select id="difficulty" name="difficulty">
                                    <option value="1">1 (Easy)</option>
                                    <option value="2">2</option>
                                    <option value="3">3 (Difficult)</option>
                                  </select><br/>
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
    );
}