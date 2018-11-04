package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.*;
import com.smol.api.bd.car.rent.apibdcarrent.repository.OpiekaRepository;
import com.smol.api.bd.car.rent.apibdcarrent.repository.PojazdRepository;
import com.smol.api.bd.car.rent.apibdcarrent.repository.PracownikRepository;
import com.smol.api.bd.car.rent.apibdcarrent.repository.WypozyczenieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class PracownikServiceImpl implements PracownikService {

    private PracownikRepository pracownikRepository;
    private ModelMapper mModelMapper;
    private OpiekaRepository mOpiekaRepository;
    private WypozyczenieRepository wypozyczenieRepository;

    PojazdRepository mPojazdRepository;

    @Autowired
    public PracownikServiceImpl(PracownikRepository pracownikRepository, ModelMapper modelMapper, OpiekaRepository opiekaRepository, WypozyczenieRepository wypozyczenieRepository, PojazdRepository pojazdRepository) {
        this.pracownikRepository = pracownikRepository;
        mModelMapper = modelMapper;
        mOpiekaRepository = opiekaRepository;
        this.wypozyczenieRepository = wypozyczenieRepository;
        mPojazdRepository = pojazdRepository;
    }

    @Override
    public List<Pracownik> getAllPracownicy() {
        List<Pracownik> pracownicy = new ArrayList<>();
        pracownikRepository.findAll().forEach(pracownicy::add);
        return pracownicy;
    }

    @Override
    public Pracownik updatePracownik(Long pracownikId, PracownikDto pracownikDetails) {
        if (!pracownikRepository.exists(pracownikId)) {
            return null;
        }
        Pracownik pracownik = pracownikRepository.findOne(pracownikId);

        if (pracownikDetails.getDataUrodzenia() != null)
            pracownik.setDataUrodzenia(pracownikDetails.getDataUrodzenia());
        if (pracownikDetails.getImie() != null)
            pracownik.setImie(pracownikDetails.getImie());
        if (pracownikDetails.getNazwisko() != null)
            pracownik.setNazwisko(pracownikDetails.getNazwisko());
        if (pracownikDetails.getPesel() != null)
            pracownik.setPesel(pracownikDetails.getPesel());
        if (pracownikDetails.getRola() != null)
            pracownik.setRola(pracownikDetails.getRola());
        if (pracownikDetails.getStatusZatrudnienia() != null) {


            if (pracownikDetails.getStatusZatrudnienia() == Pracownik.StatusZatrudnienia.NIE_PRACUJE || pracownikDetails.getStatusZatrudnienia() == Pracownik.StatusZatrudnienia.ZWOLNIONY) {

                // USUWANIE WYPOZYCZEN
                List<Wypozyczenie> wypozyczenia = pracownik.getWypozyczenia();
                for (Iterator<Wypozyczenie> i = wypozyczenia.iterator(); i.hasNext(); ) {
                    Wypozyczenie wypozyczenie = i.next();

                    wypozyczenie.getPojazd().getWypozyczenia().remove(wypozyczenie);
                    mPojazdRepository.save(wypozyczenie.getPojazd());

                    wypozyczenieRepository.delete(wypozyczenie);
                    i.remove();
                }

                pracownikRepository.save(pracownik);

                //USUWANIE OPIEK
                if (pracownik.getRola() == Pracownik.Rola.OPIEKUN) {
                    List<Opieka> opieki = pracownik.getOpieki();
                    for (Iterator<Opieka> i = opieki.iterator(); i.hasNext(); ) {
                        Opieka opieka = i.next();
                        opieka.getPojazd().setOpieka(null);
                        mPojazdRepository.save(opieka.getPojazd());

                        mOpiekaRepository.delete(opieka);
                        i.remove();
                    }
                }

                pracownikRepository.save(pracownik);
            }

            pracownik.setStatusZatrudnienia(pracownikDetails.getStatusZatrudnienia());
        }
        pracownikRepository.save(pracownik);
        return pracownik;
    }

    @Override
    public Pracownik createPracownik(PracownikDto pracownikDto) {
        Pracownik pracownik = convertFromDto(pracownikDto);
        pracownik.setWypozyczenia(new ArrayList<>());
        pracownik.setOpieki(new ArrayList<>());
        pracownik.setCzynnosciEksploatacyjne(new ArrayList<>());
        pracownikRepository.save(pracownik);

        return pracownik;
    }

    @Override
    public boolean deletePracownik(Long pracownikId) {
        Pracownik pracownik = pracownikRepository.findOne(pracownikId);
        if (pracownik == null) {
            return false;
        }

        for (Opieka opieka : pracownik.getOpieki()) {
            mOpiekaRepository.delete(opieka);
            Pojazd pojazd = opieka.getPojazd();
            pojazd.setOpieka(null);
            mPojazdRepository.save(pojazd);
            mOpiekaRepository.delete(opieka);
        }
        pracownikRepository.delete(pracownikId);
        return true;
    }

    @Override
    public Pracownik getPracownik(Long pracownikId) {
        Pracownik pracownik = pracownikRepository.findOne(pracownikId);
        if (pracownik == null) {
            return null;
        }
        return pracownik;
    }

    @Override
    public List<Pracownik> getAllOpiekuni() {
        List<Pracownik> opiekuni = new ArrayList<>();
        pracownikRepository.findAll().forEach(opiekuni::add);

        boolean isOpiekunem;
        for (Iterator<Pracownik> i = opiekuni.iterator(); i.hasNext(); ) {
            Pracownik opiekun = i.next();
            isOpiekunem = true;

            if (opiekun.getRola() != Pracownik.Rola.OPIEKUN || opiekun.getStatusZatrudnienia() == Pracownik.StatusZatrudnienia.ZWOLNIONY || opiekun.getStatusZatrudnienia() == Pracownik.StatusZatrudnienia.NIE_PRACUJE)
                isOpiekunem = false;

            if (!isOpiekunem)
                i.remove();
        }
        return opiekuni;
    }

    @Override
    public PracownikDto convertToDto(Pracownik pracownik) {

        return mModelMapper.map(pracownik, PracownikDto.class);
    }

    @Override
    public Pracownik convertFromDto(PracownikDto pracownikDto) {
        return mModelMapper.map(pracownikDto, Pracownik.class);
    }
}
