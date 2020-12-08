/**
 * 
 */
//window.onload = function() {
//	console.log("test onload");
//	getPending();
//}
//
//function loadForms(emp) {
//	document.getElementById("formsContainer").innerText=emp;
//}
//
//function getPending() {
//	let xhttp = new XMLHttpRequest();
//
//	xhttp.onreadystatechange = function() {
//		console.log("cmon do the thing")
//		console.log(xhttp.responseText);
//		if (xhttp.readyState == 4 && xhttp.status == 200) {
//			let emp = xhttp.responseText;
//			console.log(emp);
//			loadForms(emp);
//		}
//
//	}
//
//
//	xhttp.open("GET", "/UpGrade/getPending.json", false);
//
//	xhttp.send();
//}

window.onload = function() {
	console.log("test onload");
	getPending();
}

function loadForms(forms) {
	document.getElementById("empid").innerHTML=empID;
	document.getElementById("amount").innerHTML=cost;
	console.log(forms);
}

function getPending() {
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		console.log("cmon do the thing")
		console.log(xhttp.responseText);
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let forms = xhttp.responseText;
			console.log(forms);
			loadForms(forms);
		}

	}


	xhttp.open("GET", "/UpGrade/getPending.json", false);

	xhttp.send();
}
