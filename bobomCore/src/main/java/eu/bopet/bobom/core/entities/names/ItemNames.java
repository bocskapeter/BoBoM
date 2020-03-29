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
@Table(name = "item_names", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "ItemNames.findAll", query = "SELECT i FROM ItemNames i"),
        @NamedQuery(name = "ItemNames.findById", query = "SELECT i FROM ItemNames i WHERE i.id = :id")})
public class ItemNames extends Names {

    public ItemNames() {
        super();
    }

    public ItemNames(Object[] names) {
        super(names);
    }
}
