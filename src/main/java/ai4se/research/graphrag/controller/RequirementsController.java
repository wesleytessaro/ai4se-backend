package ai4se.research.graphrag.controller;

import ai4se.research.graphrag.dto.AnalysisResponse;
import ai4se.research.graphrag.dto.RequirementRequest;
import ai4se.research.graphrag.service.KnowledgeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RequirementsController {
    
    private final KnowledgeService knowledgeService;
    
    @PostMapping("/analisar")
    public ResponseEntity<AnalysisResponse> analyzeRequirement(
            @Valid @RequestBody RequirementRequest request) {
        AnalysisResponse response = knowledgeService.analisarRequisitos(request);      
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Works!!");
    }
}
