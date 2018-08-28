package com.tencent.mm.plugin.appbrand.media.a;

import com.tencent.mm.plugin.appbrand.appcache.ag;
import com.tencent.mm.plugin.appbrand.appcache.ag$a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.d;
import java.io.File;
import java.io.RandomAccessFile;

public final class e implements d {
    private static aa<String, Integer> ghN = new aa(50);
    private static aa<String, Integer> ghO = new aa(50);
    private static aa<String, Integer> ghP = new aa(50);
    private long currentPosition;
    private String ffK;
    private int fhe = -1;
    private String filePath;
    private int ghQ = -1;
    public RandomAccessFile randomAccessFile;

    public e(String str, String str2) {
        this.filePath = str;
        this.ffK = str2;
        this.randomAccessFile = bC(str, str2);
        if (ghN.bb(str) && ghO.bb(str)) {
            this.ghQ = ((Integer) ghN.get(str)).intValue();
            this.fhe = ((Integer) ghO.get(str)).intValue();
        } else if (bi.oW(str2)) {
            x.e("MicroMsg.WxaAudioDataSourceBelow19", "pkgpath is null, return");
        } else {
            ag agVar = new ag(new File(str2));
            if (!agVar.fgX) {
                agVar.close();
                x.e("MicroMsg.WxaAudioDataSourceBelow19", "pkg invalid");
            } else if (agVar.abW()) {
                ag$a qM = agVar.qM(str);
                if (qM == null) {
                    agVar.close();
                    x.e("MicroMsg.WxaAudioDataSourceBelow19", "info is null, err");
                } else if (qM.fhf <= 0 || qM.fhe <= 0) {
                    agVar.close();
                    x.e("MicroMsg.WxaAudioDataSourceBelow19", "info.resLength or info.fileOffset, err");
                } else {
                    this.ghQ = qM.fhf;
                    this.fhe = qM.fhe;
                    ghN.put(str, Integer.valueOf(this.ghQ));
                    ghO.put(str, Integer.valueOf(this.fhe));
                    agVar.close();
                }
            } else {
                agVar.close();
                x.e("MicroMsg.WxaAudioDataSourceBelow19", "pkg readInfo failed");
            }
        }
    }

    public final boolean isOpen() {
        return this.randomAccessFile != null || this.ghQ == -1 || this.fhe == -1;
    }

