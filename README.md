# CompteurAndroid

Application Android de type compteur, réalisée en Kotlin avec Android Studio dans le cadre du TP « Réalisation d'une application compteur ».


## Fonctionnalités

- Affichage d'un titre et de la valeur du compteur (0 au démarrage)
- Bouton **+** : ajoute 1
- Bouton **-** : retire 1
- Bouton **+5** : ajoute 5
- Bouton **-5** : retire 5
- Bouton **Réinitialiser** : remet le compteur à 0 et affiche un Toast « Compteur réinitialisé »

## Améliorations réalisées

- Couleur de la valeur : vert si positive, rouge si négative, noir si nulle
- Boutons +5 et -5
- Toast lors de la réinitialisation
- Conservation de la valeur après rotation de l'écran (`onSaveInstanceState`)
- Blocage du compteur à 0 (option, voir ci-dessous)

## Option : empêcher les valeurs négatives

Dans `MainActivity.kt` :

```kotlin
private val autoriserNegatif = true
```

- `true` : le compteur peut devenir négatif (affiché en rouge)
- `false` : le compteur ne descend jamais sous 0

## Configuration

- Langage : Kotlin
- Modèle : Empty Views Activity
- SDK minimum : API 24
- Package : `com.example.compteurandroid`

## Structure du projet

```
app/src/main/
├── java/com/example/compteurandroid/
│   └── MainActivity.kt
└── res/
    ├── layout/activity_main.xml
    └── values/strings.xml
```

## Identifiants des composants

| Composant | Identifiant |
| --- | --- |
| Titre | `textViewTitre` |
| Valeur du compteur | `textViewCompteur` |
| Bouton + | `buttonIncrementer` |
| Bouton - | `buttonDecrementer` |
| Bouton +5 | `buttonIncrementer5` |
| Bouton -5 | `buttonDecrementer5` |
| Bouton Réinitialiser | `buttonReinitialiser` |

Tous les textes visibles sont déclarés dans `strings.xml`.

## Lancer l'application

1. Ouvrir le dossier du projet dans Android Studio
2. Attendre la fin de la synchronisation Gradle
3. Choisir un émulateur (ou un téléphone connecté)
4. Cliquer sur **Run**

## Tests effectués

- [x] Le compteur affiche 0 au démarrage
- [x] Le bouton + augmente la valeur
- [x] Le bouton - diminue la valeur
- [x] Le compteur peut afficher une valeur négative
- [x] Le bouton Réinitialiser remet la valeur à 0
- [x] Couleurs vert, rouge et noir
- [x] Boutons +5 et -5
- [x] Toast à la réinitialisation
- [x] Valeur conservée après rotation de l'écran

## Capture d'écran

À ajouter : `capture.png`

## Difficultés rencontrées

- Erreur de build `Contenu non autorisé dans le prologue` : texte parasite avant `<?xml` dans `activity_main.xml`
- Boutons +5 et -5 invisibles : contraintes manquantes dans le ConstraintLayout
