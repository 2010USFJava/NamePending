/**
 * 
 */
window.onload=function(){
	console.log("this baby is working!!");
	getEmployee();
}

function getEmployee(){
	let xhttp = new XMLHttpRequest();
	
	xhttp.open("GET", "/UpGrade/getsession.json", true);
	
	xhttp.send();
	
	xhttp.onreadystatechange = function(){
		console.log("ready state go BBBBRRRRRRRR")
		if(xhttp.readyState==4 && xhttp.status==200){
			let emp = JSON.parse(xhttp.responseText);
			console.log(emp);
		}
	}
	
}