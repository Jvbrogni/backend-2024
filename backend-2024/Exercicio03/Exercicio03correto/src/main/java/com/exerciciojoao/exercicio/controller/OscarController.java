package com.exerciciojoao.exercicio.controller;

import com.exerciciojoao.exercicio.dto.IndicacaoAtorDto;
import com.exerciciojoao.exercicio.dto.IndicacaoFilmeDto;
import com.exerciciojoao.exercicio.service.OscarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oscar")
public class OscarController {

    private final OscarService oscarService;

    public OscarController(OscarService oscarService) {
        this.oscarService = oscarService;
    }

    @PostMapping("/adicionar-indicacao-ator")
    public ResponseEntity adicionarIndicacaoAtor(@RequestBody IndicacaoAtorDto indicacao) {
        oscarService.adicionarIndicacaoAtor(indicacao);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/adicionar-indicacao-filme")
    public ResponseEntity adicionarIndicacaoFilme(@RequestBody IndicacaoFilmeDto indicacao) {
        oscarService.adicionarIndicacaoFilme(indicacao);
        return ResponseEntity.ok().build();
    }
}