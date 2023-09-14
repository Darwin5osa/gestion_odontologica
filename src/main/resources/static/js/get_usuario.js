window.addEventListener('load', function () {
    // Al cargar la página, buscamos y obtenemos la tabla donde se mostrarán los usuarios
    const usuariosTable = document.querySelector('#usuariosTable');

    // Al hacer clic en el botón "Listar Usuarios", se ejecutará la siguiente función
    document.querySelector('#btn-listar-usuarios').addEventListener('click', function () {
        // Limpiar la tabla antes de agregar nuevos datos
        usuariosTable.innerHTML = '<thead><tr><th>ID</th><th>Nombre</th><th>Rol</th></tr></thead><tbody></tbody>';

        // Invocamos la API de usuarios con el método GET
        const url = '/usuario';
        const settings = {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
        };

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                // Recorremos la colección de usuarios y agregamos cada usuario a la tabla
                const tbody = usuariosTable.querySelector('tbody');
                data.forEach(usuario => {
                    const row = document.createElement('tr');
                    row.innerHTML = `<td>${usuario.id}</td><td>${usuario.nombre}</td><td>${usuario.rol}</td>`;
                    tbody.appendChild(row);
                });
            })
            .catch(error => {
                console.error(error);
                // Manejar errores si es necesario
            });
