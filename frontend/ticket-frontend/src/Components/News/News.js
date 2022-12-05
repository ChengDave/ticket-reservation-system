import "./News.css"
import React, {useEffect, useRef, useState, useContext} from 'react';
import {UserContext} from '../../UserContext';

// Component that shows the news tab onscreen
const News = () => {
	
	const {user, setUser} = useContext(UserContext)
	const [movies, setMovies] = useState([])
	const [registeredMovies, setRegisteredMovies] = useState([])
	
	
	useEffect(() => {

		fetch("http://localhost:8080/api/v1/movies/guest", {
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

		fetch("http://localhost:8080/api/v1/movies/registeredUser/exclusive", {
			method: "GET",
			headers:{"Content-Type":"application/json"},
		})
		.then((response) => response.json())
		.then(data => {
			setRegisteredMovies(data)
		})
		.catch((e) => {
			console.error(e)
		});

	}, [])

	let movieItems = []

	if (user !== "none") {

		movieItems.push(<h1>Pre-Release Movie News</h1>)

		registeredMovies.forEach((movie) => {
			movieItems.push(<NewsItem title = {movie.movieTitle} date = {movie.publicAnnouncement} story = {movie.news}/>)
		})
	}

	movieItems.push(<h1>Public Movie News</h1>)

	movies.forEach((movie) => {
		movieItems.push(<NewsItem title = {movie.movieTitle} date = {movie.publicAnnouncement} story = {movie.news}/>)
	})

	return (
		<div className="wrapper">
			
			<div>
				{movieItems}
			</div>
		</div>

	)
}

// Component for individual piece of movie news
const NewsItem = (props) => {

	
	let story = [<h3>{"Public Release Date: " + props.date.substring(0,10)}</h3>]

	if (props.story !== null) {
		props.story.split("\n").forEach((line) => {
			story.push(<p className="story">{line}</p>)
			story.push(<br></br>)
		})

	}

	return (
		<React.Fragment>
			<div className="news">
				<div className="story-border">
					<h2>{props.title}</h2>
					{story}
				</div>
			</div>
			<br></br>
		</React.Fragment>
	)
}


export default News