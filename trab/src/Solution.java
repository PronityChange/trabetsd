import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean isNonDirectedValidGraph(List<List<Integer>> grafo, int V) {
        for (int i = 0; i < grafo.size(); i++) {
            if (i < 0 || i >= V) {
                return false;
            }
            Set<Integer> vizinhos = new HashSet<>();
            for (Integer vizinho : grafo.get(i)) {
                if (vizinho < 0 || vizinho >= V) {
                    return false;
                }
                if (vizinho == i) {
                    return false;
                }
                if (vizinhos.contains(vizinho)) {
                    return false;
                }
                vizinhos.add(vizinho);
            }
        }

        for (int i = 0; i < grafo.size(); i++) {
            for (Integer vizinho : grafo.get(i)) {
                if (!grafo.get(vizinho).contains(i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> grafoValido = List.of(
                List.of(1, 2),
                List.of(0, 2),
                List.of(0, 1)
        );
        int VValido = 3;
        Solution solucaoValido = new Solution();
        System.out.println("O grafo válido é não direcionado válido? " + solucaoValido.isNonDirectedValidGraph(grafoValido, VValido));

        List<List<Integer>> grafoAutoLoop = List.of(
                List.of(1, 0),
                List.of(0, 1, 1)
        );
        int VAutoLoop = 2;
        Solution solucaoAutoLoop = new Solution();
        System.out.println("O grafo com auto-loop é não direcionado válido? " + solucaoAutoLoop.isNonDirectedValidGraph(grafoAutoLoop, VAutoLoop));

        List<List<Integer>> grafoParalelo = List.of(
                List.of(1, 2, 1),
                List.of(0, 2),
                List.of(0, 1)
        );
        int VParalelo = 3;
        Solution solucaoParalelo = new Solution();
        System.out.println("O grafo com aresta paralela é não direcionado válido? " + solucaoParalelo.isNonDirectedValidGraph(grafoParalelo, VParalelo));

        List<List<Integer>> grafoDirecionado = List.of(
                List.of(1),
                List.of()
        );
        int VDirecionado = 2;
        Solution solucaoDirecionado = new Solution();
        System.out.println("O grafo direcionado é não direcionado válido? " + solucaoDirecionado.isNonDirectedValidGraph(grafoDirecionado, VDirecionado));

        List<List<Integer>> grafoForaIntervalo = List.of(
                List.of(1),
                List.of(2)
        );
        int VForaIntervalo = 2;
        Solution solucaoForaIntervalo = new Solution();
        System.out.println("O grafo com nó fora do intervalo é não direcionado válido? " + solucaoForaIntervalo.isNonDirectedValidGraph(grafoForaIntervalo, VForaIntervalo));
    }
}