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
				content += "<div class=\"download\"><a href=\""+data[i].path+"\" download=\""+data[i].path+"\">Télécharger</a></div>"; 
				if(data[i].type == "audio")
					content += "<audio controls=\"controls\"> <source src=\"" + data[i].path + "\" type=\"audio/mp3\" /> Votre navigateur n'est pas compatible </audio>";
				
				if(data[i].type == "video")
					content += "<video width=\"320\" height=\"240\" controls src=\"" + data[i].path + "\"> video mp4 </video>";
				
				if(data[i].type == "image")
					content += "<image controls src=\" " + data[i].path + "\"></image>";
				if(data[i].path.split(".")[1] == "pdf"){
					content += "<iframe src=\""+data[i].path+"\" width=\"500\" height=\"500\" align=\"middle\"></iframe>"
				}
				content += "</div>";
			}
			$("#posts").html(content);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			//console.log(data)
			alert('erreur');
		}
	});
}



function getUser(idCookie){
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/user",
		dataType : "json",
		data : JSON.stringify({
			"id" : idCookie
		}),
		success : function(data, textStatus, jqXHR) {
			console.log(data);
			$("#user").html("Bonjour " + data.pseudo + " !");
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('postUser error: ' + textStatus);
		}
	});
}