
-- DROP TABLE public.role;

CREATE TABLE public.role
(
    id bigserial NOT NULL,
    code character varying(100),
    name text,
    description text,
    CONSTRAINT role_pkey PRIMARY KEY (id)
);

-- DROP TABLE public."user";

CREATE TABLE public."user"
(
    id bigserial NOT NULL,
    user_name character varying(100),
    password character varying(100),
    first_name character varying(100),
    last_name character varying(100),
    team character varying(100),
    "position" text,
    is_team_leader boolean,
    role_id bigint,
    CONSTRAINT user_pkey PRIMARY KEY (id),
    CONSTRAINT user_role_id_fkey FOREIGN KEY (role_id)
        REFERENCES public.role (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

