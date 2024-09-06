package diego.basili.demoGestionePrenotazioni.repositories;

import diego.basili.demoGestionePrenotazioni.entities.Postazione;
import diego.basili.demoGestionePrenotazioni.entities.Prenotazione;
import diego.basili.demoGestionePrenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {

    List<Prenotazione> findByPostazioneAndData(Postazione postazione, LocalDate data);

    List<Prenotazione> findByUtenteAndData(Utente utente, LocalDate data);
}

