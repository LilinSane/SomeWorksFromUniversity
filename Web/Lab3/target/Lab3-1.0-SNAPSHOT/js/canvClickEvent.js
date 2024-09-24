function clickEvent(){
    let container = document.querySelector("#canvas_container");

    container.onclick = function (event){
        let plane = document.querySelector("#plane");
        let ctx = plane.getContext("2d");

        let x = 0;
        let y = 0;
        let coords;
        //if(event.target.id !== point.id)
        x = event.offsetX;
        y = event.offsetY;

        coords = calculateCoordinates(450, 225, x, y);
        sendCoordsAJAX(coords[0], coords[1]);
        //ctx.fillStyle = "rgba(245, 17, 237, 0.5)";
        /*point.style.width = "10px";
        point.style.height = "10px";
        point.style.left = (x - parseInt(point.style.width.match(/\d+/))/2).toString() + "px";
        point.style.top = (y - parseInt(point.style.height.match(/\d+/))/2).toString() + "px";*/
    }
}

function addCoords(){
    let plane = document.querySelector("#plane");
    let ctx = plane.getContext("2d");

    let x = document.querySelector('input[name="coords_form:rnum"]:checked').value;
    let y = 0;
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
    let rdata = document.querySelector('input[name="coords_form:rnum"]:checked').value;
        $.ajax({
            url: "planeHandler",
            method: 'get',
            dataType: 'html',
            cache: false,
            data: {
                'ycoord': ydata,
                'xcoord': xdata,
                'rnum': rdata
            },
            success: function(json) {
                console.log(json);
                const data = JSON.parse(json);


                let plane = document.querySelector("#plane");
                let ctx = plane.getContext("2d");
                if (data == "true")
                    ctx.fillStyle = "#05fa57";
                else
                    ctx.fillStyle = "#fa1e38";
                ctx.beginPath();
                ctx.arc(MAX_WIDTH / 2 + 10 * xdata, MAX_HEIGHT / 2 - 10 * ydata, 3, 0, 2 * Math.PI, false);
                ctx.fill();
                document.getElementById("hiddenForm:X").value = xdata;
                document.getElementById("hiddenForm:Y").value = ydata;
                document.getElementById("hiddenForm:R").value = rdata;
                document.getElementById("hiddenForm:hiddenButton").click();



                /*let tbody = document.querySelector("#tbody");
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

                }*/
            }
        });

}
