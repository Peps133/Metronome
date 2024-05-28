package Controller;

import Entity.MetronomeSession;
import Service.MetronomeSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<MetronomeSession> saveSession(@RequestBody MetronomeSession metronomeSession) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        metronomeSession.setUsername(username);

        MetronomeSession savedSession = metronomeSessionService.save(metronomeSession);

        return ResponseEntity.ok(savedSession);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MetronomeSession>> getAllSessions() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        List<MetronomeSession> sessions = metronomeSessionService.findByUsername(username);

        return ResponseEntity.ok(sessions);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSession(@PathVariable Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        metronomeSessionService.deleteByIdAndUsername(id, username);

        return ResponseEntity.ok().build();
    }
}
