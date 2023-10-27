# DAA - laboratoire 2
## Les briques logicielles de base 
## Les Activités et les Fragments

Date : 31.10.2023

Membres :
- Felix Breval
- Anthony David
- Timothée Van Hove

Professeur : Fabien Dutoit

Assistant : Ilias Goujgali 

# 1. Activités
TODO by Felix

# 2. Les fragments, premiers pas
Dans notre mise en œuvre de l'activité hébergeant deux fragments, plusieurs observations sont à noter. Premièrement, les deux fragments fournis, à savoir le CounterFragment et le ColorFragment, sont conçus pour implémenter la restauration de leur état, offrant une expérience utilisateur cohérente même en cas de changements de configuration, tels que la rotation de l'écran. Cependant, un aspect intéressant réside dans le fait que le ColorFragment est capable de restaurer sa couleur, même en l'absence d'une sauvegarde explicite de son état. Cette capacité s'explique par le comportement par défaut d'Android, qui sauvegarde et restaure automatiquement l'état de certaines vues et éléments de l'interface utilisateur. Lorsqu'un changement de configuration se produit, Android conserve l'état de ces éléments, ce qui permet au ColorFragment de restaurer la couleur précédemment sélectionnée sans nécessiter une intervention explicite du développeur.

D'autre part, si l'on envisage de placer deux instances du CounterFragment dans l'activité, nous constatons qu'elles fonctionnent de manière indépendante. En cas de rotation de l'écran, chaque instance du CounterFragment maintiendra son propre état, ce qui peut conduire à des valeurs distinctes pour chaque instance. Cela est dû au fait que chaque Fragment est associé à l'activité qui les héberge, et Android gère la restauration de leur état en conséquence. Les deux instances du CounterFragment ne partagent pas d'état commun, ce qui signifie que leurs compteurs sont indépendants les uns des autres. Cela reflète le comportement attendu, car chaque Fragment conserve son propre état en fonction de l'Activité parente, ce qui garantit une restauration correcte de l'état, même en cas de plusieurs instances du même Fragment dans une même activité.

# 3. Le FragmentManager
TODO by Tim