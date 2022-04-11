package my.local.project.service;

import my.local.project.model.Abonement;
import my.local.project.model.Client;
import my.local.project.repository.AbonementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AbonementService {
    private final AbonementRepository abonementRepository;;

    public AbonementService(AbonementRepository abonementRepository) {
        this.abonementRepository = abonementRepository;
    }

    public List<Abonement> findAllAbonements(){
        return abonementRepository.findAll();
    }
    public Abonement findAbonementById(Long ID) {
        return abonementRepository.getById(ID);
    }
    public Abonement findAbonementByClient(Client client) {
        return null;
    }

    public Abonement saveAbonement(Abonement abonement){
        return abonementRepository.save(abonement);
    }

    public void deleteAbonement(Abonement abonement){
        abonementRepository.delete(abonement);
    }

    public void deleteAbonement(Long ID) {
        abonementRepository.deleteById(ID);
    }
}
