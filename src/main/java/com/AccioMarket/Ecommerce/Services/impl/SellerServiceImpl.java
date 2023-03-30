package com.AccioMarket.Ecommerce.Services.impl;

import com.AccioMarket.Ecommerce.Convertor.SellerConvertor;
import com.AccioMarket.Ecommerce.Exceptions.SellerNotFoundException;
import com.AccioMarket.Ecommerce.Model.Seller;
import com.AccioMarket.Ecommerce.Repository.SellerRepository;
import com.AccioMarket.Ecommerce.RequestDTO.SellerRequestDTO;
import com.AccioMarket.Ecommerce.ResponseDTO.SellerResponseDTO;
import com.AccioMarket.Ecommerce.Services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    SellerRepository sellerRepository;
    @Override
    public String addSeller(SellerRequestDTO sellerRequestDTO) {
        Seller seller = SellerConvertor.SellerRequestDtoToSeller(sellerRequestDTO);
        sellerRepository.save(seller);
        return "Congratulation! Now you can sell on Accio Market !!!";
    }

    @Override
    public List<SellerResponseDTO> getSellers() throws SellerNotFoundException {
        List<Seller> sellerList;

        try{
            sellerList = sellerRepository.findAll();
        }
        catch (Exception e){
            throw new SellerNotFoundException("NO Seller Present Yet!");
        }

        List<SellerResponseDTO> AllSeller = new ArrayList<>();

        for(Seller seller : sellerList){
            SellerResponseDTO sellerResponseDTO = SellerConvertor.SellertoToSellerResponseDTO(seller);
            AllSeller.add(sellerResponseDTO);
        }

        return  AllSeller;
    }

    @Override
    public SellerResponseDTO getSellerByPanNo(String panNo) throws SellerNotFoundException {
        Seller seller;
        try{
            seller = sellerRepository.findByPanNo(panNo);
        }
        catch (Exception e){
            throw new SellerNotFoundException("Invalid Pan Number!");
        }

        return SellerConvertor.SellertoToSellerResponseDTO(seller);
    }


}
