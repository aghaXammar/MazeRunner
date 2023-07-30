//Agha Ammar Haider
//241564746


import java.util.Scanner;

public class Maze_runner {
    private String[][] pattern;
    //row_pos and col_pos for saving the integer values for positions of the "P" (players position)
    private int row_pos;
    private int col_pos;

    private int e_row_pos; //Row position of "E" (Exit)
    private int e_col_pos; //Column position of "E" (Exit)

    private int exit_val=1; //This variable is used in a condition for outer while loop in playgame() function
    private int game_exit=1;//This variable is used in a condition for inner while loop in playgame() function

    private int no_of_steps=0; //Will save the no of steps taken by the user for the "P" to reach "E"
    private int highest_score=0; //Highest score saver

    

    public void initializeMaze() {
// # # # # # # #
// # P . . . . #
// # # # # . # #
// # . . . . . #
// # # # . # # #
// # . . . . E #
// # # # # # # #
        pattern=new String[7][7];

        
        //Creating walls and users starting point and exit point

        //For first row
        for (int i = 0; i < pattern[0].length; i++) {
            pattern[0][i]="#";
            
            
        }

        //For second row
        pattern[1][0]="#";
        pattern[1][6]="#";

        for (int i = 1; i < pattern.length-1; i++) {
            pattern[1][i]=".";
            
        }


        //For third row
        for (int i = 0; i < 4; i++) {
            pattern[2][i]="#";
            
        }

        for (int i = 5; i < 7; i++) {
            pattern[2][i]="#";
            
        }
        pattern[2][4]=".";


        //For fourth row
        pattern[3][0]="#";
        pattern[3][6]="#";

        for (int i = 1; i < pattern.length-1; i++) {
            pattern[3][i]=".";
            
        }


        //For fifth row

        for (int i = 0; i < 3; i++) {
            pattern[4][i]="#";
            
        }

        for (int i = 4; i <pattern.length ; i++) {
            pattern[4][i]="#";
            
        }

        pattern[4][3]=".";

        
        //For sixth row
        pattern[5][0]="#";
        pattern[5][6]="#";

        for (int i = 1; i < pattern.length-1; i++) {
            pattern[5][i]=".";
            
        }

        //For seventh row
        for (int i = 0; i < pattern.length; i++) {
            pattern[6][i]="#";
            
        }

        //Entering positions
        pattern[1][1]="P";
        pattern[5][5]="E";
        
        
    }

    public void printMaze() {
        //Printing the pattern
        for (int i = 0; i < pattern.length; i++) {
            for (int j = 0; j < pattern[i].length; j++) {
                System.out.print(pattern[i][j]+" ");
                
            }
            System.out.println();
        }
        
        
        for (int i = 0; i < pattern.length; i++) {         //This loop saves the position of "P" 
            for (int j = 0; j < pattern[i].length; j++) {  //in the row_pos and col_pos (Private variables)
                if (pattern[i][j].equals("P")) {  
                    row_pos=i;
                    col_pos=j;
                    
                } 
                
            }
        }

        for (int z = 0; z < pattern.length; z++) {
            for (int x = 0; x < pattern[z].length; x++) { //This loop saves the position of "P"
                if (pattern[z][x].equals("E")) { //in the e_row_pos and e_col_pos (Private variables)
                    e_row_pos=z;
                    e_col_pos=x;
                    
                } 
                
            }
         
            
            
        }
        
 
    }

    

    public boolean isValidMove(int x, int y){
        if (pattern[x][y].equals("P")) {      //This function returns true ifthere is no
            return true;                               // "#" (Wall) at the move that will be made
                                                       // and vice for
        } else {                                       
            if (!pattern[x][y].equals("#")) {
                return true;
                
            } else {
                return false;
                
            }
            
        }
    }

    

