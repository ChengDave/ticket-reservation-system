import './NavBar.css';

import React, {useContext} from "react"
import { UserContext } from '../../UserContext';

const NavBar = (props) => {

	const {user, setUser} = useContext(UserContext)

	return (
		<header className='navbar'>
			<div className='navbar__title navbar__item' onClick={() => {props.setDisplay("Tab")}}>Ticket Registration App</div>
			<div className='navbar__item' onClick={() => {props.setDisplay("News")}}>News</div>
			{user === "none" ? (
				
				[<div key = {1} className='navbar__item' onClick={() => {props.setDisplay("Cancel")}}>Cancel Reservation</div>,
				<div key = {2}className='navbar__item' onClick={() => {props.setDisplay("Login")}}>Login</div>]
			):(
				[<div key = {1} className='navbar__item' onClick={() => {props.setDisplay("Profile")}}>Profile</div>,
				<div key = {2} className='navbar__item' onClick={() => {setUser("none"); props.setDisplay("Tab")}}>Logout</div> ]
			)}
		</header>
	)
};

export default NavBar