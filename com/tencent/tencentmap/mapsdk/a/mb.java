package com.tencent.tencentmap.mapsdk.a;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class mb {
    private StringBuilder a;
    private int b = 0;

    private void a(String str) {
        for (int i = 0; i < this.b; i++) {
            this.a.append(9);
        }
        if (str != null) {
            this.a.append(str).append(": ");
        }
    }

    public mb(StringBuilder stringBuilder, int i) {
        this.a = stringBuilder;
        this.b = i;
    }

    public final mb a(boolean z, String str) {
        a(str);
        this.a.append(z ? 'T' : 'F').append(10);
        return this;
    }

    public final mb a(boolean z, boolean z2) {
        this.a.append(z ? 'T' : 'F');
        if (z2) {
            this.a.append("|");
        }
        return this;
    }

    public final mb a(byte b, String str) {
        a(str);
        this.a.append(b).append(10);
        return this;
    }

    public final mb a(byte b, boolean z) {
        this.a.append(b);
        if (z) {
            this.a.append("|");
        }
        return this;
    }

    public final mb a(char c, String str) {
        a(str);
        this.a.append(c).append(10);
        return this;
    }

    public final mb a(short s, String str) {
        a(str);
        this.a.append(s).append(10);
        return this;
    }

    public final mb a(short s, boolean z) {
        this.a.append(s);
        if (z) {
            this.a.append("|");
        }
        return this;
    }

    public final mb a(int i, String str) {
        a(str);
        this.a.append(i).append(10);
        return this;
    }

    public final mb a(int i, boolean z) {
        this.a.append(i);
        if (z) {
            this.a.append("|");
        }
        return this;
    }

    public final mb a(long j, String str) {
        a(str);
        this.a.append(j).append(10);
        return this;
    }

    public final mb a(long j, boolean z) {
        this.a.append(j);
        if (z) {
            this.a.append("|");
        }
        return this;
    }

    public final mb a(float f, String str) {
        a(str);
        this.a.append(f).append(10);
        return this;
    }

    public final mb a(float f, boolean z) {
        this.a.append(f);
        if (z) {
            this.a.append("|");
        }
        return this;
    }

    public final mb a(double d, String str) {
        a(str);
        this.a.append(d).append(10);
        return this;
    }

    public final mb a(double d, boolean z) {
        this.a.append(d);
        if (z) {
            this.a.append("|");
        }
        return this;
    }

    public final mb a(String str, String str2) {
        a(str2);
        if (str == null) {
            this.a.append("null\n");
        } else {
            this.a.append(str).append(10);
        }
        return this;
    }

    public final mb a(String str, boolean z) {
        if (str == null) {
            this.a.append("null");
        } else {
            this.a.append(str);
        }
        if (z) {
            this.a.append("|");
        }
        return this;
    }

    public final mb a(byte[] bArr, String str) {
        a(str);
        if (bArr == null) {
            this.a.append("null\n");
        } else if (bArr.length == 0) {
            this.a.append(bArr.length).append(", []\n");
        } else {
            this.a.append(bArr.length).append(", [\n");
            mb mbVar = new mb(this.a, this.b + 1);
            for (byte a : bArr) {
                mbVar.a(a, null);
            }
            a(']', null);
        }
        return this;
    }

    public final mb a(byte[] bArr, boolean z) {
        if (bArr != null && bArr.length != 0) {
            this.a.append(lz.a(bArr));
            if (z) {
                this.a.append("|");
            }
        } else if (z) {
            this.a.append("|");
        }
        return this;
    }

    public final mb a(short[] sArr, String str) {
        a(str);
        if (sArr == null) {
            this.a.append("null\n");
        } else if (sArr.length == 0) {
            this.a.append(sArr.length).append(", []\n");
        } else {
            this.a.append(sArr.length).append(", [\n");
            mb mbVar = new mb(this.a, this.b + 1);
            for (short a : sArr) {
                mbVar.a(a, null);
            }
            a(']', null);
        }
        return this;
    }

    public final mb a(short[] sArr, boolean z) {
        if (sArr == null || sArr.length == 0) {
            this.a.append("[]");
            if (z) {
                this.a.append("|");
            }
        } else {
            this.a.append("[");
            mb mbVar = new mb(this.a, this.b + 1);
            for (int i = 0; i < sArr.length; i++) {
                short s = sArr[i];
                if (i != 0) {
                    this.a.append("|");
                }
                mbVar.a(s, false);
            }
            this.a.append("]");
            if (z) {
                this.a.append("|");
            }
        }
        return this;
    }

    public final mb a(int[] iArr, String str) {
        a(str);
        if (iArr == null) {
            this.a.append("null\n");
        } else if (iArr.length == 0) {
            this.a.append(iArr.length).append(", []\n");
        } else {
            this.a.append(iArr.length).append(", [\n");
            mb mbVar = new mb(this.a, this.b + 1);
            for (int a : iArr) {
                mbVar.a(a, null);
            }
            a(']', null);
        }
        return this;
    }

    public final mb a(int[] iArr, boolean z) {
        if (iArr == null || iArr.length == 0) {
            this.a.append("[]");
            if (z) {
                this.a.append("|");
            }
        } else {
            this.a.append("[");
            mb mbVar = new mb(this.a, this.b + 1);
            for (int i = 0; i < iArr.length; i++) {
                int i2 = iArr[i];
                if (i != 0) {
                    this.a.append("|");
                }
                mbVar.a(i2, false);
            }
            this.a.append("]");
            if (z) {
                this.a.append("|");
            }
        }
        return this;
    }

    public final mb a(long[] jArr, String str) {
        a(str);
        if (jArr == null) {
            this.a.append("null\n");
        } else if (jArr.length == 0) {
            this.a.append(jArr.length).append(", []\n");
        } else {
            this.a.append(jArr.length).append(", [\n");
            mb mbVar = new mb(this.a, this.b + 1);
            for (long a : jArr) {
                mbVar.a(a, null);
            }
            a(']', null);
        }
        return this;
    }

    public final mb a(long[] jArr, boolean z) {
        if (jArr == null || jArr.length == 0) {
            this.a.append("[]");
            if (z) {
                this.a.append("|");
            }
        } else {
            this.a.append("[");
            mb mbVar = new mb(this.a, this.b + 1);
            for (int i = 0; i < jArr.length; i++) {
                long j = jArr[i];
                if (i != 0) {
                    this.a.append("|");
                }
                mbVar.a(j, false);
            }
            this.a.append("]");
            if (z) {
                this.a.append("|");
            }
        }
        return this;
    }

    public final mb a(float[] fArr, String str) {
        a(str);
        if (fArr == null) {
            this.a.append("null\n");
        } else if (fArr.length == 0) {
            this.a.append(fArr.length).append(", []\n");
        } else {
            this.a.append(fArr.length).append(", [\n");
            mb mbVar = new mb(this.a, this.b + 1);
            for (float a : fArr) {
                mbVar.a(a, null);
            }
            a(']', null);
        }
        return this;
    }

    public final mb a(float[] fArr, boolean z) {
        if (fArr == null || fArr.length == 0) {
            this.a.append("[]");
            if (z) {
                this.a.append("|");
            }
        } else {
            this.a.append("[");
            mb mbVar = new mb(this.a, this.b + 1);
            for (int i = 0; i < fArr.length; i++) {
                float f = fArr[i];
                if (i != 0) {
                    this.a.append("|");
                }
                mbVar.a(f, false);
            }
            this.a.append("]");
            if (z) {
                this.a.append("|");
            }
        }
        return this;
    }

    public final mb a(double[] dArr, String str) {
        a(str);
        if (dArr == null) {
            this.a.append("null\n");
        } else if (dArr.length == 0) {
            this.a.append(dArr.length).append(", []\n");
        } else {
            this.a.append(dArr.length).append(", [\n");
            mb mbVar = new mb(this.a, this.b + 1);
            for (double a : dArr) {
                mbVar.a(a, null);
            }
            a(']', null);
        }
        return this;
    }

    public final mb a(double[] dArr, boolean z) {
        if (dArr == null || dArr.length == 0) {
            this.a.append("[]");
            if (z) {
                this.a.append("|");
            }
        } else {
            this.a.append("[");
            mb mbVar = new mb(this.a, this.b + 1);
            for (int i = 0; i < dArr.length; i++) {
                double d = dArr[i];
                if (i != 0) {
                    this.a.append("|");
                }
                mbVar.a(d, false);
            }
            this.a.append("[");
            if (z) {
                this.a.append("|");
            }
        }
        return this;
    }

    public final <K, V> mb a(Map<K, V> map, String str) {
        a(str);
        if (map == null) {
            this.a.append("null\n");
        } else if (map.isEmpty()) {
            this.a.append(map.size()).append(", {}\n");
        } else {
            this.a.append(map.size()).append(", {\n");
            mb mbVar = new mb(this.a, this.b + 1);
            mb mbVar2 = new mb(this.a, this.b + 2);
            for (Entry entry : map.entrySet()) {
                mbVar.a('(', null);
                mbVar2.a(entry.getKey(), null);
                mbVar2.a(entry.getValue(), null);
                mbVar.a(')', null);
            }
            a('}', null);
        }
        return this;
    }

    public final <K, V> mb a(Map<K, V> map, boolean z) {
        if (map == null || map.isEmpty()) {
            this.a.append("{}");
            if (z) {
                this.a.append("|");
            }
        } else {
            this.a.append("{");
            mb mbVar = new mb(this.a, this.b + 2);
            boolean z2 = true;
            for (Entry entry : map.entrySet()) {
                if (!z2) {
                    this.a.append(",");
                }
                mbVar.a(entry.getKey(), true);
                mbVar.a(entry.getValue(), false);
                z2 = false;
            }
            this.a.append("}");
            if (z) {
                this.a.append("|");
            }
        }
        return this;
    }

    public final <T> mb a(T[] tArr, String str) {
        a(str);
        if (tArr == null) {
            this.a.append("null\n");
        } else if (tArr.length == 0) {
            this.a.append(tArr.length).append(", []\n");
        } else {
            this.a.append(tArr.length).append(", [\n");
            mb mbVar = new mb(this.a, this.b + 1);
            for (Object a : tArr) {
                mbVar.a(a, null);
            }
            a(']', null);
        }
        return this;
    }

    public final <T> mb a(T[] tArr, boolean z) {
        if (tArr == null || tArr.length == 0) {
            this.a.append("[]");
            if (z) {
                this.a.append("|");
            }
        } else {
            this.a.append("[");
            mb mbVar = new mb(this.a, this.b + 1);
            for (int i = 0; i < tArr.length; i++) {
                Object obj = tArr[i];
                if (i != 0) {
                    this.a.append("|");
                }
                mbVar.a(obj, false);
            }
            this.a.append("]");
            if (z) {
                this.a.append("|");
            }
        }
        return this;
    }

    public final <T> mb a(Collection<T> collection, String str) {
        if (collection != null) {
            return a(collection.toArray(), str);
        }
        a(str);
        this.a.append("null\t");
        return this;
    }

    public final <T> mb a(Collection<T> collection, boolean z) {
        if (collection != null) {
            return a(collection.toArray(), z);
        }
        this.a.append("[]");
        if (!z) {
            return this;
        }
        this.a.append("|");
        return this;
    }

    public final <T> mb a(T t, String str) {
        if (t == null) {
            this.a.append("null\n");
        } else if (t instanceof Byte) {
            a(((Byte) t).byteValue(), str);
        } else if (t instanceof Boolean) {
            a(((Boolean) t).booleanValue(), str);
        } else if (t instanceof Short) {
            a(((Short) t).shortValue(), str);
        } else if (t instanceof Integer) {
            a(((Integer) t).intValue(), str);
        } else if (t instanceof Long) {
            a(((Long) t).longValue(), str);
        } else if (t instanceof Float) {
            a(((Float) t).floatValue(), str);
        } else if (t instanceof Double) {
            a(((Double) t).doubleValue(), str);
        } else if (t instanceof String) {
            a((String) t, str);
        } else if (t instanceof Map) {
            a((Map) t, str);
        } else if (t instanceof List) {
            a((List) t, str);
        } else if (t instanceof mf) {
            a((mf) t, str);
        } else if (t instanceof byte[]) {
            a((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            a((Object) (boolean[]) t, str);
        } else if (t instanceof short[]) {
            a((short[]) t, str);
        } else if (t instanceof int[]) {
            a((int[]) t, str);
        } else if (t instanceof long[]) {
            a((long[]) t, str);
        } else if (t instanceof float[]) {
            a((float[]) t, str);
        } else if (t instanceof double[]) {
            a((double[]) t, str);
        } else if (t.getClass().isArray()) {
            a((Object[]) t, str);
        } else {
            throw new mc("write object error: unsupport type.");
        }
        return this;
    }

    public final <T> mb a(T t, boolean z) {
        if (t == null) {
            this.a.append("null\n");
        } else if (t instanceof Byte) {
            a(((Byte) t).byteValue(), z);
        } else if (t instanceof Boolean) {
            a(((Boolean) t).booleanValue(), z);
        } else if (t instanceof Short) {
            a(((Short) t).shortValue(), z);
        } else if (t instanceof Integer) {
            a(((Integer) t).intValue(), z);
        } else if (t instanceof Long) {
            a(((Long) t).longValue(), z);
        } else if (t instanceof Float) {
            a(((Float) t).floatValue(), z);
        } else if (t instanceof Double) {
            a(((Double) t).doubleValue(), z);
        } else if (t instanceof String) {
            a((String) t, z);
        } else if (t instanceof Map) {
            a((Map) t, z);
        } else if (t instanceof List) {
            a((List) t, z);
        } else if (t instanceof mf) {
            a((mf) t, z);
        } else if (t instanceof byte[]) {
            a((byte[]) t, z);
        } else if (t instanceof boolean[]) {
            a((Object) (boolean[]) t, z);
        } else if (t instanceof short[]) {
            a((short[]) t, z);
        } else if (t instanceof int[]) {
            a((int[]) t, z);
        } else if (t instanceof long[]) {
            a((long[]) t, z);
        } else if (t instanceof float[]) {
            a((float[]) t, z);
        } else if (t instanceof double[]) {
            a((double[]) t, z);
        } else if (t.getClass().isArray()) {
            a((Object[]) t, z);
        } else {
            throw new mc("write object error: unsupport type.");
        }
        return this;
    }

    public final mb a(mf mfVar, String str) {
        a('{', str);
        if (mfVar == null) {
            this.a.append(9).append("null");
        } else {
            mfVar.display(this.a, this.b + 1);
        }
        a('}', null);
        return this;
    }

    public final mb a(mf mfVar, boolean z) {
        this.a.append("{");
        if (mfVar == null) {
            this.a.append(9).append("null");
        } else {
            mfVar.displaySimple(this.a, this.b + 1);
        }
        this.a.append("}");
        if (z) {
            this.a.append("|");
        }
        return this;
    }
}
