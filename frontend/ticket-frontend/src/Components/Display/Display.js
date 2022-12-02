import Login from "../Login/Login"
import TabFrame from "../TabFrame/TabFrame"
import News from "../News/News"
import Register from "../Register/Register"
import CancelTicket from "../CancelTicket/CancelTicket"
import Profile from "../Profile/Profile"


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
			case "Cancel":
				return <CancelTicket></CancelTicket>
			case "Profile":
				return <Profile></Profile>
		}
		
	}
	
	return (
		getDisplay()
	)
}

export default Display