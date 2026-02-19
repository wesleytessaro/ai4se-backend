MATCH (n) DETACH DELETE n;

CREATE (fotossintese:Conceito {id: 'C-001', nome: 'Fotossíntese', categoria: 'Biologia'})
CREATE (polinizacao:Conceito  {id: 'C-002', nome: 'Polinização',  categoria: 'Biologia'});

CREATE (c1:Chunk {id: 'CHK-001', texto: 'As plantas absorvem luz solar e CO2 para produzir oxigênio e glicose.', fonte: 'natureza'})
CREATE (c2:Chunk {id: 'CHK-002', texto: 'As abelhas transportam pólen entre flores, permitindo a reprodução das plantas.', fonte: 'natureza'});

CREATE (c1)-[:RELACIONADO_A {score: 0.97}]->(fotossintese)
CREATE (c2)-[:RELACIONADO_A {score: 0.95}]->(polinizacao);

CREATE INDEX IF NOT EXISTS FOR (c:Chunk)   ON (c.id);
CREATE INDEX IF NOT EXISTS FOR (c:Conceito) ON (c.nome);
