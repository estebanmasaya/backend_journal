package com.kth.estmm.backend_journal.Controller;

import com.kth.estmm.backend_journal.BO.*;
import com.kth.estmm.backend_journal.BO.Services.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="/journal")
public class MainController {


    private EncounterService encounterService;

    private PatientService patientService;

    private DoctorService doctorService;
    private StaffService staffService;

    private ObservationService observationService;
    private ConversationService conversationService;
    private ConditionService conditionService;

    public MainController(EncounterService encounterService, PatientService patientService, DoctorService doctorService, ObservationService observationService, StaffService staffService, ConversationService conversationService, ConditionService conditionService) {
        this.observationService = observationService;
        this.encounterService = encounterService;
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.staffService = staffService;
        this.conversationService = conversationService;
        this.conditionService = conditionService;
    }

    // PATIENT
    @GetMapping(path = "/patients")
    public @ResponseBody Iterable<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping(path = "/patientById")
    public @ResponseBody Patient getPatientById(@RequestParam long id){
        return patientService.getPatientById(id);
    }
    @PostMapping(path = "/addPatient")
    public Patient addPatient(@RequestParam String name, @RequestParam String email, @RequestParam String password){
        return patientService.addPatient(name, email, password);
    }



    // DOCTOR
    @GetMapping(path = "/doctors")
    public @ResponseBody Iterable<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping(path = "/doctorById")
    public @ResponseBody Doctor getDoctorById(@RequestParam long id){
        return doctorService.getDoctorById(id);
    }
    @PostMapping(path = "/addDoctor")
    public Doctor addDoctor(@RequestParam String name, @RequestParam String email, @RequestParam String password){
        return doctorService.addDoctor(name, email, password);

    }

    // STAFF

    @GetMapping(path = "/staff")
    public @ResponseBody Iterable<Staff> getAllStaff(){
        return staffService.getAllStaff();
    }

    @GetMapping(path = "/staffById")
    public @ResponseBody Staff getStaffById(@RequestParam long id){
        return staffService.getStaffById(id);
    }
    @PostMapping(path = "/addStaff")
    public Staff addStaff(@RequestParam String name, @RequestParam String email, @RequestParam String password){
        return staffService.addStaff(name, email, password);

    }

    // OBSERVATION
    @GetMapping(path = "/observations")
    public @ResponseBody Iterable<Observation> getAllObservations(){
        return observationService.getAllObservations();
    }

    @PostMapping(path = "/addObservation")
    public Observation addObservation(@RequestParam long patientId, @RequestParam long doctorOrStaffId, @RequestParam String description){
        return observationService.addObservation(patientId, doctorOrStaffId, description);
    }

    // CONVERSATION
    @PostMapping(path = "/startConversation")
    public Conversation startNewConversation(@RequestParam long senderId, @RequestParam long receiverId, @RequestParam String messageContent){
        return conversationService.startNewConversation(senderId, receiverId, messageContent);
    }

    @PostMapping(path = "/newMessage")
    public Conversation newMessage(@RequestParam long conversationId, @RequestParam String messageContent) {
        return conversationService.newMessage(conversationId, messageContent);
    }

    // CONDITION
    @PostMapping(path = "/addCondition")
    public Condition addCondition(@RequestParam long patientId, @RequestParam String description){
        return conditionService.addCondition(patientId, description);
    }




/*    @PostMapping(path="/addEncounter")
    public boolean addEncounter(@RequestParam long patientId, @RequestParam long doctorId, @RequestParam LocalDateTime date){
        return encounterService.addEncounter(patientId, doctorId, date);
    }*/




}
