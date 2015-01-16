function createCookie(name,value,days) {
	if (days) {
		var date = new Date();
		date.setTime(date.getTime()+(days*24*60*60*1000));
		var expires = "; expires="+date.toGMTString();
	}
	else var expires = "";
	document.cookie = name+"="+value+expires+"; path=/";
}

function readCookie(name) {
	var nameEQ = name + "=";
	var ca = document.cookie.split(';');
	for(var i=0;i < ca.length;i++) {
		var c = ca[i];
		while (c.charAt(0)==' ') c = c.substring(1,c.length);
		if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
	}
	return null;
}

function eraseCookie(name) {
	createCookie(name,"",-1);
}

function disconnect(idCookie) {
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/connect/logout",
		dataType : "json",
		data : JSON.stringify({
			"id" : idCookie
		}),
		success : function(data, textStatus, jqXHR) {
			//console.log(data.success);
			eraseCookie("id");
			window.location.replace("connection.html");
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('postUser is connected error: ' + textStatus);
		}
	});
}


function isConnected(idCookie){
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/connect/check",
		dataType : "json",
		data : JSON.stringify({
			"id" : idCookie
		}),
		success : function(data, textStatus, jqXHR) {
			//console.log(data.success);
			if(!data.success)
				window.location.replace("connection.html");
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('postUser is connected error: ' + textStatus);
		}
	});
}