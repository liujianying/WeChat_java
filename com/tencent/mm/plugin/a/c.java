package com.tencent.mm.plugin.a;

import com.tencent.mm.sdk.platformtools.x;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;

public final class c {
    public static boolean oZ(String str) {
        Throwable e;
        if (oW(str)) {
            return false;
        }
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[8];
                if (fileInputStream.read(bArr, 0, 8) < 8) {
                    try {
                        fileInputStream.close();
                        return false;
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.AtomUtil", e2, "", new Object[0]);
                        return false;
                    }
                }
                int B = B(bArr, 0);
                if (B(bArr, 4) != a.ajo || B <= 0) {
                    try {
                        fileInputStream.close();
                        return false;
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.AtomUtil", e22, "", new Object[0]);
                        return false;
                    }
                }
                try {
                    fileInputStream.close();
                } catch (Throwable e222) {
                    x.printErrStackTrace("MicroMsg.AtomUtil", e222, "", new Object[0]);
                }
                return true;
            } catch (Exception e3) {
                e222 = e3;
            }
        } catch (Exception e4) {
            e222 = e4;
            fileInputStream = null;
            try {
                x.printErrStackTrace("MicroMsg.AtomUtil", e222, "", new Object[0]);
                if (fileInputStream == null) {
                    return false;
                }
                try {
                    fileInputStream.close();
                    return false;
                } catch (Throwable e2222) {
                    x.printErrStackTrace("MicroMsg.AtomUtil", e2222, "", new Object[0]);
                    return false;
                }
            } catch (Throwable th) {
                e2222 = th;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable e5) {
                        x.printErrStackTrace("MicroMsg.AtomUtil", e5, "", new Object[0]);
                    }
                }
                throw e2222;
            }
        } catch (Throwable th2) {
            e2222 = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable e52) {
                    x.printErrStackTrace("MicroMsg.AtomUtil", e52, "", new Object[0]);
                }
            }
            throw e2222;
        }
    }

    public static boolean oW(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return false;
    }

    public static int aE(String str) {
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            i++;
            i2 = (i2 << 8) | str.charAt(i);
        }
        return i2;
    }

    public static int B(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return ((((bArr[i2] & 255) << 16) | ((bArr[i] & 255) << 24)) | ((bArr[i3] & 255) << 8)) | (bArr[i3 + 1] & 255);
    }

    public static long C(byte[] bArr, int i) {
        Object obj = new byte[8];
        Arrays.fill(obj, (byte) 0);
        System.arraycopy(bArr, i, obj, 4, 4);
        return R(obj);
    }

    public static long R(byte[] bArr) {
        return ((((((((((long) bArr[0]) & 255) << 56) | ((((long) bArr[1]) & 255) << 48)) | ((((long) bArr[2]) & 255) << 40)) | ((((long) bArr[3]) & 255) << 32)) | ((((long) bArr[4]) & 255) << 24)) | ((((long) bArr[5]) & 255) << 16)) | ((((long) bArr[6]) & 255) << 8)) | (((long) bArr[7]) & 255);
    }

    public static a a(RandomAccessFile randomAccessFile, byte[] bArr, int i) {
        try {
            int read = randomAccessFile.read(bArr);
            while (read >= 8) {
                int B = B(bArr, 0);
                int B2 = B(bArr, 4);
                if (B2 != i) {
                    if (B2 != a.ajP && B2 != a.ajT) {
                        if (!a(randomAccessFile, (long) (B - 8))) {
                            break;
                        }
                        read = randomAccessFile.read(bArr);
                    } else {
                        read = randomAccessFile.read(bArr);
                    }
                } else {
                    long filePointer = randomAccessFile.getFilePointer() - ((long) read);
                    if (B2 == a.ajR) {
                        return new i(B, filePointer, B2);
                    }
                    if (B2 == a.ajS) {
                        return new e(B, filePointer, B2);
                    }
                    return B2 == a.ajU ? new h(B, filePointer, B2) : new a(B, filePointer, B2, 0);
                }
            }
            return null;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AtomUtil", e, "", new Object[0]);
            x.e("MicroMsg.AtomUtil", "find Atom error: " + e.toString());
            return null;
        }
    }

    public static boolean a(RandomAccessFile randomAccessFile, long j) {
        long j2 = 0;
        while (j > 2147483647L) {
            j2 += (long) randomAccessFile.skipBytes(Integer.MAX_VALUE);
            j -= 2147483647L;
        }
        j2 += (long) randomAccessFile.skipBytes((int) j);
        if (j2 == j) {
            return true;
        }
        x.w("MicroMsg.AtomUtil", "can not skip.skip: " + j + " trueSkip : " + j2);
        return false;
    }
}
