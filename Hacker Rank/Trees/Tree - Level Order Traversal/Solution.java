/* Link: https://www.hackerrank.com/challenges/tree-level-order-traversal/problem */

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/* class Node 
    		int data;
    		Node left;
    		Node right;
	*/
	public static void levelOrder(Node root) {
        if(root==null){
            return;
        }
        LinkedList<Node> s = new LinkedList();
        s.add(root);
        while(!s.isEmpty()){
            Node current_node = s.poll();
            System.out.print(current_node.data + " ");
            if(current_node.left!=null){
                s.add(current_node.left);
            }
            if(current_node.right!=null){
                s.add(current_node.right);
            }
        }
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }	
}
