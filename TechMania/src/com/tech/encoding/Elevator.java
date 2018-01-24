package com.tech.encoding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Class is used to count the no of stops for given elevator
 * @author Yuvaraj
 *
 */
public class Elevator {

	public static void main(String[] args) {
		Elevator elv = new Elevator();
		int[] A = new int[] {40, 40, 100, 200, 20};
        int[] B = new int[] {3, 3, 2, 2, 3};
        int M = 3;
        int X = 1;
        int Y = 200;
		System.out.println(elv.solution(A, B, X, Y, M));

	}

	private int solution(int[] A, int[] B, int X, int Y, int M) {

		if (A == null || B == null || A.length == 0 || B.length == 0 || X < 1 || Y < 1) {
			return 0;
		}

		Queue<Task> taskQueueList = new LinkedList<Task>();
		for (int i = 0; i < A.length; i++) {
			if (A[i] > Y) {
				throw new RuntimeException("Over Weight");
			}
			Task task = new Task(A[i], B[i]);
			taskQueueList.add(task);
		}
		
		int res = 0;
		while(!taskQueueList.isEmpty()){
			res += getCount(taskQueueList,X,Y);
		}
		return res;
	}

	private int getCount(Queue<Task> taskQueueList, int X, int Y) {
		List<Integer> liftList = new ArrayList<Integer>();
		
		while(!taskQueueList.isEmpty() && X > 0 && Y-taskQueueList.peek().weight > 0){
			Task task = taskQueueList.poll();
			X -= 1;
			Y -= task.weight;
			liftList.add(task.floor);
		}
		return liftList.size()+1;
	}

	class Task {
		int floor;
		int weight;

		Task(int floor, int weight) {
			this.floor = floor;
			this.weight = weight;
		}
	}
}
