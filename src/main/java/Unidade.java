import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Unidade {
    public static void main(String[] args) {

        //Criar o dataset1
        int[][] dataset = new int[10][];
        dataset[0] = new int[1000];
        dataset[1] = new int[2000];
        dataset[2] = new int[3000];
        dataset[3] = new int[4000];
        dataset[4] = new int[5000];
        dataset[5] = new int[6000];
        dataset[6] = new int[7000];
        dataset[7] = new int[8000];
        dataset[8] = new int[9000];
        dataset[9] = new int[10000];

        for (int[] ints : dataset) gerarVetor(ints);

        salvarDataset(dataset, "dataset1.txt");

    }

    public static void gerarVetor(int[] entrada){
        Random random = new Random();
        for (int i = 0; i < entrada.length; i++){
            entrada[i] = random.nextInt(100);
        }
    }

    public static void salvarDataset(int[][] dataset, String caminho) {
        try {
            FileWriter fw = new FileWriter(caminho, false);
            for (int i = 0; i < dataset.length; i++) {
                for (int j = 0; j < dataset[i].length; j++) {
                    fw.write(dataset[i][j] + " ");
                }
                fw.write("\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
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
