import { useState, useContext } from 'react';
import './App.css';
import Display from './Components/Display/Display';

import { UserContext } from './UserContext';

import NavBar from "./Components/NavBar/NavBar"

function App() {

  const [user, setUser] = useState("none")

  const [activeDisplay, setActiveDisplay] = useState("Tab")
  
  return (
    <div>
      <UserContext.Provider value = {{user, setUser}}>
        <NavBar setDisplay = {setActiveDisplay}/>
        <Display display = {activeDisplay} setDisplay = {setActiveDisplay} />
      </UserContext.Provider>
    </div>
  );
}


export default App;
