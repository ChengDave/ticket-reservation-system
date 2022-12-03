import './Checkout.css';
import React, {useState, useContext} from 'react';
import UserInformation from './UserInformation';
import {UserContext} from '../../UserContext';

function Checkout(props) {

  const [info, setInfo] = useState({})
  const [total, setTotal] = useState(0)
	const {user, setUser} = useContext(UserContext)

  const clicked = async () => {

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
    
    let userId = await fetch("http://localhost:8080/api/v1/users/email/" + info["Email"], {
      method: "GET",
      headers:{"Content-Type":"application/json"},
    })
    .then((response) => response.json())
		.then(data => {
      if (data.length > 0) {
        return data[0].id
      } else {
        return "none"
      }
    })
    .catch((e) => console.error(e))
    

    if (userId === "none") {

      let guestUser = {
        "firstName": info["First Name"],
        "creditCard": info["Card Number"],
        "lastName": info["Last Name"],
        "email": info["Email"],
        "isAdmin": false
      }

      await fetch("http://localhost:8080/api/v1/users/guestUser", {
      method: "POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(guestUser)
      })  
      .then((response) => response.json())
      .then((data) => {
        console.log(data)
      })          
      .catch((e) => console.error(e))
      
      userId = await fetch("http://localhost:8080/api/v1/users/email/" + info["Email"], {
        method: "GET",
        headers:{"Content-Type":"application/json"},
      })
      .then((response) => response.json())
      .then((data) => {
        if (data.length > 0) {
          return data[0].id
        } else {
           return "none"
        }
      })
      .catch((e) => console.error(e))

    }

    props.params.seats.forEach(seatid => {
      fetch("http://localhost:8080/api/v1/ticket/user/" + userId + "/seat/" + seatid, {
        method: "POST",
        headers:{"Content-Type":"application/json"},
      })
    });

    let payment = {
      "creditCardExpDate": info["Expiration Date"],
      "creditCardNo": parseInt(info["Card Number"]),
      "cvv": parseInt(info["Security Code"]),
      "id":null,
      "paymentAmount": parseInt(total),
      "paymentDate": null,
      "paymentTime": null,
      "userId": userId
    }

    console.log("pay")
    console.log(JSON.stringify(payment))

    await fetch("http://localhost:8080/api/v1/payment/", {
      method: "POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(payment)
    })
    .catch((e) => console.error(e))

    alert("Purchase Confirmed")

  }

  const canceled = () => {
    props.setCount(0)
    props.setParameters({movie: '', theater: "", showtime: "", seats: []})
  }

  return (
    <div className='division'>
      <Summary params = {props.params} setTotal = {setTotal}></Summary>

      <UserInformation info = {info} setInfo = {setInfo}/>
      
      <button className='checkout-button' onClick={clicked}>Purchase</button>
      <button className='checkout-button' onClick={canceled}>Cancel</button>
    </div>
  )
}

const Summary = (props) => {

  const numTickets = props.params.seats.length
  let value = props.params.price
  let gst = value * 0.05
  let total = value + gst

  props.setTotal(total)

  value = value.toFixed(2)
  gst = gst.toFixed(2)
  total = total.toFixed(2)
  
  return (
    <div>
      <h4>Order Summary</h4>
      <div>
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
              <td className='right-align'>{props.params.showtime.time}</td>
            </tr>
            <tr><td>&emsp;</td></tr>
            <tr>
              <td className='left'>Items: Ticket (x{numTickets})</td>
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
      </div>
    </div>
  )
}

export default Checkout