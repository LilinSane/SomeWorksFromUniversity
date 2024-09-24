function clickEvent(){
    let container = document.querySelector("#canvas_container");
    let point = document.querySelector("#canvas_point");

    let x = 0;
    let y = 0;
    let coords;


    container.onclick = function (event){
        if(event.target.id !== point.id){
            x = event.offsetX;
            y = event.offsetY;
        }
        coords = calculateCoordinates(450, 225, x, y);
        sendCoordsAJAX(coords[0], coords[1]);
        point.style.width = "10px";
        point.style.height = "10px";
        point.style.left = (x - parseInt(point.style.width.match(/\d+/))/2).toString() + "px";
        point.style.top = (y - parseInt(point.style.height.match(/\d+/))/2).toString() + "px";
    }
}

function calculateCoordinates(maxw, maxh, pxx, pxy, xcoord, ycoord){
    let ratioX = MAX_WIDTH / maxw; //from canv.js
    let ratioY = MAX_HEIGHT / maxh; //from canv.js
    xcoord = ((pxx*ratioX - MAX_WIDTH/2)/DIVISION_SIZE).toFixed(1);
    ycoord = ((MAX_HEIGHT / 2 - pxy * ratioY) / DIVISION_SIZE).toFixed(1);
    console.log(xcoord + " " + ycoord);
    return [xcoord, ycoord];
}

function sendCoordsAJAX(xdata, ydata){
    let rdata = Number($('#canv_size').val());
    let isHit;
        $.ajax({
            url: "controller",
            method: 'get',
            dataType: 'html',
            cache: false,
            data: {
                'ycoord': ydata,
                'xcoord': xdata,
                'rnum' : rdata,
                'isCanv': 1
            },
            success: function(json) {
                console.log(json);
                const data = JSON.parse(json);

                let point = document.querySelector("#canvas_point");
                if (data["hit"] == 1)
                    point.style.background = "#05fa57";
                else
                    point.style.background = "#fa1e38";

                if (data["hit"] != 2) {

                    let tbody = document.querySelector("#tbody");
                    let template = document.querySelector('#product-row');
                    let clone = template.content.cloneNode(true);
                    let td = clone.querySelectorAll("td");
                    td[0].textContent = xdata;
                    td[1].textContent = ydata;
                    td[2].textContent = rdata;
                    if (data["hit"] == 1) {
                        td[3].textContent = "Попадание!";
                    } else {
                        td[3].textContent = "Промах!";
                    }

                    td[4].textContent = data["completitionTime"];
                    td[5].textContent = data["currentDate"];
                    tbody.appendChild(clone);

                } else {
                    alert("Ответ сервера: вы вышли за границы координатной плоскости");
                }
            }
        });

}
