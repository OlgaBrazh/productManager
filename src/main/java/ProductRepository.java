import java.util.PrimitiveIterator;

//package org.example.ProductManager;
public class ProductRepository {
    protected Product[] products = new Product[0];


    public Product[] getProducts() {

        return products;
    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        Product findId = findById(id);
        if (findId == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found"
            );
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }


    public void save(Product product) {
        Product findId = findById(product.getId());
        if (findId != null) {
            throw new AlreadyExistsException(
                    "Element with id: " + product.getId() + " already exists"
            );
        }
            Product [] tmp = new Product [products.length+1];
            for (int i = 0; i < products.length; i++) {
                tmp[i] = products[i];
            }
            tmp[tmp.length - 1] = product;
            products = tmp;
        }
    }
