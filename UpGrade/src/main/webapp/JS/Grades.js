/**
 * 
 */
 let forms;
 let i;
 
window.onload = function() {
	console.log("test onload");
	getGrades();
}

function loadForms(forms) {
	const data = document.getElementById("tableData");
 	console.log(forms[0].bc_awarded);
 	for (i = 0; i < forms.length; i++){
 		let row = data.insertRow();
		let rID = row.insertCell(0);
		rID.innerHTML = forms[i].r_ID;
		let event = row.insertCell(1);
		event.innerHTML = forms[i].eventName;
		let grade = row.insertCell(2);
		grade.innerHTML = forms[i].gradingFormat;
		let dsapprove = row.insertCell(3);
		if(forms[i].ds_awarded == false || null){
			dsapprove.innerHTML = "Pending";
		} else {
			dsapprove.innerHTML = "Approved";
		}
		let bcapprove = row.insertCell(4);
		if(forms[i].bc_awarded == false || null){
			bcapprove.innerHTML = "Pending";
		} else {
			bcapprove.innerHTML = "Approved";
		}
 	}
}

function getGrades() {
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		console.log("cmon do the thing")
		console.log(xhttp.responseText);
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			forms = JSON.parse(xhttp.responseText);
			console.log(forms);
			loadForms(forms);
		}

	}


	xhttp.open("GET", "/UpGrade/getGrades.json", false);

	xhttp.send();
}