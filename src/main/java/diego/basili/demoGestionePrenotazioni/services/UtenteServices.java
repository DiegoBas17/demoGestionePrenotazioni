package diego.basili.demoGestionePrenotazioni.services;

import diego.basili.demoGestionePrenotazioni.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteServices {
    @Autowired
    private UtenteRepository utenteRepository;
}
