/**
 *  ocr.js
 */
 
 $(function(){
	// submit 했을 때
	$('#chatbotForm').on('submit', function(){
		event.preventDefault();
		$.ajax({
			type: 'post',
			url: 'chatbot',
			data: {"message": $('#message').val()},
			success: function(result){
				$('#chatBox').text(result);
			},
			error: function(){
				alert("전송 실패");
			}
		})
		$('#message').val('');
	});
});