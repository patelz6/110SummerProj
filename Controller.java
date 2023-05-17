public class Controller {
    public static void main(String[] args) {

        // initialisation
        int p1Score = 0;
        int p2Score = 0;
        

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
        
        while(true){
         // player1 with wall bounds
                if (gameArena.letterPressed('a') && player1.getXPosition() > 225 + player1.getSize() / 2) {
                    player1.move(-7, 0);
                }
                if (gameArena.letterPressed('d') && player1.getXPosition() < 745 - player1.getSize() / 2) {
                    player1.move(7, 0);
                }
                if (gameArena.letterPressed('w') && player1.getYPosition() > 225 + player1.getSize() / 2) {
                    player1.move(0, -7);
                }
                if (gameArena.letterPressed('s') && player1.getYPosition() < 770 - player1.getSize() / 2) {
                    player1.move(0, 7);
                }

                // player2 with wall bounds
                if (gameArena.leftPressed() && player2.getXPosition() > 755 + player2.getSize() / 2) {
                    player2.move(-7, 0);
                }
                if (gameArena.rightPressed() && player2.getXPosition() < 1275 - player2.getSize() / 2) {
                    player2.move(7, 0);
                }
                if (gameArena.upPressed() && player2.getYPosition() > 225 + player2.getSize() / 2) {
                    player2.move(0, -7);
                }
                if (gameArena.downPressed() && player2.getYPosition() < 770 - player2.getSize() / 2) {
                    player2.move(0, 7);
                }
            // puck collisions with walls
                if (puck.getYPosition() < 225 + puck.getSize() / 2) {
                    
                
                    ballSpeedY = ballSpeedY * -1;
                    puck.setYPosition(puck.getYPosition() + 10);
                }

                if (puck.getYPosition() > 775 - puck.getSize() / 2) {
                    
                    
                    ballSpeedY = ballSpeedY * -1;
                    puck.setYPosition(puck.getYPosition() - 10);
                }

                if (puck.getXPosition() < 225 + puck.getSize() / 2) {
                    
                    ballSpeedX = ballSpeedX * -1;
                    puck.setXPosition(puck.getXPosition() + 10);

                }

                if (puck.getXPosition() > 1275 - puck.getSize() / 2) {
                    
                    ballSpeedX = ballSpeedX * -1;
                    puck.setXPosition(puck.getXPosition() - 10);
                }

                // puck movement with deflection physics
                if (puck.collides(player1)) {
                    
                    Deflect deflection1 = new Deflect(30, 0, 30, 0, player1.getXPosition(), puck.getXPosition(), // added new contructor to given physics calculator in Deflect.java class
                            player1.getYPosition(), puck.getYPosition());
                    deflection1.deflect(); // calling deflect function
                    ballSpeedX = deflection1.xSpeed2;
                    ballSpeedY = deflection1.ySpeed2;
                }

                if (puck.collides(player2)) {
                    
                    Deflect deflection2 = new Deflect(30, 0, 30, 0, player2.getXPosition(), puck.getXPosition(),
                            player2.getYPosition(), puck.getYPosition());
                    deflection2.deflect();
                    ballSpeedX = deflection2.xSpeed2;
                    ballSpeedY = deflection2.ySpeed2;
                }

                // slow-down co-efficient of puck over distance
                double friction = 0.995;
                puck.move(ballSpeedX, ballSpeedY);
                ballSpeedX = friction * ballSpeedX;
                ballSpeedY = friction * ballSpeedY;
        }
    }
}

       
