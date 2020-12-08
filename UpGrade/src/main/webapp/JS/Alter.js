/**
 * 
 */
window.onload = function() {
	console.log("test onload");
	getPending();
}

function loadForms(emp) {
	document.getElementById("empid").innerHTML=emp.empID;
	document.getElementById("amount").innerHTML=emp.cost;
}

function getPending() {
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		console.log("cmon do the thing")
		console.log(xhttp.responseText);
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let emp = xhttp.responseText;
			console.log(emp);
			loadForms(emp);
		}

	}


	xhttp.open("GET", "/UpGrade/getPending.json", false);

	xhttp.send();
}