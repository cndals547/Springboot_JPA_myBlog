let index = {
	init : function(){
		$("#btn-save").on("click", ()=>{
				this.save();
		});
	},
	
	save: function(){
		//alert('user의 save함수 호출됨');
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}
		
		//console.log(data);
		$.ajax({
			type: "POST",
			url: "/auth/joinProc",
			data: JSON.stringify(data), //http body데이터
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp){
			alert("회원가입이 완료되었습니다.");
			location.href = "/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); //ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 isert요청!
	},
}

index.init();