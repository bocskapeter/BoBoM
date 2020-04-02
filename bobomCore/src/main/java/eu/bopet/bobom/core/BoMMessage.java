package eu.bopet.bobom.core;

import eu.bopet.bobom.core.entities.Users;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class BoMMessage implements Serializable {
    private BoMActivity activity;
    private Class theClass;
    private Users user;
    private List list;

    public BoMMessage(BoMActivity activity, Class theClass, Users user, List list) {
        this.activity = activity;
        this.theClass = theClass;
        this.user = user;
        this.list = list;
    }

    public BoMActivity getActivity() {
        return activity;
    }

    public Class getTheClass() {
        return theClass;
    }

    public Users getUser() {
        return user;
    }

    public List getList() {
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoMMessage message = (BoMMessage) o;
        return activity == message.activity &&
                theClass.equals(message.theClass) &&
                Objects.equals(user, message.user) &&
                Objects.equals(list, message.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activity, theClass, user, list);
    }

    @Override
    public String toString() {
        return "BoMMessage{" +
                "activity=" + activity +
                ", theClass=" + theClass +
                ", user=" + user +
                ", list=" + list +
                '}';
    }
}