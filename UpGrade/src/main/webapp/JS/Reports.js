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
		reqID.innerHTML = forms[0].r_ID;
		let empID = row.insertCell(1);
		empID.innerHTML = forms[0].empID;
		let event = row.insertCell(2);
		event.innerHTML = forms[0].eventName;
		let date = row.insertCell(3);
		date.innerHTML = forms[0].date;
		let time = row.insertCell(4);
		time.innerHTML = forms[0].time;
		let location = row.insertCell(5);
		location.innerHTML = forms[0].location;
		let description = row.insertCell(6);
		description.innerHTML = forms[0].description;
		let cost = row.insertCell(7);
		cost.innerHTML = forms[0].cost;
		let file = row.insertCell(8);
		file.innerHTML = forms[0].eventFile;
		let grade = row.insertCell(9);
		grade.innerHTML = forms[0].gradingFormat;
		let type = row.insertCell(10);
		type.innerHTML = forms[0].eventType;
		let justification = row.insertCell(11);
		justification.innerHTML = forms[0].justification;
		let approvalFile = row.insertCell(12);
		approvalFile.innerHTML = forms[0].approvalFile;
		let supeApprove = row.insertCell(13);
		supeApprove.innerHTML = forms[0].dsApproval;
		let headApprove = row.insertCell(14);
		headApprove.innerHTML = forms[0].dhApproval;
		let benCoApprove = row.insertCell(15);
		benCoApprove.innerHTML = forms[0].bcApproval;
		let alteredAmount = row.insertCell(16);
		alteredAmount.innerHTML = forms[0].alteredAmt;
		let alteredReason = row.insertCell(17);
		alteredReason.innerHTML = forms[0].alteredReason;
		let exceedFunds = row.insertCell(18);
		exceedFunds.innerHTML = forms[0].exceedingFunds;
		let awarded = row.insertCell(19);
		awarded.innerHTML = forms[0].awarded;
		let denial = row.insertCell(20);
		denial.innerHTML = forms[0].denialReason;
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