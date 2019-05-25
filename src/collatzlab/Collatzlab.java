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

        int argumentos = args.length;
        if (argumentos == 1) {
            sucesion(args[0]);
        } else if (argumentos >= 2) {
            switch (args[0]) {
                case "i":           //rama mas larga intervalo
                    int num = ramaMasLarga(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
                    c = new Collatz(num);
                    c.run(true);
                    System.out.println("Numero :" + num);
                    System.out.println("Ramas :" + c.getRamas());
                    break;
                case "c":   //caminos
                    if (OperarBig.operacion(args[1])) {
                        c = new Collatz(OperarBig.operar(args[1]) + "");
                    } else {
                        c = new Collatz(args[1]);
                    }
                    System.out.println(c.getCamino());
                    break;
                case "ci":   //caminos intervalo
                    for (BigInteger i = new BigInteger("0"); (Boolean) OperarBig.operar(i + "<" + args[2]);
                            i = (BigInteger) OperarBig.operar(i + "+1")) {
                        c = new Collatz(i);
                        System.out.println(c.getCamino());
                    }
                    break;
                case "s":   //sucesion
                    sucesion(args[1]);
                    break;
                case "p":   //entradas
                    c = new Collatz(args[1]);
                    System.out.println("Puertas:" + c.puertas("50"));
                    break;
                case "h":
                    ayuda();
                    break;
                default:

            }

        } else {

        }
        ramasExtremasSaltos(1, 10000, 3);
//        c=new Collatz(2);
//        c.puertasRamasExtremas("20");



    }
    
    
    
    

    public static void ramasExtremasSaltos(int init, int fin, int saltos) {
        for (int i = init; i < fin; i++) {
            if (i % 3 == 0 && i % 2 != 0) {
                c = new Collatz(i);
                c.run(false);
                if (c.getRamas() == saltos) {
                    System.out.println(i);
                }
            }
        }
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
        System.out.println("ramas: " + c.getRamas());

    }

    /**
     * Muestra la ayuda
     */
    public static void ayuda() {
        System.out.println("collatz i c h");
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
