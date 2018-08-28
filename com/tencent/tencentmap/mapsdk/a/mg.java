package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.gl.model.GLIcon;
import java.nio.ByteBuffer;

public final class mg {
    private static final byte[] a;
    private static final byte[] b;

    public static boolean a(byte b, byte b2) {
        return b == b2;
    }

    public static boolean a(short s, short s2) {
        return s == s2;
    }

    public static boolean a(int i, int i2) {
        return i == i2;
    }

    public static boolean a(long j, long j2) {
        return j == j2;
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj == obj2;
        } else {
            return obj.equals(obj2);
        }
    }

    public static int b(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static <T extends Comparable<T>> int a(T t, T t2) {
        return t.compareTo(t2);
    }

    public static int a(boolean[] zArr) {
        if (zArr == null) {
            return 629;
        }
        int i = 17;
        for (boolean z : zArr) {
            i = (z ? 0 : 1) + (i * 37);
        }
        return i;
    }

    public static int a(byte[] bArr) {
        if (bArr == null) {
            return 629;
        }
        int i = 17;
        for (byte b : bArr) {
            i = (i * 37) + b;
        }
        return i;
    }

    public static int a(char[] cArr) {
        if (cArr == null) {
            return 629;
        }
        int i = 17;
        for (char c : cArr) {
            i = (i * 37) + c;
        }
        return i;
    }

    public static int a(double[] dArr) {
        if (dArr == null) {
            return 629;
        }
        int i = 17;
        for (int i2 = 0; i2 < dArr.length; i2++) {
            i = (i * 37) + ((int) (Double.doubleToLongBits(dArr[i2]) ^ (Double.doubleToLongBits(dArr[i2]) >> 32)));
        }
        return i;
    }

    public static int a(float[] fArr) {
        if (fArr == null) {
            return 629;
        }
        int i = 17;
        for (float floatToIntBits : fArr) {
            i = (i * 37) + Float.floatToIntBits(floatToIntBits);
        }
        return i;
    }

    public static int a(short[] sArr) {
        if (sArr == null) {
            return 629;
        }
        int i = 17;
        for (short s : sArr) {
            i = (i * 37) + s;
        }
        return i;
    }

    public static int a(int i) {
        return i + 629;
    }

    public static int a(int[] iArr) {
        if (iArr == null) {
            return 629;
        }
        int i = 17;
        for (int i2 : iArr) {
            i = (i * 37) + i2;
        }
        return i;
    }

    public static int a(long[] jArr) {
        if (jArr == null) {
            return 629;
        }
        int i = 17;
        for (int i2 = 0; i2 < jArr.length; i2++) {
            i = (i * 37) + ((int) (jArr[i2] ^ (jArr[i2] >> 32)));
        }
        return i;
    }

    public static int a(mf[] mfVarArr) {
        if (mfVarArr == null) {
            return 629;
        }
        int i = 17;
        for (Object hashCode : mfVarArr) {
            i = (i * 37) + hashCode.hashCode();
        }
        return i;
    }

    public static int a(Object obj) {
        Object obj2 = obj;
        while (obj2 != null) {
            if (obj2.getClass().isArray()) {
                if (obj2 instanceof long[]) {
                    return a((long[]) obj2);
                }
                if (obj2 instanceof int[]) {
                    return a((int[]) obj2);
                }
                if (obj2 instanceof short[]) {
                    return a((short[]) obj2);
                }
                if (obj2 instanceof char[]) {
                    return a((char[]) obj2);
                }
                if (obj2 instanceof byte[]) {
                    return a((byte[]) obj2);
                }
                if (obj2 instanceof double[]) {
                    return a((double[]) obj2);
                }
                if (obj2 instanceof float[]) {
                    return a((float[]) obj2);
                }
                if (obj2 instanceof boolean[]) {
                    return a((boolean[]) obj2);
                }
                if (obj2 instanceof mf[]) {
                    return a((mf[]) obj2);
                }
                Object[] obj22 = (Object[]) obj22;
            } else if (obj22 instanceof mf) {
                return obj22.hashCode();
            } else {
                return obj22.hashCode() + 629;
            }
        }
        return 629;
    }

    public static byte[] a(ByteBuffer byteBuffer) {
        Object obj = new byte[byteBuffer.position()];
        System.arraycopy(byteBuffer.array(), 0, obj, 0, obj.length);
        return obj;
    }

    static {
        byte[] bArr = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70};
        byte[] bArr2 = new byte[GLIcon.TOP];
        byte[] bArr3 = new byte[GLIcon.TOP];
        for (int i = 0; i < GLIcon.TOP; i++) {
            bArr2[i] = bArr[i >>> 4];
            bArr3[i] = bArr[i & 15];
        }
        a = bArr2;
        b = bArr3;
    }
}
