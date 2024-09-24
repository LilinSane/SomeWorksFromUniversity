<?php session_start(); ?> 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <link rel="icon" href="data:;base64,=">
    <script src="jquery-3.6.1.min.js"></script>
    <script src="pageRefreshEvent.js"></script>
    <script type="text/javascript">
    function digitalClock() {
        var date = new Date();
        var hours = date.getHours();
        var minutes = date.getMinutes();
        var seconds = date.getSeconds();
        //* добавление ведущих нулей */
        if (hours < 10) hours = "0" + hours;
        if (minutes < 10) minutes = "0" + minutes;
        if (seconds < 10) seconds = "0" + seconds;
        document.getElementById("id_clock").innerHTML = hours + ":" + minutes + ":" + seconds;
        setTimeout("digitalClock()", 1000);
    }
    </script>
    <title>Document</title>
</head>

<body id="body">
    <div class="container">
        <div class="header-logo"><img class="img-width" src="https://itmo.ru/file/news/4246/itmo_small_white_eng.png" alt=""></div>
        <div class="signature"><a href="https://github.com/LilinSane" class="sign-link">Выполнил: <br> Привалов Ярослав P32111</a></div>
    </div>
    <div id="id_clock"></div>
    <script>digitalClock();</script>
    <div class="main-div">
        <table border="1" class="main-table">
            <tr>
                <td class="td-input">
                    <img src="dekart.png" alt="">
                    <form onsubmit="return handleAJAX()">
                        <p>Введите координаты Х, У, а также число R</p>
                        <label>X &isin; [-3;3]</label>
                        <p>
                            <input type="radio" name="xcoord" value="-3" required><label>-3</label>
                            <input type="radio" name="xcoord" value="-2"><label>-2</label>
                            <input type="radio" name="xcoord" value="-1"><label>-1</label>
                            <input type="radio" name="xcoord" value="0"><label>0</label>
                            <input type="radio" name="xcoord" value="1"><label>1</label>
                            <input type="radio" name="xcoord" value="2"><label>2</label>
                            <input type="radio" name="xcoord" value="3"><label>3</label>
                        </p>
                        <p id="errXcoord" class="error-msg"></p>
                        <label>Y &isin; [-5;4]</label>
                        <p><input type="text" id="ycoord" class="rounded-input" required><br></p>
                        <p id="errYcoord" class="error-msg"></p>
                        <label>R &isin; [1.0;3.0]</label>
                        <p><input type="select" id="rnum" class="rounded-input" required><br></p>
                        <p id="errRnum" class="error-msg"></p>
                        <p><input type="submit" class="btn">
                            <input type="button" onclick="clearTableAJAX()" class="btn" value="Очистить"></p>
                    </form>
                </td>
            </tr>
        </table>
        <table border="1" class="result-table">
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
                        <p>Время работы скрипта</p>
                    </td>
                    <td>
                        <p>Текущее время</p>
                    </td>
                </tr>
            </thead>
            <tbody id="tbody">
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
        <script>refreshAJAX();</script>
    </div>
</body>

</html>
<script src="clientHandler.js"></script>


