import './TileGrid.css';
import React, {useEffect, useState} from 'react';

const TileGrid = (props) => {

	const [movies, setMovies] = useState([])
	
	useEffect(() => {
		fetch("http://localhost:8080/api/vi/movies", {
			method: "GET",
			headers:{"Content-Type":"application/json"},
		})
		.then((response) => response.json())
		.then(data => {
			setMovies(data)
		})
		.catch((e) => {
			console.error(e)
		});
	}, [])

	let labels = []
	let labels_temp = []
	let j = 0;

	console.log("M2")
	console.log(movies[0])

	for (let i = 0; i < movies.length; i++) {
		labels_temp.push(<Tile label = {movies[i]} count = {props.count} setCount = {props.setCount} params = {props.params} setParams = {props.setParams} key = {i}/>)

		if (i % 4 === 3) {
			labels.push(<div className="table-row" key = {j}>{labels_temp}</div>)
			j++
			labels_temp = []
		}
	}
	
	labels.push(<div className="table-row" key = {j}>{labels_temp}</div>)

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

export default TileGrid