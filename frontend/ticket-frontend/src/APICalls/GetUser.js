
// method to fetch user by email
export const getUserByEmail = async (email) => {
	
	let response = await fetch("http://localhost:8080/api/v1/users/email/"+ email, {})
	let user = await response.json()

	return user[0]
}

