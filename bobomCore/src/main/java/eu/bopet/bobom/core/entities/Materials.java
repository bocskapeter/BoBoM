package eu.bopet.bobom.core.entities;

import eu.bopet.bobom.core.entities.names.MaterialNames;
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
@Table(name = "materials", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Materials.findAll", query = "SELECT m FROM Materials m"),
        @NamedQuery(name = "Materials.findById", query = "SELECT m FROM Materials m WHERE m.id = :id"),
        @NamedQuery(name = "Materials.findByNumber", query = "SELECT m FROM Materials m WHERE m.materialNumber = :materialNumber"),
        @NamedQuery(name = "Materials.findByDescription", query = "SELECT m FROM Materials m WHERE m.description = :description"),
        @NamedQuery(name = "Materials.findByFields", query = "SELECT m FROM Materials m "
                + "WHERE m.description = ?1 AND m.materialName = ?2 AND m.materialNumber =?3"),})
public class Materials extends DBEntities implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "material_number", nullable = false)
    private String materialNumber;
    @Transient
    private StringProperty materialNumberP;
    @Column(name = "description")
    private String description;
    @Transient
    private StringProperty descriptionP;
    @JoinColumn(name = "material_name", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private MaterialNames materialName;
    @Transient
    private ObjectProperty<MaterialNames> materialNameP;

    public Materials() {
    }

    public Materials(Object[] fields) {
        updateFields(fields);
    }

    @Override
    public void updateFields(Object[] fields) {
        setDescription((String) fields[0]);
        setMaterialName((MaterialNames) fields[1]);
        setMaterialNumber((String) fields[2]);
    }

    public String getMaterialNumber() {
        return materialNumber;
    }

    public void setMaterialNumber(String materialNumber) {
        this.materialNumber = materialNumber;
        if (materialNumberP != null) {
            materialNumberP.setValue(this.materialNumber);
        }
    }

    public StringProperty materialNumberProperty() {
        if (materialNumberP == null) {
            materialNumberP = new SimpleStringProperty(this.materialNumber);
        }
        return materialNumberP;
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

    public MaterialNames getMaterialName() {
        return materialName;
    }

    public void setMaterialName(MaterialNames materialName) {
        this.materialName = materialName;
        if (materialNameP != null) {
            materialNameP.setValue(this.materialName);
        }
    }

    public ObjectProperty<MaterialNames> materialNameProperty() {
        if (materialNameP == null) {
            materialNameP = new SimpleObjectProperty<>(this.materialName);
        }
        return materialNameP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Materials)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Materials materials = (Materials) o;
        return Objects.equals(description, materials.description)
                && materialName.equals(materials.materialName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description, materialName);
    }

    @Override
    public String toString() {
        return "Materials{"
                + "id=" + getId()
                + " ,description='" + description + '\''
                + ", materialName=" + materialName
                + '}';
    }
}
