package com.example.blps_1.sheduler;

import com.example.blps_1.entity.Product;
import com.example.blps_1.service.ProductService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class AutomaticSendToWarehouseJob implements Job {

    Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private ProductService productService;

    public void execute(JobExecutionContext context) {
        logger.info("Started execution of AutomaticDebitingOfMoneyJob with context = {}", context);
        PageRequest allDataRequest = PageRequest.of(0, Integer.MAX_VALUE);
        Page<Product> products = productService.readAll(allDataRequest);
        products.forEach(product -> {
            product.setAmount(product.getAmount() + 10);
        });
        productService.updateAll(products);

        logger.info("Finished execution of AutomaticDebitingOfMoney");
    }
}