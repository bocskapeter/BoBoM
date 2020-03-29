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
@Table(name = "material_names", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "MaterialNames.findAll", query = "SELECT m FROM MaterialNames m"),
        @NamedQuery(name = "MaterialNames.findById", query = "SELECT m FROM MaterialNames m WHERE m.id = :id")})
public class MaterialNames extends Names {

    public MaterialNames() {
        super();
    }

    public MaterialNames(Object[] names) {
        super(names);
    }
}
