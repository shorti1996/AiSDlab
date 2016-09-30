package lab08;

public class Main {

    public static void main(String[] args) {
	    BinarySearchTree binarySearchTree = new BinarySearchTree(new NaturalComparator());
        /*binarySearchTree.insert(3);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(5);
        binarySearchTree.insert(4);
        binarySearchTree.insert(6);*/
        Node n1 = new Node(30);
        binarySearchTree.insert(n1);
        binarySearchTree.insert(new Node(20));
        binarySearchTree.insert(new Node(10));
        binarySearchTree.insert(new Node(25));
        binarySearchTree.insert(new Node(40));
        binarySearchTree.insert(new Node(50));
        binarySearchTree.insert(new Node(60));
        binarySearchTree.JedenPotomek(binarySearchTree.root());

        /*System.out.println("Preorder:");
        binarySearchTree.showTreePreorder();
        System.out.println("Inorder:");
        binarySearchTree.inorder(binarySearchTree.root());
        System.out.println("Postorder:");
        binarySearchTree.postorder(binarySearchTree.root());
        System.out.println("BFS:");
        binarySearchTree.bfs();
        System.out.println("Szukaj \"25\":");
        System.out.println(binarySearchTree.find(25));
        System.out.println("Szukaj \"99\":");
        System.out.println(binarySearchTree.find(99));
        System.out.println("Wysokosc drzewa: " + binarySearchTree.findHeight());
        System.out.println("Liczba lisci: " + binarySearchTree.findLeavesCount());
        System.out.println("Najmniejszy element: " + binarySearchTree.findMinimalNode());
        System.out.println("Najwiekszy element: " + binarySearchTree.findMaximalNode());
        System.out.println("Liczba wezlow wewnetrznych " + binarySearchTree.findInnerNodesCount());
        System.out.println("Liczba wezlow zewnetrznych " + binarySearchTree.findExternalNodesCount());
        System.out.println("Nastepnik 25: " + binarySearchTree.findSuccessor(binarySearchTree.root(), binarySearchTree.search(25)));
        System.out.println("Poprednik 25: " + binarySearchTree.findPredecessor(binarySearchTree.root(), binarySearchTree.search(25)));

        System.out.println("Usuwanie 20... ");
        binarySearchTree.delete(binarySearchTree.search(20));
        System.out.println("BFS:");
        binarySearchTree.bfs();*/
    }
}
