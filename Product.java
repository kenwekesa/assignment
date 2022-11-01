import java.util.Comparator;

public class Product implements Comparable<Product>{
    private int id;
    private String name,warehouse;
    protected String cost;
    protected int weight,length, width, height,aisle,bin,shelf,amount;

    Product()
    {
        warehouse=name=null;
        weight=length=width=aisle=bin=shelf=amount=id=height=0;
        cost=null;

    }

    Product(int id,String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }/* Setting up the setters
    The do set the variables of the Product object
     */
    public void setName(String name) {
        this.name=name;
    }

    public void setWarehouse(String warehouse){
        this.warehouse=warehouse;}
    public void setCost(String cost)
    {
        this.cost = cost;
    }
    public  void setBin(int bin) {
        this.bin = bin;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void setAisle(int aisle) {
        this.aisle = aisle;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setShelf(int shelf){
        this.shelf=shelf;
    }


    /* Getters
    Setting up the setters
    The do get the variables of the Product object
     */
    public int getId()
    {
        return id;
    }

    public String getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public int getAisle() {
        return aisle;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public int getWeight() {
        return weight;
    }

    public int getAmount() {
        return amount;
    }

    public int getBin() {
        return bin;
    }

    public int getShelf() {
        return shelf;
    }

    public int getWidth() {
        return width;
    }

    public String getWarehouse() {
        return warehouse;
    }

    @Override
    public int compareTo(Product prod) {

        return Comparator.comparing(Product::getAisle)
                .thenComparing(Product::getShelf)
                .thenComparingInt(Product::getBin)
                .compare(this, prod);
    }



        @Override
        //this is required to print the user-friendly information about the Product object
        public String toString() {
            return "[" + this.id + ", " + this.name + "]";
        }



}