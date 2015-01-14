function getResultat(keywords) {
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/recherche/",
		dataType : "json",
		data : JSON.stringify({
			"keywords" : keywords,
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

