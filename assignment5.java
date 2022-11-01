import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class assignment5 {

    static ArrayList<Order> order_list;
    static ArrayList<Product> product_list;
    public static void main(String args []) throws IOException, ParseException {

        String products_file ="products.txt",
                orders_file="orders.txt";
       getProducts(products_file);
       getOrders(orders_file);
        preparePackingList(product_list,order_list);
    }

    public static void getProducts(String products_file)
    {
        List<String> productLines = null;
        try {
            productLines = Files.readAllLines(java.nio.file.Paths.get("./"+products_file), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        product_list = new ArrayList<>();
        for (String line: productLines) {
            Product product = new Product();
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

        Collections.sort(product_list);


       System.out.println(product_list);
    }

    public static void getOrders(String orders_file) throws ParseException {
        List<String> orderLines = null;
        try {
            orderLines = Files.readAllLines(java.nio.file.Paths.get("./"+orders_file), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        order_list = new ArrayList<>();

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        for (String line: orderLines) {
            Order order = new Order();
            String[] order_attributes_array = line.split(",");
            order.setId(Integer.parseInt(order_attributes_array[0]));
            order.setDate(format.parse(order_attributes_array[1]));
            order.setProduct_id(Integer.parseInt(order_attributes_array[2]));
            order.setQuantity(Integer.parseInt(order_attributes_array[3]));

            order_list.add(order);


        }


    }

    public static void preparePackingList(ArrayList<Product> prods, ArrayList<Order> orders) {
       /* ArrayList<Product> order_products=new ArrayList();

        for(Order order: orders)
        {
            Product productt;
            for(Product product: prods)
            {
                if(product.getId() == order.getId())
                {
                    productt = product;
                }
            }

        }

    }
    */
        Map<Order, List<Order>> orderListGrouped =(Map) order_list.stream().collect(Collectors.groupingBy(w->w.getId()));

        System.out.println(orderListGrouped);
    }

}
