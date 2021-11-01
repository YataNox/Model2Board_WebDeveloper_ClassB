/* 로그인 확인 function */
function loginCheck(){
	if(document.frm.userid.value.length==0){
		alert("아이디를 입력하세요.");
		document.frm.userid.focus();
		return false;
	}
	if(document.frm.userpwd.value.length==0){
		alert("비밀번호를 입력하세요.");
		document.frm.userpwd.focus();
		return false;
	}
	return true;
}

/* 중복체크 팝업 창 function */
function idCheck(){
	if(document.frm.userid.value == ""){
		alert("아이디를 입력해주세요.");
		document.from.userid.focus();
		return;
	}
	
	var inputid = document.frm.userid.value;
	var opt = "toolbar=no, menubar=no, scrollbar=yes, resizable=no, width=500, height=200";
	window.open("board.do?command=idcheck&userid=" + inputid, "idcheck", opt);
}

/* 회원가입 사항 체크 function */
function joinCheck(){
	if(document.frm.userid.value.length==0){
		alert("아이디는 필수 입력 사항입니다.");
		document.frm.userid.focus();
		return false;
	}
	if(document.frm.userid.value != document.frm.reid.value){
		alert("아이디 중복체크를 하지 않으셨습니다.");
		document.frm.userid.focus();
		return false;
	}
	if(document.frm.name.value.length==0){
		alert("이름은 필수 입력 사항입니다.");
		document.frm.name.focus();
		return false;
	}
	if(document.frm.userpwd.value.length==0){
		alert("비밀번호는 필수 입력 사항입니다.");
		document.frm.userpwd.focus();
		return false;
	}
	if(document.frm.userpwd.value != document.frm.userpwd_check.value){
		alert("비밀번호 확인이 일치하지 않습니다.");
		document.frm.userpwd_check.focus();
		return false;
	}
	return true;
}

/* 아이디 중복체크 시 작동할 기능 function */
function idok(userid){
	// 현재 팝업창의 아이디 입력란에 있는 아이디를 오프너의 아이디 입력란에 복사합니다.
	opener.document.frm.userid.value = userid;
	// 현재 팝업창의 아이디 입력란에 있는 아이디를 오프너의 reid의 value에 복사합니다.
	opener.document.frm.reid.value = userid;
	// 현재 팝업창은 스스로 닫습니다.
	self.close();
}

/* 회원 정보 수정 시 필수 입력사항 확인 function */
function editCheck(){
	if(document.frm.name.value==""){
		alert("이름은 필수 입력 사항입니다.");
		document.frm.name.focus();
		return false;
	}
	if(document.frm.userpwd.value==""){
		alert("비밀번호는 필수 입력 사항입니다.");
		document.frm.userpwd.focus();
		return false;
	}
	if(document.frm.userpwd.value != document.frm.userpwd_check.value){
		alert("비밀번호 확인이 일치하지 않습니다.");
		document.frm.userpwd_check.focus();
		return false;
	}
	alert("개인 정보 수정 완료");
	return true;
}

/* 게시물 작성시 필수 작성요소 확인 function */
function boardCheck(){
	if(document.frm.pass.value==""){
		alert("비밀번호는 수정/삭제시 필요합니다.");
		document.frm.pass.focus();
		return false;
	}
	if(document.frm.title.value==""){
		alert("제목은 필수 사항입니다.");
		document.frm.title.focus();
		return false;
	}
	if(document.frm.content.value == ""){
		alert("내용을 입력해주세요.");
		document.frm.content.focus();
		return false;
	}
	return true;
}

/* 게시물 수정/삭제 전 비밀번호 확인 팝업창 표시 function*/
function open_win(num, name){
	var url = "board.do?command=boardPassForm&num=" + num;
	var opt = "toolbar=no, menubar=no, scrollbar=yes, resizable=no, width=500, height=300";
	window.open(url, name, opt);
}

/*게시물 수정/삭제 비밀번호 확인 funtion*/
function passCheck(){
	if(document.frm.pass.value.length==0){
		alert("비밀번호를 입력하세요");
		document.frm.pass.focus();
		return false;
	}
	return true;
}