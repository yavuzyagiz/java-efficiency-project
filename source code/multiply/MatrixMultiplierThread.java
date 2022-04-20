package multiply;

import matrix.Matrix;

public class MatrixMultiplierThread extends Thread {

    private final Matrix m1;
    private final Matrix m2;
    private final Matrix result;
    private final int startRows;
    private final int rows;

    MatrixMultiplierThread(Matrix m1, Matrix m2, Matrix result, int startRows, int rows){
        this.m1 = m1;
        this.m2 = m2;
        this.result = result;
        this.startRows = startRows;
        this.rows = rows;
    }

    @Override
    public void run() {
        super.run();
        multiply();
    }

    private void multiply(){
        double sum = 0f;
        for (int i=startRows;i<startRows+rows;i++){
            for (int j=0;j<m2.getColumn();j++){
                for (int k=0;k<m1.getColumn();k++){
                    sum += m1.getValue(i,k) * m2.getValue(k,j);
                }
                result.setValue(i,j,sum);
                sum = 0f;
            }
        }
    }

}
