Agenda de Contactos
Esta aplicación permite gestionar una lista de contactos, permitiendo crear, editar y eliminar registros. La interfaz de usuario está desarrollada con Angular 17, mientras que el backend se implementa con Spring Boot Java utilizando una base de datos H2.

Características Principales
Frontend: Desarrollado con Angular 17, proporcionando una interfaz amigable para interactuar con la lista de contactos.
Backend: Implementado con Spring Boot Java, ofreciendo endpoints RESTful para operaciones CRUD sobre los contactos.
Base de Datos: Utiliza H2 como sistema de gestión de bases de datos relacional en memoria, ideal para desarrollo y pruebas.
Requisitos Técnicos
Java JDK 11 o superior
Angular CLI
Maven
Navegador web moderno
Instalación y Ejecución
Backend
Clonar el repositorio.
Abrir la terminal en la carpeta del proyecto backend.
Ejecutar el siguiente comando Maven para construir el proyecto:
mvn clean install
Ejecutar el siguiente comando Maven para iniciar la aplicación Spring Boot:
mvn spring-boot:run
Frontend
Abrir la terminal en la carpeta del proyecto frontend.
Instalar las dependencias ejecutando:
npm install
Iniciar la aplicación Angular ejecutando:
ng serve
Acceder a la aplicación a través de un navegador web en la dirección http://localhost:4200.
Uso
La aplicación permite realizar las siguientes operaciones:

Listar Contactos: Muestra todos los contactos disponibles.
Crear Contacto: Permite ingresar un nuevo contacto con nombre, apellido, número de teléfono y correo electrónico.
Editar Contacto: Modifica los detalles de un contacto existente.
Eliminar Contacto: Remueve un contacto de la lista.
Endpoints API
Los endpoints disponibles para interactuar con la API son los siguientes:

GET /api/contacts: Lista todos los contactos.
GET /api/contacts/{id}: Obtiene un contacto específico por ID.
POST /api/contacts: Crea un nuevo contacto.
PUT /api/contacts/{id}: Actualiza los detalles de un contacto existente por ID.
DELETE /api/contacts/{id}: Elimina un contacto específico por ID.
Manejo de Errores
La aplicación maneja errores de validación y excepciones lanzando respuestas HTTP adecuadas y mensajes descriptivos.

Contribuciones
Las contribuciones son bienvenidas. Para contribuir, siga estos pasos:

Fork del repositorio.
Cree su branch de desarrollo (git checkout -b feature/fooBar).
Realice sus cambios y pruebas.
Envíe su pull request.
Licencia
Este proyecto está bajo la licencia MIT. Consulte el archivo LICENSE para más detalles.