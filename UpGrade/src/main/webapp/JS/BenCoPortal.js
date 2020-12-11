/**
 * 
 */
window.onload = function() {
	console.log("test onload");
	getPending();
}

function loadForms(forms) {
	document.getElementById("empid").innerHTML=forms.forms[0].empID;
	document.getElementById("amount").innerHTML=forms.forms[0].cost;
	console.log(forms);
}

function getPending() {
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		console.log("cmon do the thing")
		console.log(xhttp.responseText);
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			var forms = JSON.parse(xhttp.responseText);
			console.log(forms);
			console.log(forms.forms[0].empID);
			loadForms(forms);
			
		}

	}


	xhttp.open("GET", "/UpGrade/getPending.json", false);

	xhttp.send();
}
