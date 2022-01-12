/**
 * prdNocheck.js
 	- 상품 번호 중복 확인
 */

 $(document).ready(function(){
	$('#prdNoCheckBtn').on('click', function(){
		event.preventDefault();
		
		var prdNo = $('#prdNo').val();

		$.ajax({
			type: 'post',
			url: 'prdNoCheck',
			data: {'prdNo': prdNo},
			success: function(result){
				if(result == "no_use")
					alert("사용할 수 없는 상품번호 입니다.");
				else
					alert("사용 가능한 상품번호 입니다.");
			},
			error:function(data, textStatus){
				alert("전송 실패");
			}
		});
	});
});