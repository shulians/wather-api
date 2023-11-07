# Microservicio de Clima

Este microservicio utiliza la API pública de AccuWeather para obtener información del clima y guarda los resultados en una base de datos H2. El servicio se encuentra desployado en Google Cloud (link en la seccion de ejemplos).

## Configuración

1. **Obtén una Clave de API de AccuWeather**

   Regístrate en [AccuWeather Developer](https://developer.accuweather.com/) para obtener una clave de API. Esta clave será necesaria para acceder a la API de AccuWeather.

2. **Configuración del Proyecto**

   - Clona el repositorio:

     ```bash
     git clone https://github.com/shulians/wather-api.git
     cd wather-api
     ```

3. **Ejecución del Proyecto**

   - Ejecuta el proyecto con Maven:

     ```bash
     mvn spring-boot:run
     ```

## Uso del Microservicio
Para información sobre cómo utilizar el microservicio y los endpoints disponibles, consulta la documentación de Swagger (/weather/swagger-ui.html).
La Api se encuentra deployada en Google Cloud, donde se podra ejecutar el servicio en modo de ejemplo.
1. Revisar si la api se encuentra activa: https://whater-project.rj.r.appspot.com/weather/actuator/health/liveness) 
   ```{"status":"UP"}```
2. Ingresar a https://whater-project.rj.r.appspot.com/weather/swagger-ui.html
