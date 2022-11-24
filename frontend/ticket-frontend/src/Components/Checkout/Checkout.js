import './Checkout.css';
import { useState } from 'react';

function Checkout() {
  const [name, setName] = useState("");

  return (
    <form>
		<InputField label = "test"/>
      {/* <label>Enter your name:
        <input
          type="text" 
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
      </label> */}
    </form>
  )
}

function InputField(props) {
	return (
		<div className='field_input-wrapper'>
			<label className='field-label'>{props.label}</label>
			<input className='field-input'></input>
		</div>
	)
}


export default Checkout