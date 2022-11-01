import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class assignment5 {
    public static void main(String args []) throws IOException, ParseException {

       getProducts();
       getOrders();
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
        ArrayList<Product> product_list = new ArrayList<>();
        for (String line: productLines) {
            String[] product_attributes_array = line.split(",");
            product.setId(Integer.parseInt(product_attributes_array[0]));
            product.setName(product_attributes_array[1]);
            product.setWarehouse(product_attributes_array[6]);
            product.setLength(Integer.parseInt(product_attributes_array[2]));
            product.setWidth(Integer.parseInt(product_attributes_array[3]));
            product.setHeight(Integer.parseInt(product_attributes_array[4]));
            product.setWeight(Integer.parseInt(product_attributes_array[5]));
            product.setAisle(Integer.parseInt(product_attributes_array[7]));
            product.setCost(product_attributes_array[10]);
            product.setAmount(Integer.parseInt(product_attributes_array[11]));
            product.setShelf(Integer.parseInt(product_attributes_array[8]));
            product.setBin(Integer.parseInt(product_attributes_array[9]));

            product_list.add(product);
        }

        System.out.println(product_list);
    }

    public static void getOrders() throws ParseException {
        List<String> orderLines = null;
        try {
            orderLines = Files.readAllLines(java.nio.file.Paths.get("./orders.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Order order = new Order();
        ArrayList<Order> order_list = new ArrayList<>();

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        for (String line: orderLines) {
            String[] order_attributes_array = line.split(",");
            order.setId(Integer.parseInt(order_attributes_array[0]));
            order.setDate(format.parse(order_attributes_array[1]));
            order.setProduct_id(Integer.parseInt(order_attributes_array[2]));
            order.setQuantity(Integer.parseInt(order_attributes_array[3]));

            order_list.add(order);


        }


    }
}
