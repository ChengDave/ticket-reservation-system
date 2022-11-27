import './NavBar.css';

const NavBar = (props) => (
	<header className='navbar'>
		<div className='navbar__title navbar__item' onClick={() => {props.setDisplay("Tab")}}>Ticket Registration App</div>
		<div className='navbar__item' onClick={() => {props.setDisplay("News")}}>News</div>        
		<div className='navbar__item' onClick={() => {props.setDisplay("Login")}}>Login</div>        
	</header>
);

export default NavBar