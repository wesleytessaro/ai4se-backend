package ai4se.research.graphrag.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequirementRequest {
    
    @NotBlank(message = "Case description cannot be empty")
    @Size(min = 10, max = 5000, message = "Case description must be between 10 and 5000 characters")
    private String requirementText;
    
    private String domain;
    private Integer topK = 5;
}
