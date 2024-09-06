package diego.basili.demoGestionePrenotazioni.services;

import diego.basili.demoGestionePrenotazioni.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneServices {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
}
