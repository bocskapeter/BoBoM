package eu.bopet.bobom.core.entities;

import eu.bopet.bobom.core.entities.names.UnitNames;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "units", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Units.findAll", query = "SELECT u FROM Units u"),
        @NamedQuery(name = "Units.findById", query = "SELECT u FROM Units u WHERE u.id = :id"),
        @NamedQuery(name = "Units.findByDescription", query = "SELECT u FROM Units u WHERE u.description = :description"),
        @NamedQuery(name = "Units.findByFields", query = "SELECT u FROM Units u "
                + "WHERE u.description = ?1 AND u.unitQuantity = ?2 AND u.unitName =?3")})
public class Units extends DBEntities implements Serializable {

    @Column(name = "description")
    private String description;
    @Transient
    private StringProperty descriptionP;
    @JoinColumn(name = "unit_quantity", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Quantities unitQuantity;
    @Transient
    private ObjectProperty<Quantities> unitQuantityP;
    @JoinColumn(name = "unit_name", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UnitNames unitName;
    @Transient
    private ObjectProperty<UnitNames> unitNameP;

    public Units() {
    }

    public Units(Object[] fields) {
        updateFields(fields);
    }

    @Override
    public void updateFields(Object[] fields) {
        setDescription((String) fields[0]);
        setUnitQuantity((Quantities) fields[1]);
        setUnitName((UnitNames) fields[2]);
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

    public Quantities getUnitQuantity() {
        return unitQuantity;
    }

    public void setUnitQuantity(Quantities unitQuantity) {
        this.unitQuantity = unitQuantity;
        if (this.unitQuantityP != null) {
            unitQuantityP.setValue(this.unitQuantity);
        }
    }

    public ObjectProperty<Quantities> unitQuantityProperty() {
        if (unitQuantityP == null) {
            unitQuantityP = new SimpleObjectProperty<>(unitQuantity);
        }
        return unitQuantityP;
    }

    public UnitNames getUnitName() {
        return unitName;
    }

    public void setUnitName(UnitNames unitName) {
        this.unitName = unitName;
        if (this.unitNameP != null) {
            unitNameP.setValue(this.unitName);
        }
    }

    public ObjectProperty<UnitNames> unitNameProperty() {
        if (unitNameP == null) {
            unitNameP = new SimpleObjectProperty<>(unitName);
        }
        return unitNameP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Units)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Units units = (Units) o;
        return Objects.equals(description, units.description)
                && unitQuantity.equals(units.unitQuantity)
                && unitName.equals(units.unitName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description, unitQuantity, unitName);
    }

    @Override
    public String toString() {
        return "Units{"
                + "id=" + getId()
                + ", description='" + description + '\''
                + ", unitQuantity=" + unitQuantity
                + ", unitName=" + unitName
                + '}';
    }
}
