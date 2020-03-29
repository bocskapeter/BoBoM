package eu.bopet.bobom.core.entities;

import eu.bopet.bobom.core.entities.names.ItemNames;
import javafx.beans.property.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author bocskapeter
 */
@Entity
@Table(name = "items", catalog = "bobom", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"item_number"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Items.findAll", query = "SELECT i FROM Items i"),
        @NamedQuery(name = "Items.findById", query = "SELECT i FROM Items i WHERE i.id = :id"),
        @NamedQuery(name = "Items.findByItemNumber", query = "SELECT i FROM Items i WHERE i.itemNumber = :itemNumber"),
        @NamedQuery(name = "Items.findByRevision", query = "SELECT i FROM Items i WHERE i.revision = :revision"),
        @NamedQuery(name = "Items.findByStatus", query = "SELECT i FROM Items i WHERE i.status = :status"),
        @NamedQuery(name = "Items.findByDescription", query = "SELECT i FROM Items i WHERE i.description = :description"),
        @NamedQuery(name = "Items.findByFields", query = "SELECT i FROM Items i"
                + " WHERE i.itemNumber = ?1 AND i.revision = ?2 AND i.status =?3 AND i.description = ?4 AND i.itemName = ?5")})
public class Items extends DBEntities implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "item_number", nullable = false)
    private String itemNumber;
    @Transient
    private StringProperty itemNumberP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "revision", nullable = false)
    private int revision;
    @Transient
    private IntegerProperty revisionP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status", nullable = false)
    private int status;
    @Transient
    private IntegerProperty statusP;
    @Column(name = "description")
    private String description;
    @Transient
    private StringProperty descriptionP;
    @JoinColumn(name = "item_name", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ItemNames itemName;
    @Transient
    private ObjectProperty<ItemNames> itemNameP;

    public Items() {
    }

    public Items(Object[] fields) {
        updateFields(fields);
    }

    @Override
    public void updateFields(Object[] fields) {
        setItemNumber((String) fields[0]);
        setRevision((int) fields[1]);
        setStatus((int) fields[2]);
        setDescription((String) fields[3]);
        setItemName((ItemNames) fields[4]);
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
        if (itemNumberP != null) {
            itemNumberP.setValue(this.itemNumber);
        }
    }

    public StringProperty itemNumberProperty() {
        if (itemNumberP == null) {
            itemNumberP = new SimpleStringProperty(itemNumber);
        }
        return itemNumberP;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
        if (this.revisionP != null) {
            revisionP.setValue(this.revision);
        }
    }

    public IntegerProperty revisionProperty() {
        if (revisionP == null) {
            revisionP = new SimpleIntegerProperty(revision);
        }
        return revisionP;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
        if (this.statusP != null) {
            statusP.setValue(this.status);
        }
    }

    public IntegerProperty statusProperty() {
        if (statusP == null) {
            statusP = new SimpleIntegerProperty(status);
        }
        return statusP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        if (this.descriptionP != null) {
            descriptionP.setValue(this.description);
        }
    }

    public StringProperty descriptionProperty() {
        if (descriptionP == null) {
            descriptionP = new SimpleStringProperty(description);
        }
        return descriptionP;
    }

    public ItemNames getItemName() {
        return itemName;
    }

    public void setItemName(ItemNames itemName) {
        this.itemName = itemName;
        if (itemNameP != null) {
            itemNameP.setValue(this.itemName);
        }
    }

    public ObjectProperty<ItemNames> itemNameProperty() {
        if (itemNameP == null) {
            itemNameP = new SimpleObjectProperty<>(itemName);
        }
        return itemNameP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Items)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Items items = (Items) o;
        return revision == items.revision
                && status == items.status
                && itemNumber.equals(items.itemNumber)
                && Objects.equals(description, items.description)
                && itemName.equals(items.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), itemNumber, revision, status, description, itemName);
    }

    @Override
    public String toString() {
        return "Items{"
                + "id=" + getId()
                + ", itemNumber='" + itemNumber + '\''
                + ", revision=" + revision
                + ", status=" + status
                + ", description='" + description + '\''
                + ", itemName=" + itemName
                + '}';
    }
}
