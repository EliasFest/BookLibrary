const saveBookForm = document.getElementById('saveBookForm');
const deleteBookForm = document.getElementById('deleteBookForm');

async function handleAddForm(event) {
    event.preventDefault();

    const form = event.currentTarget;
    const url = form.action;

    const name = document.getElementById("addFormName").value;
    const number = document.getElementById("addFormNumber").value;

    let book = new Object();
    book.name = name;
    book.number = number;
    let bookJson = JSON.stringify(book)

    try {
        const fetchOptions = {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                Accept: "application/json",
            },
            body: bookJson
        };

        const response = await fetch(url, fetchOptions);

        if (!response.ok) {
            const errorMessage = await response.text();
            throw new Error(errorMessage);
        }
    } catch (error) {
        console.error(error);
    }
}

async function handleDeleteForm(event) {
    event.preventDefault();

    const form = event.currentTarget;
    const number = document.getElementById("deleteFormNumber").value;
    const url = form.action+"/"+number;

    try {
        const fetchOptions = {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json",
                Accept: "application/json",
            }
        };

        const response = await fetch(url, fetchOptions);

        if (!response.ok) {
            const errorMessage = await response.text();
            throw new Error(errorMessage);
        }
    } catch (error) {
        console.error(error);
    }
}

window.addEventListener('load', (event) => {
    saveBookForm.addEventListener("submit", handleAddForm);
    deleteBookForm.addEventListener("submit", handleDeleteForm);
});