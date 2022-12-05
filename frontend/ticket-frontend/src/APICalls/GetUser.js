
export const getUserByEmail = async (email) => {
	// get user by email
	let response = await fetch("http://localhost:8080/api/v1/users/email/"+ email, {})
	let user = await response.json()

	return user[0]
}

