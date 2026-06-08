/**
 * Disciplina: Engenharia de Dados
 * Alunos: Caio César Santos Carvalho, Eduardo Lopes Chagas, Naabi Anne Ribeiro Rodrigues
 * Data: 06/06/2026
 * Objetivo: Classe utilitária responsável pela geração, salvamento e leitura dos datasets
 *           utilizados nos testes de desempenho dos algoritmos de ordenação.
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utilidade {

    public static List<Item[]> gerarDataset(int[] tamanhos) {
        List<Item[]> dataset = new ArrayList<>();
        Random random = new Random();
        for (int tamanho : tamanhos) {
            Item[] vetor = new Item[tamanho];
            for (int i = 0; i < tamanho; i++) {
                vetor[i] = new Item(random.nextInt(100000));
            }
            dataset.add(vetor);
        }
        return dataset;
    }

    public static void salvarDataset(List<Item[]> dataset, String caminho) {
        try {
            FileWriter fw = new FileWriter(caminho, false);
            for (Item[] vetor : dataset) {
                for (Item item : vetor) {
                    fw.write(item.valor() + " ");
                }
                fw.write("\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Item[]> lerDataset(String caminho) {
        List<Item[]> dataset = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(caminho));
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] elementos = linha.trim().split("\\s+");
                Item[] vetor = new Item[elementos.length];
                for (int i = 0; i < elementos.length; i++) {
                    vetor[i] = new Item(Integer.parseInt(elementos[i]));
                }
                dataset.add(vetor);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataset;
    }
}
