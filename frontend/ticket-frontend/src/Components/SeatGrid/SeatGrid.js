import "./SeatGrid.css"
import React, { useState } from 'react'

const SeatGrid = (props) => {

	const [selection, setSelection] = useState([])

	let buttons = []

	let seats = new Array(168).fill(false)

	seats[10] = true
	seats[20] = true
	seats[33] = true
	seats[50] = true
	seats[100] = true
	
	for (let i = 1; i <= seats.length; i++) {
		buttons.push(<Button i = {i} selected = {seats[i]} selection = {selection} setSelection = {setSelection} key = {i}/>)
	}
	
	const selectSeats = () => {
		let p = props.params

		if (selection.length == 0) {
			alert("Must select at least one seat")
			return
		}

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

const Button = (props) => {

	const [available, setAvailable] = useState(props.selected ? "taken" : "available")

	const clicked = () => {
		if (available === "taken") return;
		
		setAvailable("selected")

		let selection = props.selection
		selection.push(props.i)
		props.setSelection(selection)
	}

	return (
		<button className={`seat-button ${available}`}
				onClick = {clicked}>
			{props.i}
		</button>
	)
}

export default SeatGrid;