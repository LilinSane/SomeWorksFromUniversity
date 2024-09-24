
function sendAJAX() {
    let xdata = document.querySelector('#xcoord').value;           //document.querySelector('input[name="xcoord"]:checked').value, false
    let ydata = Number($('#ycoord').val());
        $.ajax({
            url: "controller",
            method: 'get',
            dataType: 'html',
            cache: false,
            data: {
                'ycoord': ydata,
                'xcoord': xdata
            },
            success: function(json) {
                console.log(json);
                const data = JSON.parse(json);
                if (data["hit"] != 2) {
                    let tbody = document.querySelector("#tbody");
                    let template = document.querySelector('#product-row');
                    let clone = template.content.cloneNode(true);
                    let td = clone.querySelectorAll("td");
                    td[0].textContent = xdata;
                    td[1].textContent = ydata;
                    td[2].textContent = data["r"];
                    if (data["hit"] == 1) {
                        td[3].textContent = "Попадание!";
                    } else {
                        td[3].textContent = "Промах!";
                    }

                    td[4].textContent = data["completitionTime"];
                    td[5].textContent = data["currentDate"];
                    tbody.appendChild(clone);
                    let plane = document.querySelector("#plane");
                    let ctx = plane.getContext("2d");
                    if (data["hit"] == 1)
                        ctx.fillStyle = "#05fa57";
                    else
                        ctx.fillStyle = "#fa1e38";
                    ctx.beginPath();
                    ctx.arc(MAX_WIDTH/2 + 10*xdata.getStr(), MAX_HEIGHT/2 - 10*ydata.getStr(), 3, 0, 2*Math.PI, false);
                    ctx.fill();
                } else {
                    alert("Ответ сервера: Данные некорректны");
                }
            }
        });
        return false;
}