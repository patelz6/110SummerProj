public class Controller {
    public static void main(String[] args) {

        // initialisation
        double ballSpeedX = 0; // speed in x direction
        double ballSpeedY = 0; // speed in y direction
        
        int p1Score = 0; // scores for player 1 and two
        int p2Score = 0;
        boolean canMove = true; // for reset game purposes after a win
        boolean sound = true; // controls whether you can hear sound
        

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
        Text p1score = new Text("0", 50, 150, 500, "WHITE");
        Text p2score = new Text("0", 50, 1350, 500, "WHITE");
        Text topText = new Text("Welcome to Air Hockey", 30, 250, 150, "WHITE");
        Text soundText = new Text("SOUND", 30, 100, 100, "GREEN");

        
        
        

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
        gameArena.addText(p1score);
        gameArena.addText(p2score);
        gameArena.addText(topText);
        gameArena.addText(soundText);

        

        if (sound == true) {
            SoundPlayer.playSound("fanfare.wav"); // all instances of sound are in if statements to provide a way to turn off the sound and to turn it back on
        }
        
        // player 1 and 2 controls
        
            while (true) {

                if (canMove == false) { // resetter for once the game is over
                    if (gameArena.spacePressed()) {
                        p1Score = 0;
                        p2Score = 0;
                        p1score.setText("0");
                        p2score.setText("0");
                        player1.setXPosition(550);
                        player1.setYPosition(500);
                        player2.setXPosition(950);
                        player2.setYPosition(500);
                        puck.setXPosition(750);
                        puck.setYPosition(500);
                        topText.setText("Welcome to Air Hockey!");
                        
                        if (sound == true) {
                            SoundPlayer.playSound("fanfare.wav"); // based on if sound is on or off
                        }
                        canMove = true;
                    }
                }
                if (gameArena.enterPressed()) { // sound controller
                    sound = false;
                    soundText.setColour("RED");
                }
                if (gameArena.shiftPressed()) {
                    sound = true;
                    soundText.setColour("GREEN");
                }
                
                // cheat codes
                if (gameArena.letterPressed('o')) {
                    p1Score = 5;
                    topText.setText("Player 1 has activated cheats and will win once scoring!");
                }
                if (gameArena.letterPressed('p')) {
                    p2Score = 5;
                    topText.setText("Player 2 has activated cheats and will win once scoring!");
                }
                                    
                if (canMove == true) { // if the game is currently running
                   

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
                
                }
                

                // puck collisions with walls
                if (puck.getYPosition() < 225 + puck.getSize() / 2) {
                    if (sound == true) {
                    SoundPlayer.playSound("bounce.wav");
                }
                    ballSpeedY = ballSpeedY * -1; // to prevent puck from going out of bounds whilst keeping natural movement
                    puck.setYPosition(puck.getYPosition() + 10); // to prevent the puck being stuck constantly reflecting its speed out of bounds
                }

                if (puck.getYPosition() > 775 - puck.getSize() / 2) {
                    if (sound == true) {
                        SoundPlayer.playSound("bounce.wav");
                    }
                    
                    ballSpeedY = ballSpeedY * -1;
                    puck.setYPosition(puck.getYPosition() - 10);
                }

                if (puck.getXPosition() < 225 + puck.getSize() / 2) {
                    if (sound == true) {
                        SoundPlayer.playSound("bounce.wav");
                    }
                    ballSpeedX = ballSpeedX * -1;
                    puck.setXPosition(puck.getXPosition() + 10);

                }

                if (puck.getXPosition() > 1275 - puck.getSize() / 2) {
                    if (sound == true) {
                        SoundPlayer.playSound("bounce.wav");
                    }
                    ballSpeedX = ballSpeedX * -1;
                    puck.setXPosition(puck.getXPosition() - 10);
                }

                // puck movement with deflection physics
                if (puck.collides(player1)) {
                    if (sound == true) {
                        SoundPlayer.playSound("hit.wav");
                    } // purposely ignoring the speed components for the player-controlled paddles to prevent unwanted recoil / movement
                    Deflect deflection1 = new Deflect(30, 0, 30, 0, player1.getXPosition(), puck.getXPosition(), player1.getYPosition(), puck.getYPosition());        
                    deflection1.deflect(); // calling deflect function
                    ballSpeedX = deflection1.xSpeed2;
                    ballSpeedY = deflection1.ySpeed2;

                    // for both player 1 and player 2, it calls the deflect class and creates an object
                }

                if (puck.collides(player2)) {
                    if (sound == true) {
                        SoundPlayer.playSound("hit.wav");
                    }
                    Deflect deflection2 = new Deflect(30, 0, 30, 0, player2.getXPosition(), puck.getXPosition(), player2.getYPosition(), puck.getYPosition());
                    deflection2.deflect();
                    ballSpeedX = deflection2.xSpeed2;
                    ballSpeedY = deflection2.ySpeed2;
                }

                // slow-down co-efficient of puck over distance
                double friction = 0.995;
                puck.move(ballSpeedX, ballSpeedY);
                ballSpeedX = friction * ballSpeedX;
                ballSpeedY = friction * ballSpeedY;  // applying friction

                // goal collisions

                if (puck.getXPosition() < 240 + puck.getSize() / 2) { // if player 2 scores with x/y values of player 1's goal
                    if (puck.getYPosition() < 650 + puck.getSize() / 2
                            && puck.getYPosition() > 375 - puck.getSize() / 2) {
                        if (p2Score == 5) {
                            canMove = false; // prevents movement as game is over (repeated for both players)
                            if (sound == true) {
                                SoundPlayer.playSound("drumroll.wav");
                            }
                            topText.setText("Player 2 wins! Play again?");
                        } else {
                            if (sound == true) {
                                SoundPlayer.playSound("applause.wav");
                            }
                            topText.setText("Player 2 scores!");
                        }

                        topText.setColour("GREEN");
                        String[] score2Array = { "1", "2", "3", "4", "5", "6" }; // because text.setText only takes strings and Integer.toString would be inaccessible outside of gameloop

                         // player 2 scores
                        if (p2Score < 6) {
                            p2score.setText(score2Array[p2Score]);
                            p2Score++;
                        }
                        puck.setXPosition(midBall2.getXPosition() - 76);
                        puck.setYPosition(500);
                        player1.setXPosition(550);
                        player1.setYPosition(500);
                        player2.setXPosition(950);
                        player2.setYPosition(500);
                        ballSpeedX = 0;
                        ballSpeedY = 0;
                    }
                }

                if (puck.getXPosition() > 1275 - puck.getSize() / 2) { // if player 1 scores with x/y values of player 2's goal
                    if (puck.getYPosition() < 650 + puck.getSize() / 2 && puck.getYPosition() > 375 - puck.getSize() / 2)
                            {
                        if (p1Score == 5)
                        {
                            canMove = false;
                            if (sound == true)
                            {
                                SoundPlayer.playSound("drumroll.wav");
                            }
                            topText.setText("Player 1 wins! Play again?");
                        } else {
                            if (sound == true)
                            {
                                SoundPlayer.playSound("applause.wav");
                            }
                            topText.setText("Player 1 scores!");
                        }

                        topText.setColour("GREEN");
                        
                        String[] score1Array = { "1", "2", "3", "4", "5", "6" }; // to bypass String-only input for text.setText() (see line 217 comment)

                        // player 1 scores

                        if (p1Score < 6) {
                            p1score.setText(score1Array[p1Score]);
                            p1Score++;
                        }
                        puck.setXPosition(midBall2.getXPosition() + 76); // 76 is radius of blue lined mid circle
                        puck.setYPosition(500);
                        player1.setXPosition(550);
                        player1.setYPosition(500);
                        player2.setXPosition(950);
                        player2.setYPosition(500);
                        ballSpeedX = 0;
                        ballSpeedY = 0;
                    }

                    

                }
                // updater
                gameArena.pause();
            }
        }

    }


