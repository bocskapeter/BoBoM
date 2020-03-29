INSERT INTO public.item_names (id, name_en, name_de, name_hu)
VALUES ('c0885ca3-b9a9-4ced-a4c7-eda56e625581', 'Nut', 'Mutter', 'Anya');
INSERT INTO public.item_names (id, name_en, name_de, name_hu)
VALUES ('e6494e79-9c4b-4094-bbef-3515fdce4516', 'Plate', 'Blech', 'Lemez');

INSERT INTO public.items (id, item_number, item_name, revision, status, unit, description)
VALUES ('42e8cb49-2c24-4a97-abfe-b35c7e44135a', '0000-0000-0000-0001', 'c0885ca3-b9a9-4ced-a4c7-eda56e625581', 1, 1,
        '453cf498-429f-4b68-9801-16655e4a3b40',
        'Nut');
INSERT INTO public.items (id, item_number, item_name, revision, status, unit, description)
VALUES ('72c145a0-2348-4b13-a699-e361111dcc52', '0000-0000-0000-0002', 'e6494e79-9c4b-4094-bbef-3515fdce4516', 1, 1,
        '453cf498-429f-4b68-9801-16655e4a3b40',
        'Plate');

INSERT INTO public.quantity_names (id, name_en, name_de, name_hu)
VALUES ('7e3564ee-5061-4519-8d08-844154912cfe', 'dimensionless quantity', 'dimensionslose Größe',
        'dimenziómentes mennyiség');
INSERT INTO public.quantity_names (id, name_en, name_de, name_hu)
VALUES ('8e6ee72c-825f-4b10-a22b-a4a4c65717a5', 'length', 'Längenmaßeinheit', 'hosszúság');
INSERT INTO public.quantity_names (id, name_en, name_de, name_hu)
VALUES ('fdbe28ad-c5cb-40cb-a30a-a5c7b751e850', 'time', 'Zeit', 'idő');
INSERT INTO public.quantity_names (id, name_en, name_de, name_hu)
VALUES ('f7b87087-d367-4fdf-ace0-f3a3402a2925', 'mass', 'Masse', 'tömeg');
INSERT INTO public.quantity_names (id, name_en, name_de, name_hu)
VALUES ('2813116c-5ed8-4ba4-a366-f6d54baba3aa', 'temperature', 'Temperatur', 'hőmérséklet');
INSERT INTO public.quantity_names (id, name_en, name_de, name_hu)
VALUES ('d8739071-d1bc-4c25-90de-8683d34b5875', 'angle', 'Winkel', 'szög');
INSERT INTO public.quantity_names (id, name_en, name_de, name_hu)
VALUES ('ed5ba67a-fe04-4eb3-8ba2-a5757235a22c', 'electric current', 'elektrische Strom', 'elektromos áram');
INSERT INTO public.quantity_names (id, name_en, name_de, name_hu)
VALUES ('5ba706fb-4d55-4557-872f-c2ebd7567fb9', 'amount of substance', 'Stoffmenge', 'anyagmennyiség');
INSERT INTO public.quantity_names (id, name_en, name_de, name_hu)
VALUES ('1356206e-453b-45fe-acdd-0005bc2a6551', 'luminous intensity', 'Lichtstärke', 'fényerősség');
INSERT INTO public.quantity_names (id, name_en, name_de, name_hu)
VALUES ('0e61fb2b-1a8e-4056-bbb0-17168100170e', 'solid angle', 'Raumwinkel', 'térszög');
INSERT INTO public.quantity_names (id, name_en, name_de, name_hu)
VALUES ('e019d100-9fcb-47c2-93df-30a149236bd5', 'volumetric mass density', 'Massendichte', 'térfogat sűrűség');

INSERT INTO public.quantities (id, quantity_name, description)
VALUES ('34d1f758-bd09-4d17-9023-4eb3b362813f', '7e3564ee-5061-4519-8d08-844154912cfe',
        'A dimensionless quantity (or more precisely, a quantity with the dimensions of 1) is a quantity without any physical units and thus a pure number.');
INSERT INTO public.quantities (id, quantity_name, description)
VALUES ('3e4cd054-2739-4d37-b5d4-8943d0b7271d', '8e6ee72c-825f-4b10-a22b-a4a4c65717a5',
        'Length is a measure of distance.');
INSERT INTO public.quantities (id, quantity_name, description)
VALUES ('199e3b26-416e-4f77-92bb-06dada273bda', 'f7b87087-d367-4fdf-ace0-f3a3402a2925',
        'Mass is both a property of a physical body and a measure of its resistance to acceleration (a change in its state of motion) when a net force is applied.');
INSERT INTO public.quantities (id, quantity_name, description)
VALUES ('a4633e6e-1ef9-4098-81d7-5992f2ac5feb', 'fdbe28ad-c5cb-40cb-a30a-a5c7b751e850',
        'Time is the indefinite continued progress of existence and events that occur in an apparently irreversible succession from the past, through the present, to the future.');
