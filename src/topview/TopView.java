/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topview;

import java.util.*;

/**
 *
 * @author chunyap
 */
public class TopView {

    public static void printTopView(Node node){
        HashMap<Integer, Integer[]> topView = new HashMap<>();
        _printTopView(node, 0, 0, topView);
        
        for(Map.Entry<Integer, Integer[]> entry : topView.entrySet()) {
            Integer[] info = entry.getValue();

            System.out.println(info[1]);
        }
    }
    
    private static void _printTopView(Node node, int hlevel, int vlevel, HashMap<Integer, Integer[]> map){
        if (node == null){
            return;
        }
        
        if( !map.containsKey(hlevel) || map.get(hlevel)[0] > vlevel ){
            Integer[] info = new Integer[2];
            info[0] = vlevel;   //vertical level
            info[1] = node.data;    //data
            map.put(hlevel, info);
        }
        
        _printTopView(node.left, hlevel-1, vlevel+1, map);
        _printTopView(node.right, hlevel+1, vlevel+1, map);        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Node node = new Node(10);
        
        node.left = new Node(2);
        node.left.left = new Node(3);
        node.left.right = new Node(9);
        node.left.right.right = new Node(19);
        
        node.right = new Node(7);
        node.right.left = new Node(6);
        node.right.left.right = new Node(61);
        node.right.right = new Node(20);
        
        node.right.right.left = new Node(22);
        node.right.right.left.left = new Node(23);
        node.right.right.left.right = new Node(24);
        
        TopView.printTopView(node);
    }
}

class Node{
    public int data;
    public Node left;
    public Node right;
    
    Node(int data){
        this.data = data;
    }
}