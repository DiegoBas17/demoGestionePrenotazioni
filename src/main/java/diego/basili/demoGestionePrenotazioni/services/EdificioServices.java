package diego.basili.demoGestionePrenotazioni.services;

import diego.basili.demoGestionePrenotazioni.entities.Edificio;
import diego.basili.demoGestionePrenotazioni.exceptions.ValidationException;
import diego.basili.demoGestionePrenotazioni.repositories.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdificioServices {
    @Autowired
    private EdificioRepository edificioRepository;

    public void save(Edificio newEdificio) {
        if (newEdificio.getNome().length() < 2) throw new ValidationException("Nome troppo corto");
        edificioRepository.save(newEdificio);
        System.out.println("Nuovo Edificio " + newEdificio.getNome() + " salvato con successo!");
    }
}
