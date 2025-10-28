package exception_handling.demo.ecommerce_application;

public class Product {
  private int productID;
  private String name;
  private double price;
  private int quantityInStock;

  public Product() {}

  public Product(int productID, String name, double price, int quantityInStock) {
    this.productID = productID;
    this.name = name;
    this.price = price;
    this.quantityInStock = quantityInStock;
  }

  public int getProductID() {
    return productID;
  }

  public void setProductID(int productID) {
    this.productID = productID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getQuantityInStock() {
    return quantityInStock;
  }

  public void setQuantityInStock(int quantityInStock) {
    this.quantityInStock = quantityInStock;
  }

  public void displayProductInfo() {
    System.out.println("**********************************");
    System.out.println("Product ID: " + getProductID());
    System.out.println("Product Name: " + getName());
    System.out.println("Product Price: " + getPrice());
    System.out.println("Quantity In Stock: " + getQuantityInStock());
    System.out.println("**********************************");
  }
}
