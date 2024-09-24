function clearTableAJAX(){
	let tbody = document.querySelector("#tbody");
	while(tbody.rows[0]) {
 		tbody.deleteRow(0);
	}
	$.ajax({
        url: "controller",
        method: 'get',
        dataType: 'html',
        cache: false,
        data: {
        	'cflag': 1
        },
        success: function(condition) {
            console.log(condition);
        }
    });
}