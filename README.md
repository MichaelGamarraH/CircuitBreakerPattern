# Circuit Breaker con Resilience4j

## 📌 Descripción del proyecto

Este proyecto es un **microservicio desarrollado con Spring Boot 3** que demuestra el uso del **patrón Circuit Breaker** utilizando **Resilience4j**, con el objetivo de **manejar fallos de servicios externos de forma resiliente**.

El servicio expone un endpoint que consume otro microservicio (`product-service`).  
Cuando el servicio externo **no está disponible**, el sistema **no se cae**, sino que responde usando un **fallback**, garantizando disponibilidad y estabilidad.

---

## 🎯 Propósito

El propósito principal del proyecto es:

- Implementar **tolerancia a fallos** en arquitecturas de microservicios.
- Evitar que fallos en servicios externos propaguen errores.
- Demostrar el uso práctico de:
  - `@CircuitBreaker`
  - Métodos de fallback
  - Health Indicators con Spring Actuator
  - Spring AOP
- Visualizar el estado del Circuit Breaker en tiempo real.

---

## 🛠️ Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3.3.5**
- **Spring Web**
- **Spring Actuator**
- **Spring AOP**
- **Resilience4j (Circuit Breaker)**
- **Maven**

---

## 🧱 Arquitectura

El microservicio `user-service` se comunica con `product-service` mediante **RestTemplate**.  
Si `product-service` responde correctamente, se devuelven los productos reales.  
Si ocurre un fallo (timeout, error de conexión, etc.), entra en acción el **Circuit Breaker** y se ejecuta un **método de fallback** que devuelve una lista de productos de respaldo.

---

## ⚙️ Configuración principal (`application.yml`)

```yaml
spring:
  application:
    name: user-service

server:
  port: 8083

management:
  health:
    circuitbreakers:
      enabled: true
  endpoints:
    web:
      exposure:
        include: health
  endpoint:
    health:
      show-details: always

resilience4j:
  circuitbreaker:
    instances:
      userService:
        registerHealthIndicator: true
        failureRateThreshold: 50
        minimumNumberOfCalls: 5
        automaticTransitionFromOpenToHalfOpenEnabled: true
        waitDurationInOpenState: 5s
        permittedNumberOfCallsInHalfOpenState: 3
        slidingWindowSize: 10
        slidingWindowType: COUNT_BASED