INSERT INTO public.quantities (id, quantity_name, description)
VALUES ('8c31f6df-7f76-4607-acc4-dbb45b06fc5e', '2813116c-5ed8-4ba4-a366-f6d54baba3aa',
        'Temperature is a physical quantity expressing hot and cold.');
INSERT INTO public.quantities (id, quantity_name, description)
VALUES ('f27a2ecb-a1f9-4fd4-b919-356ac4956ea8', 'd8739071-d1bc-4c25-90de-8683d34b5875',
        'In plane geometry, an angle is the figure formed by two rays, called the sides of the angle, sharing a common endpoint, called the vertex of the angle.');
INSERT INTO public.quantities (id, quantity_name, description)
VALUES ('6e3572ae-cc6a-4aa1-9a63-5ab3b25eab1f', 'ed5ba67a-fe04-4eb3-8ba2-a5757235a22c',
        'An electric current is the rate of flow of electric charge past a point  or region.');
INSERT INTO public.quantities (id, quantity_name, description)
VALUES ('eb7c800f-9c45-4826-a854-3b569b6e0443', '5ba706fb-4d55-4557-872f-c2ebd7567fb9',
        'The amount of substance in a given sample of matter is the number of discrete atomic-scale particles in it; where the particles may be molecules, atoms, ions, electrons, or other, depending on the context. It is sometimes referred to as the chemical amount.');
INSERT INTO public.quantities (id, quantity_name, description)
VALUES ('81227171-a58b-41ff-a4c9-03a4a47fb65e', '1356206e-453b-45fe-acdd-0005bc2a6551',
        'Luminous intensity is a measure of the wavelength-weighted power emitted by a light source in a particular direction per unit solid angle, based on the luminosity function, a standardized model of the sensitivity of the human eye.');
INSERT INTO public.quantities (id, quantity_name, description)
VALUES ('088d7bd7-43a8-49c4-a120-5ea5c6da8212', '0e61fb2b-1a8e-4056-bbb0-17168100170e',
        'A solid angle is a measure of the amount of the field of view from some particular point that a given object covers.');
INSERT INTO public.quantities (id, quantity_name, description)
VALUES ('b2effbaf-95c7-4770-b3e2-1d99c1592641', 'e019d100-9fcb-47c2-93df-30a149236bd5',
        'The density (more precisely, the volumetric mass density; also known as specific mass), of a substance is its mass per unit volume.');

INSERT INTO public.unit_names (id, name_en, name_de, name_hu)
VALUES ('6d74f1f0-92ca-4543-bea4-489691fd5177', 'each', 'Stück', 'darab');
INSERT INTO public.unit_names (id, name_en, name_de, name_hu)
VALUES ('9b7709c8-ab3e-47b1-917d-63c022a766f3', 'metre', 'Meter', 'méter');
INSERT INTO public.unit_names (id, name_en, name_de, name_hu)
VALUES ('7cfe82ba-cdeb-4d4e-ad9f-41d72d7b8df5', 'kilogram', 'Kilogramm', 'kilogramm');
INSERT INTO public.unit_names (id, name_en, name_de, name_hu)
VALUES ('407b4f9f-3617-4acf-a0b3-365d74707ae2', 'second', 'Sekunde', 'másodperc');
INSERT INTO public.unit_names (id, name_en, name_de, name_hu)
VALUES ('ebbc9ea9-2052-4a2f-9a58-b5a97344d171', 'millimetre', 'Millimeter', 'milliméter');
INSERT INTO public.unit_names (id, name_en, name_de, name_hu)
VALUES ('c7d70a07-d735-4f89-8104-18653cb1ec5d', 'kilogram per cubic metre', 'Kilogramm pro Kubikmeter',
        'kilogramm per köbméter');
INSERT INTO public.unit_names (id, name_en, name_de, name_hu)
VALUES ('af861ead-1a19-4912-abaa-e9f1421388c2', 'kilogram per cubic deci metre', 'Kilogramm pro Kubikdecimeter',
        'kilogramm per köbdeciméter');

INSERT INTO public.unit_symbols (id, name_en, name_de, name_hu)
VALUES ('9519eff2-f3d0-47ac-8c58-840f365bb1d8', 'kg/m³', 'kg/m³', 'kg/m³');
INSERT INTO public.unit_symbols (id, name_en, name_de, name_hu)
VALUES ('2e4a15ed-ccaa-4760-9474-1a977d2e54af', 'kg/dm³', 'kg/dm³', 'kg/dm³');
INSERT INTO public.unit_symbols (id, name_en, name_de, name_hu)
VALUES ('cb123639-3807-4de7-bed6-d5f1f7dda6a3', 'mm', 'mm', 'mm');
INSERT INTO public.unit_symbols (id, name_en, name_de, name_hu)
VALUES ('36d56bf2-87fc-4284-9b3b-90f45dbb9e8e', 's', 's', 's');
INSERT INTO public.unit_symbols (id, name_en, name_de, name_hu)
VALUES ('1fa12ab1-81e9-414b-8165-0a46b04725fd', 'EA', 'St', 'db');
INSERT INTO public.unit_symbols (id, name_en, name_de, name_hu)
VALUES ('fe24bc74-cc47-43ce-a0e5-feaea0d5c242', 'm', 'm', 'm');
INSERT INTO public.unit_symbols (id, name_en, name_de, name_hu)
VALUES ('b724df97-83f1-44b1-ba75-5f67ac2aff45', 'kg', 'kg', 'kg');

