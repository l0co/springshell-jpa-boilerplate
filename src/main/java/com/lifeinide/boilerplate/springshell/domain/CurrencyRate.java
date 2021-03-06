package com.lifeinide.boilerplate.springshell.domain;

import com.lifeinide.boilerplate.springshell.enums.Currency;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.function.BiConsumer;

@Entity
@Table(name = CurrencyRate.TABLE)
@Getter
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
public class CurrencyRate extends AbstractEntity {

	public static final String TABLE = "currency_rate";

	@Column(nullable = false)
	@NotNull
	@Enumerated(EnumType.STRING)
	private Currency currency;
	
	@Setter
	@Default
	@Column(columnDefinition = "NUMERIC(19, 4)")
	private BigDecimal rate = BigDecimal.ONE;

	@Override
	protected void collectDisplayProperties(BiConsumer<String, Object> p) {
		p.accept("currency", currency);
		p.accept("rate", rate);
	}
}
