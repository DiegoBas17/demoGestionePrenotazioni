package diego.basili.demoGestionePrenotazioni.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Utente {
    @Id
    @GeneratedValue
    private UUID utente_id;
    private String username;
    private String nome_completo;
    private String email;

    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioni;

    public Utente(String username, String nome_completo, String email) {
        this.username = username;
        this.nome_completo = nome_completo;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "utente_id=" + utente_id +
                ", username='" + username + '\'' +
                ", nome_completo='" + nome_completo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
