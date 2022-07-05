package com.lifeinide.boilerplate.springshell.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Getter
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
public class AbstractEntity {

	public static final String DISCRIMINATOR_COLUMN = "cls";
	public static final String ID_COLUMN = "id";

	public static final String UUID_COLUMN_DEF = "UUID";
	public static final String TIMESTAMP_COLUMN_DEF = "TIMESTAMP WITH TIME ZONE";

	public static final String UUID_HIBERNATE_TYPE = "uuid-char";

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(columnDefinition = UUID_COLUMN_DEF )
	@Type(type=UUID_HIBERNATE_TYPE)
	private UUID id;

	@Version
	private Integer version;

	@Column(updatable = false, insertable = false) // should be used as a discriminator column
	protected String cls = getClass().getSimpleName();

	@Override
	public boolean equals(Object o) {
		if (id != null) { // is persisted
			if (this == o) return true;
			if (!(o instanceof AbstractEntity)) return false;
			AbstractEntity that = (AbstractEntity) o;
			return Objects.equals(getId(), that.getId()) &&
				Objects.equals(getCls(), that.getCls());
		} else
			return super.equals(o);
	}

	@Override
	public int hashCode() {
		if (id != null) // is persisted
			return Objects.hash(getId(), getCls());
		else
			return super.hashCode();
	}



}
