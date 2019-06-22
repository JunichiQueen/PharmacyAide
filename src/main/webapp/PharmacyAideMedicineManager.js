function newRequest(method, url, body) {
    return new Promise((res, rej) => {
        let req = new XMLHttpRequest;
        req.onload = () => {
            if (req.status == 200) {
                res(req)
            } else {
                rej('Fail');
            }

        }
        req.open(method, url);
        req.send(body);

    }

    );
};




function addCondition(){
    let JSONString = document.getElementById("Conditioninput").value;
    let newString = " {conditionName:" + JSONString + "}";
    newRequest("POST", "http://35.222.149.127:8888/PharmacyAide/api/condition/addCondition", newString).then((res) => {
        let createText = document.createElement("p");
        createText.innerText = res.responseText;
        document.getElementById("display").appendChild(createText);
    }).catch((rej) => {console.log(rej)});
};

function deleteACondition() {
    let x = document.getElementById("conIDinput").value;
    newRequest("DELETE", "http://35.222.149.127:8888/PharmacyAide/api/condition/deleteCondition/" + x).then((res) => {
        let createText = document.createElement("p");
        createText.innerText = res.responseText;
        document.getElementById("display").appendChild(createText);
    }).catch((rej) => {console.log(rej)});
};

function updateCondition() {
    let x = document.getElementById("conIDinput").value;
    let JSONString = document.getElementById("Conditioninput").value;
    let newString = " {conditionName:" + JSONString + "}";
    newRequest("PUT", "http://35.222.149.127:8888/PharmacyAide/api/condition/updateCondition/" + x, newString).then((res) => {
        let createText = document.createElement("p");
        createText.innerText = res.responseText;
        document.getElementById("display").appendChild(createText);
    }).catch((rej) => {console.log(rej)});
};

function addMedicine(){
    let conditionID = document.getElementById("conIDinput2").value;
    console.log(conditionID);
    let stock = document.getElementById("stock").value;
    console.log(stock);
    let newPath = conditionID + "/" + stock;
    console.log(newPath);
    let drugName = document.getElementById("druginput").value;
    let newString = " {drugName:" + drugName + "}";
    newRequest("POST", "http://35.222.149.127:8888/PharmacyAide/api/medicine/addMedicine/" + newPath, newString).then((res) => {
        let createText = document.createElement("p");
        createText.innerText = res.responseText;
        document.getElementById("display").appendChild(createText);
    }).catch((rej) => {console.log(rej)});
}

function deleteMedicine() {
    let x = document.getElementById("medIDinput").value;
    newRequest("DELETE", "http://35.222.149.127:8888/PharmacyAide/api/medicine/deleteMedicine/" + x).then((res) => {
        let createText = document.createElement("p");
        createText.innerText = res.responseText;
        document.getElementById("display").appendChild(createText);
    }).catch((rej) => {console.log(rej)});
};

function updateMedicine() {
    let x = document.getElementById("medIDinput").value;
    let drugName = document.getElementById("druginput").value;
    let newString = " {drugName:" + drugName + "}";
    newRequest("PUT", "http://35.222.149.127:8888/PharmacyAide/api/medicine/updateMedicine/" + x, newString).then((res) => {
        let createText = document.createElement("p");
        createText.innerText = res.responseText;
        document.getElementById("display").appendChild(createText);
    }).catch((rej) => {console.log(rej)});
}
