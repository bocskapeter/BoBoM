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
@Table(name = "category_group_names", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "CategoryGroupNames.findAll", query = "SELECT c FROM CategoryGroupNames c"),
        @NamedQuery(name = "CategoryGroupNames.findById", query = "SELECT c FROM CategoryGroupNames c WHERE c.id = :id")})
public class CategoryGroupNames extends Names {

    public CategoryGroupNames() {
        super();
    }

    public CategoryGroupNames(Object[] names) {
        super(names);
    }
}
