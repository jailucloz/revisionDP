
package acme.features.authenticated.romps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.romps.Romp;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedRompShowService implements AbstractShowService<Authenticated, Romp> {

	@Autowired
	private AuthenticatedRompRepository repository;


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
	public Romp findOne(final Request<Romp> request) {
		assert request != null;

		Romp result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findRompById(id);

		return result;
	}

}
