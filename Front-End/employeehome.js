// copying session data from login
var user_id = sessionStorage.getItem("user_id");
var user_role_id = sessionStorage.getItem("user_role_id");
var first_name = sessionStorage.getItem("first_name");

var welcText = document.getElementById("welcome");
welcText.textContent = "Hello, " + first_name;

document.getElementById("ViewMyReimbBtn").onclick = viewMyReimbs

async function viewMyReimbs(){
    if (user_role_id == 2){
        window.location.href ='/my_reimbursements.html'

    } else {
        var errText = document.getElementById("noAccess");
        errText.textContent = "You do not have access to this page" 
    }

}