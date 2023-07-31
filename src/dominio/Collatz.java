package dominio;

import Operarlab.OperarBig;
import java.math.BigInteger;

/**
 *
 * @author ordenador
 */
public class Collatz {

    private String num;
    private String camino;
    private int ramas;

    public Collatz(String num) {
        this.num = num;
        this.ramas = 1;
        this.camino = "";
    }

    public Collatz(int num) {
        this(num + "");
    }

    public Collatz(BigInteger num) {
        this(num + "");
    }

    public void run(boolean v) {
        if ((boolean) OperarBig.operar(this.num + ">0")) {
            ejecutar(this.num, v);
        }
    }

    public void ejecutar(String num, boolean v) {
        if (v) {
            System.out.println(num);
            System.out.println();
        }
        while ((boolean) OperarBig.operar(num + "!=1")) {
            if (OperarBig.par(num)) {
                num = ((BigInteger) OperarBig.operar(num + "/2")) + "";
            } else {
                this.ramas++;
                camino += (camino == "" ? "" : " => ") + num;
                num = ((BigInteger) (OperarBig.operar((BigInteger) OperarBig.operar(num + "*3") + "+1"))) + "";
            }
            if (v) {
                System.out.println(num + "    "+OperarBig.sumaDigitos(num));
                System.out.println();
            }
        }
        camino += " => " + num;

    }



    public String getCamino() {
        if (camino == "") {
            this.run(false);
        }
        return this.camino;
    }

    /**
     * @param num
     * @param max Devuelve las entradas de una rama
     * @return
     */
    public int puertas(String max) {
        int puertas = 0;
        String aux = "";
        int c = 0;
        while ((Boolean) OperarBig.operar(max + ">0")) {
            c++;
            aux = OperarBig.operar(num + "-1") + "";
            if (!OperarBig.par(aux) && (Boolean) OperarBig.operar(OperarBig.operar(aux + "%3") + "=0")) {
                max = OperarBig.operar(max + "-1") + "";
                aux = OperarBig.operar(aux + "/3") + "";
                System.out.println(aux + " -> " + num);
                puertas++;
            }
            num = OperarBig.operar(num + "*2") + "";
        }
        return puertas;
    }

    /**
     * Devuelve las ramas de la sucesión calculada
     *
     * @return
     */
    public int getRamas() {
        return ramas;
    }

}
