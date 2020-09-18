
package acme.features.investor.applicationRomp;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.entities.investmentRounds.Investment;
import acme.entities.romps.Romp;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InvestorApplicationRompRepository extends AbstractRepository {

	@Query("select a from Application a where a.id = ?1")
	Application findOneApplicationById(int id);

	@Query("select a from Application a where a.investmentRound.id = ?1")
	Collection<Application> findManyByInvestmentId(int id);

	@Query("select a from Application a")
	Collection<Application> findAllApplication();

	@Query("select r from Romp r where r.investment.id = ?1")
	Romp findYeahByInvestment(int id);

	@Query("select r.investment from Romp r where r.id = ?1")
	Investment findInvestmentByYeah(int id);

}
