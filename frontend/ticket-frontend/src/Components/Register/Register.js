import UserInformation from "../Checkout/UserInformation"
import InputField from "../Checkout/InputField"
import React, {useState, useContext} from "react"
import { UserContext } from '../../UserContext';

const Register = (props) => {

	const [info, setInfo] = useState({})
	const {user, setUser} = useContext(UserContext)

	const clicked = async () => {

		if (info["Password"] !== info["Confirm Password"]){
			alert("Passwords much match")
			return
		}

		let start = info["Card Number"].substring(0,1)

		if (start !== "3" && start !== "4" && start !== "5") {
			alert("Enter a valid card number")
			return
		}

		let user = {
			"firstName": info["First Name"],
			"creditCard": info["Card Number"],
			"lastName": info["Last Name"],
			"email": info["Email"],
			"password": info["Password"],
			"isAdmin": false,
			"ticketNo": "",
			"receiptNo": "",
			"creditCardNumber": info["Card Number"],
			"nameOnCard": info["Name on Card"],
			"cardExpirationDate": info["Expiration Date"],
			"cardCVV": info["Security Code"],
			"isRegistered": true,
			"address": info["Address"],
			"city": info["City"],
			"province": info["Province/State"],
			"country": info["Country"],
			"postal": info["Postal Code"]
		}

		// Create User
		let response = await fetch("http://localhost:8080/api/v1/users/registeredUser", {
			method: "POST",
			headers:{"Content-Type":"application/json"},
			body: JSON.stringify(user)
		})

		if (!response.ok) {
			alert("Email Already Taken")
			return
		}

		// Log User In
		let credentials = ""
		credentials += "/USERNAME/" + info["Email"]
		credentials += "/PASSWORD/" + info["Password"]

		fetch("http://localhost:8080/api/v1/users" + credentials, {
			method: "GET",
			headers:{"Content-Type":"application/json"},
		})
		.then((response) => response.json())
		.then(data => {
			setUser(data["id"])
			props.setDisplay("Profile")
		})
		.catch(() => {
			alert("Invalid Username/Password Combination")
			setUser("none")
		})
	}

	return (
		<div className="wrapper">
			<h4>Credentials</h4>
			{/* <InputField label = "Username" className="full" info = {info} setInfo = {setInfo}/> */}
			<InputField label = "Password" className="two-wide left" info = {info} setInfo = {setInfo}/>
			<InputField label = "Confirm Password" className="two-wide right" info = {info} setInfo = {setInfo}/>

			<br></br>
			<UserInformation info = {info} setInfo = {setInfo}/>
			<button className='checkout-button' onClick={clicked}>Register</button>
		</div>
	)
}

export default Register