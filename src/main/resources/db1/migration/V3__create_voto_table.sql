CREATE TABLE voto (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      associado_id VARCHAR(255) NOT NULL,
                      pauta_id BIGINT NOT NULL,
                      voto ENUM('Sim', 'Não') NOT NULL,
                      FOREIGN KEY (pauta_id) REFERENCES pauta(id)
);
