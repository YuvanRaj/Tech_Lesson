package com.tech.algoritham;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SnakeAndLadder {

	static class qentry {
		int v;// Vertex number
		int dist;// Distance of this vertex from source
	}

	static int getMinDiceThrows(int move[], int n) {
		int visited[] = new int[n];
		Queue<qentry> q = new LinkedList<>();
		qentry qe = new qentry();
		qe.v = 0;
		qe.dist = 0;

		visited[0] = 1;
		q.add(qe);

		while (!q.isEmpty()) {
			qe = q.remove();
			int v = qe.v;

			if (v == n - 1)
				break;

			for (int j = v + 1; j <= (v + 6) && j < n; ++j) {
				if (visited[j] == 0) {
					qentry a = new qentry();
					a.dist = (qe.dist + 1);
					visited[j] = 1;

					if (move[j] != -1)
						a.v = move[j];
					else
						a.v = j;
					q.add(a);
				}
			}
		}
		return qe.dist;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int noOfTestCase = scan.nextInt();
		int N = 100;
		List<Integer> minDiceCount = new ArrayList<Integer>(0);
		for (int i = 0; i < noOfTestCase; i++) {
			int moves[] = new int[N];
			for (int x = 0; x < N; x++) {
				moves[x] = -1;
			}

			int noOfLadder = scan.nextInt();
			for (int j = 0; j < noOfLadder; j++) {
				int startIndex = scan.nextInt();
				int endIndex = scan.nextInt();
				moves[startIndex - 1] = endIndex - 1;
			}

			int noOfSnakes = scan.nextInt();
			for (int k = 0; k < noOfSnakes; k++) {
				int startIndex = scan.nextInt();
				int endIndex = scan.nextInt();
				moves[startIndex - 1] = endIndex - 1;
			}
			minDiceCount.add(getMinDiceThrows(moves, N));
		}
		scan.close();

		for (Integer count : minDiceCount) {
			if (count == 0 || count == 6) {
				System.out.println(-1);
			}
			else {
				System.out.println(count);
			}
		}

	}
}
