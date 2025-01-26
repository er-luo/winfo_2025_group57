import React, { useState } from 'react';
import Popup from 'reactjs-popup';
import axios from "axios";


export default function PopUp() {
    const [task, setTask] = useState({
        name: "",
        dueDate: "",
        category: "exam",
        difficulty: 1,
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setTask({ ...task, [name]: value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post("http://localhost:8080/api/tasks/add", task).then((response) => {
                console.log(response.status, response.data);
            });;
        } catch (error) {
            console.error("Error adding task:", error);
        }
    };

    return (
        <div>
            <Popup trigger= {<button type="submit" className="add-button" > + Add a Task</button>} modal nested>
                {
                    close => (
                        <div className='modal'>
                            <div className='content'>
                            <form onSubmit={handleSubmit}>
                                <h2>Create New Task:</h2>
                                <label>
                                    Task Name
                                      <input type="text" name="name" onChange={handleChange} required/>
                                  </label><br/>
                                  <label for="category">What type of task is this?</label>
                                  <select id="category" name="category" onChange={handleChange}>
                                    <option value="exam">Exam</option>
                                    <option value="quiz">Quiz</option>
                                    <option value="assignment">Assignment</option>
                                    <option value="project">Project</option>
                                  </select>
                                  <br/>
                                  <label for="difficulty">How hard is this for you?</label>
                                  <select id="difficulty" name="difficulty" onChange={handleChange}>
                                    <option value="1">1 (Easy)</option>
                                    <option value="2">2</option>
                                    <option value="3">3 (Difficult)</option>
                                  </select><br/>
                                  <label for="dueDate">When is this due?</label>
                                  <input type="date" id="dueDate" name="dueDate" onChange={handleChange} required />
                              </form>
                            </div>
                            <div>
                                <button type="submit" >Add</button>
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