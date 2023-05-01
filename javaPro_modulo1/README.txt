Exercício 4 

pilha push o(1) pop o(1) porque não uso repetições para processamento dos mesmos 

Fila Enqueaue o(1) Dequeue o(1) porque não tem repetições tratando de forma unitária

Lista push o(n) pop o(n) insert o(n) remove o(n) elementAt o(n) porque tem muitos laços parar percorrer os dados e por ser amis complexo o processo

Desafio

A função hash que escolhi foi o método cognominal por meio da váriavel mask embora tenha colocado pra retorna o valor do indice recebido. Escolhi esse metodo porque foi o que consegui entender pego o nível e uso base 2 elevado ao nivel e multiplicado por 2 menos 1.
Ex :. índice 1 
2 ^1 = 2
2 x 2 = 4 
4 - 1 = 3

índice 3
2 ^ 3 = 8
8 x 2 = 16
16 - 1 = 15

Porque número primo é melhor para função de hash ?
Minimiza as colisões imaginemos que uma função hash seja entrada multiplicada pela potência de uma constante(K) e adicionando um inteiro.
Algo como (primeiro caracter) + K * (segundo caracter) + k ^ 2 *(terceiro caracter) + ...
Logo se tivermos primeiros caracters iguais levando a uma mesma constante(K) até que o inteiro estoure.
Então se a contante(K) for primo e o numeros de espaços for primo as colisões serão menores.
Potência de 2 ajuda na magnetude certa do numero primo  k ^ 2 *(terceiro caracter)