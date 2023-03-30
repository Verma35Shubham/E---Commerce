package com.AccioMarket.Ecommerce.Services;

import com.AccioMarket.Ecommerce.Exceptions.CustomerNotFoundException;
import com.AccioMarket.Ecommerce.RequestDTO.CardRequestDTO;
import com.AccioMarket.Ecommerce.ResponseDTO.CardResponseDTO;

public interface CardService {

    public CardResponseDTO addCard(CardRequestDTO cardRequestDTO) throws CustomerNotFoundException;
}
