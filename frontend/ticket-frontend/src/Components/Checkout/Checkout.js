import './Checkout.css';
import { useState } from 'react';

function Checkout() {
  const [name, setName] = useState("");

  return (
    <form>
      <InputField label = "Email" className="full"/>
      <InputField label = "First Name" className="two-wide left"/>
      <InputField label = "Last Name" className="two-wide right"/>

      <InputField label = "Address" className="full"/>
      
      <InputField label = "City" className="two-wide left"/>
      <InputField label = "Province/State" className="two-wide right"/>
      <InputField label = "Country" className="two-wide left"/>

      <InputField label = "Postal Code" className="two-wide right"/>

      <button className='checkout-button'>Purchase</button>
      <button className='checkout-button'>Cancel</button>
      
    </form>
  )
}

function InputField(props) {

  let classes = 'field_input-wrapper ' + props.className

  return (
		<div className={classes}>
      <label className='field-label'>{props.label}</label>
      <input className='field-input'></input>
		</div>
	)
}


export default Checkout