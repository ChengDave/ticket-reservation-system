import './TabFrame.css';
import React, { useState, useEffect } from 'react';
import TileGrid from "../TileGrid/TileGrid"
import Checkout from "../Checkout/Checkout"
import AccordianList from "../AccordionList/AccordionList"
import SeatGrid from '../SeatGrid/SeatGrid';

function TabFrame() {

	const [count, setCount] = useState(0);
	const [parameters, setParameters] = useState({movie: '', theater: "", showtime: "", seats: []})

	let movies = []
	for (let i = 1; i <= 16; i++) {
		movies.push("Movie " + i)
	}

	let theaters = []
	for (let i = 1; i <= 1; i++) {
		theaters.push("Theater " + i)
	}

	let showtimes = []
	for (let i = 1; i <= 4; i++) {
		showtimes.push("Time " + i)
	}

	let seats = []
	for (let i = 1; i <= 100; i++) {
		seats.push("Seat " + i)
	}
	

	return (
		<div className="tabs">
			<Tabs count = {count} setCount = {setCount}>
				<Tab label="Movie">
					<div>
						<TileGrid count = {count} setCount = {setCount} items = {movies} params = {parameters} setParams = {setParameters}/>
					</div>
				</Tab>
				<Tab label="Showtime">
					<div>
						<AccordianList count = {count} setCount = {setCount} params = {parameters} setParams = {setParameters}></AccordianList>
					</div>
				</Tab>
				<Tab label="Seat">
					<div>
						<SeatGrid count = {count} setCount = {setCount} params = {parameters} setParams = {setParameters}></SeatGrid>
					</div>
				</Tab>
				<Tab label="Payment">
					<div>
						<Checkout count = {count} setCount = {setCount} params = {parameters} setParams = {setParameters}/>
					</div>
				</Tab>
			</Tabs>
		</div>
	)
}

class Tabs extends React.Component{
	

	state = {
		activeTab: this.props.children[this.props.count].props.label
	};

	nextTab = () => {
		const next_index = this.props.count + 1
		if (next_index > 4) return
		this.props.setCount(next_index)
	}

	lastTab = () => {
		const next_index = this.props.count -1
		if (next_index < 0) return
		this.props.setCount(next_index)
	}

	static getDerivedStateFromProps(nextProps, state) {
		state.activeTab = nextProps.children[nextProps.count].props.label
		console.log(state)
		return state
	}

	render(){
		let content;
		let buttons = [];
		return (
			<div>
				{React.Children.map(this.props.children, child =>{
					buttons.push(child.props.label)
					if (child.props.label === this.state.activeTab) content = child.props.children
				})}
				
				<TabButtons activeTab={this.state.activeTab} buttons={buttons} nextTab={this.nextTab} lastTab={this.lastTab}/>

				<div className="tab-content">{content}</div>
			</div>

		);
	}
}
  
const TabButtons = ({buttons, nextTab, lastTab, activeTab}) => {
	
	return(
		<div className="tab-buttons">
			{buttons.map(button =>{
				return <button key = {button} className={button === activeTab? 'active': ''}>{button}</button>
			})}
			<button className="back-button" onClick={lastTab}>⇐ Back</button>
		</div>
	)
}

const Tab = props => {
	return(
		<React.Fragment>
			{props.children}
		</React.Fragment>
	)
}


export default TabFrame