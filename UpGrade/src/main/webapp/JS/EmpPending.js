/**
 * 
 */
 
 window.onload = function(){
 	getReimbursements();
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
 	
 	xhttp.open("GET", "/UpGrade/getAll.json");
 }