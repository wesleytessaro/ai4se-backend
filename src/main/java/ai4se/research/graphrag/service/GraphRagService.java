package ai4se.research.graphrag.service;

import ai4se.research.graphrag.dto.AnalysisResponse;
import ai4se.research.graphrag.dto.RequirementRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GraphRagService implements KnowledgeService {
    
    @Override
    public AnalysisResponse analisarRequisitos(RequirementRequest request) {
        
        List<AnalysisResponse.SimilarRequirement> vectorResults = performVectorSearch(request);
        List<AnalysisResponse.RelatedConcept> graphResults = performGraphQuery(request);
        
        String reasoning = generateReasoning(vectorResults, graphResults);
        Double confidenceScore = calculateConfidence(vectorResults, graphResults);
        
        return AnalysisResponse.builder()
                .originalRequirement(request.getRequirementText())
                .analyzedAt(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME))
                .vectorSearchResults(vectorResults)
                .graphQueryResults(graphResults)
                .reasoning(reasoning)
                .confidenceScore(confidenceScore)
                .build();
    }
    
    private List<AnalysisResponse.SimilarRequirement> performVectorSearch(RequirementRequest request) {
        List<AnalysisResponse.SimilarRequirement> results = new ArrayList<>();

        results.add(AnalysisResponse.SimilarRequirement.builder()
                .requirementId("REQ-001")
                .text("O sistema deve responder em até 200ms sob carga normal")
                .similarityScore(0.94)
                .source("backlog")
                .build());

        results.add(AnalysisResponse.SimilarRequirement.builder()
                .requirementId("REQ-002")
                .text("Os endpoints da API devem retornar resposta em menos de 500ms no percentil 99")
                .similarityScore(0.81)
                .source("backlog")
                .build());

        return results;
    }

    private List<AnalysisResponse.RelatedConcept> performGraphQuery(RequirementRequest request) {
        List<AnalysisResponse.RelatedConcept> results = new ArrayList<>();

        Map<String, Object> props = new HashMap<>();
        props.put("categoria", "Qualidade");

        results.add(AnalysisResponse.RelatedConcept.builder()
                .conceptId("C-001")
                .conceptName("Desempenho")
                .relationshipType("RELACIONADO_A")
                .properties(props)
                .build());

        return results;
    }

    private String generateReasoning(
            List<AnalysisResponse.SimilarRequirement> vectorResults,
            List<AnalysisResponse.RelatedConcept> graphResults) {

        String topConcept = graphResults.isEmpty() ? "não identificado" : graphResults.get(0).getConceptName();
        double topScore   = vectorResults.isEmpty() ? 0 : vectorResults.get(0).getSimilarityScore();

        return String.format(
                "Encontrados %d requisitos similares (melhor correspondência: %.0f%%). " +
                "Grafo de conhecimento associado ao conceito '%s'.",
                vectorResults.size(), topScore * 100, topConcept);
    }
    
    private Double calculateConfidence(
            List<AnalysisResponse.SimilarRequirement> vectorResults,
            List<AnalysisResponse.RelatedConcept> graphResults) {
        
        if (vectorResults.isEmpty() || graphResults.isEmpty()) {
            return 0.5;
        }
        
        double vectorScore = vectorResults.get(0).getSimilarityScore();
        double graphScore = Math.min(graphResults.size() / 10.0, 1.0);
        return (vectorScore + graphScore) / 2.0;
    }
}
