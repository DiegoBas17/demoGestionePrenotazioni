package diego.basili.demoGestionePrenotazioni.services;

import diego.basili.demoGestionePrenotazioni.entities.Prenotazione;
import diego.basili.demoGestionePrenotazioni.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneServices {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public void save(Prenotazione newPrenotazione) {
        List<Prenotazione> prenotazioni = prenotazioneRepository.findByPostazioneAndData(newPrenotazione.getPostazione(), newPrenotazione.getData());
        if (prenotazioni.isEmpty()) {
            prenotazioneRepository.save(newPrenotazione);
            System.out.println("La prenotazione " + newPrenotazione.getPrenotazione_id() + " salvata con successo!");
        } else {
            System.out.println("Esiste gia una prenotazione nella data inserita!");
        }
    }
}
