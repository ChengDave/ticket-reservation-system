import InputField from "./InputField"

const UserInformation = (props) => {
	return (
		<form>
          <h4>Credit Card Information</h4>
          <InputField label = "Card Number" className="full" info = {props.info} setInfo = {props.setInfo}/>
          <InputField label = "Name on Card" className="full" info = {props.info} setInfo = {props.setInfo}/>
          <InputField label = "Expiration Date" className="two-wide left" info = {props.info} setInfo = {props.setInfo}/>
          <InputField label = "Security Code" className="two-wide right" info = {props.info} setInfo = {props.setInfo}/>

          <h4>Billing Address</h4>
          <InputField label = "Email" className="full" info = {props.info} setInfo = {props.setInfo}/>
          <InputField label = "First Name" className="two-wide left" info = {props.info} setInfo = {props.setInfo}/>
          <InputField label = "Last Name" className="two-wide right" info = {props.info} setInfo = {props.setInfo}/>

          <InputField label = "Address" className="full" info = {props.info} setInfo = {props.setInfo}/>
          
          <InputField label = "City" className="two-wide left" info = {props.info} setInfo = {props.setInfo}/>
          <InputField label = "Province/State" className="two-wide right" info = {props.info} setInfo = {props.setInfo}/>
          <InputField label = "Country" className="two-wide left" info = {props.info} setInfo = {props.setInfo}/>

          <InputField label = "Postal Code" className="two-wide right" info = {props.info} setInfo = {props.setInfo}/>
      </form>
	)
}


export default UserInformation