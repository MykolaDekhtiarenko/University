/**
 * Created by mykola.dekhtiarenko on 04.12.16.
 */

function recommendedOnly() {
    $(".recommended").each(function () {
        if ($( this ).html() == "false") {
            $( this ).parent().addClass("displaynone");
        }
    });
}

function recommendedButtonListener() {
    $("#recommendedButton").click(function () {
        recommendedOnly();

    });
}

function all() {
    $(".recommended").each(function () {
        if ($( this ).html() == "false") {
            $( this ).parent().removeClass("displaynone");
        }
    });
}

function allButtonListener() {
    $("#allButton").click(function () {
       all();

    });
}
