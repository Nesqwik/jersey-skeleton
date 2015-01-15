function modifierProfil(email,mdp) {
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/modifprofil/",
		dataType : "json",
		data : JSON.stringify({
			"email" : email,
			"mdp" : mdp
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
