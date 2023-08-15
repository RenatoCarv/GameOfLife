/**
 * Classe de utilitários com métodos auxiliares para verificação de valores inteiros.
 */
public class Utils {
    /**
     * Verifica se uma string contém um valor inteiro válido.
     *
     * @param valor A string que se deseja verificar.
     * @return true se a string contiver um valor inteiro válido, false caso contrário.
     */
    static boolean ehInteiroValido(String valor) {
        for (char c : valor.toCharArray()) {
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}



