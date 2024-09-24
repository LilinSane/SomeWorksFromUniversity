package com.example.blps_1.delegators;

import com.example.blps_1.dto.ProductDTO;
import com.example.blps_1.service.ProductService;
import jakarta.inject.Named;
import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named("updateProduct")
@AllArgsConstructor
public class UpdateProduct implements JavaDelegate {

    private ProductService productService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String product_name = (String) delegateExecution.getVariable("product_name");
        Long amount = (Long) delegateExecution.getVariable("amount");
        Long category_id = (Long) delegateExecution.getVariable("category_id");
        Long vendor_id = (Long) delegateExecution.getVariable("vendor_id");
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product_name);
        productDTO.setAmount(amount.intValue());
        productDTO.setCategoryId(category_id);
        productDTO.setVendorId(vendor_id);
        productService.updateProductData(productService.readByName(productDTO).getId(), productDTO);
    }
}
