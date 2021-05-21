package kodamaio.hrms.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;
import kodamaio.hrms.entities.Position;

public interface PositionRepository extends JpaRepository<Position,Integer> {

}
