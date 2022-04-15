// import { Modal } from 'bootstrap'
function showModal() {
    const body = document.querySelector('body');
    const modal = document.querySelector('.modal');
    modal.classList.toggle('show');

    if(modal.classList.contains('show')) {
        body.style.overflow = 'hidden';
    }
    // myModal.addEventListener('shown.bs.modal', function () {
    //     myInput.focus()
    // });
}

function closeModal() {
    const body = document.querySelector('body');
    const modal = document.querySelector('.modal');
    const btnClose = document.querySelector('.btn-modal-close');
    btnClose.addEventListener('click', (event) => {
        modal.classList.toggle('show');
    })
    body.style.overflow = 'auto';
}