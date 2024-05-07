package Repository;

import Entity.SoundFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoundFileRepository extends JpaRepository<SoundFile, Long> {

}

