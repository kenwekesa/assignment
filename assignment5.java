import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class assignment5 {
    public static void main(String args []) throws IOException {

       getProducts();
    }

    public static void getProducts()
    {
        List<String> productLines = null;
        try {
            productLines = Files.readAllLines(java.nio.file.Paths.get("./products.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Product product = new Product();
        for (String line: productLines) {
            String[] product_array = line.split(",");
            product.setId(Integer.parseInt(product_array[1]));
            product.setName(product_array[1]);
            product.setWarehouse(product_array[2]);
            product.setLength(Integer.parseInt(product_array[3]));
            product.setAmount(Integer.parseInt(product_array[8]));
            product.setCost(Double.parseDouble(product_array[7]));
            product.setShelf(Integer.parseInt(product_array[6]));
            product.setBin(Integer.parseInt(product_array[7]));
        }
    }
}
