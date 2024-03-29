package com.AccioMarket.Ecommerce.Controllers;

import com.AccioMarket.Ecommerce.Exceptions.CustomerNotFoundException;
import com.AccioMarket.Ecommerce.RequestDTO.CardRequestDTO;
import com.AccioMarket.Ecommerce.ResponseDTO.CardResponseDTO;
import com.AccioMarket.Ecommerce.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardService;

    @PostMapping("/add")
    public ResponseEntity addCard(@RequestBody CardRequestDTO cardRequestDTO){
        CardResponseDTO cardResponseDTO;

        try {
            cardResponseDTO = cardService.addCard(cardRequestDTO);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(cardResponseDTO, HttpStatus.ACCEPTED);
    }


    // remove card

    // remove all cards for a particular customer id
}
