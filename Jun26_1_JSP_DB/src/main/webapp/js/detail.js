function goAppleDetail(loc){
	location.href="AppleDetailController?a_location="+loc;
}
function deleteApple(loc){
	let t = confirm(`${loc} 정말 지움?`);
	if(t){
		location.href="AppleDeleteController?a_location="+loc;
	}
}