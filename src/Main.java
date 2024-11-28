public class Main {
    public static void main(String args[]) {
        String wall = "#";                  //just setting some characters that will never change, i should probably make them constants but I dont know if ill use them here yet
        String empty = " ";
        String path = "•";

        String maze = "##########" +       //the maze to be solved, exchange with a valid maze as you desire ONCE ITS FINISHED SO NOT YET LOL
                    "\n###S    ##" +
                    "\n####### ##" +
                    "\n##E     ##" +
                    "\n##########";
//        String maze = "" +                //a second maze for testing
//                  "#########################" +
//                "\n#S        ###           #" +
//                "\n######### #   ######### #" +
//                "\n###       # ##E       # #" +
//                "\n### ####### ######### # #" +
//                "\n### #######           # #" +
//                "\n### ################### #" +
//                "\n###                     #" +
//                "\n#########################";

        Main main = new Main();             //create main object for future referencing, is this bad code?

//        System.out.println(maze);           //FOR DEBUGGING: print original maze and the number of rows and columns
//        System.out.println("Columns: " + main.getColumns(maze) + "\nRows: " + main.getRows(maze));

        String[][] parsedMaze = main.mazeParser(maze);  //parse the inputted string maze into a 2d array, makes making new mazes easy

        Pathfinding pathfinding = new Pathfinding(main.getColumns(maze), main.getRows(maze), main.getCharX("S", parsedMaze), main.getCharY("S", parsedMaze));   //create a pathfinding object

        main.solve(parsedMaze, pathfinding);
        main.printMaze(parsedMaze);
    }

    public String[][] mazeParser(String map) {
        String[][] maze = new String[this.getRows(map)][this.getColumns(map)];

        String[] splitMap = map.split("\n");
        for(int i = 0; i < splitMap.length; i++) {
            String[] row = splitMap[i].split("");
            for(int j = 0; j < splitMap[i].length(); j++) {
                maze[i][j] = row[j];
            }
        }

        return maze;
    }                   //parse the string inputted maze into a 2d array so this program actually works

    public int getColumns(String map) {
        String[] columns = map.split("\n");
        return columns[0].length();
    }                          //determine the number of columns in the inputted maze

    public int getRows(String map) {
        String[] rows = map.split("\n");
        return rows.length;
    }                             //determine the number of rows in the inputted maze

    public int getCharX(String c, String[][] parsedMaze) {                   //loops through the entire array searching for the first instance of a given character then returns it's x coordinate, otherwise returns bogus number
        for(int i = 0; i < parsedMaze.length; i++) {
            for(int j = 0; j < parsedMaze[i].length; j++){
                if(parsedMaze[i][j].equals(c)) return j;
            }
        }
        return -100000000;
    }       //return the 'x' value of a given character, only works properly for unique characters, ie the start and end

    public int getCharY(String c, String[][] parsedMaze) {                   //loops through the entire array searching for the first instance of a given character then returns it's y coordinate, otherwise returns bogus number
        for(int i = 0; i < parsedMaze.length; i++) {
            for(int j = 0; j < parsedMaze[i].length; j++){
                if(parsedMaze[i][j].equals(c)) return i;
            }
        }
        return -100000000;
    }       //return the 'y' value of a given character, only works properly for unique characters, ie the start and end

    public void printMaze(String[][] map) {                         //prints out the current maze
        for(String[] i : map) {
            System.out.println();
            for (String j : i) {
                System.out.print(j);
            }
        }
        System.out.println();
    }

    public void solve(String[][] map, Pathfinding pathfinding) {
        boolean run = true;                                         //initialize loop variable
        while(run) {
            int adjacency = pathfinding.isAdjacent(map, " ");    //set up switch case variable
            switch(adjacency) {                                     //check what direction the open path is in, move in that direction, mark path as moved on
                case 1:
                    pathfinding.moveUp();
                    pathfinding.write(map);
                    break;
                case 2:
                    pathfinding.moveRight();
                    pathfinding.write(map);
                    break;
                case 3:
                    pathfinding.moveDown();
                    pathfinding.write(map);
                    break;
                case 4:
                    pathfinding.moveLeft();
                    pathfinding.write(map);
                    break;
                case 0:
                    System.out.println("The pathfinder has hit a wall, there is no more possible way to go");
                    run = false;
                    break;
                default:
                    System.out.println("Default");
            }
            if(pathfinding.isAdjacent(map, "E") > 0 ) {          //tests if the path is next to the end of the maze
                run = false;
                System.out.println("Maze Complete!");
            }
        }
    }
}
