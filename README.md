# Algoritmos de Ordenação — Benchmark de Desempenho

**Disciplina:** Estrutura de Dados I  
**Alunos:** Caio César Santos Carvalho, Eduardo Lopes Chagas, Naabi Anne Ribeiro Rodrigues  
**Instituição:** IF Goiano — Campus Urutaí  
**Data:** Junho de 2026

---

## Descrição do Problema

O objetivo deste projeto é implementar e comparar o desempenho de três algoritmos clássicos de ordenação — **ShellSort**, **QuickSort** e **MergeSort** — sobre diferentes volumes de dados, medindo o tempo médio de execução de cada um.

Para isso, foram criados dois conjuntos de dados (datasets) com vetores de tamanhos crescentes, preenchidos com valores inteiros aleatórios. Cada algoritmo foi executado **100 vezes** sobre cada vetor, e o tempo médio foi registrado em milissegundos.

---

## Estrutura do Projeto

```
algoritmos-de-ordenacao/
├── src/main/java/
│   ├── Item.java          # Objeto a ser ordenado
│   ├── Ordena.java        # Implementações dos algoritmos
│   ├── Utilidade.java     # Geração, leitura e escrita dos datasets
│   └── TesteOrdena.java   # Benchmark e tomada de tempo
├── dataset1.txt           # Dataset 1 (1.000 a 10.000 elementos)
├── dataset2.txt           # Dataset 2 (10.000 a 100.000 elementos)
└── README.md
```

### Descrição das Classes

**`Item`**  
Representa o objeto a ser ordenado. Encapsula um valor inteiro e implementa `Comparable<Item>` para definir a ordem natural dos elementos.

**`Ordena`**  
Contém as implementações dos três algoritmos de ordenação. Todos os métodos recebem `Item[]` como entrada e ordenam o vetor in-place (exceto o MergeSort, que utiliza um array auxiliar na etapa de intercalação).

**`Utilidade`**  
Responsável pela geração dos datasets com valores aleatórios, pela escrita em arquivo `.txt` e pela leitura e reconstrução dos vetores a partir do arquivo.

**`TesteOrdena`**  
Realiza o benchmark: lê os datasets do arquivo, aquece a JVM com execuções prévias e mede o tempo médio de 100 execuções de cada algoritmo sobre cada vetor.

---

## Datasets

| Dataset | Tamanhos dos vetores |
|---|---|
| Dataset 1 | 1.000 — 2.000 — 3.000 — 4.000 — 5.000 — 6.000 — 7.000 — 8.000 — 9.000 — 10.000 |
| Dataset 2 | 10.000 — 20.000 — 30.000 — 40.000 — 50.000 — 60.000 — 70.000 — 80.000 — 90.000 — 100.000 |

Os vetores são gerados com valores inteiros aleatórios entre 0 e 100.000, salvos em arquivo `.txt` (uma linha por vetor) e reutilizados em todas as execuções para garantir comparações justas.

---

## Solução

### Metodologia

1. Os datasets são gerados uma única vez e salvos em arquivo, garantindo que todos os algoritmos recebam exatamente os mesmos dados.
2. Antes de cada execução, o vetor é clonado via `.clone()` para garantir que cada algoritmo opere sobre uma cópia independente do vetor original.
3. O tempo é medido com `System.nanoTime()`, que oferece precisão em nanossegundos — adequado para benchmarks em java.
4. A JVM é aquecida antes das medições para evitar distorções causadas pela compilação JIT nas primeiras execuções.

### Fórmula do benchmark, utilizada para o tempo

```
soma = 0
para i de 0 até 99:
    copia = vetor.clone()
    inicio = nanoTime()
    algoritmo(copia)
    soma += nanoTime() - inicio
tempo_medio = soma / 100
```

---

## Algoritmos Implementados

### ShellSort
Extensão do InsertionSort que ordena elementos distantes entre si antes de aproximá-los, reduzindo o número de trocas. Utiliza a sequência de Knuth (h = h * 3 + 1) para calcular os intervalos de comparação.

- **Complexidade:** O(n log² n)
- **Memória:** In-place (O(1) extra)

### QuickSort
Algoritmo de divisão e conquista que seleciona um pivô, particiona o vetor em elementos menores e maiores, e ordena as partições recursivamente. Utiliza o primeiro elemento como pivô.

- **Complexidade média:** O(n log n)
- **Complexidade pior caso:** O(n²)
- **Memória:** In-place (O(log n) na pilha de recursão)