    public void movePlayer(char direction) {

        switch (direction) {
            case 'w':
                    if (isValidMove(row_pos-1, col_pos)) {  // As for the upper move, it will check
                        pattern[row_pos][col_pos]=".";      // (row_pos-1(one row lesser),col_pos) if it doesn't have a wall
                        pattern[row_pos-1][col_pos]="P";    // it will make that position equal to "P" and "." for the 
                        row_pos=row_pos-1;                  // previous position.
                        no_of_steps++;
                    
                    }
                        
                
                    else {
                        System.out.println();;
                        System.out.println("########################");
                        System.out.println("Invalid move, wall above"); // Will be implemented this part if isValidMove() 
                        System.out.println("########################"); // returns false
                        System.out.println();}

                
                break;
            case 'a':
                        // As for the left move, it will check
                        // (row_pos,col_pos-1(one col lesser)) if it doesn't have a wall
                        // it will make that position equal to "P" and "." for the 
                        // previous position.
                    if (isValidMove(row_pos, col_pos-1)) {  
                        pattern[row_pos][col_pos]=".";
                        pattern[row_pos][col_pos-1]="P";
                        col_pos=col_pos-1;
                        no_of_steps++;
                    }
                
                    else {
                        // Will be implemented this part if isValidMove() 
                        // returns false
                        System.out.println();;
                        System.out.println("########################");
                        System.out.println("Invalid move, wall at the left");
                        System.out.println("########################"); 
                        System.out.println();}
                    
                break;
            
                case 's':
                        // As for the down move, it will check
                        // (row_pos+1(one row greater),col_pos) if it doesn't have a wall
                        // it will make that position equal to "P" and "." for the 
                        // previous position.
                    if (isValidMove(row_pos+1, col_pos)) {
                        pattern[row_pos][col_pos]=".";
                        pattern[row_pos+1][col_pos]="P";
                        no_of_steps++;
                    }
                
                    else {

                        System.out.println();;
                        System.out.println("########################");
                        System.out.println("Invalid move, wall down");
                        System.out.println("########################"); 
                        System.out.println(); }
                    break;

                case 'd':
                        // As for the right move, it will check
                        // (row_pos,col_pos(one column greater)) if it doesn't have a wall
                        // it will make that position equal to "P" and "." for the 
                        // previous position.
                    if (isValidMove(row_pos, col_pos+1)) {
                        pattern[row_pos][col_pos]=".";
                        pattern[row_pos][col_pos+1]="P";
                        no_of_steps++;
                    }
                
                    else {
                        System.out.println();;
                        System.out.println("########################");
                        System.out.println("Invalid move, wall at the right");
                        System.out.println("########################"); 
                        System.out.println();
                    }
                    break;
                        
                        
        
            default:
                break;
        }
       

        
        
        
        }


        public void updateScore(){
            //If the highest score is zero than the first score will be the highest
            if (highest_score==0) {    
                highest_score=no_of_steps;
                
            } else {
                //If the number of steps will be less than highest score than the highest score will be no of steps
                if (no_of_steps<highest_score) {
                    highest_score=no_of_steps;
                    
                }
                
            }

        }


        public void displayResult() {
            updateScore(); //Will first update the score than the bottom code will be implemented 
            System.out.println();
            System.out.println("#################################");
            System.out.println("       Maze Runner Game");
            System.out.println("################################# ");
            System.out.println("       Highest Score: " + highest_score);
            System.out.println("       Steps Taken: " + no_of_steps);
            System.out.println("       Score: " + no_of_steps);
            System.out.println("################################# ");
            System.out.println();
        }
    

    

    public void hasPlayerWon(){
        //It will check if the "P" positions will be equal to the the "E" positions
        if (row_pos==e_row_pos && col_pos==e_col_pos) {
            System.out.println("----------------------------------------");
            System.out.println("Congratulations, player has won the game");
            System.out.println("----------------------------------------");
            exit_val=0;
            //Will display the result after the winning
            displayResult();

            
        }

       



    }

    public void startNewGame(){
        exit_val=1;
        game_exit=1;
        initializeMaze(); //Will update every value used at conditioning 
        no_of_steps=0;    // and will initialize the maze as the new one
    }


