
export const getTicketsByUserID = async (userId) => {
	
	let response = await fetch("http://localhost:8080/api/v1/ticket/user/"+ userId, {})
	let tickets = await response.json()

	return tickets

}