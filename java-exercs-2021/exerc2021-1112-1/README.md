# Exercício 1 (12/11)

O arquivo data.csv deve ser colocado na pasta C:\TEMP.

O projeto deverá ter a seguinte estrutura, em dois pacotes.

* controller
    * IFifaController (interface)
    * FifaController (classe que implementa a interface IFifaController)
* view
    * Principal (classe com o método main)

A interface deve conter as seguintes operações.

```
public Stack<String> empilhaBrasileiros(String caminho, String nome) throws IOException
public void desmpilhaBonsBrasileiros(Stack<String> pilha) throws IOException
public List<String> listaRevelacoes(String caminho, String nome) throws IOException
public void buscaListaBonsJovens(List<String> lista) throws IOException
```

O método empilhaBrasileiros recebe o caminho e o nome do arquivo, deverá inicializar uma pilha, abrir o arquivo, ler o arquivo, verificar se na coluna referente à nacionalidade existe o valor “Brazil” e empilhar (push) a linha inteira, apenas de jogadores brasileiros. O método deve retornar essa pilha.

O método desempilhaBonsBrasileiros deve receber uma pilha de Strings como parâmetro, percorrer a pilha, desempilhar (pop) e imprimir (somente nome e Overall) apenas de jogadores com Overall acima de 80. Perceba que, como estão ordenados, no arquivo, do melhor para o pior, os jogadores serão empilhados do melhor para o pior, portanto, o primeiro impresso deverá ser o pior dentre os escolhidos e o último deverá ser Neymar Jr, com Overall 92.

O método listaRevelacoes recebe o caminho e o nome do arquivo, deverá inicializar uma lista encadeada, abrir o arquivo, ler o arquivo, verificar se na coluna referente à idade o valor é menor ou igual a 20, e adicionar (add) à lista, a linha inteira, apenas de jogadores jovens. O método deve retornar essa lista.

O método buscaListaBonsJovens deve receber uma lista de Strings como parâmetro, percorrer a lista do último para o primeiro, imprimir (somente nome, idade e Overall) apenas de jogadores com Overall acima de 80 e 20 anos ou menos.
