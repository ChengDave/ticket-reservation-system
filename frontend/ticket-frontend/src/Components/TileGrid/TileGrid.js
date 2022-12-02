import './TileGrid.css';
import React, {useEffect, useRef, useState} from 'react';
import Tile from "./Tile"


const TileGrid = (props) => {

	const [movies, setMovies] = useState([])
	const [searchValue, setSearchValue] = useState("")
	const searchParameter = useRef("")
	
	useEffect(() => {
		fetch("http://localhost:8080/api/vi/movies", {
			method: "GET",
			headers:{"Content-Type":"application/json"},
		})
		.then((response) => response.json())
		.then(data => {
			setMovies(filterList(data))
			console.log("test")
		})
		.catch((e) => {
			console.error(e)
		});
	}, [searchValue])

	let labels = []
	let labels_temp = []
	let j = 0;

	const filterList = (movieList) => {

		if (searchValue === "")
			return movieList

		let newMovies = []
		movieList.forEach(movie => {
			const title = movie["movieTitle"]
			if (title.substring(0, searchValue.length).toLowerCase() === searchValue.toLowerCase()) {
				newMovies.push(movie)
			}
		})

		return newMovies;
	}

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
		<div>
			<Search search = {setSearchValue}></Search>
			<p>{searchParameter.current.value}</p>
			<div className="table">
				{labels}
			</div>
		</div>
	)
}

const Search = (props) => {

	return (
		<div className='wrapper'>
			<div className='search-outline'>
				<input className='movie-search' 
				onChange={(e) => {props.search(e.target.value)}}
				></input>
				<button className='search-button'>🔍</button>
			</div>
		</div>
	)
  
};


export default TileGrid