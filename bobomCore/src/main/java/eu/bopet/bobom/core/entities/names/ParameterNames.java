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
@Table(name = "parameter_names", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "ParameterNames.findAll", query = "SELECT p FROM ParameterNames p"),
        @NamedQuery(name = "ParameterNames.findById", query = "SELECT p FROM ParameterNames p WHERE p.id = :id")})
public class ParameterNames extends Names {

    public ParameterNames() {
        super();
    }

    public ParameterNames(Object[] names) {
        super(names);
    }
}
