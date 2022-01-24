/**
 *  ocr.js
 */
 
 $(function(){
	$('.resultArea').hide();
	// submit 했을 때
	$('#ocrForm').on('submit', function(){
		event.preventDefault();
		let formData = new FormData($(this)[0]);
		
		// 업로드된 파일명 찾아오기
		let fileName = $('#uploadFile').val().split("\\").pop();
		// alert(fileName);
		
		$.ajax({
			type: 'post',
			enctype: 'multipart/form-data',
			url: 'clovaOCR',
			data: formData,
			processData: false,
			contentType: false,
			success: function(result){
				$('.resultArea').show();
				$('.resultText').text(result);
				// 이미지 출력 
				$('#image').empty(); // 이전 이미지 지우기
				$('#image').append('<img src="/images/'+fileName+'"/>');
			},
			error: function(){
				alert("전송 실패");
			}
		})
	});
	
});