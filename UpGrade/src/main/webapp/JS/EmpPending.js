/**
 * 
 */
 let forms;
 let i;
 
 window.onload = function(){
 	getReimbursements();
 }
 
 function loadForms(forms){
 	const pendingTable = document.getElementById("pendingData");
 	
 	for (i = 0; i < forms.length; i++){
 		let row = pendingTable.insertRow();
		let rID = row.insertCell(0);
		rID.innerHTML = forms[i].r_ID;
		let event = row.insertCell(1);
		event.innerHTML = forms[i].eventName;
		let cost = row.insertCell(2);
		cost.innerHTML = forms[i].cost;
		let projected = row.insertCell(3)
		projected.innerHTML = forms[i].projected
		let dhapprove = row.insertCell(4);
		if(forms[i].dhApproval == 0 || null){
			dhapprove.innerHTML = "Pending";
		} else {
			dhapprove.innerHTML = "Approved";
		}
		let dsapprove = row.insertCell(5);
		if(forms[i].dsApproval == 0 || null){
			dsapprove.innerHTML = "Pending";
		} else {
			dsapprove.innerHTML = "Approved";
		}
		let bcapprove = row.insertCell(6);
		if(forms[i].bcApproval == false || null){
			bcapprove.innerHTML = "Pending";
		} else {
			bcapprove.innerHTML = "Approved";
		}
 	}
 }
 
 function getReimbursements(){
 	let xhttp = new XMLHttpRequest();
 	
 	xhttp.onreadystatechange = function() {
 		console.log(xhttp.responseText);
 		if (xhttp.readyState == 4 && xhttp.status == 200) {
 			forms = JSON.parse(xhttp.responseText);
 			console.log(forms);
 			loadForms(forms);
 		}
 	}
 	
 	xhttp.open("GET", "/UpGrade/getAll.json", false);
 	
 	xhttp.send();
 }