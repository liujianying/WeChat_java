package android.support.a.a;

import android.graphics.Path;
import java.util.ArrayList;

final class c {

    private static class a {
        int jF;
        boolean jG;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public static class b {
        char jH;
        float[] jI;

        /* synthetic */ b(char c, float[] fArr, byte b) {
            this(c, fArr);
        }

        private b(char c, float[] fArr) {
            this.jH = c;
            this.jI = fArr;
        }

        private b(b bVar) {
            this.jH = bVar.jH;
            this.jI = c.b(bVar.jI, bVar.jI.length);
        }

        static void a(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            Path path2 = path;
            while (true) {
                double toRadians = Math.toRadians((double) f7);
                double cos = Math.cos(toRadians);
                double sin = Math.sin(toRadians);
                double d = ((((double) f) * cos) + (((double) f2) * sin)) / ((double) f5);
                double d2 = ((((double) (-f)) * sin) + (((double) f2) * cos)) / ((double) f6);
                double d3 = ((((double) f3) * cos) + (((double) f4) * sin)) / ((double) f5);
                double d4 = ((((double) (-f3)) * sin) + (((double) f4) * cos)) / ((double) f6);
                double d5 = d - d3;
                double d6 = d2 - d4;
                double d7 = (d + d3) / 2.0d;
                double d8 = (d2 + d4) / 2.0d;
                double d9 = (d5 * d5) + (d6 * d6);
                if (d9 != 0.0d) {
                    double d10 = (1.0d / d9) - 0.25d;
                    if (d10 < 0.0d) {
                        float sqrt = (float) (Math.sqrt(d9) / 1.99999d);
                        f5 *= sqrt;
                        f6 *= sqrt;
                    } else {
                        d9 = Math.sqrt(d10);
                        d5 *= d9;
                        d6 *= d9;
                        if (z == z2) {
                            d6 = d7 - d6;
                            d5 += d8;
                        } else {
                            d6 += d7;
                            d5 = d8 - d5;
                        }
                        d2 = Math.atan2(d2 - d5, d - d6);
                        d = Math.atan2(d4 - d5, d3 - d6) - d2;
                        if (z2 != (d >= 0.0d)) {
                            if (d > 0.0d) {
                                d -= 6.283185307179586d;
                            } else {
                                d += 6.283185307179586d;
                            }
                        }
                        d6 *= (double) f5;
                        d5 *= (double) f6;
                        d9 = (d6 * cos) - (d5 * sin);
                        d10 = (d6 * sin) + (d5 * cos);
                        double d11 = (double) f5;
                        double d12 = (double) f6;
                        sin = (double) f;
                        cos = (double) f2;
                        int ceil = (int) Math.ceil(Math.abs((4.0d * d) / 3.141592653589793d));
                        double cos2 = Math.cos(toRadians);
                        double sin2 = Math.sin(toRadians);
                        d5 = Math.cos(d2);
                        toRadians = Math.sin(d2);
                        d6 = (((-d11) * cos2) * toRadians) - ((d12 * sin2) * d5);
                        d5 = (d5 * (d12 * cos2)) + (toRadians * ((-d11) * sin2));
                        double d13 = d / ((double) ceil);
                        d = d2;
                        int i = 0;
                        d3 = cos;
                        d7 = sin;
                        while (i < ceil) {
                            sin = d + d13;
                            d2 = Math.sin(sin);
                            double cos3 = Math.cos(sin);
                            d8 = (((d11 * cos2) * cos3) + d9) - ((d12 * sin2) * d2);
                            d4 = ((d12 * cos2) * d2) + (((d11 * sin2) * cos3) + d10);
                            cos = (((-d11) * cos2) * d2) - ((d12 * sin2) * cos3);
                            d2 = (d2 * ((-d11) * sin2)) + (cos3 * (d12 * cos2));
                            cos3 = Math.tan((sin - d) / 2.0d);
                            d = (Math.sin(sin - d) * (Math.sqrt((cos3 * (3.0d * cos3)) + 4.0d) - 1.0d)) / 3.0d;
                            path2.cubicTo((float) ((d6 * d) + d7), (float) ((d5 * d) + d3), (float) (d8 - (d * cos)), (float) (d4 - (d * d2)), (float) d8, (float) d4);
                            d5 = d2;
                            d6 = cos;
                            d = sin;
                            i++;
                            d3 = d4;
                            d7 = d8;
                        }
                        return;
                    }
                }
                return;
            }
        }
    }

    static float[] b(float[] fArr, int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i2 = i + 0;
        length = Math.min(i2, length + 0);
        Object obj = new float[i2];
        System.arraycopy(fArr, 0, obj, 0, length);
        return obj;
    }

    public static b[] z(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int f = f(str, i);
            String trim = str.substring(i2, f).trim();
            if (trim.length() > 0) {
                a(arrayList, trim.charAt(0), A(trim));
            }
            i = f + 1;
            i2 = f;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            a(arrayList, str.charAt(i2), new float[0]);
        }
        return (b[]) arrayList.toArray(new b[arrayList.size()]);
    }

    public static b[] a(b[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr2[i] = new b(bVarArr[i], (byte) 0);
        }
        return bVarArr2;
    }

