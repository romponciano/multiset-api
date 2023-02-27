
CREATE TABLE IF NOT EXISTS connection_table (
	id SERIAL NOT NULL,
	url varchar(256) NOT NULL,
	name VARCHAR(128) NOT NULL,
	driver VARCHAR(256) NOT NULL,
	database VARCHAR(256) NOT NULL,
	type VARCHAR(256) NOT NULL,
	username varchar(256) NOT NULL,
	password varchar(256),
	is_active boolean,
	CONSTRAINT connection_table_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS integration (
	id BIGSERIAL NOT NULL,
	conditions JSONB,
	relations JSONB,
	attributes JSONB,
	CONSTRAINT integration_table_pkey PRIMARY KEY (id)
);
