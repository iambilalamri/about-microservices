# ribbon
Ribbon est un �quilibreur de charge c�t� client. Une fois install�, il va pouvoir aller consulter la liste des instances disponibles pour un Microservice pour les choisir � tour de r�le afin d'�quilibrer la charge.

# Eureka
Eureka de Netflix remplit pr�cis�ment cette fonction. Une fois en place, les instances des Microservices viennent s'enregistrer dans le registre d'Eureka. Pour appeler un Microservice, il suffira de piocher dans cette liste d'instances qu'Eureka expose via une API REST.<br/>

Eureka offre un client capable de r�aliser des op�rations de r�cup�ration des listes d'instances.

