package Letters2D;

class Letter2D {
    // fields
    private int x;
    private int y;
    private char c;

    // constructor
    public Letter2D(int x, int y, char c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    // getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getChar() {
        return c;
    }

    // toString override
    @Override
    public String toString() {
        return x + "," + y + "," + c;
    }
}
