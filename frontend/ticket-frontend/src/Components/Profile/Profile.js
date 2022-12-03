import "./profile.css"
import React, {useContext, useEffect, useState} from "react"
import { UserContext } from '../../UserContext';
import TicketList from "../CancelTicket/TicketList";
import { getTicketsByUserID } from "../../APICalls/getTicketsByUserID";
import UserTable from "./UserTable";

const Display = (props) => {

	const [userData, setUserData] = useState({firstName: '', lastName: "", credit: 0})
	const [tickets, setTickets] = useState([])
	const {user, setUser} = useContext(UserContext)

	useEffect(() => {

		const getUser = async (user) => {
			let respone = await fetch("http://localhost:8080/api/v1/users/ID/" + user, {})
			let userData = await respone.json()

			if (typeof userData !== 'undefined') {
				setUserData(userData)
			}

			let newTickets = await getTicketsByUserID(user)
			setTickets(newTickets)
		} 
		
		getUser(user)

	}, [tickets.length])

	if (new Date(userData.nextPaymentDue) < new Date()) {

		props.setDisplay("Fee")

		return (
			<div></div>
		)
	}

	return (
		<div className="wrapper">

			<UserTable userData = {userData}/>

			<p className='header'>
				Active Tickets:
			</p>
			<TicketList tickets = {tickets} setTickets = {setTickets}></TicketList>
		</div>
	)
}

export default Display