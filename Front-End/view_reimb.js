const url = "http://localhost:4000"; // base url to append... is it needed here?

// add listener to give buttons functionality
document.getElementById("viewAllReimbursementsBtn").onclick = viewAllReimbursements
document.getElementById("reimbTypeBar").onchange = viewByType

async function viewAllReimbursements(){

    // fetch requests for employee data from the server
    let response = await fetch(url + "/view_reimbursements")

    // log response for debug clues
    console.log(response)

    // control flow on the status code to determine whether or not the request was successful
    if (response.status === 202){

        // translate JSON received in response body
        let data = await response.json();
        console.log(data);

        // every reimbursement object will be cycled through here 
        for(let reimb of data){

            // create a table row for each incoming employee
            let row = document.createElement("tr")


            let cell = document.createElement("td")
            cell.innerHTML = reimb.reimb_id
            row.appendChild(cell);

            // cell 2 - reimb_amount
            let cell2 = document.createElement("td")
            cell2.innerHTML = reimb.reimb_amount
            row.appendChild(cell2)

            // cell 3  reimb_submitted
            let cell3 = document.createElement("td")
            cell3.innerHTML = reimb.reimb_submitted
            row.appendChild(cell3)

            // cell 4 reimb_resolved
            let cell4 = document.createElement("td")
            if(reimb.reimb_resolver == 0){
                cell4.innerHTML = "N/A"
            } else {
                cell4.innerHTML = reimb.reimb_resolved
            }
            row.appendChild(cell4)

            // cell 5 reimb_description
            let cell5 = document.createElement("td")
            cell5.innerHTML = reimb.reimb_description
            row.appendChild(cell5)

            // cell 6 reimb_author_username
            let cell6 = document.createElement("td")
            cell6.innerHTML = reimb.reimb_author_username
            row.appendChild(cell6)

            // cell 7 reimb_author_first_name
            let cell7 = document.createElement("td")
            cell7.innerHTML = reimb.reimb_author_first_name
            row.appendChild(cell7)

            // cell 8 reimb_author_last_name
            let cell8 = document.createElement("td")
            cell8.innerHTML = reimb.reimb_author_last_name
            row.appendChild(cell8)

            // cell 9 reimb_author_email
            let cell9 = document.createElement("td")
            cell9.innerHTML = reimb.reimb_author_email
            row.appendChild(cell9)

            // cell 10 reimb_resolver_username
            let cell10 = document.createElement("td")
            if(reimb.reimb_resolver == 0){
                cell10.innerHTML = "N/A"
            } else {
                cell10.innerHTML = reimb.reimb_resolver_username
            }
            row.appendChild(cell10)

            // cell 11 reimb_resolver_first_name
            let cell11 = document.createElement("td")
            if(reimb.reimb_resolver == 0){
                cell11.innerHTML = "N/A"
            } else {
                cell11.innerHTML = reimb.reimb_resolver_first_name
            }
            row.appendChild(cell11)

            // cell 12 reimb_resolver_last_name
            let cell12 = document.createElement("td")
            if(reimb.reimb_resolver == 0){
                cell12.innerHTML = "N/A"
            } else {
                cell12.innerHTML = reimb.reimb_resolver_last_name
            }
            row.appendChild(cell12)

            // cell 13 reimb_resolver_email
            let cell13 = document.createElement("td")
            if(reimb.reimb_resolver == 0){
                cell13.innerHTML = "N/A"
            } else {
            cell13.innerHTML = reimb.reimb_resolver_email
            }
            row.appendChild(cell13)

            // cell 14 reimb_type_text
            let cell14 = document.createElement("td")
            cell14.innerHTML = reimb.reimb_type_text
            row.appendChild(cell14)
            
            // cell 15 reimb_status_text
            let cell15 = document.createElement("td")

            if(reimb.reimb_status_text === 'PENDING'){
                var array = ['PENDING', 'ACCEPTED', 'DECLINED'];
                var statList = document.createElement("select");
                cell15.appendChild(statList);

                // create and append options
                for (var i = 0; i < array.length; i++) {
                    var option = document.createElement("option");
                    option.value = i + 1;
                    option.text = array[i];
                    statList.appendChild(option);
                    console.log(option.value);
                    console.log(option.text);
                }
            } else{
                cell15.innerHTML = reimb.reimb_status_text
            }
            row.appendChild(cell15)

            document.getElementById("reimbBody").append(row)    

        }
    } else {
        alert("something went wrong! make sure your Java is running")

    } // end of table filling
    
} // end of viewAllReimbursements

