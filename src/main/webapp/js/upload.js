function submitForm() {
	console.log("submit event");
	var fd = new FormData($("#fileinfo"));
	fd.append("label", "WEBUPLOAD");
	$.ajax({
		url: "v1/upload",
		type: "POST",
		data: fd,
		enctype: 'multipart/form-data',
		processData: false,  // tell jQuery not to process the data
		contentType: false   // tell jQuery not to set contentType
	}).done(function( data ) {
		console.log("Output:");
		console.log( data );
	});
	return false;
}



/*
function sendFile(filePath) {
	var formData = new FormData(filePath);
	$.ajax({
		url: 'script',  //server script to process data
		type: 'POST',
		xhr: function() {  // custom xhr
			myXhr = $.ajaxSettings.xhr();
			if(myXhr.upload){ // if upload property exists
				myXhr.upload.addEventListener('progress', progressHandlingFunction, false); // progressbar
			}
			return myXhr;
		},
		//Ajax events
		success: completeHandler = function(data) {

			if(navigator.userAgent.indexOf('Chrome')) {
				var catchFile = $(":file").val().replace(/C:\\fakepath\\/i, '');
			}
			else {
				var catchFile = $(":file").val();
			}
			var writeFile = $(":file");
			writeFile.html(writer(catchFile));
			$("*setIdOfImageInHiddenInput*").val(data.logo_id);
		},
		error: errorHandler = function() {
			alert("Något gick fel");
		},
		// Form data
		data: formData,
		//Options to tell JQuery not to process data or worry about content-type
		cache: false,
		contentType: false,
		processData: false
	}, 'json');
});
}*/