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
@Table(name = "unit_names", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "UnitNames.findAll", query = "SELECT u FROM UnitNames u"),
        @NamedQuery(name = "UnitNames.findById", query = "SELECT u FROM UnitNames u WHERE u.id = :id")})
public class UnitNames extends Names {

    public UnitNames() {
        super();
    }

    public UnitNames(Object[] names) {
        super(names);
    }
}
