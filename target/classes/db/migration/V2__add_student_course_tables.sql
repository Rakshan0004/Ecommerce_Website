CREATE TABLE MStudents (
    id BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    CONSTRAINT PRIMARY KEY (id)
);

CREATE TABLE MCourse (
    id BIGINT AUTO_INCREMENT NOT NULL,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    CONSTRAINT PRIMARY KEY (id)
);

CREATE TABLE student_course (
    student_id BIGINT NOT NULL,
    course_id BIGINT NOT NULL,
    CONSTRAINT PRIMARY KEY (student_id, course_id),
    CONSTRAINT fk_sc_student FOREIGN KEY (student_id) REFERENCES MStudents(id),
    CONSTRAINT fk_sc_course FOREIGN KEY (course_id) REFERENCES MCourse(id)
);