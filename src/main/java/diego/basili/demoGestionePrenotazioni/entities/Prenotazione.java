package diego.basili.demoGestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Prenotazione {
    @Id
    @GeneratedValue
    private UUID prenotazione_id;
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    public Prenotazione(LocalDate data, Postazione postazione, Utente utente) {
        this.data = data;
        this.postazione = postazione;
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "prenotazione_id=" + prenotazione_id +
                ", data=" + data +
                ", postazione=" + postazione.getPostazione_id() +
                ", utente=" + utente.getNome_completo() +
                '}';
    }
}
