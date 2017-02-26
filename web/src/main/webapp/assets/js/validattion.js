var loginRegEx = "[a-zA-Zа-яА-Я0-9_.-]+";
var passwordRegEx= "[a-zA-Zа-яА-Я0-9_.-]{6,}";
var emailRegEx = "[a-zA-Z0-9_.-]+[@][a-zA-Z_.-]+[.][a-zA-Z]+";

$("document").ready(function(){
    $("#Login").focusout(function() {
        var login = this.value;
        if(login.search(loginRegEx) == -1) {
            $("#answerText").text("Неверный логин");
        } else if(login.search(loginRegEx) == 0) {
            $("#answerText").text("");
        }
    });

    $("#Password").focusout(function() {
        var password = this.value;
        if(password.search(passwordRegEx)) {
            $("#answerText").text("Неверный пароль");
        } else if(password.search(passwordRegEx) == 0) {
            $("#answerText").text("");
        }
    });

    $("#Email").focusout(function() {
        var email = this.value;
        if(email.search(emailRegEx)) {
            $("#answerText").text("Неверный email");
        } else if(email.search(emailRegEx) == 0) {
            $("#answerText").text("");
        }
    });
});