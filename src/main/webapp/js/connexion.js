function connect(login, password){
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/connexion/",
		dataType : "json",
		data : JSON.stringify({
			"login" : login,
			"password" : password
		}),
		success : function(data, textStatus, jqXHR) {
			console.log(data)
			if(data.success)
				$("#reponse").html('ok');
			else
				$("#reponse").html('pas ok');
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('postUser error: ' + textStatus);
		}
	});
}