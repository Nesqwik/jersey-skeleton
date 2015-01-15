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
			$("#reponse").html(data.message);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log(data)
			alert('erreur');
		}
	});
}