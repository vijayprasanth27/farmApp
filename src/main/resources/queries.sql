DROP TABLE Farm;
CREATE TABLE Farm (
	id 	 		NUMBER,
	name 		VARCHAR(50),
	field_id 	NUMBER,
);

DROP TABLE Field;
CREATE TABLE Field (
	id 						NUMBER,
	planting_area 			NUMBER,
	crop 					VARCHAR(50),
	season 					VARCHAR(50),
	expected_product 		NUMBER,
	actual_harvested_product NUMBER
);