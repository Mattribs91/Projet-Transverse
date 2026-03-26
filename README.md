# TRACKR - Projet Transverse

[![coverage report](https://git.iut-orsay.fr/tchass2/s2-sae-dev-app-ef3/badges/feature/maven-migration-trackr/coverage.svg)](https://git.iut-orsay.fr/tchass2/s2-sae-dev-app-ef3/-/pipelines)

Bienvenue sur le dépôt du projet **Trackr**.

## Équipe du projet
- **Charline Percheron**
- **Karen Reboulet**
- **Matthéo Ribeiro**
- **Raphaël Mouatt**
- **Thomas Chassang**

## Liens utiles
- [Documentation Javadoc (en ligne)](https://s2-sae-dev-app-ef3-4d50ba.gitpages.iut-orsay.fr/)
- [Guide de contribution](CONTRIBUTING.md)
- [Historique des versions](CHANGELOG.md)
- [Licence MIT](LICENSE)

## Organisation du projet

- **`Code Java/Trackr/`** : Racine du projet Java (Maven).
  - **`src/`** : Code source de l'application (package `trackr`).
  - **`tests/`** : Tests unitaires de l'application.
  - **`pom.xml`** : Configuration Maven.
- **`Documents et Rendus/`** : Documentation et rapports du projet.

## Installation & Lancement

Ce projet utilise désormais **Maven** pour la gestion des dépendances et la compilation, ce qui simplifie son utilisation sur n'importe quel éditeur de code.

### Configuration Requise
- Java JDK 17+
- Maven 3.8+ (Optionnel si vous utilisez un IDE récent)
- IntelliJ IDEA, Eclipse ou VSCode

### Ouvrir le projet dans IntelliJ IDEA
1. Ouvrez IntelliJ IDEA.
2. Allez dans **File > Open...**.
3. Sélectionnez le fichier **`pom.xml`** situé dans le dossier `Code Java/Trackr/`.
4. Cliquez sur **Open as Project**.
5. IntelliJ configurera automatiquement le projet Java via Maven.

### Ouvrir le projet dans Eclipse
1. Ouvrez Eclipse.
2. Allez dans **File > Import...**.
3. Dépliez le dossier **Maven** et sélectionnez **Existing Maven Projects**.
4. Cliquez sur **Next** et choisissez le dossier `Code Java/Trackr/` dans "Root Directory".
5. Assurez-vous que le fichier `pom.xml` est coché dans la liste.
6. Cliquez sur **Finish**. Eclipse configurera le projet Java automatiquement.

### Compilation & Lancement en ligne de commande (Alternative)
Si vous souhaitez compiler et générer le fichier exécutable vous-même via un terminal :
1. Déplacez-vous dans le dossier du projet : `cd "Code Java/Trackr"`
2. Compilez le projet : `mvn clean package`
3. Lancez le fichier JAR généré : `java -jar target/trackr-app-1.0-SNAPSHOT.jar`

La classe principale (Main) est **`trackr.FactoryMedia`**.