# Spécification du Protocole Client-Serveur pour Calculatrice

## 1. Vue d'ensemble
Ce protocole spécifie la communication entre un client et un serveur pour un service de calculatrice basique. Le client peut demander des opérations arithmétiques simples (addition, multiplication, etc.) au serveur, qui effectue les calculs et renvoie les résultats.

## 2. Détails de la Connexion
- **Réseau** : il faut faire un partage de connexion ou être sur une autre réseau, car celui de la HEIG-VD, bloque les commandes ncat
- **Protocole** : TCP
- **Port** : 5000 (ou tout autre port convenu)
- **IP** : Dépend du PC, l'IP peut changer à cause du DHCP.
- **Commande  pour se mettre à l'écoute côté serveur:** nc -kl 5000
- **Commande  pour se mettre à l'écoute côté client:** nc [adresse_IP_du_serveur] 5000


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

## 6. Quitter la console:
On peut quitter la console, le client peut faire: CTRL + C ou envoyer la commande quit.
