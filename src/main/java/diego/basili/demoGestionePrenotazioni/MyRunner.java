package diego.basili.demoGestionePrenotazioni;

import diego.basili.demoGestionePrenotazioni.entities.Edificio;
import diego.basili.demoGestionePrenotazioni.entities.Postazione;
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

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoGestionePrenotazioniApplication.class);
        try {
            Edificio edificio1 = ctx.getBean("edificio1", Edificio.class);
            Edificio edificio2 = ctx.getBean("edificio2", Edificio.class);
            Postazione postazione1 = ctx.getBean("postazionePrivata", Postazione.class);
            Postazione postazione2 = ctx.getBean("postazioneOpenSpace", Postazione.class);
            Postazione postazione3 = ctx.getBean("postazioneSalaRiunioni", Postazione.class);
            Postazione postazione4 = ctx.getBean("postazionePrivata2", Postazione.class);
            Postazione postazione5 = ctx.getBean("postazioneOpenSpace2", Postazione.class);
            Postazione postazione6 = ctx.getBean("postazioneSalaRiunioni2", Postazione.class);
            edificioServices.saveEdificio(edificio1);
            edificioServices.saveEdificio(edificio2);
            postazioneServices.savePostazione(postazione1);
            postazioneServices.savePostazione(postazione2);
            postazioneServices.savePostazione(postazione3);
            postazioneServices.savePostazione(postazione4);
            postazioneServices.savePostazione(postazione5);
            postazioneServices.savePostazione(postazione6);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