async function viewByType() {
    
    // before awaiting for the fetch request we have to the collect the value of the dropdown
    var typeDrop = document.getElementById("reimbTypeBar");
    var type_id = typeDrop.value;

    let response = await fetch(url + "/view_reimbursements/" + type_id, 
    {
        method: "POST"
    })

    console.log(response);

    if (response.status === 202){

        // translate JSON received in response body
        let data = await response.json();
        console.log(data);

        // every reimbursement object will be cycled through here 
        for(let reimb of data){

            // create a table row for each incoming employee
            let row = document.createElement("tr")


            let cell = document.createElement("td")
            cell.innerHTML = reimb.reimb_id
            row.appendChild(cell);

            // cell 2 - reimb_amount
            let cell2 = document.createElement("td")
            cell2.innerHTML = reimb.reimb_amount
            row.appendChild(cell2)

            // cell 3  reimb_submitted
            let cell3 = document.createElement("td")
            cell3.innerHTML = reimb.reimb_submitted
            row.appendChild(cell3)

            // cell 4 reimb_resolved
            let cell4 = document.createElement("td")
            if(reimb.reimb_resolver == 0){
                cell4.innerHTML = "N/A"
            } else {
                cell4.innerHTML = reimb.reimb_resolved
            }
            row.appendChild(cell4)

            // cell 5 reimb_description
            let cell5 = document.createElement("td")
            cell5.innerHTML = reimb.reimb_description
            row.appendChild(cell5)

            // cell 6 reimb_author_username
            let cell6 = document.createElement("td")
            cell6.innerHTML = reimb.reimb_author_username
            row.appendChild(cell6)

            // cell 7 reimb_author_first_name
            let cell7 = document.createElement("td")
            cell7.innerHTML = reimb.reimb_author_first_name
            row.appendChild(cell7)

            // cell 8 reimb_author_last_name
            let cell8 = document.createElement("td")
            cell8.innerHTML = reimb.reimb_author_last_name
            row.appendChild(cell8)

            // cell 9 reimb_author_email
            let cell9 = document.createElement("td")
            cell9.innerHTML = reimb.reimb_author_email
            row.appendChild(cell9)

            // cell 10 reimb_resolver_username
            let cell10 = document.createElement("td")
            if(reimb.reimb_resolver == 0){
                cell10.innerHTML = "N/A"
            } else {
                cell10.innerHTML = reimb.reimb_resolver_username
            }
            row.appendChild(cell10)

            // cell 11 reimb_resolver_first_name
            let cell11 = document.createElement("td")
            if(reimb.reimb_resolver == 0){
                cell11.innerHTML = "N/A"
            } else {
                cell11.innerHTML = reimb.reimb_resolver_first_name
            }
            row.appendChild(cell11)

            // cell 12 reimb_resolver_last_name
            let cell12 = document.createElement("td")
            if(reimb.reimb_resolver == 0){
                cell12.innerHTML = "N/A"
            } else {
                cell12.innerHTML = reimb.reimb_resolver_last_name
            }
            row.appendChild(cell12)

            // cell 13 reimb_resolver_email
            let cell13 = document.createElement("td")
            if(reimb.reimb_resolver == 0){
                cell13.innerHTML = "N/A"
            } else {
            cell13.innerHTML = reimb.reimb_resolver_email
            }
            row.appendChild(cell13)

            // cell 14 reimb_type_text
            let cell14 = document.createElement("td")
            cell14.innerHTML = reimb.reimb_type_text
            row.appendChild(cell14)
            
            // cell 15 reimb_status_text
            let cell15 = document.createElement("td")

            if(reimb.reimb_status_text === 'PENDING'){
                var array = ['PENDING', 'ACCEPTED', 'DECLINED'];
                var statList = document.createElement("select");
                cell15.appendChild(statList);

                // create and append options
                for (var i = 0; i < array.length; i++) {
                    var option = document.createElement("option");
                    option.value = i + 1;
                    option.text = array[i];
                    statList.appendChild(option);
                    console.log(option.value);
                    console.log(option.text);
                }
            } else{
                cell15.innerHTML = reimb.reimb_status_text
            }
            row.appendChild(cell15)

            document.getElementById("reimbBody").append(row)    

        }
    } else {
        alert("something went wrong! make sure your Java is running")

    } // end of table filling



} // end of type id
