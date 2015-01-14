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
			afficheUser(data)
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('postUser error: ' + textStatus);
		}
	});
}