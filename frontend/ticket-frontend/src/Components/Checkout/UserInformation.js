import InputField from "./InputField"

const UserInformation = (props) => {
    console.log("HEre")
    console.log(props.info)
	return (
		<form>
          <h4>Credit Card Information</h4>
          <InputField label = "Card Number" className="full" info = {props.info} setInfo = {props.setInfo}>{props.info["Card Number"]}</InputField>
          <InputField label = "Name on Card" className="full" info = {props.info} setInfo = {props.setInfo}></InputField>
          <InputField label = "Expiration Date" className="two-wide left" info = {props.info} setInfo = {props.setInfo}>{props.info["Expiration Date"]}</InputField>
          <InputField label = "Security Code" className="two-wide right" info = {props.info} setInfo = {props.setInfo}>{props.info["Security Code"]}</InputField>

          <h4>Billing Address</h4>
          <InputField label = "Email" className="full" info = {props.info} setInfo = {props.setInfo}>{props.info["Email"]}</InputField>
          <InputField label = "First Name" className="two-wide left" info = {props.info} setInfo = {props.setInfo}>{props.info["First Name"]}</InputField>
          <InputField label = "Last Name" className="two-wide right" info = {props.info} setInfo = {props.setInfo}>{props.info["Last Name"]}</InputField>

          <InputField label = "Address" className="full" info = {props.info} setInfo = {props.setInfo}></InputField>
          
          <InputField label = "City" className="two-wide left" info = {props.info} setInfo = {props.setInfo}></InputField>
          <InputField label = "Province/State" className="two-wide right" info = {props.info} setInfo = {props.setInfo}></InputField>
          <InputField label = "Country" className="two-wide left" info = {props.info} setInfo = {props.setInfo}></InputField>
          <InputField label = "Postal Code" className="two-wide right" info = {props.info} setInfo = {props.setInfo}></InputField>
      </form>
	)
}


export default UserInformation