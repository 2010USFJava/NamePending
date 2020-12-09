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
		let empID = row.insertCell(0);
		empID.innerHTML = forms.forms[0].empID;
		let cost = row.insertCell(1);
		cost.innerHTML = forms.forms[0].cost;
		let description = row.insertCell(2);
		description.innerHTML = forms.forms[0].description;
		let date = row.insertCell(3);
		date.innerHTML = forms.forms[0].date;
		let justification = row.insertCell(4);
		justification.innerHTML = forms.forms[0].justification;
	});
}

