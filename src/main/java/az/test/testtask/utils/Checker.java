package az.test.testtask.utils;

import az.test.testtask.exceptions.ExceptionEnums;

import java.util.Arrays;
import java.util.List;

import static az.test.testtask.exceptions.ExceptionEnums.getException;

/**
 * Check objects for null and empty and etc then throws provided Exception
 */
public class Checker {

    public static void throwIfNull(RuntimeException ex, Object... obj) {

        if (obj == null) throw ex;

        List<Object> objects = Arrays.asList(obj);

        objects.forEach(val -> {
            if (val == null) throw ex;
        });

    }

    public static void throwIfFalse(RuntimeException ex, boolean isNotValid) {
        if (isNotValid) throw ex;

    }


    public static void throwIfNull(ExceptionEnums ex, Object... obj) {

        if (obj == null) throw getException(ex);

        List<Object> objects = Arrays.asList(obj);

        objects.forEach(val -> {
            if (val == null) throw getException(ex);
        });

    }

    public static <T> T throwIfNull(ExceptionEnums ex, T obj) {
        if (obj == null) throw getException(ex);
        return obj;
    }

    public static void throwOnEmpty(RuntimeException ex, List<?>... obj) {

        if (obj == null) throw ex;

        List<List<?>> objects = Arrays.asList(obj);

        objects.forEach(val -> {
            if (val == null) throw ex;
            if (val.isEmpty()) throw ex;
        });

    }

    public static <T> T throwOnEmpty(ExceptionEnums ex, T obj) {
        if (obj == null || obj.toString().isEmpty()) throw getException(ex);
        return obj;
    }

    public static void throwOnEmptyString(RuntimeException ex, String... obj) {

        if (obj == null) throw ex;

        List<String> strings = Arrays.asList(obj);

        strings.forEach(val -> {
            if (val != null)
                if (val.isEmpty()) throw ex;
        });

    }

}