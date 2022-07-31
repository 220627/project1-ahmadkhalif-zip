
// copying session data from login
var user_id = sessionStorage.getItem("user_id");
var user_role_id = sessionStorage.getItem("user_role_id");
var first_name = sessionStorage.getItem("first_name");
console.log(user_id);

var welcText = document.getElementById("welcome");
welcText.textContent = "Hello, " + first_name;

document.getElementById("ViewReimbBtn").onclick = viewAllReimbs

async function viewAllReimbs(){
    if (user_role_id == 1){
        window.location.href ='/view_reimbursements.html'

    } else {
        var errText = document.getElementById("noAccess");
        errText.textContent = "You do not have access to this page" 
    }

}