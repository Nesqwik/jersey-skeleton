function deleteUser(login){
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/deleteAdmin/",
		dataType : "json",
		data : JSON.stringify({
			"pseudo" : login,
		}),
		success : function(data, textStatus, jqXHR) {
			console.log(data)
			$("#reponse").html(data.message);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('postUser error: ' + textStatus);
		}
	});
}