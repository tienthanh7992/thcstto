--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2018-10-29 00:46:15 +07

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
-- TOC entry 197 (class 1259 OID 16440)
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    id bigserial NOT NULL,
    code character varying(100),
    name text,
    description text
);


ALTER TABLE public.role OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16438)
-- Name: role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.role_id_seq OWNER TO postgres;

--
-- TOC entry 3142 (class 0 OID 0)
-- Dependencies: 196
-- Name: role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.role_id_seq OWNED BY public.role.id;


--
-- TOC entry 3011 (class 2604 OID 16443)
-- Name: role id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role ALTER COLUMN id SET DEFAULT nextval('public.role_id_seq'::regclass);


--
-- TOC entry 3136 (class 0 OID 16440)
-- Dependencies: 197
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.role (id, code, name, description) VALUES (1, 'PRINCIPAL', 'Hiệu trưởng', NULL);
INSERT INTO public.role (id, code, name, description) VALUES (2, 'VICE_PRINCIPAL', 'Hiệu phó', NULL);
INSERT INTO public.role (id, code, name, description) VALUES (3, 'TEACHER', 'Giáo viên', NULL);
INSERT INTO public.role (id, code, name, description) VALUES (4, 'EMPLOYEE', 'Nhân viên', NULL);
INSERT INTO public.role (id, code, name, description) VALUES (5, 'DIRECTOR', 'Sở giáo dục', NULL);


--
-- TOC entry 3143 (class 0 OID 0)
-- Dependencies: 196
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.role_id_seq', 1, false);


--
-- TOC entry 3013 (class 2606 OID 16448)
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


-- Completed on 2018-10-29 00:46:15 +07

--
-- PostgreSQL database dump complete
--

