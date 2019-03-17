--
-- PostgreSQL database dump
--

-- Dumped from database version 11.1
-- Dumped by pg_dump version 11.1

-- Started on 2019-02-12 11:56:06

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE "manter-cargo";
--
-- TOC entry 2844 (class 1262 OID 16393)
-- Name: manter-cargo; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "manter-cargo" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';


ALTER DATABASE "manter-cargo" OWNER TO "postgres";

\connect -reuse-previous=on "dbname='manter-cargo'"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 198 (class 1259 OID 16937)
-- Name: cargo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "public"."cargo" (
    "cdcargo" integer NOT NULL,
    "cbo" character varying(255),
    "cod_folha" bigint NOT NULL,
    "descricao" character varying(100),
    "hr_semana" bigint,
    "nome" character varying(50) NOT NULL,
    "vl_hora" double precision,
    "cdcategoria" integer NOT NULL,
    "cdsubcategoria" integer,
    "situacao" integer
);


ALTER TABLE "public"."cargo" OWNER TO "postgres";

--
-- TOC entry 197 (class 1259 OID 16935)
-- Name: cargo_cdcargo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "public"."cargo_cdcargo_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "public"."cargo_cdcargo_seq" OWNER TO "postgres";

--
-- TOC entry 2845 (class 0 OID 0)
-- Dependencies: 197
-- Name: cargo_cdcargo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "public"."cargo_cdcargo_seq" OWNED BY "public"."cargo"."cdcargo";


--
-- TOC entry 200 (class 1259 OID 16945)
-- Name: categoria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "public"."categoria" (
    "cdcategoria" integer NOT NULL,
    "descricao" character varying(100)
);


ALTER TABLE "public"."categoria" OWNER TO "postgres";

--
-- TOC entry 199 (class 1259 OID 16943)
-- Name: categoria_cdcategoria_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "public"."categoria_cdcategoria_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "public"."categoria_cdcategoria_seq" OWNER TO "postgres";

--
-- TOC entry 2846 (class 0 OID 0)
-- Dependencies: 199
-- Name: categoria_cdcategoria_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "public"."categoria_cdcategoria_seq" OWNED BY "public"."categoria"."cdcategoria";


--
-- TOC entry 196 (class 1259 OID 16933)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "public"."hibernate_sequence"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "public"."hibernate_sequence" OWNER TO "postgres";

--
-- TOC entry 202 (class 1259 OID 16953)
-- Name: subcategoria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "public"."subcategoria" (
    "cdsubcategoria" integer NOT NULL,
    "descricao" character varying(100),
    "cdcategoria" integer
);


ALTER TABLE "public"."subcategoria" OWNER TO "postgres";

--
-- TOC entry 201 (class 1259 OID 16951)
-- Name: subcategoria_cdsubcategoria_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "public"."subcategoria_cdsubcategoria_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "public"."subcategoria_cdsubcategoria_seq" OWNER TO "postgres";

--
-- TOC entry 2847 (class 0 OID 0)
-- Dependencies: 201
-- Name: subcategoria_cdsubcategoria_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "public"."subcategoria_cdsubcategoria_seq" OWNED BY "public"."subcategoria"."cdsubcategoria";


--
-- TOC entry 2699 (class 2604 OID 16940)
-- Name: cargo cdcargo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."cargo" ALTER COLUMN "cdcargo" SET DEFAULT "nextval"('"public"."cargo_cdcargo_seq"'::"regclass");


--
-- TOC entry 2700 (class 2604 OID 16948)
-- Name: categoria cdcategoria; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."categoria" ALTER COLUMN "cdcategoria" SET DEFAULT "nextval"('"public"."categoria_cdcategoria_seq"'::"regclass");


--
-- TOC entry 2701 (class 2604 OID 16956)
-- Name: subcategoria cdsubcategoria; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."subcategoria" ALTER COLUMN "cdsubcategoria" SET DEFAULT "nextval"('"public"."subcategoria_cdsubcategoria_seq"'::"regclass");


--
-- TOC entry 2834 (class 0 OID 16937)
-- Dependencies: 198
-- Data for Name: cargo; Type: TABLE DATA; Schema: public; Owner: postgres
--



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


--
-- TOC entry 2848 (class 0 OID 0)
-- Dependencies: 197
-- Name: cargo_cdcargo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"public"."cargo_cdcargo_seq"', 13, true);


--
-- TOC entry 2849 (class 0 OID 0)
-- Dependencies: 199
-- Name: categoria_cdcategoria_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"public"."categoria_cdcategoria_seq"', 2, true);


--
-- TOC entry 2850 (class 0 OID 0)
-- Dependencies: 196
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"public"."hibernate_sequence"', 4, true);


--
-- TOC entry 2851 (class 0 OID 0)
-- Dependencies: 201
-- Name: subcategoria_cdsubcategoria_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"public"."subcategoria_cdsubcategoria_seq"', 4, true);


--
-- TOC entry 2703 (class 2606 OID 16942)
-- Name: cargo cargo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."cargo"
    ADD CONSTRAINT "cargo_pkey" PRIMARY KEY ("cdcargo");


--
-- TOC entry 2705 (class 2606 OID 16950)
-- Name: categoria categoria_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."categoria"
    ADD CONSTRAINT "categoria_pkey" PRIMARY KEY ("cdcategoria");


--
-- TOC entry 2707 (class 2606 OID 16958)
-- Name: subcategoria subcategoria_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."subcategoria"
    ADD CONSTRAINT "subcategoria_pkey" PRIMARY KEY ("cdsubcategoria");


--
-- TOC entry 2710 (class 2606 OID 16964)
-- Name: subcategoria fk_2n8e39p00ptb29fxbp7c5ic4w; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."subcategoria"
    ADD CONSTRAINT "fk_2n8e39p00ptb29fxbp7c5ic4w" FOREIGN KEY ("cdcategoria") REFERENCES "public"."categoria"("cdcategoria");


--
-- TOC entry 2709 (class 2606 OID 16970)
-- Name: cargo fk_6wc5kco4ig30vf6lc3kwqjihh; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."cargo"
    ADD CONSTRAINT "fk_6wc5kco4ig30vf6lc3kwqjihh" FOREIGN KEY ("cdsubcategoria") REFERENCES "public"."subcategoria"("cdsubcategoria");


--
-- TOC entry 2708 (class 2606 OID 16959)
-- Name: cargo fk_72pocbvm46jbo6b1egfkfk57w; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."cargo"
    ADD CONSTRAINT "fk_72pocbvm46jbo6b1egfkfk57w" FOREIGN KEY ("cdcategoria") REFERENCES "public"."categoria"("cdcategoria");


-- Completed on 2019-02-12 11:56:06

--
-- PostgreSQL database dump complete
--

