# Ribbon
Ribbon est un �quilibreur de charge c�t� client. Une fois install�, il va pouvoir aller consulter la liste des instances disponibles pour un Microservice pour les choisir � tour de r�le afin d'�quilibrer la charge.

# Eureka
Eureka de Netflix remplit pr�cis�ment cette fonction. Une fois en place, les instances des Microservices viennent s'enregistrer dans le registre d'Eureka. Pour appeler un Microservice, il suffira de piocher dans cette liste d'instances qu'Eureka expose via une API REST.<br/>

Eureka offre un client capable de r�aliser des op�rations de r�cup�ration des listes d'instances.

# Zuul
un service qualifiable de �point d�entr�e� permettant de faire du proxy inverse au sein d�une application. Il se place donc en entr�e de l�architecture et permet de r�aliser des op�rations avant de transmettre la requ�te aux services et sur leur retour

# RabbitMQ
RabbitMQ est un syst�me permettant de g�rer des files de messages afin de permettre � diff�rents clients de communiquer tr�s simplement. Pour que chaque client puisse communiquer avec RabbitMQ, celui-ci s�appuie sur le protocole AMQP. Ce protocole d�finit pr�cis�ment la fa�on dont vont communiquer les diff�rents clients avec RabbitMQ

# Feign
Feign est un client HTTP qui facilite grandement l'appel des API expos�es par les diff�rents Microservices. Il est donc capable de cr�er et d'ex�cuter des requ�tes HTTP bas�es sur les annotations et informations que l'on fournit. C'est un peu l'�quivalent en code de Postman.<br/>

Il se pr�sente sous forme de d�pendance � ajouter au Microservice.

# Circuit breaker
Un circuit breaker est un dispositif qui permet d�isoler momentan�ment une application des probl�mes de ses d�pendances externes. Son r�le est de couper (court-circuiter) les appels vers un service distant quand celui-ci est indisponible ou r�pond lentement.

# Hystrix
Hystrix est une API open source d�velopp�e par Netflix qui impl�mente le pattern circuit breaker.<br/>
Le but d'Hystrix est de rendre une application r�siliente aux pannes de ses d�pendances externes en arr�tant momentan�ment de les invoquer le temps de leur indisponibilit