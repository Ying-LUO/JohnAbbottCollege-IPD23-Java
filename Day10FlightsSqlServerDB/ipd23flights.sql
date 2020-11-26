USE master;
GO

-- Ying LUO: Re-Build Database if existed
IF DB_ID (N'IPD23FLIGHTS') IS NOT NULL
DROP DATABASE IPD23FLIGHTS;
GO

-- Ying LUO: Creating a database without specifying files
CREATE DATABASE IPD23FLIGHTS
;
GO

-- Ying LUO: switch to the IPD23FLIGHTS database
USE IPD23FLIGHTS
;
GO

/***** DROP SCHEMA BEFORE CREATE THEM ******/

DROP SCHEMA IPD23;
GO 

/***** DROP TABLE BEFORE CREATE THEM ******/

if OBJECT_ID('IPD23.Flights', 'U') is not null
	drop table IPD23.Flights
;
go


-- CREATE SCHEMA
create schema IPD23 authorization dbo
;
go

-- CREATE TABLE
CREATE TABLE IPD23.Flights
(
	Id INT IDENTITY(1,1) NOT NULL, -- auto-generated number
	OnDay DATE NOT NULL,
    FromCode NVARCHAR(5) NOT NULL,
    ToCode NVARCHAR(5) NOT NULL,
    Type NVARCHAR(20) NOT NULL CHECK (Type IN('Domestic', 'International', 'Private')),
    Passengers INT NOT NULL
	CONSTRAINT PK_Flights PRIMARY KEY CLUSTERED (Id ASC)
)
;
go

SELECT * FROM IPD23.Flights;

DELETE FROM IPD23.Flights;