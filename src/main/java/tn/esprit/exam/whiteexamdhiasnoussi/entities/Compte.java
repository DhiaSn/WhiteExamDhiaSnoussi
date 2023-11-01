package tn.esprit.exam.whiteexamdhiasnoussi.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.exam.whiteexamdhiasnoussi.entities.Enums.TypeCompte;

import java.util.Set;

@Entity

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idCompte;

    TypeCompte type;
    long code;
    double solde;

}
