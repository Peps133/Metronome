package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Service.SessionService;
import Entity.MetronomeSession;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping("/create")
    public void createSession(@RequestBody MetronomeSession session) {
        sessionService.createSession(session);
    }

}