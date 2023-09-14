window.addEventListener('load', function () {
    // Al cargar la página, buscamos y obtenemos el formulario donde estarán
    // los datos que el usuario cargará del nuevo usuario
    const formulario = document.querySelector('#crear-usuario-form');

    // Ante un submit del formulario se ejecutará la siguiente función
    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

        // Creamos un JSON que tendrá los datos de un nuevo usuario
        const formData = {
            nombre: document.querySelector('#nombre').value,
            rol: document.querySelector('#rol').value,
            // Otros campos si es necesario
        };

        // Invocamos utilizando la función fetch la API de usuarios con el método POST
        // que guardará el nuevo usuario que enviaremos en formato JSON
        const url = '/usuario';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        };

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                // Si no hay ningún error, se muestra un mensaje diciendo que el usuario
                // se agregó correctamente
                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>Usuario agregado</strong> </div>';

                document.querySelector('#response').innerHTML = successAlert;
                document.querySelector('#response').style.display = "block";
                resetUploadForm();
            })
            .catch(error => {
                // Si hay algún error, se muestra un mensaje de error y se sugiere intentarlo nuevamente
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>Error: intente nuevamente</strong> </div>';

                document.querySelector('#response').innerHTML = errorAlert;
                document.querySelector('#response').style.display = "block";
            });
    });

    function resetUploadForm() {
        document.querySelector('#nombre').value = "";
        document.querySelector('#rol').value = "";
        // Resto de los campos si es necesario
    }

    (function () {
        let pathname = window.location.pathname;
        if (pathname === "/") {
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/usuarioList.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});
