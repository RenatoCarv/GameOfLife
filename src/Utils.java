import java.util.Random;
public class Utils {
    public static boolean ehInteiroValido(String valor) {
        for (char c : valor.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static String gerarPopulacaoAleatoria(int tamanho) {
        StringBuilder populacaoAleatoria = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            populacaoAleatoria.append(random.nextInt(2));
        }
        return populacaoAleatoria.toString();
    }
}

