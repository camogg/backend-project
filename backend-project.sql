--
-- PostgreSQL database dump
--

-- Dumped from database version 12.1
-- Dumped by pg_dump version 12.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: courses; Type: TABLE; Schema: public; Owner: swisswar
--

CREATE TABLE public.courses (
    id integer NOT NULL,
    name text NOT NULL,
    start_time text,
    end_time text,
    teacher_id integer NOT NULL
);


ALTER TABLE public.courses OWNER TO swisswar;

--
-- Name: courses_id_seq; Type: SEQUENCE; Schema: public; Owner: swisswar
--

CREATE SEQUENCE public.courses_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.courses_id_seq OWNER TO swisswar;

--
-- Name: courses_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: swisswar
--

ALTER SEQUENCE public.courses_id_seq OWNED BY public.courses.id;


--
-- Name: enrollments; Type: TABLE; Schema: public; Owner: swisswar
--

CREATE TABLE public.enrollments (
    id integer NOT NULL,
    student_id integer NOT NULL,
    course_id integer NOT NULL,
    grade integer DEFAULT 0
);


ALTER TABLE public.enrollments OWNER TO swisswar;

--
-- Name: enrollments_course_id_seq; Type: SEQUENCE; Schema: public; Owner: swisswar
--

CREATE SEQUENCE public.enrollments_course_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.enrollments_course_id_seq OWNER TO swisswar;

--
-- Name: enrollments_course_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: swisswar
--

ALTER SEQUENCE public.enrollments_course_id_seq OWNED BY public.enrollments.course_id;


--
-- Name: enrollments_id_seq; Type: SEQUENCE; Schema: public; Owner: swisswar
--

CREATE SEQUENCE public.enrollments_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.enrollments_id_seq OWNER TO swisswar;

--
-- Name: enrollments_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: swisswar
--

ALTER SEQUENCE public.enrollments_id_seq OWNED BY public.enrollments.id;


--
-- Name: enrollments_student_id_seq; Type: SEQUENCE; Schema: public; Owner: swisswar
--

CREATE SEQUENCE public.enrollments_student_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.enrollments_student_id_seq OWNER TO swisswar;

--
-- Name: enrollments_student_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: swisswar
--

ALTER SEQUENCE public.enrollments_student_id_seq OWNED BY public.enrollments.student_id;


--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: swisswar
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO swisswar;

--
-- Name: students; Type: TABLE; Schema: public; Owner: swisswar
--

CREATE TABLE public.students (
    id integer NOT NULL,
    firstname text NOT NULL,
    lastname text NOT NULL
);


ALTER TABLE public.students OWNER TO swisswar;

--
-- Name: student_id_seq; Type: SEQUENCE; Schema: public; Owner: swisswar
--

CREATE SEQUENCE public.student_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.student_id_seq OWNER TO swisswar;

--
-- Name: student_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: swisswar
--

ALTER SEQUENCE public.student_id_seq OWNED BY public.students.id;


--
-- Name: students_id_seq; Type: SEQUENCE; Schema: public; Owner: swisswar
--

CREATE SEQUENCE public.students_id_seq
    START WITH 2
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.students_id_seq OWNER TO swisswar;

--
-- Name: teachers; Type: TABLE; Schema: public; Owner: swisswar
--

CREATE TABLE public.teachers (
    id integer NOT NULL,
    firstname text NOT NULL,
    lastname text NOT NULL
);


ALTER TABLE public.teachers OWNER TO swisswar;

--
-- Name: teachers_id_seq; Type: SEQUENCE; Schema: public; Owner: swisswar
--

CREATE SEQUENCE public.teachers_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.teachers_id_seq OWNER TO swisswar;

--
-- Name: teachers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: swisswar
--

ALTER SEQUENCE public.teachers_id_seq OWNED BY public.teachers.id;


--
-- Name: courses id; Type: DEFAULT; Schema: public; Owner: swisswar
--

ALTER TABLE ONLY public.courses ALTER COLUMN id SET DEFAULT nextval('public.courses_id_seq'::regclass);


--
-- Name: enrollments id; Type: DEFAULT; Schema: public; Owner: swisswar
--

ALTER TABLE ONLY public.enrollments ALTER COLUMN id SET DEFAULT nextval('public.enrollments_id_seq'::regclass);


--
-- Name: enrollments student_id; Type: DEFAULT; Schema: public; Owner: swisswar
--

ALTER TABLE ONLY public.enrollments ALTER COLUMN student_id SET DEFAULT nextval('public.enrollments_student_id_seq'::regclass);


--
-- Name: enrollments course_id; Type: DEFAULT; Schema: public; Owner: swisswar
--

ALTER TABLE ONLY public.enrollments ALTER COLUMN course_id SET DEFAULT nextval('public.enrollments_course_id_seq'::regclass);


--
-- Name: students id; Type: DEFAULT; Schema: public; Owner: swisswar
--

ALTER TABLE ONLY public.students ALTER COLUMN id SET DEFAULT nextval('public.student_id_seq'::regclass);


--
-- Name: teachers id; Type: DEFAULT; Schema: public; Owner: swisswar
--

