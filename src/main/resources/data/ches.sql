--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2018-10-29 00:45:04 +07

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
-- TOC entry 203 (class 1259 OID 16483)
-- Name: che_submit; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.che_submit (
    id bigserial NOT NULL,
    user_id bigint,
    question_id bigint,
    issue text,
    self_point double precision,
    principal_point double precision,
    final_point double precision,
    month integer,
    updated_at timestamp without time zone,
    leader_point double precision,
    year integer
);


ALTER TABLE public.che_submit OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16481)
-- Name: che_submit_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.che_submit_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.che_submit_id_seq OWNER TO postgres;

--
-- TOC entry 3142 (class 0 OID 0)
-- Dependencies: 202
-- Name: che_submit_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.che_submit_id_seq OWNED BY public.che_submit.id;


--
-- TOC entry 3011 (class 2604 OID 16486)
-- Name: che_submit id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.che_submit ALTER COLUMN id SET DEFAULT nextval('public.che_submit_id_seq'::regclass);


--
-- TOC entry 3136 (class 0 OID 16483)
-- Dependencies: 203
-- Data for Name: che_submit; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (148, 3, 12, '', NULL, NULL, NULL, 10, '2018-10-28 23:14:06.441134', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (158, 3, 25, '', NULL, NULL, NULL, 10, '2018-10-28 23:14:06.441134', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (160, 3, 30, '', NULL, NULL, NULL, 10, '2018-10-28 23:14:06.441134', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (140, 3, 4, '', 0, NULL, NULL, 10, '2018-10-28 23:29:26.106585', 0, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (141, 3, 3, '', 0, NULL, NULL, 10, '2018-10-28 23:29:26.106585', 0, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (142, 3, 7, '', 0, NULL, NULL, 10, '2018-10-28 23:29:26.106585', 0, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (143, 3, 9, '', 0, NULL, NULL, 10, '2018-10-28 23:29:26.106585', 0, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (144, 3, 8, '', 0, NULL, NULL, 10, '2018-10-28 23:29:26.106585', 0, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (145, 3, 11, '', 0, NULL, NULL, 10, '2018-10-28 23:29:26.106585', 0, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (146, 3, 10, '', 0, NULL, NULL, 10, '2018-10-28 23:29:26.106585', 0, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (147, 3, 5, '', 0, NULL, NULL, 10, '2018-10-28 23:29:26.106585', 0, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (149, 3, 16, '', 0, NULL, NULL, 10, '2018-10-28 23:29:26.106585', 0, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (150, 3, 15, '', 0, NULL, NULL, 10, '2018-10-28 23:29:26.106585', 0, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (151, 3, 17, '', 0, NULL, NULL, 10, '2018-10-28 23:29:26.106585', 0, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (152, 3, 22, '', 0, NULL, NULL, 10, '2018-10-28 23:29:26.106585', 0, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (153, 3, 19, '', 0, NULL, NULL, 10, '2018-10-28 23:29:26.106585', 0, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (154, 3, 18, '', 0, NULL, NULL, 10, '2018-10-28 23:29:26.106585', 0, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (155, 3, 20, '', 0, NULL, NULL, 10, '2018-10-28 23:29:26.106585', 0, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (156, 3, 21, '', 0, NULL, NULL, 10, '2018-10-28 23:29:26.106585', 0, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (157, 3, 24, '', 0, NULL, NULL, 10, '2018-10-28 23:29:26.106585', 0, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (159, 3, 26, '', 0, NULL, NULL, 10, '2018-10-28 23:29:26.106585', 0, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (161, 3, 32, '', 0, NULL, NULL, 10, '2018-10-28 23:29:26.106585', 0, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (162, 3, 33, '', 0, NULL, NULL, 10, '2018-10-28 23:29:26.106585', 0, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (163, 3, 34, '', 0, NULL, NULL, 10, '2018-10-28 23:29:26.106585', 0, 2018);


--
-- TOC entry 3143 (class 0 OID 0)
-- Dependencies: 202
-- Name: che_submit_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.che_submit_id_seq', 163, true);


--
-- TOC entry 3013 (class 2606 OID 16491)
-- Name: che_submit che_submit_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.che_submit
    ADD CONSTRAINT che_submit_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.che_result
    ADD CONSTRAINT che_submit_user_id_fkey FOREIGN KEY (user_id) REFERENCES public."user"(id);

-- Completed on 2018-10-29 00:45:05 +07

--
-- PostgreSQL database dump complete
--

