import UserInformation from "../Checkout/UserInformation"
import InputField from "../Checkout/InputField"
import React, {useState} from "react"

const Register = () => {

	const [info, setInfo] = useState({})

	const clicked = () => {
		console.log(info)
	}

	return (
		<div className="wrapper">
			<h4>Credentials</h4>
			<InputField label = "Username" className="full" info = {info} setInfo = {setInfo}/>
			<InputField label = "Password" className="two-wide left" info = {info} setInfo = {setInfo}/>
			<InputField label = "Confirm Password" className="two-wide right" info = {info} setInfo = {setInfo}/>

			<br></br>
			<UserInformation info = {info} setInfo = {setInfo}/>
			<button className='checkout-button' onClick={clicked}>Register</button>
		</div>
	)
}

export default Register