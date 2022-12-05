import React, {useContext, useEffect, useState} from "react"
import { UserContext } from '../../UserContext';
import UserTable from "./UserTable";


// Page that displays when a user has to pay for their registration fee
const FeePayment = (props) => {
	
	const {user, setUser} = useContext(UserContext)

	const payFee = async () => {
		await fetch("http://localhost:8080/api/v1/payment/userfee/user/" + user, {
			method: "POST",
			headers:{"Content-Type":"application/json"}
		})
		props.setDisplay("Profile")
	}

	return (
		<div className="background">
			
			<div className="user-table fit-width red">
				<h1>
					!!!! ISSUE !!!!
				</h1>
				<div>
					<p className="centered">Annual registration Fee of $20 is due. This must be paid before continuing</p>
					<button className='profile-button' onClick={payFee}>Charge Card On File</button>
					<button className='profile-button' onClick={() => {setUser("none"); props.setDisplay("Tab")}}>Logout</button>
				</div>
			</div>
		</div>
	)

}


export default FeePayment