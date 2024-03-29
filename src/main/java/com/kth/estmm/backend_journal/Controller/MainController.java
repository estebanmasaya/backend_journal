package com.kth.estmm.backend_journal.Controller;

import com.kth.estmm.backend_journal.BO.*;
import com.kth.estmm.backend_journal.BO.Services.*;
import com.kth.estmm.backend_journal.DTO.MessageDTO;
import com.kth.estmm.backend_journal.DTO.PatientInfoDTO;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;
import java.util.List;

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
    private UserService userService;

    public MainController(EncounterService encounterService, PatientService patientService, DoctorService doctorService, ObservationService observationService, StaffService staffService, ConversationService conversationService, ConditionService conditionService, UserService userService) {
        this.observationService = observationService;
        this.encounterService = encounterService;
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.staffService = staffService;
        this.conversationService = conversationService;
        this.conditionService = conditionService;
        this.userService = userService;
    }

    // USER
    @GetMapping(path = "/login")
    public @ResponseBody User login(@RequestParam String email, @RequestParam String password) throws LoginException {
        return userService.login(email, password);
    }
    @GetMapping(path = "/userByEmail")
    public @ResponseBody User getUserByEmail(@RequestParam String email){
        return userService.getUserByEmail(email);
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

    @GetMapping(path = "/getAllPatientInfoById")
    public @ResponseBody Iterable<PatientInfoDTO> getAllPatientInfoById(@RequestParam long id){
        return patientService.getAllPatientInfoById(id);
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

    @PostMapping(path = "/addObservationByEncounterId")
    public Observation addObservationByEncounterId(@RequestParam long encounterId, @RequestParam String description){
        return observationService.addObservationByEncounterId(encounterId, description);
    }

    @PostMapping(path = "/addObservationAndEncounter")
    public Observation addObservationAndEncounter(@RequestParam long patientId, @RequestParam long doctorOrStaffId, @RequestParam String description){
        return observationService.addObservationAndEncounter(patientId, doctorOrStaffId, description);
    }

    @GetMapping(path = "/observationsByEncounterId")
    public List<Observation> getObservationsByEncounterId(@RequestParam long encounterId){
        return observationService.getObservationsByEncounterId( encounterId);
    }

    // CONVERSATION
    @PostMapping(path = "/startConversation")
    public Conversation startNewConversation(@RequestParam long senderId, @RequestParam long receiverId, @RequestParam String messageContent){
        return conversationService.startNewConversation(senderId, receiverId, messageContent);
    }
    @GetMapping(path = "/getAllConversations")
    public @ResponseBody Iterable<Conversation> getAllConversations(){
        return conversationService.getAllConversations();
    }

    @GetMapping(path = "/getAllConversationsById")
    public @ResponseBody Iterable<Conversation> getAllConversationsById(long id){
        return conversationService.getAllConversationsById(id);
    }

    @GetMapping(path = "/getConversationById")
    public @ResponseBody Conversation getConversationById(@RequestParam long id){
        return conversationService.getConversationById(id);
    }

    @GetMapping(path = "/getMessagesById")
    public @ResponseBody List<MessageDTO> getMessagesById(@RequestParam long id){
        return (List<MessageDTO>) conversationService.getMessagesById(id);
    }

    @PostMapping(path = "/removeConversationById")
    public void newMessage(@RequestParam long conversationId) {
        conversationService.removeConversationById(conversationId);
    }
    @PostMapping(path = "/newMessage")
    public Conversation newMessage(@RequestParam long conversationId, @RequestParam String messageContent, @RequestParam long senderId, @RequestParam long receiverId) {
        return conversationService.newMessage(conversationId, messageContent, senderId, receiverId);
    }

    // CONDITION
    @PostMapping(path = "/addCondition")
    public Condition addCondition(@RequestParam long patientId, @RequestParam String description){
        return conditionService.addCondition(patientId, description);
    }

    @GetMapping(path ="/conditionsByPatientId")
    public List<Condition> getConditionsByPatientId(@RequestParam long patientId){
        return conditionService.getConditionsByPatientId(patientId);
    }

    // ENCOUNTER
    @PostMapping(path="/addEncounter")
    public Encounter addEncounter(@RequestParam long patientId, @RequestParam long doctorOrStaffId){
        return encounterService.addEncounter(patientId, doctorOrStaffId);
    }

    @GetMapping(path ="/encountersByPatientId")
    public List<Encounter> getEncountersByPatientId(@RequestParam long patientId){
        return encounterService.getEncountersByPatientId(patientId);
    }
}