INSERT INTO public.units (id, unit_name, unit_symbol, unit_quantity, description)
VALUES ('453cf498-429f-4b68-9801-16655e4a3b40', '6d74f1f0-92ca-4543-bea4-489691fd5177',
        '1fa12ab1-81e9-414b-8165-0a46b04725fd',
        '34d1f758-bd09-4d17-9023-4eb3b362813f', 'Arbitrary unit.');
INSERT INTO public.units (id, unit_name, unit_symbol, unit_quantity, description)
VALUES ('260cba9a-3db4-4e7b-98ee-1a87428bb087', '9b7709c8-ab3e-47b1-917d-63c022a766f3',
        'fe24bc74-cc47-43ce-a0e5-feaea0d5c242',
        '3e4cd054-2739-4d37-b5d4-8943d0b7271d',
        'The metre is the base unit of length in the International System of Units (SI).');
INSERT INTO public.units (id, unit_name, unit_symbol, unit_quantity, description)
VALUES ('26954fdf-24cb-4d4d-ad44-39c4a28b474c', '7cfe82ba-cdeb-4d4e-ad9f-41d72d7b8df5',
        'b724df97-83f1-44b1-ba75-5f67ac2aff45',
        '199e3b26-416e-4f77-92bb-06dada273bda',
        'The kilogram is the base unit of mass in the metric system, formally the International System of Units (SI).');
INSERT INTO public.units (id, unit_name, unit_symbol, unit_quantity, description)
VALUES ('0127c46b-40f9-4435-9e0e-35080ad6aa29', '407b4f9f-3617-4acf-a0b3-365d74707ae2',
        '36d56bf2-87fc-4284-9b3b-90f45dbb9e8e',
        'a4633e6e-1ef9-4098-81d7-5992f2ac5feb',
        'The second is the base unit of time in the International System of Units (SI).');
INSERT INTO public.units (id, unit_name, unit_symbol, unit_quantity, description)
VALUES ('94c99782-3c48-4e7f-8c03-da7edebcae12', 'ebbc9ea9-2052-4a2f-9a58-b5a97344d171',
        'cb123639-3807-4de7-bed6-d5f1f7dda6a3',
        '3e4cd054-2739-4d37-b5d4-8943d0b7271d',
        'The millimetre or millimeter (American spelling) is a unit of length in the metric system, equal to one thousandth of a metre, which is the SI base unit of length.');
INSERT INTO public.units (id, unit_name, unit_symbol, unit_quantity, description)
VALUES ('495dc8a6-cb11-46ed-a5a9-dfec317ede55', 'c7d70a07-d735-4f89-8104-18653cb1ec5d',
        '9519eff2-f3d0-47ac-8c58-840f365bb1d8',
        'b2effbaf-95c7-4770-b3e2-1d99c1592641',
        'The SI unit of kilogram per cubic metre (kg/m3) is the most commonly used units for density.');
INSERT INTO public.units (id, unit_name, unit_symbol, unit_quantity, description)
VALUES ('484f782f-e2d9-48ef-b769-61bc39133c5a', 'af861ead-1a19-4912-abaa-e9f1421388c2',
        '2e4a15ed-ccaa-4760-9474-1a977d2e54af',
        'b2effbaf-95c7-4770-b3e2-1d99c1592641', 'Density in kilogram per cubic deci metre.');

INSERT INTO public.category_group_names (id, name_en, name_de, name_hu)
VALUES ('27da7a0b-f8fe-4b34-9d42-806d965c8712', 'pipe', 'Rohr', 'cső');
INSERT INTO public.category_group_names (id, name_en, name_de, name_hu)
VALUES ('8ff43ee7-74aa-44b1-93b8-5044b8d8a6a1', 'sheet metal', 'Blech', 'fémlemez');
INSERT INTO public.category_group_names (id, name_en, name_de, name_hu)
VALUES ('48b8622c-7f3f-455a-a038-63ccdae5e39f', 'nut', 'Mutter', 'csavaranya');
INSERT INTO public.category_group_names (id, name_en, name_de, name_hu)
VALUES ('6bd80e1b-719f-40a9-8070-ba202206399e', 'bolt (screw)', 'Bolzen (Schraube)', 'csavar');

INSERT INTO public.category_groups (id, category_group_name, description)
VALUES ('e7fd9228-bdbf-42b6-818a-45a0a308bf54', '8ff43ee7-74aa-44b1-93b8-5044b8d8a6a1',
        'Sheet metal is metal formed by an industrial process into thin, flat pieces.');
