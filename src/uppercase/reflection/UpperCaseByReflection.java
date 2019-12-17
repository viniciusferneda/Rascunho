package uppercase.reflection;

import org.apache.commons.lang.StringUtils;

import java.beans.Statement;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpperCaseByReflection {

    public static void main(String[] args) {
        final Municipio municipio = new Municipio(1, "Blumenau");
        for (Field field : municipio.getClass().getDeclaredFields()) {
            try {
                if (field.getType().isAssignableFrom(String.class)) {
                    final String fieldNameUpperCharFirst = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                    new Statement(municipio, "set" + fieldNameUpperCharFirst,
                            new Object[]{StringUtils.upperCase((String) municipio.getClass().getMethod("get" + fieldNameUpperCharFirst).invoke(municipio))})
                            .execute();
                }
            } catch (Exception exc) {
                getLogger().log(Level.SEVERE, "Erro inesperado!", exc);
            }
        }
        getLogger().log(Level.INFO, municipio.getId() + " - " + municipio.getDescricao());
    }

    private static Logger getLogger() {
        return Logger.getLogger(UpperCaseByReflection.class.getSimpleName());
    }

}
