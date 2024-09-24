class InputData {
    str = "";
    isValid = false;

    constructor(str, isValid) {
        this.str = str;
        this.isValid = isValid;
    }
    getStr() {
        return this.str
    }
    getIsValid() {
        return this.isValid;
    }
    /**
     * @param {string} str
     */
    setStr(str) {
        this.str = str;
    }
    /**
     * @param {boolean} isValid
     */
    setIsValid(isValid) {
        this.isValid = isValid;
    }
}

class ResponseData{
    hit;
    completitionTime;
    currentData;

    getHit() {
        return this.hit;
    }

    getcCompletitionTime() {
        return this.completitionTime;
    }

    getCurrentData() {
        return this.currentData;
    }
}

function inpErrMsg(id, isValid){
    if (!isValid) {
        document.getElementById(id).innerHTML = "Неверно заполнено поле";
    }
    else {
        document.getElementById(id).innerHTML = "";
    }
}

function isRadioValid(inputData) {
    if (inputData != "") {
        inputData.setIsValid(true);
        inpErrMsg('errXcoord', true);
        return inputData;
    } else {
        inpErrMsg('errXcoord', false);
        return inputData;
    }
}

function isTextValid(inputData) {
    if (Number.isInteger(inputData.getStr()) === true && inputData.getStr() >= -3 && inputData.getStr() <= 3) {
        inputData.setIsValid(true);
        inpErrMsg('errYcoord', true);
        return inputData;
    } else {
        inpErrMsg('errYcoord', false);
        return inputData;
    }
}

function isSelectValid(inputData) {
    if (!isNaN(inputData.getStr() && inputData.getStr() >= 1 && inputData.getStr() <= 5)) {
        inputData.setIsValid(true);
        inpErrMsg('errRnum', true);   
        return inputData;
    } else {
        inpErrMsg('errRnum', false);
        return inputData;
    }
}

function isValid(xdata, ydata, rdata) {
    isRadioValid(xdata);
    isTextValid(ydata);
    isSelectValid(rdata);
    if (xdata.getIsValid() && ydata.getIsValid() && rdata.getIsValid()) {
        return true;
    }
    return false;
}


function handleAJAX() {
    let xdata = new InputData(document.querySelector('input[name="xcoord"]:checked').value, false);
    let ydata = new InputData(Number($('#ycoord').val()), false);
    let rdata = new InputData(Number($('#rnum').val().replace(",", ".")), false);
    if (isValid(xdata, ydata, rdata)) {
        $.ajax({
            url: "controller",
            method: 'get',
            dataType: 'html',
            cache: false,
            data: {
                'ycoord': ydata.getStr(),
                'xcoord': xdata.getStr(),
                'rnum': rdata.getStr()
            },
            success: function(json) {
                console.log(json);
                const data = JSON.parse(json);
                if (data["hit"] != 2) {
                    let tbody = document.querySelector("#tbody");
                    let template = document.querySelector('#product-row');
                    let clone = template.content.cloneNode(true);
                    let td = clone.querySelectorAll("td");
                    td[0].textContent = xdata.getStr();
                    td[1].textContent = ydata.getStr();
                    td[2].textContent = rdata.getStr();
                    if (data["hit"] == 1) {
                        td[3].textContent = "Попадание!";
                    } else {
                        td[3].textContent = "Промах!";
                    }

                    td[4].textContent = data["completitionTime"];
                    td[5].textContent = data["currentDate"];
                    tbody.appendChild(clone);
                } else {
                    alert("Ответ сервера: Данные некорректны");
                }
            }
        });
        return false;
    } else {
        return false;
    }
}