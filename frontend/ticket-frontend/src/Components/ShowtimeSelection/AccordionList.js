import './AccordionList.css';
import React, {useState, useEffect} from "react";


const AccordionList = (props) => {
	
	const [times, setTimes] = useState([])

	useEffect(() => {
		fetch("http://localhost:8080/api/vi/showtime/MOVIE/"+props.params.movie, {
			method: "GET",
			headers:{"Content-Type":"application/json"},
		})
		.then((response) => response.json())
		.then(data => {
			
			let d2 = data.map(({["movie"]:m_data, ["theater"]: t_data, ["localDateTime"]: ti_data}) => ({["theater"]: t_data.theaterTitle, ['time']:ti_data}))
			console.log(d2)

			let time_temp = []
			d2.forEach((element) => {
				if (!(element.theater in time_temp)) {
					time_temp[element.theater] = {"name": element.theater, "times": []}
				}
				time_temp[element.theater].times.push(new Date(element.time))
			})
			setTimes(Object.values(time_temp))
		})
		.catch((e) => {
			console.error(e)
		});
	}, [])

	let labels = []
	let open = true

	times.forEach((theater, index) => {
		labels.push(
		<Accordion className = "wrapper" title = {theater.name} key = {index} open = {open}>
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


const Accordion = ({className, title, children, open}) => {

	const [isOpen, setOpen] = React.useState(open);
	
	return (
		<div className = {className}>
			<div>
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
	
	const timeFromUnix = (date, format) => {
		const hours = String(date.getHours())
		const minutes = String(date.getMinutes()).padStart(2, "0")

		if (!format)
			return hours + ":" + minutes

		if (hours <= 12) {
			return hours + ":" + minutes + " AM"
		}

		return hours-12 + ":" + minutes + " PM"

	}

	const dayFromUnix = (date) => {
		const year = String(date.getFullYear())
		const month = String(date.getMonth() + 1).padStart(2, "0") // Add 1 since JS returns 0-11
		const day = String(date.getDate()).padStart(2, "0")
		return year + "-" + month + "-" + day
	}

	const clicked = (time) => {

		const next_index = props.count + 1
		if (next_index > 3) return
		props.setCount(next_index)
		
		let p = props.params
		p.showtime = dayFromUnix(time) + " " + timeFromUnix(time, false)
		p.theater = theaterName
		props.setParams(p)
	};

	let buttons = {}

	times.forEach((time, index) => {

		let date = dayFromUnix(time)
		if (!(date in buttons)) {
			buttons[date] = []
		}
		buttons[date].push(<button className='time-button' onClick={() => clicked(time)} key = {index}>{timeFromUnix(time, true)}</button>)
	})

	let display = []

	for (const key in buttons) {
		display.push(
			<div key = {key}>
				<Accordion className = "inner-wrapper"  title = {key}>{buttons[key]}</Accordion>
				{/* <h4 className='time-button'>{key}</h4> */}
				{/* {buttons[key]} */}
			</div>
		)
	}

	console.log(buttons)
	return (
		<div>
			{display}
		</div>
	)
}

export default AccordionList
  