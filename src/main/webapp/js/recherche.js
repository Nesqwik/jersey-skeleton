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
	var html = "";
	var index = 0;
	if(data.length!=0){
		for (index = 0; index < data.length; ++index) {
			html = html + "<li>"+ "Utilisateur : " + data[index].pseudo + "  Post : " + data[index].description + "</li>";
			if(data[index].type == "Musique")
				html += "<br><audio controls=\"controls\"> <source src=\"" + data[index].chemin + "\" type=\"audio/mp3\" /> Votre navigateur n'est pas compatible </audio></br>";
			
			if(data[index].type == "Vidéo")
				html += "<br><video controls src=\"" + data[index].chemin + "\"> video mp4 </video></br>";
			
			if(data[index].type == "Image")
				html += "<br><image controls src=\" " + data[index].chemin + "\"></image></br>";
		}
		$("#reponse").html(html);
	}
	else $("#reponse").html("Fichier inexistant");
}

