/**
 * chatbot.js
 */
 
 $(function(){
	$('#chatbotForm').on('submit', function(event){
		event.preventDefault();
		
		/* chatBox에 보낸 메시지 추가 */
		if($('#message').val() != ""){
			$('#chatBox').append('<div class="msgBox send"><span id="in"><span>' + 
									$('#message').val() + '</span></span></div><br>');
		}
		
		$.ajax({
			url:"chatbot",
			type:"post",
			data:{message: $('#message').val()},		
			success:function(result){				
				/* chatBox에 받은 메시지 추가 */
				$('#chatBox').append('<div class="msgBox receive"><span id="in"><span>챗봇</span><br><span>' + 
									   result +'</span></span></div><br><br>'); 								   
				// 스크롤해서 올리기										   
				$("#chatBox").scrollTop($("#chatBox").prop("scrollHeight"));			
			},
			error:function(){
				alert("오류가 발생했습니다.")
			}
		});
		
		/* 입력란 비우기*/
		$('#message').val('');
	});		
});