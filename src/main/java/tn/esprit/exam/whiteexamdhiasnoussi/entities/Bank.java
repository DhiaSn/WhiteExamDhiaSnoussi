package tn.esprit.exam.whiteexamdhiasnoussi.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity

@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = {"idBank", "compte"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idBank;

    String nom;
    String agence;
    String address;

    @EqualsAndHashCode.Exclude
    @OneToMany
    Set<Compte> comptes;

}
