/**
 * 	idCheck.js
 */
 $(document).ready(function(){
	$('#idCheck').on('click', function(){
		event.preventDefault();
		
		$.ajax({
			type: 'post',
			url: 'idCheck',
			data: {'memId' : $('#memId').val()},
			dataType: 'text',
			success: function(result){
				if(result == "no_use"){
					alert("사용할 수 없는 아이디입니다.");
				}else{
					alert("사용 가능한 아이디입니다.");
				}
			},
			error: function(data, textStatus){
				alert("전송 실패");
			}
		});
	});
});
 