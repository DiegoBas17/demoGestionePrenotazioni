package diego.basili.demoGestionePrenotazioni.services;

import diego.basili.demoGestionePrenotazioni.entities.Postazione;
import diego.basili.demoGestionePrenotazioni.enums.TipoStanza;
import diego.basili.demoGestionePrenotazioni.exceptions.NotFoundException;
import diego.basili.demoGestionePrenotazioni.exceptions.ValidationException;
import diego.basili.demoGestionePrenotazioni.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostazioneServices {
    @Autowired
    private PostazioneRepository postazioneRepository;

    public void save(Postazione newPostazione) {
        if (newPostazione.getNumeroMaxOccupanti() < 0) throw new ValidationException("Numero occupanti troppo basso");
        postazioneRepository.save(newPostazione);
        System.out.println("Nuovo Edificio " + newPostazione.getPostazione_id() + " salvato con successo!");
    }

    public Postazione findById(UUID postazione_id) {
        Postazione postazione = postazioneRepository.findById(postazione_id).orElseThrow(() -> new NotFoundException(postazione_id));
        return postazione;
    }

    public List<Postazione> trovaPostazioniPerTipoECittà(TipoStanza tipoStanza, String città) {
        return postazioneRepository.findByTipoStanzaAndEdificio_Città(tipoStanza, città);
    }

}
