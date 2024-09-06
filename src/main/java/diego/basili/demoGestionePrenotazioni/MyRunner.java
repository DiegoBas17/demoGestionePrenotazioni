package diego.basili.demoGestionePrenotazioni;

import diego.basili.demoGestionePrenotazioni.entities.Utente;
import diego.basili.demoGestionePrenotazioni.services.EdificioServices;
import diego.basili.demoGestionePrenotazioni.services.PostazioneServices;
import diego.basili.demoGestionePrenotazioni.services.UtenteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    private EdificioServices edificioServices;
    @Autowired
    private PostazioneServices postazioneServices;
    @Autowired
    private UtenteServices utenteServices;

    @Override
    public void run(String... args) throws Exception {
        //AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoGestionePrenotazioniApplication.class);
        Utente gabriel = new Utente("gabriel27", "gabriel azamfiri", "gabriel@gmail.com");
        Utente arianna = new Utente("ary", "arianna loreti", "arianna@gmail.com");
        Utente eddy = new Utente("eddy", "eddy turpo", "eddy@gmail.com");
        try {
            /*Edificio edificio1 = ctx.getBean("edificio1", Edificio.class);
            Edificio edificio2 = ctx.getBean("edificio2", Edificio.class);
            Postazione postazione1 = ctx.getBean("postazionePrivata", Postazione.class);
            Postazione postazione2 = ctx.getBean("postazioneOpenSpace", Postazione.class);
            Postazione postazione3 = ctx.getBean("postazioneSalaRiunioni", Postazione.class);
            Postazione postazione4 = ctx.getBean("postazionePrivata2", Postazione.class);
            Postazione postazione5 = ctx.getBean("postazioneOpenSpace2", Postazione.class);
            Postazione postazione6 = ctx.getBean("postazioneSalaRiunioni2", Postazione.class);
            edificioServices.save(edificio1);
            edificioServices.save(edificio2);
            postazioneServices.save(postazione1);
            postazioneServices.save(postazione2);
            postazioneServices.save(postazione3);
            postazioneServices.save(postazione4);
            postazioneServices.save(postazione5);
            postazioneServices.save(postazione6);*/
            /*utenteServices.save(gabriel);
            utenteServices.save(arianna);
            utenteServices.save(eddy);*/
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        
    }
}
