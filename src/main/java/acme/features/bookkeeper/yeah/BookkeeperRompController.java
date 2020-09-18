
package acme.features.bookkeeper.yeah;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.roles.Bookkeeper;
import acme.entities.romps.Romp;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/bookkeeper/romp/")
public class BookkeeperRompController extends AbstractController<Bookkeeper, Romp> {

	@Autowired
	private BookkeeperRompListService listService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
	}

}
