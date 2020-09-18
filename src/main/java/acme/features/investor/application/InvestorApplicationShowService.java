
package acme.features.investor.application;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.roles.Investor;
import acme.entities.romps.Romp;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class InvestorApplicationShowService implements AbstractShowService<Investor, Application> {

	@Autowired
	InvestorApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		boolean result;
		int applicationId;
		Application application;
		Investor investor;
		Principal principal;

		applicationId = request.getModel().getInteger("id");
		application = this.repository.findOneApplicationById(applicationId);
		investor = application.getInvestor();
		principal = request.getPrincipal();
		result = investor.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		Collection<Romp> xx1s = this.repository.findRompsByInvestment(entity.getInvestmentRound().getId());

		Boolean hasPassword = true;
		String password = this.repository.findPasswordOfApp(request.getModel().getInteger("id"));
		if (password == null || password.isEmpty()) {
			hasPassword = false;
		}

		Boolean hasLink = true;
		String link = this.repository.findLinkOfApp(request.getModel().getInteger("id"));
		if (link == null || link.isEmpty()) {
			hasLink = false;
		}
		request.unbind(entity, model, "ticker", "statement", "creationMoment", "offer", "status", "investmentRound", "additionalInformation", "password");

		model.setAttribute("listXX1Empty", xx1s.isEmpty());
		model.setAttribute("noHasPassword", !hasPassword);
		model.setAttribute("hasLink", hasLink);

	}

	@Override
	public Application findOne(final Request<Application> request) {
		assert request != null;

		Application result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneApplicationById(id);

		return result;
	}

}
