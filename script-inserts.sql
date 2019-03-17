--
-- TOC entry 2836 (class 0 OID 16945)
-- Dependencies: 200
-- Data for Name: categoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "public"."categoria" ("cdcategoria", "descricao") VALUES (1, 'Desenvolvimento');
INSERT INTO "public"."categoria" ("cdcategoria", "descricao") VALUES (2, 'Análise');
INSERT INTO "public"."categoria" ("cdcategoria", "descricao") VALUES (3, 'Gestão');


--
-- TOC entry 2838 (class 0 OID 16953)
-- Dependencies: 202
-- Data for Name: subcategoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "public"."subcategoria" ("cdsubcategoria", "descricao", "cdcategoria") VALUES (4, 'Analista de requisitos', 2);
INSERT INTO "public"."subcategoria" ("cdsubcategoria", "descricao", "cdcategoria") VALUES (5, 'Analista de negócio', 2);
INSERT INTO "public"."subcategoria" ("cdsubcategoria", "descricao", "cdcategoria") VALUES (6, 'Analista de métricas', 2);
INSERT INTO "public"."subcategoria" ("cdsubcategoria", "descricao", "cdcategoria") VALUES (7, 'Gerente de projetos', 3);
INSERT INTO "public"."subcategoria" ("cdsubcategoria", "descricao", "cdcategoria") VALUES (8, 'Gerente de operações', 3);
INSERT INTO "public"."subcategoria" ("cdsubcategoria", "descricao", "cdcategoria") VALUES (9, 'Gerente de sereviços', 3);
INSERT INTO "public"."subcategoria" ("cdsubcategoria", "descricao", "cdcategoria") VALUES (1, 'Desenvolvedor júnior', 1);
INSERT INTO "public"."subcategoria" ("cdsubcategoria", "descricao", "cdcategoria") VALUES (2, 'Desenvolvedor pleno', 1);
INSERT INTO "public"."subcategoria" ("cdsubcategoria", "descricao", "cdcategoria") VALUES (3, 'Desenvolvedor sênior', 1);