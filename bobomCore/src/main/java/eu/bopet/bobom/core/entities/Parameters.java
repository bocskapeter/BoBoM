package eu.bopet.bobom.core.entities;

import eu.bopet.bobom.core.entities.names.ParameterNames;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author bocskapeter
 */
@Entity
@Table(name = "parameters", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Parameters.findAll", query = "SELECT p FROM Parameters p"),
        @NamedQuery(name = "Parameters.findById", query = "SELECT p FROM Parameters p WHERE p.id = :id"),
        @NamedQuery(name = "Parameters.findByDescription", query = "SELECT p FROM Parameters p WHERE p.description = :description"),
        @NamedQuery(name = "Parameters.findByFields", query = "SELECT p FROM Parameters p "
                + "WHERE p.description = ?1 AND p.parameterName = ?2 AND p.parameterUnit = ?3")})
public class Parameters extends DBEntities implements Serializable {

    @Column(name = "description")
    private String description;
    @Transient
    private StringProperty descriptionP;
    @JoinColumn(name = "parameter_name", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ParameterNames parameterName;
    @Transient
    private ObjectProperty<ParameterNames> parameterNameP;
    @JoinColumn(name = "parameter_unit", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Units parameterUnit;
    @Transient
    private ObjectProperty<Units> parameterUnitP;

    public Parameters() {
    }

    public Parameters(Object[] fields) {
        updateFields(fields);
    }

    @Override
    public void updateFields(Object[] fields) {
        setDescription((String) fields[0]);
        setParameterName((ParameterNames) fields[1]);
        setParameterUnit((Units) fields[2]);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        if (this.descriptionP != null) {
            descriptionP.setValue(this.description);
        }
    }

    public StringProperty descriptionProperty() {
        if (descriptionP == null) {
            descriptionP = new SimpleStringProperty(description);
        }
        return descriptionP;
    }

    public ParameterNames getParameterName() {
        return parameterName;
    }

    public void setParameterName(ParameterNames parameterName) {
        this.parameterName = parameterName;
        if (parameterNameP != null) {
            parameterNameP.setValue(this.parameterName);
        }
    }

    public ObjectProperty<ParameterNames> parameterNameProperty() {
        if (parameterNameP == null) {
            parameterNameP = new SimpleObjectProperty<>(this.parameterName);
        }
        return parameterNameP;
    }

    public Units getParameterUnit() {
        return parameterUnit;
    }

    public void setParameterUnit(Units parameterUnit) {
        this.parameterUnit = parameterUnit;
        if (parameterUnitP != null) {
            parameterUnitP.setValue(this.parameterUnit);
        }
    }

    public ObjectProperty<Units> parameterUnitProperty() {
        if (parameterUnitP == null) {
            parameterUnitP = new SimpleObjectProperty<>(this.parameterUnit);
        }
        return parameterUnitP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Parameters)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Parameters that = (Parameters) o;
        return Objects.equals(description, that.description)
                && parameterName.equals(that.parameterName)
                && parameterUnit.equals(that.parameterUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description, parameterName, parameterUnit);
    }

    @Override
    public String toString() {
        return "Parameters{"
                + "id=" + getId()
                + ", description='" + description + '\''
                + ", parameterName=" + parameterName
                + ", parameterUnit=" + parameterUnit
                + '}';
    }
}
