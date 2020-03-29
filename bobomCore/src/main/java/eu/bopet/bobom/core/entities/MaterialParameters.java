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
@Table(name = "material_parameters", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "MaterialParameters.findAll", query = "SELECT m FROM MaterialParameters m"),
        @NamedQuery(name = "MaterialParameters.findById", query = "SELECT m FROM MaterialParameters m WHERE m.id = :id"),
        @NamedQuery(name = "MaterialParameters.findByFields", query = "SELECT m FROM MaterialParameters m "
                + "WHERE m.seq = ?1 AND m.material = ?2 AND m.parameter = ?3 AND m.seq = ?4")})
public class MaterialParameters extends DBEntities implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "seq", nullable = false)
    private int seq;
    @Transient
    private IntegerProperty seqP;
    @JoinColumn(name = "material", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Materials material;
    @Transient
    private ObjectProperty<Materials> materialP;
    @JoinColumn(name = "parameter", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Parameters parameter;
    @Transient
    private ObjectProperty<Parameters> parameterP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "val", nullable = false)
    private BigDecimal val;
    @Transient
    private ObjectProperty<BigDecimal> valP;

    public MaterialParameters() {
    }

    public MaterialParameters(Object[] fields) {
        updateFields(fields);
    }

    @Override
    public void updateFields(Object[] fields) {
        setSeq((Integer) fields[0]);
        setMaterial((Materials) fields[1]);
        setParameter((Parameters) fields[2]);
        setVal((BigDecimal) fields[3]);
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

    public Materials getMaterial() {
        return material;
    }

    public void setMaterial(Materials material) {
        this.material = material;
        if (this.materialP != null) {
            materialP.setValue(this.material);
        }
    }

    public ObjectProperty<Materials> materialProperty() {
        if (materialP == null) {
            materialP = new SimpleObjectProperty<>(this.material);
        }
        return materialP;
    }

    public Parameters getParameter() {
        return parameter;
    }

    public void setParameter(Parameters parameter) {
        this.parameter = parameter;
        if (parameterP != null) {
            parameterP.setValue(this.parameter);
        }
    }

    public ObjectProperty<Parameters> parameterProperty() {
        if (parameterP == null) {
            parameterP = new SimpleObjectProperty<>(this.parameter);
        }
        return parameterP;
    }

    public BigDecimal getVal() {
        return val;
    }

    public void setVal(BigDecimal val) {
        this.val = val;
        if (valP != null) {
            valP.setValue(this.val);
        }
    }

    public ObjectProperty<BigDecimal> valProperty() {
        if (valP == null) {
            valP = new SimpleObjectProperty<>(this.val);
        }
        return valP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        MaterialParameters that = (MaterialParameters) o;
        return seq == that.seq
                && material.equals(that.material)
                && parameter.equals(that.parameter)
                && val.equals(that.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), seq, material, parameter, val);
    }

    @Override
    public String toString() {
        return "MaterialStandards{"
                + "id=" + getId()
                + ", seq=" + seq
                + "material=" + material
                + ", parameter=" + parameter
                + ", val=" + val
                + '}';
    }
}
