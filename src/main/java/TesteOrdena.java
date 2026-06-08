/**
 * Disciplina: Engenharia de Dados
 * Alunos: Caio César Santos Carvalho, Eduardo Lopes Chagas, Naabi Anne Ribeiro Rodrigues
 * Data: 07/06/2026
 * Objetivo: Classe responsável pela tomada de tempo dos algoritmos de ordenação,
 *           calculando a média de 100 execuções para cada vetor dos datasets 1 e 2.
 */


import java.util.List;

public class TesteOrdena {
    public static void main(String[] args) {
        //-----Criar vetor novo
        //List<Item[]> dataset1 = Utilidade.gerarDataset(new int[]{1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000});
        //List<Item[]> dataset2 = Utilidade.gerarDataset(new int[]{10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000});

        //----Apos criado, colocar no arquivo
        //Utilidade.salvarDataset(dataset2,"dataset2.txt");

        List<Item[]> dataset1 = Utilidade.lerDataset("dataset1.txt");
        List<Item[]> dataset2 = Utilidade.lerDataset("dataset2.txt");

        //pegando o primeiro (dataset1.get[0]) O mesmo que
//        Ordena.mergeSort(dataset1.getFirst().clone());
//        Ordena.shellSort(dataset1.getFirst().clone());
//        Ordena.quickSort(dataset1.getFirst().clone());


 //       Aquecendo a JVM
        for(Item[] vetor : dataset1) {
            for (int i = 0; i < 1000; i++) {
                Item[] copia = vetor.clone();
                Ordena.mergeSort(copia);
            }
        }

        //DATASET 1 {1.000 A 10.000 ELEMENTOS}
        /*System.out.println("\n-------MergeSort---------\n");
        medirMergeSort(dataset1);
        System.out.println("\n-------QuickSort---------\n");
        medirQuickSort(dataset1);
        System.out.println("\n-------ShellSort---------\n");
        medirShellSort(dataset1);
*/

        //DATASET 2 {10.000 A 100.000 ELEMENTOS}
        System.out.println("\n-------MergeSort---------\n");
        medirMergeSort(dataset2);
        System.out.println("\n-------QuickSort---------\n");
        medirQuickSort(dataset2);
        System.out.println("\n-------ShellSort---------\n");
        medirShellSort(dataset2);
    }

    public static void medirMergeSort (List<Item[]> dataset){
        for (Item[] vetor : dataset) {
            //merge
            long soma = 0;
            for (int i = 0; i < 100; i++) {
                Item[] copia = vetor.clone();
                long inicio = System.nanoTime();
                Ordena.mergeSort(copia);
                soma += System.nanoTime() - inicio;
            }
            double tempo = soma / 100.0;
            double ms = tempo / 1_000_000.0;
            System.out.println("MergeSort - tamanho " + vetor.length + ": " + ms + " ms");
        }
    }

    public static void medirQuickSort (List<Item[]> dataset){
        for (Item[] vetor : dataset) {
            //quick
            long soma = 0;
            for (int i = 0; i < 100; i++) {
                Item[] copia = vetor.clone();
                long inicio = System.nanoTime();
                Ordena.quickSort(copia);
                soma += System.nanoTime() - inicio;
            }
            double tempo = soma / 100.0;
            double ms = tempo / 1_000_000.0;

            System.out.println("QuickSort - tamanho " + vetor.length + ": " + ms + " ms");
        }
    }

    public static void medirShellSort (List<Item[]> dataset) {
        for (Item[] vetor : dataset) {
            //shellSort
            long soma = 0;
            for (int i = 0; i < 100; i++) {
                Item[] copia = vetor.clone();
                long inicio = System.nanoTime();
                Ordena.shellSort(copia);
                soma += System.nanoTime() - inicio;
            }
            double tempo = soma / 100.0;
            double ms = tempo / 1_000_000.0;

            System.out.println("ShellSort - tamanho " + vetor.length + ": " + ms + " ms");
        }
    }
}
