import './TileGrid.css';
import React from 'react';

class Tile extends React.Component{

	state = {
		test: 0
	}

	clicked = () => {
		const next_index = this.props.count + 1
		if (next_index > 3) return
		this.props.setCount(next_index)

		
		let p = this.props.params
		p.movie = this.props.label.movieTitle
		this.props.setParams(p)
	};

	render(){
		return (
			<React.Fragment>
				<div className="tile">
					<img src={process.env.PUBLIC_URL + '/images/' + this.props.label.movieTitle.replace(/[^a-zA-Z0-9\s]/g, "") + ".jpeg"} alt={this.props.label.movieTitle + " Movie Poster"} onClick={this.clicked}></img>
					<button className = "b" onClick={this.clicked}><u>{this.props.label.movieTitle}</u></button>
				</div>
			</React.Fragment>
		)
	}
}

export default Tile