package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.CzynnoscEksploatacyjna;
import com.smol.api.bd.car.rent.apibdcarrent.model.CzynnoscSerwisowa;

public interface EwidencjaKosztowService {

    boolean createEwidencjaKosztowWithCzynnoscEksploatacyjna(CzynnoscEksploatacyjna czynnoscEksploatacyjna);

    boolean createEwidencjaKosztowWithCzynnoscSerwisowa(CzynnoscSerwisowa czynnoscSerwisowa);
}
