function eliminarPaciente() {
    const pacienteId = document.getElementById("pacienteId").value;

    // Realiza una solicitud al servidor para eliminar al paciente por su ID
    fetch(`/paciente/${pacienteId}`, {
        method: 'DELETE'
    })
    .then(response => {
        if (response.status === 204) {
            // Eliminación exitosa
            document.getElementById("mensajeEliminacion").innerHTML = "<div class='alert alert-success'>Paciente eliminado con éxito.</div>";
        } else if (response.status === 404) {
            // Paciente no encontrado
            document.getElementById("mensajeEliminacion").innerHTML = "<div class='alert alert-danger'>No se encontró al paciente con el ID especificado.</div>";
        } else {
            // Otro error
            document.getElementById("mensajeEliminacion").innerHTML = "<div class='alert alert-danger'>Error al eliminar al paciente.</div>";
        }
    })
    .catch(error => {
        console.error("Error:", error);
        document.getElementById("mensajeEliminacion").innerHTML = "<div class='alert alert-danger'>Error de conexión al servidor.</div>";
    });
}