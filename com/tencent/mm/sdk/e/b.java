package com.tencent.mm.sdk.e;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

final class b {
    private static final Map<Class<?>, Object> dao = new HashMap();
    private static final Map<Class<?>, Object> dap = new HashMap();
    private static final Map<Class<?>, String> sKw = new HashMap();

    static {
        try {
            dao.put(byte[].class, new Object() {
            });
            dao.put(Short.TYPE, new Object() {
            });
            dao.put(Short.class, new Object() {
            });
            dao.put(Boolean.TYPE, new Object() {
            });
            dao.put(Boolean.class, new Object() {
            });
            dao.put(Integer.TYPE, new Object() {
            });
            dao.put(Integer.class, new Object() {
            });
            dao.put(Float.TYPE, new Object() {
            });
            dao.put(Float.class, new Object() {
            });
            dao.put(Double.TYPE, new Object() {
            });
            dao.put(Double.class, new Object() {
            });
            dao.put(Long.TYPE, new Object() {
            });
            dao.put(Long.class, new Object() {
            });
            dao.put(String.class, new Object() {
            });
            dap.put(byte[].class, new Object() {
            });
            dap.put(Short.TYPE, new Object() {
            });
            dap.put(Short.class, new Object() {
            });
            dap.put(Boolean.TYPE, new Object() {
            });
            dap.put(Boolean.class, new Object() {
            });
            dap.put(Integer.TYPE, new Object() {
            });
            dap.put(Integer.class, new Object() {
            });
            dap.put(Float.TYPE, new Object() {
            });
            dap.put(Float.class, new Object() {
            });
            dap.put(Double.TYPE, new Object() {
            });
            dap.put(Double.class, new Object() {
            });
            dap.put(Long.TYPE, new Object() {
            });
            dap.put(Long.class, new Object() {
            });
            dap.put(String.class, new Object() {
            });
            sKw.put(byte[].class, "BLOB");
            sKw.put(Short.TYPE, "SHORT");
            sKw.put(Short.class, "SHORT");
            sKw.put(Boolean.TYPE, "INTEGER");
            sKw.put(Boolean.class, "INTEGER");
            sKw.put(Integer.TYPE, "INTEGER");
            sKw.put(Integer.class, "INTEGER");
            sKw.put(Float.TYPE, "FLOAT");
            sKw.put(Float.class, "FLOAT");
            sKw.put(Double.TYPE, "DOUBLE");
            sKw.put(Double.class, "DOUBLE");
            sKw.put(Long.TYPE, "LONG");
            sKw.put(Long.class, "LONG");
            sKw.put(String.class, "TEXT");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static String H(Class<?> cls) {
        return (String) sKw.get(cls);
    }

    public static void keep_setBlob(Field field, Object obj, Cursor cursor, int i) {
        try {
            field.set(obj, cursor.getBlob(i));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getBlob(Field field, Object obj, ContentValues contentValues) {
        try {
            contentValues.put(c.a(field), (byte[]) field.get(obj));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setShort(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Short.TYPE)) {
                field.setShort(obj, cursor.getShort(i));
            } else {
                field.set(obj, Short.valueOf(cursor.getShort(i)));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getShort(Field field, Object obj, ContentValues contentValues) {
        try {
            contentValues.put(c.a(field), Short.valueOf(field.getShort(obj)));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setBoolean(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Boolean.TYPE)) {
                field.setBoolean(obj, cursor.getInt(i) != 0);
            } else {
                field.set(obj, Integer.valueOf(cursor.getInt(i)));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getBoolean(Field field, Object obj, ContentValues contentValues) {
        try {
            contentValues.put(c.a(field), Integer.valueOf(field.getBoolean(obj) ? 1 : 0));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setInt(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Integer.TYPE)) {
                field.setInt(obj, cursor.getInt(i));
            } else {
                field.set(obj, Integer.valueOf(cursor.getInt(i)));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getInt(Field field, Object obj, ContentValues contentValues) {
        try {
            if (field.getType().equals(Integer.TYPE)) {
                contentValues.put(c.a(field), Integer.valueOf(field.getInt(obj)));
            } else {
                contentValues.put(c.a(field), (Integer) field.get(obj));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setFloat(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Float.TYPE)) {
                field.setFloat(obj, cursor.getFloat(i));
            } else {
                field.set(obj, Float.valueOf(cursor.getFloat(i)));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getFloat(Field field, Object obj, ContentValues contentValues) {
        try {
            if (field.getType().equals(Float.TYPE)) {
                contentValues.put(c.a(field), Float.valueOf(field.getFloat(obj)));
            } else {
                contentValues.put(c.a(field), (Float) field.get(obj));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setDouble(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Double.TYPE)) {
                field.setDouble(obj, cursor.getDouble(i));
            } else {
                field.set(obj, Double.valueOf(cursor.getDouble(i)));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getDouble(Field field, Object obj, ContentValues contentValues) {
        try {
            if (field.getType().equals(Double.TYPE)) {
                contentValues.put(c.a(field), Double.valueOf(field.getDouble(obj)));
            } else {
                contentValues.put(c.a(field), (Double) field.get(obj));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setLong(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Long.TYPE)) {
                field.setLong(obj, cursor.getLong(i));
            } else {
                field.set(obj, Long.valueOf(cursor.getLong(i)));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getLong(Field field, Object obj, ContentValues contentValues) {
        try {
            if (field.getType().equals(Long.TYPE)) {
                contentValues.put(c.a(field), Long.valueOf(field.getLong(obj)));
            } else {
                contentValues.put(c.a(field), (Long) field.get(obj));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setString(Field field, Object obj, Cursor cursor, int i) {
        try {
            field.set(obj, cursor.getString(i));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getString(Field field, Object obj, ContentValues contentValues) {
        try {
            contentValues.put(c.a(field), (String) field.get(obj));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }
}
