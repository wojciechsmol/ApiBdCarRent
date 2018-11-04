package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.Model;
import com.smol.api.bd.car.rent.apibdcarrent.model.ModelDto;
import com.smol.api.bd.car.rent.apibdcarrent.model.PojazdDto;

public interface ModelService {

    ModelDto convertToDto(Model model);

    Model convertFromDto(ModelDto modelDto, PojazdDto pojazdDto);
}
