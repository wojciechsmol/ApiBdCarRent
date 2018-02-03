package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.Model;
import com.smol.api.bd.car.rent.apibdcarrent.model.ModelDto;

public interface ModelService {

    ModelDto convertToDto(Model model);
}
