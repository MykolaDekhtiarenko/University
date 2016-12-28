/**
 * Created by mykola.dekhtiarenko on 05.12.16.
 */
$( document).ready(function() {
    recommendedButtonListener();
    allButtonListener();
    initEditListeners();
    $("#close").click(function () {
        $("#popup").addClass("displaynone");
    });
    $("#refresh").click(function () {
        $("#popup").addClass("displaynone");
    });

});


function initEditListeners() {
    $(".edit").each(function () {
        $(this).click(function () {
            var id = $(this).attr("disciplineid");
            var teacher = $(this).attr("disciplineteacher");
            var dscr = $(this).attr("disciplinedescription");
           $("#popup").removeClass("displaynone");
           $("#teachername").val(teacher);
           $("#description").val(dscr);
           $("#refresh").click(function () {
               var newTch = $("#teachername").val();
               var newDscr =$("#description").val();
               var recommended = $('#recommended').is(":checked");

               $.ajax({
                       type: 'POST',
                       url: "http://localhost:8080/edit",
                       data: {disciplineId: id, teacher: newTch, description: newDscr, recommended: recommended},
                       success: function(data, status, settings) {
                           $("#table").html(data);
                       }
                   }
               )
           });

        })
    });
}