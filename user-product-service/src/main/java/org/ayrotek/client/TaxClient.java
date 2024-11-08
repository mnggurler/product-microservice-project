package org.ayrotek.client;

import org.ayrotek.model.Tax;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name="taxClient", url = "http://localhost:8085")
public interface TaxClient {

    @PostMapping("/calculateTax")
    double calculateTax(@RequestBody Tax tax);
}
