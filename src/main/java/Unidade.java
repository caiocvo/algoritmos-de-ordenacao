import java.util.Random;

public class Unidade {
    public static void main(String[] args) {

    }

    public Integer [] gerarVetor(int tamanho){
        Random random = new Random();
        Integer []vetor = new Integer[tamanho];

        for (int i = 0; i < tamanho; i++){
            vetor[i] = random.nextInt(1000000);
        }
        return vetor;
    }
}
