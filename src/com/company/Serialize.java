package com.company;

import myPackage.Save;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.InvalidParameterException;

public class Serialize {
    public static String serializer(Object o) throws IllegalAccessException {
        Class<?> cls = o.getClass();
        StringBuilder sb = new StringBuilder();
        Field[] fields = cls.getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(Save.class)) {
                if (Modifier.isPrivate(f.getModifiers())) {
                    f.setAccessible(true);
                }
            }
         sb.append(f.getName() + "-");
         if (f.getType() == int.class)
            sb.append(f.getInt(o));
         if (f.getType() == String.class)
             sb.append((String) f.get(o));
         if (f.getType() == long.class)
             sb.append(f.getLong(o));
         sb.append(";");
        }
        return sb.toString();
    }

    public static <T> T deserializer(String s, Class<T> cls) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        T res = (T) cls.newInstance();
        String[] line = s.split(";");

        for (String l : line) {
            String[] nv = l.split("-");
            if (nv.length != 2)
                throw new InvalidParameterException(s);

            String name = nv[0];
            String value = nv[1];
            Field f = cls.getDeclaredField(name);
            if (Modifier.isPrivate(f.getModifiers())) {
                f.setAccessible(true);
            }
            if (f.isAnnotationPresent(Save.class)) {
                if (f.getType() == int.class)
                    f.setInt(res, Integer.parseInt(value));
                if (f.getType() == String.class)
                    f.set(res, name);
                if (f.getType() == Long.class)
                    f.setLong(res, Long.parseLong(value));
            }
        }
        return res;
    }
}
