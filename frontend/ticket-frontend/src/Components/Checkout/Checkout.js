import './Checkout.css';
import React, {useState, useContext, useEffect} from 'react';
import UserInformation from './UserInformation';
import {UserContext} from '../../UserContext';

function Checkout(props) {

  const [info, setInfo] = useState({})
	const {user, setUser} = useContext(UserContext)


  const clicked = async () => {

    if (!checkValidInputs(info)) {
      alert("Missing Required Entries")
      return
    }
    
    //Get registered user or guest user
    let userId = user

    if (userId == "none"){
      userId = await getGuestUser(info)
    }


    
    let totals = getTotals(props.params)

    // Setup the payment data
    let payment = {
      "creditCardExpDate": info["Expiration Date"],
      "creditCardNo": parseInt(info["Card Number"]),
      "cvv": parseInt(info["Security Code"]),
      "id":null,
      "paymentAmount": totals["total"],
      "paymentDate": null,
      "paymentTime": null,
      "userId": userId
    }

    // Post the payment
    let response = await fetch("http://localhost:8080/api/v1/payment/", {
      method: "POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(payment)
    })
    .catch((e) => console.error(e))

    if (response.status !== 200) {
      alert("Purchase Failed")
      return
    }

    let paymentResponse = await response.json()

    let responses = []
    let tickets = []

    // Make a ticket for each selected seat

    for (let i = 0; i < props.params.seats.length; i++) {
      let response = await fetch("http://localhost:8080/api/v1/ticket/user/" + userId + "/seat/" + props.params.seats[i], {
        method: "POST",
        headers:{"Content-Type":"application/json"},
      })

      let ticket = await response.json()
      tickets.push(ticket)

    }

    props.params.payment = paymentResponse
    props.params.tickets = tickets
    props.params.total = totals["total"]
    props.setCount(props.count + 1)
    
  }

  const canceled = () => {
    props.setCount(0)
    props.setParameters({movie: '', theater: "", showtime: "", seats: []})
  }

  useEffect(() => {

    const fetchData = async (userId) => {

      let response = await fetch("http://localhost:8080/api/v1/users/ID/" + userId, {
        method: "GET",
        headers:{"Content-Type":"application/json"},
      })
    
      let userInfo = await response.json()

      let newInfo = {
        "Card Number": userInfo.creditCard,
        "Email": userInfo.email,
        "Name on Card": userInfo.nameOnCard,
        "Expiration Date": userInfo.cardExpirationDate,
        "First Name": userInfo.firstName,
        "Last Name": userInfo.lastName,
        "Security Code": userInfo.cardCVV,
        "Address": userInfo.address,
        "City": userInfo.city,
        "Province/State": userInfo.province,
        "Country": userInfo.country,
        "Postal Code": userInfo.postal
      }

      setInfo(newInfo)

    }
    
    if (user !== "none")
      fetchData(user);

  }, [])

  return (
    <div className='division'>
      <Summary params = {props.params}></Summary>

      <UserInformation info = {info} setInfo = {setInfo}/>
      
      <button className='checkout-button' onClick={clicked}>Purchase</button>
      <button className='checkout-button' onClick={canceled}>Cancel</button>
    </div>
  )
}

const getTotals = (params) => {

  let value = params.price
  let gst = value * 0.05
  let total = value + gst

  value = value.toFixed(2)
  gst = gst.toFixed(2)
  total = total.toFixed(2)

  return {"value": value, "gst":gst, "total": total}
}

const Summary = (props) => {
  let numTickets = props.params.seats.length
  const totals = getTotals(props.params)

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
              <td className='right-align'>${totals["value"]}</td>
            </tr>
            <tr className="underlined">
              <td className='left'>GST:</td><td className='right-align'>${totals["gst"]}</td>
            </tr>
            <tr>
              <td className='left'>Total:</td><td className='right-align'>${totals["total"]}</td>
            </tr>
          </tbody>
        </table>
        </div>
      </div>
    </div>
  )
}

const getGuestUser = async(info) => {

  // Check if this email is already registered to a guest user
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
    userId = createGuestUser(info)
  }

  return userId
}

const createGuestUser = async (info) => {

  // Load properties to store for a guest user
  let guestUser = {
    "firstName": info["First Name"],
    "creditCard": info["Card Number"],
    "lastName": info["Last Name"],
    "email": info["Email"],
    "isAdmin": false
  }

  // Make the new guest user
  await fetch("http://localhost:8080/api/v1/users/guestUser", {
  method: "POST",
  headers:{"Content-Type":"application/json"},
  body:JSON.stringify(guestUser)
  })
  .catch((e) => {console.error(e)})

  return getGuestUser(info)

}

const checkValidInputs = (info) => {
  
  let valid = true

  // Not all feilds filled
  if (Object.keys(info).length !== 12) {
    valid = false
  }

  // Not all feilds have a value in them
  for (let key of Object.keys(info)) {
    if (info[key] == "") {
      valid = false
      break
    }
  }

  return valid
}

export default Checkout