INSERT INTO public.category_groups (id, category_group_name, description)
VALUES ('12fb7acd-82d1-4832-b884-8f4813debaef', '27da7a0b-f8fe-4b34-9d42-806d965c8712',
        'A pipe is a tubular section or hollow cylinder, usually but not necessarily of circular cross-section, used mainly to convey substances which can flow — liquids and gases (fluids), slurries, powders and masses of small solids.');
INSERT INTO public.category_groups (id, category_group_name, description)
VALUES ('136d8080-fc37-463f-bfea-8937816c2fc8', '48b8622c-7f3f-455a-a038-63ccdae5e39f',
        'A nut is a type of fastener with a threaded hole. Nuts are almost always used opposite a mating bolt to fasten a stack of parts together.');
INSERT INTO public.category_groups (id, category_group_name, description)
VALUES ('eb760bb4-ce7e-40a0-b004-2876bbe635b3', '6bd80e1b-719f-40a9-8070-ba202206399e',
        'A screw, or bolt, is a type of fastener characterized by a helical ridge, known as an external thread or just thread, wrapped around a cylinder.');

INSERT INTO public.category_names (id, name_en, name_de, name_hu)
VALUES ('84f52371-eee3-41c2-92e0-0835910a9209', 'sheet metal', 'Blech', 'fémlemez');
INSERT INTO public.category_names (id, name_en, name_de, name_hu)
VALUES ('3fc6d89d-da96-4f0f-847c-614004eeda0b', 'hexagon nut', 'Sechskantmutter', 'hatlapú csavaranya');

INSERT INTO public.categories (id, category_name, category_group, description)
VALUES ('3dc0d66d-0898-4e00-b8ad-d9067061634f', '84f52371-eee3-41c2-92e0-0835910a9209',
        'e7fd9228-bdbf-42b6-818a-45a0a308bf54', 'General sheet metal.');
INSERT INTO public.categories (id, category_name, category_group, description)
VALUES ('ecb01798-59c3-4f7b-9192-148db0633fde', '3fc6d89d-da96-4f0f-847c-614004eeda0b',
        '136d8080-fc37-463f-bfea-8937816c2fc8', 'General hexagon nut.');

INSERT INTO public.parameter_names (id, name_en, name_de, name_hu)
VALUES ('13ef16a8-cf4f-4f6b-8e76-5d812d39fbd2', 'length', 'Länge', 'hosszúság');
INSERT INTO public.parameter_names (id, name_en, name_de, name_hu)
VALUES ('bb15aefa-811f-4f7e-b254-b523ddc46326', 'width', 'Breite', 'szélesség');
INSERT INTO public.parameter_names (id, name_en, name_de, name_hu)
VALUES ('3f22c8ae-ec06-450b-a90f-0bd73bbd8596', 'height', 'Höhe', 'magasság');
INSERT INTO public.parameter_names (id, name_en, name_de, name_hu)
VALUES ('6cf99e66-6dd1-46e4-8836-36b9bc07a96c', 'diameter', 'Durchmesser', 'átmérő');
INSERT INTO public.parameter_names (id, name_en, name_de, name_hu)
VALUES ('cd34d049-b97c-494f-b21a-fbb6a847cf52', 'thickness', 'Blechstärke', 'vastagság');
INSERT INTO public.parameter_names (id, name_en, name_de, name_hu)
VALUES ('819e98e7-5cf2-41be-bbd1-5ef08ccf4c35', 'thread size', 'Gewinde', 'a menet névleges mérete');
INSERT INTO public.parameter_names (id, name_en, name_de, name_hu)
VALUES ('02dd5cd9-9077-4891-97b8-0bb5d3b41795', 'density', 'Dichte', 'sűrűség');

INSERT INTO public.parameters (id, parameter_name, parameter_unit, description)
VALUES ('de65cf1e-e8ea-4373-972b-65c181b2d6fa', 'cd34d049-b97c-494f-b21a-fbb6a847cf52',
        '94c99782-3c48-4e7f-8c03-da7edebcae12', 'Thickness in millimetre.');
INSERT INTO public.parameters (id, parameter_name, parameter_unit, description)
VALUES ('c7c746dd-35ac-4ef6-8f03-9c9f39e15440', '13ef16a8-cf4f-4f6b-8e76-5d812d39fbd2',
        '94c99782-3c48-4e7f-8c03-da7edebcae12', 'Length in millimetre.');
INSERT INTO public.parameters (id, parameter_name, parameter_unit, description)
VALUES ('4e6d8277-214a-4972-947b-e6b0d740c977', 'bb15aefa-811f-4f7e-b254-b523ddc46326',
        '94c99782-3c48-4e7f-8c03-da7edebcae12', 'Width in millimetre.');
