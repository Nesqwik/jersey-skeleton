function getUser(idCookie){
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/user",
		dataType : "json",
		data : JSON.stringify({
			"id" : idCookie
		}),
		success : function(data, textStatus, jqXHR) {
			console.log(data);
			$("#email").html(data.email);
			$("#pseudo").html(data.pseudo);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('postUser is connected error: ' + textStatus);
		}
	});
}