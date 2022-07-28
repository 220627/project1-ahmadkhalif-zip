const url = "http://localhost:4000"; // base url

// set event listeners
// document.getElementById("viewPassBtn").onClick = viewPassFunc;
document.getElementById("log").onclick = loginFunc // button to send user's login credentials


// send user's login credentials as JSON to the backend
async function loginFunc(){

    // user input into var
    let usernameAttempt = document.getElementById("username").value
    let passwordAttempt = document.getElementById("password").value

    // to send this login data as JSON we first need to create a JS object
    let userCreds = {
        username: usernameAttempt,
        password: passwordAttempt
    } // left: JSON.  Right: values being stored 

    // for debugging, print out userCreds
    console.log(userCreds)

    // fetch request to server
    let response = await fetch(url + "/login", {
        method: "POST",
        body: JSON.stringify(userCreds),
        credentials: "include"
        // this line will ensure a cookie gets captured (so that we can use sessions)
        // future fetches after login will require this "include" variable***************************************

    })
    
    // log status
    console.log(response.status)

    //
    if (response.status === 202){

        let data = await response.json();
        console.log(data)

        // this is where to redirect the user

    } else {

        // the header will change if
        document.getElementById("informalHead").innerHTML = "Login failed. Please check your username and password.";
        document.getElementById("informalHead").style.color = "red";

    }
}



// ben recommends having one login page.
// based on the user's user_role_id reroute to appropriate page 