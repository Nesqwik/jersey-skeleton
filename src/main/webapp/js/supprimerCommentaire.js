function delComment(commentaire,pseudo,post){
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/delcomment/",
		dataType : "json",
		data : JSON.stringify({
			"commentaire" : commentaire,
			"pseudo" : user,
			"idPost" : post
		}),
		success : function(data, textStatus, jqXHR) {
			console.log(data);
			$("#reponse").html(data.message);		
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('postUser error: ' + textStatus);
		}
	});
}