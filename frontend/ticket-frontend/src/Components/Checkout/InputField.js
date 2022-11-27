
const InputField = (props) => {

	let classes = 'field_input-wrapper ' + props.className
  
	const update = (x) => {
	  let p = props.info
	  p[props.label] = x
	}
  
	return (
		  <div className={classes}>
		<label className='field-label'>{props.label}</label>
		<input className='field-input' onChange={(e) => {update(e.target.value)}}></input>
		  </div>
	  )
}

export default InputField