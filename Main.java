import java.util.Scanner;

/**
 * Programa para manejo de productos utilizando arboles binarios
 * @Author Gabriel Hidalgo - 24939
 * Fecha de inicio: 26-03-2025
 * Ultima edicion: 27-03-2025
 */
public class Main {
    public static void main(String[] args) {
        Converter converter = new Converter();
        Scanner sc = new Scanner(System.in);
        String keySearch;
        Product product2;

        BinaryTree<String, Product> nameTree = converter.loadProducts("inventario.csv", true);
        BinaryTree<String, Product> SKUTree = converter.loadProducts("inventario.csv", false);
        
        String option = "-1";
        boolean orderedByName = true;
        System.out.println("\n:::::MENU CON PRODUCTOS ORDENADOS POR NOMBRE:::::");
       
        while (!option.equals("0")) { 
            converter.saveProducts("inventario.csv", nameTree);
           
            System.out.print("1. Agregar nuevo producto\n" +
                "2. Editar descripcion\n" +
                "3. Eliminar talla\n" +
                "4. Agregar talla\n" +
                "5. Editar cantidad por talla\n" +
                "6. Listar productos\n" +
                "7. Buscar Producto \n" +
                "8. Cambiar ordenamiento\n" + 
                "0. Salir\n\n" + 
                "Elige una opcion: ");

            option = sc.nextLine().trim(); 

            switch(option) {
                //Salir
                case "0":
                    System.out.println("Saliendo...");
                    sc.close(); 
                    break;

                //Agregar producto
                case "1":
                    System.out.print("\nIngrese el SKU del producto: ");
                    String SKU = sc.nextLine();

                    System.out.print("\nIngrese el nombre del producto: ");
                    String name = sc.nextLine().toLowerCase();

                    System.out.print("\nIngrese la descripcion del producto: ");
                    String description = sc.nextLine();
                    
                    System.out.print("\nIngrese las tallas y cantidades [ x:##| y:##| ]: ");
                    String size_amount = sc.nextLine();

                    Product product = new Product(SKU, name, description, size_amount);

                    if(orderedByName){
                        nameTree.setRoot(nameTree.insert(nameTree.getRoot(), name, product));
                    }else{
                        SKUTree.setRoot(SKUTree.insert(SKUTree.getRoot(), SKU, product));
                    }

                    converter.saveProducts("inventario.csv", nameTree);
                    System.out.println("\nProducto agregado exitosamente\n");
                    
                    break;

                //Editar descripcion
                case "2":
                if(orderedByName){
                    System.out.print("\nIngrese el nombre del producto: ");
                    keySearch = sc.nextLine().toLowerCase();

                    if(nameTree.search(nameTree.getRoot(), keySearch)!=null){
                        product2 = nameTree.search(nameTree.getRoot(), keySearch).getValue();
                        System.out.println("\nPRODUCTO:\n" + product2.toString() + "\n");

                        System.out.print("\nIngrese nueva descripcion: ");
                        product2.setDescription(sc.nextLine());
                        nameTree.setRoot(nameTree.insert(nameTree.getRoot(), product2.getName(), product2));
                    }else{
                        System.out.println("\n>>>Producto no encontrado\n");
                    }                      
                }else{
                    System.out.print("\nIngrese el SKU del producto: ");
                    keySearch = sc.nextLine().toLowerCase();

                    if(SKUTree.search(SKUTree.getRoot(), keySearch)!=null){
                        product2 = SKUTree.search(SKUTree.getRoot(), keySearch).getValue();
                        System.out.println("\nPRODUCTO:\n" + product2.toString() + "\n");

                        System.out.print("\nIngrese nueva descripcion: ");
                        product2.setDescription(sc.nextLine());
                        SKUTree.setRoot(SKUTree.insert(SKUTree.getRoot(), product2.getSKU(), product2));
                    }else{
                        System.out.println("\n>>>Producto no encontrado\n");
                    }                      
                }
                    break;

                
                case "3":
                if(orderedByName){
                    System.out.print("\nIngrese el nombre del producto: ");
                    keySearch = sc.nextLine().toLowerCase();

                    if(nameTree.search(nameTree.getRoot(), keySearch)!=null){
                        product2 = nameTree.search(nameTree.getRoot(), keySearch).getValue();
                        System.out.println("\nPRODUCTO:\n" + product2.toString() + "\n");

                        System.out.print("\nIngrese talla a eliminar: ");
                        product2.deleteSize(sc.nextLine());
                        nameTree.setRoot(nameTree.insert(nameTree.getRoot(), product2.getName(), product2));
                    }else{
                        System.out.println("\n>>>Producto no encontrado\n");
                    }                      
                }else{
                    System.out.print("\nIngrese el SKU del producto: ");
                    keySearch = sc.nextLine().toLowerCase();

                    if(SKUTree.search(SKUTree.getRoot(), keySearch)!=null){
                        product2 = SKUTree.search(SKUTree.getRoot(), keySearch).getValue();
                        System.out.println("\nPRODUCTO:\n" + product2.toString() + "\n");

                        System.out.print("\nIngrese talla a eliminar: ");
                        product2.deleteSize(sc.nextLine());
                        SKUTree.setRoot(SKUTree.insert(SKUTree.getRoot(), product2.getSKU(), product2));
                    }else{
                        System.out.println("\n>>>Producto no encontrado\n");
                    }                      
                }
                    break;
                case "4":
                if(orderedByName){
                    System.out.print("\nIngrese el nombre del producto: ");
                    keySearch = sc.nextLine().toLowerCase();

                    if(nameTree.search(nameTree.getRoot(), keySearch)!=null){
                        product2 = nameTree.search(nameTree.getRoot(), keySearch).getValue();
                        System.out.println("\nPRODUCTO:\n" + product2.toString() + "\n");

                        System.out.print("\nIngrese talla a agregar: ");
                        product2.addNewSize(sc.nextLine(), 15);
                        nameTree.setRoot(nameTree.insert(nameTree.getRoot(), product2.getName(), product2));
                    }else{
                        System.out.println("\n>>>Producto no encontrado\n");
                    }                      
                }else{
                    System.out.print("\nIngrese el SKU del producto: ");
                    keySearch = sc.nextLine().toLowerCase();

                    if(SKUTree.search(SKUTree.getRoot(), keySearch)!=null){
                        product2 = SKUTree.search(SKUTree.getRoot(), keySearch).getValue();
                        System.out.println("\nPRODUCTO:\n" + product2.toString() + "\n");

                        System.out.print("\nIngrese talla a agregar: ");
                        product2.addNewSize(sc.nextLine(), 15);
                        SKUTree.setRoot(SKUTree.insert(SKUTree.getRoot(), product2.getSKU(), product2));
                    }else{
                        System.out.println("\n>>>Producto no encontrado\n");
                    }                      
                }
                    break;
                case "5":
                if(orderedByName){
                    System.out.print("\nIngrese el nombre del producto: ");
                    keySearch = sc.nextLine().toLowerCase();

                    if(nameTree.search(nameTree.getRoot(), keySearch)!=null){
                        product2 = nameTree.search(nameTree.getRoot(), keySearch).getValue();
                        System.out.println("\nPRODUCTO:\n" + product2.toString() + "\n");

                        System.out.print("\nIngrese cantidad: ");
                        product2.setAmountForSize(15, sc.nextLine());
                        nameTree.setRoot(nameTree.insert(nameTree.getRoot(), product2.getName(), product2));
                    }else{
                        System.out.println("\n>>>Producto no encontrado\n");
                    }                      
                }else{
                    System.out.print("\nIngrese el SKU del producto: ");
                    keySearch = sc.nextLine().toLowerCase();

                    if(SKUTree.search(SKUTree.getRoot(), keySearch)!=null){
                        product2 = SKUTree.search(SKUTree.getRoot(), keySearch).getValue();
                        System.out.println("\nPRODUCTO:\n" + product2.toString() + "\n");

                        System.out.print("\nIngrese nueva descripcion: ");
                        product2.setAmountForSize(15, sc.nextLine());
                        SKUTree.setRoot(SKUTree.insert(SKUTree.getRoot(), product2.getSKU(), product2));
                    }else{
                        System.out.println("\n>>>Producto no encontrado\n");
                    }                      
                }
                    break;
                case "6":
                    if(orderedByName){
                        System.out.println("");
                        nameTree.listInOrder(nameTree.getRoot());
                        System.out.println("");
                    }else{
                        System.out.println("");
                        SKUTree.listInOrder(SKUTree.getRoot());
                        System.out.println("");
                    }
                    break;

                //Buscar producto
                case "7":
                    if(orderedByName){
                        System.out.print("\nIngrese el nombre del producto: ");
                        keySearch = sc.nextLine().toLowerCase();

                        if(nameTree.search(nameTree.getRoot(), keySearch)!=null){
                            System.out.println("\nPRODUCTO:\n" + nameTree.search(nameTree.getRoot(), keySearch).getValue().toString() + "\n");
                        }else{
                            System.out.println("\n>>>Producto no encontrado\n");
                        }                      
                    }else{
                        System.out.print("\nIngrese el SKU del producto: ");
                        keySearch = sc.nextLine().toLowerCase();

                        if(SKUTree.search(SKUTree.getRoot(), keySearch)!=null){
                            System.out.println("\nPRODUCTO:\n" + SKUTree.search(SKUTree.getRoot(), keySearch).getValue().toString() + "\n");
                        }else{
                            System.out.println("\n>>>Producto no encontrado\n");
                        }                      
                    }
                    break;

                //Cambio de arbol
                case "8":
                    orderedByName = false;
                    System.out.println("\n:::::MENU CON PRODUCTOS ORDENADOS POR SKU:::::");
                    break;

                //Control de errores
                default:
                    System.out.println("Opción inválida, por favor ingresa una opción válida");
                    break;
            }
        }
    }
}
