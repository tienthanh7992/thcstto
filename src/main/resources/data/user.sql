--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2018-10-29 00:46:51 +07

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
-- TOC entry 199 (class 1259 OID 16451)
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."user" (
    id bigserial NOT NULL,
    user_name character varying(100),
    password character varying(100),
    first_name character varying(100),
    last_name character varying(100),
    team character varying(100),
    "position" text,
    is_team_leader boolean,
    role_id bigint
);


ALTER TABLE public."user" OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16449)
-- Name: user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_id_seq OWNER TO postgres;

--
-- TOC entry 3143 (class 0 OID 0)
-- Dependencies: 198
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_id_seq OWNED BY public."user".id;


--
-- TOC entry 3011 (class 2604 OID 16454)
-- Name: user id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user" ALTER COLUMN id SET DEFAULT nextval('public.user_id_seq'::regclass);


--
-- TOC entry 3137 (class 0 OID 16451)
-- Dependencies: 199
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."user" (id, user_name, password, first_name, last_name, team, "position", is_team_leader, role_id) VALUES (1, 'hieutruong', '$2a$10$RlMbzy0x40U6t8IohrfF4.2jwsTuoP1SrcHK9TkNv.B48skjTU1aO', 'Hiệu', 'Trưởng', '', 'Hiệu trưởng', false, 1);
INSERT INTO public."user" (id, user_name, password, first_name, last_name, team, "position", is_team_leader, role_id) VALUES (2, 'hieupho', '$2a$10$RlMbzy0x40U6t8IohrfF4.2jwsTuoP1SrcHK9TkNv.B48skjTU1aO', 'Hiệu', 'Phó', '', 'Hiệu phó', false, 2);
INSERT INTO public."user" (id, user_name, password, first_name, last_name, team, "position", is_team_leader, role_id) VALUES (3, 'giaovien', '$2a$10$RlMbzy0x40U6t8IohrfF4.2jwsTuoP1SrcHK9TkNv.B48skjTU1aO', 'Giáo', 'Viên', '1', 'Giáo viên', false, 3);
INSERT INTO public."user" (id, user_name, password, first_name, last_name, team, "position", is_team_leader, role_id) VALUES (4, 'nhanvien', '$2a$10$RlMbzy0x40U6t8IohrfF4.2jwsTuoP1SrcHK9TkNv.B48skjTU1aO', 'Nhân', 'Viên', '2', 'Nhân viên', false, 4);
INSERT INTO public."user" (id, user_name, password, first_name, last_name, team, "position", is_team_leader, role_id) VALUES (5, 'director', '$2a$10$RlMbzy0x40U6t8IohrfF4.2jwsTuoP1SrcHK9TkNv.B48skjTU1aO', 'Sở', 'Giáo Dục', '', 'Sở giáo dục', false, 5);
INSERT INTO public."user" (id, user_name, password, first_name, last_name, team, "position", is_team_leader, role_id) VALUES (6, 'totruonggiaovien', '$2a$10$RlMbzy0x40U6t8IohrfF4.2jwsTuoP1SrcHK9TkNv.B48skjTU1aO', 'Tổ Trưởng', 'Giáo Viên', '1', 'Tổ trưởng giáo viên', true, 3);
INSERT INTO public."user" (id, user_name, password, first_name, last_name, team, "position", is_team_leader, role_id) VALUES (7, 'totruongnhanvien', '$2a$10$RlMbzy0x40U6t8IohrfF4.2jwsTuoP1SrcHK9TkNv.B48skjTU1aO', 'Tổ Trưởng', 'Nhân Viên', '2', 'Tổ trưởng nhân viên', false, 4);


--
-- TOC entry 3144 (class 0 OID 0)
-- Dependencies: 198
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_id_seq', 1, false);


--
-- TOC entry 3013 (class 2606 OID 16459)
-- Name: user user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- TOC entry 3014 (class 2606 OID 16460)
-- Name: user user_role_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_role_id_fkey FOREIGN KEY (role_id) REFERENCES public.role(id);


-- Completed on 2018-10-29 00:46:51 +07

--
-- PostgreSQL database dump complete
--

