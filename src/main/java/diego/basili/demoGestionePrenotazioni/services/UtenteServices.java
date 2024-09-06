package diego.basili.demoGestionePrenotazioni.services;

import diego.basili.demoGestionePrenotazioni.entities.Utente;
import diego.basili.demoGestionePrenotazioni.exceptions.ValidationException;
import diego.basili.demoGestionePrenotazioni.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteServices {
    @Autowired
    private UtenteRepository utenteRepository;

    public void save(Utente newUtente) {
        if (newUtente.getUsername().length() < 2) throw new ValidationException("Nome troppo corto");
        utenteRepository.save(newUtente);
        System.out.println("Nuovo Utente " + newUtente.getNome_completo() + " salvato con successo!");
    }
}
