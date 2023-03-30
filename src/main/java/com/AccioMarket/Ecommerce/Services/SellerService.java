package com.AccioMarket.Ecommerce.Services;

import com.AccioMarket.Ecommerce.Exceptions.SellerNotFoundException;
import com.AccioMarket.Ecommerce.Model.Seller;
import com.AccioMarket.Ecommerce.RequestDTO.SellerRequestDTO;
import com.AccioMarket.Ecommerce.ResponseDTO.SellerResponseDTO;

import java.util.List;

public interface SellerService {

    public String addSeller(SellerRequestDTO sellerRequestDTO);

    public List<SellerResponseDTO> getSellers() throws SellerNotFoundException;

    public SellerResponseDTO getSellerByPanNo(String panNo) throws SellerNotFoundException;
}
