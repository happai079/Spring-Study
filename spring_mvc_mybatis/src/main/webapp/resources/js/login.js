/**
 * login.js
 */
 
 $(function(){
	$('#frmLogin').on('submit', function(){
		event.preventDefault();
		
		let userId = $('#user_id').val();	
		let userPw = $('#user_pw').val();
		
		$.ajax({
			type: "post",
			url: "login",
			data: {"id": userId, "pw": userPw}, /* 컨트롤러에서 받을 때 id, pw로 받음 */
			dataType: 'text',
			success: function(result){
				if(result == "success")
					message = "로그인 성공";
				else
					message = "로그인 실패";
					
				alert(message);
			},
			error: function(data, textStatus){
				alert("전송 실패");
			},
			complete:function(data, textStatus){
				alert("작업을 완료했습니다.");
			}
		});	
	});
});