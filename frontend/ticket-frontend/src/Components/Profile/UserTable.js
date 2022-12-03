
const UserTable = (props) => {
	return (
		<div>
			<p className='header'>
				Profile:
			</p>
			<table className='user-table'>

				<tbody>
					<tr>
						<td className='left'>Name:</td>
						<td className='right-align'>{props.userData.firstName} {props.userData.lastName}</td>
					</tr>
					<tr>
						<td className='left'>Email:</td>
						<td className='right-align'>{props.userData.email}</td>
					</tr>
					<tr>
						<td className='left'>Account Credit:</td>
						<td className='right-align'>${props.userData.credit.toFixed(2)}</td>
					</tr>
					<tr>
						<td className='left'>Registered Since:</td>
						<td className='right-align'>{props.userData.registrationDate}</td>
					</tr>
					<tr>
						<td className='left'>Next Annual Fee Due:</td>
						<td className='right-align'>{props.userData.nextPaymentDue}</td>
					</tr>
				</tbody>
			</table>
		</div>)
}

export default UserTable