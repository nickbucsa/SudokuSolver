public class box {
    int row, column, value;

    public box() {
        this.row = -1;
        this.column = -1;
        this.value = -1;
    }

    public box(int row, int column, int value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public void incValue() {
        value++;
    }

    public void getBox() {
        System.out.println("Row: " + row + ", Column:" + column + " Value: " + value);
    }
}