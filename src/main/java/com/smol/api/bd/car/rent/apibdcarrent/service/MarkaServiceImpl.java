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
    MarkaRepository mMarkaRepository;

    @Autowired
    public MarkaServiceImpl(ModelMapper modelMapper, MarkaRepository markaRepository) {
        mModelMapper = modelMapper;
        mMarkaRepository = markaRepository;
    }

    @Override
    public MarkaDto convertToDto(Marka marka) {
        return mModelMapper.map(marka, MarkaDto.class);
    }

    @Override
    public Marka convertFromDto(MarkaDto markaDto) {

        Marka marka = mMarkaRepository.findTopByOpis(markaDto.getOpis());
        if(marka != null)
            return marka;

        marka = mModelMapper.map(markaDto, Marka.class);
        marka.setOpis(markaDto.getOpis());
        mMarkaRepository.save(marka);
        return  marka;
    }
}
