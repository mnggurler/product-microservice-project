package org.ayrotek.service;


import org.ayrotek.model.Product;

import java.util.List;


public interface UserProductService {

    void createProduct(Product product);

    boolean updateProduct(Integer id, Product product);

    boolean deleteProduct(Integer id);

    List<Product> getAllProducts();

}
