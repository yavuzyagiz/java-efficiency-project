package matrix;

public class Matrix {
    private final double[] array;
    private final int row;
    private final int column;

    public Matrix(int row, int column) {
        this.row = checkRow(row);
        this.column = checkColumn(column);
        this.array = new double[row * column];
    }

    public Matrix(int row, int column, double initialValue) {
        this.row = checkRow(row);
        this.column = checkColumn(column);
        this.array = new double[row * column];
        for(int i=0;i<array.length;i++)
            array[i] = initialValue;
    }

    public void print(){
        for (int i=0;i<row;i++){
            for (int j=0;j<column;j++){
                System.out.print(getValue(i,j) + " ");
            }
            System.out.println("");
        }
    }

    public double getValue(int x, int y) {
        return array[x * this.column + y];
    }

    public void setValue(int x, int y, double value) {
        array[x * this.column + y] = value;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    private int checkRow(int row) {
        return check(row, "row value is invalid");
    }

    private int checkColumn(int column) {
        return check(column, "column value is invalid");
    }

    private int check(int number, String errMessage) {
        if (number < 1)
            throw new IllegalArgumentException(errMessage);
        return number;
    }
}
