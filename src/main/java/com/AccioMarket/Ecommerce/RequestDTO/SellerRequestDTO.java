package com.AccioMarket.Ecommerce.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellerRequestDTO {
    private String name;
    private String mobNo;
    private String email;
    private String panNo;
}
