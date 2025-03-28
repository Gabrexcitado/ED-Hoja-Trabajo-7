import java.util.HashMap;
import java.util.Map;

public class Product {
    private String SKU, name, description;
    private HashMap<String, Integer> size_amount;

    /**
     * Constructor del producto
     * @param SKU identificador
     * @param name producto
     * @param description descripcion del producto
     * @param size_amount texto con tallas y cantidades
     */
    public Product(String SKU, String name, String description, String size_amount){
        this.SKU = SKU;
        this.name = name;
        this.description = description;
        this.size_amount = parseSize_Amount(size_amount);
    }

    /**
     * Metodo para cambiar la descripcion
     * @param description nueva descripcion
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     * Metodo que convierte la ultima columna del csv en un mapa
     * @return mapa con tallas como claves y cantidad como valor
     */
    public HashMap<String, Integer> parseSize_Amount(String size_amount){
        HashMap<String, Integer> sizesDataMap = new HashMap();

        //separa los datos por '|'
        String[] sizes = size_amount.split("\\|");
        for (String size: sizes){
            String[] data = size.split(":");
            if(data.length == 2){
                sizesDataMap.put(data[0], Integer.parseInt(data[1]));
            }
        }
        return sizesDataMap;
    }

    /**
     * Metodo para reescribir las tallas como en el CSV (realizado con ayuda de IA)
     * @return String de ultima columna del csv
     */
    public String mapToCSV(){
        StringBuilder csvFormat = new StringBuilder();
        for (Map.Entry<String, Integer> entry : size_amount.entrySet()){
            if(csvFormat.length() > 0){
                csvFormat.append("|");
            }

            csvFormat.append(entry.getKey()).append(":").append(entry.getValue());
        }

        return csvFormat.toString();
    }

    /**
     * Metodo para colocar una cantidad a una talla
     * @param amount cantidad
     * @param size talla
     */
    public void setAmountForSize(int amount, String size){
        if(amount >= 0){
            size_amount.put(size, amount);
        }
    }


    /**
     * Metodo para añadir una nueva talla
     * @param size talla
     * @param amount cantidad
     */
    public void addNewSize(String size, int amount){
        if(!size_amount.containsKey(size)){
            size_amount.put(size, amount);
        }
    }

    /**
     * Permite borrar una talla
     * @param size talla
     */
    public void deleteSize(String size){
        size_amount.remove(size);
    }

    /**
     * Acceder al SKU
     * @return SKU
     */
    public String getSKU(){
        return SKU;
    }

    /**
     * Acceder al nombre
     * @return nombre
     */
    public String getName(){
        return name;
    }

    /**
     * Convierte el Producto en formato de CSV
     */
    public String toString(){
        return SKU + "," + "," + description + "," + mapToCSV();
    }
}
