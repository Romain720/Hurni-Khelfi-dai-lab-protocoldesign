# Spécification du Protocole Client-Serveur pour Calculatrice

## 1. Vue d'ensemble
Ce protocole spécifie la communication entre un client et un serveur pour un service de calculatrice basique. Le client peut demander des opérations arithmétiques simples (addition, multiplication, etc.) au serveur, qui effectue les calculs et renvoie les résultats.

## 2. Détails de la Connexion
- **Protocole** : TCP
- **Port** : 5000 (ou tout autre port convenu)

## 3. Format de la Requête
Le client envoie une requête dans le format suivant :
`<OPERATION> <NOMBRE1> <NOMBRE2>`
- **OPERATION** : Type d'opération (`ADD`, `MULT`).
- **NOMBRE1** : Premier opérande (entier).
- **NOMBRE2** : Deuxième opérande (entier).

### Exemples de Requêtes
- Addition : `ADD 4 5`
- Multiplication : `MULT 3 7`

## 4. Format de la Réponse
Le serveur répond avec le résultat du calcul :
`RESULT <VALEUR>`
- **VALEUR** : Résultat de l'opération arithmétique.

### Exemples de Réponses
- Pour `ADD 4 5`, la réponse est `RESULT 9`.
- Pour `MULT 3 7`, la réponse est `RESULT 21`.

## 5. Gestion des Erreurs
Si le format de la requête est incorrect ou si une opération non prise en charge est demandée, le serveur répond avec :
`ERROR Requête Invalide`
