import "./CancelTicket.css"
import React, {useEffect, useRef, useState} from "react";
import { getTicketsByUserID } from "../../APICalls/getTicketsByUserID";
import { getUserByEmail } from "../../APICalls/GetUser";


const CancelTicket = (props) => {

	const [tickets, setTickets] = useState([])
	const [ticketTiles, setTiles] = useState([])


	useEffect(() => {
		let tiles = []
		tickets.forEach(ticket => {
			let showtime = ticket.seat.showtime
			console.log(showtime)
			tiles.push(<div className='ticket-item'>
							<div className="left">
										<p>Theater: {showtime.theater.theaterTitle}</p>
										<p>Movie:    {showtime.movie.movieTitle}</p>
										<p>Time: {showtime.localDateTime.substring(11,16)}</p>
										<p>Seat: {ticket.seat.seatNumber}</p>
							</div>
							<div className="right">
								<button className='cancel-button'>Cancel</button>
							</div>
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

const Tile = () => {

	return (
		<React.Fragment>
			<div className="tile">
				{/* <img src={process.env.PUBLIC_URL + '/images/' + this.props.label.movieTitle.replace(/[^a-zA-Z0-9\s]/g, "") + ".jpeg"} alt={this.props.label.movieTitle + " Movie Poster"} onClick={this.clicked}></img> */}

				<button className = "b" ><u>{"TEST"}</u></button>
			</div>
		</React.Fragment>
	)
}


export default CancelTicket;