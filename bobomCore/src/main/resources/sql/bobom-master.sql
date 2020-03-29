CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TABLE IF EXISTS public.category_group_names CASCADE;
CREATE TABLE public.category_group_names
(
    id      uuid NOT NULL DEFAULT uuid_generate_v4(),
    name_en text NOT NULL,
    name_de text NOT NULL,
    name_hu text NOT NULL,
    CONSTRAINT category_group_names_pkey PRIMARY KEY (id)
);


DROP TABLE IF EXISTS public.category_names CASCADE;
CREATE TABLE public.category_names
(
    id      uuid NOT NULL DEFAULT uuid_generate_v4(),
    name_en text NOT NULL,
    name_de text NOT NULL,
    name_hu text NOT NULL,
    CONSTRAINT category_names_pkey PRIMARY KEY (id)
);
ALTER TABLE public.category_names
    OWNER TO postgres;

DROP TABLE IF EXISTS public.item_names CASCADE;
CREATE TABLE public.item_names
(
    id      uuid NOT NULL,
    name_en text NOT NULL,
    name_de text NOT NULL,
    name_hu text NOT NULL,
    CONSTRAINT item_names_pkey PRIMARY KEY (id)
);
ALTER TABLE public.item_names
    OWNER TO postgres;

DROP TABLE IF EXISTS public.material_names CASCADE;
CREATE TABLE public.material_names
(
    id      uuid NOT NULL DEFAULT uuid_generate_v4(),
    name_en text NOT NULL,
    name_de text NOT NULL,
    name_hu text NOT NULL,
    CONSTRAINT material_names_pkey PRIMARY KEY (id)
);
ALTER TABLE public.material_names
    OWNER TO postgres;

DROP TABLE IF EXISTS public.parameter_names CASCADE;
CREATE TABLE public.parameter_names
(
    id      uuid NOT NULL DEFAULT uuid_generate_v4(),
    name_en text NOT NULL,
    name_de text NOT NULL,
    name_hu text NOT NULL,
    CONSTRAINT parameter_names_pkey PRIMARY KEY (id)
);
ALTER TABLE public.parameter_names
    OWNER TO postgres;

DROP TABLE IF EXISTS public.quantity_names CASCADE;
CREATE TABLE public.quantity_names
(
    id      uuid NOT NULL DEFAULT uuid_generate_v4(),
    name_en text NOT NULL,
    name_de text NOT NULL,
    name_hu text NOT NULL,
    CONSTRAINT quantity_names_pkey PRIMARY KEY (id)
);
ALTER TABLE public.quantity_names
    OWNER TO postgres;

DROP TABLE IF EXISTS public.standard_names CASCADE;
CREATE TABLE public.standard_names
(
    id      uuid NOT NULL DEFAULT uuid_generate_v4(),
    name_en text NOT NULL,
    name_de text NOT NULL,
    name_hu text NOT NULL,
    CONSTRAINT standard_names_pkey PRIMARY KEY (id)
);
ALTER TABLE public.standard_names
    OWNER TO postgres;

DROP TABLE IF EXISTS public.unit_names CASCADE;
CREATE TABLE public.unit_names
(
    id      uuid NOT NULL DEFAULT uuid_generate_v4(),
    name_en text NOT NULL,
    name_de text NOT NULL,
    name_hu text NOT NULL,
    CONSTRAINT unit_names_pkey PRIMARY KEY (id)
);
ALTER TABLE public.unit_names
    OWNER TO postgres;

DROP TABLE IF EXISTS public.unit_symbols CASCADE;
CREATE TABLE public.unit_symbols
(
    id      uuid NOT NULL DEFAULT uuid_generate_v4(),
    name_en text NOT NULL,
    name_de text NOT NULL,
    name_hu text NOT NULL,
    CONSTRAINT unit_symbols_pkey PRIMARY KEY (id)
);
ALTER TABLE public.unit_symbols
    OWNER TO postgres;

DROP TABLE IF EXISTS public.category_groups CASCADE;
CREATE TABLE public.category_groups
(
    id                  uuid NOT NULL DEFAULT uuid_generate_v4(),
    category_group_name uuid NOT NULL,
    description         text,
    CONSTRAINT category_groups_pkey PRIMARY KEY (id),
    CONSTRAINT category_group_name_fkey FOREIGN KEY (category_group_name) REFERENCES public.category_group_names (id) ON UPDATE NO ACTION ON DELETE RESTRICT
);
ALTER TABLE public.category_groups
    OWNER TO postgres;

