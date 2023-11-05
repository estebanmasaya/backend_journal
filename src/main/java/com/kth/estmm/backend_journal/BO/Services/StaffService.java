package com.kth.estmm.backend_journal.BO.Services;

import com.kth.estmm.backend_journal.BO.Doctor;
import com.kth.estmm.backend_journal.BO.Staff;
import com.kth.estmm.backend_journal.Persistence.StaffRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;

    public Iterable<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Staff getStaffById(long id) {
        return staffRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Staff not found with id " + id));
    }
    public boolean addStaff(String name, String email, String password) {
        Staff newStaff = new Staff(name, email, password);
        staffRepository.save(newStaff);
        return true;
    }
}
