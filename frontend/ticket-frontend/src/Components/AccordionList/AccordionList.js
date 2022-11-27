import './AccordionList.css';
import React from "react";


const AccordionList = (props) => {
	
	let times = [
		{name: "Downtown Theater",
			times: ["10:00 AM", "12:00 PM", "1:00 PM", "2:30 PM", "5:00 PM", "6:00 PM", "7:00 PM", "7:30 PM", "8:00 PM", "9:00 PM", "10:00 PM"]},
		{name: "Uptown Theater",
			times: ["10:00 AM", "1:00 PM", "2:30 PM", "5:00 PM", "6:00 PM", "7:00 PM", "7:30 PM", "8:00 PM", "9:00 PM", "10:00 PM", "11:00 PM"]},
		{name: "North West Theater",
			times: ["12:00 PM", "1:00 PM", "2:30 PM", "5:00 PM", "6:00 PM", "7:00 PM", "7:30 PM", "8:00 PM", "9:00 PM", "10:00 PM", "11:00 PM"]},
	]

	let labels = []
	let open = true

	times.forEach((theater, index) => {
		labels.push(
		<Accordion title = {theater.name} key = {index} open = {open}>
			<Buttons props = {props} times = {theater.times} theaterName = {theater.name} key = {"button" + index}></Buttons>
		</Accordion>)
		open = false
	})

	return (
		<div>
			{labels}
		</div>
	);
};


const Accordion = ({title, children, open}) => {

	const [isOpen, setOpen] = React.useState(open);
	
	return (
		<div className="wrapper">
			<div className="accordion-wrapper">
				<div
					className={`accordion-title ${isOpen ? "open" : ""}`}
					onClick={() => setOpen(!isOpen)}
					>
					{title}
				</div>
				<div className={`accordion-item ${!isOpen ? "collapsed" : ""}`}>
					<div className="accordion-content">{children}</div>
				</div>
			</div>
		</div>
	);
};

const Buttons = ({props, times, theaterName}) => {
	
	const clicked = (time) => {

		const next_index = props.count + 1
		if (next_index > 3) return
		props.setCount(next_index)
		
		let p = props.params
		p.showtime = time
		p.theater = theaterName
		props.setParams(p)
	};

	let buttons = []

	times.forEach((time, index) => {
		buttons.push(<button className='time-button' onClick={() => clicked(time)} key = {index}>{time}</button>)
	})


	return (
		<div>
			{buttons}
		</div>
	)
}

export default AccordionList
  