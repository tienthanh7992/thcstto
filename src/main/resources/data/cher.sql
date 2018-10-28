--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2018-10-29 00:44:19 +07

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
-- TOC entry 201 (class 1259 OID 16467)
-- Name: che_result; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.che_result (
    id bigserial NOT NULL,
    user_id bigint,
    self_point double precision,
    result_type character(100),
    status character varying(100),
    month integer,
    updated_at timestamp without time zone,
    leader_point double precision,
    principal_point double precision,
    leader_comment text,
    principal_comment text,
    leader_updated_at timestamp without time zone,
    principal_updated_at timestamp without time zone,
    self_created_at timestamp without time zone,
    year integer,
    leader_id bigint,
    principal_id bigint
);


ALTER TABLE public.che_result OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16465)
-- Name: che_result_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.che_result_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.che_result_id_seq OWNER TO postgres;

--
-- TOC entry 3143 (class 0 OID 0)
-- Dependencies: 200
-- Name: che_result_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.che_result_id_seq OWNED BY public.che_result.id;


--
-- TOC entry 3011 (class 2604 OID 16470)
-- Name: che_result id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.che_result ALTER COLUMN id SET DEFAULT nextval('public.che_result_id_seq'::regclass);


--
-- TOC entry 3137 (class 0 OID 16467)
-- Dependencies: 201
-- Data for Name: che_result; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.che_result (id, user_id, self_point, result_type, status, month, updated_at, leader_point, principal_point, leader_comment, principal_comment, leader_updated_at, principal_updated_at, self_created_at, year, leader_id, principal_id) VALUES (10, 3, 0, 'D                                                                                                   ', 'LEADER_APPROVED', 10, NULL, -21, NULL, '', NULL, '2018-10-28 23:29:26.116512', NULL, '2018-10-28 23:14:06.44656', NULL, 6, NULL);


--
-- TOC entry 3144 (class 0 OID 0)
-- Dependencies: 200
-- Name: che_result_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.che_result_id_seq', 10, true);


--
-- TOC entry 3013 (class 2606 OID 16475)
-- Name: che_result che_result_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.che_result
    ADD CONSTRAINT che_result_pkey PRIMARY KEY (id);


--
-- TOC entry 3014 (class 2606 OID 16476)
-- Name: che_result che_result_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.che_result
    ADD CONSTRAINT che_result_user_id_fkey FOREIGN KEY (user_id) REFERENCES public."user"(id);


-- Completed on 2018-10-29 00:44:20 +07

--
-- PostgreSQL database dump complete
--

