/*{
    "make":"BMW",
    "model":"8-series Coupe",
    "color":"Brown",
    "description":"Well maintained, Triple Owner, Good Milage",
    "year":"2013",
    "price":"59395.00",
    "status":"SELL",
    "fuel":"DIESEL",
    "power":"240",
    "gearType":"Automatic",
    "image":"../assets/images/featured-cars/fc7.png",
    "mileage":"6100"
}


{
    "make":"Lamborghini",
    "model":"v520",
    "color":"Ceyan",
    "description":"Fully loaded, posh and powerful car, well maintained, single owner",
    "year":"2022",
    "price":"86575.00",
    "status":"BUY",
    "fuel":"DIESEL",
    "power":"280",
    "gearType":"Manual",
    "image":"../assets/images/featured-cars/fc4.png",
    "mileage":"2100"
}

{
    "make":"Chevrolet",
    "model":"Camaro wmv20",
    "color":"Red",
    "description":"Well maintained, Second Owner, Good Milage",
    "year":"2019",
    "price":"66575.00",
    "status":"SELL",
    "fuel":"PETROL",
    "power":"220",
    "gearType":"Automatic",
    "image":"../assets/images/featured-cars/fc2.png",
    "mileage":"8100"
}


{
    "make": "BMW",
    "model": "X3",
    "color": "Black",
    "description": "Brand new look, well maintained, Single Owner",
    "year":"2019",
    "price":"55575.00",
    "status":"BUY",
    "fuel":"PETROL",
    "power":"250",
    "gearType":"Automatic",
    "image":"../assets/images/featured-cars/fc1.png",
    "mileage":"8100"
}

#POSTGRES
-- Database: car-market

-- DROP DATABASE IF EXISTS "car-market";

CREATE DATABASE "car-market"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE USER market WITH PASSWORD 'market';
commit;

GRANT ALL PRIVILEGES ON DATABASE "car-market" TO market;
commit;

SELECT * FROM pg_user WHERE usename = 'postgres';
*/