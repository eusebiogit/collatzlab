package collatzlab;

import Operarlab.OperarBig;
import java.math.BigInteger;

/**
 *
 * @author ordenador
 */
public class Collatz {

    private String num;
    private int ramas;

    public Collatz(String num) {
        this.num = num;
        this.ramas = 1;
    }

    public Collatz(int num) {
        this(num + "");
    }

    public Collatz(BigInteger num) {
        this(num + "");
    }

    public void run() {
        ejecutar(this.num);
        System.out.println("ramas: " + this.ramas);
    }

    public void ejecutar(String num) {
        System.out.println(num);
        System.out.println();
        while ((boolean) OperarBig.operar(num + "!=1")) {
            if (OperarBig.par(num)) {
                num = ((BigInteger) OperarBig.operar(num + "/2")) + "";
            } else {
                this.ramas++;
                num = ((BigInteger) (OperarBig.operar((BigInteger) OperarBig.operar(num + "*3") + "+1"))) + "";
            }
            System.out.println(num);
            System.out.println();
        }

    }

    /**
     * @param num
     * @param max Devuelve las entradas de una rama
     * @return
     */
    public int puertas(String num, String max) {
        int puertas = 0;
        String aux = "";
        int c=0;
            while ((Boolean) OperarBig.operar(max + ">0")) {
                c++;
                if(c%10000==0){
                    System.out.println("N: "+num);
                }
                
                
                aux=OperarBig.operar(num+"-1")+"";
                if((Boolean)OperarBig.operar(OperarBig.operar(aux+"%3")+"=0")){
                    max = OperarBig.operar(max + "-1") + "";
                    aux=OperarBig.operar(aux+"/3")+"";
                    System.out.println(aux+" -> "+num);
                }
                    num=OperarBig.operar(num+"*2")+"";
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
