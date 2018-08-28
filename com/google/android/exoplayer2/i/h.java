package com.google.android.exoplayer2.i;

import com.tencent.wcdb.FileUtils;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class h {
    public static final byte[] aBV = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1};
    public static final float[] aCd = new float[]{1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object aCe = new Object();
    private static int[] aCf = new int[10];

    public static int i(byte[] bArr, int i) {
        int i2;
        synchronized (aCe) {
            int i3;
            int i4 = 0;
            int i5 = 0;
            while (i5 < i) {
                while (i5 < i - 2) {
                    if (bArr[i5] == (byte) 0 && bArr[i5 + 1] == (byte) 0 && bArr[i5 + 2] == (byte) 3) {
                        break;
                    }
                    i5++;
                }
                i5 = i;
                if (i5 < i) {
                    if (aCf.length <= i4) {
                        aCf = Arrays.copyOf(aCf, aCf.length * 2);
                    }
                    i3 = i4 + 1;
                    aCf[i4] = i5;
                    i5 += 3;
                    i4 = i3;
                }
            }
            i2 = i - i4;
            i5 = 0;
            i3 = 0;
            int i6 = 0;
            while (i5 < i4) {
                int i7 = aCf[i5] - i6;
                System.arraycopy(bArr, i6, bArr, i3, i7);
                int i8 = i3 + i7;
                i3 = i8 + 1;
                bArr[i8] = (byte) 0;
                i8 = i3 + 1;
                bArr[i3] = (byte) 0;
                i6 += i7 + 3;
                i5++;
                i3 = i8;
            }
            System.arraycopy(bArr, i6, bArr, i3, i2 - i3);
        }
        return i2;
    }

    public static void e(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i = 0;
        int i2 = 0;
        while (i + 1 < position) {
            int i3 = byteBuffer.get(i) & 255;
            if (i2 == 3) {
                if (i3 == 1 && (byteBuffer.get(i + 1) & 31) == 7) {
                    ByteBuffer duplicate = byteBuffer.duplicate();
                    duplicate.position(i - 3);
                    duplicate.limit(position);
                    byteBuffer.position(0);
                    byteBuffer.put(duplicate);
                    return;
                }
            } else if (i3 == 0) {
                i2++;
            }
            if (i3 != 0) {
                i2 = 0;
            }
            i++;
        }
        byteBuffer.clear();
    }

    public static boolean b(String str, byte b) {
        return ("video/avc".equals(str) && (b & 31) == 6) || ("video/hevc".equals(str) && ((b & 126) >> 1) == 39);
    }

    public static int j(byte[] bArr, int i) {
        return bArr[i + 3] & 31;
    }

    public static int k(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    public static b j(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        boolean z;
        int i6;
        float f;
        k kVar = new k(bArr, i, i2);
        kVar.cX(8);
        int cY = kVar.cY(8);
        kVar.cX(16);
        int mn = kVar.mn();
        int i7 = 1;
        boolean z2 = false;
        if (cY == 100 || cY == 110 || cY == 122 || cY == 244 || cY == 44 || cY == 83 || cY == 86 || cY == 118 || cY == FileUtils.S_IWUSR || cY == 138) {
            int mn2 = kVar.mn();
            if (mn2 == 3) {
                z2 = kVar.mb();
            }
            kVar.mn();
            kVar.mn();
            kVar.mk();
            if (kVar.mb()) {
                i7 = mn2 != 3 ? 8 : 12;
                i3 = 0;
                while (i3 < i7) {
                    if (kVar.mb()) {
                        int i8 = i3 < 6 ? 16 : 64;
                        cY = 8;
                        i4 = 8;
                        for (i5 = 0; i5 < i8; i5++) {
                            if (i4 != 0) {
                                i4 = ((kVar.mm() + cY) + 256) % 256;
                            }
                            if (i4 != 0) {
                                cY = i4;
                            }
                        }
                    }
                    i3++;
                }
            }
            z = z2;
            i7 = mn2;
        } else {
            z = false;
        }
        i3 = kVar.mn() + 4;
        i5 = kVar.mn();
        int i9 = 0;
        boolean z3 = false;
        if (i5 == 0) {
            i9 = kVar.mn() + 4;
        } else if (i5 == 1) {
            z3 = kVar.mb();
            kVar.mm();
            kVar.mm();
            long mn3 = (long) kVar.mn();
            for (i6 = 0; ((long) i6) < mn3; i6++) {
                kVar.mn();
            }
        }
        kVar.mn();
        kVar.mk();
        cY = kVar.mn() + 1;
        i4 = kVar.mn() + 1;
        boolean mb = kVar.mb();
        i6 = (2 - (mb ? 1 : 0)) * i4;
        if (!mb) {
            kVar.mk();
        }
        kVar.mk();
        i4 = cY * 16;
        int i10 = i6 * 16;
        if (kVar.mb()) {
            int mn4 = kVar.mn();
            int mn5 = kVar.mn();
            int mn6 = kVar.mn();
            int mn7 = kVar.mn();
            if (i7 == 0) {
                i7 = 1;
                i6 = 2 - (mb ? 1 : 0);
            } else {
                i6 = (2 - (mb ? 1 : 0)) * (i7 == 1 ? 2 : 1);
                i7 = i7 == 3 ? 1 : 2;
            }
            i7 = i4 - (i7 * (mn4 + mn5));
            cY = i10 - (i6 * (mn6 + mn7));
        } else {
            i7 = i4;
            cY = i10;
        }
        float f2 = 1.0f;
        if (kVar.mb() && kVar.mb()) {
            i4 = kVar.cY(8);
            if (i4 == 255) {
                i4 = kVar.cY(16);
                i10 = kVar.cY(16);
                if (!(i4 == 0 || i10 == 0)) {
                    f2 = ((float) i4) / ((float) i10);
                }
                f = f2;
            } else if (i4 < aCd.length) {
                f = aCd[i4];
            }
            return new b(mn, i7, cY, f, z, mb, i3, i5, i9, z3);
        }
        f = 1.0f;
        return new b(mn, i7, cY, f, z, mb, i3, i5, i9, z3);
    }

    public static a l(byte[] bArr, int i) {
        k kVar = new k(bArr, 3, i);
        kVar.cX(8);
        int mn = kVar.mn();
        int mn2 = kVar.mn();
        kVar.mk();
        return new a(mn, mn2, kVar.mb());
    }

    public static int a(byte[] bArr, int i, int i2, boolean[] zArr) {
        boolean z = true;
        int i3 = i2 - i;
        a.ap(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr != null) {
            if (zArr[0]) {
                b(zArr);
                return i - 3;
            } else if (i3 > 1 && zArr[1] && bArr[i] == (byte) 1) {
                b(zArr);
                return i - 2;
            } else if (i3 > 2 && zArr[2] && bArr[i] == (byte) 0 && bArr[i + 1] == (byte) 1) {
                b(zArr);
                return i - 1;
            }
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            if ((bArr[i5] & 254) == 0) {
                if (bArr[i5 - 2] == (byte) 0 && bArr[i5 - 1] == (byte) 0 && bArr[i5] == (byte) 1) {
                    if (zArr != null) {
                        b(zArr);
                    }
                    return i5 - 2;
                }
                i5 -= 2;
            }
            i5 += 3;
        }
        if (zArr == null) {
            return i2;
        }
        boolean z2 = i3 > 2 ? bArr[i2 + -3] == (byte) 0 && bArr[i2 - 2] == (byte) 0 && bArr[i2 - 1] == (byte) 1 : i3 == 2 ? zArr[2] && bArr[i2 - 2] == (byte) 0 && bArr[i2 - 1] == (byte) 1 : zArr[1] && bArr[i2 - 1] == (byte) 1;
        zArr[0] = z2;
        z2 = i3 > 1 ? bArr[i2 + -2] == (byte) 0 && bArr[i2 - 1] == (byte) 0 : zArr[2] && bArr[i2 - 1] == (byte) 0;
        zArr[1] = z2;
        if (bArr[i2 - 1] != (byte) 0) {
            z = false;
        }
        zArr[2] = z;
        return i2;
    }

    public static void b(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }
}
