package com.project.sequense.controller;


import com.project.sequense.Service.SequenceService;
import com.project.sequense.model.SequenceRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sequence")
public class SequenceController {
    private final SequenceService sequenceService;

    public SequenceController(SequenceService sequenceService) {
        this.sequenceService = sequenceService;
    }

    @PostMapping("/generate")  // Accepte uniquement POST
    public ResponseEntity<String> generateSequenceDiagram(@RequestBody SequenceRequest request) {
        try {
            String svg = sequenceService.generateDiagram(request); // Génération du diagramme
            return ResponseEntity.ok(svg);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erreur : " + e.getMessage());
        }
    }
}
