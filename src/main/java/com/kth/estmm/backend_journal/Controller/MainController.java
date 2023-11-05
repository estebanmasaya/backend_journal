package com.kth.estmm.backend_journal.Controller;

import com.kth.estmm.backend_journal.BO.Doctor;
import com.kth.estmm.backend_journal.BO.Patient;
import com.kth.estmm.backend_journal.BO.Services.DoctorService;
import com.kth.estmm.backend_journal.BO.Services.EncounterService;
import com.kth.estmm.backend_journal.BO.Services.PatientService;
import com.kth.estmm.backend_journal.BO.Services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="/journal")
public class MainController {

    private UserService userService;
    private EncounterService encounterService;

    private PatientService patientService;

    private DoctorService doctorService;

    public MainController(UserService userService, EncounterService encounterService, PatientService patientService, DoctorService doctorService) {
        this.userService = userService;
        this.encounterService = encounterService;
        this.patientService = patientService;
        this.doctorService = doctorService;
    }

    @GetMapping(path = "/patients")
    public @ResponseBody Iterable<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @PostMapping(path = "/addPatient")
    public boolean addPatient(@RequestParam String name, @RequestParam String email, @RequestParam String password){
        return patientService.addPatient(name, email, password);

    }

    @GetMapping(path = "/doctors")
    public @ResponseBody Iterable<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @PostMapping(path = "/addDoctor")
    public boolean addDoctor(@RequestParam String name, @RequestParam String email, @RequestParam String password){
        return doctorService.addDoctor(name, email, password);

    }


/*    @GetMapping(path = "/users")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping(path = "/addUser")
    public boolean addUser(@RequestParam String name, @RequestParam String email, @RequestParam String password){
        return userService.addUser(name, email, password);

    }*/

/*    @PostMapping(path="/addEncounter")
    public boolean addEncounter(@RequestParam long patientId, @RequestParam long doctorId, @RequestParam LocalDateTime date){
        return encounterService.addEncounter(patientId, doctorId, date);
    }*/




}
