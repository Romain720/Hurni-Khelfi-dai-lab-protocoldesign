# Protocole Client-Serveur

## Connexion
- Client : Se connecte à l'adresse IP `10.191.22.236` et au port `12345`.
- Serveur : Écoute sur le port `12345`.

## Format des Messages
- Requête du Client : `OPERATION nombre1 nombre2`
  - Exemples : `ADD 10 20`, `MULT 5 3`
- Réponse du Serveur : `RESULTAT valeur`
  - Exemples : `RESULTAT 30`, `RESULTAT 15`

## Opérations Supportées
- ADD : Additionne deux nombres.
- MULT : Multiplie deux nombres.

## Flux de Communication
1. Le client se connecte au serveur.
2. Le client envoie une requête au serveur.
3. Le serveur traite la requête et renvoie le résultat.
4. Le client affiche le résultat.
