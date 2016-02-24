INSERT INTO sinaisprod.om (omid, indicativo_naval, omnome, codunidmar, endtelegrafico, situacao) VALUES
  (2, "CPMM", "CENTRO DE PERÍCIAS MÉDICAS DA MARINHA", "65200", "PERMED", "1"),
  (1, "DSM", "DIRETORIA DE SAÚDE DA MARINHA", "65100", "DSAUDE", "1"),
  (3, "COM1ºDN", "COMANDO DO 1º DISTRITO NAVAL", "65000", "PRIDIS", "1"),
  (4, "HCM", "HOSPITAL CENTRAL DA MARINHA", "65300", "HOSCEN", "1");
  
INSERT INTO sinaisprod.junta (juntaid, ampid, omid, nome, nome_tis, num_dias_pendencia, possui_secretaria, possui_areaexames, inativa) VALUES
  (1, 1, 2, "JUNTA SUPERIOR DE SAUDE", "JSS", 0, 1, 1, false),
  (2, 2, 2, "JUNTA SUPERIOR DE SA�DE (ATIVIDADES ESPECIAIS)", "JSS(AE)", 0, 1, 1, false),
  (4, 4, 2, "JUNTA SUPERIOR DE ATIVIDADES ESPECIAIS", "JSAE/CPMM", 0, 1, 1, false),
  (3, 3, 2, "JUNTA SUPERIOR DISTRITAL", "JSD/CPMM", 0, 1, 1, false),
  (5, 5, 2, "JUNTA REGULAR DE SAÚDE I", "JRS1/CPMM", 0, 1, 1, false),
  (6, 5, 2, "JUNTA REGULASR DE SAÚDE II", "JRS2/CPMM", 0, 1, 1, false),
  (8, 7, 4, "MÉDICO PERITO QUALIFICADO JOSÉ� SILVA / HCM", "MPIQ JOS� SILVA/HCM", 0, 1, 1, false),
  (7, 6, 4, "MÉDICO PERITO JO�O BASTOS / HCM", "MPI JO�O BASTOS/HCM", 0, 1, 1, false);
  
INSERT INTO sinaisprod.finalidade (finalidadeid, nome, descricao_tis, status) VALUES
  (1, "VDF - MILITAR", "VERIFICAÇÃO DE DEFICIÊNCIA FUNCIONAL", "1"),
  (3, "TI - MILITAR", "TÉRMINO DE INCAPACIDADE", "1"),
  (2, "TR - MILITAR", "TÉRMINO DE RESTRICÕES", "1"),
  (4, "CONTROLE TRIENAL", "CONTROLE TRIENAL", "1");

INSERT INTO sinaisprod.grupo (grupoid, nome, principal) VALUES
  (1, "CONTROLES", true),
  (2, "CONTROLE COM TÉRMINOS", false),
  (3, "VERIFICAÇÕES & TÉRMINOS", true);
  
INSERT INTO sinaisprod.finalidadeexclusiva (grupoid, finalidadeid, ordem) VALUES
  (2, 1, 1),
  (2, 3, 3),
  (2, 2, 2);
  
INSERT INTO sinaisprod.finalidaderegra (finalidaderegraid, tipomilitar, tipo, sexo, inifaixa, fimfaixa, inidelimitador, fimdelimitador, finalidadeid) VALUES
  (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 4),
  (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1),
  (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2),
  (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 3);

INSERT INTO laudos.tb_situacao (id_situacao, nm_situacao) VALUES
  (1, "Apto para o SAM"),
  (2, "Apto para o SMV"),
  (3, "Apto para o SPG"),
  (4, "Apto com restrições"),
  (5, "Incapaz temporariamente"),
  (6, "Incapaz definitivamente"),
  (7, "Incapaz B1");

INSERT INTO laudos.tb_conclusao (id_conclusao, ds_conclusao) VALUES
  (1, "Apto"),
  (2, "Inapto"),
  (3, "Enquadra"),
  (4, "Não enquadra"),
  (5, "Incapaz");
  
