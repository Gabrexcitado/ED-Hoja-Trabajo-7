import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase que lee el archivo CSV y lo escribe (Hecho con ayuda de Inteligencia Artifical)
 */
public class Converter {

    /**
     * Metodo que convierte el csv en un arbol
     * @param file archivo a leer
     * @param orderByName determina cual sera la clave del arbol
     * @return arbol con los productos
     */
    public BinaryTree<String, Product> loadProducts(String file, boolean orderByName){
        BinaryTree<String, Product> tree = new BinaryTree<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            br.readLine(); 
            line = br.readLine();
            while(line != null){

                String[] data = line.split(",");
                
                String SKU = data[0];
                String name = data[1].toLowerCase();
                String description = data[2].toLowerCase();
                String size_amount = data[3].toLowerCase();

                Product product = new Product(SKU, name, description, size_amount);

                //Orden del árbol segun el input
                String key;
                if(orderByName){
                    key = name;
                }else{
                    key = SKU;
                }

                
                tree.setRoot(tree.insert(tree.getRoot(),key, product));
                line = br.readLine();
                
            }

        }catch(IOException e){
            System.out.println("Error al leer el archivo");

        }
        return tree;

    }

    public void saveProducts(String file, BinaryTree<String, Product> tree){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            bw.write("SKU,Nombre,Descripcion,Cantidad por talla\n");
            writeInOrder(tree.getRoot(), bw);
            
        }catch(IOException e){
            System.out.println("Error al escribir el CSV");
        }
    }

    public void writeInOrder(BinaryTree<String, Product>.Node node, BufferedWriter bw) throws IOException{
        if(node == null){
            return;
        }

        writeInOrder(node.left, bw);
        Product product = node.value;
        bw.write(product.toString() + "\n");
        writeInOrder(node.right, bw);
    }
}
