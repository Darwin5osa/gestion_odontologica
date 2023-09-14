window.addEventListener('load', function () {
    // Al cargar la página, buscamos y obtenemos el formulario donde estarán
    // los datos que el usuario actualizará del turno
    const formulario = document.querySelector('#update_turno');

    // Ante un submit del formulario se ejecutará la siguiente función
    formulario.addEventListener('submit', function (event) {
        // Prevenir el comportamiento predeterminado del formulario
        event.preventDefault();

        // Obtener los datos del formulario
        const turnoId = document.querySelector('#turnoId').value; // Id del turno a actualizar
        const odontologoId = document.querySelector('#odontologoSelect').value;
        const pacienteId = document.querySelector('#pacienteSelect').value;
        // También puedes obtener otros datos del formulario según sea necesario

        // Crear un objeto formData que coincida con la estructura de la entidad Turno
        const formData = {
            id: turnoId, // Id del turno a actualizar
            fecha: new Date(), // Debes establecer la fecha de alguna manera (por ejemplo, nueva fecha actual)
            paciente: { id: pacienteId },
            odontologo: { id: odontologoId }
            // Añadir otros atributos de Turno según sea necesario
        };

        // Invocamos la API de turnos con el método PUT que actualizará el turno que enviaremos en formato JSON
        const url = '/turno/' + turnoId; // Reemplaza con la URL correcta para actualizar un turno
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        };

        fetch(url, settings)
            .then(response => {
                return response.json();
            })
            .then(data => {
                // Si no hay ningún error, muestra un mensaje diciendo que el turno se actualizó correctamente
                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>Turno actualizado correctamente.</strong></div>';

                document.querySelector('#response').innerHTML = successAlert;
                document.querySelector('#response').style.display = "block";
                resetUpdateForm();
            })
            .catch(error => {
                // Si hay algún error, muestra un mensaje diciendo que el turno no se pudo actualizar y se debe intentar nuevamente
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>Error, inténtelo nuevamente.</strong></div>';

                document.querySelector('#response').innerHTML = errorAlert;
                document.querySelector('#response').style.display = "block";
            });
    });

    function resetUpdateForm() {
        // Aquí puedes resetear los campos del formulario de actualización o hacer cualquier otra acción necesaria
    }

    (function () {
        let pathname = window.location.pathname;
        if (pathname === "/") {
            document.querySelector(".nav .nav-item a:first").classList.add("active");
        } else if (pathname == "/turnoList.html") {
            document.querySelector(".nav .nav-item a:last").classList.add("active");
        }
    })();
});
