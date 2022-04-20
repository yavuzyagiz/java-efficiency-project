package multiply;

import matrix.Matrix;

public interface MatrixMultiply {
    void checkDimension(Matrix m1, Matrix m2);
    Matrix multiply(Matrix m1, Matrix m2);
}
