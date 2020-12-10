/**
 * 
 */
window.onload = function() {
	console.log("test onload");
	getPending();
}

function loadForms(forms) {
	document.getElementById("empFName").innerHTML=forms.empObj.firstName;
	document.getElementById("empLName").innerHTML=forms.empObj.lastName;
}

function getPending() {
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		console.log("cmon do the thing")
		console.log(xhttp.responseText);
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			var forms = JSON.parse(xhttp.responseText);
			console.log(forms);
			console.log(forms.empObj.firstName);
			loadForms(forms);
			
		}

	}


	xhttp.open("GET", "/UpGrade/getPending.json", false);

	xhttp.send();
}


