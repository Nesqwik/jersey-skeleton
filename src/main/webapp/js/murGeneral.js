function reload(){
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/register/",
		dataType : "json",
		data : JSON.stringify({
		}),
		success : function(data, textStatus, jqXHR) {
			console.log(data)
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('erreur');
		}
	});
}