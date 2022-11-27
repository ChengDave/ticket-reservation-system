import './Login.css';
import React, {useState} from "react"

const Login = (props) => {

	const [username, setUsername] = useState("")
	const [password, setPassword] = useState("")

	const signIn = () => {
		console.log(username)
		console.log(password)
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
						<input className='login-input' onChange={(e) => setUsername(e.target.value)}></input>
					</div>
					<br></br>
					<div>
						<label className='login-label'>Password:</label>
						<input className='login-input'onChange={(e) => setPassword(e.target.value)} type="password"></input>
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