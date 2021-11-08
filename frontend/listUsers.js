fetch('http://localhost:8080/Gradle___org_example___BookLibrary_1_0_SNAPSHOT_war/users')
    .then(function (response) {
        return response.json();
    })
    .then(function (users) {
        showUserList(users);
    })
    .catch(function (err) {
        console.log('error: ' + err);
    });

function showUserList(users) {
    const mainContainer = document.getElementById("users");
    for (var i = 0; i < users.length; i++) {
        const tr = document.createElement("tr");
        const tdUserName = document.createElement("td");
        tdUserName.innerHTML = users[i].userName;
        const tdID = document.createElement("td");
        tdID.innerHTML = users[i].userNumber;



        tr.appendChild(tdUserName)
        tr.appendChild(tdID)
        mainContainer.appendChild(tr)
    }
}