CREATE TABLE IF NOT EXISTS product_type(
    id SERIAL PRIMARY KEY,
    type VARCHAR(500) NOT NULL
);

CREATE TABLE IF NOT EXISTS measurement_type(
    id SERIAL PRIMARY KEY,
    type VARCHAR(500) NOT NULL
);

CREATE TABLE IF NOT EXISTS product(
     id SERIAL PRIMARY KEY,
     product_type_id SERIAL NOT NULL,
     name VARCHAR(500) NOT NULL,
     measurement_points INTEGER NOT NULL,
     measurement_type_id SERIAL NOT NULL,
     description VARCHAR(500),
     img_reference VARCHAR(500),
     price DOUBLE(10,2);
);