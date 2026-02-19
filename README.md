# GraphRAG CADE Analyzer

Proof of Concept: Hybrid Vector + Graph Retrieval for Competition Law Analysis

## Overview

Sistema de análise de casos antitruste combinando:

- **Vector Search** (Qdrant) - Busca semântica de precedentes
- **Knowledge Graphs** (Neo4j) - Raciocínio sobre estrutura de mercado e relacionamentos corporativos

## Context

Desenvolvido para equipes de análise do CADE (Conselho Administrativo de Defesa Econômica).

**Problema:** Analistas precisam buscar precedentes similares em milhares de decisões e mapear estruturas complexas de mercado.

**Solução:** GraphRAG combina busca semântica com grafos de conhecimento para recuperar casos conceitualmente similares e entender relações entre empresas e mercados.

## API

### POST `/api/analyze`

Analisa um caso antitruste usando GraphRAG.

**Request:**
```json
{
  "requirementText": "Descrição do caso",
  "domain": "telecomunicacoes",
  "topK": 5
}
```

**Domínios suportados:**
- `telecomunicacoes` - Operadoras, infraestrutura, banda larga
- `energia` - Geração, distribuição, comercialização
- `financeiro` - Bancos, fintechs, meios de pagamento
- `varejo` - Comércio, distribuição, plataformas
- `saude` - Hospitais, planos de saúde, farmacêuticas
- `transporte` - Aéreo, rodoviário, aplicativos

## Quick Start

Execute a aplicação:
```bash
./gradlew bootRun
```

Teste a API:
```bash
sh test-api.sh
```

## Use Cases

### Atos de Concentração
Buscar fusões/aquisições similares por mercado e estrutura, identificar remédios aplicados em casos análogos, mapear participações societárias.

### Processos Administrativos
Recuperar investigações de cartel e abuso de posição dominante, analisar padrões de comportamento.

### Pareceres Técnicos
Reutilizar análises econômicas de definição de mercado relevante e metodologias de cálculo de participação de mercado.

## Tech Stack

- Java 21
- Spring Boot 3.3
- Neo4j 5.15
- Qdrant (Vector DB)

