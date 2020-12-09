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
		}
	}
	xhttp.open("GET", "/UpGrade/getPending.json", false);
	xhttp.send();
}

function loadForms(forms) {
	const table = document.getElementById("formData");
	Array.prototype.forEach.call(forms.forms, form => {
		let row = table.insertRow();
		let reqID = row.insertCell(0);
		reqID.innerHTML = forms.forms[0].r_ID;
		let empID = row.insertCell(1);
		empID.innerHTML = forms.forms[0].empID;
		let event = row.insertCell(2);
		event.innerHTML = forms.forms[0].eventName;
		let date = row.insertCell(3);
		date.innerHTML = forms.forms[0].date;
		let time = row.insertCell(4);
		time.innerHTML = forms.forms[0].time;
		let location = row.insertCell(5);
		location.innerHTML = forms.forms[0].location;
		let description = row.insertCell(6);
		description.innerHTML = forms.forms[0].description;
		let cost = row.insertCell(7);
		cost.innerHTML = forms.forms[0].cost;
		let file = row.insertCell(8);
		file.innerHTML = forms.forms[0].eventFile;
		let grade = row.insertCell(9);
		grade.innerHTML = forms.forms[0].gradingFormat;
		let type = row.insertCell(10);
		type.innerHTML = forms.forms[0].eventType;
		let justification = row.insertCell(11);
		justification.innerHTML = forms.forms[0].justification;
		let approvalFile = row.insertCell(12);
		approvalFile.innerHTML = forms.forms[0].approvalFile;
		let supeApprove = row.insertCell(13);
		supeApprove.innerHTML = forms.forms[0].dsApproval;
		let headApprove = row.insertCell(14);
		headApprove.innerHTML = forms.forms[0].dhApproval;
		let benCoApprove = row.insertCell(15);
		benCoApprove.innerHTML = forms.forms[0].bcApproval;
		let alteredAmount = row.insertCell(16);
		alteredAmount.innerHTML = forms.forms[0].alteredAmt;
		let alteredReason = row.insertCell(17);
		alteredReason.innerHTML = forms.forms[0].alteredReason;
		let exceedFunds = row.insertCell(18);
		exceedFunds.innerHTML = forms.forms[0].exceedingFunds;
		let awarded = row.insertCell(19);
		awarded.innerHTML = forms.forms[0].awarded;
		let denial = row.insertCell(20);
		denial.innerHTML = forms.forms[0].denialReason;
	});
}

