package com.smol.api.bd.car.rent.apibdcarrent.repository;

import com.smol.api.bd.car.rent.apibdcarrent.model.Opieka;
import org.springframework.data.repository.CrudRepository;

public interface OpiekaRepository extends CrudRepository<Opieka, Long> {
    Opieka findFirstByPojazdId(Long id);
}
