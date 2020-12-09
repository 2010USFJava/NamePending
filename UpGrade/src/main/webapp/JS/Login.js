/**
 * 
 */
function adminLogin(){
	let xhttp = new XMLHttpRequest();
	console.log("in admin login");
	xhttp.open("GET", "/UpGrade/admin.json", false);
	xhttp.send();
}