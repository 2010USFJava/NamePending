/**
 * 
 */
 let forms;
 let i;
 
 window.onload = function(){
 	
 }
 
 function getDetails(){
 	let xhttp = new XMLHttpRequest();
 	
 	xhttp.onreadystatechange = function() {
 		if(xhttp.readyState == 4 && xhttp.status == 200){
 			forms = JSON.parse(xhttp.responseText);
 			console.log(forms);
 			loadForms(forms);
 		}
 	}
 	
 	xhttp.open("GET", "/UpGrade/getEmpDetails.json", false);
 	
 	xhttp.send();
 }