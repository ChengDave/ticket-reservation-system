import Login from "../Login/Login"
import TabFrame from "../TabFrame/TabFrame"
import News from "../News/News"

const Display = (props) => {
	
	const getDisplay = () => {
		console.log(props.display)
		switch(props.display) {
			case "Tab":
				return <TabFrame></TabFrame>
			case "News":
				return <News></News>
			case "Login":
				return <Login></Login>
		}
		
	}
	
	return (
		getDisplay()
	)
}

export default Display