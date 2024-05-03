package utils;

import java.util.Random;

public class GeradorCPF {

    public  String gerarCPF() {
        Random random = new Random();
        int[] cpf = new int[11];

        for (int i = 0; i < 9; i++) {
            cpf[i] = random.nextInt(10);
        }

        cpf[9] = calcularDigitoVerificador(cpf, 9);

        cpf[10] = calcularDigitoVerificador(cpf, 10);

        StringBuilder cpfString = new StringBuilder();
        for (int i = 0; i < 11; i++) {
            cpfString.append(cpf[i]);
            if (i == 2 || i == 5) {
                cpfString.append(".");
            }
            else if (i == 8) {
                cpfString.append("-");
            }
        }

        return cpfString.toString();
    }

    private  int calcularDigitoVerificador(int[] cpf, int posicao) {
        int soma = 0;
        for (int i = 0; i < posicao; i++) {
            soma += cpf[i] * (posicao + 1 - i);
        }
        int resto = soma % 11;
        if (resto < 2) {
            return 0;
        } else {
            return 11 - resto;
        }
    }
}
