function signUpgo() {
	location.href = "regController";
}

function logout() {
	let chk = confirm("로그아웃 하시겠습니까?");
	if (chk) {
		location.href = "LoginController";
	}
}

function memberInfoGo(){
	location.href ="MemberInfoController";
}