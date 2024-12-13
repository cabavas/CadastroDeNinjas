package com.example.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    @GetMapping("/listar")
    public String listarMissao() {
        return "Missão listadas com sucesso!";
    }

    @GetMapping("/listarID")
    public String listarMissaoPorId() {
        return "Missão id listada com sucesso!";
    }

    @PostMapping("/criar")
    public String criarMissao() {
        return "Missão criada com sucesso!";
    }

    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missão alterada com sucesso!";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "Missão deletada com sucesso!";
    }
}
