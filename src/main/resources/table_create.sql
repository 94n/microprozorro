CREATE TABLE public.product
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT product_pkey PRIMARY KEY (id)
)