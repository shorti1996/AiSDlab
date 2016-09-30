package com.wojciech.liebert.lab13;

import java.util.*;

/**
 * Created by shorti1996 on 25.05.2016.
 */
public class DisjointSet {
    public List<Element> elements = new LinkedList<>();
    public Element representative;
    public Element lastAdded;
    public List<Element> lastElements = new LinkedList<>();
    public AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(10);
    public List<Edge> edges = new LinkedList<>();
    private int rank = 0;


    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
        for (Element e :
                elements) {
            e.setRank(rank);
        }
    }

    public DisjointSet(){}
    
    public void UpdateEdges(){
        edges = new LinkedList<>();
        for (int i = 0; i < adjacencyMatrix.a.length-1; i++){
            for (int j = 0; j < adjacencyMatrix.a.length-1; j++){
                if (adjacencyMatrix.a[i][j] == true){
                    Edge e = new Edge(0);
                    e.jointInts.add(i);
                    e.jointInts.add(j);
                    e.jointElements.add(findE(i));
                    e.jointElements.add(findE(j));
                    edges.add(e);
                }
            }
        }
    }

    /*
    K01:	Utwórz n elementową strukturę zbiorów rozłącznych Z
K02:	Utwórz pustą kolejkę Q
K03:	Utwórz pusty zbiór T	; zbiór dla minimalnego drzewa rozpinającego
K04:	Dla v = 0,1,...,n - 1: wykonuj K05...K06	; przeglądamy kolejne wierzchołki grafu
K05:	    MakeSet(Z[v])	; tworzymy zbiory rozłączne, po jednym dla każdego wierzchołka
K06:	    Dla każdego sąsiada u wierzchołka v wykonuj:
        Q.push(v–u:w)	; przeglądamy sąsiadów wierzchołka v
; i w kolejce Q umieszczamy krawędzie wraz z ich wagami
K07:	Dla i = 1,2,...,n - 1, wykonuj K08...K11	; główną pętlę wykonujemy n-1 razy
K08:	    v–u:w ← Q.front();  Q.pop()	; pobieramy krawędź z początku kolejki
K09:	    Jeśli FindSet(Z[v]) = FindSet(Z[u]), to idź do K08	; sprawdzamy, czy u i v leżą w różnych składowych w drzewie T
K10:	    Dodaj v–u:w do T	; jeśli tak, to krawędź dodajemy do drzewa T
K11:	    UnionSets(Z[u],Z[v])	; a zbiory z u i v łączymy ze sobą
K12:	Zakończ z wynikiem T
     */

    /*MST_KRUSKAL

MST = {} {zbiór pusty}

for each vÎV

MAKE_SET(v)

for each <u,v> Î LK

if FIND(u) <> FIND(v) then

MST = MST È {<u,v>}

UNION(u,v)*/

    public List<Edge> MST(int e){
        Element start = findE(e);
        List<Edge> MST = new LinkedList<>();
        List<Edge> allEdges = new LinkedList<>();
        for (Edge ed :
                edges) {
            allEdges.add(ed);
        }
        Collections.sort(allEdges, (a, b) -> Integer.compare(b.weight, a.weight));

        while(MST.size() != elements.size()-1){
            Edge minimalEdge = Collections.min(start.jointEdges);
            start.jointEdges.remove(minimalEdge);
        }

        return MST;
    }

    public Element findE(int e){
        for (Element element :
                elements) {
            if (element.value == e)
                return element;
        }
        return null;
    }

    public void AddElement(Element e){
        if (elements.size() == 0){
            representative = e;
            e.parent = null;
            lastElements.add(e);
        }
        else{
            e.parent = elements.get(elements.size()-1);
            lastAdded.children.add(e);
        }
        lastAdded = e;
        elements.add(e);
        setRank(getRank() + 1);
        for (Element element :
                elements) {
            element.setRank(this.getRank());
        }
    }

    public Element FindRepresentative(Element e){
        if (e.parent == null){
            return e;
        }
        else {
            return FindRepresentative(e.parent);
        }
    }

    public Element CompressionFind(Element e){
        if (e.parent != null){
            e.parent.children.remove(e);
            e.parent = CompressionFind(e.parent);
            e.parent.children.add(e);
        }
        if (e.parent == null)
            return e;
        return e.parent;
    }

    @Override
    public String toString(){
        String toReturn = "";
        Element element = lastAdded;
        do{
            toReturn += element + ", ";
            element = element.parent;
        }
        while (element != null);
        return toReturn;
    }

    public void Union(Element x, Element y) {
        Element xRoot = FindRepresentative(x);
        Element yRoot = FindRepresentative(y);
        if (xRoot == yRoot)
            return;

        if (xRoot.getRank() < yRoot.getRank()) {
            xRoot.parent = yRoot;
            yRoot.children.add(xRoot);
        } else if (xRoot.getRank() > yRoot.getRank()) {
            yRoot.parent = xRoot;
            xRoot.children.add(yRoot);
        } else {
            yRoot.parent = xRoot;
            xRoot.children.add(yRoot);
            xRoot.setRank(xRoot.getRank() + 1);
        }
    }

    public List<Element> bfs()
    {
        List<Element> toReturn = new ArrayList<>();
        Queue q = new LinkedList();
        q.add(representative);
        toReturn.add(representative);
        representative.visited = true;
        while(!q.isEmpty())
        {
            Element n = (Element)q.remove();
            Element child = null;
            while((child = getUnvisitedChildNode(n))!= null)
            {
                child.visited = true;
                toReturn.add(child);
                q.add(child);
            }
        }
        //Clear visited property of nodes
        clearNodes();
        return toReturn;
    }

    private void clearNodes() {
        for (Element n : this.preorder(representative, new LinkedList<Element>())){
            n.visited = false;
        }
    }

    private Element getUnvisitedChildNode(Element n) {
        if (n.children.size() > 0){
            for (Element e :
                    n.children) {
                if (!e.visited){
                    return e;
                }
            }
        }
        return null;
    }

    void printLevelOrder(Element root) {
        if (root == null) return;
        Queue currentLevel = new LinkedList<>();
        Queue nextLevel = new LinkedList<>();
        currentLevel.add(root);
        while (!currentLevel.isEmpty()) {
            Element currNode = (Element) currentLevel.peek();
            currentLevel.poll();
            if (currNode != null) {
                System.out.print(currNode + " ");
                for (Element e :
                        currNode.children) {
                    nextLevel.add(e);
                }
            }
            if (currentLevel.isEmpty()) {
                System.out.print("\n");
                Queue temp = new LinkedList<>();
                temp = nextLevel;
                nextLevel = currentLevel;
                currentLevel = temp;
            }
        }
    }

    public void showTreePreorder(){
        for (Element n : this.preorder(representative, new LinkedList<Element>())){
            System.out.println(n);
        }
    }

    public List<Element> preorder(Element x, List<Element> argList){
        argList.add(x);
        if (x.children.size() > 0){
            for (Element child
                    : x.children){
                preorder(child, argList);
            }
        }
        return argList;
    }

    public List<Element> GetChildren(Element root){
        List<Element> list = new LinkedList<>();
        list.add(root);
        if (root.children.size() > 0){
            for (Element e :
                    root.children) {
                list.add(e);
                List<Element> child = new LinkedList<>();
                child = GetChildren(e);
                list.addAll(child);
            }
        }
        return list;
    }



}

