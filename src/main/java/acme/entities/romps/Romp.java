
package acme.entities.romps;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import acme.entities.investmentRounds.Investment;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Romp extends DomainEntity {

	private static final long	serialVersionUID	= 1;

	@NotBlank
	@Length(max = 1024)
	private String				text;

	@NotNull
	@Valid
	@OneToOne(optional = false)
	private Investment			investment;

}
