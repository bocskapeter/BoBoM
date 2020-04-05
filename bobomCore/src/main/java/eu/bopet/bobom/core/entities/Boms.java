package eu.bopet.bobom.core.entities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author bocskapeter
 */
@Entity
@Table(name = "boms", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Boms.findAll", query = "SELECT b FROM Boms b"),
        @NamedQuery(name = "Boms.findById", query = "SELECT b FROM Boms b WHERE b.id = :id"),
        @NamedQuery(name = "Boms.findByAssembly", query = "SELECT b FROM Boms b WHERE b.assembly = :assembly"),
        @NamedQuery(name = "Boms.findByComponent", query = "SELECT b FROM Boms b WHERE b.component = :component")})
public class Boms extends DBEntities implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "seq", nullable = false)
    private int seq;
    @Transient
    private IntegerProperty seqP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity", nullable = false)
    private BigDecimal quantity;
    @Transient
    private ObjectProperty<BigDecimal> quantityP;
    @JoinColumn(name = "assembly", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Items assembly;
    @Transient
    private ObjectProperty<Items> assemblyP;
    @JoinColumn(name = "component", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Items component;
    @Transient
    private ObjectProperty<Items> componentP;
    @JoinColumn(name = "unit", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Units unit;
    @Transient
    private ObjectProperty<Units> unitP;

    public Boms() {
    }

    public Boms(Object[] fields){
        updateFields(fields);
    }

    @Override
    public void updateFields(Object[] fields) {
        setSeq((Integer) fields[0]);
        setQuantity((BigDecimal) fields[1]);
        setAssembly((Items) fields[2]);
        setComponent((Items) fields[3]);
        setUnit((Units) fields[4]);
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
        if (this.seqP != null) {
            seqP.setValue(this.seq);
        }
    }

    public IntegerProperty seqProperty() {
        if (seqP == null) {
            seqP = new SimpleIntegerProperty(seq);
        }
        return seqP;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
        if (this.quantityP != null) {
            quantityP.setValue(this.quantity);
        }
    }

    public ObjectProperty<BigDecimal> quantityProperty() {
        if (quantityP == null) {
            quantityP = new SimpleObjectProperty<>(quantity);
        }
        return quantityP;
    }

    public Items getAssembly() {
        return assembly;
    }

    public void setAssembly(Items assembly) {
        this.assembly = assembly;
        if (this.assemblyP != null) {
            assemblyP.setValue(this.assembly);
        }
    }

    public ObjectProperty<Items> assemblyProperty() {
        if (assemblyP == null) {
            assemblyP = new SimpleObjectProperty<>(assembly);
        }
        return assemblyP;
    }

    public Items getComponent() {
        return component;
    }

    public void setComponent(Items component) {
        this.component = component;
        if (this.componentP != null) {
            componentP.setValue(this.component);
        }
    }

    public ObjectProperty<Items> componentProperty() {
        if (componentP == null) {
            componentP = new SimpleObjectProperty<>(component);
        }
        return componentP;
    }

    public Units getUnit() {
        return unit;
    }

    public void setUnit(Units unit) {
        this.unit = unit;
        if (this.unitP != null) {
            unitP.setValue(this.unit);
        }
    }

    public ObjectProperty<Units> unitPProperty() {
        if (unitP == null) {
            unitP = new SimpleObjectProperty<>(unit);
        }
        return unitP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Boms boms = (Boms) o;
        return seq == boms.seq &&
                quantity.equals(boms.quantity) &&
                assembly.equals(boms.assembly) &&
                component.equals(boms.component) &&
                unit.equals(boms.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), seq, quantity, assembly, component, unit);
    }

    @Override
    public String toString() {
        return "Boms{" +
                "assembly=" + assembly +
                ", seq=" + seq +
                ", quantity=" + quantity +
                ", unit=" + unit +
                ", component=" + component +
                '}';
    }
}
