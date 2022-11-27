import { useState } from 'react';
import './App.css';
import Display from './Components/Display/Display';

import NavBar from "./Components/NavBar/NavBar"
import TabFrame from './Components/TabFrame/TabFrame';

function App() {

  const [activeDisplay, setActiveDisplay] = useState("Tab")

  return (
    <div>
      <NavBar setDisplay = {setActiveDisplay}/>
      <Display display = {activeDisplay} setDisplay = {setActiveDisplay} />
    </div>
  );
}


export default App;
