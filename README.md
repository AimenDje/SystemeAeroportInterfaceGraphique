# ✈️ 🖥️ Aéroport - Interface Graphique des Écrans d’Affichage
Ce projet est la deuxième partie d’un système de gestion d’écrans d’affichage pour un aéroport, cette fois avec une interface graphique (GUI). 
Basé sur le patron de conception Observateur, il simule des écrans dynamiques affichant les départs de vols selon différents niveaux : aéroport, terminaux, et portes d’embarquement — 
mais désormais via des boîtes de dialogue graphiques plutôt qu’une console.

# 🧠 Concepts principaux

Patron Observateur : notification automatique des écrans lorsqu’un vol change.

Réutilisation de l’architecture console : mêmes objets Flight, Gate, Terminal, Airport, mais affichés dans une interface graphique.

GUI avec Java Swing : chaque action utilisateur est faite via des boîtes de dialogue personnalisées (JDialog, JFrame).

Programmation orientée objet en Java : réutilisation, abstraction, héritage.

<h2>📁 Structure du projet</h2>

<pre style="background-color: #f6f8fa; padding: 16px; border-radius: 8px; font-family: 'Courier New', monospace;">
/src
│
├── gui/
│   ├── GuiApp.java              # Point d’entrée principal de l’interface graphique
│   ├── AddFlightDialog.java     # Boîte de dialogue pour ajouter un vol
│   ├── DelayFlightDialog.java   # Boîte de dialogue pour retarder un vol
│   ├── ChangeGateDialog.java    # Boîte pour changer la porte d’un vol
│   ├── CancelFlightDialog.java  # Boîte pour annuler un vol
│   ├── NotifyBoardingDialog.java# Boîte pour notifier l’embarquement
│   ├── RemoveFlightDialog.java  # Boîte pour supprimer un vol
│   ├── ScreenDialog.java        # Classe de base pour l’affichage des écrans 
├── screens/
│   ├── TerminalScreen.java      # Observateur graphique du terminal
│   ├── AirportScreen.java       # Observateur graphique de l’aéroport
│   └── GateScreen.java          # Observateur graphique des portes
│
├── airport/
│   ├── Flight.java              # Représente un vol
│   ├── Gate.java                # Représente une porte d’embarquement
│   ├── Terminal.java            # Représente un terminal
│   └── Airport.java             # Représente l’aéroport au complet
│
├── observer/
│   ├── Observer.java            # Classe abstraite pour les observateurs
│   └── Subject.java             # Classe abstraite pour les sujets observés

</pre>

# ✨ Fonctionnalités

🪄 Toutes les opérations sont accessibles via une interface graphique :

➕ Ajouter un vol

✈️ Retarder un vol

🔁 Changer la porte

📣 Notifier de l’embarquement

❌ Annuler un vol

🗑️ Supprimer un vol

✅ Chaque action met automatiquement à jour les écrans correspondants grâce au patron Observateur.

# 💡 Affichage graphique
Les informations de vol sont affichées dans une boîte de dialogue dédiée à chaque écran :

Écran global de l’aéroport

Écrans de terminaux (A, B, C)

Écrans de portes

## 📌 Informations supplémentaires 

GuiApp.java remplace ConsoleApp.java comme point d’entrée.

Chaque boîte de dialogue hérite de JDialog et suit une convention stricte (AddFlightDialog, DelayFlightDialog, etc.).

ScreenDialog.java est fournie complète – à étudier mais ne pas modifier.

L’interface utilise Swing via l’environnement Codio Virtual Desktop.

Les statuts de vol possibles : "ON TIME", "BOARDING", "DELAYED", "CANCELLED".


# 🛠️ Instructions de compilation et d'exécution

Compiler :
- javac -d bin src/**/*.java

Exécuter :
- Cliquez sur Run GuiApp
