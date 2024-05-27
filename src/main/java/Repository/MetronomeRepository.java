package Repository;

import Entity.Metronome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetronomeRepository extends JpaRepository<Metronome, Long> {
}