### MergeSort
Algoritmo de divisão e conquista que divide o vetor ao meio recursivamente e intercala os subvetores já ordenados. Garante desempenho consistente em qualquer entrada.

- **Complexidade:** O(n log n) sempre
- **Memória:** O(n) extra (array auxiliar na intercalação)

---

## Resultados

### Dataset 1 — vetores de 1.000 a 10.000 elementos

| Tamanho | QuickSort | ShellSort | MergeSort |
|---|---|---|---|
| 1.000 | 0,043 ms | 0,128 ms | 0,204 ms |
| 2.000 | 0,073 ms | 0,125 ms | 0,182 ms |
| 3.000 | 0,134 ms | 0,214 ms | 0,276 ms |
| 4.000 | 0,202 ms | 0,311 ms | 0,425 ms |
| 5.000 | 0,318 ms | 0,426 ms | 0,498 ms |
| 6.000 | 0,411 ms | 0,517 ms | 0,692 ms |
| 7.000 | 0,426 ms | 0,707 ms | 0,677 ms |
| 8.000 | 0,477 ms | 0,785 ms | 0,822 ms |
| 9.000 | 0,561 ms | 0,857 ms | 1,004 ms |
| 10.000 | 0,619 ms | 1,019 ms | 1,194 ms |

### Dataset 2 — vetores de 10.000 a 100.000 elementos

| Tamanho | QuickSort | MergeSort | ShellSort |
|---|---|---|---|
| 10.000 | 0,649 ms | 1,414 ms | 1,019 ms |
| 20.000 | 1,374 ms | 2,438 ms | 2,285 ms |
| 30.000 | 2,213 ms | 3,761 ms | 3,783 ms |
| 40.000 | 3,099 ms | 4,654 ms | 5,249 ms |
| 50.000 | 4,031 ms | 6,130 ms | 6,831 ms |
| 60.000 | 4,877 ms | 7,848 ms | 8,669 ms |
| 70.000 | 5,878 ms | 9,253 ms | 10,925 ms |
| 80.000 | 6,726 ms | 10,377 ms | 12,355 ms |
| 90.000 | 7,835 ms | 11,833 ms | 14,718 ms |
| 100.000 | 8,710 ms | 13,379 ms | 16,684 ms |

---

## Seção de gráficos

![image1](https://raw.githubusercontent.com/caiocvo/algoritmos-de-ordenacao/blob/main/images/image3.png)
![image1](https://raw.githubusercontent.com/caiocvo/algoritmos-de-ordenacao/blob/main/images/image2.png)
![image1](https://raw.githubusercontent.com/caiocvo/algoritmos-de-ordenacao/blob/main/images/image1.png)


---

## Análise dos Gráficos

### Dataset 1 (1k a 10k elementos)

No dataset 1, o **QuickSort** se manteve consistentemente mais rápido. O **MergeSort** apresentou os maiores tempos nos vetores menores, o que se explica pelo custo de alocação do array auxiliar — esse custo fixo pesa mais quando o vetor é pequeno. O **ShellSort** ficou numa posição intermediária.

### Dataset 2 (10k a 100k elementos)

Com volumes maiores, o comportamento ficou mais claro:

- **QuickSort** manteve crescimento linear suave, confirmando seu desempenho médio O(n log n) com constantes pequenas.
- **MergeSort** ficou em posição intermediária — sua complexidade O(n log n) é garantida, mas o custo de alocação de memória a cada intercalação o torna mais lento que o QuickSort na prática.
- **ShellSort** mostrou crescimento mais acentuado com volumes altos, evidenciando sua complexidade O(n^1.5) se distanciando dos outros dois.

### Gráfico de escala logarítmica

O gráfico em escala logarítmica evidencia claramente a diferença de crescimento entre os algoritmos: as curvas do QuickSort e MergeSort crescem de forma semelhante (O(n log n)), enquanto o ShellSort se distancia progressivamente com o aumento do volume de dados.

---

## Por que o QuickSort vence na prática?

Embora QuickSort e MergeSort tenham a mesma complexidade assintótica O(n log n), o QuickSort é mais rápido na prática por três razões principais:

1. **Opera in-place:** não aloca memória extra no heap, evitando chamadas ao sistema operacional.
2. **Melhor uso de cache:** trabalha sempre no mesmo array, mantendo os dados no cache da CPU. O MergeSort precisa de dois arrays simultaneamente, dobrando a pressão no cache.
3. **Aproveita dados parcialmente ordenados:** dados reais tendem a ter sequências já ordenadas, o que beneficia a fase de partição do QuickSort.

