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


function getAllMedicines(){
    newRequest("GET", "http://localhost:8080/PharmacyAide/api/medicine/getAllMedicines").then((res) => {
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
                h2.innerText = "Medicine Name";
                let h3 = document.createElement("th");
                h3.innerText = "Stock";
                newTable.appendChild(firstRow);
                firstRow.appendChild(h1);
                firstRow.appendChild(h2);
                firstRow.appendChild(h3);
                headerFlag = true;
            }
            let newRow = document.createElement("tr");
            

            for (let prop in resObj[i]){
                let newCell = document.createElement("td");
                let text1 = document.createTextNode(resObj[i][prop]);
                newCell.appendChild(text1);
                newRow.appendChild(newCell);

            }
            
            newTable.appendChild(newRow);
        }

    }).catch((rej) => {console.log(rej)});
}

function addMedicine(){
    let JSONString = document.getElementById("JSONinput").value;
    console.log(JSONString);
    newRequest("POST", "http://localhost:8080/PharmacyAide/api/medicine/addMedicine", JSONString).then((res) => {
        let createText = document.createElement("p");
        createText.innerText = res.responseText;
        document.getElementById("display").appendChild(createText);
    }).catch((rej) => {console.log(rej)});
}

function deleteMedicine() {
    let x = document.getElementById("IDinput").value;
    newRequest("DELETE", "http://localhost:8080/PharmacyAide/api/medicine/deleteMedicine/" + x).then((res) => {
        let createText = document.createElement("p");
        createText.innerText = res.responseText;
        document.getElementById("display").appendChild(createText);
    }).catch((rej) => {console.log(rej)});
};

function updateMedicine() {
    let x = document.getElementById("IDinput").value;
    let JSONString = document.getElementById("JSONinput").value;
    newRequest("PUT", "http://localhost:8080/PharmacyAide/api/medicine/updateMedicine/" + x, JSONString).then((res) => {
        let createText = document.createElement("p");
        createText.innerText = res.responseText;
        document.getElementById("display").appendChild(createText);
    }).catch((rej) => {console.log(rej)});
}