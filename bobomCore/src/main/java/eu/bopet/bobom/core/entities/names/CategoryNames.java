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
@Table(name = "category_names", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "CategoryNames.findAll", query = "SELECT c FROM CategoryNames c"),
        @NamedQuery(name = "CategoryNames.findById", query = "SELECT c FROM CategoryNames c WHERE c.id = :id")})
public class CategoryNames extends Names {

    public CategoryNames() {
        super();
    }

    public CategoryNames(Object[] names) {
        super(names);
    }
}
