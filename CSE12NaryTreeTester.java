/**
 * Name: Daniel Lee
 * ID: A17209209
 * Email: dtl001@ucsd.edu
 * File description: This file contains the CSE12NaryTreeTester class which
 tests edge cases for the CSE12NaryTree class. The class is dependent upon
 the add method working perfectly.
 */

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 *
 The CSE12NaryTreeTester class tests edge cases for the CSE12NaryTree class.
 The class is dependent upon the add method working perfectly.
 */
public class CSE12NaryTreeTester {
    private CSE12NaryTree<Integer> tree = new CSE12NaryTree<Integer>(5);
    private CSE12NaryTree<Integer> tree2 = new CSE12NaryTree<Integer>(5);
    private CSE12NaryTree<Integer> tree3 = new CSE12NaryTree<Integer>(5);

    @Before
    public void setUp(){
      tree.add((Integer)0);
      tree.add((Integer)1);
      tree.add((Integer)2);
      tree.add((Integer)3);
      tree.add((Integer)4);
      tree.add((Integer)5);
      tree2.add((Integer)3);
      tree2.add((Integer)2);
      tree2.add((Integer)0);
      tree2.add((Integer)8);
      tree2.add((Integer)5);
      tree2.add((Integer)4);
      tree2.add((Integer)7);
      tree2.add((Integer)6);
      tree2.add((Integer)1);
      tree2.add((Integer)9);
      tree2.add((Integer)12);
      tree2.add((Integer)11);
      tree2.add((Integer)10);
      tree2.add((Integer)13);
      tree3.add((Integer)5);
    }
    /**
     *  Tests the add method on a 5-ary tree that already contains
     only a root node and its 5 children nodes.
     */
    @Test
    public void testAdd(){
      tree.add(6);
      assertEquals((Integer)6, tree.root.getChildren().get(0).getChildren().
          get(0).getData());
    }



    /**
     * Tests the contains method on a 5-ary tree when the element is
      not present in it.
     */
    @Test
    public void testContains(){
      assertFalse(tree.contains(10));

      assertTrue(tree.contains(0));
      assertTrue(tree.contains(1));
      assertTrue(tree.contains(2));
      assertTrue(tree.contains(3));
      assertTrue(tree.contains(4));
      assertTrue(tree.contains(5));


    }

    /**
     * Tests the sortTree method on a 5-ary tree that contains only
      the root node.
     */
    @Test
    public void testSortTree(){
      assertEquals((Integer)5, tree3.sortTree().get(0));
    }

    /**
     * test treeSort on a tree with multiple levels. This is different than
     testSortTree because it has multiple nodes which are children of other
     nodes.
     */
    @Test
    public void testCustom(){
      ArrayList<Integer> ansList = tree2.sortTree();
      assertEquals((Integer)0, ansList.get(0));
      for(int i = 0; i < tree2.size; i++){
        assertEquals((Integer)i, ansList.get(i));
      }
    }
}
