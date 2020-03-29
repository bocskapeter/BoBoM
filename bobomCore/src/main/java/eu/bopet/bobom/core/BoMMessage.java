package eu.bopet.bobom.core;

import eu.bopet.bobom.core.entities.Users;

import java.io.Serializable;
import java.util.List;

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
    public String toString() {
        return "BoMMessage{" +
                "activity=" + activity +
                ", theClass=" + theClass +
                ", user=" + user +
                ", list=" + list +
                '}';
    }
}