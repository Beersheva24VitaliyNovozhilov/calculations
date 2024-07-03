package io.p4r53c.beersheba24.calculations;

/**
 * A simple binary tree node implementation.
 *
 * @author p4r53c
 * @since 03.07.2024
 */
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    /**
     * Constructs a new TreeNode with the given value.
     *
     * @param value the value of the node
     */
    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
