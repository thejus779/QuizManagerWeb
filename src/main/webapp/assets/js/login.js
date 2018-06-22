/*//////////////////////////////////////////////////////////////////
//[ FRONT-END SAURABH ]*/

$(document).ready(function() {
    // Function to change form action.
    $("#op").change(function() {
        var selected = $(this).children(":selected").text();
        switch (selected) {
            case "Student":
                $("#myform").attr('action', 'quiz.html');
                break;
            case "Professor":
                $("#myform").attr('action', 'index.html');

                break;

            default:
                $("#myform").attr('action', '#');
        }
    });
    // Function For Back Button
    $(".back").click(function() {
        parent.history.back();
        return false;
    });
});