
package acme.features.bookkeeper.yeah;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Bookkeeper;
import acme.entities.romps.Romp;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class BookkeeperRompListService implements AbstractListService<Bookkeeper, Romp> {

	@Autowired
	BookkeeperRompRepository repository;


	@Override
	public boolean authorise(final Request<Romp> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Romp> request, final Romp entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text");
	}

	@Override
	public Collection<Romp> findMany(final Request<Romp> request) {
		assert request != null;

		Collection<Romp> result;

		result = this.repository.findAllRompByInvestmentId(request.getModel().getInteger("id"));

		return result;
	}

}
