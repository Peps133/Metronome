package Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TempoRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "metronome_id", nullable = false)
    private Metronome metronome;

    private String title;

    private int tempo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date recordDate;

    public TempoRecord() {
    }

    public TempoRecord(Metronome metronome, String title, int tempo, Date recordDate) {
        this.metronome = metronome;
        this.title = title;
        this.tempo = tempo;
        this.recordDate = recordDate;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }
}
