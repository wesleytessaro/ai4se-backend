# GraphRAG CADE Analyzer

Proof of Concept: teste con hieramientas Qdrant y Neo4j

## Overview

Sistema de análise de casos antitruste combinando:

- **Vector Search** (Qdrant) - Busca semântica de precedentes
- **Knowledge Graphs** (Neo4j) - Raciocínio sobre estrutura de mercado e relacionamentos corporativos

## Teste de la API
```
curl -s -X POST http://localhost:8080/api/analyze \
  -H "Content-Type: application/json" \
  -d '{
  "requirementText": "Como as plantas produzem energia a partir da luz?"
}' | jq '.'

```

## Tech Stack

- Java 21
- Spring Boot 3.3
- Neo4j 5.15
- Qdrant (Vector DB)

