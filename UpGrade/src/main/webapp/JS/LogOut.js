/**
 * 
 */
function logout(){
	let xhttp = new XMLHttpRequest();
	
	xhttp.open("GET", "/UpGrade/logout.json", false);
	xhttp.send();
}