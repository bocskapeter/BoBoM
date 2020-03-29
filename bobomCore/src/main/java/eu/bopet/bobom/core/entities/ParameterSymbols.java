package eu.bopet.bobom.core.entities;

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
@Table(name = "parameter_symbols", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "ParameterSymbols.findAll", query = "SELECT p FROM ParameterSymbols p"),
        @NamedQuery(name = "ParameterSymbols.findById", query = "SELECT p FROM ParameterSymbols p WHERE p.id = :id"),
        @NamedQuery(name = "ParameterSymbols.findBySymbol", query = "SELECT p FROM ParameterSymbols p WHERE p.symbol = :symbol"),
        @NamedQuery(name = "ParameterSymbols.findByPos", query = "SELECT p FROM ParameterSymbols p WHERE p.pos = :pos"),
        @NamedQuery(name = "ParameterSymbols.findByFields", query = "SELECT p FROM ParameterSymbols p "
                + "WHERE p.symbol = ?1 AND p.pos = ?2 AND p.parameter = ?3")})
public class ParameterSymbols extends DBEntities implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "symbol", nullable = false)
    private String symbol;
    @Transient
    private StringProperty symbolP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pos", nullable = false)
    private String pos;
    @Transient
    private StringProperty posP;
    @JoinColumn(name = "parameter", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Parameters parameter;
    @Transient
    private ObjectProperty<Parameters> parameterP;

    public ParameterSymbols() {
    }

    public ParameterSymbols(Object[] fields) {
        updateFields(fields);
    }

    @Override
    public void updateFields(Object[] fields) {
        setSymbol((String) fields[0]);
        setPos((String) fields[1]);
        setParameter((Parameters) fields[2]);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
        if (symbolP != null) {
            symbolP.setValue(this.symbol);
        }
    }

    public StringProperty symbolProperty() {
        if (symbolP == null) {
            symbolP = new SimpleStringProperty(this.symbol);
        }
        return symbolP;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
        if (posP != null) {
            posP.setValue(this.pos);
        }
    }

    public StringProperty posProperty() {
        if (posP == null) {
            posP = new SimpleStringProperty(this.pos);
        }
        return posP;
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
        if (!(o instanceof ParameterSymbols)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        ParameterSymbols that = (ParameterSymbols) o;
        return symbol.equals(that.symbol)
                && pos.equals(that.pos)
                && parameter.equals(that.parameter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), symbol, pos, parameter);
    }

    @Override
    public String toString() {
        return "ParameterSymbols{"
                + "id=" + getId()
                + ", symbol='" + symbol + '\''
                + ", pos='" + pos + '\''
                + ", parameter=" + parameter
                + '}';
    }
}
