# Usuario Service

Este proyecto es un servicio de gestión de usuarios. Proporciona una API para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en usuarios. Este es uno de los tres microservicios del sistema, junto con `hotel-service` y `calificaciones-service`.

## Requisitos

- Java 11+
- Maven 3.6.3+

## Instalación

1. Clona el repositorio:
    ```bash
    git clone https://github.com/tu-usuario/usuario-service.git
    ```
2. Navega al directorio del proyecto:
    ```bash
    cd usuario-service
    ```
3. Compila el proyecto:
    ```bash
    mvn clean install
    ```

## Uso

Para iniciar el servicio, ejecuta:
```bash
mvn spring-boot:run
```

La API estará disponible en `http://localhost:8080`.

## Endpoints

- `GET /usuarios` - Lista todos los usuarios
- `GET /usuarios/{id}` - Obtiene un usuario por ID
- `POST /usuarios` - Crea un nuevo usuario
- `PUT /usuarios/{id}` - Actualiza un usuario existente
- `DELETE /usuarios/{id}` - Elimina un usuario

## Contribuir

1. Haz un fork del proyecto.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -am 'Añadir nueva funcionalidad'`).
4. Sube tus cambios (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.