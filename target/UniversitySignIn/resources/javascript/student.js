/**
 * Created by mykola.dekhtiarenko on 04.12.16.
 */
$( document).ready(function() {
    recommendedButtonListener();
    allButtonListener();
    initSigninListeners();
});

function initSigninListeners() {
    $(".signin").each(function () {
        $(this).click(function () {
            $.ajax(
                {
                    type: 'POST',
                    url: "http://localhost:8080/signin",
                    data: {userId: $(this).attr("userId"), disciplineId: $(this).attr("disciplineId")},
                    success: function(data, status, settings){
                        $("html").html(data);
                    }
                }
            );


        })
    });
}