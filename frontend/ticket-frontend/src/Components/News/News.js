import "./News.css"
import React from "react"

const News = () => {
	return (
		<div className="wrapper">
			<h1>Movie News</h1>
			<div>
				<NewsItem title = {"News Story 1"} story = {"Take your movie to the next level! Our enhanced experiences offer extra movie magic and keep every movie-lover buzzing long after the credits. From expansive screens to food and drinks delivered right to your seat, these movie upgrades are unlike anything else you’ve experienced. Take your movie to the next level! Our enhanced experiences offer extra movie magic and keep every movie-lover buzzing long after the credits. From expansive screens to food and drinks delivered right to your seat, these movie upgrades are unlike anything else you’ve experienced."}/>
				<NewsItem title = {"News Story 2"} story = {"Story 2 body"}/>
				<NewsItem title = {"News Story 3"} story = {"Story 3 body"}/>
				<NewsItem title = {"News Story 4"} story = {"Story 4 body"}/>
			</div>
		</div>

	)
}


const NewsItem = (props) => {
	return (
		<React.Fragment>
			<div className="news">
				<div className="story-border">
					<h2>{props.title}</h2>
					<p className="story">{props.story}</p>
				</div>
			</div>
			<br></br>
		</React.Fragment>
	)
}


export default News