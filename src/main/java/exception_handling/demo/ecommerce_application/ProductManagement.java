package exception_handling.demo.ecommerce_application;

public class ProductManagement {
  private final Product[] products = new Product[10];
  private int productCount = 0;
  private Product currentProduct;

  public ProductManagement addProduct() {
    if (productCount >= products.length) {
      throw new RuntimeException("Full Storage!");
    }

    Product newProduct = new Product();
    products[productCount++] = inputProductDetail(newProduct);

    System.out.println("Product added successfully");
    return this;
  }

  public ProductManagement displayProductByID(int productID) throws ProductNotFoundException {
    Product foundProduct = findProductByID(productID);

    if (foundProduct == null) {
      throw new ProductNotFoundException("Product with ID " + productID + " not found");
    }

    currentProduct = foundProduct;
    System.out.println("Product found successfully");
    return this;
  }

  public ProductManagement updateProductQuantity(int productID, int newQuantity)
      throws ProductNotFoundException {

    Product productToUpdate = findProductByID(productID);

    if (productToUpdate == null) {
      throw new ProductNotFoundException("Product with ID " + productID + " not found");
    }

    productToUpdate.setQuantityInStock(newQuantity);
    currentProduct = productToUpdate;

    System.out.println("Quantity updated successfully");
    return this;
  }

  public Product inputProductDetail(Product newProduct) {
    int newProductID;
    System.out.println("\nEnter product details: ");

    while (true) {
      newProductID = InputHelper.readInt("Product ID: ");

      if (!isExistsId(newProductID)) {
        break;
      }

      System.out.println("Product ID " + newProductID + " is already exists. Try Again!");
    }

    newProduct.setProductID(newProductID);
    newProduct.setName(InputHelper.readString("Product Name: "));
    newProduct.setPrice(InputHelper.readDouble("Product Price: "));
    newProduct.setQuantityInStock(InputHelper.readInt("Quantity In Stock: "));

    currentProduct = newProduct;
    return newProduct;
  }

  public void displayCurrentProductDetail() {
    if (currentProduct != null) {
      currentProduct.displayProductInfo();
    } else {
      System.out.println("No product set for display");
    }
  }

  public boolean isExistsId(int productID) {
    return findProductByID(productID) != null;
  }

  private Product findProductByID(int productID) {
    for (int i = 0; i < productCount; i++) {
      if (products[i] == null) {
        continue;
      }

      if (products[i].getProductID() == productID) {
        return products[i];
      }
    }
    return null;
  }
}
