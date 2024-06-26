function appleRegCheck(){
	let lBox = document.appleRegForm.a_location;
	let pBox = document.appleRegForm.a_price;
	let iBox = document.appleRegForm.a_introduce;
	
	if(isEmpty(lBox)){
		alert("Please Fill in Location Properly");
		lBox.focus();
		return false;
	} else if (isEmpty(pBox) || isNotNumber(pBox)){
		alert("Plese Fill in Price Properly")
		pBox.value="";
		pBox.focus();
		return false;
	} else if (isEmpty(iBox) || atLeastLetter(iBox, 5)){
		alert("Plese Fill in Introduce Properly")
		iBox.value="";
		iBox.focus();
		return false;
	} 
	return true;
}