# Guide de contribution

Bienvenue sur notre projet Trackr ! Pour que le projet reste propre et organisé, merci de suivre ces quelques règles.

## Branches
- Ne travaillez jamais directement sur le `main` sauf pour de petites modifications.
- Créez une branche pour chaque tâche : `feature/nom-tache`, `bugfix/nom-bug` ou `docs/nom-modif`.

## Commits
- Utilisez des messages de commit clairs en français ou anglais.
- **Liez vos tickets** : Mentionnez le numéro de l'issue dans votre message pour créer un lien automatique sur GitLab.
  - Pour fermer l'issue automatiquement : `(Fixes #12) ajout de la gestion des avis`
  - Pour simplement lier l'issue sans la fermer : `(Refs #12) ajout de la gestion des avis`.

## Merge Requests (MR)
- Une fois votre travail terminé, ouvrez une Merge Request vers `main`.
- Attendez qu'au moins un autre membre du groupe relise et approuve votre code.
- Vérifiez que le pipeline CI/CD passe au vert avant de fusionner.

## Qualité du code
- Respectez les conventions Java (CamelCase, Javadoc pour les méthodes publiques).
- Votre éditeur doit normalement utiliser la configuration du fichier `.editorconfig`.
