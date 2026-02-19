package ai4se.research.graphrag.service;

import ai4se.research.graphrag.dto.AnalysisResponse;
import ai4se.research.graphrag.dto.RequirementRequest;

public interface KnowledgeService {
    AnalysisResponse analisarRequisitos(RequirementRequest request);
}
