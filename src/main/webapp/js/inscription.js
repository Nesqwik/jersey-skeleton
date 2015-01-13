function signIn(pseudo, email, mdp, mdp2){
	if (mdp == mdp2){
		$.ajax({
			type : 'POST',
			contentType : 'application/json',
			url : "v1/signin/",
			dataType : "json",
			data : JSON.stringify({
				"email" : email,
				"pseudo": pseudo,
				"mdp" : mdp,
				"mdp2" : mdp2
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
	else
		$("#reponse").html('Erreur, mots de passe différents');
		
}