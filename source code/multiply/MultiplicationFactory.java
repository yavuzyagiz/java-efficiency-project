package multiply;

public class MultiplicationFactory {
    public static final int SEQUENTIAL_DATA_SHARING = 0;
    public static final int BLOCK_DATA_SHARING = 1;

    public static MatrixMultiply getMultiply(int type){
        if (type == 0)
            return new SequentialMatrixMultiply();
        else if(type == 1)
            return new BlockMatrixMultiply();
        else
            return null;
    }
}
