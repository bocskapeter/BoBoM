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
@Table(name = "item_categories", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "ItemCategories.findAll", query = "SELECT i FROM ItemCategories i"),
        @NamedQuery(name = "ItemCategories.findById", query = "SELECT i FROM ItemCategories i WHERE i.id = :id"),
        @NamedQuery(name = "ItemCategories.findByFields", query = "SELECT i FROM ItemCategories i "
                + "WHERE i.category = ?1 AND i.item = ?2")})
public class ItemCategories extends DBEntities implements Serializable {

    @JoinColumn(name = "category", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Categories category;
    @Transient
    private ObjectProperty<Categories> categoryP;
    @JoinColumn(name = "item", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Items item;
    @Transient
    private ObjectProperty<Items> itemP;

    public ItemCategories() {
    }

    public ItemCategories(Object[] fields) {
        updateFields(fields);
    }

    @Override
    public void updateFields(Object[] fields) {
        setCategory((Categories) fields[0]);
        setItem((Items) fields[1]);
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
        if (this.categoryP != null) {
            categoryP.setValue(this.category);
        }
    }

    public ObjectProperty<Categories> categoryProperty() {
        if (categoryP == null) {
            categoryP = new SimpleObjectProperty<>(this.category);
        }
        return categoryP;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ItemCategories)) {
            return false;
        }
        ItemCategories that = (ItemCategories) o;
        return category.equals(that.category)
                && item.equals(that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, item);
    }

    @Override
    public String toString() {
        return "ItemCategories{"
                + "id=" + getId()
                + ", category=" + category
                + ", item=" + item
                + '}';
    }
}
