/*//////////////////////////////////////////////////////////////////
//[ FRONT-END SAURABH ]*/
$(document).ready(function() {
    $('.login100-form').hide();

    $('#q1').show();
    $('#q1 #submit').click(function() {
        $('.login100-form').hide();
        $('#q2').fadeIn(300);
        return false;
    });
    $('#q2 #submit').click(function() {
        $('.login100-form').hide();
        $('#q3').fadeIn(300);
        return false;
    });
    $('#q3 #submit').click(function() {
        $('.login100-form').hide();
        $('#q4').fadeIn(300);
        return false;
    });
    $('#q4 #submit').click(function() {
        $('.login100-form').hide();
        $('#q5').fadeIn(300);
        return false;
    });
    $('#q5 #done').click(function() {
        $('.login100-form').hide();
        window.location.href = 'C:/Users/Jaydev/Downloads/Login_v5/quizdone.html'
        return false;
    });


})