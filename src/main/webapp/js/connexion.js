function connect(login, password){
	$.getJSON("v1/connexion/" + login, function(data) {
		
		console.log(data)
		if(data.success)
			$("#reponse").html('login ok');
		else
			$("#reponse").html('login pas ok');
	});
	
	$.getJSON("v1/connexion/" + password, function(data) {
		
		console.log(data)
		if(data.success)
			$("#reponse").html('password ok');
		else
			$("#reponse").html('password pas ok');
	});
}