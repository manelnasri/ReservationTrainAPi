Guide d’utilisation de l’API                                 
                        
Les livrables du projet sont : 
* un fichier jar “app-0.0.1-SNAPSHOT” qui comprend tous les fichiers sources et les fichiers de configuration du projet
* un fichier “app-0.0.1-SNAPSHOT-src.zip” qui contient les sources du projet 
* un fichier README.txt décrivant les étapes à suivre pour utiliser l’API 
* un script de peuplement de la base de données H2 (fichier data.sql)
* un script de création de la base de données H2 (fichier schema.sql)
* une documentation complète sous forme de rapport décrivant les choix technologiques, le modèle de données ainsi que les différentes fonctionnalités de l’API.  
Pour lancer l’application : 
1. il faut tout d’abord lancer Consul avec la commande : 
docker run -p 8500:8500 consul


2. lancer l’application avec la commande : 
java -jar "-Dserver.port=8080" app-0.0.1-SNAPSHOT.jar


Pour lancer une deuxième instance de l’application, il suffit de changer le port. Par exemple : 




Pour tester l’application : 
Utiliser l’outil Postman pour lancer des requêtes et tester l’API. 
Des exemples de requêtes sont disponibles dans le Section 4 du rapport. 




Auteur : Manel NASRI, Master 2 MIAGE ACSI