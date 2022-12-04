import React, {useEffect, useState} from "react";
import { getTicketsByUserID } from "../../APICalls/getTicketsByUserID";

const TicketList = (props) => {

	const [ticketTiles, setTiles] = useState([])

	const cancel = async (user, seat) => {

		let result = window.confirm("Are you sure you want to Cancel this ticket?")
      	if (!result)
			return;

		//cancel the ticket
		await fetch("http://localhost:8080/api/v1/ticket/user/" + user + "/seat/" + seat.id, {
			method: "DELETE",
			mode:'cors',
			headers:{'Access-Control-Allow-Origin': '*'},
		}).catch((e) => console.error(e))


		// Credit the user
		await fetch("http://localhost:8080/api/v1/payment/refund/" + user + "/amount/" + seat.price * 1.05, {
			method: "POST",
			mode:'cors',
			headers:{'Access-Control-Allow-Origin': '*'},
		}).catch((e) => console.error(e))

		
		let newTickets = await getTicketsByUserID(user).catch((e) => console.error(e))
		props.setTickets(newTickets)

	}

	useEffect(() => {
		let tiles = []
		props.tickets.forEach(ticket => {
			let showtime = ticket.seat.showtime
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
								<button className='cancel-button' onClick={() => cancel(ticket.user.id, ticket.seat)}>Cancel</button>
							</div>
							:
							<div className="right"><p className='cancel-button'>Cannot Cancel<br></br>Tickets within {minDays}<br></br>days of showing</p></div>
							}
							</div>)
		})
		setTiles(tiles)
	}, [props.tickets])

	return (
		<div className="wrapper">
			{ticketTiles}
		</div>
	)
}

export default TicketList