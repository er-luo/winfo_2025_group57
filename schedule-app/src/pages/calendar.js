import React from 'react';


function calendar(){
    return(
        <div className="week">
            <div className="day">
                Sunday
                <div className="task">
                    <ul>
                        <li>2:00 PM: Math HW</li>
                    </ul>
                </div>
            </div>
            <div className="day">Monday</div>
            <div className="day">Tuesday</div>
            <div className="day">Wednesday</div>
            <div className="day">Thursday</div>
            <div className="day">Friday</div>
            <div className="day">Saturday</div>
        </div>
    );
}

export default calendar;