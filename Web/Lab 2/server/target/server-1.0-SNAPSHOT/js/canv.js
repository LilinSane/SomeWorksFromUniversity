const MIN_WIDTH = 0;
const MIN_HEIGHT = 0;
const MAX_WIDTH = 300;
const MAX_HEIGHT = 150;
const MAX_DIVISION = 6;
const DIVISION_SIZE = 10;

function draw_def_axis_y(){
	let plane = document.querySelector("#plane");
	let ctx = plane.getContext("2d");

	//print line
	ctx.beginPath();
	ctx.moveTo(MAX_WIDTH/2, MIN_HEIGHT + 10);
	ctx.lineTo(MAX_WIDTH/2, MAX_HEIGHT - 10);
	ctx.closePath();
	ctx.stroke();

	//print + division
	ctx.beginPath();
	ctx.moveTo(MAX_WIDTH/2 - 5, MIN_HEIGHT + 15);
	ctx.lineTo(MAX_WIDTH/2 + 5, MIN_HEIGHT + 15);
	ctx.closePath();
	ctx.stroke();

	ctx.fillStyle = "rgba(89, 17, 245, 1)";
	ctx.font = "12px Inkulinati-Regular"
	ctx.fillText("R", MAX_WIDTH/2 - 30, MIN_HEIGHT + 15);

	ctx.beginPath();
	ctx.moveTo(MAX_WIDTH/2 - 5, MAX_HEIGHT/4 + 5);
	ctx.lineTo(MAX_WIDTH/2 + 5, MAX_HEIGHT/4 + 5);
	ctx.closePath();
	ctx.stroke();

	ctx.fillStyle = "rgba(89, 17, 245, 1)";
	ctx.font = "12px Inkulinati-Regular"
	ctx.fillText("R/2", MAX_WIDTH/2 - 30, MAX_HEIGHT/4 + 5);

	//print - division
	ctx.beginPath();
	ctx.moveTo(MAX_WIDTH/2 - 5, MAX_HEIGHT - 15);
	ctx.lineTo(MAX_WIDTH/2 + 5, MAX_HEIGHT - 15);
	ctx.closePath();
	ctx.stroke();

	ctx.fillStyle = "rgba(89, 17, 245, 1)";
	ctx.font = "12px Inkulinati-Regular"
	ctx.fillText("-R", MAX_WIDTH/2 - 30, MAX_HEIGHT - 15);

	ctx.beginPath();
	ctx.moveTo(MAX_WIDTH/2 - 5, 3*MAX_HEIGHT/4 - 5);
	ctx.lineTo(MAX_WIDTH/2 + 5, 3*MAX_HEIGHT/4 - 5);
	ctx.closePath();
	ctx.stroke();

	ctx.fillStyle = "rgba(89, 17, 245, 1)";
	ctx.font = "12px Inkulinati-Regular"
	ctx.fillText("-R/2", MAX_WIDTH/2 - 30, 3*MAX_HEIGHT/4 - 5);

	//print arrow
	ctx.fillStyle = "rgba(250, 10, 26, 0.8)";
	ctx.beginPath();
	ctx.moveTo(MAX_WIDTH/2 - 5, MIN_HEIGHT + 10);
	ctx.lineTo(MAX_WIDTH/2 + 5, MIN_HEIGHT + 10);
	ctx.lineTo(MAX_WIDTH/2, MIN_HEIGHT);
	ctx.lineTo(MAX_WIDTH/2 - 5, MIN_HEIGHT + 10);
	ctx.fill();

	ctx.fillStyle = "rgba(245, 17, 237, 1)";
	ctx.font = "18px SilafejiraRegular"
	ctx.fillText("Y", MAX_WIDTH/2 + 10, MIN_HEIGHT + 15);
}

