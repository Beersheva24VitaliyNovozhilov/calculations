package io.p4r53c.beersheba24.calculations;

import java.util.List;

import io.p4r53c.beersheba24.calculations.BFS;
import io.p4r53c.beersheba24.calculations.TreeNode;

/**
 * First demo class for Beersheva 24 TR Course
 * 
 * @author p4r53c
 * @since 02.07.2024
 * 
*/
public class Main {

    public static void main(String[] args) {
        printGreeting();
        System.out.println(printStringBuilderHellowMessage());
        calculateShortWayByBFS(4, 7);
    }

    /**
     * Prints the greeting "Hello world!" to the standard output.
     * 
     * 
     */
    private static void printGreeting() {
        System.out.println("Hello world!");
    }

    /**
     * Returns a string that concatenates multiple lines of text using a StringBuilder.
     *
     * @return          the concatenated string
     */
    private static String printStringBuilderHellowMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello\n").append("Tel Ran\n").append("Beersheva24\n").append("Course\n");
        return sb.toString();
    }


    /**
     * Calculates the shortest path between two nodes in a binary tree using Breadth-First Search (BFS) algorithm.
     *
     * @param  startValue  the value of the start node
     * @param  endValue    the value of the end node
     */
    private static void calculateShortWayByBFS(int startValue, int endValue) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        //int startValue = 4; // Start node
        //int endValue = 7;   // End node

        BFS bfs = new BFS(root, startValue, endValue);
        List<Integer> path = bfs.findShortestPath();

        System.out.println("Shortest path from " + startValue + " to " + endValue + ": " + path);
    }
}