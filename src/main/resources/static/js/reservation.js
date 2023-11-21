function reservationYN(number, acceptYn){
	let form = document.getElementById("reservationForm");
	let no = document.getElementById("reserve_no");
	let accept = document.getElementById("accept");
	
	no.value = number;
	accept.value = acceptYn;
	
	form.submit();
	
}