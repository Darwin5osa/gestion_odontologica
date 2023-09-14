window.addEventListener('load', function () {
    // Al cargar la página, buscamos y obtenemos el formulario de actualización de usuario
    const formulario = document.querySelector('#update_usuario_form');

    // Al hacer clic en el botón "Actualizar Usuario", se ejecutará la siguiente función
    formulario.addEventListener('submit', function (event) {
        event.preventDefault(); // Evitar el envío del formulario

        // Obtener el ID del usuario a actualizar desde el formulario
        const usuarioId = document.querySelector('#usuarioId').value;

        // Crear un objeto JSON con los datos actualizados del usuario
        const formData = {
            nombre: document.querySelector('#nombre').value,
            rol: document.querySelector('#rol').value,
        };

        // Invocamos la API de usuarios con el método PUT para actualizar el usuario
        const url = `/usuario/${usuarioId}`;
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData),
        };

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                // Si la actualización es exitosa, mostrar un mensaje de éxito
                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>Usuario actualizado</strong></div>';

                document.querySelector('#response').innerHTML = successAlert;
                document.querySelector('#response').style.display = "block";
            })
            .catch(error => {
                console.error(error);
                // Manejar errores si es necesario
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>Error al actualizar el usuario</strong></div>';

