import multiply.MatrixMultiply;
import multiply.MultiplicationFactory;
import matrix.Matrix;

public class Main {

    public static void main(String args[]) {

        MatrixMultiply blockMatrixMultiply = MultiplicationFactory.getMultiply(MultiplicationFactory.BLOCK_DATA_SHARING);
        MatrixMultiply sequentialMatrixMultiply = MultiplicationFactory.getMultiply(MultiplicationFactory.SEQUENTIAL_DATA_SHARING);

        Matrix[] sequentialMatrix = new Matrix[5];
        Matrix[] blockMatrix = new Matrix[5];
        long startTime = System.currentTimeMillis();
        for (int i=0;i<blockMatrix.length;i++){
            blockMatrix[i] = new Matrix((i+1)*1000, (i+1)*1000,1f);
            blockMatrixMultiply.multiply(blockMatrix[i], blockMatrix[i]);
        }
        long endTime = System.currentTimeMillis();
        long runningTime = endTime - startTime;
        System.out.println("Block Data Sharing=" + runningTime);


        startTime = System.currentTimeMillis();
        for (int i = 0; i < sequentialMatrix.length; i++) {
            sequentialMatrix[i] = new Matrix((i + 1) * 1000, (i + 1) * 1000, 1f);
            sequentialMatrixMultiply.multiply(sequentialMatrix[i], sequentialMatrix[i]);
        }
        endTime = System.currentTimeMillis();
        runningTime = endTime - startTime;
        System.out.println("Sequential Data Sharing=" + runningTime);


    }
}
