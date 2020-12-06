/**
 * 
 */
window.onload = function() {
	console.log("this baby is working!!");
	getEmployee();
}

function getEmployee() {
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		console.log("ready state go BBBBRRRRRRRR")
		console.log(xhttp.responseText);
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let emp = xhttp.responseText;
			console.log(emp);
		}

	}


	xhttp.open("GET", "/UpGrade/getsession.json", false);

	xhttp.send();
}

