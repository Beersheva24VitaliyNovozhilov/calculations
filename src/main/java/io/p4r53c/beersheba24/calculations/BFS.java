package io.p4r53c.beersheba24.calculations;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import io.p4r53c.beersheba24.calculations.TreeNode;

/**
 * Implements Breadth-First Search (BFS) algorithm to find the shortest path between two nodes in a binary tree.
 * 
 * @author p4r53c
 * @since 03.07.2024
 * 
 * @see io.p4r53c.beersheba24.calculations.TreeNode
 */
public class BFS {
    private TreeNode root;
    private int startValue;
    private int endValue;

    /**
     * Constructs a new BFS instance with the given root node and start/end values.
     *
     * @param root        the root node of the binary tree
     * @param startValue  the value of the start node
     * @param endValue    the value of the end node
     */
    public BFS(TreeNode root, int startValue, int endValue) {
        this.root = root;
        this.startValue = startValue;
        this.endValue = endValue;
    }

    /**
     * Finds the shortest path between the start and end nodes in the binary tree.
     *
     * @return a list of integers representing the shortest path from the start node to the end node
     */
    public List<Integer> findShortestPath() {
        if (root == null) {
            return Collections.emptyList();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode startNode = null;
        TreeNode endNode = null;

        queue.add(root);
        parentMap.put(root, null);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.value == startValue) {
                startNode = current;
            }
            if (current.value == endValue) {
                endNode = current;
            }

            if (current.left != null) {
                queue.add(current.left);
                parentMap.put(current.left, current);
            }
            if (current.right != null) {
                queue.add(current.right);
                parentMap.put(current.right, current);
            }
        }

        if (startNode == null || endNode == null) {
            return Collections.emptyList(); 
        }

        List<Integer> path = new LinkedList<>();
        for (TreeNode node = endNode; node != null; node = parentMap.get(node)) {
            path.add(node.value);
        }
        
        Collections.reverse(path);
        return path;
    }
}