    private static int f(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 65) * (charAt - 90) <= 0 || (charAt - 97) * (charAt - 122) <= 0) && charAt != 'e' && charAt != 'E') {
                break;
            }
            i++;
        }
        return i;
    }

    private static void a(ArrayList<b> arrayList, char c, float[] fArr) {
        arrayList.add(new b(c, fArr, (byte) 0));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static float[] A(java.lang.String r12) {
        /*
        r1 = 1;
        r2 = 0;
        r0 = r12.charAt(r2);
        r3 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
        if (r0 != r3) goto L_0x001a;
    L_0x000a:
        r0 = r1;
    L_0x000b:
        r3 = r12.charAt(r2);
        r4 = 90;
        if (r3 != r4) goto L_0x001c;
    L_0x0013:
        r3 = r1;
    L_0x0014:
        r0 = r0 | r3;
        if (r0 == 0) goto L_0x001e;
    L_0x0017:
        r0 = new float[r2];
    L_0x0019:
        return r0;
    L_0x001a:
        r0 = r2;
        goto L_0x000b;
    L_0x001c:
        r3 = r2;
        goto L_0x0014;
    L_0x001e:
        r0 = r12.length();	 Catch:{ NumberFormatException -> 0x0088 }
        r8 = new float[r0];	 Catch:{ NumberFormatException -> 0x0088 }
        r9 = new android.support.a.a.c$a;	 Catch:{ NumberFormatException -> 0x0088 }
        r0 = 0;
        r9.<init>(r0);	 Catch:{ NumberFormatException -> 0x0088 }
        r10 = r12.length();	 Catch:{ NumberFormatException -> 0x0088 }
        r7 = r1;
        r3 = r2;
    L_0x0030:
        if (r7 >= r10) goto L_0x0083;
    L_0x0032:
        r0 = 0;
        r9.jG = r0;	 Catch:{ NumberFormatException -> 0x0088 }
        r0 = r2;
        r4 = r2;
        r5 = r2;
        r6 = r7;
    L_0x0039:
        r11 = r12.length();	 Catch:{ NumberFormatException -> 0x0088 }
        if (r6 >= r11) goto L_0x0066;
    L_0x003f:
        r11 = r12.charAt(r6);	 Catch:{ NumberFormatException -> 0x0088 }
        switch(r11) {
            case 32: goto L_0x004c;
            case 44: goto L_0x004c;
            case 45: goto L_0x004f;
            case 46: goto L_0x0059;
            case 69: goto L_0x0064;
            case 101: goto L_0x0064;
            default: goto L_0x0046;
        };	 Catch:{ NumberFormatException -> 0x0088 }
    L_0x0046:
        r0 = r2;
    L_0x0047:
        if (r5 != 0) goto L_0x0066;
    L_0x0049:
        r6 = r6 + 1;
        goto L_0x0039;
    L_0x004c:
        r0 = r2;
        r5 = r1;
        goto L_0x0047;
    L_0x004f:
        if (r6 == r7) goto L_0x0046;
    L_0x0051:
        if (r0 != 0) goto L_0x0046;
    L_0x0053:
        r0 = 1;
        r9.jG = r0;	 Catch:{ NumberFormatException -> 0x0088 }
        r0 = r2;
        r5 = r1;
        goto L_0x0047;
    L_0x0059:
        if (r4 != 0) goto L_0x005e;
    L_0x005b:
        r0 = r2;
        r4 = r1;
        goto L_0x0047;
    L_0x005e:
        r0 = 1;
        r9.jG = r0;	 Catch:{ NumberFormatException -> 0x0088 }
        r0 = r2;
        r5 = r1;
        goto L_0x0047;
    L_0x0064:
        r0 = r1;
        goto L_0x0047;
    L_0x0066:
        r9.jF = r6;	 Catch:{ NumberFormatException -> 0x0088 }
        r4 = r9.jF;	 Catch:{ NumberFormatException -> 0x0088 }
        if (r7 >= r4) goto L_0x00a6;
    L_0x006c:
        r0 = r3 + 1;
        r5 = r12.substring(r7, r4);	 Catch:{ NumberFormatException -> 0x0088 }
        r5 = java.lang.Float.parseFloat(r5);	 Catch:{ NumberFormatException -> 0x0088 }
        r8[r3] = r5;	 Catch:{ NumberFormatException -> 0x0088 }
    L_0x0078:
        r3 = r9.jG;	 Catch:{ NumberFormatException -> 0x0088 }
        if (r3 == 0) goto L_0x007f;
    L_0x007c:
        r7 = r4;
        r3 = r0;
        goto L_0x0030;
    L_0x007f:
        r7 = r4 + 1;
        r3 = r0;
        goto L_0x0030;
    L_0x0083:
        r0 = b(r8, r3);	 Catch:{ NumberFormatException -> 0x0088 }
        goto L_0x0019;
    L_0x0088:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r3 = "error in parsing \"";
        r2.<init>(r3);
        r2 = r2.append(r12);
        r3 = "\"";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2, r0);
        throw r1;
    L_0x00a6:
        r0 = r3;
        goto L_0x0078;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.a.a.c.A(java.lang.String):float[]");
    }
}
