import './Checkout.css';
import React, { useState } from 'react';
import UserInformation from './UserInformation';

function Checkout(props) {

  const [info, setInfo] = useState({})
  // const [userId, setUserId] = useState("none")

  const numTickets = props.params.seats.length
  const ticketPrice = 19.99
  let value = ticketPrice * numTickets
  let gst = value * 0.05
  let total = value + gst

  value = value.toFixed(2)
  gst = gst.toFixed(2)
  total = total.toFixed(2)

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
    
    let today = new Date();
    let dd = String(today.getDate()).padStart(2, '0');
    let mm = String(today.getMonth() + 1).padStart(2, '0') + 1;
    let yyyy = today.getFullYear();
    
    let time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
    
    today = mm + '/' + dd + '/' + yyyy;

    // TODO: Check if I can delete times

    
    
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
      
      let userId = await fetch("http://localhost:8080/api/v1/users/email/" + info["Email"], {
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
      </div>

      <UserInformation info = {info} setInfo = {setInfo}/>
      
      <button className='checkout-button' onClick={clicked}>Purchase</button>
      <button className='checkout-button' onClick={canceled}>Cancel</button>
    </div>
  )
}

export default Checkout