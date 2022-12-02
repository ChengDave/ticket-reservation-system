import React from "react";


const CancelTicket = () => {

	

	return (
		<div className="wrapper">
			<Tile></Tile>
		</div>
	)
		
}

const Tile = () => {

	return (
		<React.Fragment>
			<div className="tile">
				{/* <img src={process.env.PUBLIC_URL + '/images/' + this.props.label.movieTitle.replace(/[^a-zA-Z0-9\s]/g, "") + ".jpeg"} alt={this.props.label.movieTitle + " Movie Poster"} onClick={this.clicked}></img> */}
				<button className = "b" ><u>{"TEST"}</u></button>
			</div>
		</React.Fragment>
	)
}

export default CancelTicket;