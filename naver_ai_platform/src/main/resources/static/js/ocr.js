/**
 *  ocr.js
 */
 
 $(function(){
	$('.resultArea').hide();
	// submit 했을 때
	$('#ocrForm').on('submit', function(){
		event.preventDefault();
		let formData = new FormData($(this)[0]);
		$.ajax({
			type: 'post',
			enctype: 'multipart/form-data',
			url: 'clovaOCR',
			data: formData,
			processData: false,
			contentType: false,
			success: function(result){
				$('.resultArea').show();
				if(result == null){
					$('.resultText').text("없음");
				}else{
					$('.resultText').text(result);
				}
			},
			error: function(){
				alert("전송 실패");
			}
		})
	});
	
});