package multiply;

import matrix.Matrix;

public class BlockMatrixMultiply implements MatrixMultiply {
    private static final int THREAD_SIZE = Runtime.getRuntime().availableProcessors();

    @Override
    public Matrix multiply(Matrix m1, Matrix m2) {
        checkDimension(m1, m2);
        Matrix result = new Matrix(m1.getRow(), m2.getColumn());
        MatrixMultiplierThread[] tasks = new MatrixMultiplierThread[THREAD_SIZE];

        int startRow = 0;
        int basicRowsPerThreads = m1.getRow() / (THREAD_SIZE);

        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = new MatrixMultiplierThread(m1, m2, result, startRow, basicRowsPerThreads);
            tasks[i].start();
            startRow += basicRowsPerThreads;
        }

        for (MatrixMultiplierThread thread : tasks) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public int getPoolSize() {
        return THREAD_SIZE;
    }

    @Override
    public void checkDimension(Matrix m1, Matrix m2) {
        if (m1.getColumn() != m2.getRow()) {
            throw new IllegalArgumentException("m1 columns is not equals to m2 rows.");
        }
    }
}
