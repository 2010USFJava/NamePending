/**
 * 
 */
let forms;
let i;

window.onload = function() {
	getPending();
}

function loadForms(forms) {
	today = new Date();
	const table = document.getElementById("tableData");
	for (i = 0; i < forms.length; i++) {
		let row = table.insertRow();
		let eID = row.insertCell(0);
		eID.innerHTML = forms[i].empObj.empID;
		let rID = row.insertCell(1);
		rID.innerHTML = forms[i].rObj.r_ID;
		let fName = row.insertCell(2);
		fName.innerHTML = forms[i].empObj.firstName;
		let lName = row.insertCell(3);
		lName.innerHTML = forms[i].empObj.lastName;
		let event = row.insertCell(4);
		event.innerHTML = forms[i].rObj.eventName;
		let days = row.insertCell(5);
		let day = new Date(forms[i].rObj.date);
		let date = Math.round((day.getTime() - today.getTime()) / (1000 * 60 * 60 * 24));
		if (date < 12) {
			days.innerHTML = date + " days URGENT";
		}
		else {
			days.innerHTML = date + " days";
		}
	}
}

function getPending(){
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function () {
		if(xhttp.readyState == 4 && xhttp.status == 200){
			forms = JSON.parse(xhttp.responseText);
			console.log(forms);
			loadForms(forms);
		}
	}
	
	xhttp.open("GET", "/UpGrade/getDHPending.json", false);
	
	xhttp.send();
}