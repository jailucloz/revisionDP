
package acme.features.entrepreneur.romp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.roles.Entrepreneur;
import acme.entities.romps.Romp;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/entrepreneur/romp/")
public class EntrepreneurRompController extends AbstractController<Entrepreneur, Romp> {

	@Autowired
	private EntrepreneurRompListService listService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
	}

}
