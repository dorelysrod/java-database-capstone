# 📋 Smart Clinic Management System - User Stories

---

## 👩‍⚕️ Doctor Stories

### 1. View all appointments
**As a** doctor,  
**I want to** view all my scheduled appointments,  
**So that** I can manage my daily consultations efficiently.

---

### 2. Prescribe medication to patients
**As a** doctor,  
**I want to** create prescriptions for patients after appointments,  
**So that** their treatment records are updated and accessible.

---

## 👤 Patient Stories

### 3. Book an appointment with a doctor
**As a** patient,  
**I want to** book an appointment with a specific doctor,  
**So that** I can receive timely medical care.

---

### 4. View my upcoming appointments
**As a** patient,  
**I want to** see a list of my upcoming appointments,  
**So that** I can plan accordingly and not miss them.

---

### 5. Cancel an appointment
**As a** patient,  
**I want to** cancel a booked appointment if needed,  
**So that** I free up the slot for other patients and avoid no-shows.

---

## 🛠️ Admin Stories

### 6. Add a new doctor to the system
**As an** admin,  
**I want to** add a doctor’s profile with their specialization and available times,  
**So that** they are visible for appointment bookings.

---

### 7. Remove a doctor from the system
**As an** admin,  
**I want to** remove a doctor’s profile if they leave the clinic,  
**So that** patients cannot book appointments with unavailable doctors.

---

## 📝 Pending Issues / Features

### 🚀 Implement appointment cancellation feature for patients

- **GitHub Issue:** [#1](https://github.com/dorelysrod/java-database-capstone/issues/1)
- **Summary:** Patients need the ability to cancel their booked appointments directly from their portal if they are unable to attend.
- **Priority:** High

---

### 🔒 Add JWT authentication

**As a** user (patient, doctor, or admin),  
**I want to** login and receive a JWT token,  
**So that** I can securely access my role-specific dashboard and functionalities.

---

## ✅ Acceptance Criteria

- All endpoints are secured with token validation.
- Doctors can CRUD prescriptions.
- Patients can book and cancel appointments.
- Admins can manage doctor profiles.

---

> **Last updated:** July 6, 2025  
> **Author:** Dorelys Rod

