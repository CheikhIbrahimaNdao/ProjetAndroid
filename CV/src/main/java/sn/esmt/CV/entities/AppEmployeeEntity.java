package sn.esmt.CV.entities;

import javax.persistence.Entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "appemployees")
public class AppEmployeeEntity {
    @Id
    @Column(length = 150,nullable = false)
    private String prenom;
    @Column(length = 100,nullable = false)
    private String nom;
    @Column(nullable = false)
    private int age;
    @Column(length = 200,nullable = false,unique = true)
    private String email;
    @Column(length = 200,nullable = false)
    private String adresse;
    @Column(length = 100,nullable = false,unique = true)
    private String telephone;
    @Column(length = 200,nullable = false)
    private String specialite;
    @Column(length = 200,nullable = false)
    private String niveauEtude;
    @Column(nullable = false)
    private int experienceProfessionnelle;
}
