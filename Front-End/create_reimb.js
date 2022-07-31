const url = "http://localhost:4000"; // base url to append

document.getElementById("createReimbursementBtn").onclick = createReimb


async function createReimb() {

    // gather user input for user_id, status_type and reimb_id
    let reimb_type = document.getElementById("typeList").value
    var user_id = sessionStorage.getItem("user_id");

    console.log(reimb_type);
    console.log(user_id);

    let reimb_desc = document.getElementById("reimbDesc").value
    let reimb_amt = document.getElementById("reimbNum").value

    myJSON = {reimb_amount: reimb_amt, reimb_description: reimb_desc, reimb_author: user_id, reimb_type_id: reimb_type};

    let response = await fetch(url + "/create_reimbursement", {
        method: "POST",
        body: JSON.stringify(myJSON)
    })
    console.log(myJSON);
    console.log(JSON.stringify(myJSON));

    // control flow on status code
    if (response.status === 202){
        var p_resolve = document.getElementById("afterResolve");
        p_resolve.textContent = "Reimbursement Successfully Created"
    }
    else {
        var p_resolve = document.getElementById("afterResolve");
        p_resolve.textContent = "Failed to Create Reimbursement"
    }
    
} // end of createReimb
