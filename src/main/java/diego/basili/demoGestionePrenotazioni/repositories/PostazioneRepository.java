package diego.basili.demoGestionePrenotazioni.repositories;

import diego.basili.demoGestionePrenotazioni.entities.Postazione;
import diego.basili.demoGestionePrenotazioni.enums.TipoStanza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, UUID> {

    List<Postazione> findByTipoStanzaAndEdificio_Città(TipoStanza tipoStanza, String città);
}