    public final void open() {
        x.i("MicroMsg.WxaAudioDataSourceBelow19", "open %d", Integer.valueOf(hashCode()));
        if (this.randomAccessFile == null) {
            this.randomAccessFile = bC(this.filePath, this.ffK);
        }
        this.currentPosition = 0;
        if (this.randomAccessFile != null) {
            this.randomAccessFile.seek((long) this.fhe);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.RandomAccessFile bC(java.lang.String r10, java.lang.String r11) {
        /*
        r9 = this;
        r5 = 1;
        r0 = 0;
        r8 = 0;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r11);
        if (r1 == 0) goto L_0x0013;
    L_0x0009:
        r1 = "MicroMsg.WxaAudioDataSourceBelow19";
        r2 = "pkgpath is null, return";
        com.tencent.mm.sdk.platformtools.x.e(r1, r2);
    L_0x0012:
        return r0;
    L_0x0013:
        r1 = "MicroMsg.WxaAudioDataSourceBelow19";
        r2 = "filePath:%s, resLength:%d, fileOffset:%d";
        r3 = 3;
        r3 = new java.lang.Object[r3];
        r3[r8] = r10;
        r4 = r9.ghQ;
        r4 = java.lang.Integer.valueOf(r4);
        r3[r5] = r4;
        r4 = 2;
        r5 = r9.fhe;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
        r1 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x004d, IOException -> 0x007b }
        r1.<init>(r11);	 Catch:{ FileNotFoundException -> 0x004d, IOException -> 0x007b }
        r1 = r1.exists();	 Catch:{ FileNotFoundException -> 0x004d, IOException -> 0x007b }
        if (r1 != 0) goto L_0x005a;
    L_0x003d:
        r1 = "MicroMsg.WxaAudioDataSourceBelow19";
        r2 = "file pkgPath:%s isn't exist ";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ FileNotFoundException -> 0x004d, IOException -> 0x007b }
        r4 = 0;
        r3[r4] = r11;	 Catch:{ FileNotFoundException -> 0x004d, IOException -> 0x007b }
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);	 Catch:{ FileNotFoundException -> 0x004d, IOException -> 0x007b }
        goto L_0x0012;
    L_0x004d:
        r1 = move-exception;
        r2 = "MicroMsg.WxaAudioDataSourceBelow19";
        r3 = "";
        r4 = new java.lang.Object[r8];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r1, r3, r4);
        goto L_0x0012;
    L_0x005a:
        r1 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x004d, IOException -> 0x007b }
        r2 = "r";
        r1.<init>(r11, r2);	 Catch:{ FileNotFoundException -> 0x004d, IOException -> 0x007b }
        r2 = "MicroMsg.WxaAudioDataSourceBelow19";
        r3 = "randomAccessFile.length:%d";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ FileNotFoundException -> 0x004d, IOException -> 0x0091 }
        r5 = 0;
        r6 = r1.length();	 Catch:{ FileNotFoundException -> 0x004d, IOException -> 0x0091 }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ FileNotFoundException -> 0x004d, IOException -> 0x0091 }
        r4[r5] = r6;	 Catch:{ FileNotFoundException -> 0x004d, IOException -> 0x0091 }
        com.tencent.mm.sdk.platformtools.x.d(r2, r3, r4);	 Catch:{ FileNotFoundException -> 0x004d, IOException -> 0x0091 }
        r0 = r1;
        goto L_0x0012;
    L_0x007b:
        r1 = move-exception;
        r2 = r1;
        r3 = r0;
    L_0x007e:
        r1 = "MicroMsg.WxaAudioDataSourceBelow19";
        r4 = "";
        r5 = new java.lang.Object[r8];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r2, r4, r5);
        if (r3 == 0) goto L_0x0012;
    L_0x008b:
        r3.close();	 Catch:{ IOException -> 0x008f }
        goto L_0x0012;
    L_0x008f:
        r1 = move-exception;
        goto L_0x0012;
    L_0x0091:
        r2 = move-exception;
        r3 = r1;
        goto L_0x007e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.media.a.e.bC(java.lang.String, java.lang.String):java.io.RandomAccessFile");
    }

    public final int readAt(long j, byte[] bArr, int i, int i2) {
        int i3 = -1;
        if (this.randomAccessFile == null) {
            x.e("MicroMsg.WxaAudioDataSourceBelow19", "[readAt]randomAccessFile is null");
        } else {
            if (this.currentPosition != j) {
                this.randomAccessFile.seek(((long) this.fhe) + j);
                this.currentPosition = j;
            }
            if (bArr == null || bArr.length <= 0) {
                x.e("MicroMsg.WxaAudioDataSourceBelow19", "[readAt]bytes is null");
            } else if (j < 0 || i < 0 || i2 <= 0) {
                x.e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d, offset:%d, size:%d", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
            } else if (bArr != null && i + i2 > bArr.length) {
                x.e("MicroMsg.WxaAudioDataSourceBelow19", "offset:%d, size:%d, bytes.length:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length));
            } else if (j >= ((long) this.ghQ)) {
                x.e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d resLength:%d", Long.valueOf(j), Integer.valueOf(this.ghQ));
            } else {
                if (((long) i2) + j >= ((long) this.ghQ)) {
                    x.e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d, size:%d, resLength:%d", Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(this.ghQ));
                    i2 = (int) (((long) this.ghQ) - j);
                }
                i3 = this.randomAccessFile.read(bArr, i, i2);
                if (i3 >= 0) {
                    this.currentPosition += (long) i3;
                } else {
                    x.e("MicroMsg.WxaAudioDataSourceBelow19", "read:%d err", Integer.valueOf(i3));
                }
            }
        }
        return i3;
    }

    public final long getSize() {
        if (this.randomAccessFile != null) {
            return (long) this.ghQ;
        }
        x.e("MicroMsg.WxaAudioDataSourceBelow19", "[getSize] randomAccessFile is null");
        return 0;
    }

    public final int Kn() {
        String str;
        int i = 1;
        if (this.randomAccessFile == null) {
            this.randomAccessFile = bC(this.filePath, this.ffK);
        }
        if (ghP.bb(this.filePath)) {
            return ((Integer) ghP.get(this.filePath)).intValue();
        }
        if (this.randomAccessFile == null) {
            x.e("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] inputStream is null");
            return 0;
        } else if (this.filePath.toLowerCase().endsWith(".mp3")) {
            x.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] mp3");
            return 2;
        } else if (this.filePath.toLowerCase().contains(".wav")) {
            x.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] wav");
            return 3;
        } else if (this.filePath.toLowerCase().contains(".ogg")) {
            x.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] ogg");
            return 4;
        } else {
            try {
                byte[] bArr = new byte[64];
                this.randomAccessFile.seek((long) this.fhe);
                this.randomAccessFile.read(bArr);
                str = new String(bArr);
            } catch (Exception e) {
                x.e("MicroMsg.WxaAudioDataSourceBelow19", "getAudioType", e);
                str = null;
                return str != null ? 0 : 0;
            } finally {
                i = this.randomAccessFile;
                str = (long) this.fhe;
                i.seek(str);
                str = null;
                if (str != null) {
                }
            }
            if (str != null && str.contains("ftyp")) {
                x.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] aac");
                ghP.put(this.filePath, Integer.valueOf(i));
                return i;
            }
        }
    }

    public final void close() {
        if (this.randomAccessFile != null) {
            x.i("MicroMsg.WxaAudioDataSourceBelow19", "close %d", Integer.valueOf(hashCode()));
            this.randomAccessFile.close();
            this.randomAccessFile = null;
        }
    }
}
