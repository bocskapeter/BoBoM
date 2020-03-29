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
@Table(name = "standard_names", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "StandardNames.findAll", query = "SELECT s FROM StandardNames s"),
        @NamedQuery(name = "StandardNames.findById", query = "SELECT s FROM StandardNames s WHERE s.id = :id")})
public class StandardNames extends Names {

    public StandardNames() {
        super();
    }

    public StandardNames(Object[] names) {
        super(names);
    }
}
