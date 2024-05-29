\c product;

CREATE TABLE IF NOT EXISTS products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    description VARCHAR(500) NOT NULL,
    price FLOAT NOT NULL,
    quantity INTEGER NOT NULL,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO products VALUES (
    DEFAULT,
    'SmartTV Samsung',
    'Experience the next level of home entertainment with Samsung Smart TV. Combining cutting-edge technology, stunning visuals, and seamless connectivity, Samsung Smart TV transforms your living room into an immersive entertainment hub.',
    4699.600,
    5
);
