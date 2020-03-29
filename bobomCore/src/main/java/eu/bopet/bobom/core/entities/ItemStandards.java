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
@Table(name = "item_standards", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "ItemStandards.findAll", query = "SELECT i FROM ItemStandards i"),
        @NamedQuery(name = "ItemStandards.findById", query = "SELECT i FROM ItemStandards i WHERE i.id = :id"),
        @NamedQuery(name = "ItemStandards.findByFields", query = "SELECT i FROM ItemStandards i "
                + "WHERE i.item = ?1 AND i.standard = ?2")})
public class ItemStandards extends DBEntities implements Serializable {

    @JoinColumn(name = "item", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Items item;
    @Transient
    private ObjectProperty<Items> itemP;
    @JoinColumn(name = "standard", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Standards standard;
    @Transient
    private ObjectProperty<Standards> standardP;

    public ItemStandards() {
    }

    public ItemStandards(Object[] fields) {
        updateFields(fields);
    }

    @Override
    public void updateFields(Object[] fields) {
        setItem((Items) fields[0]);
        setStandard((Standards) fields[1]);
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
        if (!(o instanceof ItemStandards)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        ItemStandards that = (ItemStandards) o;
        return item.equals(that.item)
                && standard.equals(that.standard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), item, standard);
    }

    @Override
    public String toString() {
        return "ItemStandards{"
                + "id=" + getId()
                + "item=" + item
                + ", standard=" + standard
                + '}';
    }
}