function draw_def_axis_x(){
	let plane = document.querySelector("#plane");
	let ctx = plane.getContext("2d");

	//print line
	ctx.beginPath();
	ctx.moveTo(MIN_WIDTH + 85, MAX_HEIGHT/2);
	ctx.lineTo(MAX_WIDTH - 85, MAX_HEIGHT/2);
	ctx.closePath();
	ctx.stroke();

	//print + division
	ctx.beginPath();
	ctx.moveTo(MAX_WIDTH - 90, MAX_HEIGHT/2 - 5);
	ctx.lineTo(MAX_WIDTH - 90, MAX_HEIGHT/2 + 5);
	ctx.closePath();
	ctx.stroke();

	ctx.fillStyle = "rgba(89, 17, 245, 1)";
	ctx.font = "12px Inkulinati-Regular"
	ctx.fillText("R", MAX_WIDTH - 90, MAX_HEIGHT/2 + 20);

	ctx.beginPath();
	ctx.moveTo(MAX_WIDTH/4 + 105, MAX_HEIGHT/2 - 5);
	ctx.lineTo(MAX_WIDTH/4 + 105, MAX_HEIGHT/2 + 5);
	ctx.closePath();
	ctx.stroke();

	ctx.fillStyle = "rgba(89, 17, 245, 1)";
	ctx.font = "12px Inkulinati-Regular"
	ctx.fillText("R/2", MAX_WIDTH/4 + 105, MAX_HEIGHT/2 + 20);

	//print - division
	ctx.beginPath();
	ctx.moveTo(MIN_WIDTH + 90, MAX_HEIGHT/2 - 5);
	ctx.lineTo(MIN_WIDTH + 90, MAX_HEIGHT/2 + 5);
	ctx.closePath();
	ctx.stroke();

	ctx.fillStyle = "rgba(89, 17, 245, 1)";
	ctx.font = "12px Inkulinati-Regular"
	ctx.fillText("R", MIN_WIDTH + 90, MAX_HEIGHT/2 + 20);

	ctx.beginPath();
	ctx.moveTo(3*MAX_WIDTH/4 - 105, MAX_HEIGHT/2 - 5);
	ctx.lineTo(3*MAX_WIDTH/4 - 105, MAX_HEIGHT/2 + 5);
	ctx.closePath();
	ctx.stroke();

	ctx.fillStyle = "rgba(89, 17, 245, 1)";
	ctx.font = "12px Inkulinati-Regular"
	ctx.fillText("R/2", 3*MAX_WIDTH/4 - 105, MAX_HEIGHT/2 + 20);

	//print arrow
	ctx.fillStyle = "rgba(250, 10, 26, 0.8)";
	ctx.beginPath();
	ctx.moveTo(MAX_WIDTH - 85, MAX_HEIGHT/2 - 5);
	ctx.lineTo(MAX_WIDTH - 85, MAX_HEIGHT/2 + 5);
	ctx.lineTo(MAX_WIDTH - 75, MAX_HEIGHT/2);
	ctx.lineTo(MAX_WIDTH - 85, MAX_HEIGHT/2 - 5);
	ctx.fill();

	ctx.fillStyle = "rgba(245, 17, 237, 0.8)";
	ctx.font = "18px SilafejiraRegular"
	ctx.fillText("X", MAX_WIDTH - 70, MAX_HEIGHT/2);
}

function draw_rectangle(r){
	let plane = document.querySelector("#plane");
	let ctx = plane.getContext("2d");

	ctx.fillStyle = "rgba(245, 17, 237, 0.5)";
	ctx.fillRect(3*MAX_WIDTH/4 - 135 + MAX_DIVISION*DIVISION_SIZE - r*DIVISION_SIZE/2, MAX_HEIGHT - 135 + MAX_DIVISION*DIVISION_SIZE - r*DIVISION_SIZE, MAX_WIDTH/2 - (3*MAX_WIDTH/4 - 135 + MAX_DIVISION*DIVISION_SIZE - r*DIVISION_SIZE/2), MAX_HEIGHT/2 - (MAX_HEIGHT - 135 + MAX_DIVISION*DIVISION_SIZE - r*DIVISION_SIZE) );
}

function draw_triangle(r){
	let plane = document.querySelector("#plane");
	let ctx = plane.getContext("2d");

	ctx.fillStyle = "rgba(245, 17, 237, 0.5)";
	ctx.beginPath();
	ctx.moveTo(MAX_WIDTH - 210 + MAX_DIVISION*DIVISION_SIZE - r*DIVISION_SIZE, MAX_HEIGHT/2);
	ctx.lineTo(MAX_WIDTH/2, MAX_HEIGHT/2);
	ctx.lineTo(MAX_WIDTH/2, MAX_HEIGHT/2 + r*DIVISION_SIZE/2);
	ctx.lineTo(MAX_WIDTH - 210 + MAX_DIVISION*DIVISION_SIZE - r*DIVISION_SIZE, MAX_HEIGHT/2);
	ctx.fill();
}

