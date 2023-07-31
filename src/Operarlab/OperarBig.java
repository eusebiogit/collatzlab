package Operarlab;

import java.math.BigInteger;
import java.util.LinkedList;

/**
 * Realiza operaciones sobre dos numeros enteros de tamaño BigInteger pasadas en
 * formato String ej: ("num"+"operador"+"num2")
 *
 * @author ordenador
 */
public class OperarBig {

    private static final String operaciones[] = {"\\+", "-", "\\*", "/", "\\^", "%", "c", "!=", ">=", "<=", "=", ">", "<", "sqrt"};

    /**
     * Devuelve un biginteger resultado de realizar la operación pasada como
     * string
     *
     * @param numero
     * @return
     */
    public static Object operar(String numero) {
        Object ob = null;
        String operandos[] = {};
        String operador = "";
        for (int i = 0; i < operaciones.length && operandos.length != 2; i++) {
            operador = operaciones[i];
            operandos = numero.split(operador);
        }
        if (operandos.length == 2) {
            ob = opera(operandos, operador);
        }
        return ob;
    }

    public static boolean operacion(String expresion) {
        String operador;
        String operandos[] = {};
        for (int i = 0; i < operaciones.length && operandos.length != 2; i++) {
            operador = operaciones[i];
            operandos = expresion.split(operador);
        }
        return operandos.length == 2;
    }

    /**
     * Realiza la operacion a partir de dos operandos en String y un operador y
     * la devuelve en BigInteger
     *
     * @param operandos
     * @param operador
     * @return
     */
    private static Object opera(String operandos[], String operador) {
        Object result = null;
        switch (operador) {
            case "\\+":
                result = new BigInteger(operandos[0]).add(new BigInteger(operandos[1]));
                break;
            case "-":
                result = new BigInteger(operandos[0]).subtract(new BigInteger(operandos[1]));
                break;
            case "\\*":
                result = new BigInteger(operandos[0]).multiply(new BigInteger(operandos[1]));
                break;
            case "/":
                result = new BigInteger(operandos[0]).divide(new BigInteger(operandos[1]));
                break;
            case "\\^":
                result = new BigInteger(operandos[0]).pow(new BigInteger(operandos[1]).intValue());
                break;
            case "%":
                result = new BigInteger(operandos[0]).mod(new BigInteger(operandos[1]));
                break;
            case "c":
                result = new BigInteger(new BigInteger(operandos[0]) + "" + new BigInteger(operandos[1]));
                break;
            case ">=":
                result = new BigInteger(operandos[0]).compareTo(new BigInteger(operandos[1])) >= 0;
                break;
            case ">":
                result = new BigInteger(operandos[0]).compareTo(new BigInteger(operandos[1])) > 0;
                break;
            case "=":
                result = new BigInteger(operandos[0]).compareTo(new BigInteger(operandos[1])) == 0;
                break;
            case "<=":
                result = new BigInteger(operandos[0]).compareTo(new BigInteger(operandos[1])) <= 0;
                break;
            case "<":
                result = new BigInteger(operandos[0]).compareTo(new BigInteger(operandos[1])) < 0;
                break;
            case "sqrt":
                result = new BigInteger(operandos[1]).sqrt();
                break;
            case "!=":
                result = !new BigInteger(operandos[0]).equals(new BigInteger(operandos[1]));
                break;
        }
        return result;
    }

    public static String sumaDigitos(String num) {
        return sumaDigitos(new BigInteger(num)) + "";
    }

    public static BigInteger sumaDigitos(BigInteger num) {
        BigInteger resultado = new BigInteger(0 + "");
        do {
            while (num.compareTo(new BigInteger(0 + "")) > 0) {
                resultado = resultado.add(num.mod(new BigInteger(10 + "")));
                num = num.divide(new BigInteger(10 + ""));
            }
            if (resultado.compareTo(new BigInteger(9 + "")) > 0) {
                num = resultado;
                resultado = new BigInteger(0 + "");
            }
        } while (num.compareTo(new BigInteger(9 + "")) > 0);
        return resultado;
    }

    /**
     * Fuente:
     * http://chuwiki.chuidiang.org/index.php?title=Descomposici%C3%B3n_en_factores_primos
     *
     * @param valor
     * @return
     */
    public static LinkedList<String> factoresPrimos(String valor) {

        // Se empieza probando como posible factor primo el 2.
        String factor = "2";
        LinkedList<String> factores = new LinkedList<String>();

        // Ultimo factor que debemos probar.
        BigInteger factorLimite = (BigInteger) operar("sqrt" + valor);
        String limite = factorLimite + "";

        while ((boolean) operar(factor + "<=" + limite)) {
            // Mientras es divisible, se añade el factor a la lista de factores primos
            // y se realiza la división.
            while ((boolean) operar((BigInteger) operar(valor + "%" + factor) + "=0")) {
                factores.add(factor);
                valor = ((BigInteger) operar(valor + "/" + factor)) + "";
            }

            // Si no es divisible, se pasa al posible siguiente factor.
            if ((boolean) operar(factor + "=2")) {
                factor = ((BigInteger) operar(factor + "+1")) + "";
            } else {
                factor = ((BigInteger) operar(factor + "+2")) + "";
            }
        }

        // Si no se ha logrado la descomposición total, añadimos el último valor que
        // queda a la lista.
        if ((boolean) operar(valor + "!=2")) {
            factores.add(valor);
        }

        return factores;
    }

    public static boolean par(String num) {
        return (boolean) OperarBig.operar(OperarBig.operar(num + "%2") + "=0");
    }
}
