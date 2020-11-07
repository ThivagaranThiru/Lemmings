# Lemmings
 * PROJET 2017/2018	UPEC				THIRUCHELVAM Thivagaran - PIRES Christopher
 * Conception et Programmation Objets
 
Le projet consiste en la réalisation d’un jeu s’inspirant de ”Lemmings”. Le but est de conduire une escouade de lemmings d’une entrée vers la sortie, en ayant le moins de pertes possible. Les lemmings vont tout droit sans réfléchir, mais on peut leur donner des tâches à effectuer (creuser, construire un escalier. . .) pour les protéger et leur permettre d’arriver à la sortie.

Dans ce projet, le jeu se déroule sur une grille de cases. Chaque lemming est positionné sur une case de la grille, une case pouvant contenir plusieurs lemmings. Un lemming possède de plus une direction (gauche ou droite), et se déplace dans cette direction tant que cela est possible. Le lemming tombe s’il n’y a plus rien sous ses pieds, ou change de direction s’il rencontre un obstacle plus grand que lui. Si l’obstacle ne fait qu’une case de hauteur, le lemming monte simplement dessus et continue d’avancer. Les chutes de 5 cases ou plus lui sont mortelles.

Il existe plusieurs “terrains” possibles :

- Les obstacles destructibles par les tunneliers, les foreurs et les bombeurs. Cela inclut :
   - les obstacles destructibles simples ;
   - les obstacles qui explosent les lemmings autour quand ils sont détruits ;
   - les obstacles qui font apparaitre d’autres obstacles sur la grille quand ils sont détruits.
   
- les obstacles indestructibles. Cela inclut :
  - les obstacles indestructibles simples ;
  - les téléporteurs qui envoient les lemmings marchant dessus sur une autre case associée ;
  - la lave qui tue les lemmings marchant dessus.
  - les entrées d’où arrivent un certain nombre de lemmings à une certaine vitesse ;
  - les arrivées retirant les lemmings du plateau en les comptabilisant ;
  - l’air libre (absence d’obstacle).

Le jeu se déroule pas à pas. À chaque pas, les lemmings marcheurs se déplacent tout droit dans leur direction.

Afin de mener les lemmings à bon port, le joueur a la possibilité de leur affecter une tâche parmi les suivantes :

Un Bloqueur s’arrête, et fait faire demi-tour aux les lemmings tentant de le croiser ;
Un Tunnelier creuse les obstacles destructibles devant lui tout en avançant jusqu’à l’air libre ;
Un Foreur creuse dans les obstacles destructibles vers le bas, pendant 5 pas ;
Un Bombeur explose après 3 pas, détruisant les obstacles destructibles sur 2 cases autour de lui ;
Un Charpentier construit un escalier en montant d’une case à chaque pas pendant 5 pas ;
Un Grimpeur peut escalader les parois verticales jusqu’au sommet quelque soit la hauteur ;
Un Parachutiste tombe deux fois moins vite que les autres et survit à sa chute.
 

Le jeu a un peu mal à appliquer les pouvoirs attribués par les clics, il ne faut donc pas hésiter à cliquer plusieurs fois sur la position.
De plus, il est conseillé de cliquer à la position où l'on veut activer le pouvoir jusqu'à l'arrivée du lemming.
