function deletePost(user,post){
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/deletePost/",
		dataType : "json",
		data : JSON.stringify({
			"pseudo" : user,
			"idPost" : post
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