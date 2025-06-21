# TransChile Simulador - API de Viajes

Este proyecto simula un sistema de gestión de viajes de transporte de carga para TransChile. Está construido con Java 17 y Spring Boot, y forma parte de una evaluación de prácticas DevOps y CI/CD.

---

## 🚀 Funcionalidades
- Crear un nuevo viaje
- Listar todos los viajes
- Buscar por estado del viaje o de la mercancía
- Eliminar un viaje por ID
- Exposición de métricas vía Actuator

---

## 🔧 Tecnologías
- Java 17 + Spring Boot 3
- Maven
- Spring Web, Lombok, DevTools
- JUnit 5 + MockMvc
- SonarQube + JaCoCo
- Docker
- Jenkins (Declarative Pipeline)
- Actuator para monitoreo

---

## 🛠️ Instalación y ejecución

### 🔨 Construcción del proyecto
```bash
mvn clean package -DskipTests
````

### 🐳 Construcción y ejecución con Docker

```bash
docker build -t transchile-simulador .
docker run -p 8080:8080 transchile-simulador
```

---

## 📫 Endpoints principales

| Método | Endpoint             | Descripción                                   |
| ------ | -------------------- | --------------------------------------------- |
| POST   | `/api/viajes`        | Crear un nuevo viaje                          |
| GET    | `/api/viajes`        | Listar todos los viajes                       |
| GET    | `/api/viajes/buscar` | Filtrar por `estadoViaje` o `estadoMercancia` |
| DELETE | `/api/viajes/{id}`   | Eliminar un viaje por ID                      |
| GET    | `/actuator/health`   | Estado de salud de la app (Actuator)          |

---

## 🧪 Ejemplo de payload para POST

```json
{
  "origen": "Santiago",
  "destino": "Puerto Montt",
  "fechaInicio": "2025-06-20",
  "fechaLlegada": "2025-06-24",
  "estadoViaje": "EN_CURSO",
  "estadoMercancia": "INTEGRA"
}
```

---

## 📋 CI/CD

Este proyecto incluye un `Jenkinsfile` que simula un pipeline completo:

* Checkout
* Test + Coverage (JaCoCo)
* Análisis con SonarQube
* Escaneo de seguridad (Trivy / ZAP simulado)
* Build JAR + Docker
* Despliegue a Staging y Producción (simulado)

---

## 🔒 Seguridad

El escaneo de imágenes Docker se realiza con [Trivy](https://aquasecurity.github.io/trivy/). El pipeline puede ampliarse para escanear también el código fuente (SAST) con herramientas como Semgrep o CodeQL.

---