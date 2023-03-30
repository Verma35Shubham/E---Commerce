package com.AccioMarket.Ecommerce.Controllers;

import com.AccioMarket.Ecommerce.Exceptions.SellerNotFoundException;
import com.AccioMarket.Ecommerce.Repository.SellerRepository;
import com.AccioMarket.Ecommerce.RequestDTO.SellerRequestDTO;
import com.AccioMarket.Ecommerce.ResponseDTO.SellerResponseDTO;
import com.AccioMarket.Ecommerce.Services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    SellerService sellerService;

    @PostMapping("/add")
    public String addSeller(@RequestBody SellerRequestDTO sellerRequestDTO){
        return sellerService.addSeller(sellerRequestDTO);
    }

    @GetMapping("/get_sellers")
    public List<SellerResponseDTO> getSellers() throws SellerNotFoundException {
        return sellerService.getSellers();
    }

    @GetMapping("get/by/pan/{panNo}")
    public ResponseEntity getSellerByPanNo(@PathVariable("panNo") String panNo) throws SellerNotFoundException {
        SellerResponseDTO sellerResponseDTO;
        try {
            sellerResponseDTO = sellerService.getSellerByPanNo(panNo);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(sellerResponseDTO, HttpStatus.ACCEPTED);
    }

    // find sellers of a particular age
}
