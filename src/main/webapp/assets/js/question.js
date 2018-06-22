$(document).ready(function() {
    // Function to change form action.
    $("#tp").change(function() {
        var selected = $(this).children(":selected").text();
        switch (selected) {
            case "Open Question":
                $("#myform").attr('action', 'open.html');
                break;
            case "Multiple choice Question":
                $("#myform").attr('action', 'multiple.html');

                break;
            case "Associative Question":
                $("#myform").attr('action', 'associative.html');

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