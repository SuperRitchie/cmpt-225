package graph;

import java.util.Iterator;
import java.util.*;

public class DenseGraph {
	boolean[][] matrix;
	int n, edges = 0;
	boolean[] visited;
	/**
	 * creates an empty graph on n nodes
	 * the "names" of the vertices are 0,1,..,n-1 
	 * @param n - number of vertices in the graph
	 */
	public DenseGraph(int n) {
		this.n = n;
		matrix = new boolean[n][n];
		visited = new boolean[n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				matrix[i][j] = false;
			}
		}
	}

	/**
	 * @return the adjacency matrix representing the graph
	 */
	public int[][] getAdjacencyMatrix() {
		int[][]adj = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(matrix[i][j]) {
					adj[i][j] = 1;
				}
				else {
					adj[i][j] = 0;
				}
			}
		}
		return adj;
	}

	/**
	 * adds the edge (i,j) to the graph  
	 * no effect if i and j were already adjacent
	 * @param i, j - vertices in the graph
	 */
	public void addEdge(int i, int j) {
		matrix[i][j] = true;
		matrix[j][i] = true;
		edges++;
	}

	/**
	 * removes the edge (i,j) from the graph
	 * no effect if i and j were not adjacent
	 * @param i, j - vertices in the graph
	 */
	public void removeEdge(int i, int j) {
		matrix[i][j] = false;
		matrix[j][i] = false;
		edges--;
	}

	/**
	 * @param i, j - vertices in the graph
	 * @return true if (i,j) is an edge in the graph, and false otherwise
	 */
	public boolean areAdjacent(int i, int j) {
		return matrix[i][j] || matrix[j][i];
	}

	/**
	 * @param i - a vertex in the graph
	 * @return the degree of i
	 */
	public int degree(int i) {
		int count = 0;
		for(int j = 0; j < n; j++) {
			if(matrix[i][j]) count++;
		}
		return count;
	}
	
	/**
	 * The iterator must output the neighbors of i in the increasing order
	 * Assumption: the graph is not modified during the use of the iterator 
	 * @param i - a vertex in the graph
	 * @return an iterator that returns the neighbors of i
	 */
	public Iterator<Integer> neighboursIterator(int i) {
		ArrayList<Integer> ans = new ArrayList<>();
		for(int j = 0; j < n; j++) {
			if(matrix[i][j]) {
				ans.add(j);
			}
		}
		return ans.iterator();
	}

	public ArrayList<Integer> neighbours(int i) {
		ArrayList<Integer> ans = new ArrayList<>();
		for(int j = 0; j < n; j++) {
			if(matrix[i][j]) {
				ans.add(j);
			}
		}
		return ans;
	}

	/*
	public int[] adjacent(int i) {
		Vector<Integer> copy = new Vector<>();
		for(int j = 0; j < n; j++) {
			if(matrix[i][j]) {
				copy.add(j);
			}
		}
		int[] adj = new int[copy.size()];
		for(int )
		return adj;
	}
	 */

	/**
	 * @return number of vertices in the graph
	 */
	public int numberOfVertices() {
		return n;
	}

	/**
	 * @return number of edges in the graph
	 */
	public int numberOfEdges() {
		return edges;
	}

	/**
	 * @param i, j - vertices in the graph
	 * @return distance between i and j in the graph
	 */

	// Solution to this function referenced from Coding Simplified
	public int distance(int i, int j) {
		int d = 0;
		if(i == j) {
			return 0;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);
		visited[i] = true;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size > 0) {
				for(Integer neighbour: neighbours(queue.poll())) {
					if(neighbour == j) {
						return ++d;
					}
					if(!visited[neighbour]) {
						queue.add(neighbour);
						visited[neighbour] = true;
					}
				}
				size--;
			}
			d++;
		}
		return 0;
	}

	/**
	 * @param n - number of vertices
	 * @param p - number between 0 and 1
	 * @return a random graph on n vertices, where each edge is added to the graph with probability p
	 */
	public static DenseGraph generateRandomGraph(int n, double p) {
		DenseGraph random = new DenseGraph(n);
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				if(Math.random() < p) {
					random.addEdge(i,j);
				}
			}
		}
		return random;
	}
}
