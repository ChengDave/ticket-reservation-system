
// Method to fetch users
export const getTicketsByUserID = async (userId) => {
	// get tickets by user
	let response = await fetch("http://localhost:8080/api/v1/ticket/user/"+ userId, {})
	let tickets = await response.json()

	return tickets

}