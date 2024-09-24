function clearPlane(){
    let plane = document.querySelector("#plane");
    let ctx = plane.getContext("2d");
    ctx.clearRect(0, 0, plane.width, plane.height);
}

function redrawEvent(){
    let r;
    try {
        r = document.querySelector('input[name="coords_form:rnum"]:checked').value;
    }
    catch (e){
        r = null;
    }
    if(r != null){
        clearPlane();
        draw_plane(r);
        loadPointsAJAX(r);
        return;
    }
    draw_plane_def();
}

function resizePlane(data){
    if (data == null)
        return;
    if (data.status === "success") {
        let r = document.querySelector('input[name="coords_form:rnum"]:checked').value;
        clearPlane();
        draw_plane(r);
        loadPointsAJAX(r);
    }
}

function clearEvent(data){
    if (data == null)
        return;
    if (data.status === "success") {
        let r = document.querySelector('input[name="coords_form:rnum"]:checked').value;
        clearPlane();
        draw_plane(r);
    }
}

function loadPointsAJAX(r){
    $.ajax({
        url: "pointHistory",
        method: 'get',
        dataType: 'html',
        cache: false,
        data: {
            'rnum': r
        },
        success: function(json){
            console.log(json);
            let stopw = "endl";
            let data = [];
            let buffer = json.split(stopw);
            let i = 0;
            while ((buffer.length - 1) > i){
                data[i] = JSON.parse(buffer[i]);
                i++;
            }
            for(let i = 0; i < data.length; i++){
                drawHistory(data[i]["x"], data[i]["y"], data[i]["result"]);
            }

            console.log(data[1]);
        }
    });
}

/*function resizeAJAX(r){
    if (r === 0)
        return false;
    $.ajax({
        url: "controller",
        method: 'get',
        dataType: 'html',
        cache: false,
        data: {
            'rnum': r
        },
        success: function(json) {
            console.log(json);
            let stopw = "stopw";
            let data = [];
            let buffer = json.split(stopw);
            let i = 0;
            while ((buffer.length - 1) > i){
                data[i] = JSON.parse(buffer[i]);
                i++;
            }

            clearPlane();
            draw_plane(r);

            for(let i = 0; i < data.length; i++){
                drawHistory(data[i]["x"], data[i]["y"], data[i]["hit"]);
            }

            console.log(data[1]);
        }
    });
}*/

function drawHistory(x, y, isHit) {
    let plane = document.querySelector("#plane");
    let ctx = plane.getContext("2d");
    if (isHit === true)
        ctx.fillStyle = "#05fa57";
    else
        ctx.fillStyle = "#fa1e38";
    ctx.beginPath();
    ctx.arc(MAX_WIDTH/2 + 10*x, MAX_HEIGHT/2 - 10*y, 3, 0, 2*Math.PI, false);
    ctx.fill();
}
