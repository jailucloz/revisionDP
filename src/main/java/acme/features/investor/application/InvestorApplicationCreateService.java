
package acme.features.investor.application;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.investmentRounds.Investment;
import acme.entities.roles.Entrepreneur;
import acme.entities.roles.Investor;
import acme.features.entrepreneur.investmentRound.EntrepreneurInvestmentRoundRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class InvestorApplicationCreateService implements AbstractCreateService<Investor, Application> {

	@Autowired
	private InvestorApplicationRepository	repository;

	@Autowired
	EntrepreneurInvestmentRoundRepository	repositoryInvest;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "additionalInformation", "password");
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "creationMoment", "statement", "offer", "investmentRound.ticker", "additionalInformation", "password");
	}

	@Override
	public Application instantiate(final Request<Application> request) {

		Application result;
		Principal principal;

		principal = request.getPrincipal();

		Entrepreneur entrepreneur;
		result = new Application();

		Investment i = this.repositoryInvest.findOneInvestmentRoundById(request.getModel().getInteger("id"));
		entrepreneur = i.getEntrepreneur();
		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		int investorId = principal.getAccountId();
		Investor investor = this.repository.findOneInvestorByUserAccountId(investorId);

		result.setCreationMoment(moment);
		result.setAdditionalInformation(null);
		result.setPassword(null);
		result.setInvestor(investor);
		result.setInvestmentRound(i);
		result.setEntrepreneur(entrepreneur);

		return result;
	}

	@Override
	public void validate(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors("ticker")) {
			Boolean unique = null;
			unique = this.repository.findApplicationByTicker(entity.getTicker()) != null;
			errors.state(request, !unique, "ticker", "investor.application.error.duplicatedTicker");
		}

		if (!errors.hasErrors("password")) {
			Boolean hasLinkPassword, hasLink, hasPassword = null;
			hasLink = !request.getModel().getString("additionalInformation").isEmpty();
			hasPassword = !request.getModel().getString("password").isEmpty();
			if (!hasLink && hasPassword) {
				hasLinkPassword = false;
			} else {
				hasLinkPassword = true;
			}
			errors.state(request, hasLinkPassword, "password", "investor.application.error.password");

			Boolean regexPassword = null;
			String password = request.getModel().getString("password");
			String regexx = "^(?=.*[A-Za-z]){1,}(?=.*[0-9]){1,}(?=.*[\\W]){1,}[A-Za-z0-9\\W]{10,}$|^$";
			if (password.matches(regexx)) {
				regexPassword = true;
			} else {
				regexPassword = false;
			}
			errors.state(request, regexPassword, "password", "investor.application.error.password.regex");
		}
	}

	@Override
	public void create(final Request<Application> request, final Application entity) {

		this.repository.save(entity);
	}

}
