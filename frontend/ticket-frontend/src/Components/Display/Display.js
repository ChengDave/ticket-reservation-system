import Login from "../Login/Login"
import TabFrame from "../TabFrame/TabFrame"
import News from "../News/News"
import Register from "../Register/Register"

const Display = (props) => {
	
	const getDisplay = () => {
		switch(props.display) {
			case "Tab":
				return <TabFrame></TabFrame>
			case "News":
				return <News></News>
			case "Login":
				return <Login setDisplay = {props.setDisplay}></Login>
			case "Register":
				return <Register></Register>
		}
		
	}
	
	return (
		getDisplay()
	)
}

export default Display