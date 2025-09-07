-- 1️⃣ Create schema
CREATE SCHEMA IF NOT EXISTS expensemate;

-- 2️⃣ Create users table
CREATE TABLE IF NOT EXISTS expensemate.users (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL
);

-- 3️⃣ Create categories table
CREATE TABLE IF NOT EXISTS expensemate.categories (
    id UUID PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

-- 4️⃣ Create transactions table
CREATE TABLE IF NOT EXISTS expensemate.transactions (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL,
    amount DECIMAL(12,2) NOT NULL,
    type VARCHAR(20) NOT NULL,
    category_id UUID,
    date TIMESTAMP NOT NULL,
    notes VARCHAR(255),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES expensemate.users(id),
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES expensemate.categories(id)
);
