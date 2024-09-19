// Get the button element
const transferBtn = document.querySelector('.transfer-btn');

// Add an event listener to the button
transferBtn.addEventListener('click', (e) => {
    // Get the patient ID from the button's data attribute
    const patientId = e.target.getAttribute('data-patient-id');

    // Get the row element
    const row = e.target.parentNode.parentNode;


    const patientData = {
        "id": patientId,
        "firstName": row.cells[1].textContent,
        "lastName": row.cells[2].textContent,
        "DateOfBirth": row.cells[3].textContent,
        "Gender": row.cells[4].textContent,
        "Address": row.cells[5].textContent,
        "Email": row.cells[6].textContent,
        "Transferred": row.cells[7].textContent === 'Transfered'
    };
localStorage.setItem('transferredPatientGoma',JSON.stringify(patientData));
    console.log(patientData);
    // Remove the row from the UI
    row.remove();
});