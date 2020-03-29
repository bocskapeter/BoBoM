package eu.bopet.bobom.core.entities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author bocskapeter
 */
@Entity
@Table(name = "category_parameters", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "CategoryParameters.findAll", query = "SELECT c FROM CategoryParameters c"),
        @NamedQuery(name = "CategoryParameters.findById", query = "SELECT c FROM CategoryParameters c WHERE c.id = :id"),
        @NamedQuery(name = "CategoryParameters.findBySeq", query = "SELECT c FROM CategoryParameters c WHERE c.seq = :seq"),
        @NamedQuery(name = "CategoryParameters.findByFields", query = "SELECT c FROM CategoryParameters c "
                + "WHERE c.seq = ?1 AND c.category = ?2 AND c.parameter = ?3")})
public class CategoryParameters extends DBEntities implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "seq", nullable = false)
    private int seq;
    @Transient
    private IntegerProperty seqP;
    @JoinColumn(name = "category", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Categories category;
    @Transient
    private ObjectProperty<Categories> categoryP;
    @JoinColumn(name = "parameter", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Parameters parameter;
    @Transient
    private ObjectProperty<Parameters> parameterP;

    public CategoryParameters() {
    }

    public CategoryParameters(Object[] fields) {
        updateFields(fields);
    }

    @Override
    public void updateFields(Object[] fields) {
        setSeq((int) fields[0]);
        setCategory((Categories) fields[1]);
        setParameter((Parameters) fields[2]);
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
        if (!(o instanceof CategoryParameters)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        CategoryParameters that = (CategoryParameters) o;
        return seq == that.seq
                && category.equals(that.category)
                && parameter.equals(that.parameter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), seq, category, parameter);
    }

    @Override
    public String toString() {
        return "CategoryParameters{"
                + "id=" + getId()
                + ", seq=" + seq
                + ", category=" + category
                + ", parameter=" + parameter
                + '}';
    }
}
