package com.example.CadastroDeNinjas.Ninjas;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Boas Vindas";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    // Mostrar todos ninja (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaModel>> listarNinjas() {
        return ResponseEntity.ok(ninjaService.listarNinjas());
    }

    // Mostrar ninja especifico (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<NinjaModel> listarNinjasPorId(@PathVariable Long id) {
        if(ninjaService.listarNinjasPorId(id) != null) {
            return ResponseEntity.ok(ninjaService.listarNinjasPorId(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Alterar dados do ninja (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<NinjaModel> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaModel ninjaAtualizado) {
        if(ninjaService.listarNinjasPorId(id) != null) {
            return ResponseEntity.ok().body(ninjaService.atualizarNinja(id, ninjaAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
        if(ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.deletarNinjaPorID(id);
            return ResponseEntity.ok().body("Ninja deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja não foi encontrado");
        }
    }
}
