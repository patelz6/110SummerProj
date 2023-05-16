public class Controller {
    public static void main(String[] args) {

        // initialisation
        
        

        // drawing main game and players
        GameArena gameArena = new GameArena(1500, 1000, true);
        Rectangle blueRect = new Rectangle(200, 200, 1100, 600, "BLUE", 0);
        Rectangle whiteRect = new Rectangle(225, 225, 1050, 550, "WHITE", 1);
        Rectangle goal1 = new Rectangle(225, 375, 15, 275, "GREY", 6);
        Rectangle goal2 = new Rectangle(1260, 375, 15, 275, "GREY", 6);
        Line middle = new Line(750, 200, 750, 800, 1, "BLUE", 3);
        Ball midBall = new Ball(750, 500, 150, "WHITE", 4);
        Ball midBall2 = new Ball(750, 500, 152, "BLUE", 3);
        Ball player1 = new Ball(550, 500, 90, "BLUE", 5);
        Ball player2 = new Ball(950, 500, 90, "BLUE", 5);
        Ball puck = new Ball(750, 500, 40, "BLACK", 5);
        

        
        
        

        // rendering
        gameArena.addBall(player1);
        gameArena.addBall(player2);
        gameArena.addBall(puck);
        gameArena.addBall(midBall);
        gameArena.addBall(midBall2);
        gameArena.addRectangle(blueRect);
        gameArena.addRectangle(whiteRect);
        gameArena.addLine(middle);
        gameArena.addRectangle(goal1);
        gameArena.addRectangle(goal2);
    }
}

       