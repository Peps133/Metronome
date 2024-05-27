package Controller;

import Entity.MetronomeSession;
import Service.MetronomeSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/metronome-sessions")
public class MetronomeSessionController {

    private final MetronomeSessionService metronomeSessionService;

    @Autowired
    public MetronomeSessionController(MetronomeSessionService metronomeSessionService) {
        this.metronomeSessionService = metronomeSessionService;
    }

    @PostMapping("/save")
    public ResponseEntity<MetronomeSession> saveSession(@RequestBody MetronomeSession metronomeSession, Principal principal) {
        metronomeSession.setUsername(principal.getName());
        MetronomeSession savedSession = metronomeSessionService.save(metronomeSession);
        return ResponseEntity.ok(savedSession);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MetronomeSession>> getAllSessions(Principal principal) {
        List<MetronomeSession> sessions = metronomeSessionService.findByUsername(principal.getName());
        return ResponseEntity.ok(sessions);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSession(@PathVariable Long id, Principal principal) {
        metronomeSessionService.deleteByIdAndUsername(id, principal.getName());
        return ResponseEntity.ok().build();
    }
}
