package com.wojciech.liebert.lab10;

/**
 * Created by shorti1996 on 04.05.2016.
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {

    public Comparator _comparator;
    private Node _root;

    public BinarySearchTree(Comparator comparator) {
        assert comparator != null : "nie określono komparatora";
        _comparator = comparator;
    }

    public Node root(){
        return _root;
    }

    public Object find(Object x){
        Node t = search(x);
        return t != null ? t.value : null;
    }

    public Node search(Object value) {
        Node node = _root;
        int cmp = 0;
        while (node != null && (cmp = _comparator.compare(value, node.value)) != 0)
            node = cmp < 0 ? node.left : node.right;
        return node;
    }

    public void insert(Object x)
    { _root= insert(x, _root); }

    protected Node insert(Object x, Node t) {
        if(t == null) t = new Node(x);
        else {
            int cmp = _comparator.compare(x, t.value);
            if (cmp < 0) t.left = insert(x, t.left);
            else if (cmp > 0) t.right = insert(x, t.right);
            else throw new DuplicateItemException(x.toString());
        }
        return t;
    }

    public void showTreePreorder(){
        for (Node n : this.preorder(root(), new LinkedList<Node>())){
            System.out.println(n);
        }
    }

    public List<Node> preorder(Node x, List<Node> argList){
        argList.add(x);
        if (x.left != null)
            preorder(x.left, argList);
        if (x.right != null)
            preorder(x.right, argList);
        return argList;
    }

    public void inorder(Node x){
        if (x.left != null)
            inorder(x.left);
        System.out.println(x.toString());
        if (x.right != null)
            inorder(x.right);
    }

    public void postorder(Node x){
        if (x.left != null)
            postorder(x.left);
        if (x.right != null)
            postorder(x.right);
        System.out.println(x.toString());
    }


    public void bfs()
    {
        Queue q = new LinkedList();
        q.add(root());
        System.out.println(root());
        root().visited = true;
        while(!q.isEmpty())
        {
            Node n = (Node)q.remove();
            Node child = null;
            while((child = getUnvisitedChildNode(n))!= null)
            {
                child.visited = true;
                System.out.println(child);
                q.add(child);
            }
        }
        //Clear visited property of nodes
        clearNodes();
    }

    private void clearNodes() {
        for (Node n : this.preorder(root(), new LinkedList<Node>())){
            n.visited = false;
        }
    }

    private Node getUnvisitedChildNode(Node n) {
        if (n.left != null && !n.left.visited)
            return n.left;
        if (n.right != null && !n.right.visited)
            return n.right;
        return null;
    }

    public boolean isEmpty(){
        if (root() == null)
            return true;
        else
            return false;
    }

    public int findHeight(){
        if(this.isEmpty()){
            return 0;
        }
        else{
            Node node = root();
            return height(node);
        }
    }
    private int height(Node aNode){
        int heightLeft = -1;
        int heightRight = -1;
        if(aNode.left != null)
            heightLeft = height(aNode.left);
        if(aNode.right != null)
            heightRight = height(aNode.right);
        if(heightLeft > heightRight){
            return heightLeft + 1;
        }
        else{
            return heightRight + 1;
        }
    }

    public int findLeavesCount(){
        if (this.isEmpty())
            return 0;
        else {
            Node node = root();
            return leavesCount(node);
        }
    }

    int leavesCount(Node node){
        if( node == null )
            return 0;
        if( node.left == null && node.right == null ) {
            return 1;
        }
        else {
            return leavesCount(node.left) + leavesCount(node.right);
        }
    }

    public int findMinimalNode(){
        if (this.isEmpty())
            return 0;
        else{
            return (int)minimalNode(root()).value[0];
        }
    }

    private Node minimalNode(Node node){
        if (node.left != null){
            return minimalNode(node.left);
        }
        else
            return node;
    }

    public int findMaximalNode(){
        if (this.isEmpty())
            return 0;
        else{
            return (int)maximalNode(root()).value[2];
        }
    }

    private Node maximalNode(Node node){
        if (node.right != null){
            return maximalNode(node.right);
        }
        else
            return node;
    }

    int findInnerNodesCount(){
        if (this.isEmpty()){
            return 0;
        }
        else {
            return innerNodesCount(root());
        }
    }

    private int innerNodesCount(Node node) {
        if(node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            // not an inner node !
            return 0;
        } else {
            // the number of inner nodes in the left sub-tree + the number of inner
            // nodes in the right sub-tree, plus 1 for this inner node
            return innerNodesCount(node.left) + innerNodesCount(node.right) + 1;
        }
    }

    public int findExternalNodesCount(){
        if (this.isEmpty()){
            return 0;
        }
        else{
            return externalNodesCount(root());
        }
    }

    private int externalNodesCount(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 2;
        }
        if (node.left == null) {
            return 1;
        }
        if (node.right == null) {
            return 1;
        } else {
            return externalNodesCount(node.left) + externalNodesCount(node.right) + 1;
        }
    }

    public Node findSuccessor(Node root, Node node){
        root = root();
        if (node.right != null){
            return minimalNode(node.right);
        }
        Node successor = null;
        while (root != null){
            int cmp = _comparator.compare(node.value, root.value);
            if (/*(int)node.value < (int)root.value*/ cmp < 0){
                successor = root;
                root = root.left;
            }
            else if (/*(int)node.value > (int)root.value*/ cmp > 0){
                root = root.right;
            }
            else
                break;
        }
        return successor;
    }

    public Node findPredecessor(Node root, Node node){
        root = root();
        if (node.left != null){
            return  maximalNode(node.left);
        }
        Node predecessor = null;
        while (root != null){
            int cmp = _comparator.compare(node.value, root.value);
            if (cmp < 0){
                root = root.left;
            }
            else if (cmp > 0){
                predecessor = root;
                root = root.right;
            }
            else
                break;
        }
        return predecessor;
    }

    public Node delete (Node node){
        Node nodeToReturn = null;
        //leaf
        if (node.left == null && node.right == null){
            Node parent = findParent(node);
            if (parent.left == node){
                parent.left = null;
            }
            if (parent.right == node){
                parent.right = null;
            }
            nodeToReturn = new Node(node);
            node = null;
            return nodeToReturn;
        }
        //parent of one node
        if (node.left == null)// || node.right == null){
        {
            Node parent = findParent(node);
            nodeToReturn = new Node(node);
            if (parent.left == node){
                parent.left = node.right;
            }
            if (parent.right == node){
                parent.right = node.right;
            }
            return nodeToReturn;
        }
        if (node.right == null){
            Node parent = findParent(node);
            nodeToReturn = new Node(node);
            if (parent.left == node){
                parent.left = node.left;
            }
            if (parent.right == node){
                parent.right = node.left;
            }
            return nodeToReturn;
        }
        //parent of two nodee
        if (node.left != null && node.right != null){
            Node parent = findParent(node);
            nodeToReturn = new Node(node);
            Node successor = findSuccessor(root(), node);
            successor.left = node.left;
            //if (node.right == successor){
            successor.left = node.left;
            successor.right = (node.right == successor.right) ? null : successor.right;
            if (parent.left == node){
                parent.left = successor;
            }
            if (parent.right == node){
                parent.right = successor;
            }
            node = null;
            return nodeToReturn;
            //}
            /*if (node.right != successor){

            }*/
        }
        return null;
    }

    public Node findParent(Node node){
        Node parent = null;
        //boolean right = false;
        for (Node n : this.preorder(root(), new LinkedList<Node>())){
            if (n.left == node || n.right == node ){
                parent = n;
                /*if (n.right == node){
                    right = true;
                }*/
                break;
            }
        }
        return parent;
    }
}

