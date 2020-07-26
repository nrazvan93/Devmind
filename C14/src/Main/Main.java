package Main;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("test");

        Matrix a = new Matrix(2);
        Matrix b = new Matrix(2);
        a.populateMatrix(3);
        b.populateMatrix(4);
        a.updateMatrixParameters();
//        b.updateMatrixParameters();
        a.printMatrix();
        b.printMatrix();
        Matrix c = Matrix.matrixOperations(a,b, "multiply");
        Matrix d = Matrix.matrixOperations(a,b, "add");
        c.printMatrix();
        d.printMatrix();
    }
}
