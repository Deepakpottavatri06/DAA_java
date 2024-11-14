/*
 In a joint family, every person assigned with an ID, an integer value.
and the entire family is arranged in the from of tree.

You will be given the family tree,
your task is to find and print the person ID, who is only child to his/her parent.
i.e, the person with no siblings. Print all such person ID's in ascending order.

NOTE: 
	- If only one person is there in the family, please consider him as a parent.
	- In the given tree, please consider '-1' as null.

Input Format:
-------------
Line-1: Space separated integers, person ID's in the family.

Output Format:
--------------
Line-1: Print the list of person IDs in ascending order.


Sample Input-1:
---------------
2 3 4 -1 5

Sample Output-1:
----------------
[5]

Sample Input-2:
---------------
11 99 88 77 -1 -1 66 55 -1 -1 44 33 -1 -1 22

Sample Output-2:
----------------
[77, 66, 55, 44, 33, 22]

 */

import java.util.*;

class Binarynode {
    public int data;
    public Binarynode left,right;
    Binarynode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    @Override
    public String toString() {
        return ""+data;
    }
}


public class LonelyNode {
    private static Binarynode binaryTree(int [] arr){
        Binarynode root = new Binarynode(arr[0]);
        int i = 1;
        Queue<Binarynode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty() && i<arr.length) {
            Binarynode node  = queue.poll();
            if(arr[i]!=-1){
                Binarynode left = new Binarynode(arr[i]);
                node.left = left;
                queue.add(left);
            }
            i++;
            if(i<arr.length && arr[i]!=-1){
                Binarynode right = new Binarynode(arr[i]);
                node.right = right;
                queue.add(right);
            }
            i++;
        }
        
        return root;
    }

    public static List<Integer> bfsLonelyNode(Binarynode root){
        Queue <Binarynode> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Binarynode node  = queue.poll();
            // System.out.println(node);
            if(node.left==null && node.right==null){
                continue;
            }
            if(node.left==null){
                result.add(node.right.data);
            }
            else if(node.right==null){
                result.add(node.left.data);
            }        

            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
            

        }
        return result;
    }
    public static void bfsTraversal(Binarynode root){
        Queue <Binarynode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Binarynode node  = queue.poll();
            System.out.println(node);
            if(node.left!=null)queue.add(node.left);
            if(node.right!=null)queue.add(node.right);
        }
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int arr [] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = cin.nextInt();
        }
        Binarynode root = binaryTree(arr);
        // bfsTraversal(root);
        System.out.println(bfsLonelyNode(root));
        cin.close();
    }
}

/*
 import java.util.*;

class BinaryTreeNode {
    public int data;
    public BinaryTreeNode left, right;

    public BinaryTreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    // Method to get all lonely nodes in the tree using BFS
    // Return list of lonelyNodes
    public ArrayList<Integer> getLonelyNodes(BinaryTreeNode root) {
        //Write your code here
        Queue <BinaryTreeNode> queue = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node  = queue.poll();
            // System.out.println(node);
            if(node.left==null && node.right==null){
                continue;
            }
            if(node.left==null){
                result.add(node.right.data);
            }
            else if(node.right==null){
                result.add(node.left.data);
            }        

            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
            

        }
        return result;
    }
}

public class LonelyNodes {
    static BinaryTreeNode root;

    // Function to construct the tree based on input using level-order insertion
    BinaryTreeNode buildTreeFromInput(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) {
            return null;
        }

        root = new BinaryTreeNode(arr[0]);
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        // Traverse the input array and construct the binary tree
        while (!queue.isEmpty() && i < arr.length) {
            BinaryTreeNode currentNode = queue.poll();

            // Add left child
            if (arr[i] != null) {
                currentNode.left = new BinaryTreeNode(arr[i]);
                queue.add(currentNode.left);
            }
            i++;

            // Add right child
            if (i < arr.length && arr[i] != null) {
                currentNode.right = new BinaryTreeNode(arr[i]);
                queue.add(currentNode.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        LonelyNodes ln = new LonelyNodes();
        Solution sol = new Solution();

        // Read input as space-separated integers, converting -1 to null for tree structure
        String[] inputStr = sc.nextLine().split(" ");
        Integer[] nodes = new Integer[inputStr.length];
        for (int i = 0; i < inputStr.length; i++) {
            nodes[i] = inputStr[i].equals("-1") ? null : Integer.parseInt(inputStr[i]);
        }

        // Build the tree from input
        root = ln.buildTreeFromInput(nodes);

        // Get lonely nodes
        ArrayList<Integer> result = sol.getLonelyNodes(root);

        // Output result
        System.out.println(result);
    }
}

 */