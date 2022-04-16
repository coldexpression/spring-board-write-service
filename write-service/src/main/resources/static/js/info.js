// import { Modal } from 'bootstrap'
function showModal(id) {
    const modals = document.querySelectorAll('.modal');
    modals.forEach(function (items) {
        if (items.id === id) {
            modals[id-1].classList.toggle('show');
        }
    })

    // myModal.addEventListener('shown.bs.modal', function () {
    //     myInput.focus()
    // });
}

function closeModal(id) {
    const modals = document.querySelectorAll('.modal');
    modals[id-1].classList.toggle('show');
    // btnClose.addEventListener('click', (event) => {
    //     modal.classList.toggle('show');
    // })

}