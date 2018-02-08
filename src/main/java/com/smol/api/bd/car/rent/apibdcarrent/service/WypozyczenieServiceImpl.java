package com.smol.api.bd.car.rent.apibdcarrent.service;


import com.smol.api.bd.car.rent.apibdcarrent.model.Pojazd;
import com.smol.api.bd.car.rent.apibdcarrent.model.Pracownik;
import com.smol.api.bd.car.rent.apibdcarrent.model.Wypozyczenie;
import com.smol.api.bd.car.rent.apibdcarrent.model.WypozyczenieDto;
import com.smol.api.bd.car.rent.apibdcarrent.repository.PojazdRepository;
import com.smol.api.bd.car.rent.apibdcarrent.repository.PracownikRepository;
import com.smol.api.bd.car.rent.apibdcarrent.repository.WypozyczenieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WypozyczenieServiceImpl implements WypozyczenieService {

    private WypozyczenieRepository wypozyczenieRepository;
    private ModelMapper mModelMapper;
    private PojazdRepository mPojazdRepository;
    private PracownikRepository mPracownikRepository;
    private PojazdService mPojazdService;

    @Autowired
    public WypozyczenieServiceImpl(WypozyczenieRepository wypozyczenieRepository, ModelMapper modelMapper, PojazdRepository pojazdRepository, PracownikRepository pracownikRepository, PojazdService pojazdService) {
        this.wypozyczenieRepository = wypozyczenieRepository;
        mModelMapper = modelMapper;
        mPojazdRepository = pojazdRepository;
        mPracownikRepository = pracownikRepository;
        mPojazdService = pojazdService;
    }


    @Override
    public List<Wypozyczenie> getAllWypozyczenia() {
        List<Wypozyczenie> wypozyczenia = new ArrayList<>();
        wypozyczenieRepository.findAll().forEach(wypozyczenia::add);
        return wypozyczenia;
    }

    @Override
    public Wypozyczenie updateWypozyczenie(Long wypozyczenieId, WypozyczenieDto wypozyczenieDetails) {
        if (!wypozyczenieRepository.exists(wypozyczenieId))
            return null;

        Wypozyczenie wypozyczenie = wypozyczenieRepository.findOne(wypozyczenieId);

        if (wypozyczenieDetails.getFaktycznaDataRozpoczecia() != null)
            wypozyczenie.setFaktycznaDataRozpoczecia(wypozyczenieDetails.getFaktycznaDataRozpoczecia());
        if (wypozyczenieDetails.getPlanowanaDataRozpoczecia() != null)
            wypozyczenie.setPlanowanaDataRozpoczecia(wypozyczenieDetails.getPlanowanaDataRozpoczecia());
        if (wypozyczenieDetails.getFaktycznaDataZakonczenia() != null)
            wypozyczenie.setFaktycznaDataZakonczenia(wypozyczenieDetails.getFaktycznaDataZakonczenia());
        if (wypozyczenieDetails.getPlanowanaDataZakonczenia() != null)
            wypozyczenie.setPlanowanaDataZakonczenia(wypozyczenieDetails.getPlanowanaDataZakonczenia());
        if (wypozyczenieDetails.getPrzebiegRozpoczecia() != 0)
            wypozyczenie.setPrzebiegRozpoczecia(wypozyczenieDetails.getPrzebiegRozpoczecia());
        if (wypozyczenieDetails.getPrzebiegZakonczenia() != 0)
            wypozyczenie.setPrzebiegZakonczenia(wypozyczenieDetails.getPrzebiegZakonczenia());
        if (wypozyczenieDetails.getStatusWypozyczenia() != null)
            wypozyczenie.setStatusWypozyczenia(wypozyczenieDetails.getStatusWypozyczenia());

        if (wypozyczenieDetails.getIdPojazdu() != null) {
            //if Id don't match then we've got to change the pojazd
            if (wypozyczenieDetails.getIdPojazdu() != wypozyczenie.getPojazd().getId()) {
                Pojazd pojazd = mPojazdRepository.findOne(wypozyczenieDetails.getIdPojazdu());

                //if the Pojazd is available
                if (pojazd != null && pojazd.getStatus() != Pojazd.statusPojazdu.ZŁOMOWANY &&
                        pojazd.getStatus() != Pojazd.statusPojazdu.W_NAPRAWIE &&
                        !pojazd.isTaken(wypozyczenie.getFaktycznaDataRozpoczecia(), wypozyczenie.getFaktycznaDataZakonczenia()) &&
                        !pojazd.isTaken(wypozyczenie.getPlanowanaDataRozpoczecia(), wypozyczenie.getPlanowanaDataZakonczenia())) {

                    wypozyczenie.getPojazd().getWypozyczenia().remove(wypozyczenie);
                    mPojazdRepository.save(wypozyczenie.getPojazd());

                    wypozyczenie.setPojazd(pojazd);
                    pojazd.getWypozyczenia().add(wypozyczenie);
                    mPojazdRepository.save(pojazd);
                }
            }
        }

        if (wypozyczenieDetails.getIdPracownika() != null) {
            //if Id don't match then we've got to change the pracownik
            if (wypozyczenieDetails.getIdPracownika() != wypozyczenie.getPracownik().getId()) {
                Pracownik pracownik = mPracownikRepository.findOne(wypozyczenieDetails.getIdPracownika());

                //if pracownik is ZWOLNIONY then can't book the car
                if (pracownik != null && pracownik.getStatusZatrudnienia() != Pracownik.StatusZatrudnienia.ZWOLNIONY) {
                    wypozyczenie.getPracownik().getWypozyczenia().remove(wypozyczenie);
                    mPracownikRepository.save(wypozyczenie.getPracownik());

                    wypozyczenie.setPracownik(pracownik);
                    pracownik.getWypozyczenia().add(wypozyczenie);
                    mPracownikRepository.save(pracownik);

                }
            }
        }

        wypozyczenieRepository.save(wypozyczenie);
        return wypozyczenie;

    }

    @Override
    public Wypozyczenie createWypozyczenie(WypozyczenieDto wypozyczenieDto) {
        //Should be validation if the car available

        Wypozyczenie wypozyczenie = convertFromDto(wypozyczenieDto);
        if (wypozyczenie.getPracownik() == null || wypozyczenie.getPojazd() == null || wypozyczenie.getPracownik().getStatusZatrudnienia() == Pracownik.StatusZatrudnienia.ZWOLNIONY)
            return null;


        wypozyczenie.getPojazd().getWypozyczenia().add(wypozyczenie);
        mPojazdRepository.save(wypozyczenie.getPojazd());

        wypozyczenie.getPracownik().getWypozyczenia().add(wypozyczenie);
        mPracownikRepository.save(wypozyczenie.getPracownik());

        wypozyczenieRepository.save(wypozyczenie);

        return wypozyczenie;
    }

    @Override
    public Wypozyczenie getWypozyczenie(Long wypozyczenieId) {
        if (!wypozyczenieRepository.exists(wypozyczenieId)) {
            return null;
        }
        return wypozyczenieRepository.findOne(wypozyczenieId);
    }

    @Override
    public boolean deleteWypozyczenie(Long wypozyczenieId) {

        if (!wypozyczenieRepository.exists(wypozyczenieId))
            return false;

        Wypozyczenie wypozyczenie = wypozyczenieRepository.findOne(wypozyczenieId);

        Pracownik pracownik = wypozyczenie.getPracownik();
        pracownik.getWypozyczenia().remove(wypozyczenie);
        mPracownikRepository.save(pracownik);

        Pojazd pojazd = wypozyczenie.getPojazd();
        pojazd.getWypozyczenia().remove(wypozyczenie);
        mPojazdRepository.save(pojazd);

        wypozyczenieRepository.delete(wypozyczenieId);
        return true;
    }

    @Override
    public WypozyczenieDto convertToDto(Wypozyczenie wypozyczenie) {
        WypozyczenieDto wypozyczenieDto = new WypozyczenieDto();
        mModelMapper.map(wypozyczenie, wypozyczenieDto);

        wypozyczenieDto.setIdPojazdu(wypozyczenie.getPojazd().getId());
        wypozyczenieDto.setIdPracownika(wypozyczenie.getPracownik().getId());
        return wypozyczenieDto;
    }

    @Override
    public Wypozyczenie convertFromDto(WypozyczenieDto wypozyczenieDto) {
        Wypozyczenie wypozyczenie = mModelMapper.map(wypozyczenieDto, Wypozyczenie.class);
        if (mPracownikRepository.exists(wypozyczenieDto.getIdPracownika()))
            wypozyczenie.setPracownik(mPracownikRepository.findOne(wypozyczenieDto.getIdPracownika()));

        if (mPojazdRepository.exists(wypozyczenieDto.getIdPojazdu()))
            wypozyczenie.setPojazd(mPojazdRepository.findOne(wypozyczenieDto.getIdPojazdu()));


        return wypozyczenie;
    }
}
