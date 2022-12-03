import "./CancelTicket.css"
import React, {useEffect, useRef, useState} from "react";
import { getTicketsByUserID } from "../../APICalls/getTicketsByUserID";
import { getUserByEmail } from "../../APICalls/GetUser";
import TicketList from "./TicketList";

const CancelTicket = (props) => {
	
	const [tickets, setTickets] = useState([])

	return (
		<div className="wrapper">
			<EnterEmail setTickets = {setTickets}></EnterEmail>
			<TicketList tickets = {tickets} setTickets = {setTickets}></TicketList>
		</div>
	)

}

const EnterEmail = (props) => {

	const email = useRef()

	const handleKeyDown = async (event) => {
		if (event.key !== 'Enter') {
			return
		}

		let user = await getUserByEmail(email.current.value)
		let tickets = await getTicketsByUserID(user.id)

		props.setTickets(tickets)
	  }


	return (
		<div className='email'>
			<div className='login-form'>
					<div>
						<label className='login-label'>Enter Email Linked To Tickets</label>
						<input className='login-input' ref = {email} onKeyDown={handleKeyDown}></input>
					</div>
			</div>
		</div>
	)
}

export default CancelTicket;