INSERT INTO sinaisprod.paciente (pacienteid, pacnome, pacnip, pacendereco, paccomplemento, pacbairro, paccep, paccidade, pacestado, pacidentidade, pacorgao, pacdata_nascimento, pacanoingresso, omid) VALUES
  (1, "VICTOR BEZERRA ALENCAR", "09051872", "RUA SANTA CLARA, 142", "APTO 403", "COPACABANA", "22041012", "RIO DE JANEIRO", "RJ", "8011222", "MB", "1983-11-21 00:00:00", 2009, 1),
  (2, "RODRIGO RUFINO SOUSA", "56389145", "RUA SANTA CLARA, 142", "APTO 403", "COPACABANA", "22041012", "RIO DE JANEIRO", "RJ", "8011221", "MB", "1983-11-21 00:00:00", 2009, 1),
  (3, "JOS� ARRUDA PEREIRA", "05187209", "RUA SANTA CLARA, 142", "APTO 403", "COPACABANA", "22041012", "RIO DE JANEIRO", "RJ", "8011220", "MB", "1983-11-21 00:00:00", 2010, 1),
  (4, "FRANCISCO BICALHO JUNIOR", "18720905", "RUA SANTA CLARA, 142", "APTO 403", "COPACABANA", "22041012", "RIO DE JANEIRO", "RJ", "8011229", "MB", "1983-11-21 00:00:00", 2011, 1),
  (5, "TALES AUGUSTO SILVA", "72090518", "RUA SANTA CLARA, 142", "APTO 403", "COPACABANA", "22041012", "RIO DE JANEIRO", "RJ", "8011210", "MB", "1983-11-21 00:00:00", 1990, 2),
  (6, "AMANDA SANTOS LIMA", "20905187", "RUA SANTA CLARA, 142", "APTO 403", "COPACABANA", "22041012", "RIO DE JANEIRO", "RJ", "8011211", "MB", "1983-11-21 00:00:00", 1997, 2),
  (7, "NAYARA DA SILVA SANTOS", "05361827", "RUA SANTA CLARA, 142", "APTO 403", "COPACABANA", "22041012", "RIO DE JANEIRO", "RJ", "8011212", "MB", "1983-11-21 00:00:00", 2013, 2),
  (8, "ALINE ALENCAR DE SOUZA", "53618270", "RUA SANTA CLARA, 142", "APTO 403", "COPACABANA", "22041012", "RIO DE JANEIRO", "RJ", "8011213", "MB", "1983-11-21 00:00:00", 2013, 3),
  (9, "DÉBORA REIS LIMA", "36182705", "RUA SANTA CLARA, 142", "APTO 403", "COPACABANA", "22041012", "RIO DE JANEIRO", "RJ", "8011214", "MB", "1983-11-21 00:00:00", 2012, 3),
  (10, "JULIANA CARTAXO PEDROSA", "61827053", "RUA SANTA CLARA, 142", "APTO 403", "COPACABANA", "22041012", "RIO DE JANEIRO", "RJ", "8011215", "MB", "1983-11-21 00:00:00", 2005, 3);

  
INSERT INTO sinaisprod.inspecao (inspecaoid, pacienteid, omid, status_inspecao, data_laudo) VALUES
  (1, 1, 1, 7, "2014-01-01 00:00:00"),
  (2, 1, 1, 7, "2014-02-01 00:00:00"),
  (3, 1, 2, 7, "2014-03-01 00:00:00"),
  (4, 2, 3, 7, "2014-04-01 00:00:00"),
  (5, 2, 3, 7, "2014-05-01 00:00:00"),
  (6, 3, 2, 7, "2014-06-01 00:00:00"),
  (7, 3, 1, 7, "2014-07-01 00:00:00"),
  (8, 4, 2, 7, "2014-08-01 00:00:00"),
  (9, 4, 3, 7, "2014-09-01 00:00:00"),
  (10, 4, 3, 7, "2014-10-01 00:00:00");

INSERT INTO sinaisprod.inspecao_finalidadegrupo (inspecaoid, finalidadeid, grupoid, ordem, finalidaderegraid) VALUES
  (1, 4, 2, 0, 1),
  (1, 1, 2, 1, 2),
  (2, 2, 3, 1, 3),
  (3, 2, 3, 1, 3),
  (6, 4, 2, 0, 1),
  (6, 1, 2, 1, 2),
  (4, 1, 3, 0, 2),
  (5, 3, 3, 2, 4),
  (7, 2, 3, 1, 3);

INSERT INTO laudos.tb_laudo (id_laudo, migracao, id_conclusao, id_situacao, inspecaoid, laudo, laudo_formatado, txt_complementar, dt_inicio_situacao, dt_fim_situacao, finalidadeid) VALUES
  (1, false, 1, 4, 1, "Apto com restrições por 30 dias.", "Apto com restrições por 30 dias.", "", "2015-01-01 00:00:00", "2015-01-31 00:00:00", 1),
  (2, false, 1, 4, 1, "Apto com restrições por 30 dias.", "Apto com restrições por 30 dias.", "", "2015-01-01 00:00:00", "2015-01-31 00:00:00", 4),
  (3, false, 1, 4, 2, "Apto com restrições por 30 dias.", "Apto com restrições por 30 dias.", "", "2015-02-01 00:00:00", "2015-03-02 00:00:00", 2),
  (4, false, 1, 4, 3, "Apto com restrições por 6 dias.", "Apto com restrições por 6 dias.", "", "2015-03-02 00:00:00", "2015-03-08 00:00:00", 2);
  (5, false, 5, 5, 4, "Incapaz temporariamente por 30 dias.", "Incapaz temporariamente por 30 dias.", "", "2015-02-01 00:00:00", "2015-03-02 00:00:00", 1),
  (6, false, 5, 5, 5, "Incapaz temporariamente por 30 dias.", "Incapaz temporariamente por 30 dias.", "", "2015-03-02 00:00:00", "2015-04-01 00:00:00", 3);

  
INSERT INTO sc_samp.tb_fase_ciclo_rtrit_incapacitante (c_ciclo, c_insp, c_ord) VALUES
  (1, 1, 0),
  (1, 2, 1),
  (1, 3, 2),
  (2, 4, 0),
  (2, 5, 1);
