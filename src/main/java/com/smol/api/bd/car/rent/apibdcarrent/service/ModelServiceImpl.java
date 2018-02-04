package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.Model;
import com.smol.api.bd.car.rent.apibdcarrent.model.ModelDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {

    ModelMapper mModelMapper;

    @Autowired
    public ModelServiceImpl(ModelMapper modelMapper) {
        mModelMapper = modelMapper;
    }


    @Override
    public ModelDto convertToDto(Model model) {

        return mModelMapper.map(model, ModelDto.class);
    }
}
