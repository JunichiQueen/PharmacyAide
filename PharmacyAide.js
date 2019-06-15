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
    newRequest("GET", "http://localhost:8080/PharmacyAide/api/condition/getAllConditions").then((res) => {
        let createText = document.createElement("p");
        createText.innerText = res.responseText;
        document.getElementById("display").appendChild(createText);
    }).catch((rej) => {console.log(rej)});
};

function deleteACondition() {
    let x = document.getElementById("input").value;
    newRequest("DELETE", "http://localhost:8080/PharmacyAide/api/condition/deleteCondition/" + x).then((res) => {
        let createText = document.createElement("p");
        createText.innerText = res.responseText;
        document.getElementById("display").appendChild(createText);
    }).catch((rej) => {console.log(rej)});
};