DROP TABLE IF EXISTS public.materials CASCADE;
CREATE TABLE public.materials
(
    id              uuid NOT NULL DEFAULT uuid_generate_v4(),
    material_name   uuid NOT NULL,
    material_number text NOT NULL,
    description     text,
    CONSTRAINT materials_pkey PRIMARY KEY (id),
    CONSTRAINT material_name_fkey FOREIGN KEY (material_name) REFERENCES public.material_names (id) ON UPDATE NO ACTION ON DELETE RESTRICT,
    CONSTRAINT materials_material_number_key UNIQUE (material_number)
);
ALTER TABLE public.materials
    OWNER TO postgres;

DROP TABLE IF EXISTS public.quantities CASCADE;
CREATE TABLE public.quantities
(
    id            uuid NOT NULL DEFAULT uuid_generate_v4(),
    quantity_name uuid NOT NULL,
    description   text,
    CONSTRAINT quantities_pkey PRIMARY KEY (id),
    CONSTRAINT quantity_name_fkey FOREIGN KEY (quantity_name) REFERENCES public.quantity_names (id) ON UPDATE NO ACTION ON DELETE RESTRICT
);
ALTER TABLE public.quantities
    OWNER TO postgres;

DROP TABLE IF EXISTS public.standards CASCADE;
CREATE TABLE public.standards
(
    id              uuid NOT NULL DEFAULT uuid_generate_v4(),
    standard_name   uuid NOT NULL,
    standard_number text NOT NULL,
    description     text,
    CONSTRAINT standards_pkey PRIMARY KEY (id),
    CONSTRAINT standard_name_fkey FOREIGN KEY (standard_name) REFERENCES public.standard_names (id) ON UPDATE NO ACTION ON DELETE RESTRICT
);
ALTER TABLE public.standards
    OWNER TO postgres;

DROP TABLE IF EXISTS public.items CASCADE;
CREATE TABLE public.items
(
    id          uuid    NOT NULL DEFAULT uuid_generate_v4(),
    item_number text    NOT NULL,
    item_name   uuid    NOT NULL,
    revision    integer NOT NULL,
    status      integer NOT NULL,
    unit        uuid    NOT NULL,
    description text,
    CONSTRAINT items_pkey PRIMARY KEY (id),
    CONSTRAINT item_name_fkey FOREIGN KEY (item_name) REFERENCES public.item_names (id) ON UPDATE NO ACTION ON DELETE RESTRICT,
    CONSTRAINT item_unit_fkey FOREIGN KEY (unit) REFERENCES public.units (id) ON UPDATE NO ACTION ON DELETE RESTRICT,
    CONSTRAINT items_item_number_key UNIQUE (item_number)
);
ALTER TABLE public.items
    OWNER TO postgres;


DROP TABLE IF EXISTS public.categories CASCADE;
CREATE TABLE public.categories
(
    id             uuid NOT NULL DEFAULT uuid_generate_v4(),
    category_name  uuid NOT NULL,
    category_group uuid NOT NULL,
    description    text,
    CONSTRAINT categories_pkey PRIMARY KEY (id),
    CONSTRAINT category_name_fkey FOREIGN KEY (category_name) REFERENCES public.category_names (id) ON UPDATE NO ACTION ON DELETE RESTRICT,
    CONSTRAINT category_group_fkey FOREIGN KEY (category_group) REFERENCES public.category_groups (id) ON UPDATE NO ACTION ON DELETE RESTRICT
);
ALTER TABLE public.categories
    OWNER TO postgres;

DROP TABLE IF EXISTS public.item_categories CASCADE;
CREATE TABLE public.item_categories
(
    id       uuid NOT NULL DEFAULT uuid_generate_v4(),
    item     uuid NOT NULL,
    category uuid NOT NULL,
    CONSTRAINT item_categories_pkey PRIMARY KEY (id),
    CONSTRAINT item_category_item_fkey FOREIGN KEY (item) REFERENCES public.items (id) ON UPDATE NO ACTION ON DELETE RESTRICT,
    CONSTRAINT item_category_category_fkey FOREIGN KEY (category) REFERENCES public.categories (id) ON UPDATE NO ACTION ON DELETE RESTRICT
);
ALTER TABLE public.item_categories
    OWNER TO postgres;

DROP TABLE IF EXISTS public.item_standards CASCADE;
CREATE TABLE public.item_standards
(
    id       uuid NOT NULL DEFAULT uuid_generate_v4(),
    item     uuid NOT NULL,
    standard uuid NOT NULL,
    CONSTRAINT item_standards_pkey PRIMARY KEY (id),
    CONSTRAINT item_standard_item_fkey FOREIGN KEY (item) REFERENCES public.items (id) ON UPDATE NO ACTION ON DELETE RESTRICT,
    CONSTRAINT item_standard_standard_fkey FOREIGN KEY (standard) REFERENCES public.standards (id) ON UPDATE NO ACTION ON DELETE RESTRICT
);
ALTER TABLE public.item_standards
    OWNER TO postgres;

