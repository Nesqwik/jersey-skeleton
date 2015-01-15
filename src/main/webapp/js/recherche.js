function getResultat(keywords, type) {
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/recherche/",
		dataType : "json",
		data : JSON.stringify({
			"keywords" : keywords,
			"type" : type,
		}),
		success : function(data, textStatus, jqXHR) {
			console.log(data)
			afficheListFiles(data)
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('postUser error: ' + textStatus);
		}
	});
}

function afficheListFiles(data){
	var html = '<ul>';
	var index = 0;
	if(data.length!=0){
		for (index = 0; index < data.length; ++index) {
			html = html + "<li>" + data[index].description + "</li>";
		}
		html = html + "</ul>";
		$("#reponse").html(html);
	}
	else $("#reponse").html("Fichier inexistant");
}

