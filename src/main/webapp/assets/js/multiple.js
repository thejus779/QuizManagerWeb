/*//////////////////////////////////////////////////////////////////
//[ FRONT-END SAURABH ]*/
"use strict";

function show_selected() {
    var selector1 = document.getElementById('opt1');
    var value1 = selector1[selector1.selectedIndex].value;

    var selector2 = document.getElementById('opt2');
    var value2 = selector2[selector2.selectedIndex].value;

    var selector3 = document.getElementById('opt3');
    var value3 = selector3[selector3.selectedIndex].value;

    var selector4 = document.getElementById('opt4');
    var value4 = selector4[selector4.selectedIndex].value;
    
    var selector5 = document.getElementById('opt5');
    var value5 = selector5[selector5.selectedIndex].value;

    if (value1 == "False" || value2 == "False" || value3 == "False" || value4 == "False" || value5 == "False") {
        window.alert("Select one option True");
        return;
    }
    document.getElementById('done').addEventListener('submit', show_selected);
}