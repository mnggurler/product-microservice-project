package org.ayrotek.repository;

import org.ayrotek.entity.ProductDAO;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductDAO, Integer> {
}
