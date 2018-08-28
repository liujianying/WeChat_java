package com.tencent.mm.plugin.a;

import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;

public final class b {
    public a eyA = null;
    public long eyx = -1;
    public long eyy = -1;
    public long eyz = -1;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long oY(java.lang.String r12) {
        /*
        r11 = this;
        r2 = -1;
        r10 = 0;
        r0 = com.tencent.mm.plugin.a.c.oW(r12);
        if (r0 == 0) goto L_0x0013;
    L_0x0009:
        r0 = "MicroMsg.AtomParsers";
        r1 = "calc moov atom location but filepath is null.";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
    L_0x0012:
        return r2;
    L_0x0013:
        r7 = new java.io.File;
        r7.<init>(r12);
        r1 = 0;
        r6 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x00bc, all -> 0x00e1 }
        r6.<init>(r12);	 Catch:{ Exception -> 0x00bc, all -> 0x00e1 }
        r0 = r7.length();	 Catch:{ Exception -> 0x00fb, all -> 0x00f6 }
        r11.eyz = r0;	 Catch:{ Exception -> 0x00fb, all -> 0x00f6 }
        r0 = r11.n(r6);	 Catch:{ Exception -> 0x00fb, all -> 0x00f6 }
        if (r0 != 0) goto L_0x007e;
    L_0x002a:
        r0 = "MicroMsg.AtomParsers";
        r1 = "has no atom, this file may be not mp4";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);	 Catch:{ Exception -> 0x00fb, all -> 0x00f6 }
        r0 = r2;
        r4 = r2;
    L_0x0035:
        r6.close();	 Catch:{ IOException -> 0x00ae }
    L_0x0038:
        r11.eyx = r4;
        r11.eyy = r0;
        r0 = "MicroMsg.AtomParsers";
        r1 = new java.lang.StringBuilder;
        r2 = "calc moov atom location moovAtomLocation : ";
        r1.<init>(r2);
        r1 = r1.append(r4);
        r2 = " moovSize : ";
        r1 = r1.append(r2);
        r2 = r11.eyy;
        r1 = r1.append(r2);
        r2 = " file length : ";
        r1 = r1.append(r2);
        r2 = r7.length();
        r6 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r2 = r2 / r6;
        r1 = r1.append(r2);
        r2 = " K file path: ";
        r1 = r1.append(r2);
        r1 = r1.append(r12);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r2 = r4;
        goto L_0x0012;
    L_0x007e:
        r1 = r0.VJ();	 Catch:{ Exception -> 0x00fb, all -> 0x00f6 }
        if (r1 == 0) goto L_0x008c;
    L_0x0084:
        r4 = r0.eyw;	 Catch:{ Exception -> 0x00fb, all -> 0x00f6 }
        r2 = r0.getSize();	 Catch:{ Exception -> 0x00ff, all -> 0x00f6 }
        r0 = r2;
        goto L_0x0035;
    L_0x008c:
        r1 = r0.VK();	 Catch:{ Exception -> 0x00fb, all -> 0x00f6 }
        if (r1 == 0) goto L_0x009e;
    L_0x0092:
        r0 = "MicroMsg.AtomParsers";
        r1 = "it is the final atom, but can not find moov atom.";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);	 Catch:{ Exception -> 0x00fb, all -> 0x00f6 }
        r0 = r2;
        r4 = r2;
        goto L_0x0035;
    L_0x009e:
        r4 = r0.getSize();	 Catch:{ Exception -> 0x00fb, all -> 0x00f6 }
        r8 = 0;
        r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r1 <= 0) goto L_0x0105;
    L_0x00a8:
        r4 = r0.VL();	 Catch:{ Exception -> 0x00fb, all -> 0x00f6 }
        r0 = r2;
        goto L_0x0035;
    L_0x00ae:
        r2 = move-exception;
        r3 = "MicroMsg.AtomParsers";
        r6 = "";
        r8 = new java.lang.Object[r10];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r6, r8);
        goto L_0x0038;
    L_0x00bc:
        r0 = move-exception;
        r4 = r2;
    L_0x00be:
        r6 = "MicroMsg.AtomParsers";
        r8 = "";
        r9 = 0;
        r9 = new java.lang.Object[r9];	 Catch:{ all -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r6, r0, r8, r9);	 Catch:{ all -> 0x00f8 }
        if (r1 == 0) goto L_0x0102;
    L_0x00cc:
        r1.close();	 Catch:{ IOException -> 0x00d2 }
        r0 = r2;
        goto L_0x0038;
    L_0x00d2:
        r0 = move-exception;
        r1 = "MicroMsg.AtomParsers";
        r6 = "";
        r8 = new java.lang.Object[r10];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r6, r8);
        r0 = r2;
        goto L_0x0038;
    L_0x00e1:
        r0 = move-exception;
        r6 = r1;
    L_0x00e3:
        if (r6 == 0) goto L_0x00e8;
    L_0x00e5:
        r6.close();	 Catch:{ IOException -> 0x00e9 }
    L_0x00e8:
        throw r0;
    L_0x00e9:
        r1 = move-exception;
        r2 = "MicroMsg.AtomParsers";
        r3 = "";
        r4 = new java.lang.Object[r10];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r1, r3, r4);
        goto L_0x00e8;
    L_0x00f6:
        r0 = move-exception;
        goto L_0x00e3;
    L_0x00f8:
        r0 = move-exception;
        r6 = r1;
        goto L_0x00e3;
    L_0x00fb:
        r0 = move-exception;
        r1 = r6;
        r4 = r2;
        goto L_0x00be;
    L_0x00ff:
        r0 = move-exception;
        r1 = r6;
        goto L_0x00be;
    L_0x0102:
        r0 = r2;
        goto L_0x0038;
    L_0x0105:
        r0 = r2;
        r4 = r2;
        goto L_0x0035;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.a.b.oY(java.lang.String):long");
    }

    private a n(InputStream inputStream) {
        Throwable e;
        if (0 < 0) {
            x.w("MicroMsg.AtomParsers", "find Moov Atom, but parameter is error.");
            return null;
        }
        a aVar = null;
        a aVar2;
        try {
            if (inputStream.skip(0) < 0) {
                return null;
            }
            long j = 0;
            byte[] bArr = new byte[8];
            int read = inputStream.read(bArr, 0, 8);
            while (read >= 8) {
                try {
                    read = c.B(bArr, 0);
                    int B = c.B(bArr, 4);
                    long j2 = 0;
                    if (read == 1) {
                        if (inputStream.read(bArr, 0, 8) < 8) {
                            break;
                        }
                        j2 = c.R(bArr);
                    }
                    this.eyA = aVar;
                    aVar2 = new a(read, j, B, j2);
                    try {
                        if (aVar2.VJ() || aVar2.VK()) {
                            return aVar2;
                        }
                        long j3;
                        if (read > 1) {
                            j3 = (long) (read - 8);
                            j += (long) read;
                        } else if (j2 <= 0) {
                            return aVar2;
                        } else {
                            j += j2;
                            j3 = (j2 - 8) - 8;
                        }
                        if (inputStream.skip(j3) < j3) {
                            return aVar2;
                        }
                        read = inputStream.read(bArr, 0, 8);
                        aVar = aVar2;
                    } catch (Exception e2) {
                        e = e2;
                        x.printErrStackTrace("MicroMsg.AtomParsers", e, "", new Object[0]);
                        return aVar2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    aVar2 = aVar;
                    x.printErrStackTrace("MicroMsg.AtomParsers", e, "", new Object[0]);
                    return aVar2;
                }
            }
            return aVar;
        } catch (Exception e4) {
            e = e4;
            aVar2 = null;
            x.printErrStackTrace("MicroMsg.AtomParsers", e, "", new Object[0]);
            return aVar2;
        }
    }
}
