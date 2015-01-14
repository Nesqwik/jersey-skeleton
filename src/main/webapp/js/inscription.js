function register(pseudo, email, mdp, mdp2){
	if (mdp == mdp2){
		$.ajax({
			type : 'POST',
			contentType : 'application/json',
			url : "v1/register/",
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
					window.location.replace("murGeneral.html");
				else
					$("#reponse").html(data.message);
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log(jqXHR);
				console.log(textStatus);
				console.log(errorThrown);
				alert('erreur');
			}
		});
	}
	else
		$("#reponse").html('Erreur, mots de passe différents');
}