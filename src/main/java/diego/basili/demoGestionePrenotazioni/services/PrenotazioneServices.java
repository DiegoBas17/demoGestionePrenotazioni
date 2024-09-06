package diego.basili.demoGestionePrenotazioni.services;

import diego.basili.demoGestionePrenotazioni.entities.Prenotazione;
import diego.basili.demoGestionePrenotazioni.exceptions.NotFoundException;
import diego.basili.demoGestionePrenotazioni.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PrenotazioneServices {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public void save(Prenotazione newPrenotazione) {
        List<Prenotazione> prenotazioni = prenotazioneRepository.findByPostazioneAndData(newPrenotazione.getPostazione(), newPrenotazione.getData());
        List<Prenotazione> utenteAndData = prenotazioneRepository.findByUtenteAndData(newPrenotazione.getUtente(), newPrenotazione.getData());
        if (prenotazioni.isEmpty()) {
            if (utenteAndData.isEmpty()) {
                prenotazioneRepository.save(newPrenotazione);
                System.out.println("La prenotazione " + newPrenotazione.getPrenotazione_id() + " salvata con successo!");
            } else {
                System.out.println("questo utente ha gia un altra prenotazione oggi!");
            }
        } else {
            System.out.println("Esiste gia una prenotazione nella data inserita!");
        }
    }

    public List<Prenotazione> getAll() {
        return prenotazioneRepository.findAll();
    }

    public Prenotazione findById(UUID id) {
        return prenotazioneRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(UUID id) {
        Prenotazione prenotazione = this.findById(id);
        prenotazioneRepository.delete(prenotazione);
    }
}
