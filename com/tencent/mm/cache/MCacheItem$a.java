package com.tencent.mm.cache;

import android.os.Parcel;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class MCacheItem$a {
    public static Map<Class<?>, Method> dao = new HashMap();
    public static Map<Class<?>, Method> dap = new HashMap();

    MCacheItem$a() {
    }

    static {
        try {
            dao.put(byte[].class, MCacheItem$a.class.getMethod("keep_writeByteArray", new Class[]{Parcel.class, Field.class, Object.class}));
            dao.put(Short.TYPE, MCacheItem$a.class.getMethod("keep_writeShort", new Class[]{Parcel.class, Field.class, Object.class}));
            dao.put(Short.class, MCacheItem$a.class.getMethod("keep_writeShort", new Class[]{Parcel.class, Field.class, Object.class}));
            dao.put(Boolean.TYPE, MCacheItem$a.class.getMethod("keep_writeBoolean", new Class[]{Parcel.class, Field.class, Object.class}));
            dao.put(Boolean.class, MCacheItem$a.class.getMethod("keep_writeBoolean", new Class[]{Parcel.class, Field.class, Object.class}));
            dao.put(Integer.TYPE, MCacheItem$a.class.getMethod("keep_writeInt", new Class[]{Parcel.class, Field.class, Object.class}));
            dao.put(Integer.class, MCacheItem$a.class.getMethod("keep_writeInt", new Class[]{Parcel.class, Field.class, Object.class}));
            dao.put(Float.TYPE, MCacheItem$a.class.getMethod("keep_writeFloat", new Class[]{Parcel.class, Field.class, Object.class}));
            dao.put(Float.class, MCacheItem$a.class.getMethod("keep_writeFloat", new Class[]{Parcel.class, Field.class, Object.class}));
            dao.put(Double.TYPE, MCacheItem$a.class.getMethod("keep_writeDouble", new Class[]{Parcel.class, Field.class, Object.class}));
            dao.put(Double.class, MCacheItem$a.class.getMethod("keep_writeDouble", new Class[]{Parcel.class, Field.class, Object.class}));
            dao.put(Long.TYPE, MCacheItem$a.class.getMethod("keep_writeLong", new Class[]{Parcel.class, Field.class, Object.class}));
            dao.put(Long.class, MCacheItem$a.class.getMethod("keep_writeLong", new Class[]{Parcel.class, Field.class, Object.class}));
            dao.put(String.class, MCacheItem$a.class.getMethod("keep_writeString", new Class[]{Parcel.class, Field.class, Object.class}));
            dap.put(byte[].class, MCacheItem$a.class.getMethod("keep_readByteArray", new Class[]{Parcel.class, Field.class, Object.class}));
            dap.put(Short.TYPE, MCacheItem$a.class.getMethod("keep_readShort", new Class[]{Parcel.class, Field.class, Object.class}));
            dap.put(Short.class, MCacheItem$a.class.getMethod("keep_readShort", new Class[]{Parcel.class, Field.class, Object.class}));
            dap.put(Boolean.TYPE, MCacheItem$a.class.getMethod("keep_readBoolean", new Class[]{Parcel.class, Field.class, Object.class}));
            dap.put(Boolean.class, MCacheItem$a.class.getMethod("keep_readBoolean", new Class[]{Parcel.class, Field.class, Object.class}));
            dap.put(Integer.TYPE, MCacheItem$a.class.getMethod("keep_readInt", new Class[]{Parcel.class, Field.class, Object.class}));
            dap.put(Integer.class, MCacheItem$a.class.getMethod("keep_readInt", new Class[]{Parcel.class, Field.class, Object.class}));
            dap.put(Float.TYPE, MCacheItem$a.class.getMethod("keep_readFloat", new Class[]{Parcel.class, Field.class, Object.class}));
            dap.put(Float.class, MCacheItem$a.class.getMethod("keep_readFloat", new Class[]{Parcel.class, Field.class, Object.class}));
            dap.put(Double.TYPE, MCacheItem$a.class.getMethod("keep_readDouble", new Class[]{Parcel.class, Field.class, Object.class}));
            dap.put(Double.class, MCacheItem$a.class.getMethod("keep_readDouble", new Class[]{Parcel.class, Field.class, Object.class}));
            dap.put(Long.TYPE, MCacheItem$a.class.getMethod("keep_readLong", new Class[]{Parcel.class, Field.class, Object.class}));
            dap.put(Long.class, MCacheItem$a.class.getMethod("keep_readLong", new Class[]{Parcel.class, Field.class, Object.class}));
            dap.put(String.class, MCacheItem$a.class.getMethod("keep_readString", new Class[]{Parcel.class, Field.class, Object.class}));
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public static void keep_writeByteArray(Parcel parcel, Field field, Object obj) {
        try {
            parcel.writeByteArray((byte[]) field.get(obj));
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public static void keep_writeShort(Parcel parcel, Field field, Object obj) {
        try {
            parcel.writeInt(field.getShort(obj));
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public static void keep_writeBoolean(Parcel parcel, Field field, Object obj) {
        try {
            parcel.writeInt(field.getBoolean(obj) ? 1 : 0);
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public static void keep_writeInt(Parcel parcel, Field field, Object obj) {
        try {
            parcel.writeInt(field.getInt(obj));
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public static void keep_writeFloat(Parcel parcel, Field field, Object obj) {
        try {
            parcel.writeFloat(field.getFloat(obj));
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public static void keep_writeDouble(Parcel parcel, Field field, Object obj) {
        try {
            parcel.writeDouble(field.getDouble(obj));
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public static void keep_writeLong(Parcel parcel, Field field, Object obj) {
        try {
            parcel.writeLong(field.getLong(obj));
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public static void keep_writeString(Parcel parcel, Field field, Object obj) {
        try {
            parcel.writeString((String) field.get(obj));
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public static void keep_readByteArray(Parcel parcel, Field field, Object obj) {
        try {
            field.set(obj, parcel.createByteArray());
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public static void keep_readShort(Parcel parcel, Field field, Object obj) {
        try {
            field.setShort(obj, (short) parcel.readInt());
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public static void keep_readBoolean(Parcel parcel, Field field, Object obj) {
        try {
            field.setBoolean(obj, parcel.readInt() != 0);
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public static void keep_readInt(Parcel parcel, Field field, Object obj) {
        try {
            field.setInt(obj, parcel.readInt());
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public static void keep_readFloat(Parcel parcel, Field field, Object obj) {
        try {
            field.setFloat(obj, parcel.readFloat());
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public static void keep_readDouble(Parcel parcel, Field field, Object obj) {
        try {
            field.setDouble(obj, parcel.readDouble());
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public static void keep_readLong(Parcel parcel, Field field, Object obj) {
        try {
            field.set(obj, Long.valueOf(parcel.readLong()));
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public static void keep_readString(Parcel parcel, Field field, Object obj) {
        try {
            field.set(obj, parcel.readString());
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bi.i(e)});
        }
    }
}
