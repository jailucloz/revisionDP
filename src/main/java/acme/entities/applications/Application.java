
package acme.entities.applications;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.entities.investmentRounds.Investment;
import acme.entities.roles.Entrepreneur;
import acme.entities.roles.Investor;
import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Application extends DomainEntity {

	/*
	 * a ticker, a creation date and moment,
	 * a statement, and an investment money offer.
	 */

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	@Pattern(regexp = "^[A-Z]{3}[-][0-9]{2}[-][0-9]{6}$", message = "{entrepreneur.application.ticker.pattern}")
	private String				ticker;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				creationMoment;

	@NotBlank
	private String				statement;

	@NotNull
	private ApplicationStatus	status;					// PENDIENTE, ACEPTADO O RECHAZADO

	private String				rejectionJustification;			// OBLIGATORIO AL RECHAZAR

	@NotNull
	@Valid
	private Money				offer;

	//control check

	@URL
	private String				additionalInformation;

	@Pattern(regexp = "^(?=.*[A-Za-z]){1,}(?=.*[0-9]){1,}(?=.*[\\W]){1,}[A-Za-z0-9\\W]{10,}$|^$", message = "{investor.application.password.pattern}")
	private String				password;

	// Relationships ----------------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Investment			investmentRound;

	/*
	 * @Valid
	 *
	 * @ManyToOne(optional = false)
	 * private Romp romp;
	 */

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Investor			investor;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Entrepreneur		entrepreneur;

}
