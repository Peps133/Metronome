package Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class MetronomeSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "metronome_id", nullable = false)
    private Metronome metronome;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    private String username; // Ajout de l'attribut username

    public MetronomeSession() {
    }

    public MetronomeSession(Metronome metronome, Date startTime, Date endTime, String username) {
        this.metronome = metronome;
        this.startTime = startTime;
        this.endTime = endTime;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Metronome getMetronome() {
        return metronome;
    }

    public void setMetronome(Metronome metronome) {
        this.metronome = metronome;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
