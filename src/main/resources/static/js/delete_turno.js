function eliminarTurno() {
    const turnoId = document.getElementById("turnoId").value;

    // Realiza una solicitud al servidor para eliminar el turno por su ID
    fetch(`/turno/${turnoId}`, {
        method: 'DELETE'
    })
    .then(response => {
        if (response.status === 204) {
            // Eliminación exitosa
            document.getElementById("mensajeEliminacion").innerHTML = "<div class='alert alert-success'>Turno eliminado con éxito.</div>";
        } else if (response.status === 404) {
            // Turno no encontrado
            document.getElementById("mensajeEliminacion").innerHTML = "<div class='alert alert-danger'>No se encontró el turno con el ID especificado.</div>";
        } else {
            // Otro error
            document.getElementById("mensajeEliminacion").innerHTML = "<div class='alert alert-danger'>Error al eliminar el turno.</div>";
        }
    })
    .catch(error => {
        console.error("Error:", error);
        document.getElementById("mensajeEliminacion").innerHTML = "<div class='alert alert-danger'>Error de conexión al servidor.</div>";
    });
}