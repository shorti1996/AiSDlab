package com.wojciech.liebert.lab12_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by shorti1996 on 18.05.2016.
 */
public class DisjointSet {
    public List<Element> elements = new LinkedList<>();
    public Element representative;
    public Element lastAdded;
    public List<Element> lastElements = new LinkedList<>();
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

    /*function Find(x)
    if x.parent != x
    x.parent := Find(x.parent)
    return x.parent*/

    /*@Override
    public String toString() {

        String toReturn = "";
        return toReturn;
    }*/

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
        /*for (Element e :
                xRoot.children) {
            elements.add(e);
        }*/
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

    void DFS(Element root) {
        if (root == null) return;
        Queue currentLevel = new LinkedList<>();
        Queue nextLevel = new LinkedList<>();
        currentLevel.add(root);
        while (!currentLevel.isEmpty()) {
            Element currNode = (Element) currentLevel.peek();
            currentLevel.poll();
            if (currNode != null) {
                System.out.print(currNode + " "); //cout << currNode->data << " ";
                for (Element e :
                        currNode.children) {
                    nextLevel.add(e);
                }
                /*nextLevel.push(currNode->left);
                nextLevel.push(currNode->right);*/
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

    /*
    function Union(x, y)
     xRoot := Find(x)
     yRoot := Find(y)
     if xRoot == yRoot
         return

     // x and y are not already in same set. Merge them.
     if xRoot.rank < yRoot.rank
         xRoot.parent := yRoot
     else if xRoot.rank > yRoot.rank
         yRoot.parent := xRoot
     else
         yRoot.parent := xRoot
         xRoot.rank := xRoot.rank + 1
     */
}
