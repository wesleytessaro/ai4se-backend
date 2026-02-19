#!/bin/bash
# Teste rápido — sh test-api.sh

echo "=== saúde ==="
curl -s http://localhost:8080/actuator/health | jq '.status'

echo -e "\n=== analisar ==="
curl -s -X POST http://localhost:8080/api/analyze \
  -H "Content-Type: application/json" \
  -d '{"requirementText": "O sistema deve responder em até 200ms sob carga normal"}' | jq '.'
