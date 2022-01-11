function validate(){
	let email = registrationForm.email.value;
	let password = registrationForm.password.value;
	
	if(email === "" || email === " "){
		alert("Preencha o campo email!")
		return false;
	}
	if(password === "" || password === " "){
		alert("Preencha o campo senha!")
		return false;
	}
	document.forms["registrationForm"].submit();
}