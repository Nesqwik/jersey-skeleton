function getResultat(recherche) {
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/recherche/",
		dataType : "json",
		data : JSON.stringify({
			"recherche" : recherche,
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

