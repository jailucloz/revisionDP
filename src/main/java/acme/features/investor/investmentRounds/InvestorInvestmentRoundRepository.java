
package acme.features.investor.investmentRounds;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investmentRounds.Investment;
import acme.entities.romps.Romp;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InvestorInvestmentRoundRepository extends AbstractRepository {

	@Query("select i from Investment  i where i.finalMode = 1")
	Collection<Investment> findActivesInvestmentRounds();

	@Query("select i from Investment i where i.id =?1")
	Investment findOneInvestmentRoundById(int id);

	@Query("select r from Romp r where r.investment.id = ?1")
	Collection<Romp> findRompByInvestmentId(int id);

	@Query("select r.id from Romp r where r.investment.id = ?1")
	Integer idRompOfTheInvestment(int id);
}
