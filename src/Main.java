public class Main {
    public static void main(String args[]) {
        char wall = '#';
        char empty = ' ';
        char path = '•';

        String maze = "##########" +
                "\n###S    ##" +
                "\n####### ##" +
                "\n##E     ##" +
                "\n##########";

        Main main = new Main();

        System.out.println(maze);
        System.out.println("Columns: " + main.getColumns(maze) + "\nRows: " + main.getRows(maze));

        String[][] parsedMaze = main.mazeParser(maze);

        Pathfinding pathfinding = new Pathfinding(main.getColumns(maze), main.getRows(maze), main.getCharX('S', parsedMaze), main.getCharY('S', parsedMaze));

        for(String[] i : parsedMaze) {
            System.out.println();
            for(String j : i){
                System.out.print(j);
            }
        }
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
    }

    public int getColumns(String map) {
        String[] columns = map.split("\n");
        return columns[0].length();
    }

    public int getRows(String map) {
        String[] rows = map.split("\n");
        return rows.length;
    }

    public int getCharX(char c, String[][] parsedMaze) {                   //loops through the entire array searching for the first instance of a given character then returns it's x coordinate, otherwise returns bogus number
        for(int i = 0; i < parsedMaze.length; i++) {
            for(int j = 0; j < parsedMaze[i].length; j++){
                if(parsedMaze[i][j].equals('c')) return j;
            }
        }
        return -100000000;
    }

    public int getCharY(char c, String[][] parsedMaze) {                   //loops through the entire array searching for the first instance of a given character then returns it's y coordinate, otherwise returns bogus number
        for(int i = 0; i < parsedMaze.length; i++) {
            for(int j = 0; j < parsedMaze[i].length; j++){
                if(parsedMaze[i][j].equals('c')) return i;
            }
        }
        return -100000000;
    }
}
