# Spring Boot - Kafka Messaging Producer

## Requerimientos
- Java v11+
- Maven v3.8.3+
- Docker v20.10.21+
- Docker-Compose plugin v2.12.2+
- Kafka v2.8.1+ (se anexa docker-compose.yml)

## Instalación / Ejecución
Se debe instalar o tener algún servidor de Kafka en ejecución, en la clase `KafkaConfiguration` se pueden realizar 
modificaciones para ajustar los parámetros de la conexión, según las necesidades.

Se anexa un archivo docker-compose.yml con un servidor de kafka/zookeeper para levantar dos contenedores, para ejecutar 
las líneas de este compose, debemos ir a la carpeta donde se encuentra el archivo yml:
```
$ docker compose up -d
```
y esperamos a que los comoponentes levanten completamente.

Para levantar este proyecto de Spring Boot, vamos a la carpeta del proyecto y por medio de Maven:
```
$ mvn spring-boot:run
```

## Descripción
Esta prueba de concepto encola mensajes de tipo JSON a un tópico arbitrario `kafka-topic` de Kafka, el cual se puede ver
en el archivo de configuraciones `KafkaConfiguration` donde además se pueden ver otras configuraciones de kafka y el host.

El punto de partida en este PoC se encuentra en la clase `AppRunner`, la cual está configurada como un Command Line Runner
de Spring Boot, por lo que se obvian otros componentes.

El `AppRunner` realiza un llamado al servicio `MessagingService` el cual contiene la lógica de negocio suficiente para
envolver el mensaje en formato JSON (por medio de la interfaz `MessageMarshalling`) y encolarlo al tópico de Kafka por 
medio de la interfaz `Sender`. Como `KafkaSender` es la única implementación disponible, entonces `Sender` la ocupará.

Si se generó un contenedor de Docker Kafka/Zookeeper, para visualizar los mensajes que se ejecutan en Kafka:

```
$ docker exec -it kafka bash
```
```
# kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic kafka-topic --from-beginning
```

El comando anterior mostrará los mensajes encolados en Kafka desde el primero hasta el más actual. Remover el parámetro
`--from-beginning` mostrará sólo los nuevos mensajes que se vayan generando.

### Fuentes

https://docs.spring.io/spring-kafka/reference/html/#sending-messages
https://www.conduktor.io/kafka/kafka-cli-tutorial
https://www.baeldung.com/spring-kafka