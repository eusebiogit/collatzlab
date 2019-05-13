package collatzlab;

import Operarlab.OperarBig;
import collatzlab.Collatz;
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
        
        Collatz c=null;
        if(args.length==1){
            if(OperarBig.operacion(args[0])){
                c=new Collatz(OperarBig.operar(args[0])+"");
            }else{
                c=new Collatz(args[0]);
            }
            c.run();
        
        }
        else{
            //seguridad git
            c=new Collatz("");
            c.puertas("66","1");
        }
        
        
        
        
    }
}
