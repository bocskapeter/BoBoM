package eu.bopet.bobom.core.entities.names;


import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author bocskapeter
 */
@Entity
@Table(name = "unit_symbols", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "UnitSymbols.findAll", query = "SELECT u FROM UnitSymbols u"),
        @NamedQuery(name = "UnitSymbols.findById", query = "SELECT u FROM UnitSymbols u WHERE u.id = :id")})
public class UnitSymbols extends Names {

    public UnitSymbols() {
        super();
    }

    public UnitSymbols(Object[] names) {
        super(names);
    }
}
