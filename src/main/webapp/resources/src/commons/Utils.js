export const showError = error => {
    let msgError = "Ha ocurrido un error";
    if (error) {
        if (typeof error === 'string') {
            msgError += `: ${error}`;
        } else if (error.statusText) {
            msgError += `: ${error.statusText}`;
        }
    }
    document.getElementById("modalMessageContent").textContent = msgError;
    $('#modalMessage').modal('show');
};
