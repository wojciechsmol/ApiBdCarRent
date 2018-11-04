package com.smol.api.bd.car.rent.apibdcarrent.repository;

import com.smol.api.bd.car.rent.apibdcarrent.model.Marka;
import org.springframework.data.repository.CrudRepository;

public interface MarkaRepository extends CrudRepository<Marka, Long> {

    Marka findTopByOpis(String opis);
}
