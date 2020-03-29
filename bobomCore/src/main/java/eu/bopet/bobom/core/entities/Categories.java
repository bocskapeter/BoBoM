package eu.bopet.bobom.core.entities;

import eu.bopet.bobom.core.entities.names.CategoryNames;
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
@Table(name = "categories", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Categories.findAll", query = "SELECT c FROM Categories c"),
        @NamedQuery(name = "Categories.findById", query = "SELECT c FROM Categories c WHERE c.id = :id"),
        @NamedQuery(name = "Categories.findByDescription", query = "SELECT c FROM Categories c WHERE c.description = :description"),
        @NamedQuery(name = "Categories.findByFields", query = "SELECT c FROM Categories c "
                + "WHERE c.description = ?1 AND c.categoryGroup = ?2 AND c.categoryName = ?3")})
public class Categories extends DBEntities implements Serializable {

    @Column(name = "description")
    private String description;
    @Transient
    private StringProperty descriptionP;
    @JoinColumn(name = "category_group", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private CategoryGroups categoryGroup;
    @Transient
    private ObjectProperty<CategoryGroups> categoryGroupP;
    @JoinColumn(name = "category_name", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private CategoryNames categoryName;
    @Transient
    private ObjectProperty<CategoryNames> categoryNameP;

    public Categories() {
    }

    public Categories(Object[] fields) {
        updateFields(fields);
    }

    @Override
    public void updateFields(Object[] fields) {
        setDescription((String) fields[0]);
        setCategoryGroup((CategoryGroups) fields[1]);
        setCategoryName((CategoryNames) fields[2]);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        if (descriptionP != null) {
            descriptionP.setValue(this.description);
        }
    }

    public StringProperty descriptionProperty() {
        if (descriptionP == null) {
            descriptionP = new SimpleStringProperty(this.description);
        }
        return descriptionP;
    }

    public CategoryGroups getCategoryGroup() {
        return categoryGroup;
    }

    public void setCategoryGroup(CategoryGroups categoryGroup) {
        this.categoryGroup = categoryGroup;
        if (categoryGroupP != null) {
            categoryGroupP.setValue(this.categoryGroup);
        }
    }

    public ObjectProperty<CategoryGroups> categoryGroupProperty() {
        if (categoryGroupP == null) {
            categoryGroupP = new SimpleObjectProperty<>(categoryGroup);
        }
        return categoryGroupP;
    }

    public CategoryNames getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(CategoryNames categoryName) {
        this.categoryName = categoryName;
        if (categoryNameP != null) {
            categoryNameP.setValue(this.categoryName);
        }
    }

    public ObjectProperty<CategoryNames> categoryNamePProperty() {
        if (categoryNameP == null) {
            categoryNameP = new SimpleObjectProperty<>(categoryName);
        }
        return categoryNameP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Categories)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Categories that = (Categories) o;
        return Objects.equals(description, that.description)
                && categoryGroup.equals(that.categoryGroup)
                && categoryName.equals(that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description, categoryGroup, categoryName);
    }

    @Override
    public String toString() {
        return "Categories{"
                + "id=" + getId()
                + ", description='" + description + '\''
                + ", categoryGroup=" + categoryGroup
                + ", categoryName=" + categoryName
                + '}';
    }
}
