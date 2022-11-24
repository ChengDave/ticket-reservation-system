import './TileGrid.css';
import React from 'react';

const TileGrid = (props) => {

	let labels = []
	let labels_temp = []

	for (let i = 0; i < props.items.length; i++) {
		labels_temp.push(<Tile label = {props.items[i]} count = {props.count} setCount = {props.setCount}/>)

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
		if (next_index > 4) return
		this.props.setCount(next_index)
	};

	render(){
		return (
			<React.Fragment>
				<div className="tile">
				<button className="tile" onClick={this.clicked}>{this.props.label}</button>
				</div>
			</React.Fragment>
		)
	}
}

export default TileGrid