# Microservicio de Clima

Este microservicio utiliza la API pública de AccuWeather para obtener información del clima y guarda los resultados en una base de datos H2.

## Configuración

1. **Obtén una Clave de API de AccuWeather**

   Regístrate en [AccuWeather Developer](https://developer.accuweather.com/) para obtener una clave de API. Esta clave será necesaria para acceder a la API de AccuWeather.

2. **Configuración del Proyecto**

   - Clona el repositorio:

     ```bash
     git clone https://github.com/shulians/wather-api.git
     cd wather-api
     ```

   - Abrir el archivo `src/main/resources/application.properties` y configura la clave de la API de AccuWeather:

     ```properties
     # application.properties

     accuweather.api.key=[TuClaveDeAPIAccuWeather]
     ```

3. **Ejecución del Proyecto**

   - Ejecuta el proyecto con Maven:

     ```bash
     mvn spring-boot:run
     ```

   El microservicio estará disponible en `http://localhost:8085`.

## Uso del Microservicio

### Obtener Clave de Ubicación

```http
GET http://localhost:8085/weather/location?localizedName=Luis%20Guillon