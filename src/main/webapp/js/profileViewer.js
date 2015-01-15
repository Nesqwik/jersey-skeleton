function getEmail(email){
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/profil/",
		dataType : "json",
		data : JSON.stringify({
			"email" : email,
		}),
		success : function(data, textStatus, jqXHR) {
			afficheUser(data)
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('postUser error: ' + textStatus);
		}
	});
}

function getPseudo(pseudo){
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/profil/",
		dataType : "json",
		data : JSON.stringify({
			"pseudo" : pseudo,
		}),
		success : function(data, textStatus, jqXHR) {
			afficheUser(data)
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('postUser error: ' + textStatus);
		}
	});
}