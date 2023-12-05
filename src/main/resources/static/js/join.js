function joinHospital(){
	
	if(validatePassword()){
		document.getElementById("joinForm").submit();
	}

}

function validatePassword() {
  var passwd = document.getElementById("user_pw").value;
  var repeatPasswd = document.getElementById("user_pw_re").value;

  if (passwd != repeatPasswd) {
    alert("패스워드가 일치하지 않습니다.");
    return false;
  }

  return true;
}