DROP TABLE IF EXISTS public.item_materials CASCADE;
CREATE TABLE public.item_materials
(
    id       uuid NOT NULL DEFAULT uuid_generate_v4(),
    item     uuid NOT NULL,
    material uuid NOT NULL,
    CONSTRAINT item_materials_pkey PRIMARY KEY (id),
    CONSTRAINT item_material_item_fkey FOREIGN KEY (item) REFERENCES public.items (id) ON UPDATE NO ACTION ON DELETE RESTRICT,
    CONSTRAINT item_material_material_fkey FOREIGN KEY (material) REFERENCES public.materials (id) ON UPDATE NO ACTION ON DELETE RESTRICT
);
ALTER TABLE public.item_materials
    OWNER TO postgres;

DROP TABLE IF EXISTS public.material_standards CASCADE;
CREATE TABLE public.material_standards
(
    id       uuid NOT NULL DEFAULT uuid_generate_v4(),
    material uuid NOT NULL,
    standard uuid NOT NULL,
    CONSTRAINT material_standards_pkey PRIMARY KEY (id),
    CONSTRAINT material_standard_material_fkey FOREIGN KEY (material) REFERENCES public.materials (id) ON UPDATE NO ACTION ON DELETE RESTRICT,
    CONSTRAINT material_standard_standard_fkey FOREIGN KEY (standard) REFERENCES public.standards (id) ON UPDATE NO ACTION ON DELETE RESTRICT
);
ALTER TABLE public.material_standards
    OWNER TO postgres;

DROP TABLE IF EXISTS public.units CASCADE;
CREATE TABLE public.units
(
    id            uuid NOT NULL DEFAULT uuid_generate_v4(),
    unit_name     uuid NOT NULL,
    unit_symbol   uuid NOT NULL,
    unit_quantity uuid NOT NULL,
    description   text,
    CONSTRAINT units_pkey PRIMARY KEY (id),
    CONSTRAINT unit_name_fkey FOREIGN KEY (unit_name) REFERENCES public.unit_names (id) ON UPDATE NO ACTION ON DELETE RESTRICT,
    CONSTRAINT unit_symbol_fkey FOREIGN KEY (unit_symbol) REFERENCES public.unit_symbols (id) ON UPDATE NO ACTION ON DELETE RESTRICT,
    CONSTRAINT unit_quantity_fkey FOREIGN KEY (unit_quantity) REFERENCES public.quantities (id) ON UPDATE NO ACTION ON DELETE RESTRICT
);
ALTER TABLE public.units
    OWNER TO postgres;

DROP TABLE IF EXISTS public.parameters CASCADE;
CREATE TABLE public.parameters
(
    id             uuid NOT NULL DEFAULT uuid_generate_v4(),
    parameter_name uuid NOT NULL,
    parameter_unit uuid NOT NULL,
    description    text,
    CONSTRAINT parameters_pkey PRIMARY KEY (id),
    CONSTRAINT parameter_name_fkey FOREIGN KEY (parameter_name) REFERENCES public.parameter_names (id) ON UPDATE NO ACTION ON DELETE RESTRICT,
    CONSTRAINT parameter_unit_fkey FOREIGN KEY (parameter_unit) REFERENCES public.units (id) ON UPDATE NO ACTION ON DELETE RESTRICT
);
ALTER TABLE public.parameters
    OWNER TO postgres;

DROP TABLE IF EXISTS public.parameter_symbols CASCADE;
CREATE TABLE public.parameter_symbols
(
    id        uuid NOT NULL DEFAULT uuid_generate_v4(),
    parameter uuid NOT NULL,
    pos       text NOT NULL,
    symbol    text NOT NULL,
    CONSTRAINT parameter_symbols_pkey PRIMARY KEY (id),
    CONSTRAINT parameter_fkey FOREIGN KEY (parameter) REFERENCES public.parameters (id) ON UPDATE NO ACTION ON DELETE RESTRICT
);
ALTER TABLE public.parameter_symbols
    OWNER TO postgres;

