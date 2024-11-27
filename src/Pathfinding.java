public class Pathfinding {
    private int x;
    private int y;
    private int columns;
    private int rows;

    public Pathfinding(int columns, int rows, int x, int y) {
        this.rows = rows;
        this.columns = columns;
        this.x = x;
        this.y = y;
    }

    public void moveLeft() {
        if(this.x > 0 && this.x < columns) this.x -= 1;
    }

    public void moveRight() {
        if(this.x > -1 && this.x < columns - 1) this.x += 1;
    }

    public void moveUp() {
        if(this.y > 0 && this.y < rows - 1) this.y += 1;
    }

    public void moveDown() {
        if(this.x > -1 && this.x < rows) this.y -= 1;
    }
}
