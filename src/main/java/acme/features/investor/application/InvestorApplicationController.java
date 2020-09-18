
package acme.features.investor.application;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.applications.Application;
import acme.entities.roles.Investor;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/investor/application/")
public class InvestorApplicationController extends AbstractController<Investor, Application> {

	@Autowired
	private InvestorApplicationShowService			showService;

	@Autowired
	private InvestorApplicationListMineService		listMineService;

	@Autowired
	private InvestorApplicationCreateService		createService;

	@Autowired
	private InvestorApplicationUpdateOfferService	updateService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listMineService);
		super.addCustomCommand(CustomCommand.UPDATE_OFFER, BasicCommand.UPDATE, this.updateService);

	}

}