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

function getAllConditions(){
    newRequest("GET", "http://35.232.167.206:8888/PharmacyAide/api/condition/getAllConditions").then((res) => {
        let resObj = JSON.parse(res.responseText);
        let arrayLength = resObj.length;

        let newTable = document.createElement("table");
        newTable.className = "table table-bordered";
        document.getElementById("display").appendChild(newTable);

        let headerFlag = false;

        for (let i=0; i<arrayLength; i++){

            if (headerFlag == false){
                let firstRow = document.createElement("tr");
                let h1 = document.createElement("th");
                h1.innerText = "ID";
                let h2 = document.createElement("th");
                h2.innerText = "Condition Name";
                let h3 = document.createElement("th");
                h3.innerText = "Medicine Info"
                newTable.appendChild(firstRow);
                firstRow.appendChild(h1);
                firstRow.appendChild(h2);
                firstRow.appendChild(h3);
                headerFlag = true;
            }
            let newRow = document.createElement("tr");
            

            for (let prop in resObj[i]){
                let newCell = document.createElement("td");
                let text1 = document.createTextNode(JSON.stringify(resObj[i][prop]));
                newCell.appendChild(text1);
                newRow.appendChild(newCell);

            }
            
            newTable.appendChild(newRow);
        }

    }).catch((rej) => {console.log(rej)});
};

function addCondition(){
    let JSONString = document.getElementById("Conditioninput").value;
    let newString = " {conditionName:" + JSONString + "}";
    newRequest("POST", "http://35.232.167.206:8888/PharmacyAide/api/condition/addCondition", newString).then((res) => {
        let createText = document.createElement("p");
        createText.innerText = res.responseText;
        document.getElementById("display").appendChild(createText);
    }).catch((rej) => {console.log(rej)});
}

function deleteACondition() {
    let x = document.getElementById("IDinput").value;
    newRequest("DELETE", "http://35.232.167.206:8888/PharmacyAide/api/condition/deleteCondition/" + x).then((res) => {
        let createText = document.createElement("p");
        createText.innerText = res.responseText;
        document.getElementById("display").appendChild(createText);
    }).catch((rej) => {console.log(rej)});
};

function updateCondition() {
    let x = document.getElementById("IDinput").value;
    let JSONString = document.getElementById("Conditioninput").value;
    let newString = " {conditionName:" + JSONString + "}";
    newRequest("PUT", "http://35.232.167.206:8888/PharmacyAide/api/condition/updateCondition/" + x, newString).then((res) => {
        let createText = document.createElement("p");
        createText.innerText = res.responseText;
        document.getElementById("display").appendChild(createText);
    }).catch((rej) => {console.log(rej)});
}


