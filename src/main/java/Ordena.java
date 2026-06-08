/**
 * Disciplina: Engenharia de Dados
 * Alunos: Caio César Santos Carvalho, Eduardo Lopes Chagas, Naabi Anne Ribeiro Rodrigues
 * Data: 06/06/2026
 * Objetivo: Classe responsável pela implementação dos algoritmos de ordenação
 *           ShellSort, QuickSort e MergeSort sobre vetores de objetos Item.
 */


public class Ordena {
    public static void shellSort(Item[] vet) {
        int j, i, h;
        Item x;

        int nElems = vet.length;

        h = 1;

        do {
            h = h * 3 + 1;
        } while (h < nElems);

        do {

            h = h / 3;

            for (i = h; i < nElems; i++) {

                x = vet[i];
                j = i;

                while (j >= h && vet[j - h].compareTo(x) > 0) {

                    vet[j] = vet[j - h];
                    j = j - h;
                }

                vet[j] = x;
            }

        } while (h != 1);
    }


    // QUICKSORT
    public static void quickSort(Item[] vetor) {
        ordena(vetor, 0, vetor.length - 1);
    }

    private static void ordena(Item[] vetor, int inicio, int fim) {

        if (inicio < fim) {

            int posicaoPivo = particao(vetor, inicio, fim);

            ordena(vetor, inicio, posicaoPivo - 1);

            ordena(vetor, posicaoPivo + 1, fim);
        }
    }

    private static int particao(Item[] vetor, int inicio, int fim) {

        Item pivo = vetor[inicio];

        int i = inicio + 1;

        int j = fim;

        while (i <= j) {

            if (vetor[i].compareTo(pivo) <= 0) {
                i++;
            } else if (pivo.compareTo(vetor[j]) < 0) {
                j--;
            } else {

                Item troca = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = troca;

                i++;
                j--;
            }
        }

        vetor[inicio] = vetor[j];
        vetor[j] = pivo;

        return j;
    }

    // MERGESORT
    public static void mergeSort(Item[] vetor) {

        mergeSort(vetor, 0, vetor.length - 1);
    }

    private static void mergeSort(Item[] vetor, int inicio, int fim) {

        if (inicio >= fim) {
            return;
        }

        int meio = (inicio + fim) / 2;

        mergeSort(vetor, inicio, meio);

        mergeSort(vetor, meio + 1, fim);

        intercala(vetor, inicio, meio, fim);
    }

    private static void intercala(Item[] vetor, int inicio, int meio, int fim) {

        Item[] auxiliar = new Item[fim - inicio + 1];

        int i = inicio;
        int j = meio + 1;
        int k = 0;

        while (i <= meio && j <= fim) {

            if (vetor[i].compareTo(vetor[j]) <= 0) {

                auxiliar[k] = vetor[i];
                i++;
            } else {

                auxiliar[k] = vetor[j];
                j++;
            }

            k++;
        }

        while (i <= meio) {

            auxiliar[k] = vetor[i];

            i++;
            k++;
        }

        while (j <= fim) {

            auxiliar[k] = vetor[j];

            j++;
            k++;
        }

        for (i = inicio, k = 0; i <= fim; i++, k++) {
            vetor[i] = auxiliar[k];
        }
    }
}