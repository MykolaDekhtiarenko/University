/**
 * Created by mykola.dekhtiarenko on 04.12.16.
 */
$( document ).ready(function() {
    if(document.location.href=="http://localhost:8080/")
        document.location.href="http://localhost:8080/index";

    initButtons();
    recommendedButtonListener();
    allButtonListener();
});

function initButtons() {
    var loginButton = $("#login");
    loginButton.click(function () {
        document.location.href="http://localhost:8080/login";
    });
}

