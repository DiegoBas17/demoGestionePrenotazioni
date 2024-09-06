package diego.basili.demoGestionePrenotazioni;

import diego.basili.demoGestionePrenotazioni.entities.Edificio;
import diego.basili.demoGestionePrenotazioni.entities.Postazione;
import diego.basili.demoGestionePrenotazioni.entities.Prenotazione;
import diego.basili.demoGestionePrenotazioni.entities.Utente;
import diego.basili.demoGestionePrenotazioni.enums.TipoStanza;
import diego.basili.demoGestionePrenotazioni.services.EdificioServices;
import diego.basili.demoGestionePrenotazioni.services.PostazioneServices;
import diego.basili.demoGestionePrenotazioni.services.PrenotazioneServices;
import diego.basili.demoGestionePrenotazioni.services.UtenteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    private EdificioServices edificioServices;
    @Autowired
    private PostazioneServices postazioneServices;
    @Autowired
    private UtenteServices utenteServices;
    @Autowired
    private PrenotazioneServices prenotazioneServices;
    @Autowired
    private AnnotationConfigApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {
        //AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoGestionePrenotazioniApplication.class);
        Utente gabriel = new Utente("gabriel27", "gabriel azamfiri", "gabriel@gmail.com");
        Utente arianna = new Utente("ary", "arianna loreti", "arianna@gmail.com");
        Utente eddy = new Utente("eddy", "eddy turpo", "eddy@gmail.com");
        try {
            Edificio edificio1 = ctx.getBean("edificio1", Edificio.class);
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
            postazioneServices.save(postazione6);
            utenteServices.save(gabriel);
            utenteServices.save(arianna);
            utenteServices.save(eddy);
            Postazione postazione1FromDB = postazioneServices.findById(UUID.fromString("0b4c2229-ce12-468b-8382-d58956b60480"));
            Postazione postazione2FromDB = postazioneServices.findById(UUID.fromString("22c25a63-52a8-45fd-bd1b-87daf5d9efdb"));
            Postazione postazione3FromDB = postazioneServices.findById(UUID.fromString("4da4f8c8-962d-40e3-8ce1-ba8d0a8a0afd"));
            Postazione postazione4FromDB = postazioneServices.findById(UUID.fromString("70a2bb61-e286-4729-a42d-2b4cbd22d8f4"));
            Postazione postazione5FromDB = postazioneServices.findById(UUID.fromString("cc561a72-f0c8-4d65-bc70-669d88d16ede"));
            Postazione postazione6FromDB = postazioneServices.findById(UUID.fromString("dd4b794e-3730-4b44-a8ed-97518afc6b80"));
            Utente gabrielFromDB = utenteServices.findById(UUID.fromString("3050c850-9fef-48c7-8b86-ce942a59a101"));
            Utente ariannaFromDB = utenteServices.findById(UUID.fromString("cb1b158d-1da5-4955-88a5-6b12985be597"));
            Utente eddyFromDB = utenteServices.findById(UUID.fromString("cba61f9d-74df-48d5-a767-c1345b4bda1e"));
            Prenotazione prenotazione1 = new Prenotazione(LocalDate.of(2024, 9, 10), postazione1FromDB, gabrielFromDB);
            Prenotazione prenotazione2 = new Prenotazione(LocalDate.of(2024, 9, 10), postazione1FromDB, ariannaFromDB);
            /*prenotazioneServices.save(prenotazione1);
            prenotazioneServices.save(prenotazione2);*/
            TipoStanza tipoStanza = TipoStanza.PRIVATO;
            String città = "milano";
            List<Postazione> postazioni = postazioneServices.trovaPostazioniPerTipoECittà(tipoStanza, città);
            postazioni.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }


    }
}
