# Ribbon
Ribbon est un équilibreur de charge côté client. Une fois installé, il va pouvoir aller consulter la liste des instances disponibles pour un Microservice pour les choisir à tour de rôle afin d'équilibrer la charge.

# Eureka
Eureka de Netflix remplit précisément cette fonction. Une fois en place, les instances des Microservices viennent s'enregistrer dans le registre d'Eureka. Pour appeler un Microservice, il suffira de piocher dans cette liste d'instances qu'Eureka expose via une API REST.<br/>

Eureka offre un client capable de réaliser des opérations de récupération des listes d'instances.

# Zuul
un service qualifiable de “point d’entrée” permettant de faire du proxy inverse au sein d’une application. Il se place donc en entrée de l’architecture et permet de réaliser des opérations avant de transmettre la requête aux services et sur leur retour

# RabbitMQ
RabbitMQ est un système permettant de gérer des files de messages afin de permettre à différents clients de communiquer très simplement. Pour que chaque client puisse communiquer avec RabbitMQ, celui-ci s’appuie sur le protocole AMQP. Ce protocole définit précisément la façon dont vont communiquer les différents clients avec RabbitMQ

# Feign
Feign est un client HTTP qui facilite grandement l'appel des API exposées par les différents Microservices. Il est donc capable de créer et d'exécuter des requêtes HTTP basées sur les annotations et informations que l'on fournit. C'est un peu l'équivalent en code de Postman.<br/>

Il se présente sous forme de dépendance à ajouter au Microservice.

# Circuit breaker
Un circuit breaker est un dispositif qui permet d’isoler momentanément une application des problèmes de ses dépendances externes. Son rôle est de couper (court-circuiter) les appels vers un service distant quand celui-ci est indisponible ou répond lentement.

# Hystrix
Hystrix est une API open source développée par Netflix qui implémente le pattern circuit breaker.<br/>
Le but d'Hystrix est de rendre une application résiliente aux pannes de ses dépendances externes en arrêtant momentanément de les invoquer le temps de leur indisponibilité