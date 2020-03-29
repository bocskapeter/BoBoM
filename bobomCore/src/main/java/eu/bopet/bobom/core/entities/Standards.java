package eu.bopet.bobom.core.entities;

import eu.bopet.bobom.core.entities.names.StandardNames;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author bocskapeter
 */
@Entity
@Table(name = "standards", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Standards.findAll", query = "SELECT s FROM Standards s"),
        @NamedQuery(name = "Standards.findById", query = "SELECT s FROM Standards s WHERE s.id = :id"),
        @NamedQuery(name = "Standards.findByDescription", query = "SELECT s FROM Standards s WHERE s.description = :description"),
        @NamedQuery(name = "Standards.findByFields", query = "SELECT s FROM Standards s "
                + "WHERE s.standardNumber = ?1 AND s.description = ?2 AND s.standardName = ?3")})
public class Standards extends DBEntities implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "standard_number", nullable = false)
    private String standardNumber;
    @Transient
    private StringProperty standardNumberP;
    @Column(name = "description")
    private String description;
    @Transient
    private StringProperty descriptionP;
    @JoinColumn(name = "standard_name", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private StandardNames standardName;
    @Transient
    private ObjectProperty<StandardNames> standardNameP;

    public Standards() {
    }

    public Standards(Object[] fields) {
        updateFields(fields);
    }

    @Override
    public void updateFields(Object[] fields) {
        setStandardNumber((String) fields[0]);
        setDescription((String) fields[1]);
        setStandardName((StandardNames) fields[2]);
    }

    public String getStandardNumber() {
        return standardNumber;
    }

    public void setStandardNumber(String standardNumber) {
        this.standardNumber = standardNumber;
        if (standardNumberP != null) {
            standardNumberP.setValue(this.standardNumber);
        }
    }

    public StringProperty standardNumberProperty() {
        if (standardNumberP == null) {
            standardNumberP = new SimpleStringProperty(standardNumber);
        }
        return standardNumberP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        if (descriptionP != null) {
            descriptionP.setValue(this.description);
        }
    }

    public StringProperty descriptionProperty() {
        if (descriptionP == null) {
            descriptionP = new SimpleStringProperty(this.description);
        }
        return descriptionP;
    }

    public StandardNames getStandardName() {
        return standardName;
    }

    public void setStandardName(StandardNames standardName) {
        this.standardName = standardName;
        if (standardNameP != null) {
            standardNameP.setValue(this.standardName);
        }
    }

    public ObjectProperty<StandardNames> standardNameProperty() {
        if (standardNameP == null) {
            standardNameP = new SimpleObjectProperty<>(this.standardName);
        }
        return standardNameP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Standards)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Standards standards = (Standards) o;
        return Objects.equals(standardNumber, standards.standardNumber)
                && Objects.equals(description, standards.description)
                && Objects.equals(standardName, standards.standardName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), standardNumber, description, standardName);
    }

    @Override
    public String toString() {
        return "Standards{"
                + "id=" + getId()
                + ", standardNumber'=" + standardNumber + '\''
                + ", description='" + description + '\''
                + ", standardName=" + standardName
                + '}';
    }
}
