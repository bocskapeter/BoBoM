package eu.bopet.bobom.core.entities;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author bocskapeter
 */
@Entity
@Table(name = "material_standards", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "MaterialStandards.findAll", query = "SELECT m FROM MaterialStandards m"),
        @NamedQuery(name = "MaterialStandards.findById", query = "SELECT m FROM MaterialStandards m WHERE m.id = :id"),
        @NamedQuery(name = "MaterialStandards.findByFields", query = "SELECT m FROM MaterialStandards m "
                + "WHERE m.material = ?1 AND m.standard = ?2")})
public class MaterialStandards extends DBEntities implements Serializable {

    @JoinColumn(name = "material", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Materials material;
    @Transient
    private ObjectProperty<Materials> materialP;
    @JoinColumn(name = "standard", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Standards standard;
    @Transient
    private ObjectProperty<Standards> standardP;

    public MaterialStandards() {
    }

    public MaterialStandards(Object[] fields) {
        updateFields(fields);
    }

    @Override
    public void updateFields(Object[] fields) {
        setMaterial((Materials) fields[0]);
        setStandard((Standards) fields[1]);
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

    public Standards getStandard() {
        return standard;
    }

    public void setStandard(Standards standard) {
        this.standard = standard;
        if (standardP != null) {
            standardP.setValue(this.standard);
        }
    }

    public ObjectProperty<Standards> standardProperty() {
        if (standardP == null) {
            standardP = new SimpleObjectProperty<>(this.standard);
        }
        return standardP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MaterialStandards)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        MaterialStandards that = (MaterialStandards) o;
        return material.equals(that.material)
                && standard.equals(that.standard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), material, standard);
    }

    @Override
    public String toString() {
        return "MaterialStandards{"
                + "id=" + getId()
                + "material=" + material
                + ", standard=" + standard
                + '}';
    }
}
