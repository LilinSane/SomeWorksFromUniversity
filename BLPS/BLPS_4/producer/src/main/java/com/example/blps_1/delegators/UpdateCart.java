package com.example.blps_1.delegators;

import com.example.blps_1.dto.ProductDTO;
import com.example.blps_1.service.CartService;
import jakarta.inject.Named;
import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named("updateCart")
@AllArgsConstructor
public class UpdateCart implements JavaDelegate {

    private CartService cartService;

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
        cartService.update((Long) delegateExecution.getVariable("client_id"), productDTO);
    }
}
