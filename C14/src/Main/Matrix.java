package Main;

import java.util.Scanner;

public class Matrix {

    private int[][] n;

    public Matrix(int size) {
        this.n = new int[size][size];
    }

    static Scanner sc = new Scanner(System.in);

    public void populateMatrix(int value) {
        for (int i = 0; i < this.n.length; i++) {
            for (int j = 0; j < this.n.length; j++) {
                this.n[i][j] = value;
            }
        }
    }

    public void updateMatrixParameters() {

        System.out.println("Matrix dimension: ");
        int matrixDimension = sc.nextInt();
        System.out.println("Main diag value: ");
        int mainDiagValue = sc.nextInt();
        System.out.println("Secondary diag value: ");
        int sndDiagValue = sc.nextInt();
        System.out.println("Center value: ");
        int centerValue = sc.nextInt();
        System.out.println("Left value: ");
        int leftValue = sc.nextInt();
        System.out.println("Up value: ");
        int upValue = sc.nextInt();
        System.out.println("Right value: ");
        int rightValue = sc.nextInt();
        System.out.println("Bottom value: ");
        int bottomValue = sc.nextInt();


        this.n = new int[matrixDimension][matrixDimension];

        for (int i = 0; i < matrixDimension; i++) {
            for (int j = 0; j < matrixDimension; j++) {
                if (i == j) {
                    this.n[i][j] = mainDiagValue;
                }
                if (i + j == matrixDimension - 1) {
                    this.n[i][j] = sndDiagValue;
                }
                if (matrixDimension % 2 != 0) {
                    this.n[matrixDimension / 2][matrixDimension / 2] = centerValue;
                }
                if (i > j && i + j < matrixDimension - 1) {
                    this.n[i][j] = leftValue;
                }
                if (i < j && i + j < matrixDimension - 1) {
                    this.n[i][j] = upValue;
                }
                if (i < j && i + j > matrixDimension - 1) {
                    this.n[i][j] = rightValue;
                }
                if (i > j && i + j > matrixDimension - 1) {
                    this.n[i][j] = bottomValue;
                }
            }
        }
    }

    public void printMatrix() {
        for (int i = 0; i < this.n.length; i++) {
            for (int j = 0; j < this.n.length; j++) {
                System.out.print(this.n[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------");
    }

    public int getMatrixSize() {
        return n.length;
    }

    public static Matrix matrixOperations(Matrix a, Matrix b, String operation) {
        Matrix c = new Matrix(a.getMatrixSize());
        if (a.getMatrixSize() == b.getMatrixSize()) {
            for (int i = 0; i < a.getMatrixSize(); i++) {
                for (int j = 0; j < a.getMatrixSize(); j++) {
                    if (operation.equals("add")) {
                        c.n[i][j] = a.n[i][j] + b.n[i][j];
                    } else if (operation.equals("substract")) {
                        c.n[i][j] = a.n[i][j] - b.n[i][j];
                    } else if (operation.equals("multiply")) {
                        for (int k = 0; k < a.getMatrixSize(); k++) {
                            c.n[i][j] += a.n[i][k] * b.n[k][j];
                        }
                    } else {
                        System.out.println("Valid operations: add / substract");
                    }
                }
            }
        } else {
            System.out.println("Matrices must have the same size for this operation");
        }
        return c;
    }

    public static Matrix matrixOperations(Matrix a, int scalar) {
        for (int i = 0; i < a.getMatrixSize(); i++) {
            for (int j = 0; j < a.getMatrixSize(); j++) {
                a.n[i][j] = a.n[i][j] * scalar;
            }
        }
        return a;
    }
}
