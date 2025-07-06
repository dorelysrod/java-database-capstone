# Smart Clinic System Database Schema Design

## MySQL Database Design

The relational data stored in MySQL includes structured entities such as patients, doctors, appointments, and admins.

### 1. Patients Table

| Column Name   | Data Type      | Constraints               |
|---------------|----------------|---------------------------|
| patient_id    | INT            | PRIMARY KEY, AUTO_INCREMENT |
| first_name    | VARCHAR(50)    | NOT NULL                 |
| last_name     | VARCHAR(50)    | NOT NULL                 |
| dob           | DATE           | NOT NULL                 |
| email         | VARCHAR(100)   | NOT NULL, UNIQUE         |
| phone_number  | VARCHAR(20)    | NULLABLE                 |
| address       | VARCHAR(255)   | NULLABLE                 |

### 2. Doctors Table

| Column Name   | Data Type      | Constraints               |
|---------------|----------------|---------------------------|
| doctor_id     | INT            | PRIMARY KEY, AUTO_INCREMENT |
| first_name    | VARCHAR(50)    | NOT NULL                 |
| last_name     | VARCHAR(50)    | NOT NULL                 |
| specialization | VARCHAR(100)  | NOT NULL                 |
| email         | VARCHAR(100)   | NOT NULL, UNIQUE         |
| phone_number  | VARCHAR(20)    | NULLABLE                 |

### 3. Appointments Table

| Column Name    | Data Type     | Constraints               |
|----------------|---------------|---------------------------|
| appointment_id | INT           | PRIMARY KEY, AUTO_INCREMENT |
| patient_id     | INT           | NOT NULL, FOREIGN KEY REFERENCES patients(patient_id) |
| doctor_id      | INT           | NOT NULL, FOREIGN KEY REFERENCES doctors(doctor_id) |
| appointment_date | DATETIME    | NOT NULL                 |
| status         | ENUM('Scheduled', 'Completed', 'Cancelled') | NOT NULL DEFAULT 'Scheduled' |

### 4. Admin Table

| Column Name   | Data Type      | Constraints               |
|---------------|----------------|---------------------------|
| admin_id      | INT            | PRIMARY KEY, AUTO_INCREMENT |
| username      | VARCHAR(50)    | NOT NULL, UNIQUE         |
| password_hash | VARCHAR(255)   | NOT NULL                 |
| role          | ENUM('SuperAdmin', 'StaffAdmin') | NOT NULL |

---

## MongoDB Collection Design

For flexible or unstructured data, MongoDB will store documents such as **prescriptions**.

### Prescriptions Collection Example

```json
{
  "_id": "ObjectId('60f5b6c28d1e8c3c6d6e6b1a')",
  "patient_id": 1,
  "doctor_id": 2,
  "prescribed_date": "2025-07-05T14:30:00Z",
  "medications": [
    {
      "name": "Amoxicillin",
      "dosage": "500mg",
      "frequency": "Twice a day",
      "duration": "7 days"
    },
    {
      "name": "Paracetamol",
      "dosage": "650mg",
      "frequency": "Thrice a day",
      "duration": "5 days"
    }
  ],
  "notes": "Take medications after food. Return for review in one week."
}
