This is a Game Repository. It's supposed to contain a Main class that acts as a Principal Menu. It displays the possible games that you can play. You can access each Game.
A Game is supposed to implement the interface Gameable. A Game can also have its own start Menu that welcomes you to the game, lets you play another round etc. The logic 
of the Game and its Menu should not affect the rest of the logic i.e the Game Repository itself. 
Actual flow overview: Main, User, Menu (abstract), Gameable (interface), Repositorio (game repository, a collection of gameables)-> GuessGame (has its own package, and its own 
logic, including GuessGame, MenuGuessGame, Partida, Estado). 
Things that should be added and/or can be worked on:
- Repositorio should be able to add only Gameables and create a new class with its name implementing Gameable and instance of said Gameable. 
- Cleaner code, handling exceptions, exception logger for exceptions not handled.
- SpringBoot, implementing visual graphics. 
