$(function() {
    // if ($('input[name="remember"]:checked')) {
    document.getElementById("txtLoginUserName").value = getCookie(KEY_USERNAME);
    document.getElementById("txtPassword").value = getCookie(KEY_PASS);
    // };
});

function login() {
    // Get userName & password
    var userName = document.getElementById("txtLoginUserName").value;
    var password = document.getElementById("txtPassword").value;

    // TODO validate
    if (!userName) {
        showNameErrorMessage("Please input UserName!");
        return;
    }

    if (!password) {
        showNameErrorMessage("Please input Password!");
        return;
    }

    if (userName.length < 1 || userName.length > 30 || password.length < 1 || password.length > 30) {
        showNameErrorMessage("UserName and Password must be from 6 to 30 chracters!");
        return;
    }

    console.log(btoa(userName + ":" + password));

    // Call API
    $.ajax({
        url: 'http://localhost:8080/api/v1/accounts',
        type: 'GET',
        // data: JSON.stringify(account), // body
        contentType: "application/json", // type of body (json, xml, text)
        dataType: 'json', // datatype return
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(userName + ":" + password));
        },
        success: function(data, textStatus, xhr) {
            setCookie(KEY_USERNAME, userName);
            setCookie(KEY_PASS, password);
            // console.log(data);
            // success
            // hideModal();
            // showSuccessAlert();
            // buildTable();
            window.location.replace("http://127.0.0.1:5500/html/Index.html");
        },
        error(jqXHR, textStatus, errorThrown) {
            if (jqXHR.status == 401) {
                showNameErrorMessage("Login Fail!");
            } else {
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            }
        }

    });
}

function showNameErrorMessage(message) {
    document.getElementById("nameErrorMessage").style.display = "block";
    document.getElementById("nameErrorMessage").innerHTML = message;
}

function hideNameErrorMessage(message) {
    document.getElementById("nameErrorMessage").style.display = "none";
}

function handKeyUpEventForLogin(event) {
    if (event.keyCode === 13) {
        event.preventDefault();
        login();
    }
}

function refreshRemember() {
    setCookie(KEY_USERNAME, "");
    setCookie(KEY_PASS, "");

    window.location.replace("http://127.0.0.1:5500/html/Login.html");
}