package com.AccioMarket.Ecommerce.ResponseDTO;

import com.AccioMarket.Ecommerce.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardDTO {
    private String CardNo;

    private CardType cardType;
}
