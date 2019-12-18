# Loup Garou UHC

## Règles pour les joueurs

- Tout type de minage
- Pas de cheat
- Streamhack non toléré
- Ne pas voter pour la personne qui vient d'être votée, il est cependant possible de voter plusieurs fois pour la même personne si celle-ci n'a pas pris les votes lors du précédant vote
- Plugin Mumble nécessaire
- Ne pas volontairement révéler son rôle (Le dire ou volontairement montrer une potion sans l'utiliser par exemple)
- Si la partie s'écourte et que vous ne vous êtes toujours pas rapprocher du centre vous serez téléporté
- Fire Aspect, Flame, seau de lave, briquet et canne à pêche ne sont pas autorisés
- Ne pas communiquer par message sur une autre application
- Ne pas essayer d'exploiter des éléments non spécifiés qui seraient de toute évidence non autorisé
- Nous nous réservons le droit de Blacklist les personnes ne respectant pas les règles ou les personnes qui nuiraient au plaisir des autres

## Règles de base

- Map de taille configurable(1000x1000 / 2000x2000 / 3000x3000 / 5000x5000)
- Configuration de temps pour la réduction de la bordure jusqu'en 1000x1000
- Désactivation des coordonnées sur le F3, une distance par rapport au centre sera données aux joueurs en fonction de leur position
- Ajout d'une RoofedForest pour le centre de la map
- Cutclean
- Nightvision permanent pour tous les joueurs
- Annonce des différents rôles à 20 minutes, ils sont répartis de manière aléatoire
- PVP actif à partir de l'annonce des rôles
- A partir de l'annonce des rôles le cylce jour/nuit ne fera plus que 5 minutes à la place des 10 par défaut
- Limite de minage du diamant à 17 par joueur
- Limite d'enchantement sur le diamant à protection 3, sauf exception de livre avec un id spécial(associé à un rôle)
- Limite d'enchantement sur les épées à Sharpness 4
- Limite à 2 pièces d'armure en diamant par joueur
- Chaque 20 minutes après 60 minutes de jeu, les joueurs ont la possibilités de voter (Commande : /lg vote PlayerName) Le joueur comptabilisant le plus de votes perdra donc la motier de sa vie pendant 10 minutes
- Gain de 2 coeurs d'absorption lorsque l'on tue un joueur
- A la mort d'un joueur, son nom et son rôles sont données à tous les joueurs mais le nom du tueur n'est pas indiqué
- Nether désactivé
- Spawn des joueurs de manière aléatoire et séparé les uns des autres sur la map
- Pas de chat disponible pour la communication entre les joueurs
- Utilisation du plugin Mumble
- Rod desactivée
- Fire Aspect, Flame, seau de lave et briquet désactivé
- Possibilités d'activer ou désactiver des rôles
- 15 sec de délais avant la mort d'un joueur pour permettre les résurrections
- Ajouter un lien lorsqu'un rôle est prévenu pour une mort qui exécute la commande pour les résurrections cela permet aux joueurs de ressusciter plus simplement
- Un joueur ressuscité est téléporté aléatoirement sur la map.
- Répartition : (Suivre l'ordre des règles pour l'attribution)
- Attribution des rôles spéciaux avant attribution des rôles villageois / loups
- 2x moins de loup que de villageois
- attribution des rôles particuliers de chaque camps
- attribution des rôles LG et SV

## Les Rôles

### Le village

- Simple villageois : -
- Chasseur : Obtient un livre Power 4 avec 128 flèches. A sa mort il a une minute pour choisir, un joueur et lui enlevé la moitié de sa vie (Commande : /lg pan PlayerName).
- Petite fille : Invisibilité + Weakness + Speed la nuit. Elle peut connaître tous les joueurs qui se trouvent dans un rayon de 100 blocs en permanence (Commande : /lg spy).
- Sorcière : Obtient 3 potions d'instant heal 1, 1 potion de regen 1 de 45sec et 3 potions d'instant damage 1. Elle peut choisir de ressusciter un joueur lorsqu'il meurt. (Elle peut se ressusciter elle même) (Commande : /lg revive PlayerName).
- Salvateur : Chaque 20min à partir du début de la partie il peut choisir un joueur à qui il confère les effets "No fall" et résistance 1 pendant 20min. (Commande : /lg salvater PlayerName) Il dispose de 2min pour réalisé sa commande et ne peut pas choisir 2x le même joueur d'affilé. Il peut se choisir lui-même.
- Ancien : Résistance 1 en permanence. Ressuscite la première fois qu'il meurt.
- Mineur : Haste 2 en permanence. Obtient une pioche en diamant Efficiency 2
- Montreur d'ours : A chaque début de journée pour chaque loup qui se trouve dans un rayon de 50 blocs, un grognement est affiché dans le chat général.
- Sœurs : Résistance 1 lors qu'elles sont à moins de 10 blocs l'une de l'autre. Voit le rôle du joueur qui a tué l'autre sœur.
- Renard : Speed 1 en permanence. Il peut flairer 3x dans la game un joueur qui se trouve à moins de 10 blocs de lui, afin de savoir si celui-ci est un loup ou un innocent. (Commande : /lg snif PlayerName) Il ne voit en tant que loup que les rôles qui ont "loup" dans leur nom.
- Voyante : Obtient 4 obsidiennes et 2 bibliothèque. Elle dispose, chaque 30min de jeu après l'attribution des rôles, de 2min pour connaître le rôle d'une personne de son choix. (Commande : /lg voir PlayerName)
- Citoyen : Il peut visualiser les votes des joueurs à 2 reprises dans la partie. Il reçoit un message dans son chat juste avant l'annonce du résultat du vote et s'il clic sur "Voir", il peut voir qui à voter pour qui.

### Les loups

- Loups-garous : Force 60% la nuit.
- Infect père des loups : Force 60% la nuit. Speed 1 pendant 2 minutes lorsqu'il tue un joueur. Il peut choisir de ressusciter un joueur mort par les loups-garous celui-ci devient un loup-garou normal tout en conservant ses anciens pouvoirs. (Commande : /lg infect PlayerName)
- Vilain petit loup : Speed 1 la nuit.

### Spéciaux

- Cupidon
  - Gagne avec le couple ou le village.
  - Désigne deux personnes à mettre en couple. (Commande : /lg love Player1 Player2). Obtient un arc punch 2 avec 64 flèches.

- Assassin :
  - Gagne en solo.
  - Force 60% le jour. Obtient les livres Protection 3, Sharpness 3 et Power 3.

- Voleur :
  - Gagne en solo, tant qu'il n'a pas volé un rôle.
  - Il gagne le rôle de la première personne qu'il tue. Si les pouvoirs du rôle ont déjà été utilisés, il ne pourra pas les utiliser et il ne récupère pas les objets du rôle.
  - Il dispose de l'effet Résistance 1 avant de voler un joueur et s'il tue un joueur en couple, il le remplace et connaîtra l'identité de son partenaire (mais celui-ci ne le saura pas).

- Mercenaire :
  - Gagne avec les loups.
  - Ne voit pas la liste des loups et les loups ne le connaissent pas non plus.

- Loup-garou blanc :
  - Gagne en solo.
  - Force 60% la nuit et 5 coeurs supplémentaires permanent

- Loup amnésique :
  - Gagne avec le village, s'il se souvient gagne avec les loups.
  - SV à l'annonce des rôles, puis si un membre des loups le tape, il retrouve la mémoire après 2 minutes et devient un loup-garou normal.

- Enfant sauvage :
  - Gagne avec le village, si son maître meurt gagne avec les loups.
  - Il désigne un maître au début de la partie (Commande : /lg master PlayerName), si son maître meurt il devient un loup-garou normal.

### Autres

- Couple :
  - Gagne avec son partenaire (+ ~cupidon) / Gagne avec les loups si les 2 partenaires sont loups / Gagne avec le village si les 2 partenaires sont villageois
  - Si l'un des 2 partenaires meurt, l'autre aussi.
