window.addEventListener('load', function () {
    // Al cargar la página, buscamos y obtenemos el botón "Eliminar Usuario"
    const btnEliminarUsuario = document.querySelector('#btn-eliminar-usuario');

    // Al hacer clic en el botón "Eliminar Usuario", se ejecutará la siguiente función
    btnEliminarUsuario.addEventListener('click', function () {
        // Obtener el ID del usuario que se va a eliminar (puedes obtenerlo de tu lógica)
        const usuarioId = obtenerIdUsuarioAEliminar(); // Reemplaza con tu lógica para obtener el ID

        // Si no se pudo obtener el ID o si no se desea eliminar el usuario, salimos de la función
        if (!usuarioId || !confirm('¿Estás seguro de que deseas eliminar este usuario?')) {
            return;
        }

        // Invocamos la API de usuarios con el método DELETE para eliminar el usuario
        const url = `/usuario/${usuarioId}`;
        const settings = {
            method: 'DELETE',
        };

        fetch(url, settings)
            .then(response => {
                if (response.status === 204) {
                    // Si la eliminación es exitosa (código de respuesta 204), mostrar mensaje de éxito
                    let successAlert = '<div class="alert alert-success alert-dismissible">' +
                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                        '<strong>Usuario eliminado con éxito</strong></div>';

                    document.querySelector('#response').innerHTML = successAlert;
                    document.querySelector('#response').style.display = "block";
                } else {
                    // Si ocurrió un error al eliminar, mostrar mensaje de error
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                        '<strong>Error al eliminar el usuario</strong></div>';

                    document.querySelector('#response').innerHTML = errorAlert;
                    document.querySelector('#response').style.display = "block";
                }
            })
            .catch(error => {
                console.error(error);
                // Manejar errores si es necesario
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>Error al eliminar el usuario</strong></div>';

                document.querySelector('#response').innerHTML = errorAlert;
                document.querySelector('#response').style.display = "block";
            });
    });

    (function () {
        let pathname = window.location.pathname;
        if (pathname === "/") {
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/usuarioList.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});
