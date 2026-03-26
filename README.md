# TRACKR - Projet Transverse

[![pipeline status](https://git.iut-orsay.fr/tchass2/s2-sae-dev-app-ef3/badges/main/pipeline.svg)](https://git.iut-orsay.fr/tchass2/s2-sae-dev-app-ef3/-/commits/main)

Bienvenue sur le dépôt du projet **Trackr**.

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

### Ouvrir le projet dans IntelliJ IDEA ou Eclipse
1. Ouvrez votre IDE.
2. Allez dans **File > Open...** (ou **Import...**).
3. Sélectionnez le fichier **`pom.xml`** (situé dans `Code Java/Trackr/pom.xml`).
4. Choisissez **Open as Project** (ou importer comme projet Maven).
L'IDE s'occupera automatiquement de télécharger les librairies (JUnit) et de configurer le projet pour vous !

### Compilation & Lancement en ligne de commande (Alternative)
Si vous souhaitez compiler et générer le fichier exécutable vous-même via un terminal :
1. Déplacez-vous dans le dossier du projet : `cd "Code Java/Trackr"`
2. Compilez le projet : `mvn clean package`
3. Lancez le fichier JAR généré : `java -jar target/trackr-app-1.0-SNAPSHOT.jar`

La classe principale (Main) est **`trackr.FactoryMedia`**.