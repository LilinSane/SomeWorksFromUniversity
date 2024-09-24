function clearPlane(){
    let plane = document.querySelector("#plane");
    let ctx = plane.getContext("2d");
    ctx.clearRect(0, 0, plane.width, plane.height);
}

function resizeAJAX(){
    let r = Number($('#canv_size').val());
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
        success: function() {
            clearPlane();
            draw_plane(r);
        }
    });
}

