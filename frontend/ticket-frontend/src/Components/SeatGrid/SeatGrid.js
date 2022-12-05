import "./SeatGrid.css"
import React, { useState, useEffect } from 'react'


// Component to display a grid of seats
const SeatGrid = (props) => {

	const [selection, setSelection] = useState([])
	const [seats, setSeats] = useState([])

	useEffect(() => {
		fetch("http://localhost:8080/api/v1/seat/"+props.params.showtime.id,{})
		.then((response) => response.json())
		.then(async (json) => {

			let newSeats = []
			json.forEach(element => {
				newSeats.push({"taken": element.taken, "id": element.id, "number": element.seatNumber, "price": element.price})	
			});
			
			setSeats(newSeats)
		})
	}, [])

	let buttons = []
	
	seats.forEach((seat, index) => {
		buttons.push(<Button seat = {seat} selection = {selection} setSelection = {setSelection} key = {index}/>)
	})

	
	const selectSeats = () => {
		let p = props.params

		if (selection.length == 0) {
			alert("Must select at least one seat")
			return
		}

		let price = 0;

		seats.forEach(seat => {
			if (selection.includes(seat.id)){
				price += seat.price;
			}
		})
		
		p.price = price
		p.seats = selection
		props.setParams(p)

		const next_index = props.count + 1
		if (next_index > 3) return
		props.setCount(next_index)
	}


	return (
		<div>
			<div>
				<h2>Select one or more available seat below: &emsp;
				<button className="green-square">Available</button>
				<button className="seat-button blue-square">Taken</button>
				</h2>
			</div>
			<div className="seat-grid">
				{buttons}
				<br></br>
				<button className='checkout-button' onClick={selectSeats}>Confirm Selection</button>
			</div>
		</div>

	)
}

// Seat button that changes color when a user selects it
const Button = (props) => {

	const [available, setAvailable] = useState(props.seat.taken ? "taken" : "available")

	const clicked = () => {
		if (available === "taken") return;
		
		
		let selection = props.selection

		if (available === "selected") {
			let newSeats = []
			selection.forEach(element =>{
				if (element !== props.seat.id){
					newSeats.push(element)
				}
			})
			
			props.setSelection(newSeats)
			setAvailable("available")
		} else {
			setAvailable("selected")
			selection.push(props.seat.id)
			props.setSelection(selection)
		}
	}

	return (
		<button className={`seat-button ${available}`}
				onClick = {clicked}>
			{props.seat.number}
		</button>
	)
}

export default SeatGrid;