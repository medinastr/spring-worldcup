package com.medinastr.worldcup.rest;

import com.medinastr.worldcup.dao.NationRepository;
import com.medinastr.worldcup.dto.NationDTO;
import com.medinastr.worldcup.entity.Nation;
import com.medinastr.worldcup.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin("*")  // liberar todas as entradas que vierem da máquina
@RequestMapping("/nations")
public class NationRestController {

    private final NationService nationService;

    @Autowired
    public NationRestController(NationService nationService) {
        this.nationService = nationService;
    }

    @GetMapping
    public ResponseEntity<List<NationDTO>> nationsList() {
        List<NationDTO> nations = nationService.getNations();
        return ResponseEntity.status(200).body(nations);
    }

    @PostMapping("/saveNation")
    public ResponseEntity<Nation> addNation(@RequestBody NationDTO nationDTO) {
        Nation dbNation = nationService.save(nationDTO);
        return ResponseEntity.status(201).body(dbNation);
    }

    @PostMapping("/saveNations")
    public ResponseEntity<List<Nation>> saveNationsList(@RequestBody List<NationDTO> nationsDTO) {
        List<Nation> dbNations = nationService.saveNationsList(nationsDTO);
        return ResponseEntity.status(201).body(dbNations);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Nation>> deleteNation(@PathVariable int id) {
        Optional<Nation> nationToDelete = nationService.delete(id);
        return ResponseEntity.status(204).body(nationToDelete);
    }
}
