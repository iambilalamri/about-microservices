# ribbon
Ribbon est un équilibreur de charge côté client. Une fois installé, il va pouvoir aller consulter la liste des instances disponibles pour un Microservice pour les choisir à tour de rôle afin d'équilibrer la charge.

# Eureka
Eureka de Netflix remplit précisément cette fonction. Une fois en place, les instances des Microservices viennent s'enregistrer dans le registre d'Eureka. Pour appeler un Microservice, il suffira de piocher dans cette liste d'instances qu'Eureka expose via une API REST.<br/>

Eureka offre un client capable de réaliser des opérations de récupération des listes d'instances.

