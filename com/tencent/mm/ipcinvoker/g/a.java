package com.tencent.mm.ipcinvoker.g;

import com.tencent.mm.ipcinvoker.h.b;
import java.lang.reflect.Field;

public final class a<FieldType> {
    private Class<?> dng;
    private String dnh;
    private boolean dni;
    private Field mField;

    public a(Class<?> cls, String str) {
        if (str.length() == 0) {
            throw new IllegalArgumentException("Both of invoker and fieldName can not be null or nil.");
        }
        this.dng = cls;
        this.dnh = str;
    }

    private synchronized void prepare() {
        if (!this.dni) {
            Class cls = this.dng;
            while (cls != null) {
                try {
                    Field declaredField = cls.getDeclaredField(this.dnh);
                    declaredField.setAccessible(true);
                    this.mField = declaredField;
                    break;
                } catch (Exception e) {
                    cls = cls.getSuperclass();
                }
            }
            this.dni = true;
        }
    }

    private synchronized FieldType Cz() {
        FieldType fieldType = null;
        synchronized (this) {
            prepare();
            if (this.mField == null) {
                b.w("SDK.ReflectStaticFieldSmith", "Field %s is no exists.", new Object[]{this.dnh});
            } else {
                try {
                    fieldType = this.mField.get(null);
                } catch (ClassCastException e) {
                    throw new IllegalArgumentException("unable to cast object");
                }
            }
        }
        return fieldType;
    }

    public final synchronized FieldType CA() {
        FieldType fieldType;
        fieldType = null;
        try {
            fieldType = Cz();
        } catch (NoSuchFieldException e) {
            b.i("SDK.ReflectStaticFieldSmith", "getWithoutThrow, exception occur :%s", new Object[]{e});
        } catch (IllegalAccessException e2) {
            b.i("SDK.ReflectStaticFieldSmith", "getWithoutThrow, exception occur :%s", new Object[]{e2});
        } catch (IllegalArgumentException e3) {
            b.i("SDK.ReflectStaticFieldSmith", "getWithoutThrow, exception occur :%s", new Object[]{e3});
        }
        return fieldType;
    }
}
