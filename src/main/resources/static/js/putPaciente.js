window.addEventListener('load', function () {
    // Al cargar la página, buscamos y obtenemos el formulario donde estarán
    // los datos que el usuario cargará para actualizar al paciente existente
    const formulario = document.querySelector('#update_paciente');

    // Ante un submit del formulario se ejecutará la siguiente función
    formulario.addEventListener('submit', function (event) {
        event.preventDefault(); // Evitar que el formulario se envíe por defecto

        // Obtener el ID del paciente que se va a actualizar (supongamos que está en algún lugar del formulario)
        const pacienteId = document.querySelector('#id').value;

        // Crear un objeto JSON con los datos para actualizar al paciente y su domicilio
        const formData = {
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            dni: document.querySelector('#dni').value,
            fechaIngreso: document.querySelector('#fechaIngreso').value,
            // Agregar aquí los campos adicionales del paciente según tu DTO

            // Datos de domicilio
            domicilio: {
                calle: document.querySelector('#calle').value,
                numero: document.querySelector('#numero').value,
                ciudad: document.querySelector('#ciudad').value,
                // Agregar aquí más campos de domicilio si es necesario
            }
        };

        // Realizar la solicitud PUT para actualizar el paciente (y su domicilio)
        const putUrl = `/paciente/${pacienteId}`;
        const putSettings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData),
        };

        fetch(putUrl, putSettings)
            .then(response => {
                if (!response.ok) {
                    throw new Error('No se pudo actualizar el paciente');
                }
                return response.json();
            })
            .then(data => {
                // Si no hay ningún error, se muestra un mensaje diciendo que el paciente se actualizó correctamente
                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong></strong> Paciente actualizado </div>';

                document.querySelector('#response').innerHTML = successAlert;
                document.querySelector('#response').style.display = "block";

                // Puedes realizar otras acciones después de actualizar el paciente, como redirigir, etc.
            })
            .catch(error => {
                // Si hay algún error, se muestra un mensaje de error
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong> Error al actualizar el paciente. Intente nuevamente.</strong> </div>';

                document.querySelector('#response').innerHTML = errorAlert;
                document.querySelector('#response').style.display = "block";
            });
    });
});
