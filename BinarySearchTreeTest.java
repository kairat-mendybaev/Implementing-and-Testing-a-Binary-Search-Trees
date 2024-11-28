import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {
    private BinarySearchTree bst;

    @Before
    public void setUp() {
        bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
    }

    @Test
    public void testSearchExist() {
        assertTrue(bst.search(40));
    }

    @Test
    public void testSearchNotExist() {
        assertFalse(bst.search(100));
    }

    @Test
    public void testDeleteLeafNode() {
        bst.delete(20);
        assertFalse(bst.search(20));
    }

    @Test
    public void testDeleteNodeWithOneChild() {
        bst.delete(30);
        assertFalse(bst.search(30));
        assertTrue(bst.search(20));
        assertTrue(bst.search(40));
    }

    @Test
    public void testDeleteNodeWithTwoChildren() {
        bst.delete(70);
        assertFalse(bst.search(70));
        assertTrue(bst.search(60));
        assertTrue(bst.search(80));
    }

    @Test
    public void testInsertAndTraverse() {
        BinarySearchTree newBst = new BinarySearchTree();
        newBst.insert(10);
        newBst.insert(20);
        newBst.insert(5);
        newBst.inorderTraversal(); // Expected Order: 5, 10, 20
    }
}
