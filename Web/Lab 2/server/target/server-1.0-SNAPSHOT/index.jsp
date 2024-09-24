<%@ page import="java.util.List" %>
<%@ page import="models.ClientData" %>
<%@ page import="view.TableView" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/nav.css">
    <link rel="stylesheet" type="text/css" href="css/fonts.css">
    <link rel="stylesheet" type="text/css" href="css/body.css">
    <link rel="stylesheet" type="text/css" href="css/table.css">
    <link rel="stylesheet" type="text/css" href="css/canv.css">
    <script src="js/jquery-3.6.1.min.js"></script>
    <script src="js/clearTableEvent.js"></script>
    <script src="js/clientHandler.js"></script>
    <script src="js/canv.js"></script>
    <script src="js/planeResizeEvent.js"></script>
    <script src="js/canvClickEvent.js"></script>
    <title>Document</title>
</head>

<body onload="return draw_plane_def()">
    <div id="nav_bar">
        <div class="nav_item"><img src="img/logo.png" alt="" id="logo"></div>
        <div class="nav_item" id="owner">
            <p id="sign">Created by: <a href="https://github.com/lilinsane">In$ane</a></p>
        </div>
        <div class="nav_item">
            <p id="name"><a href="">Привалов Ярослав P32111</a></p>
        </div>
    </div>
    <div id="main_page">
        <div id="content">
            <div class="content_block">
                <p>
                <div id="canvas_container">
                    <div id="canvas_point"></div>
                    <canvas id="plane" onclick="return clickEvent()"></canvas>
                </div>
                </p>
                <div class="content_block">
                    <form>
                        <p>Введите число R &isin; [1;5]</p>
                        <input type="number" min="1" max="5" id="canv_size">
                        <div class="btn_block">
                            <p><input type="button" onclick="resizeAJAX();" class="btn neon_red" value="Отправить"></p>
                        </div>
                    </form>
                </div>
            </div>
            <div class="content_block" >
                <form onsubmit="return handleAJAX();">
                    <p>Введите координаты Х, У, а также число R:</p>
                    <label>X &isin; [-3;5]</label>
                    <div class="radio_form">
                        <div class="radio"><input class="radio_inp" type="radio" name="xcoord" value="-3" id="number1" required>
                            <label class="radio_label" for="number1">-3</label>
                        </div>
                        <div class="radio"><input class="radio_inp" type="radio" name="xcoord" value="-2" id="number2">
                            <label class="radio_label" for="number2">-2</label>
                        </div>
                        <div class="radio"><input class="radio_inp" type="radio" name="xcoord" value="-1" id="number3">
                            <label class="radio_label" for="number3">-1</label>
                        </div>
                        <div class="radio"><input class="radio_inp" type="radio" name="xcoord" value="0" id="number4">
                            <label class="radio_label" for="number4">0</label>
                        </div>
                        <div class="radio"><input class="radio_inp" type="radio" name="xcoord" value="1" id="number5">
                            <label class="radio_label" for="number5">1</label>
                        </div>
                        <div class="radio"><input class="radio_inp" type="radio" name="xcoord" value="2" id="number6">
                            <label class="radio_label" for="number6">2</label>
                        </div>
                        <div class="radio"><input class="radio_inp" type="radio" name="xcoord" value="3" id="number7">
                            <label class="radio_label" for="number7">3</label>
                        </div>
                        <div class="radio"><input class="radio_inp" type="radio" name="xcoord" value="4" id="number8">
                            <label class="radio_label" for="number7">4</label>
                        </div>
                        <div class="radio"><input class="radio_inp" type="radio" name="xcoord" value="5" id="number9">
                            <label class="radio_label" for="number7">5</label>
                        </div>
                    </div>
                    <p id="errXcoord" class="error-msg"></p>
                    <label>Y &isin; [-3;3]</label>
                    <p><input type="text" id="ycoord" class="section_inp neon_red" required><br></p>
                    <p id="errYcoord" class="error-msg"></p>
                    <label>R &isin; [1.0;5.0]</label>
                    <p><input type="select" id="rnum" class="section_inp neon_red" required><br></p>
                    <p id="errRnum" class="error-msg"></p>
                    <div class="btn_block">
                        <p><input type="submit" class="btn neon_red"></p>
                        <p><input type="button" onclick="return clearTableAJAX();" class="btn neon_red" value="Очистить"></p>
                    </div>
                </form>
            </div>
                <div class="table_block">
                    <table border="1" class="result_table neon_blue">
                        <thead>
                            <tr>
                                <td>
                                    <p>Координата X</p>
                                </td>
                                <td>
                                    <p>Координата Y</p>
                                </td>
                                <td>
                                    <p>Число R</p>
                                </td>
                                <td>
                                    <p>Результат</p>
                                </td>
                                <td>
                                    <p>Время работы скрипта мс</p>
                                </td>
                                <td>
                                    <p>Текущее время</p>
                                </td>
                            </tr>
                        </thead>
                        <tbody id="tbody">
                        <%
                            List<ClientData> clientData = (List<ClientData>) session.getAttribute("clientData");
                            TableView tableView = new TableView();
                            if(clientData != null) {
                                for (ClientData cl: clientData) { %>
                                    <%= tableView.createRow(cl)%>
                                <%}
                            }
                        %>
                        </tbody>
                    </table>
                    <template id="product-row">
                        <tr>
                            <td class="column">
                                <p></p>
                            </td>
                            <td class="column">
                                <p></p>
                            </td>
                            <td class="column">
                                <p></p>
                            </td>
                            <td class="column">
                                <p></p>
                            </td>
                            <td class="column">
                                <p></p>
                            </td>
                            <td class="column">
                                <p></p>
                            </td>
                        </tr>
                    </template>

                </div>
            </div>
        </div>
    </div>
</body>

</html>