INSERT INTO public.parameters (id, parameter_name, parameter_unit, description)
VALUES ('b64f55a3-69b3-4807-b588-7ed8b5b8cd92', '6cf99e66-6dd1-46e4-8836-36b9bc07a96c',
        '94c99782-3c48-4e7f-8c03-da7edebcae12', 'Diameter in millimetre.');
INSERT INTO public.parameters (id, parameter_name, parameter_unit, description)
VALUES ('7c6a3102-2584-4873-9109-94aa3c37e509', '819e98e7-5cf2-41be-bbd1-5ef08ccf4c35',
        '94c99782-3c48-4e7f-8c03-da7edebcae12', 'Thread size in millimetre.');
INSERT INTO public.parameters (id, parameter_name, parameter_unit, description)
VALUES ('3e89c758-5407-4258-a686-1413741f95d2', '02dd5cd9-9077-4891-97b8-0bb5d3b41795',
        '495dc8a6-cb11-46ed-a5a9-dfec317ede55', 'Density in kilogram per cubic metre.');
INSERT INTO public.parameters (id, parameter_name, parameter_unit, description)
VALUES ('96db4676-be8e-4f48-842b-703a2c9e2bfc', '02dd5cd9-9077-4891-97b8-0bb5d3b41795',
        '484f782f-e2d9-48ef-b769-61bc39133c5a', 'Density in kilogram per cubic deci metre.');

INSERT INTO public.category_parameters (id, seq, category, parameter)
VALUES ('263ea255-afab-4ef8-b311-c69825147b9b', 1, '3dc0d66d-0898-4e00-b8ad-d9067061634f',
        'de65cf1e-e8ea-4373-972b-65c181b2d6fa');
INSERT INTO public.category_parameters (id, seq, category, parameter)
VALUES ('41bc8c9a-f8ef-4da0-8ff1-aad1f702abf4', 2, '3dc0d66d-0898-4e00-b8ad-d9067061634f',
        'c7c746dd-35ac-4ef6-8f03-9c9f39e15440');
INSERT INTO public.category_parameters (id, seq, category, parameter)
VALUES ('069f35ee-795a-4842-a1ee-e59ad789d814', 3, '3dc0d66d-0898-4e00-b8ad-d9067061634f',
        '4e6d8277-214a-4972-947b-e6b0d740c977');
INSERT INTO public.category_parameters (id, seq, category, parameter)
VALUES ('d91e5f34-f803-4f4c-8bab-091954f826d8', 1, 'ecb01798-59c3-4f7b-9192-148db0633fde',
        '7c6a3102-2584-4873-9109-94aa3c37e509');

INSERT INTO public.item_categories (id, item, category)
VALUES ('9fdf9d88-3223-4d4f-8b04-a273f65548ec', '42e8cb49-2c24-4a97-abfe-b35c7e44135a',
        'ecb01798-59c3-4f7b-9192-148db0633fde');
INSERT INTO public.item_categories (id, item, category)
VALUES ('e3ddb496-2ac3-4976-94e7-d8c5382b01ba', '72c145a0-2348-4b13-a699-e361111dcc52',
        '3dc0d66d-0898-4e00-b8ad-d9067061634f');

INSERT INTO public.material_names (id, name_en, name_de, name_hu)
VALUES ('ed487678-05f8-4edd-bbcd-778416e9a8d9', 'X5CrNi18-10', 'X5CrNi18-10', 'X5CrNi18-10');
INSERT INTO public.material_names (id, name_en, name_de, name_hu)
VALUES ('64d3810b-6b9f-423e-98c8-2b23b06bc287', 'X2CrNiMo17-12-2', 'X2CrNiMo17-12-2', 'X2CrNiMo17-12-2');
INSERT INTO public.material_names (id, name_en, name_de, name_hu)
VALUES ('d2e46ae2-29d7-4afe-b2ed-401604ba4c0d', 'A2', 'A2', 'A2');
INSERT INTO public.material_names (id, name_en, name_de, name_hu)
VALUES ('e69a27a7-c9f4-43b3-9f04-6a480653d923', 'A4', 'A4', 'A4');
INSERT INTO public.material_names (id, name_en, name_de, name_hu)
VALUES ('b59b8b83-17b1-4488-9ea6-a9e34f275262', 'PTFE - Polytetrafluoroethylene', 'PTFE - Polytetrafluorethylen',
        'PTFE - Poli(tetrafluor-etilén)');
INSERT INTO public.material_names (id, name_en, name_de, name_hu)
VALUES ('f1e17704-5b37-4f3e-9b9d-121d85abd099', 'NYLON', 'NYLON', 'NYLON');
INSERT INTO public.material_names (id, name_en, name_de, name_hu)
VALUES ('3cc41d40-21ba-4c8c-823d-a74fb94567d6', 'X8CrNiS18-9', 'X8CrNiS18-9', 'X8CrNiS18-9');

