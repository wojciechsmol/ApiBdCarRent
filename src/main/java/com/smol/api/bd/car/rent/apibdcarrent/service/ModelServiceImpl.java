package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.Model;
import com.smol.api.bd.car.rent.apibdcarrent.model.ModelDto;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {

    @Override
    public ModelDto convertToDto(Model model) {
        return new ModelDto(model.getId(),
                model.getNazwa(),
                model.getIloscMiejsc(),
                model.getRokProdukcji(),
                model.getTypNadwozia());
    }
}
