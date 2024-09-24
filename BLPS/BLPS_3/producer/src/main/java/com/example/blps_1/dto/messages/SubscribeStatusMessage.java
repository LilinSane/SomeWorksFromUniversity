package com.example.blps_1.dto.messages;

import com.example.blps_1.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscribeStatusMessage implements Message{
    private Long id;
    private ProductDTO productDTO;
}
