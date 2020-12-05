/**
 * 
 */
window.onload=function(){
	console.log("this baby is working!!");
	getEmployee();
}

function getEmployee(){
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		console.log("ready state go BBBBRRRRRRRR")
		if(xhttp.readyState==4 && xhttp.status==200){
			let emp = JSON.parse(xhttp.responseText);
			console.log(emp);
		}
	}
	xhttp.open("GET", "http://localhost:8085/UpGrade/getsession.json", true);
	
	xhttp.send();
}