ALTER TABLE ONLY public.teachers ALTER COLUMN id SET DEFAULT nextval('public.teachers_id_seq'::regclass);


--
-- Data for Name: courses; Type: TABLE DATA; Schema: public; Owner: swisswar
--

INSERT INTO public.courses VALUES (0, 'Server Programming', '0', '0', 0);
INSERT INTO public.courses VALUES (5, 'Updated course', '14:00', '15:00', 0);


--
-- Data for Name: enrollments; Type: TABLE DATA; Schema: public; Owner: swisswar
--

INSERT INTO public.enrollments VALUES (1, 1, 0, 0);
INSERT INTO public.enrollments VALUES (10, 0, 0, 3);
INSERT INTO public.enrollments VALUES (11, 0, 5, 3);
INSERT INTO public.enrollments VALUES (12, 0, 0, 3);
INSERT INTO public.enrollments VALUES (0, 0, 0, 5);


--
-- Data for Name: students; Type: TABLE DATA; Schema: public; Owner: swisswar
--

INSERT INTO public.students VALUES (0, 'Camille', 'Oggier');
INSERT INTO public.students VALUES (1, 'Mathias', 'Tanner');
INSERT INTO public.students VALUES (2, 'John', 'Doe');
INSERT INTO public.students VALUES (54, 'John', 'Doe');
INSERT INTO public.students VALUES (55, 'John', 'Doe');
INSERT INTO public.students VALUES (56, 'John', 'Doe');
INSERT INTO public.students VALUES (57, 'John', 'Doe');


--
-- Data for Name: teachers; Type: TABLE DATA; Schema: public; Owner: swisswar
--

INSERT INTO public.teachers VALUES (0, 'Juha', 'Hinkula');
INSERT INTO public.teachers VALUES (1, 'John', 'Doe');
INSERT INTO public.teachers VALUES (2, 'John', 'Doe');
INSERT INTO public.teachers VALUES (4, 'John', 'Doe');
INSERT INTO public.teachers VALUES (3, 'Jacky', 'Chan');
INSERT INTO public.teachers VALUES (8, 'Patrick', 'Jackson');


--
-- Name: courses_id_seq; Type: SEQUENCE SET; Schema: public; Owner: swisswar
--

SELECT pg_catalog.setval('public.courses_id_seq', 1, false);


--
-- Name: enrollments_course_id_seq; Type: SEQUENCE SET; Schema: public; Owner: swisswar
--

SELECT pg_catalog.setval('public.enrollments_course_id_seq', 1, false);


--
-- Name: enrollments_id_seq; Type: SEQUENCE SET; Schema: public; Owner: swisswar
--

SELECT pg_catalog.setval('public.enrollments_id_seq', 1, false);


--
-- Name: enrollments_student_id_seq; Type: SEQUENCE SET; Schema: public; Owner: swisswar
--

SELECT pg_catalog.setval('public.enrollments_student_id_seq', 1, false);


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: swisswar
--

SELECT pg_catalog.setval('public.hibernate_sequence', 14, true);


--
-- Name: student_id_seq; Type: SEQUENCE SET; Schema: public; Owner: swisswar
--

SELECT pg_catalog.setval('public.student_id_seq', 1, false);


--
-- Name: students_id_seq; Type: SEQUENCE SET; Schema: public; Owner: swisswar
--

SELECT pg_catalog.setval('public.students_id_seq', 102, true);


--
-- Name: teachers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: swisswar
--

SELECT pg_catalog.setval('public.teachers_id_seq', 1, false);


--
-- Name: courses courses_pkey; Type: CONSTRAINT; Schema: public; Owner: swisswar
--

ALTER TABLE ONLY public.courses
    ADD CONSTRAINT courses_pkey PRIMARY KEY (id);


--
-- Name: enrollments enrollments_pkey; Type: CONSTRAINT; Schema: public; Owner: swisswar
--

ALTER TABLE ONLY public.enrollments
    ADD CONSTRAINT enrollments_pkey PRIMARY KEY (id);


--
-- Name: students student_pkey; Type: CONSTRAINT; Schema: public; Owner: swisswar
--

ALTER TABLE ONLY public.students
    ADD CONSTRAINT student_pkey PRIMARY KEY (id);


--
-- Name: teachers teachers_pkey; Type: CONSTRAINT; Schema: public; Owner: swisswar
--

ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_pkey PRIMARY KEY (id);


--
-- Name: courses courses_teacher_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: swisswar
--

ALTER TABLE ONLY public.courses
    ADD CONSTRAINT courses_teacher_id_fkey FOREIGN KEY (teacher_id) REFERENCES public.teachers(id);


--
-- Name: enrollments enrollments_course_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: swisswar
--

ALTER TABLE ONLY public.enrollments
    ADD CONSTRAINT enrollments_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.courses(id);


--
-- Name: enrollments enrollments_student_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: swisswar
--

ALTER TABLE ONLY public.enrollments
    ADD CONSTRAINT enrollments_student_id_fkey FOREIGN KEY (student_id) REFERENCES public.students(id);


--
-- PostgreSQL database dump complete
--

