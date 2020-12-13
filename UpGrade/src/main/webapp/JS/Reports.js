/**
 * 
 */
 let forms;
 let i;
 
window.onload = function(){
	getForms();
}

function loadForms(forms) {
	const table = document.getElementById("formData");
	 for (i = 0; i < forms.length; i++) {
		let row = table.insertRow();
		let reqID = row.insertCell(0);
		reqID.innerHTML = forms[i].r_ID;
		let empID = row.insertCell(1);
		empID.innerHTML = forms[i].empID;
		let event = row.insertCell(2);
		event.innerHTML = forms[i].eventName;
		let date = row.insertCell(3);
		date.innerHTML = forms[i].date;
		let time = row.insertCell(4);
		time.innerHTML = forms[i].time;
		let location = row.insertCell(5);
		location.innerHTML = forms[i].location;
		let description = row.insertCell(6);
		description.innerHTML = forms[i].description;
		let cost = row.insertCell(7);
		cost.innerHTML = forms[i].cost;
		let file = row.insertCell(8);
		file.innerHTML = forms[i].eventFile;
		let grade = row.insertCell(9);
		grade.innerHTML = forms[i].gradingFormat;
		let type = row.insertCell(10);
		type.innerHTML = forms[i].eventType;
		let justification = row.insertCell(11);
		justification.innerHTML = forms[i].justification;
		let approvalFile = row.insertCell(12);
		approvalFile.innerHTML = forms[i].approvalFile;
		let supeApprove = row.insertCell(13);
		supeApprove.innerHTML = forms[i].dsApproval;
		let headApprove = row.insertCell(14);
		headApprove.innerHTML = forms[i].dhApproval;
		let benCoApprove = row.insertCell(15);
		benCoApprove.innerHTML = forms[i].bcApproval;
		let alteredAmount = row.insertCell(16);
		alteredAmount.innerHTML = forms[i].alteredAmt;
		let alteredReason = row.insertCell(17);
		alteredReason.innerHTML = forms[i].alteredReason;
		let exceedFunds = row.insertCell(18);
		exceedFunds.innerHTML = forms[i].exceedingFunds;
		let awarded = row.insertCell(19);
		awarded.innerHTML = forms[i].awarded;
		let denial = row.insertCell(20);
		denial.innerHTML = forms[i].denialReason;
		};
}

function getForms(){
	let xhttp = new XMLHttpRequest();
	console.log("in getForms");
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState==4 && xhttp.status==200){
			forms = JSON.parse(xhttp.responseText);
			console.log(forms);
			loadForms(forms); 
			
		}
	}
	xhttp.open("GET", "/UpGrade/getEvery.json", false);
	xhttp.send();
}
