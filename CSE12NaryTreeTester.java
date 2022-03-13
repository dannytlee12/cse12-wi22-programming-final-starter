/**
 * TODO: Add file header
 * Name:
 * ID:
 * Email:
 * File description:
 */

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * TODO: Add class header
 */
public class CSE12NaryTreeTester {
    CSE12NaryTree<Integer> tree = new CSE12NaryTree<Integer>(3);
    CSE12NaryTree<Integer> tree2 = new CSE12NaryTree<Integer>(5);

    @Before
    public void setUp(){
      tree.add((Integer)0);
      tree.add((Integer)1);
      tree.add((Integer)2);
      tree.add((Integer)3);
      tree.add((Integer)4);
      tree.add((Integer)5);
      tree.add((Integer)6);
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
    }
    /**
     * TODO: Add test case description.
     */
    @Test
    public void testAdd(){

    }


    @Test
    public void testAdd2(){
      tree.add(7);
      assertEquals((Integer)1, tree.root.getChildren().get(0).getData());
      assertEquals((Integer)7, tree.root.getChildren().get(1).getChildren().get(0).getData());
    }

    /**
     * TODO: Add test case description
     */
    @Test
    public void testContains(){
      assertTrue(tree.contains(0));
      assertTrue(tree.contains(1));
      assertTrue(tree.contains(2));
      assertTrue(tree.contains(3));
      assertTrue(tree.contains(4));
      assertTrue(tree.contains(5));
      assertTrue(tree.contains(6));
      assertFalse(tree.contains(10));

    }

    /**
     * TODO: Add test case description
     */
    @Test
    public void testSortTree(){
      ArrayList<Integer> ansList = tree2.sortTree();
      assertEquals((Integer)0, ansList.get(0));
      for(int i = 0; i < tree2.size; i++){
        assertEquals((Integer)i, ansList.get(i));
      }
    }

    /**
     * TODO: Add test case description
     */
    @Test
    public void testCustom(){

    }
}
