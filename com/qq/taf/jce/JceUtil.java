package com.qq.taf.jce;

import com.tencent.map.lib.gl.model.GLIcon;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

public final class JceUtil {
    private static final byte[] highDigits;
    private static final int iConstant = 37;
    private static final int iTotal = 17;
    private static final byte[] lowDigits;

    public static boolean equals(boolean z, boolean z2) {
        return z == z2;
    }

    public static boolean equals(byte b, byte b2) {
        return b == b2;
    }

    public static boolean equals(char c, char c2) {
        return c == c2;
    }

    public static boolean equals(short s, short s2) {
        return s == s2;
    }

    public static boolean equals(int i, int i2) {
        return i == i2;
    }

    public static boolean equals(long j, long j2) {
        return j == j2;
    }

    public static boolean equals(float f, float f2) {
        return f == f2;
    }

    public static boolean equals(double d, double d2) {
        return d == d2;
    }

    public static boolean equals(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    public static int compareTo(boolean z, boolean z2) {
        int i = 1;
        int i2 = z ? 1 : 0;
        if (!z2) {
            i = 0;
        }
        return i2 - i;
    }

    public static int compareTo(byte b, byte b2) {
        if (b < b2) {
            return -1;
        }
        return b > b2 ? 1 : 0;
    }

    public static int compareTo(char c, char c2) {
        if (c < c2) {
            return -1;
        }
        return c > c2 ? 1 : 0;
    }

    public static int compareTo(short s, short s2) {
        if (s < s2) {
            return -1;
        }
        return s > s2 ? 1 : 0;
    }

    public static int compareTo(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static int compareTo(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j > j2 ? 1 : 0;
    }

    public static int compareTo(float f, float f2) {
        if (f < f2) {
            return -1;
        }
        return f > f2 ? 1 : 0;
    }

    public static int compareTo(double d, double d2) {
        if (d < d2) {
            return -1;
        }
        return d > d2 ? 1 : 0;
    }

    public static <T extends Comparable<T>> int compareTo(T t, T t2) {
        return t.compareTo(t2);
    }

    public static <T extends Comparable<T>> int compareTo(List<T> list, List<T> list2) {
        Iterator it = list.iterator();
        Iterator it2 = list2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            int compareTo = ((Comparable) it.next()).compareTo((Comparable) it2.next());
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return compareTo(it.hasNext(), it2.hasNext());
    }

    public static <T extends Comparable<T>> int compareTo(T[] tArr, T[] tArr2) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i3 < tArr.length && i2 < tArr2.length) {
                i = tArr[i3].compareTo(tArr2[i2]);
                if (i != 0) {
                    return i;
                }
                i = i3 + 1;
                i2++;
            }
        }
        return compareTo(tArr.length, tArr2.length);
    }

    public static int compareTo(boolean[] zArr, boolean[] zArr2) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i3 < zArr.length && i2 < zArr2.length) {
                i = compareTo(zArr[i3], zArr2[i2]);
                if (i != 0) {
                    return i;
                }
                i = i3 + 1;
                i2++;
            }
        }
        return compareTo(zArr.length, zArr2.length);
    }

    public static int compareTo(byte[] bArr, byte[] bArr2) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i3 < bArr.length && i2 < bArr2.length) {
                i = compareTo(bArr[i3], bArr2[i2]);
                if (i != 0) {
                    return i;
                }
                i = i3 + 1;
                i2++;
            }
        }
        return compareTo(bArr.length, bArr2.length);
    }

    public static int compareTo(char[] cArr, char[] cArr2) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i3 < cArr.length && i2 < cArr2.length) {
                i = compareTo(cArr[i3], cArr2[i2]);
                if (i != 0) {
                    return i;
                }
                i = i3 + 1;
                i2++;
            }
        }
        return compareTo(cArr.length, cArr2.length);
    }

    public static int compareTo(short[] sArr, short[] sArr2) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i3 < sArr.length && i2 < sArr2.length) {
                i = compareTo(sArr[i3], sArr2[i2]);
                if (i != 0) {
                    return i;
                }
                i = i3 + 1;
                i2++;
            }
        }
        return compareTo(sArr.length, sArr2.length);
    }

    public static int compareTo(int[] iArr, int[] iArr2) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i3 < iArr.length && i2 < iArr2.length) {
                i = compareTo(iArr[i3], iArr2[i2]);
                if (i != 0) {
                    return i;
                }
                i = i3 + 1;
                i2++;
            }
        }
        return compareTo(iArr.length, iArr2.length);
    }

    public static int compareTo(long[] jArr, long[] jArr2) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i3 < jArr.length && i2 < jArr2.length) {
                i = compareTo(jArr[i3], jArr2[i2]);
                if (i != 0) {
                    return i;
                }
                i = i3 + 1;
                i2++;
            }
        }
        return compareTo(jArr.length, jArr2.length);
    }

    public static int compareTo(float[] fArr, float[] fArr2) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i3 < fArr.length && i2 < fArr2.length) {
                i = compareTo(fArr[i3], fArr2[i2]);
                if (i != 0) {
                    return i;
                }
                i = i3 + 1;
                i2++;
            }
        }
        return compareTo(fArr.length, fArr2.length);
    }

    public static int compareTo(double[] dArr, double[] dArr2) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i3 < dArr.length && i2 < dArr2.length) {
                i = compareTo(dArr[i3], dArr2[i2]);
                if (i != 0) {
                    return i;
                }
                i = i3 + 1;
                i2++;
            }
        }
        return compareTo(dArr.length, dArr2.length);
    }

    public static int hashCode(boolean z) {
        return (z ? 0 : 1) + 629;
    }

    public static int hashCode(boolean[] zArr) {
        if (zArr == null) {
            return 629;
        }
        int i = 17;
        for (boolean z : zArr) {
            i = (z ? 0 : 1) + (i * 37);
        }
        return i;
    }

    public static int hashCode(byte b) {
        return b + 629;
    }

    public static int hashCode(byte[] bArr) {
        if (bArr == null) {
            return 629;
        }
        int i = 17;
        for (byte b : bArr) {
            i = (i * 37) + b;
        }
        return i;
    }

    public static int hashCode(char c) {
        return c + 629;
    }

    public static int hashCode(char[] cArr) {
        if (cArr == null) {
            return 629;
        }
        int i = 17;
        for (char c : cArr) {
            i = (i * 37) + c;
        }
        return i;
    }

    public static int hashCode(double d) {
        return hashCode(Double.doubleToLongBits(d));
    }

    public static int hashCode(double[] dArr) {
        if (dArr == null) {
            return 629;
        }
        int i = 17;
        for (int i2 = 0; i2 < dArr.length; i2++) {
            i = (i * 37) + ((int) (Double.doubleToLongBits(dArr[i2]) ^ (Double.doubleToLongBits(dArr[i2]) >> 32)));
        }
        return i;
    }

    public static int hashCode(float f) {
        return Float.floatToIntBits(f) + 629;
    }

    public static int hashCode(float[] fArr) {
        if (fArr == null) {
            return 629;
        }
        int i = 17;
        for (float floatToIntBits : fArr) {
            i = (i * 37) + Float.floatToIntBits(floatToIntBits);
        }
        return i;
    }

    public static int hashCode(short s) {
        return s + 629;
    }

    public static int hashCode(short[] sArr) {
        if (sArr == null) {
            return 629;
        }
        int i = 17;
        for (short s : sArr) {
            i = (i * 37) + s;
        }
        return i;
    }

    public static int hashCode(int i) {
        return i + 629;
    }

    public static int hashCode(int[] iArr) {
        if (iArr == null) {
            return 629;
        }
        int i = 17;
        for (int i2 : iArr) {
            i = (i * 37) + i2;
        }
        return i;
    }

    public static int hashCode(long j) {
        return ((int) ((j >> 32) ^ j)) + 629;
    }

    public static int hashCode(long[] jArr) {
        if (jArr == null) {
            return 629;
        }
        int i = 17;
        for (int i2 = 0; i2 < jArr.length; i2++) {
            i = (i * 37) + ((int) (jArr[i2] ^ (jArr[i2] >> 32)));
        }
        return i;
    }

    public static int hashCode(JceStruct[] jceStructArr) {
        if (jceStructArr == null) {
            return 629;
        }
        int i = 17;
        for (Object hashCode : jceStructArr) {
            i = (i * 37) + hashCode.hashCode();
        }
        return i;
    }

    public static int hashCode(Object obj) {
        Object obj2 = obj;
        while (obj2 != null) {
            if (obj2.getClass().isArray()) {
                if (obj2 instanceof long[]) {
                    return hashCode((long[]) obj2);
                }
                if (obj2 instanceof int[]) {
                    return hashCode((int[]) obj2);
                }
                if (obj2 instanceof short[]) {
                    return hashCode((short[]) obj2);
                }
                if (obj2 instanceof char[]) {
                    return hashCode((char[]) obj2);
                }
                if (obj2 instanceof byte[]) {
                    return hashCode((byte[]) obj2);
                }
                if (obj2 instanceof double[]) {
                    return hashCode((double[]) obj2);
                }
                if (obj2 instanceof float[]) {
                    return hashCode((float[]) obj2);
                }
                if (obj2 instanceof boolean[]) {
                    return hashCode((boolean[]) obj2);
                }
                if (obj2 instanceof JceStruct[]) {
                    return hashCode((JceStruct[]) obj2);
                }
                Object[] obj22 = (Object[]) obj22;
            } else if (obj22 instanceof JceStruct) {
                return obj22.hashCode();
            } else {
                return obj22.hashCode() + 629;
            }
        }
        return 629;
    }

    public static byte[] getJceBufArray(ByteBuffer byteBuffer) {
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
        highDigits = bArr2;
        lowDigits = bArr3;
    }

    public static String getHexdump(byte[] bArr) {
        return getHexdump(ByteBuffer.wrap(bArr));
    }

    public static String getHexdump(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (remaining == 0) {
            return "empty";
        }
        StringBuffer stringBuffer = new StringBuffer((byteBuffer.remaining() * 3) - 1);
        int position = byteBuffer.position();
        int i = byteBuffer.get() & 255;
        stringBuffer.append((char) highDigits[i]);
        stringBuffer.append((char) lowDigits[i]);
        for (remaining--; remaining > 0; remaining--) {
            stringBuffer.append(' ');
            i = byteBuffer.get() & 255;
            stringBuffer.append((char) highDigits[i]);
            stringBuffer.append((char) lowDigits[i]);
        }
        byteBuffer.position(position);
        return stringBuffer.toString();
    }
}
