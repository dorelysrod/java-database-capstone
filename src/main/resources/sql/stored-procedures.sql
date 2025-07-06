-- =====================================
-- Stored Procedure: GetDailyAppointmentReportByDoctor
-- =====================================

DELIMITER //

CREATE PROCEDURE GetDailyAppointmentReportByDoctor(IN report_date DATE)
BEGIN
    SELECT d.id AS doctor_id, d.first_name, d.last_name, COUNT(a.id) AS total_appointments
    FROM doctor d
    JOIN appointment a ON d.id = a.doctor_id
    WHERE DATE(a.appointment_date) = report_date
    GROUP BY d.id, d.first_name, d.last_name
    ORDER BY total_appointments DESC;
END //

DELIMITER ;

-- =====================================
-- Stored Procedure: GetDoctorWithMostPatientsByMonth
-- =====================================

DELIMITER //

CREATE PROCEDURE GetDoctorWithMostPatientsByMonth(IN year INT, IN month INT)
BEGIN
    SELECT d.id AS doctor_id, d.first_name, d.last_name, COUNT(a.id) AS total_patients
    FROM doctor d
    JOIN appointment a ON d.id = a.doctor_id
    WHERE YEAR(a.appointment_date) = year AND MONTH(a.appointment_date) = month
    GROUP BY d.id, d.first_name, d.last_name
    ORDER BY total_patients DESC
    LIMIT 1;
END //

DELIMITER ;

-- =====================================
-- Stored Procedure: GetDoctorWithMostPatientsByYear
-- =====================================

DELIMITER //

CREATE PROCEDURE GetDoctorWithMostPatientsByYear(IN year INT)
BEGIN
    SELECT d.id AS doctor_id, d.first_name, d.last_name, COUNT(a.id) AS total_patients
    FROM doctor d
    JOIN appointment a ON d.id = a.doctor_id
    WHERE YEAR(a.appointment_date) = year
    GROUP BY d.id, d.first_name, d.last_name
    ORDER BY total_patients DESC
    LIMIT 1;
END //

DELIMITER ;
