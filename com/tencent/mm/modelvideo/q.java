package com.tencent.mm.modelvideo;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileInputStream;
import java.io.IOException;

public final class q {
    private static String bytesToHexString(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        if (bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & b.CTRL_BYTE);
            if (toHexString.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }

    public static boolean nD(String str) {
        Throwable e;
        Throwable th;
        x.d("MicroMsg.VideoFile", " filepath " + str);
        if (bi.oW(str)) {
            return false;
        }
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[10];
                fileInputStream.read(bArr, 0, 10);
                String bytesToHexString = bytesToHexString(bArr);
                if (!bi.oW(bytesToHexString)) {
                    bytesToHexString = bytesToHexString.toUpperCase();
                    x.d("MicroMsg.VideoFile", "file type " + bytesToHexString);
                    if (bytesToHexString.contains("00000014667479707174")) {
                        x.d("MicroMsg.VideoFile", "file type qt ");
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                        }
                        return true;
                    }
                }
                try {
                    fileInputStream.close();
                    return false;
                } catch (IOException e3) {
                    return false;
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    x.e("MicroMsg.VideoFile", "exception:%s", new Object[]{bi.i(e)});
                    if (fileInputStream != null) {
                        return false;
                    }
                    try {
                        fileInputStream.close();
                        return false;
                    } catch (IOException e5) {
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e7) {
            e = e7;
            fileInputStream = null;
            x.e("MicroMsg.VideoFile", "exception:%s", new Object[]{bi.i(e)});
            if (fileInputStream != null) {
                return false;
            }
            try {
                fileInputStream.close();
                return false;
            } catch (IOException e52) {
                return false;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e62) {
                }
            }
            throw th;
        }
    }

