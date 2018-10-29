--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2018-10-29 19:43:46 +07

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3722 (class 1262 OID 16531)
-- Name: thcstto; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE thcstto WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';


ALTER DATABASE thcstto OWNER TO postgres;

\connect thcstto

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 13792)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 3724 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 205 (class 1259 OID 16594)
-- Name: che_result; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.che_result (
    id bigint NOT NULL,
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
-- TOC entry 204 (class 1259 OID 16592)
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
-- TOC entry 3725 (class 0 OID 0)
-- Dependencies: 204
-- Name: che_result_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.che_result_id_seq OWNED BY public.che_result.id;


--
-- TOC entry 203 (class 1259 OID 16578)
-- Name: che_submit; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.che_submit (
    id bigint NOT NULL,
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
-- TOC entry 202 (class 1259 OID 16576)
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
-- TOC entry 3726 (class 0 OID 0)
-- Dependencies: 202
-- Name: che_submit_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.che_submit_id_seq OWNED BY public.che_submit.id;


--
-- TOC entry 201 (class 1259 OID 16561)
-- Name: question; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.question (
    id bigint NOT NULL,
    index integer,
    index_str character varying(100),
    content text,
    max_point double precision,
    is_increase boolean,
    question_role character varying(100),
    role_id bigint NOT NULL,
    start_point double precision DEFAULT 1,
    "group" text
);


ALTER TABLE public.question OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16559)
-- Name: question_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.question_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.question_id_seq OWNER TO postgres;

--
-- TOC entry 3727 (class 0 OID 0)
-- Dependencies: 200
-- Name: question_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.question_id_seq OWNED BY public.question.id;


--
-- TOC entry 197 (class 1259 OID 16534)
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    id bigint NOT NULL,
    code character varying(100),
    name text,
    description text
);


ALTER TABLE public.role OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16532)
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
-- TOC entry 3728 (class 0 OID 0)
-- Dependencies: 196
-- Name: role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.role_id_seq OWNED BY public.role.id;


