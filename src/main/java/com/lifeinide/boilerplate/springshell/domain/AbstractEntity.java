package com.lifeinide.boilerplate.springshell.domain;

import com.lifeinide.boilerplate.springshell.display.DisplayProperty;
import com.lifeinide.boilerplate.springshell.display.IDisplayProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.BiConsumer;

@Getter
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
@ToString
public class AbstractEntity implements IDisplayProperties {

	public static final String ID_COLUMN = "id";

	public static final String UUID_COLUMN_DEF = "UUID";
	public static final String TIMESTAMP_COLUMN_DEF = "TIMESTAMP WITH TIME ZONE";

	public static final String UUID_HIBERNATE_TYPE = "uuid-char";

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = ID_COLUMN, columnDefinition = UUID_COLUMN_DEF )
	@Type(type=UUID_HIBERNATE_TYPE)
	private UUID id;

	@Override
	public boolean equals(Object o) {
		if (id != null) { // is persisted
			if (this == o) return true;
			if (!(o instanceof AbstractEntity)) return false;
			AbstractEntity that = (AbstractEntity) o;
			return Objects.equals(getId(), that.getId());
		} else
			return super.equals(o);
	}

	@Override
	public int hashCode() {
		if (id != null) // is persisted
			return Objects.hash(getId());
		else
			return super.hashCode();
	}

	@Override
	public final List<DisplayProperty> displayProperties() {
		List<DisplayProperty> properties = new ArrayList<>();
		collectDisplayProperties((name, value) -> properties.add(DisplayProperty.of(name, value)));
		return properties;
	}

	protected void collectDisplayProperties(BiConsumer<String, Object> p) {
		p.accept("id", id);
	}

}
