public class Pathfinding {
    private int x;
    private int y;
    private int columns;
    private int rows;
    private String wall = "#";
    private String empty = " ";
    private String path = "•";

    public Pathfinding(int columns, int rows, int x, int y) {   //initializes the class with an x and y based on where S is and the number of columns and rows the maze has
        this.rows = rows;
        this.columns = columns;
        this.x = x;
        this.y = y;
    }

    public void moveLeft() {                                    //move one space to the left, if unable to, do nothing
        if(this.x > 0 && this.x < columns) this.x -= 1;
    }

    public void moveRight() {                                   //move one space to the right, if unable to, do nothing
        if(this.x > -1 && this.x < columns - 1) this.x += 1;
    }

    public void moveUp() {                                      //move one space up, if unable to, do nothing
        if(this.y > 0 && this.y < rows - 1) this.y -= 1;
    }

    public void moveDown() {                                    //move one space down, if unable to, do nothing
        if(this.y > -1 && this.y < rows) this.y += 1;
    }

    public void write(String[][] map) {                         //change the current space to a dot
        map[this.y][this.x] = path;
    }

    public int isAdjacent(String[][] map, String c) {           //checks which side a given character is adjacent to in a provided maze, 1 = top, 2 = right, 3 = bottom, 4 = left, 0 = not adjacent
        if(map[this.y - 1][this.x].equals(c)) {
            return 1;
        } else if(map[this.y][this.x + 1].equals(c)) {
            return 2;
        } else if(map[this.y + 1][this.x].equals(c)) {
            return 3;
        } else if(map[this.y][this.x - 1].equals(c)) {
            return 4;
        } else {
            return 0;
        }
    }

    public String isOnChar(String[][] map) {                    //checks and returns what character the path is currently at
        return map[this.y][this.x];
    }
}