INSERT INTO public.materials (id, material_name, material_number, description)
VALUES ('3e56c606-e82c-40c4-8c7e-96242923901c', 'ed487678-05f8-4edd-bbcd-778416e9a8d9', '1.4301', 'Austenitic steels.');
INSERT INTO public.materials (id, material_name, material_number, description)
VALUES ('1dc004b1-07b9-42ed-aa6b-e73694d4c41b', '64d3810b-6b9f-423e-98c8-2b23b06bc287', '1.4404', 'Austenitic steels.');
INSERT INTO public.materials (id, material_name, material_number, description)
VALUES ('c649579d-de56-4111-835a-982f83be7dbd', 'd2e46ae2-29d7-4afe-b2ed-401604ba4c0d', 'A2', 'Austenitic.');
INSERT INTO public.materials (id, material_name, material_number, description)
VALUES ('4357ed79-5c14-4425-9e36-a813e507f7f9', 'e69a27a7-c9f4-43b3-9f04-6a480653d923', 'A4', 'Austenitic.');
INSERT INTO public.materials (id, material_name, material_number, description)
VALUES ('8f7969a6-72ba-471a-88bd-f9ba4b9d0456', 'b59b8b83-17b1-4488-9ea6-a9e34f275262', 'PTFE',
        'Polytetrafluoroethylene (PTFE) semi-finished product');
INSERT INTO public.materials (id, material_name, material_number, description)
VALUES ('52458f97-2229-43b1-838c-b9bb833c6dff', 'f1e17704-5b37-4f3e-9b9d-121d85abd099', 'PA 66',
        'Polyamide 66: monopolymer based on hexamethylenediamine and adipic acid.');
INSERT INTO public.materials (id, material_name, material_number, description)
VALUES ('5886f7f6-858a-47ff-879e-12d83d7c31d5', '3cc41d40-21ba-4c8c-823d-a74fb94567d6', '1.4305',
        'Austenitic corrosion resisting steel.');

INSERT INTO public.item_materials (id, item, material)
VALUES ('a2e7de8c-ad4b-40aa-852b-be6e4c1e17a0', '42e8cb49-2c24-4a97-abfe-b35c7e44135a',
        'c649579d-de56-4111-835a-982f83be7dbd');
INSERT INTO public.item_materials (id, item, material)
VALUES ('fbd6b9b8-57c2-46cd-840a-ce128c3f2ba7', '72c145a0-2348-4b13-a699-e361111dcc52',
        '3e56c606-e82c-40c4-8c7e-96242923901c');

INSERT INTO public.standard_names (id, name_en, name_de, name_hu)
VALUES ('73c5abdc-0cbf-437d-8b59-18b695f39973',
        'Flat products made of steels for pressure purposes – Part 7: Stainless steels',
        'Flacherzeugnisse aus Druckbehälterstählen - Teil 7: Nichtrostende Stähle',
        'Lapos acéltermékek nyomástartó berendezésekhez - 7. rész: Korrózióálló acélok');
INSERT INTO public.standard_names (id, name_en, name_de, name_hu)
VALUES ('cde5fb41-ef44-4460-9f89-d6fbce35613c',
        'Mechanical properties of corrosion resistant stainless steel fasteners — Part 1: Bolts, screws and studs',
        'Mechanische Eigenschaften von Verbindungselementen aus korrosionsbeständigen nichtrostenden Stählen - Teil 1: Schrauben mit festgelegten Festigkeitsklassen - Regelgewinde und Feingewinde',
        'Korrózióálló acél kötőelemek mechanikai tulajdonságai. 1. rész: Csavarok');
INSERT INTO public.standard_names (id, name_en, name_de, name_hu)
VALUES ('3b6e8296-74fa-4709-b9fe-87ac8c75d1ee',
        'Mechanical properties of corrosion resistant stainless steel fasteners — Part 2: Nuts',
        'Mechanische Eigenschaften von Verbindungselementen aus korrosionsbeständigen nichtrostenden Stählen - Teil 2: Muttern mit festgelegten Festigkeitsklassen - Regelgewinde und Feingewinde',
        'Korrózióálló acél kötőelemek mechanikai tulajdonságai. 2. rész: Csavaranyák');
INSERT INTO public.standard_names (id, name_en, name_de, name_hu)
VALUES ('52099fc8-fa0c-49ff-9036-c30fdd44668c',
        'Plastics - Polytetrafluoroethylene (PTFE) semi-finished products - Part 1: Requirements and designation',
        'Kunststoffe - Polytetrafluorethylen (PTFE)-Halbzeuge - Teil 1: Anforderungen und Bezeichnung',
        'Műanyagok. Poli(tetrafluor-etilén) (PTFE) félkész termékek. 1. rész: Követelmények és megnevezés');
INSERT INTO public.standard_names (id, name_en, name_de, name_hu)
VALUES ('b2c3d756-0e6a-4168-9391-83198dda5fb2',
        'Plastics — Polyamide (PA) moulding and extrusion materials — Part 1: Designation system and basis for specification',
        'Kunststoffe - Polyamid (PA)-Formmassen für das Spritzgießen und die Extrusion - Teil 1: Bezeichnungssystem und Basis für Spezifikationen',
        'Műanyagok. Poliamid (PA) fröccs- és extrúziós anyagok. 1. rész: Megnevezési rendszer, termékek jelölése és a műszaki követelmény alapja');
