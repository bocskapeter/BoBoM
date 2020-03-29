package eu.bopet.bobom.core.entities;

import eu.bopet.bobom.core.LocaleConverter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Locale;

@Entity
@Table(name = "users", catalog = "bobom", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
        @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"),
        @NamedQuery(name = "Users.findByEMail", query = "SELECT u FROM Users u WHERE u.eMail = :eMail")})
public class Users extends DBEntities {

    @Basic(optional = false)
    @NotNull
    @Column(name = "user_email", nullable = false)
    private String eMail;
    @Transient
    private StringProperty eMailP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_name", nullable = false)
    private String name;
    @Transient
    private StringProperty nameP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_password", nullable = false)
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_locale", nullable = false)
    private String localeString;
    @Transient
    private Locale locale;

    public Users() {
    }

    public Users(Object[] fields) {
        updateFields(fields);
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
        if (eMailP != null) {
            eMailP.setValue(this.eMail);
        }
    }

    public StringProperty eMailPProperty() {
        if (eMailP == null) {
            eMailP = new SimpleStringProperty(eMail);
        }
        return eMailP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        if (nameP != null) {
            nameP.setValue(this.name);
        }
    }

    public StringProperty namePProperty() {
        if (nameP == null) {
            nameP = new SimpleStringProperty(name);
        }
        return nameP;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Locale getLocale() {
        if (locale == null) {
            locale = LocaleConverter.getLocaleFromString(this.localeString);
        }
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        this.localeString = this.locale.toString();
    }

    @Override
    public void updateFields(Object[] fields) {
        this.eMail = (String) fields[0];
        this.name = (String) fields[1];
        this.password = (String) fields[2];
        this.localeString = (String) fields[3];
    }

    @Override
    public String toString() {
        return "User " + eMail + " (" + getId() + ") ";
    }
}
