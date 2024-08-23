CREATE TABLE sessao (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        pauta_id BIGINT,
                        data_abertura DATETIME,
                        data_encerramento DATETIME,
                        FOREIGN KEY (pauta_id) REFERENCES pauta(id)
);
