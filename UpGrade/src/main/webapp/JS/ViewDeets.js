/**
 * 
 */
window.onload = function(){
	getForms();
}

function getForms(){
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState==4 && xhttp.status==200){
			let forms = JSON.parse(xhttp.responseText);
			loadForms(forms); 
			console.log(forms);
			console.log(forms.forms[1].r_ID);
		}
	}
	xhttp.open("GET", "/UpGrade/getPending.json", false);
	xhttp.send();
}

function loadForms(forms) {
	const table = document.getElementById("formData");
	for(i=0; i < forms.forms.length; i++){
		let row = table.insertRow();
		let reqID = row.insertCell(0);
		reqID.innerHTML = forms.forms[i].r_ID;
		let empID = row.insertCell(1);
		empID.innerHTML = forms.forms[i].empID;
		let event = row.insertCell(2);
		event.innerHTML = forms.forms[i].eventName;
		let date = row.insertCell(3);
		date.innerHTML = forms.forms[i].date;
		let time = row.insertCell(4);
		time.innerHTML = forms.forms[i].time;
		let location = row.insertCell(5);
		location.innerHTML = forms.forms[i].location;
		let description = row.insertCell(6);
		description.innerHTML = forms.forms[i].description;
		let cost = row.insertCell(7);
		cost.innerHTML = forms.forms[i].cost;
		let file = row.insertCell(8);
		file.innerHTML = forms.forms[i].eventFile;
		let grade = row.insertCell(9);
		grade.innerHTML = forms.forms[i].gradingFormat;
		let type = row.insertCell(10);
		type.innerHTML = forms.forms[i].eventType;
		let justification = row.insertCell(11);
		justification.innerHTML = forms.forms[i].justification;
		let approvalFile = row.insertCell(12);
		approvalFile.innerHTML = forms.forms[i].approvalFile;
		let supeApprove = row.insertCell(13);
		supeApprove.innerHTML = forms.forms[i].dsApproval;
		let headApprove = row.insertCell(14);
		headApprove.innerHTML = forms.forms[i].dhApproval;
		let benCoApprove = row.insertCell(15);
		benCoApprove.innerHTML = forms.forms[i].bcApproval;
		let alteredAmount = row.insertCell(16);
		alteredAmount.innerHTML = forms.forms[i].alteredAmt;
		let alteredReason = row.insertCell(17);
		alteredReason.innerHTML = forms.forms[i].alteredReason;
		let exceedFunds = row.insertCell(18);
		exceedFunds.innerHTML = forms.forms[i].exceedingFunds;
		let awarded = row.insertCell(19);
		awarded.innerHTML = forms.forms[i].awarded;
		let denial = row.insertCell(20);
		denial.innerHTML = forms.forms[i].denialReason;
	}
}

