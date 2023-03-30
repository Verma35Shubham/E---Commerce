package com.AccioMarket.Ecommerce.Convertor;

import com.AccioMarket.Ecommerce.Model.Seller;
import com.AccioMarket.Ecommerce.RequestDTO.SellerRequestDTO;
import com.AccioMarket.Ecommerce.ResponseDTO.SellerResponseDTO;

public class SellerConvertor {
    public static Seller SellerRequestDtoToSeller(SellerRequestDTO sellerRequestDTO){
        return Seller.builder()
                .name(sellerRequestDTO.getName())
                .email(sellerRequestDTO.getEmail())
                .mobNo(sellerRequestDTO.getMobNo())
                .panNo(sellerRequestDTO.getPanNo()).build();
    }

    public static SellerResponseDTO SellertoToSellerResponseDTO(Seller seller){
        return SellerResponseDTO.builder()
                .name(seller.getName())
                .mobNo(seller.getMobNo())
                .email(seller.getEmail())
                .panNo(seller.getPanNo())
                .build();
    }
}
