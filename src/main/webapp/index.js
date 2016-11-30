/**
 * Created by mykola.dekhtiarenko on 29.11.16.
 */
$(document).ready(function(){
    getDisciplines();
    $(function () {
        $('#table').bootstrapTable({
            data: disciplines
        });
    });
});
var disciplines;

function getDisciplines() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/discipline/getAllDiscipline',

        success: function (request) {
           disciplines=request.toString();

        },
        error: function (errormessage) {
            alert(errormessage.toString());
        }
    });
}

