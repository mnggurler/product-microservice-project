package org.ayrotek.controller;

import org.ayrotek.kafka.ProducerService;
import org.ayrotek.model.Tax;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxCalculationController {

    private final ProducerService producerService;

    public TaxCalculationController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/calculateTax")
    public double calculateTax(@RequestBody Tax tax) {
        producerService.sendMessage("tax has been calculated");
        return tax.getPrice() + tax.getPrice() * tax.getTax();
    }
}
