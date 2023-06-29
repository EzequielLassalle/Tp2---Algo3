# TP2 - AlgoDefense
## Algoritmos y Programación 3
## Grupo11
* **108397 - Alejo Ordoñez** - [alejoordonez02](https://github.com/alejoordonez02)
* **109007 - Fernando Yu** - [fernandoyu](https://github.com/FernandoYu)
* **105414 - Gonzalo Olmos** - [gonzalo912](https://github.com/gonzalo912)
* **105801 - Lassalle Ezequiel** - [LassalleEzequiel](https://github.com/EzequielLassalle)
## Descripción del juego
El objetivo de este trabajo es el completo desarrollo de un Tower Defense, incluyendo el modelo de clases, sonidos e interfaz gráfica; acompañado por pruebas unitarias e integrales y documentación de diseño; utilizando el lenguaje Java, con un diseño orientado a objetos y trabajando con las técnicas de TDD e Integración Continua.
AlgoDefense es un Tower Defense pero no en tiempo real, sino por turnos. Es un juego de estrategia y se basa en la construcción de defensas que impidan que los enemigos lleguen hasta el jugador. El jugador debera sobrevivir y ganar la partida matando la mayor cantidad de enemigos posibles y sobreviviendo las oleadas de enemigos.
##
El plantel de enemigos se encuentra conformado por hormigas, arañas, topos y lechuzas, todos con habilidades únicas que requerirán diferentes estrategias para ser derrotados.
El jugador tiene 20 puntos de vida y 100 créditos que le permitirán construir defensas, que irán retornando más créditos a medida que vayan eliminando enemigos según corresponda su unidad. A medida que los enemigos vayan llegando a la meta se le irán descontando puntos de vida al jugador y éste pierde la partida si llega a 0.
Las defensas que el jugador podrá utilizar para defenderse de las unidades enemigas son la Torre Blanca, de rápida construcción pero menos potente que la Torre Plateada, que a pesar de ser más cara y de tardar más en construirse es más fuerte. También se pueden construir Trampas Arenosas que ralentizan el avance de los enemigos cuando caen en ellas.
Como ya mencionamos el juego es por turnos, en cada uno de ellos las defensas atacaran según sus capacidades y el jugador elige si  quiero construir más o pasar.
La partida comienza con los enemigos apareciendo en el extremo inicial del mapa. Si el jugador logra sobrevivir cuando se hayan desfilado todos los enemigos, habrá ganado la partida.
## Herramientas de desarrollo
Para el desarrollo se usaron JDK, JavaFX, JUnit: framework de pruebas unitarias para Java, y Git para versionar el código y trabajar en conjunto.
Además utilizamos formas de desarrollo en grupo como aprendizaje cooperativo, evaluación grupal y "pair programming". Tambien utilizamos JSON SIMPLE para 
parsear los JSON.
## Metodología de desarrollo
La realización de este trabajo consistió en 6 entregas semanales, en cada una de las cuáles recibimos una valoración sobre nuestro progreso por parte de nuestro corrector y consejos para seguir trabajando.
## Semana 1
- Planteamos el modelo tentativo del programa con diagramas de clases.
- Creacmos el repositorio y GITHUB actions
- Hicimos commits con nuestros nombres.
## Semana 2
Implementamos el modelo basandonos en las primeras pruebas unitarias que nos dio la catedra
## Semana 3
Implementamos la lectura y conversion del JSON.
## Semana 4
Terminamos el modelo
## Semana 5
Refactorizamos el modelo y arrancamos con la interfaz grafica
## Semana 6
EntregaMOS final con el trabajo completo funcionando, con interfaz gráfica y sonidos.
## Desarrollo
El desarrollo se fue dando con metodologia Pair programming por medio de Discord. Para el desarrollo se
uso TDD.
        
Para el desarrollo tomamos varios supuestos, para empezar como en casi todos los tower Defence lo
pensamos como funcionan la mayoria de los Tower Defense:
-El jugador puede construir la cantidad de Torres que quiera mientras sus creditos se lo permitan
-El jugador muere cuando se lo mata
-La lechuza se mueve en forma de L
-La trampa arenosa pierde tu utilidad cuando es usada, como toda trampa en la mayoria de los Tower defense
## Diagramas de clases

Casilleros.uml.PNG

##Primer Diagrama
DiagramasTp2Algo3/Casilleros.uml.PNG

##Segundo Diagrama
DiagramasTp2Algo3/Rango.uml.PNG

##Tercer Diagrama
DiagramasTp2Algo3/Torre.uml.PNG

##Cuarto Diagrama
DiagramasTp2Algo3/Enemigos.uml.PNG

##Quinto Diagrama
DiagramasTp2Algo3/DiagramaDeJuego.PNG

##SextoDiagrama
DiagramasTp2Algo3/DiagramaDeSecuencia1.PNG

## Septimo Diagrama
DiagramasTp2Algo3/DiagramaDeSecuencia2.PNG

##Octavo Diagrama
DiagramasTp2Algo3/DiagramaDeSecuencia3.PNG

##Noveno Diagrama
DiagramasTp2Algo3/DiagramaDePaquetes.PNG

<!-- Diagramas de secuencia -->
<!-- Diagrama de paquetes -->
## Detalles de implementación
Para la implementación fuimos cuidadosos con los pilares de la programación orientada a objetos. Además aplicamos algunos de sus principios, como "Tell Don't Ask", Ley de Demeter, Programación contra Interfaces, entre otras.
Intentamos cumplir con la mayoria de los principios de la materia. 
## Excepciones
Como excepciones utilizamos principalmente los errores de JSONERROR.
