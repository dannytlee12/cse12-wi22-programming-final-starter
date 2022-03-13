/**
 * TODO: Add file header
 * Name:
 * ID:
 * Email:
 * File description:
 */

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * TODO: Add class header
 */
public class CSE12NaryTree<E extends Comparable<E>> {

    /**
     * This inner class encapsulates the data and children for a Node.
     * Do NOT edit this inner class.
     */
    protected class Node{
        E data;
        List<Node> children;

        /**
         * Initializes the node with the data passed in
         *
         * @param data The data to initialize the node with
         */
        public Node(E data) {
            this.data = data;
            this.children = new ArrayList<>();
        }

        /**
         * Getter for data
         *
         * @return Return a reference to data
         */
        public E getData() {
            return data;
        }

        /**
         * Setter for the data
         *
         * @param data Data that this node is set to
         */
        public void setData(E data) {
            this.data = data;
        }

        /**
         * Getter for children
         *
         * @return reference to the list of children
         */
        public List<Node> getChildren() {
            return children;
        }

        /**
         * Returns the number of children
         *
         * @return number of children
         */
        public int getNumChildren() {
            // assume there are no nulls in list
            return children.size();
        }

        /**
         * Add the given node to this node's list of children
         *
         * @param node The node to add
         */
        public void addChild(Node node) {
            children.add(node);
        }

    }

    Node root;
    int size;
    int N;

    /**
     * Constructor that initializes an empty N-ary tree, with the given N
     *
     * @param N The N the N-tree should be initialized with
     */
    public CSE12NaryTree(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        this.root = null;
        this.size = 0;
        this.N = N;
    }

    /**
     * TODO: Add method header
     */
    public void add(E element) {
      if(element == null){
        throw new NullPointerException();
      }

      Node newNode = new Node(element);
      if(root == null){
        root = newNode;
        size++;
        return;
      }
      //index of the parent of the node to be added
      //root is index 0
      int parentIdx = (size-1)/N;
      ArrayList<Integer> ancestors = new ArrayList<Integer>();
      while(parentIdx > 0){
        //ancestors holds the order of children to traverse to get to the next
        //insertion point
        ancestors.add(0,(parentIdx-1)%N);
        parentIdx = (parentIdx)/N;
      }
      Node curr = root;
      //how many times to go down before getting to the parent of the new node
      int parentLevel = ancestors.size();
      for(int i = 0; i < parentLevel; i++){
        curr = curr.getChildren().get(ancestors.get(i));
      }
      curr.addChild(newNode);
      size++;
    }

    /**
     * TODO: Add method header
     */
    public boolean contains(E element) {
      if(element == null){
        throw new NullPointerException();
      }

      boolean found = false;
        if(root.getData() == element){
          return true;
        }
        if(root.getNumChildren() == 0){
          return false;
        }
        for(int i = 0; i < root.getNumChildren(); i++){
          //if any children are element, return true
          CSE12NaryTree childTree = new CSE12NaryTree(N);
          childTree.root = root.getChildren().get(i);
          found = found || childTree.contains(element);
        }
        return found;
    }

    /**
     * TODO: Add method header
     */
    public ArrayList<E> sortTree(){
        ArrayList<E> ansList = new ArrayList<E>();
        ArrayList<Node> pQ = new ArrayList<Node>(size);
        PriorityQueue<E> pQ2 = new PriorityQueue<E>(size);
        if(root == null){
          return ansList;
        }
        pQ.add(root);
        while(pQ.size() != 0){
          int n = pQ.size();
          while(n > 0){
            Node curr = pQ.get(0);
            pQ.remove(0);
            pQ2.add(curr.getData());

            for(int i = 0; i < curr.getNumChildren(); i++){
              pQ.add(curr.getChildren().get(i));
            }
            n--;
          }
        }
        while(pQ2.size() != 0){
          ansList.add(pQ2.remove());
        }
        return ansList;
    }
}
