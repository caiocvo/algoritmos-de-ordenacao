import java.util.Random;

public class Unidade {
    public static void main(String[] args) {
        int[][] dataset = new int[10][];
        dataset[0] = new int[10];
        dataset[1] = new int[20];
        dataset[2] = new int[30];
        dataset[3] = new int[40];
        dataset[4] = new int[50];
        dataset[5] = new int[60];
        dataset[6] = new int[70];
        dataset[7] = new int[80];
        dataset[8] = new int[90];
        dataset[9] = new int[100];

        gerarVetor(dataset[0]);
        gerarVetor(dataset[1]);
        gerarVetor(dataset[2]);
        gerarVetor(dataset[3]);

        mostrarVetor(dataset[2]);
        System.out.println();
        mostrarVetor(dataset[1]);
        System.out.println();
        mostrarVetor(dataset[0]);

    }

    public static void gerarVetor(int[] entrada){
        Random random = new Random();
        for (int i = 0; i < entrada.length; i++){
            entrada[i] = random.nextInt(100);
        }
    }

    public static void mostrarVetor(int[] entrada){
        int salto = 0;
        for (int elementos : entrada) {
            System.out.print(elementos+" ");
            salto++;
            if (salto == 10) {
                System.out.println();
                salto = 0;
            }
        }

    }
}