--
-- TOC entry 199 (class 1259 OID 16545)
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."user" (
    id bigint NOT NULL,
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
-- TOC entry 198 (class 1259 OID 16543)
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
-- TOC entry 3729 (class 0 OID 0)
-- Dependencies: 198
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_id_seq OWNED BY public."user".id;


--
-- TOC entry 3571 (class 2604 OID 16597)
-- Name: che_result id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.che_result ALTER COLUMN id SET DEFAULT nextval('public.che_result_id_seq'::regclass);


--
-- TOC entry 3570 (class 2604 OID 16581)
-- Name: che_submit id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.che_submit ALTER COLUMN id SET DEFAULT nextval('public.che_submit_id_seq'::regclass);


--
-- TOC entry 3568 (class 2604 OID 16564)
-- Name: question id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question ALTER COLUMN id SET DEFAULT nextval('public.question_id_seq'::regclass);


--
-- TOC entry 3566 (class 2604 OID 16537)
-- Name: role id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role ALTER COLUMN id SET DEFAULT nextval('public.role_id_seq'::regclass);


--
-- TOC entry 3567 (class 2604 OID 16548)
-- Name: user id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user" ALTER COLUMN id SET DEFAULT nextval('public.user_id_seq'::regclass);


--
-- TOC entry 3716 (class 0 OID 16594)
-- Dependencies: 205
-- Data for Name: che_result; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.che_result (id, user_id, self_point, result_type, status, month, updated_at, leader_point, principal_point, leader_comment, principal_comment, leader_updated_at, principal_updated_at, self_created_at, year, leader_id, principal_id) VALUES (4, 3, 97.5, 'A                                                                                                   ', 'PENDING', 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-10-29 02:00:39.525269', 2018, NULL, NULL);
INSERT INTO public.che_result (id, user_id, self_point, result_type, status, month, updated_at, leader_point, principal_point, leader_comment, principal_comment, leader_updated_at, principal_updated_at, self_created_at, year, leader_id, principal_id) VALUES (5, 6, 29, 'D                                                                                                   ', 'PENDING', 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-10-29 02:07:50.029391', 2018, NULL, NULL);


--
-- TOC entry 3714 (class 0 OID 16578)
-- Dependencies: 203
-- Data for Name: che_submit; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (73, 3, 4, '', 2, NULL, NULL, 10, '2018-10-29 02:00:39.519934', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (74, 3, 3, '', 2, NULL, NULL, 10, '2018-10-29 02:00:39.519934', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (75, 3, 7, '', 1, NULL, NULL, 10, '2018-10-29 02:00:39.519934', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (76, 3, 9, '', 2, NULL, NULL, 10, '2018-10-29 02:00:39.519934', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (77, 3, 8, '', 2, NULL, NULL, 10, '2018-10-29 02:00:39.519934', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (78, 3, 11, '', 1, NULL, NULL, 10, '2018-10-29 02:00:39.519934', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (79, 3, 10, '', 2, NULL, NULL, 10, '2018-10-29 02:00:39.519934', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (80, 3, 5, '', 8, NULL, NULL, 10, '2018-10-29 02:00:39.519934', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (81, 3, 12, '', NULL, NULL, NULL, 10, '2018-10-29 02:00:39.519934', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (82, 3, 16, '', 2, NULL, NULL, 10, '2018-10-29 02:00:39.519934', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (83, 3, 15, '', 2, NULL, NULL, 10, '2018-10-29 02:00:39.519934', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (84, 3, 17, '', 2, NULL, NULL, 10, '2018-10-29 02:00:39.519934', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (85, 3, 22, '', 2, NULL, NULL, 10, '2018-10-29 02:00:39.519934', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (86, 3, 19, '', 2, NULL, NULL, 10, '2018-10-29 02:00:39.519934', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (87, 3, 18, '', 2, NULL, NULL, 10, '2018-10-29 02:00:39.519934', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (88, 3, 20, '', 2, NULL, NULL, 10, '2018-10-29 02:00:39.519934', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (89, 3, 21, '', 2, NULL, NULL, 10, '2018-10-29 02:00:39.519934', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (90, 3, 24, '', 2, NULL, NULL, 10, '2018-10-29 02:00:39.519934', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (91, 3, 25, '', NULL, NULL, NULL, 10, '2018-10-29 02:00:39.519934', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (92, 3, 26, '', 50, NULL, NULL, 10, '2018-10-29 02:00:39.519934', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (93, 3, 30, '', NULL, NULL, NULL, 10, '2018-10-29 02:00:39.519934', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (94, 3, 32, '', 4, NULL, NULL, 10, '2018-10-29 02:00:39.519934', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (95, 3, 33, '', 3, NULL, NULL, 10, '2018-10-29 02:00:39.519934', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (96, 3, 34, '', 2.5, NULL, NULL, 10, '2018-10-29 02:00:39.519934', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (97, 6, 4, '', 0.5, NULL, NULL, 10, '2018-10-29 02:07:50.025642', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (98, 6, 3, '', 1, NULL, NULL, 10, '2018-10-29 02:07:50.025642', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (99, 6, 7, '', 0.5, NULL, NULL, 10, '2018-10-29 02:07:50.025642', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (100, 6, 9, '', 1, NULL, NULL, 10, '2018-10-29 02:07:50.025642', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (101, 6, 8, '', 1, NULL, NULL, 10, '2018-10-29 02:07:50.025642', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (102, 6, 11, '', 1, NULL, NULL, 10, '2018-10-29 02:07:50.025642', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (103, 6, 10, '', 1, NULL, NULL, 10, '2018-10-29 02:07:50.025642', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (104, 6, 5, '', 4, NULL, NULL, 10, '2018-10-29 02:07:50.025642', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (105, 6, 12, '', NULL, NULL, NULL, 10, '2018-10-29 02:07:50.025642', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (106, 6, 16, '', 1.5, NULL, NULL, 10, '2018-10-29 02:07:50.025642', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (107, 6, 15, '', 1, NULL, NULL, 10, '2018-10-29 02:07:50.025642', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (108, 6, 17, '', 1.5, NULL, NULL, 10, '2018-10-29 02:07:50.025642', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (109, 6, 22, '', 1.5, NULL, NULL, 10, '2018-10-29 02:07:50.025642', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (110, 6, 19, '', 1, NULL, NULL, 10, '2018-10-29 02:07:50.025642', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (111, 6, 18, '', 1, NULL, NULL, 10, '2018-10-29 02:07:50.025642', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (112, 6, 20, '', 1, NULL, NULL, 10, '2018-10-29 02:07:50.025642', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (113, 6, 21, '', 1, NULL, NULL, 10, '2018-10-29 02:07:50.025642', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (114, 6, 24, '', 1, NULL, NULL, 10, '2018-10-29 02:07:50.025642', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (115, 6, 25, '', NULL, NULL, NULL, 10, '2018-10-29 02:07:50.025642', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (116, 6, 26, '', 8.5, NULL, NULL, 10, '2018-10-29 02:07:50.025642', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (117, 6, 30, '', NULL, NULL, NULL, 10, '2018-10-29 02:07:50.025642', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (118, 6, 32, '', 0, NULL, NULL, 10, '2018-10-29 02:07:50.025642', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (119, 6, 33, '', 0, NULL, NULL, 10, '2018-10-29 02:07:50.025642', NULL, 2018);
INSERT INTO public.che_submit (id, user_id, question_id, issue, self_point, principal_point, final_point, month, updated_at, leader_point, year) VALUES (120, 6, 34, '', 0, NULL, NULL, 10, '2018-10-29 02:07:50.025642', NULL, 2018);


--
-- TOC entry 3712 (class 0 OID 16561)
-- Dependencies: 201
-- Data for Name: question; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (1, 2, '1', 'Chấp hành tốt đường lối, chủ trương của Đảng, chính sách pháp luật của nhà nước.', 5, true, 'SUB_TOPIC', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (2, 1, 'I', 'Ý THỨC TỔ CHỨC KỶ LUẬT', 20, true, 'TOPIC', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (3, 4, '1.2', 'Có phẩm chất đạo đức tốt, có tinh thần nêu gương, tận tụy, trung thực trong công việc, sẵn sàng nhận nhiệm vụ. Có thái độ phục vụ nhân dân đúng mực; không hách dịch, cửa quyền, phiền hà, tiêu cực trong thực hiện công vụ.', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (4, 3, '1.1', 'Gương mẫu chấp hành tốt đường lối, chủ trương của Đảng, chính sách pháp luật của nhà nước', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (5, 11, '2.5', 'Thực hiện ngày giờ công theo qui định', 8, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (6, 6, '2', 'Chấp hành nghiêm giờ làm việc, nội quy, quy chế, quy định của cơ quan, đơn vị gồm:', 15, true, 'SUB_TOPIC', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (7, 5, '1.3', 'Có tinh thần đoàn kết, thực hiện nguyên tắc tập trung dân chủ trong đơn vị', 1, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (8, 8, '2.2', 'Chấp hành kỷ luật, kỷ cương hành chính và các văn bản của Huyện ủy - UBND Huyện áp dụng đối với CBCCVC, LĐHĐ huyện, xã;
Sử dụng hiệu quả thời gian làm việc. Chấp hành quy định ra, vào cơ quan; quản lý bảo vệ tài sản, trang thiết bị của cơ quan. Đeo thẻ chức danh trong giờ làm việc. Sắp xếp, bài trí chỗ làm việc gọn gàng, ngăn nắp, sạch sẽ.', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (9, 7, '2.1', 'Thực hiện tốt văn hoá công sở; giao tiếp thân thiện, lịch sự, ngôn ngữ chuẩn mực, rõ ràng. Mặc trang phục lịch sự, phù hợp với hoàn cảnh, tính chất công việc, đúng quy định của cơ quan.', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (10, 10, '2.4', 'Giữ gìn bí mật nhà nước trong cơ quan, đơn vị và thực hiện nghiêm kỷ luật phát ngôn.', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (11, 9, '2.3', 'Xây dựng hình ảnh, giữ gìn uy tín cho bản thân, cơ quan, đơn vị và đồng nghiệp.', 1, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (13, 14, '1', 'Năng lực và kỹ năng lãnh đạo, điều hành', 20, true, 'SUB_TOPIC', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (14, 13, 'II', 'KẾT QUẢ THỰC HIỆN NHIỆM VỤ', 70, true, 'TOPIC', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (23, 25, '2', 'Thực hiện nhiệm vụ theo kế hoạch, lịch công tác đảm bảo tiến độ, chất lượng
(theo tiêu chí thi đua)', 50, true, 'SUB_TOPIC', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (31, 31, 'III', 'ĐIỂM THƯỞNG 
(theo tiêu chí thi đua)', 10, true, 'TOPIC', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (35, 35, NULL, 'Tổng điểm', 100, true, 'TOTAL', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (16, 15, '1.1', 'Chủ động nghiên cứu, cập nhật kịp thời các kiến thức pháp luật, các kiến thức, kỹ năng về chuyên môn nghiệp vụ; tham mưu cho Hiệu trưởng các giải pháp nâng cao chất lượng dạy và học đáp ứng với yêu cầu đổi mới đạt hiệu quả, chất lượng.', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (18, 20, '1.6', 'Có năng lực tập hợp GV, NV xây dựng nhà trường đoàn kết, thống nhất.', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (19, 19, '1.5', 'Thường xuyên kiểm tra việc thực hiện chuyên môn của GV, NV đảm bảo quy định. Có khả năng bao quát, đôn đốc việc thực hiện nhiệm vụ của GV, NV; giải quyết kịp thời những khó khăn, vướng mắc theo thẩm quyền được giao', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (20, 21, '1.7', 'Phối hợp với GV, NV thiết lập mối quan hệ tốt với phụ huynh học sinh, các tổ chức, cá nhân, đoàn thể có liên quan đến trong thực hiện nhiệm vụ', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (21, 22, '1.9', 'Sử dụng thành thạo ứng dụng CNTT đáp ứng yêu cầu quản lý, điều hành, giải quyết công việc', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (22, 18, '1.4', 'Tham mưu phân công nhiệm vụ cho giáo viên, nhân viên thuộc bộ phận phụ trách đảm bảo rõ người, rõ nội dung, tiến độ thực hiện.', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (24, 23, '1.10', 'Tham mưu tổ chức, chủ trì, điều hành cuộc họp hiệu quả.', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (15, 16, '1.2', 'Tham mưu có hiệu quả trong việc xây dựng các kế hoạch công tác, lịch công tác của cá nhân, bộ phận phụ trách đảm bảo tiến độ', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (17, 17, '1.3', 'Kiểm soát việc thực hiện của các tổ chuyên môn thuộc lĩnh vực được phân công phụ trách đảm bảo kịp thời, không bỏ sót công việc. Giải quyết công việc đúng quy trình quy định.', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (32, 32, '1', 'Tham mưu, đề xuất giải pháp, mô hình mới đảm bảo chất lượng và tiến độ, được cấp có thẩm quyền phê duyệt', 4, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (33, 33, '2', 'Tham mưu có hiệu quả đối với các nhiệm vụ mới, khó, phức tạp theo phân công được lãnh đạo cơ quan, đơn vị ghi nhận', 3, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (34, 34, '3', 'Chủ động, sáng tạo, khoa học, cải tiến phương pháp làm việc, nâng cao hiệu quả công việc, có thành tích nổi bật', 3, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (12, 12, NULL, 'Nội dung bị trừ điểm:
+ Có phản ảnh, kiến nghị của phụ huynh học sinh, của nhân dân và đồng nghiệp về thái độ giao tiếp, ứng xử thiếu lịch sự với đồng nghiệp hoặc với học sinh (và xác minh sự việc là đúng);
+ Mặc trang phục không phù hợp môi trường sư phạm.
+ Thực hiện ngày giờ công không theo theo qui định.
+ Tuyên truyền các thông tin thiếu chính xác trên mạng xã hội hoặc có hành vi (lời nói, việc làm) gây ảnh hưởng tới uy tín của địa phương, ngành, nhà trường và đồng nghiệp;
+ Có hành vi (lời nói, việc làm, phát ngôn) gây ảnh hưởng tới uy tín của bản thân, đồng nghiệp, nhà trường.', 20, false, 'DECREASE', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (30, 30, NULL, 'Nội dung bị trừ điểm: 
- Không thực hiện nhiệm vụ theo đúng lịch công tác mà không có lý do...
- Không hoàn thành công việc đúng tiến độ và chất lượng công việc không theo đúng yêu cầu của nhà trường. 
- Không kịp thời xử lý, giải quyết dứt điểm các khiếu nại, kiến nghị của phụ huynh học sinh làm ảnh hưởng đến uy tín của nhà trường.
- Không báo cáo kịp thời với BGH các khó khăn, vướng mắc làm ảnh hưởng đến kết quả giải quyết công việc, đến uy tín của nhà trường....', 50, false, 'DECREASE', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (25, 24, NULL, 'Nội dung bị trừ điểm:
+ Chưa kịp thời cập nhật kiến thức chuyên môn, phương pháp đổi mới trong thực hiện nhiệm vụ;
+ Xây dựng lịch công tác tuần, lịch báo giảng chưa khớp với sổ ghi đầu bài hoặc chưa hợp lý về nội dung hoặc còn bỏ sót nhiệm vụ;
+ Còn công việc bị bỏ sót hoặc bỏ chương trình giảng dạy chưa thực hiện;   
+ Lên lớp không có giáo án, soạn bải không theo phân phối chương trình, các loại hồ sơ, sổ sách nội dung không đảm bảo.
+ Giải quyết công việc không đúng quy trình.
+ Không báo cáo BGH kịp thời các nội dung còn vướng mắc xảy ra, không xử lý kịp thời, dứt điểm tình trạng học sinh mâu thuẫn, mất đoàn kết dẫn đến xích mích;
+ Chưa chủ động đề xuất giải pháp thực hiện nhiệm vụ được giao hoặc không báo cáo lãnh đạo kịp thời những khó khăn, vướng mắc làm ảnh hưởng tới kết quả, chất lượng công việc
+ Hàng tháng chậm đánh giá kết quả thực hiện nhiệm vụ theo quy định
+ Phối hợp với phụ huynh học sinh, đồng nghiệp và các tổ chức liên quan trong giải quyết công việc không hiệu quả, tạo căng thẳng, bức xúc
+ Chưa sử dụng thành thạo CNTT hoặc chưa ứng dụng CNTT trong đổi mới PPDH.  
+ Báo cáo số liệu, tài liệu bị sai sót về nội dung, hình thức.', 10, false, 'DECREASE', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (26, 26, '2.1', '+ Hoàn thành từ 90%-100% công việc theo kế hoạch, lịch công tác đảm bảo tiến độ và chất lượng: điểm từ 45 => 50                          

+ Hoàn thành từ 80%-<90% công việc theo kế hoạch, lịch công tác đảm bảo tiến độ và chất lượng: điểm từ 40 => 44                      
   
+ Hoàn thành từ 70%-<80% công việc theo kế hoạch, lịch công tác đảm bảo tiến độ và chất lượng: điểm từ 35 => 39          
      
+ Hoàn thành dưới 70% công việc theo kế hoạch, lịch công tác đảm bảo tiến độ và chất lượng: điểm dưới <35', 50, true, 'QUESTION', 3, 0, '3-1');


--
-- TOC entry 3708 (class 0 OID 16534)
-- Dependencies: 197
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.role (id, code, name, description) VALUES (1, 'PRINCIPAL', 'Hiệu trưởng', NULL);
INSERT INTO public.role (id, code, name, description) VALUES (2, 'VICE_PRINCIPAL', 'Hiệu phó', NULL);
INSERT INTO public.role (id, code, name, description) VALUES (3, 'TEACHER', 'Giáo viên', NULL);
INSERT INTO public.role (id, code, name, description) VALUES (4, 'EMPLOYEE', 'Nhân viên', NULL);
INSERT INTO public.role (id, code, name, description) VALUES (5, 'DIRECTOR', 'Sở giáo dục', NULL);


--
-- TOC entry 3710 (class 0 OID 16545)
-- Dependencies: 199
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."user" (id, user_name, password, first_name, last_name, team, "position", is_team_leader, role_id) VALUES (5, 'director', '$2a$10$RlMbzy0x40U6t8IohrfF4.2jwsTuoP1SrcHK9TkNv.B48skjTU1aO', 'Sở', 'Giáo Dục', '', 'Sở giáo dục', false, 5);
INSERT INTO public."user" (id, user_name, password, first_name, last_name, team, "position", is_team_leader, role_id) VALUES (1, 'hieutruong', '$2a$10$RlMbzy0x40U6t8IohrfF4.2jwsTuoP1SrcHK9TkNv.B48skjTU1aO', 'Nguyễn Thị', 'Hồng Thịnh', '', 'Hiệu trưởng', false, 1);
INSERT INTO public."user" (id, user_name, password, first_name, last_name, team, "position", is_team_leader, role_id) VALUES (2, 'hieupho', '$2a$10$RlMbzy0x40U6t8IohrfF4.2jwsTuoP1SrcHK9TkNv.B48skjTU1aO', 'Đoàn Thị', 'Hương Giang', '', 'Hiệu phó', false, 2);
INSERT INTO public."user" (id, user_name, password, first_name, last_name, team, "position", is_team_leader, role_id) VALUES (3, 'giaovien', '$2a$10$RlMbzy0x40U6t8IohrfF4.2jwsTuoP1SrcHK9TkNv.B48skjTU1aO', 'Nguyễn', 'Vân Anh', '1', 'Giáo viên', false, 3);
INSERT INTO public."user" (id, user_name, password, first_name, last_name, team, "position", is_team_leader, role_id) VALUES (6, 'totruonggiaovien', '$2a$10$RlMbzy0x40U6t8IohrfF4.2jwsTuoP1SrcHK9TkNv.B48skjTU1aO', 'Trần', 'Thị Hiền', '1', 'Tổ trưởng giáo viên', true, 3);
INSERT INTO public."user" (id, user_name, password, first_name, last_name, team, "position", is_team_leader, role_id) VALUES (4, 'nhanvien', '$2a$10$RlMbzy0x40U6t8IohrfF4.2jwsTuoP1SrcHK9TkNv.B48skjTU1aO', 'Nguyễn', 'Hồng Nhân', '2', 'Nhân viên', false, 4);
INSERT INTO public."user" (id, user_name, password, first_name, last_name, team, "position", is_team_leader, role_id) VALUES (7, 'totruongnhanvien', '$2a$10$RlMbzy0x40U6t8IohrfF4.2jwsTuoP1SrcHK9TkNv.B48skjTU1aO', 'Nguyễn', 'Thị Hương', '2', 'Tổ trưởng nhân viên', true, 4);
INSERT INTO public."user" (id, user_name, password, first_name, last_name, team, "position", is_team_leader, role_id) VALUES (8, 'hieupho1', '$2a$10$RlMbzy0x40U6t8IohrfF4.2jwsTuoP1SrcHK9TkNv.B48skjTU1aO', 'Nguyễn', 'Thị Thành', NULL, 'Hiệu phó', NULL, 2);


--
-- TOC entry 3730 (class 0 OID 0)
-- Dependencies: 204
-- Name: che_result_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.che_result_id_seq', 5, true);


--
-- TOC entry 3731 (class 0 OID 0)
-- Dependencies: 202
-- Name: che_submit_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.che_submit_id_seq', 120, true);


--
-- TOC entry 3732 (class 0 OID 0)
-- Dependencies: 200
-- Name: question_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.question_id_seq', 1, false);


--
-- TOC entry 3733 (class 0 OID 0)
-- Dependencies: 196
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.role_id_seq', 1, false);


--
-- TOC entry 3734 (class 0 OID 0)
-- Dependencies: 198
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_id_seq', 1, true);


--
-- TOC entry 3581 (class 2606 OID 16602)
-- Name: che_result che_result_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.che_result
    ADD CONSTRAINT che_result_pkey PRIMARY KEY (id);


--
-- TOC entry 3579 (class 2606 OID 16586)
-- Name: che_submit che_submit_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.che_submit
    ADD CONSTRAINT che_submit_pkey PRIMARY KEY (id);


--
-- TOC entry 3577 (class 2606 OID 16570)
-- Name: question question_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question
    ADD CONSTRAINT question_pkey PRIMARY KEY (id);


--
-- TOC entry 3573 (class 2606 OID 16542)
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- TOC entry 3575 (class 2606 OID 16553)
-- Name: user user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- TOC entry 3585 (class 2606 OID 16603)
-- Name: che_result che_result_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.che_result
    ADD CONSTRAINT che_result_user_id_fkey FOREIGN KEY (user_id) REFERENCES public."user"(id);


--
-- TOC entry 3584 (class 2606 OID 16587)
-- Name: che_submit che_submit_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.che_submit
    ADD CONSTRAINT che_submit_user_id_fkey FOREIGN KEY (user_id) REFERENCES public."user"(id);


--
-- TOC entry 3583 (class 2606 OID 16571)
-- Name: question question_role_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question
    ADD CONSTRAINT question_role_id_fkey FOREIGN KEY (role_id) REFERENCES public.role(id);


--
-- TOC entry 3582 (class 2606 OID 16554)
-- Name: user user_role_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_role_id_fkey FOREIGN KEY (role_id) REFERENCES public.role(id);


-- Completed on 2018-10-29 19:43:54 +07

--
-- PostgreSQL database dump complete
--

