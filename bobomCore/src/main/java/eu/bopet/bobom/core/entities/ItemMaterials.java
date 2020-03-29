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
@Table(name = "item_materials", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "ItemMaterials.findAll", query = "SELECT i FROM ItemMaterials i"),
        @NamedQuery(name = "ItemMaterials.findById", query = "SELECT i FROM ItemMaterials i WHERE i.id = :id"),
        @NamedQuery(name = "ItemMaterials.findByFields", query = "SELECT i FROM ItemMaterials i "
                + "WHERE i.item = ?1 AND i.material =?2")})
public class ItemMaterials extends DBEntities implements Serializable {

    @JoinColumn(name = "item", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Items item;
    @Transient
    private ObjectProperty<Items> itemP;
    @JoinColumn(name = "material", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Materials material;
    @Transient
    private ObjectProperty<Materials> materialP;

    public ItemMaterials() {
    }

    public ItemMaterials(Object[] fields) {
        updateFields(fields);
    }

    @Override
    public void updateFields(Object[] fields) {
        setItem((Items) fields[0]);
        setMaterial((Materials) fields[1]);
    }

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
        if (this.itemP != null) {
            itemP.setValue(this.item);
        }
    }

    public ObjectProperty<Items> itemProperty() {
        if (itemP == null) {
            itemP = new SimpleObjectProperty<>(this.item);
        }
        return itemP;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ItemMaterials)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        ItemMaterials that = (ItemMaterials) o;
        return item.equals(that.item)
                && material.equals(that.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), item, material);
    }

    @Override
    public String toString() {
        return "ItemMaterials{"
                + "id=" + getId()
                + "item=" + item
                + ", material=" + material
                + '}';
    }
}
