package com.kth.estmm.backend_journal.Controller;

import com.kth.estmm.backend_journal.BO.Role;
import com.kth.estmm.backend_journal.BO.Services.EncounterService;
import com.kth.estmm.backend_journal.BO.User;
import com.kth.estmm.backend_journal.BO.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path ="/journal")
public class MainController {

    private UserService userService;
    private EncounterService encounterService;

    public MainController(UserService userService, EncounterService encounterService) {
        this.userService = userService;
        this.encounterService = encounterService;
    }

    @GetMapping(path = "/users")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping(path = "/addUser")
    public boolean addUser(@RequestParam String name, @RequestParam String email, @RequestParam String password, @RequestParam Role role){
        return userService.addUser(name, email, password, role);

    }

    @PostMapping(path="/addEncounter")
    public boolean addEncounter(@RequestParam long patientId, @RequestParam long doctorId, @RequestParam LocalDateTime date){
        return encounterService.addEncounter(patientId, doctorId, date);
    }




}
