package diego.basili.demoGestionePrenotazioni.entities;

import diego.basili.demoGestionePrenotazioni.enums.TipoStanza;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Postazione {
    @Id
    @GeneratedValue
    private UUID postazione_id;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoStanza tipoStanza;
    private Long numeroMaxOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;
    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;

    public Postazione(String descrizione, TipoStanza tipoStanza, Long numeroMaxOccupanti, Edificio edificio) {
        this.descrizione = descrizione;
        this.tipoStanza = tipoStanza;
        this.numeroMaxOccupanti = numeroMaxOccupanti;
        this.edificio = edificio;
    }

    @Override
    public String toString() {
        return "Postazione{" +
                "postazione_id=" + postazione_id +
                ", descrizione='" + descrizione + '\'' +
                ", tipoStanza=" + tipoStanza +
                ", numeroMaxOccupanti=" + numeroMaxOccupanti +
                ", edificio=" + edificio +
                '}';
    }
}
