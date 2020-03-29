package eu.bopet.bobom.core.entities;

import eu.bopet.bobom.core.UUIDConverter;
import org.eclipse.persistence.annotations.Convert;
import org.eclipse.persistence.annotations.Converter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
@Converter(name = "uuidConverter", converterClass = UUIDConverter.class)
public abstract class DBEntities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    @Convert("uuidConverter")
    UUID id = UUID.randomUUID();

    public DBEntities() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public abstract void updateFields(Object[] fields);

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DBEntities)) {
            return false;
        }
        DBEntities dbEntities = (DBEntities) o;
        return id.equals(dbEntities.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
