function deleteCommentAdmin(commentaire){
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/delcommentAdmin/",
		dataType : "json",
		data : JSON.stringify({
			"commentaire" : commentaire,
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