package ass.qualified;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Item {

    private Product product;
    private String name;
    private String description;

    private static Set<String> keys = new HashSet<>(); // Item name is a unique value key -> setName()

    /*
        Item key is not removed from the key set when association is removed.
        We assume that the object is still alive and ready for a new association
     */

    public Item(String name, String description) {
        setName(name);
        setDescription(description);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        if (this.product == product) {
            return;
        }
        if (this.product == null && product != null) {
            this.product = product;
            product.addItem(this);
        }
        if (this.product != null && product == null) {
            Product p = this.product;
            this.product = null;
            p.removeItem(this);
        }
        if (this.product != null && product != null) {
            Product p = this.product;
            this.product = null;
            p.removeItem(this);

            this.product = product;
            product.addItem(this);
        }
    }

    public void removeProduct() {
        if (this.product == null) {
            return;
        }
        if (!this.product.getItems().containsKey(this.getName())) {
            return;
        }
        this.product.removeItem(this);
        this.product = null;
    }

    public static Set<String> getKeys() {
        return Collections.unmodifiableSet(keys);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Item description is required");
        }
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Item name is required");
        }
        if (keys.contains(name)) {
            throw new IllegalArgumentException("Item with the following key already exists");
        }
        this.name = name;
        keys.add(name);
    }
}
