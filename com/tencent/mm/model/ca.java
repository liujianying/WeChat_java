package com.tencent.mm.model;

public final class ca {
    public static int getInt(Object obj, int i) {
        if (!(obj instanceof Integer)) {
            return i;
        }
        try {
            return ((Integer) obj).intValue();
        } catch (Exception e) {
            return i;
        }
    }

    public static String f(Object obj, String str) {
        if (obj instanceof String) {
            try {
                return (String) obj;
            } catch (Exception e) {
            }
        }
        return str;
    }

    public static boolean aW(Object obj) {
        if (obj instanceof Boolean) {
            try {
                return ((Boolean) obj).booleanValue();
            } catch (Exception e) {
            }
        }
        return false;
    }
}
