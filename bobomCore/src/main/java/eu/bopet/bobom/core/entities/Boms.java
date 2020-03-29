package eu.bopet.bobom.core.entities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
@Table(name = "boms", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Boms.findAll", query = "SELECT b FROM Boms b"),
        @NamedQuery(name = "Boms.findById", query = "SELECT b FROM Boms b WHERE b.id = :id"),
        @NamedQuery(name = "Boms.findByAssembly", query = "SELECT b FROM Boms b WHERE b.assembly = :assembly"),
        @NamedQuery(name = "Boms.findByComponent", query = "SELECT b FROM Boms b WHERE b.component = :component"),
        @NamedQuery(name = "Boms.findByPosition", query = "SELECT b FROM Boms b "
                + "WHERE b.assembly = ?1 AND b.seq = ?2"),
        @NamedQuery(name = "Boms.findByFields", query = "SELECT b FROM Boms b "
                + "WHERE b.assembly = ?1 AND b.component = ?2 AND b.seq = ?3 AND b.quantity <= ?4 AND b.quantity >= ?5")})
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

    public Boms() {
    }

    public Boms(Object[] fields) {
        updateFields(fields);
    }

    @Override
    public void updateFields(Object[] fields) {
        setSeq((int) fields[0]);
        setQuantity((BigDecimal) fields[1]);
        setAssembly((Items) fields[2]);
        setComponent((Items) fields[3]);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Boms)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Boms boms = (Boms) o;
        return seq == boms.seq
                && quantity.equals(boms.quantity)
                && assembly.equals(boms.assembly)
                && component.equals(boms.component);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), seq, quantity, assembly, component);
    }

    @Override
    public String toString() {
        return "Boms{"
                + "id=" + getId()
                + ", assembly=" + assembly
                + ", seq=" + seq
                + ", component=" + component
                + ", quantity=" + quantity
                + '}';
    }
}
