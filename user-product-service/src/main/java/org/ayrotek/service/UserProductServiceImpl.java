package org.ayrotek.service;

import lombok.RequiredArgsConstructor;
import org.ayrotek.client.TaxClient;
import org.ayrotek.entity.ProductDAO;
import org.ayrotek.kafka.ProducerService;
import org.ayrotek.model.Product;
import org.ayrotek.model.Tax;
import org.ayrotek.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserProductServiceImpl implements UserProductService{

    private final TaxClient taxClient;
    private final ProductRepository productRepository;
    private final ProducerService producerService;

    @Override
    public void createProduct(Product product) {
        double totalTax = getTotalTax(product);

        ProductDAO productDao = new ProductDAO();

        productDao.setName(product.getName());
        productDao.setDescription(product.getDescription());
        productDao.setPrice(totalTax);
        productDao.setTax(product.getTax());

        productRepository.save(productDao);
        producerService.sendMessage("create Product has been established");
    }


    @Override
    public boolean updateProduct(Integer id, Product product){
        ProductDAO productDao = productRepository.findById(id).orElse(null);

        if(ObjectUtils.isEmpty(productDao)){
            return false;
        }
        double totalTax = getTotalTax(product);

        productDao.setName(product.getName());
        productDao.setDescription(product.getDescription());
        productDao.setPrice(totalTax);
        productDao.setTax(product.getTax());

        productRepository.save(productDao);
        producerService.sendMessage("update Product has been established");

        return true;
    }

    @Override
    public boolean deleteProduct(Integer id){
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            producerService.sendMessage("delete Product has been established");
            return true;
        }
        return false;
    }

    @Override
    public List<Product> getAllProducts(){
        List<ProductDAO> productDaoList = (List<ProductDAO>) productRepository.findAll();

        producerService.sendMessage("all Product has been returned.");
        return productDaoList.stream()
                .map(productDao -> new Product(
                        productDao.getName(),
                        productDao.getDescription(),
                        productDao.getPrice(),
                        productDao.getTax()                         // Set tax to null or calculate if needed
                ))
                .collect(Collectors.toList());
    }

    private double getTotalTax(Product product) {
        Tax tax = new Tax();
        tax.setPrice(product.getPrice());
        tax.setTax(product.getTax());

        return taxClient.calculateTax(tax);
    }
    
}
