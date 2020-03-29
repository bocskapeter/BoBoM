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
@Table(name = "quantity_names", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "QuantityNames.findAll", query = "SELECT q FROM QuantityNames q"),
        @NamedQuery(name = "QuantityNames.findById", query = "SELECT q FROM QuantityNames q WHERE q.id = :id")})
public class QuantityNames extends Names {

    public QuantityNames() {
        super();
    }

    public QuantityNames(Object[] names) {
        super(names);
    }
}
