package covid.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import covid.model.PreventionModel;

@Repository
public interface PreventionRepo extends JpaRepository<PreventionModel, Integer>{

}
