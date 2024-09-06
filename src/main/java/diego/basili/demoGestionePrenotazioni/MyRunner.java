package diego.basili.demoGestionePrenotazioni;

import diego.basili.demoGestionePrenotazioni.entities.Edificio;
import diego.basili.demoGestionePrenotazioni.repositories.EdificioRepository;
import diego.basili.demoGestionePrenotazioni.services.EdificioServices;
import diego.basili.demoGestionePrenotazioni.services.PostazioneServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    private EdificioServices edificioServices;
    @Autowired
    private PostazioneServices postazioneServices;
    @Autowired
    private EdificioRepository edificioRepository;

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoGestionePrenotazioniApplication.class);
        try {
            Edificio edificio1 = new Edificio("Edificio1", "via roma 10", "milano");
            Edificio edificio2 = new Edificio("Edificio2", "via roma 10", "milano");
            edificioRepository.save(edificio1);
            edificioRepository.save(edificio2);
            /*Postazione postazionePrivata = new Postazione("locazione ottima per un ufficio", TipoStanza.PRIVATO, 1L, edificio1);
            Postazione postazioneOpenSpace = new Postazione("locazione ottima per gestire piu scrivanie", TipoStanza.OPENSPACE, 20L, edificio1);
            Postazione postazioneSalaRiunioni = new Postazione("locazione ottima per riunioni o meeting", TipoStanza.SALA_RIUNIONI, 8L, edificio1);
            Postazione postazionePrivata2 = new Postazione("locazione ottima per un ufficio", TipoStanza.PRIVATO, 1L, edificio2);
            Postazione postazioneOpenSpace2 = new Postazione("locazione ottima per gestire piu scrivanie", TipoStanza.OPENSPACE, 20L, edificio2);
            Postazione postazioneSalaRiunioni2 = new Postazione("locazione ottima per riunioni o meeting", TipoStanza.SALA_RIUNIONI, 8L, edificio2);

            postazioneServices.save(postazionePrivata);
            postazioneServices.save(postazioneOpenSpace);
            postazioneServices.save(postazioneSalaRiunioni);
            postazioneServices.save(postazionePrivata2);
            postazioneServices.save(postazioneOpenSpace2);
            postazioneServices.save(postazioneSalaRiunioni2);*/
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
