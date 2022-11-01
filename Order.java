import java.util.Comparator;
import java.util.Date;

public class Order implements Comparable<Order>{
    protected Date date;
    protected int product_id;
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

    @Override
    public int compareTo(Order order) {
        return Comparator.comparing(Order::getId)
                .compare(this, order);
    }

    @Override
    //this is required to print the user-friendly information about the Order object
    public String toString() {
        return "Order ID: " + this.id +" ";
    }
}
