package multiply;

import matrix.Matrix;

public class SequentialMatrixMultiply implements MatrixMultiply {

    public Matrix multiply(Matrix m1, Matrix m2) {
        checkDimension(m1,m2);

        double total = 0.0;
        Matrix temp = new Matrix(m1.getRow(), m2.getColumn());

        for (int i = 0; i < m1.getRow(); i++) {
            for (int j = 0; j < m2.getColumn(); j++) {
                for (int k = 0; k < m1.getColumn(); k++) {
                    total += m1.getValue(i, k) * m2.getValue(k, j);
                }
                temp.setValue(i, j, total);
                total = 0f;
            }
        }
        return temp;
    }


    @Override
    public void checkDimension(Matrix m1, Matrix m2) {
        if(m1.getColumn() != m2.getRow()){
            throw new IllegalArgumentException("m1 columns is not equals to m2 rows.");
        }
    }
}
