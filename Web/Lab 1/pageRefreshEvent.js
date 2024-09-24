function refreshAJAX() {
    $.ajax({
        url: "sessionStorage.php",
        method: 'get',
        dataType: 'html',
        cache: false,
        data: {
        	'cflag': 0
        },
        success: function(json) {
            console.log(json);
            const data = JSON.parse(json);
            for (let i = 0; i < data.length; i++) {
            	let tbody = document.querySelector("#tbody");
            	let template = document.querySelector('#product-row');
            	let clone = template.content.cloneNode(true);
            	let td = clone.querySelectorAll("td");
				td[0].textContent = data[i]['x'];
				td[1].textContent = data[i]['y'];
				td[2].textContent = data[i]['r'];
				if (data[i]['isHit'] == 1) {
				 td[3].textContent = "Есть попадание!";
                } 
                else {
                 td[3].textContent = "Промах!";
                }
				td[4].textContent = data[i]['interval'];
				td[5].textContent = data[i]['time'];

                tbody.appendChild(clone);
            }

        }
    });
}

function clearTableAJAX(){
	let tbody = document.querySelector("#tbody");
	while(tbody.rows[0]) {
 		tbody.deleteRow(0);
	}
	$.ajax({
        url: "sessionStorage.php",
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
