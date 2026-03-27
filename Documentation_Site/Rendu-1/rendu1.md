# Rendu 1 : Analyse et Design IHM

Ce premier rendu se concentre sur l'analyse des besoins utilisateurs et la conception de l'interface graphique (IHM) de l'application **Trackr**.

!!! info "Documents sources"
    Les fichiers originaux sont dans ce dossier.
    
    *   [Rapport IHM (PDF)](Rendu-n1%20IHM%20SAE-1256%20EF-3.pdf)
    *   [Tables fonctionnelles et Scénarios](Tables_fonctionnelles%20et%20Scénarios.docx)

## Analyse des Utilisateurs (Personas)
Nous avons défini des profils types d'utilisateurs pour guider le développement de l'interface :

<p align="center">
  <img src="../Personas1.jpeg" width="45%" style="border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1);" />
  <img src="../Personas2.jpeg" width="45%" style="border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1);" />
</p>

## Architecture et Modèle de Données (UML)

Voici la conception de l'architecture de Trackr sous forme de diagramme UML natif (généré avec Mermaid).

```mermaid
classDiagram
    %% Définition de l'énumération
    class Categorie {
        <<enumeration>>
        SF
        Horreur
        Auteur
    }

    %% Définition des classes principales
    class Media {
        <<abstract>>
        -String titre
        -Date date
        -String realisateur
        +getTitre() String
        +getDate() Date
    }

    class Film {
        -String duree
        +getDuree() String
    }

    class Serie {
        -int nombreEpisodes
        +getNombreEpisodes() int
    }

    class Episode {
        -int numeroDeSaison
        -String duree
        +getDuree() String
    }

    class User {
        -String pseudo
        -String mail
        +getPseudo() String
    }

    class Avis {
        -Date dateDeCreation
        -String commentaire
        -int nombreEtoiles
    }

    class Playlist {
        -String nom
        -Date dateCreation
        -boolean estPrive
    }

    %% Relations entre les classes
    Media <|-- Film : Héritage
    Media <|-- Serie : Héritage
    Media <|-- Episode : Héritage
    
    Media "1" *-- "*" Avis : possède (LesAvis)
    Media --> "1" Categorie : laCategorie
    
    Serie "1" o-- "*" Episode : contient (LesEpisodes)
    
    Film "1" --> "0..1" Film : filmSuivant
    Film "1" --> "0..1" Film : filmPrecedent
    
    Episode "1" --> "0..1" Episode : episodeSuivant
    Episode "1" --> "0..1" Episode : episodePrecedent
    Episode "*" --> "1" Serie : serieMere
    
    User "1" --> "*" Playlist : mesPlaylists
    User "1" --> "*" Avis : sesAvis
    User "*" --> "*" User : follower / suivi
    
    Playlist "*" o-- "*" Media : lesMedias
    Avis "*" --> "1" User : createur
```

---

<p align="right">
  <a href="../../Rendu-2/rendu2/" class="md-button md-button--primary">Passer au Rendu 2 ➔</a>
</p>
