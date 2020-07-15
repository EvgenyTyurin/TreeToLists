import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Convert tree to lists by tree levels
 */

public class TreeToLists {

    public static void main(String[] args) {

        // level 1
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        // level 2
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode(2);
        root.setChildLeft(node2);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode(3);
        root.setChildRight(node3);
        // level 3
        node2.setChildLeft(new BinaryTreeNode(4));
        node2.setChildRight(new BinaryTreeNode(5));
        node3.setChildLeft(new BinaryTreeNode(6));
        node3.setChildRight(new BinaryTreeNode(7));
        System.out.println("Tree:");
        root.printTree();
        // Convert by recursion procedure
        ArrayList<LinkedList<BinaryTreeNode>> lists = new ArrayList<LinkedList<BinaryTreeNode>>();
        treeLevelToList(root, lists, 0);
        // Print result
        System.out.println("Lists:");
        for (LinkedList<BinaryTreeNode> list : lists) {
            for (BinaryTreeNode<Integer> node : list) {
                System.out.print(node.getData() + " ");
            }
            System.out.print("\n");
        }

    }

    // Recursive procedure forming lists from tree levels
    private static void treeLevelToList(BinaryTreeNode node, ArrayList<LinkedList<BinaryTreeNode>> lists, int level) {
        if (node == null)
            return;
        if (lists.size() == level) {
            LinkedList<BinaryTreeNode> list = new LinkedList<>();
            list.add(node);
            lists.add(list);
        } else {
            lists.get(level).add(node);
        }
        treeLevelToList(node.getChildLeft(), lists, level + 1);
        treeLevelToList(node.getChildRight(), lists, level + 1);
    }

}
