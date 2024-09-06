package diego.basili.demoGestionePrenotazioni;

import diego.basili.demoGestionePrenotazioni.entities.Edificio;
import diego.basili.demoGestionePrenotazioni.entities.Postazione;
import diego.basili.demoGestionePrenotazioni.enums.TipoStanza;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
public class MenuConfig {

    @Bean
    public Edificio edificio1() {
        return new Edificio("Edificio1", "via roma 10", "milano");
    }

    @Bean
    public Edificio edificio2() {
        return new Edificio("Edificio2", "via roma 10", "milano");
    }

    @Bean
    public Postazione postazionePrivata() {
        return new Postazione("locazione ottima per un ufficio", TipoStanza.PRIVATO, 1L, edificio1());
    }

    @Bean
    public Postazione postazioneOpenSpace() {
        return new Postazione("locazione ottima per gestire piu scrivanie", TipoStanza.OPENSPACE, 20L, edificio1());
    }

    @Bean
    public Postazione postazioneSalaRiunioni() {
        return new Postazione("locazione ottima per riunioni o meeting", TipoStanza.SALA_RIUNIONI, 8L, edificio1());
    }

    @Bean
    public Postazione postazionePrivata2() {
        return new Postazione("locazione ottima per un ufficio", TipoStanza.PRIVATO, 1L, edificio2());
    }

    @Bean
    public Postazione postazioneOpenSpace2() {
        return new Postazione("locazione ottima per gestire piu scrivanie", TipoStanza.OPENSPACE, 20L, edificio2());
    }

    @Bean
    public Postazione postazioneSalaRiunioni2() {
        return new Postazione("locazione ottima per riunioni o meeting", TipoStanza.SALA_RIUNIONI, 8L, edificio2());
    }
}
