fetch('http://localhost:8080/Gradle___org_example___BookLibrary_1_0_SNAPSHOT_war/books')
    .then(function (response) {
        return response.json();
    })
    .then(function (books) {
        showBookList(books);
    })
    .catch(function (err) {
        console.log('error: ' + err);
    });

function showBookList(books) {
    const mainContainer = document.getElementById("books");
    for (var i = 0; i < books.length; i++) {
        const tr = document.createElement("tr");
        const tdBookName = document.createElement("td");
        tdBookName.innerHTML = books[i].bookName;
        const tdID = document.createElement("td");
        tdID.innerHTML = books[i].serialNumber;


        tr.appendChild(tdBookName)
        tr.appendChild(tdID)
        mainContainer.appendChild(tr)
    }
}