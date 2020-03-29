package eu.bopet.bobom.core.entities;

import eu.bopet.bobom.core.entities.names.CategoryGroupNames;
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
@Table(name = "category_groups", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "CategoryGroups.findAll", query = "SELECT c FROM CategoryGroups c"),
        @NamedQuery(name = "CategoryGroups.findById", query = "SELECT c FROM CategoryGroups c WHERE c.id = :id"),
        @NamedQuery(name = "CategoryGroups.findByDescription", query = "SELECT c FROM CategoryGroups c WHERE c.description = :description"),
        @NamedQuery(name = "CategoryGroups.findByFields", query = "SELECT c FROM CategoryGroups c "
                + "WHERE c.description = ?1 AND c.categoryGroupName = ?2")})
public class CategoryGroups extends DBEntities implements Serializable {

    @Column(name = "description")
    private String description;
    @Transient
    private StringProperty descriptionP;
    @JoinColumn(name = "category_group_name", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private CategoryGroupNames categoryGroupName;
    @Transient
    private ObjectProperty<CategoryGroupNames> categoryGroupNameP;

    public CategoryGroups() {
    }

    public CategoryGroups(Object[] fields) {
        updateFields(fields);
    }

    @Override
    public void updateFields(Object[] fields) {
        setDescription((String) fields[0]);
        setCategoryGroupName((CategoryGroupNames) fields[1]);
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

    public CategoryGroupNames getCategoryGroupName() {
        return categoryGroupName;
    }

    public void setCategoryGroupName(CategoryGroupNames categoryGroupName) {
        this.categoryGroupName = categoryGroupName;
        if (categoryGroupNameP != null) {
            categoryGroupNameP.setValue(this.categoryGroupName);
        }
    }

    public ObjectProperty<CategoryGroupNames> categoryGroupNameProperty() {
        if (categoryGroupNameP == null) {
            categoryGroupNameP = new SimpleObjectProperty<>(this.categoryGroupName);
        }
        return categoryGroupNameP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CategoryGroups)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        CategoryGroups that = (CategoryGroups) o;
        return Objects.equals(description, that.description)
                && categoryGroupName.equals(that.categoryGroupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description, categoryGroupName);
    }

    @Override
    public String toString() {
        return "CategoryGroups{"
                + "id=" + getId()
                + ", description='" + description + '\''
                + ", categoryGroupName=" + categoryGroupName
                + '}';
    }
}
