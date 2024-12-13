package com.example.CadastroDeNinjas.Ninjas;

import com.example.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_ninjas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;
    private int idade;

    @ManyToOne
    @JoinColumn(name = "missao_id")
    private MissoesModel missoes;

}
