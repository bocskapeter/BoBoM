package eu.bopet.bobom.core.entities;

import eu.bopet.bobom.core.entities.names.QuantityNames;
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
@Table(name = "quantities", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Quantities.findAll", query = "SELECT q FROM Quantities q"),
        @NamedQuery(name = "Quantities.findById", query = "SELECT q FROM Quantities q WHERE q.id = :id"),
        @NamedQuery(name = "Quantities.findByDescription", query = "SELECT q FROM Quantities q WHERE q.description = :description"),
        @NamedQuery(name = "Quantities.findByFields", query = "SELECT q FROM Quantities q "
                + "WHERE q.description = ?1 AND q.quantityName = ?2")})
public class Quantities extends DBEntities implements Serializable {

    @Column(name = "description")
    private String description;
    @Transient
    private StringProperty descriptionP;
    @JoinColumn(name = "quantity_name", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private QuantityNames quantityName;
    @Transient
    private ObjectProperty<QuantityNames> quantityNameP;

    public Quantities() {
    }

    public Quantities(Object[] fields) {
        updateFields(fields);
    }

    @Override
    public void updateFields(Object[] fields) {
        setDescription((String) fields[0]);
        setQuantityName((QuantityNames) fields[1]);
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

    public QuantityNames getQuantityName() {
        return quantityName;
    }

    public void setQuantityName(QuantityNames quantityName) {
        this.quantityName = quantityName;
        if (this.quantityNameP != null) {
            quantityNameP.setValue(this.quantityName);
        }
    }

    public ObjectProperty<QuantityNames> quantityNameProperty() {
        if (quantityNameP == null) {
            quantityNameP = new SimpleObjectProperty<>(quantityName);
        }
        return quantityNameP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Quantities)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Quantities that = (Quantities) o;
        return Objects.equals(description, that.description)
                && quantityName.equals(that.quantityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description, quantityName);
    }

    @Override
    public String toString() {
        return "Quantities{"
                + "id=" + getId()
                + ", description='" + description + '\''
                + ", quantityName=" + quantityName
                + '}';
    }
}
