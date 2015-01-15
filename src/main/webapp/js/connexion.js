function connect(login, password){
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/connect/",
		dataType : "json",
		data : JSON.stringify({
			"pseudo" : login,
			"mdp" : password
		}),
		success : function(data, textStatus, jqXHR) {
			console.log(data);
			if(data.id != -1){
				createCookie("id", data.id, 1);
				window.location.replace("murGeneral.html");
				console.log(readCookie("id"));
			}
			else
				$("#reponse").html("Identifiants incorrect !");		
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('postUser error: ' + textStatus);
		}
	});
}