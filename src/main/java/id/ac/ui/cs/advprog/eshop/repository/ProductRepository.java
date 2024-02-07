package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private final List<Product> productData = new ArrayList<>();

    public void create(Product product) {
        String productId = productData.size() + 1 + "";
        product.setProductId(productId);
        productData.add(product);
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public void update(Product updatedProduct, String productID) {
        Product productData = findById(productID);
        productData.setProductName(updatedProduct.getProductName());
        productData.setProductQuantity(updatedProduct.getProductQuantity());
    }

    public Product findById(String productId) {
        for(Product product: productData) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public void delete(String productId) {
        Product deletedProduct = findById(productId);
        productData.remove(deletedProduct);
    }
}