package collatzlab;

import Operarlab.OperarBig;
import dominio.Collatz;
import java.math.BigInteger;

/**
 *
 * @author ordenador
 */
public class Collatzlab {

    private static Collatz c = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length!=0) {
            sucesion(args[0]);
        }
//        System.out.println(OperarBig.factoresPrimos("6148914691236517205"));
    }

    /**
     * Sucesion de collatz
     */
    public static void sucesion(String num) {
        if (OperarBig.operacion(num)) {
            c = new Collatz(OperarBig.operar(num) + "");
        } else {
            c = new Collatz(num);
        }
        c.run(true);

    }

    
    
    
}
