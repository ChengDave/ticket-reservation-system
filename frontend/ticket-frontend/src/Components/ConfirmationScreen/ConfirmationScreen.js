
const ConfirmationScreen = (props) => {

	console.log(props.params.payment)
	console.log(props.params.tickets)

	let ticketFrames = []

	props.params.tickets.forEach((ticket) => {
		let date = ticket.seat.showtime.localDateTime.split('T')
		ticketFrames.push(
			<div className='ticket-item'>
				<div className="left">
					<p>Theater: {ticket.seat.showtime.theater.theaterTitle}</p>
					<p>Movie:    {ticket.seat.showtime.movie.movieTitle}</p>
					<p>Date: {date[0]}</p>
					<p>Time: {date[1].substring(0,5)}</p>
					<p>Seat: {ticket.seat.seatNumber}</p>
				</div>
			</div>
		)
	})

	const confirm = () => {
		props.setCount(0)
		props.setParameter({movie: '', theater: "", showtime: "", seats: []})
	}

	return (
		<div className="wrapper">

			<p className='header'>
				Payment Successful:
			</p>

			<p className='header'>
				Payment Details:
			</p>
			<div className='ticket-item'>
				<p>Payment Date: {props.params.payment.date}</p>
				<p>Total Charged to Card: ${props.params.payment.amount.toFixed(2)}</p>
				<p>Total Using Credit: ${(props.params.total - props.params.payment.amount).toFixed(2)}</p>
			</div>

			<p className='header'>
				Tickets:
			</p>

			{ticketFrames}

			<br></br>
			<button className="cancel-button" onClick = {confirm}>Confirm</button>
		</div>
	)
}

export default ConfirmationScreen