package eu.bopet.bobom.core;

import org.eclipse.persistence.internal.helper.DatabaseField;
import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.converters.Converter;
import org.eclipse.persistence.sessions.Session;

import java.sql.Types;
import java.util.UUID;

public class UUIDConverter implements Converter {

    private static final long serialVersionUID = 1L;

    @Override
    public UUID convertObjectValueToDataValue(Object o, Session session) {
        return (UUID) o;
    }

    @Override
    public UUID convertDataValueToObjectValue(Object o, Session session) {
        return (UUID) o;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public void initialize(DatabaseMapping mapping, Session session) {
        DatabaseField field = mapping.getField();
        field.setSqlType(Types.OTHER);
        field.setTypeName("java.util.UUID");
        field.setColumnDefinition("UUID");
    }
}
