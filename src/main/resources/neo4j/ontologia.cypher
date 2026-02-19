// Grafo de conhecimento de exemplo — execute no Neo4j Browser após o docker compose up

MATCH (n) DETACH DELETE n;

// Conceitos
CREATE (desempenho:Conceito {id: 'C-001', nome: 'Desempenho',    categoria: 'Qualidade'})
CREATE (seguranca:Conceito  {id: 'C-002', nome: 'Segurança',      categoria: 'Qualidade'})
CREATE (usabilidade:Conceito {id: 'C-003', nome: 'Usabilidade',  categoria: 'Qualidade'});

// Requisitos
CREATE (r1:Requisito {id: 'REQ-001', texto: 'O sistema deve responder em até 200ms sob carga normal',           fonte: 'backlog'})
CREATE (r2:Requisito {id: 'REQ-002', texto: 'Senhas devem ser armazenadas com bcrypt e custo mínimo 12',         fonte: 'backlog'})
CREATE (r3:Requisito {id: 'REQ-003', texto: 'A interface deve ser totalmente navegável pelo teclado',             fonte: 'backlog'});

// Relacionamentos
CREATE (r1)-[:RELACIONADO_A {score: 0.95}]->(desempenho)
CREATE (r2)-[:RELACIONADO_A {score: 0.98}]->(seguranca)
CREATE (r3)-[:RELACIONADO_A {score: 0.90}]->(usabilidade);

// Índices
CREATE INDEX IF NOT EXISTS FOR (r:Requisito) ON (r.id);
CREATE INDEX IF NOT EXISTS FOR (c:Conceito)  ON (c.nome);
