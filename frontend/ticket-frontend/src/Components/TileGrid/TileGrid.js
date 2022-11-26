import './TileGrid.css';
import React from 'react';

const TileGrid = (props) => {


	let movies = [
		{name: "Avatar: The Way of Water", image: "Avatar.jpeg"},
		{name: "Black Adam", image: "BlackAdam.jpeg"},
		{name: "Black Panther: Wakanda Forever", image: "BlackPanther.jpeg"},
		{name: "Bones and All", image: "BonesAndAll.jpeg"},
		{name: "Devotion", image: "Devotion.jpeg"},
		{name: "Glass Onion: A Knives Out Mystery", image: "GlassOnion.jpeg"},
		{name: "Guillermo Del Toro's Pinocchio", image: "GuillermoDelTorosPinocchio.jpeg"},
		{name: "I Wanna Dance With Somebody", image: "IWannaDanceWithSomebody.jpeg"},
		{name: "Puss In Boots: The Last Wish", image: "PussInBoots.jpeg"},
		{name: "She Said", image: "SheSaid.jpeg"},
		{name: "Strange World", image: "StrangeWorld.jpeg"},
		{name: "The Banshee Of Inisherin", image: "TheBansheeOfInisherin.jpeg"},
		{name: "The Fabelmans", image: "TheFabelmans.jpeg"},
		{name: "The Menu", image: "TheMenu.jpeg"},
		{name: "Ticket to Paradise", image: "TicketToParadise.jpeg"},
		{name: "Violent Night", image: "ViolentNight.jpeg"},
	]

	let labels = []
	let labels_temp = []

	for (let i = 0; i < props.items.length; i++) {
		labels_temp.push(<Tile label = {movies[i]} count = {props.count} setCount = {props.setCount} params = {props.params} setParams = {props.setParams}/>)

		if (i % 4 === 3) {
			labels.push(<div className="table-row">{labels_temp}</div>)
			labels_temp = []
		}
	}
	
	labels.push(<div className="table-row">{labels_temp}</div>)

	return(
			<div className="table">
				{labels}
			</div>
	)
}

class Tile extends React.Component{

	state = {
		test: 0
	}

	clicked = () => {
		const next_index = this.props.count + 1
		if (next_index > 3) return
		this.props.setCount(next_index)

		
		let p = this.props.params
		p.movie = this.props.label.name
		this.props.setParams(p)
	};

	render(){
		return (
			<React.Fragment>
				<div className="tile">
					<img src={process.env.PUBLIC_URL + '/images/' + this.props.label.image} alt={this.props.label.name + " Movie Poster"} onClick={this.clicked}></img>
					<button className = "b" onClick={this.clicked}><u>{this.props.label.name}</u></button>
				</div>
			</React.Fragment>
		)
	}
}

export default TileGrid