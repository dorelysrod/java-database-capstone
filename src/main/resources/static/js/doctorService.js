const doctorService = {
    getAllDoctors: async () => {
      const res = await fetch('/api/doctors');
      return await res.json();
    },
    searchDoctors: async (query) => {
      const res = await fetch(`/api/doctors?name=${query}`);
      return await res.json();
    },
    addDoctor: async (doctor) => {
      await fetch('/api/doctors', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(doctor)
      });
    }
  };
  