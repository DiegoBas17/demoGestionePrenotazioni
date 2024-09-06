package diego.basili.demoGestionePrenotazioni.repositories;

import diego.basili.demoGestionePrenotazioni.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, UUID> {

    List<Edificio> findByCittà(String città);
    
    boolean existsByNome(String nome);
}
