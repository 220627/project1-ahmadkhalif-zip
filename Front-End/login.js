// base url
const api = "localhost:/4000/"

// set event listeners
document.getElementById("btn").onClick = loginFunc;

async function loginFunc(){

    // user input into var
    let usernameAttempt = document.getElementById("username").value
    let passwordAttempt = document.getElementById("password").value

    //use the fetch method to send a request to the login API with the user's input
    let response = await fetch(api + ) 

    // check promise
    if(response.status === 200) {

    } else {
        document.
    }


}