import java.util.Comparator;
import java.util.Date;

public class Order implements Comparable<Order>{
    private Date date;
    protected int product_id,product_bin,product_shelf,product_aisle;
    private int id;
    private int quantity;

    Order()
    {}

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProduct_aisle(int product_aisle) {
        this.product_aisle = product_aisle;
    }

    public void setProduct_bin(int product_bin) {
        this.product_bin = product_bin;
    }

    public void setProduct_shelf(int product_shelf) {
        this.product_shelf = product_shelf;
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getProduct_aisle() {
        return product_aisle;
    }

    public int getProduct_bin() {
        return product_bin;
    }

    public int getProduct_shelf() {
        return product_shelf;
    }

    @Override
    public int compareTo(Order order) {
        return Comparator.comparing(Order::getProduct_aisle)
                .thenComparing(Order::getProduct_shelf)
                .thenComparingInt(Order::getProduct_bin)
                .compare(this, order);
    }

    @Override
    //this is required to print the user-friendly information about the Order object
    public String toString() {
        return "Order ID: " + this.id +" ";
    }
}
