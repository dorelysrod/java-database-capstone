document.addEventListener('DOMContentLoaded', () => {
    fetchDoctors();
  
    document.getElementById('searchDoctor').addEventListener('input', (e) => {
      const query = e.target.value;
      doctorService.searchDoctors(query).then(renderDoctors);
    });
  
    document.getElementById('addDoctorBtn').addEventListener('click', () => {
      openModal('addDoctorModal');
    });
  
    document.getElementById('saveDoctorBtn').addEventListener('click', () => {
      const firstName = document.getElementById('firstName').value;
      const lastName = document.getElementById('lastName').value;
      const specialization = document.getElementById('specialization').value;
      doctorService.addDoctor({ firstName, lastName, specialization }).then(fetchDoctors);
      closeModal('addDoctorModal');
    });
  });
  
  function fetchDoctors() {
    doctorService.getAllDoctors().then(renderDoctors);
  }
  
  function renderDoctors(doctors) {
    const list = document.getElementById('doctorList');
    list.innerHTML = '';
    doctors.forEach(doc => {
      const div = document.createElement('div');
      div.innerText = `${doc.firstName} ${doc.lastName} - ${doc.specialization}`;
      list.appendChild(div);
    });
  }
  