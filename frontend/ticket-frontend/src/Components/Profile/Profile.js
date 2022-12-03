import "./profile.css"
import React, {useContext, useEffect, useState} from "react"
import { UserContext } from '../../UserContext';
import TicketList from "../CancelTicket/TicketList";
import { getTicketsByUserID } from "../../APICalls/getTicketsByUserID";

const Display = (props) => {

	const [userData, setUserData] = useState({firstName: '', lastName: "", credit: 0})
	const [tickets, setTickets] = useState([])
	const {user, setUser} = useContext(UserContext)

	useEffect(() => {

		const getUser = async (user) => {
			let respone = await fetch("http://localhost:8080/api/v1/users/ID/" + user, {})
			let userData = await respone.json()

			if (typeof userData !== 'undefined') {
				console.log(userData)
				setUserData(userData)
			}

			let tickets = await getTicketsByUserID(user)
			setTickets(tickets)
		} 
		
		getUser(user)

	}, [tickets.length])



	return (
		<div className="wrapper">
			<table className='user-table'>
				<tbody>
					<tr>
						<td className='left'>Name:</td>
						<td className='right-align'>{userData.firstName} {userData.lastName}</td>
					</tr>
					<tr>
						<td className='left'>Email:</td>
						<td className='right-align'>{userData.email}</td>
					</tr>
					<tr>
						<td className='left'>Account Credit:</td>
						<td className='right-align'>${userData.credit.toFixed(2)}</td>
					</tr>
					<tr>
						<td className='left'>Registered Since:</td>
						<td className='right-align'>{userData.registrationDate}</td>
					</tr>
					<tr>
						<td className='left'>Next Annual Fee Due:</td>
						<td className='right-align'>{userData.nextPaymentDue}</td>
					</tr>
				</tbody>
			</table>
			
			<p className='tickets'>
				Active Tickets:
			</p>
			<TicketList tickets = {tickets} setTickets = {setTickets}></TicketList>
		</div>
	)
}

export default Display