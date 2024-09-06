package diego.basili.demoGestionePrenotazioni.services;

import diego.basili.demoGestionePrenotazioni.entities.Postazione;
import diego.basili.demoGestionePrenotazioni.exceptions.ValidationException;
import diego.basili.demoGestionePrenotazioni.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostazioneServices {
    @Autowired
    private PostazioneRepository postazioneRepository;

    public void savePostazione(Postazione newPostazione) {
        if (newPostazione.getNumeroMaxOccupanti() < 0) throw new ValidationException("Numero occupanti troppo basso");
        postazioneRepository.save(newPostazione);
        System.out.println("Nuovo Edificio " + newPostazione.getPostazione_id() + " salvato con successo!");
    }
}
