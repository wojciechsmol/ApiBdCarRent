package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.Marka;
import com.smol.api.bd.car.rent.apibdcarrent.model.MarkaDto;
import com.smol.api.bd.car.rent.apibdcarrent.repository.MarkaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkaServiceImpl implements MarkaService {

    ModelMapper mModelMapper;

    @Autowired
    public MarkaServiceImpl(ModelMapper modelMapper) {
        mModelMapper = modelMapper;
    }


    @Override
    public MarkaDto convertToDto(Marka marka) {
        return mModelMapper.map(marka, MarkaDto.class);
    }
}
