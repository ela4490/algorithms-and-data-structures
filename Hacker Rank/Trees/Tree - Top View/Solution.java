/* Link: https://www.hackerrank.com/challenges/tree-top-view/problem */

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

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
    static class QueueNode{
        public Node node;
        public int hd;
        
        QueueNode(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
	public static void topView(Node root) {
        Queue<QueueNode> q = new LinkedList<QueueNode>();
        Map<Integer, Integer> map = new TreeMap();
        q.add(new QueueNode(root, 0));
        while(!q.isEmpty()){
            QueueNode top = q.poll();
            map.putIfAbsent(top.hd, top.node.data);
            if(top.node.left!=null){
                q.add(new QueueNode(top.node.left, top.hd-1));
            }
            if(top.node.right!=null){
                q.add(new QueueNode(top.node.right, top.hd+1));
            }
        }
        for(Map.Entry m: map.entrySet()){
            System.out.print(m.getValue() + " ");
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
        topView(root);
    }	
}
