function reload(){
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/reload/",
		dataType : "json",
		data : JSON.stringify({
		}),
		success : function(data, textStatus, jqXHR) {
			console.log(data)
			var i;
			var content = "";
			for(i = 0 ; i < data.length ; i++) {
				content += "<div class=\"post\">";
				content += "<div class=\"pseudo\">" + data[i].pseudo + "</div>";
				content += "<div class=\"description\">" + data[i].description + "</div>";
				
				content += getHtmlFromData(data[i]);
				
				content += "</div>";
			}
			$("#posts").html(content);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log(data)
			alert('erreur');
		}
	});
}


function getHtmlFromData(post){
	
	if(post.type == "audio")
		//return "<button id=\"\" class=\"btn btn-primary\">Valider</button>";
		return "<audio controls=\"controls\"> <source src=\"" + post.path + "\" type=\"audio/mp3\" /> Votre navigateur n'est pas compatible </audio>";
	
	if(post.type == "video")
		return "<video controls src=\"" + post.path + "\"> video mp4 </video>";
	
	if(post.type == "image")
		return "<image controls src=\" " + post.path + "\"></image>";
}