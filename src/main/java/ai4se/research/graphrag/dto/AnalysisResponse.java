package ai4se.research.graphrag.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class AnalysisResponse {
    
    private String originalRequirement;
    private String analyzedAt;
    private List<SimilarRequirement> vectorSearchResults;
    private List<RelatedConcept> graphQueryResults;
    private String reasoning;
    private Double confidenceScore;
    
    @Data
    @Builder
    public static class SimilarRequirement {
        private String requirementId;
        private String text;
        private Double similarityScore;
        private String source;
    }
    
    @Data
    @Builder
    public static class RelatedConcept {
        private String conceptId;
        private String conceptName;
        private String relationshipType;
        private Map<String, Object> properties;
    }
}
