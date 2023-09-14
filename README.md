# Clínica Odontológica - Aplicación Monolítica

Esta es una aplicación monolítica en Java diseñada para administrar una clínica odontológica. Permite la gestión de odontólogos, pacientes, sus domicilios, turnos y usuarios. El sistema cuenta con dos tipos de usuarios: usuarios regulares y administradores.

## Funcionalidades

### Usuarios Users
- Los usuarios regulares tienen acceso limitado y solo pueden manipular los turnos.
- Pueden:
    - Ver sus turnos programados.
    - Reservar un nuevo turno.
    - Cancelar un turno existente.

### Administradores Admins
- Los administradores tienen acceso completo al sistema y pueden realizar todas las funciones de los usuarios regulares, además de administrar el sistema en su totalidad.
- Pueden:
    - Gestionar odontólogos (agregar, editar o eliminar).
    - Gestionar pacientes (agregar, editar o eliminar).
    - Gestionar domicilios de pacientes (agregar, editar o eliminar).
    - Supervisar y modificar los turnos de todos los pacientes.
    - Administrar usuarios (agregar, editar o eliminar cuentas de usuarios regulares o administradores).

## Requisitos del Sistema

Asegúrese de tener instalado lo siguiente antes de ejecutar la aplicación:

- [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html)

## Configuración

1. Clone el repositorio a su máquina local.
2. Configure su base de datos y actualice la configuración de conexión en el archivo de configuración correspondiente.
3. Compile y ejecute la aplicación Java.

```bash
java -jar clinic-odontologica.jar
```
4. Abra su navegador web y vaya a http://localhost:8080 para acceder al sistema.

## Uso

- Inicie sesión con sus credenciales como usuario regular (user) o administrador (admin).
- Explore las opciones disponibles en función de su rol.

## Contribución

Si desea contribuir a este proyecto, siga los pasos a continuación:

1. Haga un fork del repositorio.
2. Cree una rama para su contribución: `git checkout -b feature/nueva-funcion`.
3. Realice sus cambios y asegúrese de que las pruebas sean exitosas.
4. Envíe sus cambios: `git push origin feature/nueva-funcion`.
5. Abra una solicitud de extracción en GitHub.

## Documentación Postman

Para probar las API de esta aplicación, puede utilizar la colección de Postman proporcionada.
Ademas, para disponer de un uso nomal usando basic auth. Se deberá comentar desde la línea 26 a la 29 y descomentar las demas.

## Ejemplos de Usuarios

A continuación se muestran ejemplos de usuarios que puede utilizar para iniciar sesión en la aplicación:

- **Usuario Regular (USER)**
    - Username: agus
    - Contraseña: 0000

- **Administrador (ADMIN)**
    - Username: darwin
    - Contraseña: 0000

## Licencia

Este proyecto está bajo la licencia MIT. Consulte el archivo [LICENSE](LICENSE) para obtener más detalles.

## Contacto

Si tiene alguna pregunta o comentario, no dude en ponerse en contacto con nosotros en [correo@example.com](mailto:correo@example.com).

¡Gracias por usar nuestra aplicación!
