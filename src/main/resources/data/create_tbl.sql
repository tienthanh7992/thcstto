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

-- Table: public.che_result

-- DROP TABLE public.che_result;

CREATE TABLE public.che_result
(
    id bigserial NOT NULL,
    user_id bigint,
    self_point integer,
    result_type character(100),
    status character varying(100),
    month integer,
    updated_at timestamp without time zone,
    leader_point integer,
    principal_point integer,
    leader_comment text,
    principal_comment text,
    leader_updated_at timestamp without time zone,
    principal_updated_at timestamp without time zone,
    self_created_at timestamp without time zone,
    year integer,
    CONSTRAINT che_result_pkey PRIMARY KEY (id),
    CONSTRAINT che_result_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES public."user" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


-- DROP TABLE public.che_submit;

CREATE TABLE public.che_submit
(
    id bigserial NOT NULL,
    user_id bigint,
    question_id bigint,
    issue text,
    self_point integer,
    lead_point integer,
    principal_point integer,
    final_point integer,
    month integer,
    updated_at timestamp without time zone,
    CONSTRAINT che_submit_pkey PRIMARY KEY (id)
);

-- DROP TABLE public.question;

CREATE TABLE public.question
(
    id bigserial NOT NULL,
    index integer,
    index_str character varying(100),
    content text,
    max_point bigint,
    is_increase boolean,
    question_role character varying(100),
    role_id bigint NOT NULL,
    start_point integer DEFAULT 1,
    "group" text,
    CONSTRAINT question_pkey PRIMARY KEY (id),
    CONSTRAINT question_role_id_fkey FOREIGN KEY (role_id)
        REFERENCES public.role (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


-- insert role
insert into "role" values(1, 'PRINCIPAL', 'Hiệu trưởng', null);
insert into "role" values(2, 'VICE_PRINCIPAL', 'Hiệu phó', null);
insert into "role" values(3, 'TEACHER', 'Giáo viên', null);
insert into "role" values(4, 'EMPLOYEE', 'Nhân viên', null);
insert into "role" values(5, 'DIRECTOR', 'Sở giáo dục', null);


-- insert user
insert into "user" values(1, 'hieutruong', '$2a$10$RlMbzy0x40U6t8IohrfF4.2jwsTuoP1SrcHK9TkNv.B48skjTU1aO', 'Hiệu', 'Trưởng', '', 'Hiệu trưởng', false, 1);
insert into "user" values(2, 'hieupho', '$2a$10$RlMbzy0x40U6t8IohrfF4.2jwsTuoP1SrcHK9TkNv.B48skjTU1aO', 'Hiệu', 'Phó', '', 'Hiệu phó', false, 2);
insert into "user" values(3, 'giaovien', '$2a$10$RlMbzy0x40U6t8IohrfF4.2jwsTuoP1SrcHK9TkNv.B48skjTU1aO', 'Giáo', 'Viên', '1', 'Giáo viên', false, 3);
insert into "user" values(4, 'nhanvien', '$2a$10$RlMbzy0x40U6t8IohrfF4.2jwsTuoP1SrcHK9TkNv.B48skjTU1aO', 'Nhân', 'Viên', '2', 'Nhân viên', false, 4);
insert into "user" values(5, 'director', '$2a$10$RlMbzy0x40U6t8IohrfF4.2jwsTuoP1SrcHK9TkNv.B48skjTU1aO', 'Sở', 'Giáo Dục', '', 'Sở giáo dục', false, 5);
insert into "user" values(6, 'totruonggiaovien', '$2a$10$RlMbzy0x40U6t8IohrfF4.2jwsTuoP1SrcHK9TkNv.B48skjTU1aO', 'Tổ Trưởng', 'Giáo Viên', '1', 'Tổ trưởng giáo viên', true, 3);
insert into "user" values(7, 'totruongnhanvien', '$2a$10$RlMbzy0x40U6t8IohrfF4.2jwsTuoP1SrcHK9TkNv.B48skjTU1aO', 'Tổ Trưởng', 'Nhân Viên', '2', 'Tổ trưởng nhân viên', false, 4);


