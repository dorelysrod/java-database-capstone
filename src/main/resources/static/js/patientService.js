const patientService = {
    getAppointmentsForLoggedInDoctor: async () => {
      const res = await fetch('/api/doctor/appointments');
      return await res.json();
    },
    searchAppointmentsByPatient: async (query) => {
      const res = await fetch(`/api/doctor/appointments?patientName=${query}`);
      return await res.json();
    },
    filterAppointmentsByDate: async (date) => {
      const res = await fetch(`/api/doctor/appointments?date=${date}`);
      return await res.json();
    }
  };
  