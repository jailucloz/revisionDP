
package acme.features.entrepreneur.romp;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.romps.Romp;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EntrepreneurRompRepository extends AbstractRepository {

	@Query("select r from Romp r where r.investment.id =?1")
	Collection<Romp> findAllRompByInvestmentId(int id);

}
