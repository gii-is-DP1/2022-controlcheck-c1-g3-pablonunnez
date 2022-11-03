package org.springframework.samples.petclinic.recoveryroom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recoveryRooms")
public class RecoveryRoomController {
    private final String VIEW_RECOVERY_ROOM_CREATE_FORM ="recoveryRooms/createOrUpdateProductForm";
    private final String WELCOME = "welcome";
    private RecoveryRoomService rrservice;
    @Autowired
    public RecoveryRoomController(RecoveryRoomService service) {
        this.rrservice = service;
    }
    @GetMapping("/create")
    public String initRecoveryRoom(ModelMap map) {
        map.addAttribute("recoveryRoom", new RecoveryRoom());
        map.addAttribute("types", rrservice.getAllRecoveryRoomTypes());
        return VIEW_RECOVERY_ROOM_CREATE_FORM;
    }
    @PostMapping(path = "/create")
    public String createRecoveryRoom(@Valid RecoveryRoom recoveryRoom, BindingResult br,
    ModelMap map) {
        if(br.hasErrors()) {
            map.addAttribute("recoveryRoom", recoveryRoom);
            map.addAttribute("types", rrservice.getAllRecoveryRoomTypes());
            return VIEW_RECOVERY_ROOM_CREATE_FORM;
        } else {
            map.addAttribute("message", "Recovery room succesfully saved");
        }
        return WELCOME;
    }
}


































