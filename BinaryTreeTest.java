import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Pruebas para busqueda e inserción de productos en el arbol
 */
public class BinaryTreeTest {

    private BinaryTree<String, Product> tree;

    @BeforeEach
    public void setUp() {
        tree = new BinaryTree<>();
        
        // Insertar productos en el árbol
        Product p1 = new Product("SKU1", "Producto A", "Descripción A", "M:10,L:5");
        Product p2 = new Product("SKU2", "Producto B", "Descripción B", "S:15,M:10");
        Product p3 = new Product("SKU3", "Producto C", "Descripción C", "L:20,XL:10");
        
        // Insertar productos con la clave como nombre
        tree.setRoot(tree.insert(tree.getRoot(), p1.getName().toLowerCase(), p1));
        tree.setRoot(tree.insert(tree.getRoot(), p2.getName().toLowerCase(), p2));
        tree.setRoot(tree.insert(tree.getRoot(), p3.getName().toLowerCase(), p3));
    }

    @Test
    public void testInsertAndSearch() {
        // Verificar que los productos fueron insertados correctamente
        assertNotNull(tree.search(tree.getRoot(), "producto a"));
        assertNotNull(tree.search(tree.getRoot(), "producto b"));
        assertNotNull(tree.search(tree.getRoot(), "producto c"));

        // Verificar que se puede acceder a los productos correctamente
        assertEquals("Producto A", tree.search(tree.getRoot(), "producto a").getValue().getName());
        assertEquals("Producto B", tree.search(tree.getRoot(), "producto b").getValue().getName());
        assertEquals("Producto C", tree.search(tree.getRoot(), "producto c").getValue().getName());
    }

    @Test
    public void testSearchNonExistentProduct() {
        // Intentar buscar un producto que no existe
        assertNull(tree.search(tree.getRoot(), "producto inexistente"));
    }
}
