package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.*;
import com.smol.api.bd.car.rent.apibdcarrent.repository.MarkaRepository;
import com.smol.api.bd.car.rent.apibdcarrent.repository.ModelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ModelServiceImpl implements ModelService {

    ModelMapper mModelMapper;
    ModelRepository mModelRepository;
    MarkaService mMarkaService;
    MarkaRepository mMarkaRepository;

    @Autowired
    public ModelServiceImpl(ModelMapper modelMapper, ModelRepository modelRepository, MarkaService markaService, MarkaRepository markaRepository) {
        mModelMapper = modelMapper;
        mModelRepository = modelRepository;
        mMarkaService = markaService;
        mMarkaRepository = markaRepository;
    }

    @Override
    public ModelDto convertToDto(Model model) {

        return mModelMapper.map(model, ModelDto.class);
    }

    @Override
    public Model convertFromDto(ModelDto modelDto, PojazdDto pojazdDto) {

        Model model = mModelMapper.map(modelDto, Model.class);
        model.setMarka(mMarkaService.convertFromDto(pojazdDto.getMarka()));

        Marka marka = model.getMarka();
        if (marka.getModele() == null)
            marka.setModele(new ArrayList<>());
        marka.getModele().add(model);

        mModelRepository.save(model);

        return model;
    }
}
