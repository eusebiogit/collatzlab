package collatzlab;

import Operarlab.OperarBig;
import dominio.Collatz;
import java.math.BigInteger;

/**
 *
 * @author ordenador
 */
public class Collatzlab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Collatz c = null;
        if (args.length == 1) {
            if (OperarBig.operacion(args[0])) {
                c = new Collatz(OperarBig.operar(args[0]) + "");
            } else {
                c = new Collatz(args[0]);
            }
            c.run(true);
            System.out.println("ramas: " + c.getRamas());
        } else if (args.length == 2) {
            int num=ramaMasLarga(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            c = new Collatz(num);
            c.run(true);
            System.out.println("Numero :"+num);
            System.out.println("Ramas :"+c.getRamas());
        }

    }
    

    public static int ramaMasLarga(int init, int fin) {
        Collatz c;
        int max = 0;
        int num = 0;
        for (int i = init; i < fin; i++) {
            c = new Collatz(i);
            c.run(false);
            if (c.getRamas() > max) {
                max = c.getRamas();
                num = i;
            }
        }
        return num;
    }

}
