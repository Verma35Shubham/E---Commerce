package com.AccioMarket.Ecommerce.Services.impl;

import com.AccioMarket.Ecommerce.Exceptions.CustomerNotFoundException;
import com.AccioMarket.Ecommerce.Model.Card;
import com.AccioMarket.Ecommerce.Model.Customer;
import com.AccioMarket.Ecommerce.Repository.CustomerRepository;
import com.AccioMarket.Ecommerce.RequestDTO.CardRequestDTO;
import com.AccioMarket.Ecommerce.ResponseDTO.CardDTO;
import com.AccioMarket.Ecommerce.ResponseDTO.CardResponseDTO;
import com.AccioMarket.Ecommerce.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CardResponseDTO addCard(CardRequestDTO cardRequestDTO) throws CustomerNotFoundException {
        Customer customer;
        try {
            customer = customerRepository.findById(cardRequestDTO.getCustomerId()).get();
        } catch (Exception e) {
            throw new CustomerNotFoundException("Invalid customer id");
        }

        Card card = Card.builder()
                .cardNo(cardRequestDTO.getCardNo())
                .cardType(cardRequestDTO.getCardType())
                .cvv(cardRequestDTO.getCvv())
                .customer(customer)
                .build();

        customer.getCards().add(card);

        customerRepository.save(customer);

        CardResponseDTO cardResponseDTO = new CardResponseDTO();
        cardResponseDTO.setName(customer.getName());

        List<CardDTO> cardDTOList = new ArrayList<>();
        for(Card card1 : customer.getCards()){
            CardDTO cardDTO = new CardDTO();
            cardDTO.setCardNo(card1.getCardNo());
            cardDTO.setCardType(card1.getCardType());
            cardDTOList.add(cardDTO);
        }

        cardResponseDTO.setCardLists(cardDTOList);

        return cardResponseDTO;
    }
}
