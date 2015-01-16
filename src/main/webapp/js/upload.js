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



function fileSelected() {
	var file = document.getElementById('fileToUpload').files[0];
	if(file){
		var fileSize = 0;
		if (file.size>1024*1024){
			fileSize = (Math.round(file.size * 100 / (1024 * 1024)) / 100).toString() + 'Méga';
		}else if(file.size>1024){
			fileSize = (Math.round(file.size * 100 / 1024) / 100).toString() + 'Kilo';
		}else{ 
			fileSize = (Math.round(file.size * 100) / 100 ).toString();
		}
		fileSize += 'Octets';
		document.getElementById('fileName').innerHTML = 'Nom : ' + file.name;
		document.getElementById('fileSize').innerHTML = 'Taille : ' + fileSize;
		document.getElementById('fileType').innerHTML = 'Type : ' + file.type;
	}
}

function uploadFile() {
	var fd = new FormData();
	fd.append("fileToUpload", document.getElementById('fileToUpload').files[0]);
	var xhr = new XMLHttpRequest();
	xhr.upload.addEventListener("progress", uploadProgress, false);
	xhr.addEventListener("load", uploadComplete, false);
	xhr.addEventListener("error", uploadFailed, false);
	xhr.addEventListener("abort", uploadCanceled, false);
	xhr.open("POST", "upload");
	xhr.send(fd);
}

function uploadProgress(evt) {
	if(evt.lengthComputable){
		var percentComplete = Math.round(evt.loaded * 100 / evt.total);
		document.getElementById('progressNumber').innerHTML = percentComplete.toString() + '/100%';
	}else{
		document.getElementById('progressNumber').innerHTML = 'unable to compute';
	}
}

function uploadComplete(evt) {
	/* appelé lors de la réponse du serveur */
	alert("fuuuuuuuuuuuuuu\n"+evt.target.responseText);
}

function uploadFailed(evt) {
	alert("There was an error attempting to upload the file.");
}

function uploadCanceled(evt) {
	alert("The upload has been canceled by the user or the browser dropped the connection.");
}