
package acme.features.investor.applicationRomp;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.investmentRounds.Investment;
import acme.entities.roles.Investor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class InvestorApplicationRompListService implements AbstractListService<Investor, Application> {

	@Autowired
	InvestorApplicationRompRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "creationMoment", "ticker", "statement", "offer");

	}

	@Override
	public Collection<Application> findMany(final Request<Application> request) {
		assert request != null;

		Collection<Application> result;

		Investment i = this.repository.findInvestmentByYeah(request.getModel().getInteger("id"));

		result = this.repository.findManyByInvestmentId(i.getId());

		return result;
	}

}
