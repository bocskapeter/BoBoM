package eu.bopet.bobom.core.entities;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author bocskapeter
 */
@Entity
@Table(name = "unit_convert_values", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "UnitConvertValues.findAll", query = "SELECT u FROM UnitConvertValues u"),
        @NamedQuery(name = "UnitConvertValues.findById", query = "SELECT u FROM UnitConvertValues u WHERE u.id = :id"),
        @NamedQuery(name = "UnitConvertValues.findByConvertValue", query = "SELECT u FROM UnitConvertValues u WHERE u.convertValue = :convertValue"),
        @NamedQuery(name = "UnitConvertValues.findByFields", query = "SELECT u FROM UnitConvertValues u "
                + "WHERE u.convertValue = ?1 AND u.fromUnit = ?2 AND u.toUnit = ?3")})
public class UnitConvertValues extends DBEntities implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "convert_value", nullable = false)
    private BigDecimal convertValue;
    @Transient
    private ObjectProperty<BigDecimal> convertValueP;
    @JoinColumn(name = "from_unit", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Units fromUnit;
    @Transient
    private ObjectProperty<Units> fromUnitP;
    @JoinColumn(name = "to_unit", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Units toUnit;
    @Transient
    private ObjectProperty<Units> toUnitP;

    public UnitConvertValues() {
    }

    public UnitConvertValues(Object[] fields) {
        updateFields(fields);
    }

    @Override
    public void updateFields(Object[] fields) {
        setConvertValue((BigDecimal) fields[0]);
        setFromUnit((Units) fields[1]);
        setToUnit((Units) fields[2]);
    }

    public BigDecimal getConvertValue() {
        return convertValue;
    }

    public void setConvertValue(BigDecimal convertValue) {
        this.convertValue = convertValue;
        if (convertValueP != null) {
            convertValueP.setValue(this.convertValue);
        }
    }

    public ObjectProperty<BigDecimal> convertValueProperty() {
        if (convertValueP == null) {
            convertValueP = new SimpleObjectProperty<>(this.convertValue);
        }
        return convertValueP;
    }

    public Units getFromUnit() {
        return fromUnit;
    }

    public void setFromUnit(Units fromUnit) {
        this.fromUnit = fromUnit;
        if (fromUnitP != null) {
            fromUnitP.setValue(this.fromUnit);
        }
    }

    public ObjectProperty<Units> fromUnitProperty() {
        if (fromUnitP == null) {
            fromUnitP = new SimpleObjectProperty<>(this.fromUnit);
        }
        return fromUnitP;
    }

    public Units getToUnit() {
        return toUnit;
    }

    public void setToUnit(Units toUnit) {
        this.toUnit = toUnit;
        if (toUnitP != null) {
            toUnitP.setValue(this.toUnit);
        }
    }

    public ObjectProperty<Units> toUnitProperty() {
        if (toUnitP == null) {
            toUnitP = new SimpleObjectProperty<>(this.toUnit);
        }
        return toUnitP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UnitConvertValues)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        UnitConvertValues that = (UnitConvertValues) o;
        return convertValue.equals(that.convertValue)
                && fromUnit.equals(that.fromUnit)
                && toUnit.equals(that.toUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), convertValue, fromUnit, toUnit);
    }

    @Override
    public String toString() {
        return "UnitConvertValues{"
                + "id=" + getId()
                + ", convertValue=" + convertValue
                + ", fromUnit=" + fromUnit
                + ", toUnit=" + toUnit
                + '}';
    }
}
