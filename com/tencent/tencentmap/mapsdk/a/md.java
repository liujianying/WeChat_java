package com.tencent.tencentmap.mapsdk.a;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class md {
    protected String a = "GBK";
    private ByteBuffer b;

    public md(byte[] bArr) {
        this.b = ByteBuffer.wrap(bArr);
    }

    public md(byte[] bArr, int i) {
        this.b = ByteBuffer.wrap(bArr);
        this.b.position(i);
    }

    public final void a(byte[] bArr) {
        this.b = ByteBuffer.wrap(bArr);
    }

    public static int a(a aVar, ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        aVar.a = (byte) (b & 15);
        aVar.b = (b & 240) >> 4;
        if (aVar.b != 15) {
            return 1;
        }
        aVar.b = byteBuffer.get() & 255;
        return 2;
    }

    public final void a(a aVar) {
        a(aVar, this.b);
    }

    private int b(a aVar) {
        return a(aVar, this.b.duplicate());
    }

    private void b(int i) {
        this.b.position(this.b.position() + i);
    }

    public final boolean a(int i) {
        try {
            a aVar = new a();
            while (true) {
                int b = b(aVar);
                if (i > aVar.b && aVar.a != (byte) 11) {
                    b(b);
                    a(aVar.a);
                }
            }
            if (aVar.a != (byte) 11 && i == aVar.b) {
                return true;
            }
            return false;
        } catch (ma e) {
            return false;
        } catch (BufferUnderflowException e2) {
            return false;
        }
    }

    public final void a() {
        a aVar = new a();
        do {
            a(aVar);
            a(aVar.a);
        } while (aVar.a != (byte) 11);
    }

    private void b() {
        a aVar = new a();
        a(aVar);
        a(aVar.a);
    }

    private void a(byte b) {
        int i = 0;
        int a;
        switch (b) {
            case (byte) 0:
                b(1);
                return;
            case (byte) 1:
                b(2);
                return;
            case (byte) 2:
                b(4);
                return;
            case (byte) 3:
                b(8);
                return;
            case (byte) 4:
                b(4);
                return;
            case (byte) 5:
                b(8);
                return;
            case (byte) 6:
                i = this.b.get();
                if (i < 0) {
                    i += 256;
                }
                b(i);
                return;
            case (byte) 7:
                b(this.b.getInt());
                return;
            case (byte) 8:
                a = a(0, 0, true);
                while (i < a * 2) {
                    b();
                    i++;
                }
                return;
            case (byte) 9:
                a = a(0, 0, true);
                while (i < a) {
                    b();
                    i++;
                }
                return;
            case (byte) 10:
                a();
                return;
            case (byte) 11:
            case (byte) 12:
                return;
            case (byte) 13:
                a aVar = new a();
                a(aVar);
                if (aVar.a != (byte) 0) {
                    throw new ma("skipField with invalid type, type value: " + b + ", " + aVar.a);
                }
                b(a(0, 0, true));
                return;
            default:
                throw new ma("invalid type.");
        }
    }

    public final boolean a(boolean z, int i, boolean z2) {
        if (a((byte) 0, i, z2) != (byte) 0) {
            return true;
        }
        return false;
    }

    public final byte a(byte b, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 0:
                    return this.b.get();
                case (byte) 12:
                    return (byte) 0;
                default:
                    throw new ma("type mismatch.");
            }
        } else if (!z) {
            return b;
        } else {
            throw new ma("require field not exist.");
        }
    }

    public final short a(short s, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 0:
                    return (short) this.b.get();
                case (byte) 1:
                    return this.b.getShort();
                case (byte) 12:
                    return (short) 0;
                default:
                    throw new ma("type mismatch.");
            }
        } else if (!z) {
            return s;
        } else {
            throw new ma("require field not exist.");
        }
    }

    public final int a(int i, int i2, boolean z) {
        if (a(i2)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 0:
                    return this.b.get();
                case (byte) 1:
                    return this.b.getShort();
                case (byte) 2:
                    return this.b.getInt();
                case (byte) 12:
                    return 0;
                default:
                    throw new ma("type mismatch.");
            }
        } else if (!z) {
            return i;
        } else {
            throw new ma("require field not exist.");
        }
    }

    public final long a(long j, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 0:
                    return (long) this.b.get();
                case (byte) 1:
                    return (long) this.b.getShort();
                case (byte) 2:
                    return (long) this.b.getInt();
                case (byte) 3:
                    return this.b.getLong();
                case (byte) 12:
                    return 0;
                default:
                    throw new ma("type mismatch.");
            }
        } else if (!z) {
            return j;
        } else {
            throw new ma("require field not exist.");
        }
    }

    public final float a(float f, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 4:
                    return this.b.getFloat();
                case (byte) 12:
                    return 0.0f;
                default:
                    throw new ma("type mismatch.");
            }
        } else if (!z) {
            return f;
        } else {
            throw new ma("require field not exist.");
        }
    }

    public final double a(double d, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 4:
                    return (double) this.b.getFloat();
                case (byte) 5:
                    return this.b.getDouble();
                case (byte) 12:
                    return 0.0d;
                default:
                    throw new ma("type mismatch.");
            }
        } else if (!z) {
            return d;
        } else {
            throw new ma("require field not exist.");
        }
    }

    public final String a(int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            int i2;
            byte[] bArr;
            switch (aVar.a) {
                case (byte) 6:
                    i2 = this.b.get();
                    if (i2 < 0) {
                        i2 += 256;
                    }
                    bArr = new byte[i2];
                    this.b.get(bArr);
                    try {
                        return new String(bArr, this.a);
                    } catch (UnsupportedEncodingException e) {
                        return new String(bArr);
                    }
                case (byte) 7:
                    i2 = this.b.getInt();
                    if (i2 > 104857600 || i2 < 0 || i2 > this.b.capacity()) {
                        throw new ma("String too long: " + i2);
                    }
                    bArr = new byte[i2];
                    this.b.get(bArr);
                    try {
                        return new String(bArr, this.a);
                    } catch (UnsupportedEncodingException e2) {
                        return new String(bArr);
                    }
                default:
                    throw new ma("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new ma("require field not exist.");
        }
    }

    public final <K, V> HashMap<K, V> a(Map<K, V> map, int i, boolean z) {
        return (HashMap) a(new HashMap(), map, i, z);
    }

    private <K, V> Map<K, V> a(Map<K, V> map, Map<K, V> map2, int i, boolean z) {
        if (map2 == null || map2.isEmpty()) {
            return new HashMap();
        }
        Entry entry = (Entry) map2.entrySet().iterator().next();
        Object key = entry.getKey();
        Object value = entry.getValue();
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 8:
                    int a = a(0, 0, true);
                    if (a < 0) {
                        throw new ma("size invalid: " + a);
                    }
                    for (int i2 = 0; i2 < a; i2++) {
                        map.put(a(key, 0, true), a(value, 1, true));
                    }
                    return map;
                default:
                    throw new ma("type mismatch.");
            }
        } else if (!z) {
            return map;
        } else {
            throw new ma("require field not exist.");
        }
    }

    public final boolean[] a(boolean[] zArr, int i, boolean z) {
        boolean[] zArr2 = null;
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a >= 0) {
                        zArr2 = new boolean[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            zArr2[i2] = a(zArr2[0], 0, true);
                        }
                        break;
                    }
                    throw new ma("size invalid: " + a);
                default:
                    throw new ma("type mismatch.");
            }
        } else if (z) {
            throw new ma("require field not exist.");
        }
        return zArr2;
    }

    public final byte[] a(byte[] bArr, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            byte[] bArr2;
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a < 0 || a > this.b.capacity()) {
                        throw new ma("size invalid: " + a);
                    }
                    bArr2 = new byte[a];
                    for (int i2 = 0; i2 < a; i2++) {
                        bArr2[i2] = a(bArr2[0], 0, true);
                    }
                    return bArr2;
                case (byte) 13:
                    a aVar2 = new a();
                    a(aVar2);
                    if (aVar2.a != (byte) 0) {
                        throw new ma("type mismatch, tag: " + i + ", type: " + aVar.a + ", " + aVar2.a);
                    }
                    int a2 = a(0, 0, true);
                    if (a2 < 0 || a2 > this.b.capacity()) {
                        throw new ma("invalid size, tag: " + i + ", type: " + aVar.a + ", " + aVar2.a + ", size: " + a2);
                    }
                    bArr2 = new byte[a2];
                    this.b.get(bArr2);
                    return bArr2;
                default:
                    throw new ma("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new ma("require field not exist.");
        }
    }

    public final short[] a(short[] sArr, int i, boolean z) {
        short[] sArr2 = null;
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a >= 0) {
                        sArr2 = new short[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            sArr2[i2] = a(sArr2[0], 0, true);
                        }
                        break;
                    }
                    throw new ma("size invalid: " + a);
                default:
                    throw new ma("type mismatch.");
            }
        } else if (z) {
            throw new ma("require field not exist.");
        }
        return sArr2;
    }

    public final int[] a(int[] iArr, int i, boolean z) {
        int[] iArr2 = null;
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a >= 0) {
                        iArr2 = new int[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            iArr2[i2] = a(iArr2[0], 0, true);
                        }
                        break;
                    }
                    throw new ma("size invalid: " + a);
                default:
                    throw new ma("type mismatch.");
            }
        } else if (z) {
            throw new ma("require field not exist.");
        }
        return iArr2;
    }

    public final long[] a(long[] jArr, int i, boolean z) {
        long[] jArr2 = null;
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a >= 0) {
                        jArr2 = new long[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            jArr2[i2] = a(jArr2[0], 0, true);
                        }
                        break;
                    }
                    throw new ma("size invalid: " + a);
                default:
                    throw new ma("type mismatch.");
            }
        } else if (z) {
            throw new ma("require field not exist.");
        }
        return jArr2;
    }

    public final float[] a(float[] fArr, int i, boolean z) {
        float[] fArr2 = null;
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a >= 0) {
                        fArr2 = new float[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            fArr2[i2] = a(fArr2[0], 0, true);
                        }
                        break;
                    }
                    throw new ma("size invalid: " + a);
                default:
                    throw new ma("type mismatch.");
            }
        } else if (z) {
            throw new ma("require field not exist.");
        }
        return fArr2;
    }

    public final double[] a(double[] dArr, int i, boolean z) {
        double[] dArr2 = null;
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a >= 0) {
                        dArr2 = new double[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            dArr2[i2] = a(dArr2[0], 0, true);
                        }
                        break;
                    }
                    throw new ma("size invalid: " + a);
                default:
                    throw new ma("type mismatch.");
            }
        } else if (z) {
            throw new ma("require field not exist.");
        }
        return dArr2;
    }

    public final <T> T[] a(T[] tArr, int i, boolean z) {
        if (tArr != null && tArr.length != 0) {
            return b(tArr[0], i, z);
        }
        throw new ma("unable to get type of key and value.");
    }

    public final <T> List<T> a(List<T> list, int i, boolean z) {
        int i2 = 0;
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        Object[] b = b(list.get(0), i, z);
        if (b == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (i2 < b.length) {
            arrayList.add(b[i2]);
            i2++;
        }
        return arrayList;
    }

    private <T> T[] b(T t, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a < 0) {
                        throw new ma("size invalid: " + a);
                    }
                    Object[] objArr = (Object[]) Array.newInstance(t.getClass(), a);
                    for (int i2 = 0; i2 < a; i2++) {
                        objArr[i2] = a((Object) t, 0, true);
                    }
                    return objArr;
                default:
                    throw new ma("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new ma("require field not exist.");
        }
    }

    public final mf a(mf mfVar, int i, boolean z) {
        mf mfVar2 = null;
        if (a(i)) {
            try {
                mfVar2 = (mf) mfVar.getClass().newInstance();
                a aVar = new a();
                a(aVar);
                if (aVar.a != (byte) 10) {
                    throw new ma("type mismatch.");
                }
                mfVar2.readFrom(this);
                a();
            } catch (Exception e) {
                throw new ma(e.getMessage());
            }
        } else if (z) {
            throw new ma("require field not exist.");
        }
        return mfVar2;
    }

    public final <T> Object a(T t, int i, boolean z) {
        if (t instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i, z));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(a(false, i, z));
        }
        if (t instanceof Short) {
            return Short.valueOf(a((short) 0, i, z));
        }
        if (t instanceof Integer) {
            return Integer.valueOf(a(0, i, z));
        }
        if (t instanceof Long) {
            return Long.valueOf(a(0, i, z));
        }
        if (t instanceof Float) {
            return Float.valueOf(a(0.0f, i, z));
        }
        if (t instanceof Double) {
            return Double.valueOf(a(0.0d, i, z));
        }
        if (t instanceof String) {
            return a(i, z);
        }
        if (t instanceof Map) {
            return a((Map) t, i, z);
        }
        if (t instanceof List) {
            return a((List) t, i, z);
        }
        if (t instanceof mf) {
            return a((mf) t, i, z);
        }
        if (!t.getClass().isArray()) {
            throw new ma("read object error: unsupport type.");
        } else if ((t instanceof byte[]) || (t instanceof Byte[])) {
            return a(null, i, z);
        } else {
            if (t instanceof boolean[]) {
                return a(null, i, z);
            }
            if (t instanceof short[]) {
                return a(null, i, z);
            }
            if (t instanceof int[]) {
                return a(null, i, z);
            }
            if (t instanceof long[]) {
                return a(null, i, z);
            }
            if (t instanceof float[]) {
                return a(null, i, z);
            }
            if (t instanceof double[]) {
                return a(null, i, z);
            }
            return a((Object[]) t, i, z);
        }
    }

    public final int a(String str) {
        this.a = str;
        return 0;
    }
}
