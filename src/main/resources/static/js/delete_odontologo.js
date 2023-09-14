window.addEventListener('load', function () {
function eliminarOdontologo() {
}
    const odontologoId = document.getElementById("odontologoId").value;

    // Realiza una solicitud al servidor para eliminar al odontólogo por su ID
    fetch(`/odontologo/${odontologoId}`, {
        method: 'DELETE'
    })
    .then(response => {
        if (response.status === 204) {
            // Eliminación exitosa
            document.getElementById("mensajeEliminacion").innerHTML = "<div class='alert alert-success'>Odontólogo eliminado con éxito.</div>";
        } else if (response.status === 404) {
            // Odontólogo no encontrado
            document.getElementById("mensajeEliminacion").innerHTML = "<div class='alert alert-danger'>No se encontró el odontólogo con el ID especificado.</div>";
        } else {
            // Otro error
            document.getElementById("mensajeEliminacion").innerHTML = "<div class='alert alert-danger'>Error al eliminar el odontólogo.</div>";
        }
    })
    .catch(error => {
        console.error("Error:", error);
        document.getElementById("mensajeEliminacion").innerHTML = "<div class='alert alert-danger'>Error de conexión al servidor.</div>";
    });
}
