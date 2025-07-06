document.addEventListener('DOMContentLoaded', () => {
    fetchAppointments();
  
    document.getElementById('searchPatient').addEventListener('input', (e) => {
      const query = e.target.value;
      patientService.searchAppointmentsByPatient(query).then(renderAppointments);
    });
  
    document.getElementById('filterDate').addEventListener('change', (e) => {
      const date = e.target.value;
      patientService.filterAppointmentsByDate(date).then(renderAppointments);
    });
  });
  
  function fetchAppointments() {
    patientService.getAppointmentsForLoggedInDoctor().then(renderAppointments);
  }
  
  function renderAppointments(appointments) {
    const list = document.getElementById('appointmentList');
    list.innerHTML = '';
    appointments.forEach(appt => {
      const div = document.createElement('div');
      div.innerText = `${appt.patientName} - ${appt.appointmentDate}`;
      list.appendChild(div);
    });
  }
  