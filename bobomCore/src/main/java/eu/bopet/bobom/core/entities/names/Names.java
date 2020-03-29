package eu.bopet.bobom.core.entities.names;

import eu.bopet.bobom.core.entities.DBEntities;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
public abstract class Names extends DBEntities implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "name_en", nullable = false)
    private String nameEn;
    @Transient
    private StringProperty nameEnP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "name_de", nullable = false)
    private String nameDe;
    @Transient
    private StringProperty nameDeP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "name_hu", nullable = false)
    private String nameHu;
    @Transient
    private StringProperty nameHuP;

    public Names() {
    }

    public Names(Object[] fields) {
        this.updateFields(fields);
    }

    @Override
    public void updateFields(Object[] fields) {
        setNameEn((String) fields[0]);
        setNameDe((String) fields[1]);
        setNameHu((String) fields[2]);
    }

    public String getName(String language) {
        switch (language) {
            case "de":
                return getNameDe();
            case "hu":
                return getNameHu();
            default:
                return getNameEn();
        }
    }

    public StringProperty nameProperty(String language) {
        switch (language) {
            case "de":
                return nameDeProperty();
            case "hu":
                return nameHuProperty();
            default:
                return nameEnProperty();
        }
    }

    public void setName(String language, String name) {
        switch (language) {
            case "de":
                setNameDe(name);
            case "hu":
                setNameHu(name);
            case "en":
                setNameEn(name);
            default:
                setNameEn(name);
        }
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
        if (this.nameEnP != null) {
            nameEnP.setValue(nameEn);
        }
    }

    public StringProperty nameEnProperty() {
        if (nameEnP == null) {
            nameEnP = new SimpleStringProperty(nameEn);
        }
        return nameEnP;
    }

    public String getNameDe() {
        return nameDe;
    }

    public void setNameDe(String nameDe) {
        this.nameDe = nameDe;
        if (this.nameDeP != null) {
            nameDeP.setValue(nameDe);
        }
    }

    public StringProperty nameDeProperty() {
        if (nameDeP == null) {
            nameDeP = new SimpleStringProperty(nameDe);
        }
        return nameDeP;
    }

    public String getNameHu() {
        return nameHu;
    }

    public void setNameHu(String nameHu) {
        this.nameHu = nameHu;
        if (this.nameHuP != null) {
            nameHuP.setValue(nameHu);
        }
    }

    public StringProperty nameHuProperty() {
        if (nameHuP == null) {
            nameHuP = new SimpleStringProperty(nameHu);
        }
        return nameHuP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Names)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Names names = (Names) o;
        return nameEn.equals(names.nameEn)
                && nameDe.equals(names.nameDe)
                && nameHu.equals(names.nameHu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nameEn, nameDe, nameHu);
    }

    @Override
    public String toString() {
        return "Names{"
                + "id=" + getId().toString()
                + ", nameEn='" + nameEn + '\''
                + ", nameDe='" + nameDe + '\''
                + ", nameHu='" + nameHu + '\''
                + '}';
    }
}
