import "./profile.css"
import React, {useContext, useEffect, useState} from "react"
import { UserContext } from '../../UserContext';

const Display = (props) => {

	const [userData, setUserData] = useState({firstName: '', lastName: ""})
	const {user, setUser} = useContext(UserContext)

	useEffect(() => {
		fetch("http://localhost:8080/api/v1/users/ID/" + user, {
			method: "GET",
			headers:{"Content-Type":"application/json"},
		})
		.then((response) => response.json())
		.then(data => {
			console.log(data)
			if (typeof data !== 'undefined') {
				let d = {firstName: data["firstName"], lastName: data["lastName"], email: data["email"]}
				setUserData(d)
			}
		})
		.catch((e) => console.error("Error " + e))
	}, [])


	// console.log(userObject)
	// console.log(userData)

	return (
		<div className="wrapper">
			<table className='user-table'>
				<tbody>
					<tr>
						<td className='left'>Name:</td>
						<td className='right-align'>{userData['firstName']} {userData['lastName']}</td>
					</tr>
					<tr>
						<td className='left'>Email:</td>
						<td className='right-align'>{userData['email']}</td>
					</tr>
					<tr>
						<td className='left'>Registered Since:</td>
						<td className='right-align'>{"Need to get this data"}</td>
					</tr>
					<tr>
						<td className='left'>Next Annual Fee:</td>
						<td className='right-align'>{"Need to get this data"}</td>
					</tr>
					<tr>
						<td className='left'>Tickets:</td>
						<td className='right-align'>{"Need to get this data"}</td>
					</tr>
				</tbody>
			</table>
		</div>
	)
}

export default Display