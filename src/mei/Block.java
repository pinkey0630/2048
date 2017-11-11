package mei;

public class Block {
    int number;
    int row;
    int column;
    String color;

    public Block(int number, int row, int column, String color) {
        this.number = number;
        this.row = row;
        this.column =column;
        this.color =color;
    }

    public int getNumber() {
        return this.number;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public String getColor() {
        return color;
    }
}