DROP TABLE IF EXISTS public.unit_convert_values CASCADE;
CREATE TABLE public.unit_convert_values
(
    id            uuid    NOT NULL DEFAULT uuid_generate_v4(),
    from_unit     uuid    NOT NULL,
    to_unit       uuid    NOT NULL,
    convert_value numeric NOT NULL,
    CONSTRAINT unit_convert_values_pkey PRIMARY KEY (id),
    CONSTRAINT unit_convert_value_from_unit_fkey FOREIGN KEY (from_unit) REFERENCES public.units (id) ON UPDATE NO ACTION ON DELETE RESTRICT,
    CONSTRAINT unit_convert_value_to_unit_fkey FOREIGN KEY (to_unit) REFERENCES public.units (id) ON UPDATE NO ACTION ON DELETE RESTRICT
);
ALTER TABLE public.unit_convert_values
    OWNER TO postgres;

DROP TABLE IF EXISTS public.parameter_values CASCADE;
CREATE TABLE public.parameter_values
(
    id            uuid    NOT NULL DEFAULT uuid_generate_v4(),
    item_category uuid    NOT NULL,
    parameter     uuid    NOT NULL,
    val           numeric NOT NULL,
    CONSTRAINT parameter_values_pkey PRIMARY KEY (id),
    CONSTRAINT item_category_fkey FOREIGN KEY (item_category) REFERENCES public.item_categories (id) ON UPDATE NO ACTION ON DELETE CASCADE,
    CONSTRAINT parameter_fkey FOREIGN KEY (parameter) REFERENCES public.parameters (id) ON UPDATE NO ACTION ON DELETE RESTRICT
);
ALTER TABLE public.parameter_values
    OWNER TO postgres;

DROP TABLE IF EXISTS public.category_parameters CASCADE;
CREATE TABLE public.category_parameters
(
    id        uuid    NOT NULL DEFAULT uuid_generate_v4(),
    seq       integer NOT NULL,
    category  uuid    NOT NULL,
    parameter uuid    NOT NULL,
    CONSTRAINT category_parameters_pkey PRIMARY KEY (id),
    CONSTRAINT category_parameter_category_fkey FOREIGN KEY (category) REFERENCES public.categories (id) ON UPDATE NO ACTION ON DELETE RESTRICT,
    CONSTRAINT category_parameter_parameter_fkey FOREIGN KEY (parameter) REFERENCES public.parameters (id) ON UPDATE NO ACTION ON DELETE RESTRICT
);
ALTER TABLE public.category_parameters
    OWNER TO postgres;

DROP TABLE IF EXISTS public.material_parameters CASCADE;
CREATE TABLE public.material_parameters
(
    id        uuid    NOT NULL DEFAULT uuid_generate_v4(),
    seq       integer NOT NULL,
    material  uuid    NOT NULL,
    parameter uuid    NOT NULL,
    val       numeric NOT NULL,
    CONSTRAINT material_parameters_pkey PRIMARY KEY (id),
    CONSTRAINT material_parameter_material_fkey FOREIGN KEY (material) REFERENCES public.materials (id) ON UPDATE NO ACTION ON DELETE CASCADE,
    CONSTRAINT material_parameter_parameter_fkey FOREIGN KEY (parameter) REFERENCES public.parameters (id) ON UPDATE NO ACTION ON DELETE RESTRICT
);
ALTER TABLE public.category_parameters
    OWNER TO postgres;

DROP TABLE IF EXISTS public.boms CASCADE;
CREATE TABLE public.boms
(
    id        uuid    NOT NULL DEFAULT uuid_generate_v4(),
    assembly  uuid    NOT NULL,
    seq       integer NOT NULL,
    component uuid    NOT NULL,
    quantity  numeric NOT NULL,
    CONSTRAINT boms_pkey PRIMARY KEY (id),
    CONSTRAINT bom_assembly_fkey FOREIGN KEY (assembly) REFERENCES public.items (id) ON UPDATE NO ACTION ON DELETE RESTRICT,
    CONSTRAINT bom_component_fkey FOREIGN KEY (component) REFERENCES public.items (id) ON UPDATE NO ACTION ON DELETE RESTRICT,
    CONSTRAINT unique_assembly_seq UNIQUE (assembly, seq)
);
ALTER TABLE public.boms
    OWNER TO postgres;

DROP TABLE IF EXISTS public.users CASCADE;
CREATE TABLE public.users
(
    id            uuid NOT NULL DEFAULT uuid_generate_v4(),
    user_email    text NOT NULL,
    user_name     text NOT NULL,
    user_password text NOT NULL,
    user_locale   text NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT unique_email UNIQUE (user_email),
    CONSTRAINT unique_name UNIQUE (user_name)
);
ALTER TABLE public.users
    OWNER TO postgres;
