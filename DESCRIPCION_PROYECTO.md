# 📘 Descripción del proyecto: `510_microGstContactosPersona`

## 🎯 Propósito general

Es un **microservicio REST** desarrollado con **Spring Boot 4.1.0** y **Java 21** que se encarga de **gestionar las temáticas (proyectos, campañas, iniciativas) asociadas a una persona o contacto**. Es decir, dada una persona (identificada por un número), devuelve todas las temáticas/proyectos en los que está involucrada.

Su nombre lo deja claro: **"Micro-servicio de Gestión de Contactos-Persona"** (gst = gestion, conper = contactos persona).

## 🏗️ Arquitectura y stack tecnológico

| Aspecto             | Detalle                                                                    |
| ------------------- | -------------------------------------------------------------------------- |
| **Framework**       | Spring Boot 4.1.0 (padre `spring-boot-starter-parent`)                     |
| **Lenguaje**        | Java 21                                                                    |
| **Módulo web**      | `spring-boot-starter-webmvc`                                               |
| **Build**           | Maven (con `mvnw` wrapper)                                                 |
| **Hot reload**      | `spring-boot-devtools` (runtime, opcional)                                 |
| **Puerto**          | `8081` (configurado en `application.properties`)                          |
| **Persistencia**    | **No tiene base de datos**: usa un `HashMap` estático en memoria como "BD"|
| **Pruebas**         | JUnit 5 con `spring-boot-starter-webmvc-test`                              |
| **Repositorio**     | `https://github.com/qualitrain/510_microGstContactosPersona`               |

## 📂 Estructura del código

```
src/main/java/mx/com/qtx/gstconper/
├── Application.java                    # Punto de entrada (@SpringBootApplication)
├── api/
│   ├── ApiController.java              # Controlador REST + manejadores de excepción
│   └── errores/
│       ├── ErrorFormato.java           # Error de formato en URI (clave "INV001")
│       └── ErrorNegocio.java           # Error de reglas de negocio (cód. 10001)
├── core/
│   ├── IGestorTematicas.java           # Interfaz del servicio (contrato)
│   └── NegocioException.java           # Excepción de negocio
├── entidades/
│   └── TematicaPersona.java            # POJO: nomCorto, nombre, numPersona, idTematica
└── servicios/
    └── GestorTematicas.java            # Implementación (@Service) con datos en HashMap
```

## 🔌 API expuesta

### Endpoint principal

```
GET /tematicas/{numPersona}
Content-Type: application/json
```

**Ejemplo:** `GET http://localhost:8081/tematicas/1`

**Respuesta (200 OK):** un arreglo JSON con las temáticas de la persona 1:

```json
[
  {"nomCorto":"Auditoria","nombre":"Auditoría y Gobierno Corporativo","numPersona":1,"idTematica":1},
  {"nomCorto":"Acuario","nombre":"Proyecto Acuario","numPersona":1,"idTematica":2},
  {"nomCorto":"Compras","nombre":"Portal de Compras","numPersona":1,"idTematica":3},
  {"nomCorto":"Servicio","nombre":"Servicio al cliente","numPersona":1,"idTematica":4}
]
```

## ⚙️ Flujo de operación

1. **`Application.java`** arranca el contexto de Spring Boot.
2. **`ApiController`** recibe la petición `GET /tematicas/{numPersona}`.
3. Inyecta el servicio **`IGestorTematicas`** (implementado por `GestorTematicas`).
4. El servicio:
   - Valida si la persona existe (buscando en el `HashMap`).
   - Si **no existe** → lanza `NegocioException.crearExceptionPersonaRequerida(numPersona)`.
   - Si **existe** → filtra y devuelve la lista de temáticas asociadas.
5. **`ApiController`** tiene dos `@ExceptionHandler` que traducen errores a respuestas HTTP:
   - `MethodArgumentTypeMismatchException` (p. ej. `numPersona` no numérico) → **HTTP 406** con `ErrorFormato` (`cveError: "INV001"`).
   - `NegocioException` → **HTTP 406** con `ErrorNegocio` (código `10001` y la regla violada).

## 🗃️ Datos precargados (memoria)

Hay 11 temáticas repartidas en 3 personas (1, 2 y 3), inicializadas en el método estático `crearTematicas()` de `GestorTematicas`. Como el `HashMap` es `static`, los datos se comparten entre todas las peticiones y persisten mientras la aplicación esté viva (se reinician al reiniciar el servicio).

## ✅ Pruebas

`ApplicationTests` contiene un único test generado por Spring Initializr (`@SpringBootTest contextLoads()`) que verifica que el contexto de Spring arranca sin errores. **No hay tests unitarios específicos** del servicio o del controlador (es un buen punto a mejorar).

## 🧩 Patrones y buenas prácticas aplicadas

- **Inversión de dependencias (DIP):** el controlador depende de la interfaz `IGestorTematicas`, no de la implementación.
- **Inyección de dependencias por campo (`@Autowired`):** funcional, aunque el estilo moderno prefiere inyección por constructor.
- **Manejo centralizado de errores** con `@ExceptionHandler` en el controlador, devolviendo DTOs de error tipados.
- **Separación por capas:** `api` (entrada), `core` (contrato/reglas), `entidades` (modelo), `servicios` (lógica).

## 🚀 Cómo se ejecuta

```bash
./mvnw spring-boot:run
```

Luego se invoca: `http://localhost:8081/tematicas/1`

---

## 🧾 Resumen

Es un microservicio didáctico/laboratorio que muestra un API REST mínima pero bien estructurada en Spring Boot, con datos en memoria, sin base de datos, ideal para aprender la separación en capas, inyección de dependencias y manejo de errores HTTP personalizados.