    public static boolean nE(String str) {
        Throwable e;
        Throwable th;
        if (!e.cn(str)) {
            return false;
        }
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[32];
                fileInputStream.read(bArr, 0, 32);
                String bytesToHexString = bytesToHexString(bArr);
                if (bi.oW(bytesToHexString) || !bytesToHexString.toUpperCase().contains("68766331")) {
                    try {
                        fileInputStream.close();
                        return false;
                    } catch (IOException e2) {
                        return false;
                    }
                }
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                }
                return true;
            } catch (Exception e4) {
                e = e4;
                try {
                    x.e("MicroMsg.VideoFile", "exception:%s", new Object[]{bi.i(e)});
                    if (fileInputStream != null) {
                        return false;
                    }
                    try {
                        fileInputStream.close();
                        return false;
                    } catch (IOException e5) {
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e7) {
            e = e7;
            fileInputStream = null;
            x.e("MicroMsg.VideoFile", "exception:%s", new Object[]{bi.i(e)});
            if (fileInputStream != null) {
                return false;
            }
            try {
                fileInputStream.close();
                return false;
            } catch (IOException e52) {
                return false;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e62) {
                }
            }
            throw th;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean nF(java.lang.String r12) {
        /*
        r4 = 0;
        r1 = 1;
        r0 = 0;
        r2 = com.tencent.mm.a.e.cn(r12);
        if (r2 != 0) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r2 = "MicroMsg.VideoFile";
        r3 = "check is h265 video %s";
        r5 = new java.lang.Object[r1];
        r5[r0] = r12;
        com.tencent.mm.sdk.platformtools.x.d(r2, r3, r5);
        r5 = new android.media.MediaExtractor;	 Catch:{ Throwable -> 0x0066, all -> 0x007c }
        r5.<init>();	 Catch:{ Throwable -> 0x0066, all -> 0x007c }
        r5.setDataSource(r12);	 Catch:{ Throwable -> 0x0089, all -> 0x0084 }
        r7 = r5.getTrackCount();	 Catch:{ Throwable -> 0x0089, all -> 0x0084 }
        r6 = r0;
    L_0x0024:
        if (r6 >= r7) goto L_0x0062;
    L_0x0026:
        r2 = r5.getTrackFormat(r6);	 Catch:{ Throwable -> 0x003f, all -> 0x0084 }
        r3 = "mime";
        r3 = r2.getString(r3);	 Catch:{ Throwable -> 0x003f, all -> 0x0084 }
        r2 = "video/hevc";
        r2 = r2.equalsIgnoreCase(r3);	 Catch:{ Throwable -> 0x008c, all -> 0x0084 }
        if (r2 == 0) goto L_0x0050;
    L_0x003a:
        r5.release();
        r0 = r1;
        goto L_0x0009;
    L_0x003f:
        r2 = move-exception;
        r3 = r4;
    L_0x0041:
        r8 = "MicroMsg.VideoFile";
        r9 = "check is h265 video %s";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ Throwable -> 0x0089, all -> 0x0084 }
        r11 = 0;
        r10[r11] = r12;	 Catch:{ Throwable -> 0x0089, all -> 0x0084 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r8, r2, r9, r10);	 Catch:{ Throwable -> 0x0089, all -> 0x0084 }
    L_0x0050:
        r2 = "video/hevc";
        r2 = r2.equalsIgnoreCase(r3);	 Catch:{ Throwable -> 0x0089, all -> 0x0084 }
        if (r2 == 0) goto L_0x005e;
    L_0x0059:
        r5.release();
        r0 = r1;
        goto L_0x0009;
    L_0x005e:
        r2 = r6 + 1;
        r6 = r2;
        goto L_0x0024;
    L_0x0062:
        r5.release();
        goto L_0x0009;
    L_0x0066:
        r1 = move-exception;
    L_0x0067:
        r2 = "MicroMsg.VideoFile";
        r3 = "check is h265 video %s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0086 }
        r6 = 0;
        r5[r6] = r12;	 Catch:{ all -> 0x0086 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r1, r3, r5);	 Catch:{ all -> 0x0086 }
        if (r4 == 0) goto L_0x0009;
    L_0x0078:
        r4.release();
        goto L_0x0009;
    L_0x007c:
        r0 = move-exception;
        r5 = r4;
    L_0x007e:
        if (r5 == 0) goto L_0x0083;
    L_0x0080:
        r5.release();
    L_0x0083:
        throw r0;
    L_0x0084:
        r0 = move-exception;
        goto L_0x007e;
    L_0x0086:
        r0 = move-exception;
        r5 = r4;
        goto L_0x007e;
    L_0x0089:
        r1 = move-exception;
        r4 = r5;
        goto L_0x0067;
    L_0x008c:
        r2 = move-exception;
        goto L_0x0041;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvideo.q.nF(java.lang.String):boolean");
    }

    public static boolean nG(String str) {
        Throwable e;
        Throwable th;
        x.d("MicroMsg.VideoFile", " filepath " + str);
        if (bi.oW(str)) {
            return false;
        }
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[7];
                fileInputStream.read(bArr, 0, 7);
                String bytesToHexString = bytesToHexString(bArr);
                if (!bi.oW(bytesToHexString)) {
                    bytesToHexString = bytesToHexString.toUpperCase();
                    x.d("MicroMsg.VideoFile", "file type " + bytesToHexString);
                    if (bytesToHexString.contains("234558544D3355")) {
                        x.d("MicroMsg.VideoFile", "it is m3u8 file");
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                        }
                        return true;
                    }
                }
                try {
                    fileInputStream.close();
                    return false;
                } catch (IOException e3) {
                    return false;
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    x.e("MicroMsg.VideoFile", "exception:%s", new Object[]{bi.i(e)});
                    if (fileInputStream != null) {
                        return false;
                    }
                    try {
                        fileInputStream.close();
                        return false;
                    } catch (IOException e5) {
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e7) {
            e = e7;
            fileInputStream = null;
            x.e("MicroMsg.VideoFile", "exception:%s", new Object[]{bi.i(e)});
            if (fileInputStream != null) {
                return false;
            }
            try {
                fileInputStream.close();
                return false;
            } catch (IOException e52) {
                return false;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e62) {
                }
            }
            throw th;
        }
    }
}
