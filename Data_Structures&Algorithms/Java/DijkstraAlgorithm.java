import java.util.*;

public class DijkstraAlgorithm {

    // Node class for priority queue
    static class Node implements Comparable<Node> {
        int target;  
        long price;  

        public Node(int target, long price) {
            this.target = target;
            this.price = price;
        }

        @Override
        public int compareTo(Node other) {
            return Long.compare(this.price, other.price);
        }
    }

    private static final long INF = Long.MAX_VALUE;

    // Dijkstra function to find shortest distances
    public static long[] dijkstra(int V, List<List<Node>> adj, int src) {
        long[] dist = new long[V + 1]; 
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[src] = 0;
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            long d = current.price;
            int u = current.target;

            if (d > dist[u]) continue;

            for (Node edge : adj.get(u)) {
                int v = edge.target;
                long price = edge.price;
                long newPrice = d + price;

                if (newPrice < dist[v]) {
                    dist[v] = newPrice;
                    pq.add(new Node(v, newPrice));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 4; 
        int src = 1; 

        List<List<Node>> adj = new ArrayList<>(V + 1);
        for (int i = 0; i <= V; i++) adj.add(new ArrayList<>());

        // Adding edges (u, v, weight)
        adj.get(1).add(new Node(4, 5));
        adj.get(1).add(new Node(2, 4));
        adj.get(2).add(new Node(4, 5));
        adj.get(1).add(new Node(3, 2));
        adj.get(3).add(new Node(4, 3));

        long[] shortestPrices = dijkstra(V, adj, src);

        System.out.println("Shortest prices from City " + src + ":");
        for (int i = 1; i <= V; i++) {
            if (shortestPrices[i] == INF) 
                System.out.println("City " + i + ": Unreachable");
            else 
                System.out.println("City " + i + ": " + shortestPrices[i]);
        }

        System.out.println("\nMinimum price to City " + V + ": " + shortestPrices[V]);
    }
}
