function deletePost(post){
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/deletePost/",
		dataType : "json",
		data : JSON.stringify({
			"post" : post,
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