INSERT INTO public.standard_names (id, name_en, name_de, name_hu)
VALUES ('620498f2-1efd-4510-89eb-8d3c01a84351',
        'Stainless steels - Part 3: Technical delivery conditions for semi-finished products, bars, rods, wire, sections and bright products of corrosion resisting steels for general purposes',
        'Nichtrostende Stähle - Teil 3: Technische Lieferbedingungen für Halbzeug, Stäbe, Walzdraht, gezogenen Draht, Profile und Blankstahlerzeugnisse aus korrosionsbeständigen Stählen für allgemeine Verwendung',
        'Korrózióálló acélok. 3. rész: Az általános felhasználású félgyártmányok, rudak, hengerhuzalok, huzalok, idomacélok és fényes termékek műszaki szállítási feltételei');
INSERT INTO public.standard_names (id, name_en, name_de, name_hu)
VALUES ('d53e4300-8e9f-4938-b5a4-48ea2153c274', 'Hexagon nut', 'Sechskantmutter', 'Hatlapú csavaranya');
INSERT INTO public.standard_names (id, name_en, name_de, name_hu)
VALUES ('93bfee1c-919a-43b7-9d5c-ff4fde58f2ec', 'Plain washers', 'Flache Scheiben', 'Lapos alátét');

INSERT INTO public.standards (id, standard_name, standard_number, description)
VALUES ('ec60a85a-8edc-43c5-9abb-3daf5bfe0cc7', '52099fc8-fa0c-49ff-9036-c30fdd44668c', 'ISO 13000-1',
        'This part of ISO 13000 specifies the requirements for processed unfilled polytetrafluoroethylene (PTFE) products, which may occur in several forms.');
INSERT INTO public.standards (id, standard_name, standard_number, description)
VALUES ('7e677d14-3735-44df-b928-4af1c06ed480', 'b2c3d756-0e6a-4168-9391-83198dda5fb2', 'ISO 1874-1',
        'This part of ISO 1874 establishes a System of designation for Polyamide (PA) thermoplastic materials, which may be used as the basis for specifications.');
INSERT INTO public.standards (id, standard_name, standard_number, description)
VALUES ('06f4a02d-3b32-45b2-8082-862509ef7a4f', '3b6e8296-74fa-4709-b9fe-87ac8c75d1ee', 'ISO 3506-2',
        'This part of ISO 3506 specifies the mechanical properties of nuts made of austenitic, martensitic and ferritic steel grades of corrosion-resistant stainless steels, when tested over an ambient temperature range of 10 °C to 35 °C.');
INSERT INTO public.standards (id, standard_name, standard_number, description)
VALUES ('9c197400-9bef-4f6c-a010-cac818654b93', 'cde5fb41-ef44-4460-9f89-d6fbce35613c', 'ISO 3506-1',
        'This part of ISO 3506 specifies the mechanical properties of bolts, screws and studs made of austenitic, martensitic and ferritic steel grades of corrosion-resistant stainless steels, when tested over an ambient temperature range of 10 °C to 35 °C.');
INSERT INTO public.standards (id, standard_name, standard_number, description)
VALUES ('477b890b-da28-4971-b999-798aa2d56394', '620498f2-1efd-4510-89eb-8d3c01a84351', 'EN 10088-3',
        'This part of EN 10088 specifies the technical delivery conditions for semi-finished products, hot or cold formed bars, rods, wire, sections and bright products of standard grades and special grades of corrosion resisting stainless steels for general purposes.');
INSERT INTO public.standards (id, standard_name, standard_number, description)
VALUES ('97c28184-efcd-457f-bd1f-65a3e733ef52', '73c5abdc-0cbf-437d-8b59-18b695f39973', 'EN 10028-7',
        'This European Standard specifies requirements for flat products for pressure purposes made of stainless steels, including austenitic creep resisting steels, in thicknesses as indicated in Tables 7 to 10.');
INSERT INTO public.standards (id, standard_name, standard_number, description)
VALUES ('fbbacb28-283f-4b6f-ac1f-33467f01e02f', 'd53e4300-8e9f-4938-b5a4-48ea2153c274', 'ISO 4032',
        'This International Standard specifies the characteristics of hexagon regular nuts (style 1), with thread from M1,6 up to and including M64, with product grade A for threads D ≤ M16 and product grade B for threads D > M16.');

INSERT INTO public.item_standards (id, item, standard)
VALUES ('8960fd0b-f188-4ae0-92fa-aa4751ba9b3c', '42e8cb49-2c24-4a97-abfe-b35c7e44135a',
        'fbbacb28-283f-4b6f-ac1f-33467f01e02f');

