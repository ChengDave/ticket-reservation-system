import './Login.css';
import React, {useRef} from "react"

const Login = (props) => {

	const username = useRef()
	const password = useRef()

	const signIn = () => {

		let credentials = ""
		credentials += "/USERNAME/" + username.current.value
		credentials += "/PASSWORD/" + password.current.value

		fetch("http://localhost:8080/api/vi/users" + credentials, {
			method: "GET",
			headers:{"Content-Type":"application/json"},
		})
		.then((response) => {response.text()})
		.then(data => {
			console.log(data)
		})

	}

	const register = () => {
		props.setDisplay("Register")
	}

	return (
		<div className='login-border'>
			<div className='login-form'>
				<form>
					<div>
						<label className='login-label'>Username:</label>
						<input className='login-input' ref = {username}></input>
					</div>
					<br></br>
					<div>
						<label className='login-label'>Password:</label>
						<input className='login-input' ref = {password} type="password"></input>
					</div>
				</form>

				<br></br>
					<button className="signin-button" onClick={signIn}>Sign In</button>
					<button className="text-button" onClick={register}>Register for an Account</button>
				<br></br>
			</div>
		</div>
	)
}

export default Login