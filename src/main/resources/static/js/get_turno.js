window.addEventListener('load', function () {
    // Fetch data from the API for "turno"
    const url = '/turno'; // Replace with the correct URL for fetching turnos
    const settings = {
        method: 'GET'
    };

    fetch(url, settings)
        .then(response => response.json())
        .then(data => {
            // Get the table element
            var table = document.getElementById("turnoTable"); // Update table ID as needed

            // Iterate over the data and create rows for each turno
            for (const turno of data) {
                let tr_id = 'tr_' + turno.id;
                var turnoRow = table.insertRow();
                turnoRow.id = tr_id;

                // Create cells for each data field
                turnoRow.innerHTML = '<td class="td_nombre">' + turno.fecha.toUpperCase() + '</td>' +
                    '<td class="td_apellido">' + turno.pacienteId.toUpperCase() + '</td>' +
                    '<td class="td_fechaIngreso">' + turno.odontologoList.toUpperCase() + '</td>' +

            }
        });

    // Add 'active' class to the last nav item if pathname is "/odontologoList.html"
    (function () {
        let pathname = window.location.pathname;
        if (pathname === "/turnoList.html") {
            document.querySelector(".nav .nav-item:last-child a").classList.add("active");
        }
    });
});
