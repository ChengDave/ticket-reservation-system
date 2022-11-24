import './TabFrame.css';
import React, { useState, useEffect } from 'react';
import TileGrid from "../TileGrid/TileGrid"
import Checkout from "../Checkout/Checkout"

function TabFrame() {

	const [count, setCount] = useState(0);

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
						<TileGrid  count = {count} setCount = {setCount} items = {movies}/>
					</div>
				</Tab>
				<Tab label="Theater">
					<div>
						<TileGrid  count = {count} setCount = {setCount} items = {theaters}/>
					</div>
				</Tab>
				<Tab label="Showtime">
					<div>
						<TileGrid  count = {count} setCount = {setCount} items = {showtimes}/>
					</div>
				</Tab>
				<Tab label="Seat">
					<div>
						<TileGrid  count = {count} setCount = {setCount} items = {seats}/>
					</div>
				</Tab>
				<Tab label="Payment">
					<div>
						<Checkout/>
						<p>Tab 5 content</p>
					</div>
				</Tab>
			</Tabs>
		</div>
	)
}

class Tabs extends React.Component{
	

	state = {
		activeTab: this.props.children[0].props.label
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

	componentWillReceiveProps(nextProps) {
		console.log(nextProps.count)
		if (nextProps.count !== this.props.count)
			this.setState({activeTab: nextProps.children[nextProps.count].props.label});
			this.render()
	};


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