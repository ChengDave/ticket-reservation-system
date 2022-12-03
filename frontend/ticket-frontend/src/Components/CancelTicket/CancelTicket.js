import "./CancelTicket.css"
import React, {useEffect, useRef, useState} from "react";
import { getTicketsByUserID } from "../../APICalls/getTicketsByUserID";
import { getUserByEmail } from "../../APICalls/GetUser";


const CancelTicket = (props) => {

	const [tickets, setTickets] = useState([])
	const [ticketTiles, setTiles] = useState([])

	const cancel = async (user, seat) => {

		await fetch("http://localhost:8080/api/v1/ticket/user/" + user + "/seat/" + seat, {
			method: "DELETE",
			mode:'cors',
			headers:{'Access-Control-Allow-Origin': '*'},
		}).catch((e) => console.error(e))

		let newTickets = await getTicketsByUserID(user).catch((e) => console.error(e))
		setTickets(newTickets)

	}

	useEffect(() => {
		let tiles = []
		tickets.forEach(ticket => {
			let showtime = ticket.seat.showtime
			console.log(ticket)

			let date = showtime.localDateTime.split('T')

			let daysAway = (new Date(showtime.localDateTime) - new Date()) / 86400000
			let minDays = 3

			tiles.push(<div className='ticket-item'>
							<div className="left">
										<p>Theater: {showtime.theater.theaterTitle}</p>
										<p>Movie:    {showtime.movie.movieTitle}</p>
										<p>Date: {date[0]}</p>
										<p>Time: {date[1].substring(0,5)}</p>
										<p>Seat: {ticket.seat.seatNumber}</p>
							</div>
							{daysAway >  minDays ? 
							<div className="right">
								<button className='cancel-button' onClick={() => cancel(ticket.user.id, ticket.seat.id)}>Cancel</button>
							</div>
							:
							<div className="right"><p className='cancel-button'>Cannot Cancel<br></br>Tickets within {minDays}<br></br>days of showing</p></div>
							}
							</div>)
		})
		setTiles(tiles)
	}, [tickets])

	return (
		<div className="wrapper">
			<EnterEmail setTickets = {setTickets}></EnterEmail>
			{ticketTiles}
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