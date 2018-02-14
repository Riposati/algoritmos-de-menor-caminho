Algoritmo de Dijkstra

Entrada: 

– um grafo ou um digrafo (conjunto de nós + conjunto
de arestas ponderadas); – o nó de origem.

 Saída: 
 
 – d : arranjo com os valores das menores distâncias do
nó de origem para cada um dos nós do grafo;

– π : arranjo com o predecessor de cada um dos nós no
caminho de menor distância entre o nó de origem e
os demais nós.

Algoritmo de Bellman-Ford

Dado um grafo orientado ponderado G = (V, E) com origem em s e função peso w:E → R, o algoritmo retorna FALSE
quando encontra um ciclo de peso negativo indicando que não existe solução, ou retorna TRUE
indicando que produziu os caminhos mais curtos e seus pesos. O algoritmo usa a técnica do
relaxamento, diminuindo progressivamente a estimativa d[v] no peso de um caminho mais curto.
