package com.webdev.test;

/**
 * Created by henriezhang on 2014/11/4.
 */
import Jama.Matrix;

/**
 * Created by Administrator on 2014/10/25 0025.
 */
public class MatrixTest {
    public static void main(String[] args){
        double[][] array = {
                {1.,2.,3},
                {4.,5.,6.},
                {7.,8.,10.}
        };
        Matrix A = new Matrix(array);
        //Matrix b = Matrix.random(3,1);

        Matrix c = A.inverse();
        A.print(4,3);
        c.print(4,3);

        Matrix d = A.times(c);
        d.print(4,3);


        /*Printer.print2Darray(b.getArray());
        System.out.println("matrix call ok 1");

        Matrix x = A.solve(b);
        Printer.print2Darray(x.getArray());
        System.out.println("matrix call ok 2");

        Matrix Residual = A.times(x).minus(b);
        Printer.print2Darray(Residual.getArray());
        System.out.println("matrix call ok 3");

        double rnorm = Residual.normInf();
        System.out.println("matrix call ok 4:"+rnorm);*/
    }
}

