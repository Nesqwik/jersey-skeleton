function modifierProfil(email,mdp,pseudo) {
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/modifprofil/",
		dataType : "json",
		data : JSON.stringify({
			"email" : email,
			"mdp" : mdp,
			"pseudo" : pseudo
		}),
		success : function(data, textStatus, jqXHR) {
			console.log(data)
			$("#reponse").html(data.message);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('postUser error: ' + textStatus);
		}
	});
}
