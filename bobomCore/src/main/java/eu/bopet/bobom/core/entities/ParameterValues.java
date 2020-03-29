package eu.bopet.bobom.core.entities;

import javafx.beans.property.ObjectProperty;
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
@Table(name = "parameter_values", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "ParameterValues.findAll", query = "SELECT p FROM ParameterValues p"),
        @NamedQuery(name = "ParameterValues.findById", query = "SELECT p FROM ParameterValues p WHERE p.id = :id"),
        @NamedQuery(name = "ParameterValues.findByVal", query = "SELECT p FROM ParameterValues p WHERE p.val = :val"),
        @NamedQuery(name = "ParameterValues.findByItemCategory", query = "SELECT p FROM ParameterValues p WHERE p.itemCategory = :itemCategory"),
        @NamedQuery(name = "ParameterValues.findByFields", query = "SELECT p FROM ParameterValues p "
                + "WHERE p.val = ?1 AND p.itemCategory = ?2 AND p.parameter = ?3")})
public class ParameterValues extends DBEntities implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "val", nullable = false)
    private BigDecimal val;
    @Transient
    private ObjectProperty<BigDecimal> valP;
    @JoinColumn(name = "item_category", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ItemCategories itemCategory;
    @Transient
    private ObjectProperty<ItemCategories> itemCategoryP;
    @JoinColumn(name = "parameter", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Parameters parameter;
    @Transient
    private ObjectProperty<Parameters> parameterP;

    public ParameterValues() {
    }

    public ParameterValues(Object[] fields) {
        updateFields(fields);
    }

    @Override
    public void updateFields(Object[] fields) {
        setVal((BigDecimal) fields[0]);
        setItemCategory((ItemCategories) fields[1]);
        setParameter((Parameters) fields[2]);
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

    public ItemCategories getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategories itemCategory) {
        this.itemCategory = itemCategory;
        if (this.itemCategoryP != null) {
            itemCategoryP.setValue(this.itemCategory);
        }
    }

    public ObjectProperty<ItemCategories> itemCategoryProperty() {
        if (itemCategoryP == null) {
            itemCategoryP = new SimpleObjectProperty<>(this.itemCategory);
        }
        return itemCategoryP;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ParameterValues)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        ParameterValues that = (ParameterValues) o;
        return val.equals(that.val)
                && itemCategory.equals(that.itemCategory)
                && parameter.equals(that.parameter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), val, itemCategory, parameter);
    }

    @Override
    public String toString() {
        return "ParameterValues{"
                + "id=" + getId()
                + ", item=" + itemCategory
                + ", val=" + val
                + ", parameter=" + parameter
                + '}';
    }
}
