function checkFeildEmail(){
    let email=document.getElementById("email").value;
    let emailMsg=document.getElementById("msg1");
    let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if(email===""){
        emailMsg.textContent ="Email cannot be empty";
        return false;
    }else if(!emailPattern.test(email)){
        emailMsg.textContent= "Enter a valid email address";
        return false;
    }
    else{
        emailMsg.textContent="";
        return true;
    }
}

function checkFeildPassword(){
    let password=document.getElementById("pass").value;
    let passwordMsg=document.getElementById("msg2");
    if(password===""){
        passwordMsg.textContent ="Password cannot be empty";
        return false;
    }else{
        passwordMsg.textContent="";
        return true;
    }
}

function checkValidation() {
        let emailValid = checkFeildEmail();
        let passwordValid = checkFeildPassword();

        if (emailValid && passwordValid) {
            alert("Login successful!");
        }
 }