INSERT INTO public.material_parameters (id, seq, material, parameter, val)
VALUES ('f9977230-20ee-493e-8afb-b57d7e5325b3', 1, '3e56c606-e82c-40c4-8c7e-96242923901c',
        '96db4676-be8e-4f48-842b-703a2c9e2bfc', 7.9);
INSERT INTO public.material_parameters (id, seq, material, parameter, val)
VALUES ('a4abfc1e-4dbc-4d5f-bfa3-319d66fa4ba0', 1, '1dc004b1-07b9-42ed-aa6b-e73694d4c41b',
        '96db4676-be8e-4f48-842b-703a2c9e2bfc', 8.0);
INSERT INTO public.material_parameters (id, seq, material, parameter, val)
VALUES ('f914ba84-774a-42ba-a219-2558faa871a6', 1, '5886f7f6-858a-47ff-879e-12d83d7c31d5',
        '96db4676-be8e-4f48-842b-703a2c9e2bfc', 7.9);

INSERT INTO public.material_standards (id, material, standard)
VALUES ('7a28fef1-1007-4a54-902a-65c02950ae4f', '3e56c606-e82c-40c4-8c7e-96242923901c',
        '97c28184-efcd-457f-bd1f-65a3e733ef52');
INSERT INTO public.material_standards (id, material, standard)
VALUES ('f35051d2-5f1d-4050-95c2-436d6ea72e2e', '1dc004b1-07b9-42ed-aa6b-e73694d4c41b',
        '97c28184-efcd-457f-bd1f-65a3e733ef52');
INSERT INTO public.material_standards (id, material, standard)
VALUES ('95cba91d-7db5-4526-9616-144358f4f4aa', 'c649579d-de56-4111-835a-982f83be7dbd',
        '9c197400-9bef-4f6c-a010-cac818654b93');
INSERT INTO public.material_standards (id, material, standard)
VALUES ('b7a788c6-812d-4c2a-be41-2bdc1bbc8e1d', 'c649579d-de56-4111-835a-982f83be7dbd',
        '06f4a02d-3b32-45b2-8082-862509ef7a4f');
INSERT INTO public.material_standards (id, material, standard)
VALUES ('a8b5d40a-7cac-4f45-8567-cf23132fc815', '4357ed79-5c14-4425-9e36-a813e507f7f9',
        '9c197400-9bef-4f6c-a010-cac818654b93');
INSERT INTO public.material_standards (id, material, standard)
VALUES ('959197de-00e3-40af-b2db-65ddeff58fd7', '4357ed79-5c14-4425-9e36-a813e507f7f9',
        '06f4a02d-3b32-45b2-8082-862509ef7a4f');
INSERT INTO public.material_standards (id, material, standard)
VALUES ('f6b81a0c-1f15-4758-b918-14fdaa2051da', '8f7969a6-72ba-471a-88bd-f9ba4b9d0456',
        'ec60a85a-8edc-43c5-9abb-3daf5bfe0cc7');
INSERT INTO public.material_standards (id, material, standard)
VALUES ('ed467b36-e86d-419d-979a-20bbfaa3679d', '52458f97-2229-43b1-838c-b9bb833c6dff',
        '7e677d14-3735-44df-b928-4af1c06ed480');
INSERT INTO public.material_standards (id, material, standard)
VALUES ('7242e40c-15b8-486d-891c-b9b45faa75d9', '5886f7f6-858a-47ff-879e-12d83d7c31d5',
        '477b890b-da28-4971-b999-798aa2d56394');

INSERT INTO public.parameter_values (id, item_category, parameter, val)
VALUES ('c3d6f091-457d-4750-a000-227e2f9f87bf', '9fdf9d88-3223-4d4f-8b04-a273f65548ec',
        '7c6a3102-2584-4873-9109-94aa3c37e509', 8);
INSERT INTO public.parameter_values (id, item_category, parameter, val)
VALUES ('90ee555b-d2f8-4916-b6a1-2568a61c1b9b', 'e3ddb496-2ac3-4976-94e7-d8c5382b01ba',
        'de65cf1e-e8ea-4373-972b-65c181b2d6fa', 2);
INSERT INTO public.parameter_values (id, item_category, parameter, val)
VALUES ('1bcdfb1e-207d-412f-9659-9b4f9797cc43', 'e3ddb496-2ac3-4976-94e7-d8c5382b01ba',
        '4e6d8277-214a-4972-947b-e6b0d740c977', 560);
INSERT INTO public.parameter_values (id, item_category, parameter, val)
VALUES ('416af912-9ab7-49fe-ab67-2d31896a82a3', 'e3ddb496-2ac3-4976-94e7-d8c5382b01ba',
        'c7c746dd-35ac-4ef6-8f03-9c9f39e15440', 313);

INSERT INTO public.users (id, user_email, user_name, user_password, user_locale)
VALUES ('330acee3-81ec-45df-9f0d-fe22e46fb36c', 'admin', 'admin',
        '$2a$10$W8XkQpHnWov3.xlc1MiAWu.qn0WVvULyFmPNZnlfk4rhkGSu4Izlu', 'en_US');
