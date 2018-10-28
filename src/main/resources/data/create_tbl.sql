-- Table: public.che_result

-- DROP TABLE public.che_result;

CREATE TABLE public.che_result
(
    id bigint NOT NULL DEFAULT nextval('che_result_id_seq'::regclass),
    user_id bigint,
    self_point double precision,
    result_type character(100) COLLATE pg_catalog."default",
    status character varying(100) COLLATE pg_catalog."default",
    month integer,
    updated_at timestamp without time zone,
    leader_point double precision,
    principal_point double precision,
    leader_comment text COLLATE pg_catalog."default",
    principal_comment text COLLATE pg_catalog."default",
    leader_updated_at timestamp without time zone,
    principal_updated_at timestamp without time zone,
    self_created_at timestamp without time zone,
    year integer,
    leader_id bigint,
    principal_id bigint,
    CONSTRAINT che_result_pkey PRIMARY KEY (id),
    CONSTRAINT che_result_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES public."user" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.che_result
    OWNER to postgres;
    
    -- Table: public.che_submit

-- DROP TABLE public.che_submit;

CREATE TABLE public.che_submit
(
    id bigint NOT NULL DEFAULT nextval('che_submit_id_seq'::regclass),
    user_id bigint,
    question_id bigint,
    issue text COLLATE pg_catalog."default",
    self_point double precision,
    principal_point double precision,
    final_point double precision,
    month integer,
    updated_at timestamp without time zone,
    leader_point double precision,
    year integer,
    CONSTRAINT che_submit_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.che_submit
    OWNER to postgres;
    -- Table: public.question

-- DROP TABLE public.question;

CREATE TABLE public.question
(
    id bigint NOT NULL DEFAULT nextval('question_id_seq'::regclass),
    index integer,
    index_str character varying(100) COLLATE pg_catalog."default",
    content text COLLATE pg_catalog."default",
    max_point double precision,
    is_increase boolean,
    question_role character varying(100) COLLATE pg_catalog."default",
    role_id bigint NOT NULL,
    start_point double precision DEFAULT 1,
    "group" text COLLATE pg_catalog."default",
    CONSTRAINT question_pkey PRIMARY KEY (id),
    CONSTRAINT question_role_id_fkey FOREIGN KEY (role_id)
        REFERENCES public.role (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.question
    OWNER to postgres;
    -- Table: public.role

-- DROP TABLE public.role;

CREATE TABLE public.role
(
    id bigint NOT NULL DEFAULT nextval('role_id_seq'::regclass),
    code character varying(100) COLLATE pg_catalog."default",
    name text COLLATE pg_catalog."default",
    description text COLLATE pg_catalog."default",
    CONSTRAINT role_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.role
    OWNER to postgres;
    
    -- Table: public."user"

-- DROP TABLE public."user";

CREATE TABLE public."user"
(
    id bigint NOT NULL DEFAULT nextval('user_id_seq'::regclass),
    user_name character varying(100) COLLATE pg_catalog."default",
    password character varying(100) COLLATE pg_catalog."default",
    first_name character varying(100) COLLATE pg_catalog."default",
    last_name character varying(100) COLLATE pg_catalog."default",
    team character varying(100) COLLATE pg_catalog."default",
    "position" text COLLATE pg_catalog."default",
    is_team_leader boolean,
    role_id bigint,
    CONSTRAINT user_pkey PRIMARY KEY (id),
    CONSTRAINT user_role_id_fkey FOREIGN KEY (role_id)
        REFERENCES public.role (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."user"
    OWNER to postgres;