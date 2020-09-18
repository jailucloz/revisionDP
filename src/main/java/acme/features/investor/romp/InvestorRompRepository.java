
package acme.features.investor.romp;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.romps.Romp;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InvestorRompRepository extends AbstractRepository {

	@Query("select r from Romp r where r.investment.id =?1")
	Collection<Romp> findAllRompByInvestmentId(int id);

	@Query("select r from Romp r where r.id =?1")
	Romp findRompById(int id);

}
