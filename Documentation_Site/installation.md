# Installation et Utilisation

Ce guide vous explique comment configurer votre environnement de développement pour travailler sur Trackr.

## Configuration Requise
- Java JDK 17
- Maven 3.8+ (inclus dans la plupart des IDE modernes)

## Ouvrir le projet dans un IDE

=== "IntelliJ IDEA"

    1. Ouvrez IntelliJ.
    2. Allez dans **File > Open...**.
    3. Sélectionnez le fichier **`pom.xml`** dans le dossier `Code Java/Trackr/`.
    4. Cliquez sur **Open as Project**.

=== "Eclipse"

    1. Ouvrez Eclipse.
    2. Allez dans **File > Import...**.
    3. Choisissez **Maven > Existing Maven Projects**.
    4. Sélectionnez le dossier `Code Java/Trackr/` comme répertoire racine.
    5. Cliquez sur **Finish**.

## Compilation et Lancement (Ligne de commande)

Si vous préférez utiliser un terminal :

1.  **Se déplacer dans le projet** :
    ```bash
    cd "Code Java/Trackr"
    ```
2.  **Compiler et générer le JAR** :
    ```bash
    mvn clean package
    ```
3.  **Lancer l'application** :
    ```bash
    java -jar target/trackr-app-1.0-SNAPSHOT.jar
    ```
