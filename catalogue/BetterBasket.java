package catalogue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BetterBasket extends Basket and uses a map to manage products.
 * It allows adding products and updating quantities if the product already exists.
 * 
 * @author Jayanshi Rawat 
 * @version 1.0
 * 
 */
public class BetterBasket extends Basket implements Serializable {
    private Map<String, Product> productMap;

    // Initialise basket.
    public BetterBasket() {
        super();
        productMap = new HashMap<>();
    }

    /**
     * Adds a product to the basket or updates the quantity if the product already exists.
     * 
     * @param pr the product to be added or updated
     * @return true if the product was successfully added or updated, false otherwise
     */
    @Override
    public boolean add(Product pr) {
        // Get product number.
        String nProduct = pr.getProductNum();

        // If the product exists within the map:
        if (productMap.containsKey(nProduct)) {
            // Update product quantity.
            Product existingProduct = productMap.get(nProduct);
            existingProduct.setQuantity(existingProduct.getQuantity() + pr.getQuantity());
        } else {
            // Add new product to the map.
            productMap.put(nProduct, pr);
        }

        // Sort the products and update the collection.
        return sortAndUpdate();
    }

    /**
     * Sorts the products by their product number and updates the collection in the superclass.
     * 
     * @return true if sorting and updating were successful
     */
    private boolean sortAndUpdate() {
        // Convert productMap to a list.
        List<Product> productList = new ArrayList<>(productMap.values());

        // Sort the list by product number.
        Collections.sort(productList, Comparator.comparing(Product::getProductNum));

        // Clear the collection in the superclass.
        super.clear();
        // Add the sorted values back into the collection.
        super.addAll(productList);

        return true;
    }
}
