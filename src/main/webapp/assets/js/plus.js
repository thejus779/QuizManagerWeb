/*//////////////////////////////////////////////////////////////////
//[ FRONT-END SAURABH ]*/
$(document).ready(function() {
    $("#plus").on('click', function() {
        $("#addmore").append(' <input class="left100" type="text" name="answer">        <span class="focus-input100"></span>        <select class="right100">                <option>Answer</option>                <option>True</option>                <option>False</option>        </select>        <span class="focus-input100"></span>');
    })
});