import './Checkout.css';
import React, { useState } from 'react';

function Checkout(props) {

  const [info, setInfo] = useState({})

  const numTickets = props.params.seats.length
  const ticketPrice = 19.99
  let value = ticketPrice * numTickets
  let gst = value * 0.05
  let total = value + gst

  value = value.toFixed(2)
  gst = gst.toFixed(2)
  total = total.toFixed(2)

  const clicked = () => {
    
    let valid = true
    if (Object.keys(info).length !== 12) {
        valid = false
    }

    for (let key of Object.keys(info)) {
      if (info[key] == "") {
        valid = false
        break
      }
    }

    if (!valid) {
      alert("Missing Required Entries")
      return
    }
  }

  const canceled = () => {
    props.setCount(0)
    props.setParameters({movie: '', theater: "", showtime: "", seats: []})
  }

  return (
    <div className='division'>
      <h4>Order Summary</h4>
      <div>
        <table className='field_input-wrapper'>
          <tbody>
            <tr>
              <td className='left'>Movie:</td>
              <td className='right-align'>{props.params.movie}</td>
            </tr>
            <tr>
              <td className='left'>Theater:</td>
              <td className='right-align'>{props.params.theater}</td>
            </tr>
            <tr>
              <td className='left'>Time:</td>
              <td className='right-align'>{props.params.showtime}</td>
            </tr>
            <tr><td>&emsp;</td></tr>
            <tr>
              <td className='left'>Items: Ticket (x{numTickets}) $19.99</td>
              <td className='right-align'>${value}</td>
            </tr>
            <tr className="underlined">
              <td className='left'>GST:</td><td className='right-align'>${gst}</td>
            </tr>
            <tr>
              <td className='left'>Total:</td><td className='right-align'>${total}</td>
            </tr>
          </tbody>
        </table>
      </div>
      <form>
          <h4>Credit Card Information</h4>
          <InputField label = "Card Number" className="full" info = {info} setInfo = {setInfo}/>
          <InputField label = "Name on Card" className="full" info = {info} setInfo = {setInfo}/>
          <InputField label = "Expiration Date" className="two-wide left" info = {info} setInfo = {setInfo}/>
          <InputField label = "Security Code" className="two-wide right" info = {info} setInfo = {setInfo}/>

          <h4>Billing Address</h4>
          <InputField label = "Email" className="full" info = {info} setInfo = {setInfo}/>
          <InputField label = "First Name" className="two-wide left" info = {info} setInfo = {setInfo}/>
          <InputField label = "Last Name" className="two-wide right" info = {info} setInfo = {setInfo}/>

          <InputField label = "Address" className="full" info = {info} setInfo = {setInfo}/>
          
          <InputField label = "City" className="two-wide left" info = {info} setInfo = {setInfo}/>
          <InputField label = "Province/State" className="two-wide right" info = {info} setInfo = {setInfo}/>
          <InputField label = "Country" className="two-wide left" info = {info} setInfo = {setInfo}/>

          <InputField label = "Postal Code" className="two-wide right" info = {info} setInfo = {setInfo}/>
      </form>
      <button className='checkout-button' onClick={clicked}>Purchase</button>
      <button className='checkout-button' onClick={canceled}>Cancel</button>
    </div>
  )
}

function InputField(props) {

  let classes = 'field_input-wrapper ' + props.className

  const update = (x) => {
    let p = props.info
    p[props.label] = x
  }

  return (
		<div className={classes}>
      <label className='field-label'>{props.label}</label>
      <input className='field-input' onChange={(e) => {update(e.target.value)}}></input>
		</div>
	)
}


export default Checkout