    public void showInstructions() {
        //Will print instructions
        System.out.println("-------------------------------------------------------");
        System.out.println("         Maze Runner Rules and instructions");
        System.out.println("-------------------------------------------------------");
        System.out.println("Rules:");
        System.out.println("1. The maze is represented by '#' for walls,");
        System.out.println("   '.' for paths, 'P' for the player, and 'E' for the exit.");
        System.out.println("2. Use 'w' to move upwards, 's' to move downwards, 'a' to move left, and 'd' to move right.");
        System.out.println("3. You cannot move through walls ('#').");
        System.out.println("4. Reach the exit ('E') to win the game.");
        System.out.println("5. The number of steps taken will be recorded.");
        System.out.println("6. You can quit the game by typing 'e'.");
        System.out.println("-------------------------------------------------------");
        System.out.println();
    }

    public void showCredits(){
        //Credit printing
        System.out.println("---------------------------------");
        System.out.println("        Maze Runner Credits");
        System.out.println("---------------------------------");
        System.out.println("Game developed by Agha Ammar Haider");
        System.out.println("---------------------------------");
        System.out.println();
    }

   public void showHighScore(){
        //Will print the high score
        System.out.println("---------------------------------");
        System.out.println("   Maze Runner Highest Score");
        System.out.println("---------------------------------");
        System.out.println("       Highest Score: " + highest_score);
        System.out.println("---------------------------------");
        System.out.println();


   

   }

   public void exitGame(){

        System.out.println("-------------------");
        System.out.println(" Exiting the game");
        System.out.println("-------------------");
        //System.exit(0(represents termination))
        System.exit(0);
   }


    public void playGame(){
        int exit=1;

        Scanner sc=new Scanner(System.in);

        while (exit!=0) { //run while loop untill the exit value is 0
            initializeMaze();
            System.out.println();
            System.out.println("#################################");
            System.out.println("       Maze Runner Game");
            System.out.println("################################# ");
            System.out.println("a. Play Game");
            System.out.println("b. Instructions");
            System.out.println("c. Credits");
            System.out.println("d. High Score");
            System.out.println("e. Exit");
            System.out.print("Enter your choice (a,b,c,d,e): ");
            String main_choice=sc.nextLine();//Will take the value from user
            System.out.println("################################# ");
            System.out.println();
        
        

            switch (main_choice) {
                case "a": //value "a" for playing the game
                    
                    while (game_exit!=0) { //Will run while loop untill the value of game exit is 0
                        
                    
                        System.out.println("-------------------------------------------");
                        System.out.println("Starting the game, select your moves wisely ");
                        System.out.println("-------------------------------------------");
                        printMaze(); //Print maze and also assigns the positions of "P" and "E"
                        while (exit_val!=0) {//while loop will run untill the value exit_val is 0
                       
                        
                            System.out.println();
                            System.out.println("------------------------");
                            System.out.print("Your move (w/a/s/d): ");
                            
                            
                            String move=sc.nextLine();//Takes the value from user
                            System.out.println("------------------------");
                            char c=move.charAt(0); //Converts the character at 0th index of the value
                            movePlayer(c);
                            printMaze();
                            hasPlayerWon();

                        
                            }
                        
                        System.out.print("Do you want to play again (y/n): ");
                        String y_n=sc.nextLine();   //takes the value from user
                        char c1=y_n.charAt(0);//Converts the character at 0th index of the value
                        System.out.println();

                        if (c1=='y') {//If the value is y, it will start a new game play
                            System.out.println("Starting the game again");
                            System.out.println();
                            startNewGame();//Will update the conditional values

                            
                        } else {
                            //If the value is "n" 
                            startNewGame();//Will update the conditional values 
                            break;         // and will break the game play loop
                            
                        }
                    }
                    
                    break;
                
                case "b":
                    showInstructions(); //Value b for instruction printing
                    break;
                    
                case "c":
                    showCredits(); //Value c for credit printing
                    break;
                
                case "d":
                    showHighScore();//Value d for high score printing
                    break;
                case "e":
                    exitGame(); //Value e to exit the program

                default:
                    System.out.println();;
                    System.out.println("########################");
                    System.out.println("Invalid move, wall above"); //if not any of the mentioned values
                    System.out.println("########################"); //implement this part
                    System.out.println();
                    break;

            }


            
        }
    }



    public static void main(String[] args) {
        //The program starts here

        //Created the object of the main class Maze_runner
        Maze_runner mazeRunner = new Maze_runner();
        
        mazeRunner.playGame();//Implementation of playGame() method
        


        
        
        
    }
    
}


