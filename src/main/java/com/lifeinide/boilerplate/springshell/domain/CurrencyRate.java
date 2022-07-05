package com.lifeinide.boilerplate.springshell.domain;

import com.lifeinide.boilerplate.springshell.enums.Currency;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = CurrencyRate.TABLE)
@Getter
@SuperBuilder
@NoArgsConstructor
public class CurrencyRate extends AbstractEntity {

	public static final String TABLE = "currency_rate";

	@Column(nullable = false)
	@NotNull
	@Enumerated(EnumType.STRING)
	private Currency currency;
	
	@Setter
	@Default
	private BigDecimal rate = BigDecimal.ONE;

}
