# Gestion de Tickets avec Spring Boot

Ce projet est une application de gestion de tickets développée en Java avec Spring Boot. L'application permet aux utilisateurs de créer, lire, mettre à jour, affecter et supprimer des tickets. Chaque ticket possède un titre, une description, un utilisateur assigné et un statut (en cours, terminé, annulé).

## Technologies utilisées
- Java
- Spring Boot
- Spring Data JPA
- Spring Security
- H2 Database pour la base embarquée
- JUnit et Mockito pour les tests
- OpenAPI (Swagger) pour la documentation

## Comment exécuter l'application
- Aller sur http://localhost:9090/swagger-ui.html' en s'authentifiant avec user/password pour retrouver la documentation de l'api

## Endpoints REST
- GET /api/users: Récupérer tous les utilisateurs
- GET /api/users/{id}/ticket: Récupérer les tickets assignés à l'utilisateur
- POST /api/users: Créer un utilisateur
- PUT /api/users/{id}: Modifier un utilisateur
- GET /api/tickets: Récupérer tous les tickets
- GET /api/tickets/{id}: Récupérer un ticket par son ID
- POST /api/tickets: Créer un nouveau ticket
- PUT /api/tickets/{id}: Mettre à jour un ticket existant
- PUT /api/tickets/{id}/assign/{useId}: Assigner un ticket à un utilisateur
- DELETE /api/tickets/{id}: Supprimer un ticket par son ID

## Auteur
christinandyzo

N'hésitez pas à contribuer en ouvrant des issues ou des pull requests.

Merci d'utiliser notre application de gestion de tickets !