function draw_circle(r){
	let plane = document.querySelector("#plane");
	let ctx = plane.getContext("2d");

	ctx.fillStyle = "rgba(245, 17, 237, 0.5)";
	ctx.beginPath();
	ctx.arc(MAX_WIDTH/2, MAX_HEIGHT/2, r*DIVISION_SIZE, 0, -Math.PI/2, true);
	ctx.fill();

	ctx.beginPath();
	ctx.moveTo(MAX_WIDTH/2, MAX_HEIGHT/2);
	ctx.lineTo(MAX_WIDTH/2, MAX_HEIGHT/2 - r*DIVISION_SIZE);
	ctx.lineTo(MAX_WIDTH/2 + r*DIVISION_SIZE, MAX_HEIGHT/2);
	ctx.lineTo(MAX_WIDTH/2, MAX_HEIGHT/2);
	ctx.fill();
}

function draw_axis_y(){
	let plane = document.querySelector("#plane");
	let ctx = plane.getContext("2d");

	//print line
	ctx.beginPath();
	ctx.moveTo(MAX_WIDTH/2, MIN_HEIGHT + 10);
	ctx.lineTo(MAX_WIDTH/2, MAX_HEIGHT - 10);
	ctx.closePath();
	ctx.stroke();

	//print divisions
	for(let i = 0; i <= 12; i++){
		if(i != 6){
			ctx.beginPath();
			ctx.moveTo(MAX_WIDTH/2 - 5, MAX_HEIGHT - i*DIVISION_SIZE - 15);
			ctx.lineTo(MAX_WIDTH/2 + 5, MAX_HEIGHT - i*DIVISION_SIZE - 15);
			ctx.closePath();
			ctx.stroke();
			ctx.fillStyle = "rgba(89, 17, 245, 1)";
			ctx.font = "10px Inkulinati-Regular";
			ctx.fillText(i - 6, MAX_WIDTH/2 - 15, MAX_HEIGHT - i*DIVISION_SIZE - 10);
		}
	}

	//print arrow
	ctx.fillStyle = "rgba(255, 0, 0, 1)";
	ctx.beginPath();
	ctx.moveTo(MAX_WIDTH/2 - 5, MIN_HEIGHT + 10);
	ctx.lineTo(MAX_WIDTH/2 + 5, MIN_HEIGHT + 10);
	ctx.lineTo(MAX_WIDTH/2, MIN_HEIGHT);
	ctx.lineTo(MAX_WIDTH/2 - 5, MIN_HEIGHT + 10);
	ctx.fill();

	ctx.fillStyle = "rgba(245, 17, 237, 0.8)";
	ctx.font = "18px SilafejiraRegular"
	ctx.fillText("Y", MAX_WIDTH/2 + 10, MIN_HEIGHT + 15);
}

function draw_axis_x(){
	let plane = document.querySelector("#plane");
	let ctx = plane.getContext("2d");

	//print line
	ctx.beginPath();
	ctx.moveTo(MIN_WIDTH + 85, MAX_HEIGHT/2);
	ctx.lineTo(MAX_WIDTH - 85, MAX_HEIGHT/2);
	ctx.closePath();
	ctx.stroke();

	//print divisions
	for(let i = 0; i <= 12; i++){
		if(i != 6){
			ctx.beginPath();
			ctx.moveTo(MIN_WIDTH + i*DIVISION_SIZE + 90, MAX_HEIGHT/2 - 5);
			ctx.lineTo(MIN_WIDTH + i*DIVISION_SIZE + 90, MAX_HEIGHT/2 + 5);
			ctx.closePath();
			ctx.stroke();
			ctx.fillStyle = "rgba(89, 17, 245, 1)";
			ctx.font = "10px Inkulinati-Regular";
			ctx.fillText(i - 6, MIN_WIDTH + i*DIVISION_SIZE + 85,  MAX_HEIGHT/2 + 15);
		}
	}
	

	//print arrow
	ctx.fillStyle = "rgba(250, 10, 26, 1)";
	ctx.beginPath();
	ctx.moveTo(MAX_WIDTH - 85, MAX_HEIGHT/2 - 5);
	ctx.lineTo(MAX_WIDTH - 85, MAX_HEIGHT/2 + 5);
	ctx.lineTo(MAX_WIDTH - 75, MAX_HEIGHT/2);
	ctx.lineTo(MAX_WIDTH - 85, MAX_HEIGHT/2 - 5);
	ctx.fill();

	ctx.fillStyle = "rgba(245, 17, 237, 0.8)";
	ctx.font = "18px SilafejiraRegular"
	ctx.fillText("X", MAX_WIDTH - 75, MAX_HEIGHT/2);
}

function draw_plane(r) {
	draw_axis_x();
	draw_axis_y();
	draw_triangle(r);
	draw_rectangle(r);
	draw_circle(r);
}

function draw_plane_def() {
	draw_def_axis_x();
	draw_def_axis_y();
	draw_triangle(5);
	draw_rectangle(5);
	draw_circle(5);
}
