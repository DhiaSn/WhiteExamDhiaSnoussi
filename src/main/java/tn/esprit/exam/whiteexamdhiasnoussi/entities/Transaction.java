package tn.esprit.exam.whiteexamdhiasnoussi.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.exam.whiteexamdhiasnoussi.entities.Enums.TypeTransaction;

import java.time.LocalDate;
import java.util.Set;

@Entity

@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = {"idTransaction", "expediteurs", "destinataires"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idTransaction;

    double montant;
    TypeTransaction type;
    LocalDate dateTransaction;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    Compte expediteur;
    @EqualsAndHashCode.Exclude
    @ManyToOne
    Compte destinataire;

}
