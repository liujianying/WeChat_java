package com.tencent.mm.ak;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.mm.a.e;
import com.tencent.mm.a.f;
import com.tencent.mm.a.o;
import com.tencent.mm.bp.a;
import com.tencent.mm.bt.h;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.p.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.MMJpegOptim;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.bd;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class g extends j {
    public static long dUD = 0;
    public static int dUq = 0;
    public static final String[] diD = new String[]{"CREATE TABLE IF NOT EXISTS ImgInfo ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT )", "CREATE TABLE IF NOT EXISTS ImgInfo2 ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT, createtime INT, msglocalid INT, status INT, nettimes INT, reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text, hashdthumb int DEFAULT 0, iscomplete INT DEFAULT 1, origImgMD5 TEXT, compressType INT DEFAULT 0, midImgPath TEXT, forwardType INT DEFAULT 0)", "CREATE INDEX IF NOT EXISTS  serverImgInfoIndex ON ImgInfo2 ( msgSvrId ) ", "CREATE INDEX IF NOT EXISTS  serverImgInfoHdIndex ON ImgInfo2 ( reserved1 ) ", "CREATE INDEX IF NOT EXISTS  msgLocalIdIndex ON ImgInfo2 ( msglocalid ) ", "insert into imginfo2 (id,msgSvrId , offset , totalLen , bigImgPath , thumbImgPath) select id, msgSvrId, offset ,totallen , bigimgpath , thumbimgpath from imginfo; ", "delete from ImgInfo ; ", "CREATE INDEX IF NOT EXISTS iscomplete_index ON ImgInfo2 ( iscomplete ) ", "CREATE INDEX IF NOT EXISTS origImgMD5_index ON ImgInfo2 ( origImgMD5 ) "};
    public h dCZ = null;
    private LayoutParams dUA = new LayoutParams(-2, -2);
    private SoftReference<ColorDrawable> dUB;
    public int dUC = 150;
    public f<String, Bitmap> dUr = new f(40, new 1(this));
    f<String, String> dUs = new f(40, new 2(this));
    private List<b> dUt = new ArrayList();
    private Map<Integer, WeakReference<ImageView>> dUu = new HashMap();
    private Map<Integer, WeakReference<ImageView>> dUv = new HashMap();
    private Map<Integer, WeakReference<View>> dUw = new HashMap();
    private Set<Integer> dUx = new HashSet();
    private Map<String, String> dUy = new HashMap();
    public long dUz = 1;
    private ag dvh = new ag(Looper.getMainLooper());

    public g(h hVar) {
        a(hVar);
        this.dCZ = hVar;
        OP();
    }

    public final void OP() {
        Cursor b = this.dCZ.b("SELECT max(id) FROM ImgInfo2", null, 2);
        if (b.moveToFirst()) {
            this.dUz = b.getLong(0) + 1;
        }
        b.close();
        x.i("MicroMsg.ImgInfoStorage", "loading new img id: " + this.dUz);
    }

    private static void a(h hVar) {
        Cursor b = hVar.b("PRAGMA table_info(ImgInfo2)", null, 2);
        int columnIndex = b.getColumnIndex("name");
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        Object obj6 = null;
        while (b.moveToNext()) {
            if (columnIndex >= 0) {
                Object obj7;
                String string = b.getString(columnIndex);
                if ("hashdthumb".equals(string)) {
                    obj6 = 1;
                }
                if ("iscomplete".equals(string)) {
                    obj5 = 1;
                }
                if ("origImgMD5".equals(string)) {
                    obj4 = 1;
                }
                if ("compressType".equals(string)) {
                    obj3 = 1;
                }
                if ("midImgPath".equals(string)) {
                    obj7 = 1;
                } else {
                    obj7 = obj2;
                }
                if ("forwardType".equals(string)) {
                    obj = 1;
                }
                obj2 = obj7;
            }
        }
        b.close();
        long dO = com.tencent.mm.kernel.g.Ei().dqq.dO(Thread.currentThread().getId());
        if (obj6 == null) {
            hVar.fV("ImgInfo2", "Alter table ImgInfo2 add hashdthumb INT DEFAULT 0");
        }
        if (obj5 == null) {
            hVar.fV("ImgInfo2", "Alter table ImgInfo2 add iscomplete INT DEFAULT 1");
        }
        if (obj4 == null) {
            hVar.fV("ImgInfo2", "Alter table ImgInfo2 add origImgMD5 TEXT");
        }
        if (obj3 == null) {
            hVar.fV("ImgInfo2", "Alter table ImgInfo2 add compressType INT DEFAULT 0");
        }
        if (obj2 == null) {
            hVar.fV("ImgInfo2", "Alter table ImgInfo2 add midImgPath TEXT");
        }
        if (obj == null) {
            hVar.fV("ImgInfo2", "Alter table ImgInfo2 add forwardType INT DEFAULT 0");
        }
        if (dO > 0) {
            com.tencent.mm.kernel.g.Ei().dqq.gp(dO);
        }
    }

    public final String b(String str, String str2, String str3, boolean z) {
        if (bi.oW(str)) {
            return null;
        }
        String str4;
        String str5;
        String str6 = "";
        if (str.startsWith("SERVERID://")) {
            try {
                str4 = bq(Long.valueOf(str.substring(11)).longValue()).dTL;
            } catch (NumberFormatException e) {
                x.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e.getMessage());
                return null;
            }
        }
        str4 = str6;
        if (str.startsWith("THUMBNAIL_DIRPATH://")) {
            str = str.substring(23);
            str5 = "th_";
        } else {
            str5 = str2;
        }
        str6 = c.Gb();
        String Gc = c.Gc();
        if (bi.oW(str4)) {
            str4 = str;
        }
        return com.tencent.mm.sdk.platformtools.h.b(str6, Gc, str5, str4, str3, z);
    }

    public final String o(String str, String str2, String str3) {
        return b(str, str2, str3, true);
    }

    public final String getFullPath(String str) {
        if (bi.oW(str)) {
            return null;
        }
        String str2 = "";
        if (str.startsWith("SERVERID://")) {
            try {
                str2 = bq(Long.valueOf(str.substring(11)).longValue()).dTL;
            } catch (NumberFormatException e) {
                x.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e.getMessage());
                return null;
            }
        }
        String Gb = c.Gb();
        String Gc = c.Gc();
        String str3 = "th_";
        if (!bi.oW(str2)) {
            str = str2;
        }
        return com.tencent.mm.sdk.platformtools.h.f(Gb, Gc, str3, str, "");
    }

    public static String lM(String str) {
        return "THUMBNAIL_DIRPATH://th_" + str;
    }

    public final String lN(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String str2 = "";
        String trim = str.trim();
        if (trim.startsWith("THUMBNAIL://")) {
            try {
                trim = hQ(Integer.valueOf(trim.substring(12)).intValue()).dTN;
            } catch (NumberFormatException e) {
                x.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e.getMessage());
                return null;
            }
        } else if (trim.startsWith("THUMBNAIL_DIRPATH://")) {
            trim = trim.substring(23);
            str2 = "th_";
        }
        return o(trim, str2, "");
    }

    public final String a(byte[] bArr, boolean z, CompressFormat compressFormat) {
        return a(8, bArr, z, compressFormat);
    }

    public final String a(byte[] bArr, CompressFormat compressFormat) {
        if (bi.bC(bArr)) {
            x.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
            return null;
        }
        String u = com.tencent.mm.a.g.u((bi.VF()).getBytes());
        x.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = %s", new Object[]{o(u, "th_", "")});
        try {
            com.tencent.mm.sdk.platformtools.c.a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length), 100, compressFormat, o(u, "th_", ""), true);
            return "THUMBNAIL_DIRPATH://th_" + u;
        } catch (IOException e) {
            x.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", new Object[]{e});
            return a(9, bArr, true, compressFormat);
        } catch (Exception e2) {
            x.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", new Object[]{e2});
            return a(9, bArr, true, compressFormat);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(byte[] r11, android.graphics.Bitmap.CompressFormat r12, int r13, int r14) {
        /*
        r10 = this;
        r6 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.bC(r11);
        if (r0 == 0) goto L_0x0012;
    L_0x0007:
        r0 = "MicroMsg.ImgInfoStorage";
        r1 = "save dir thumb error, thumbBuf is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = r6;
    L_0x0011:
        return r0;
    L_0x0012:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = com.tencent.mm.sdk.platformtools.bi.VF();
        r0 = r0.append(r2);
        r0 = r0.toString();
        r0 = r0.getBytes();
        r8 = com.tencent.mm.a.g.u(r0);
        r0 = "th_";
        r1 = "";
        r9 = r10.o(r8, r0, r1);
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0 = r0.append(r9);
        r1 = ".tmp";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r1 = "MicroMsg.ImgInfoStorage";
        r2 = new java.lang.StringBuilder;
        r3 = "saveDirThumb, fullPath = ";
        r2.<init>(r3);
        r2 = r2.append(r9);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.x.d(r1, r2);
        r7 = com.tencent.mm.modelsfs.FileOp.jx(r0);	 Catch:{ IOException -> 0x01bd, Exception -> 0x01ba, all -> 0x018c }
        r7.write(r11);	 Catch:{ IOException -> 0x0103, Exception -> 0x015c }
        r7.flush();	 Catch:{ IOException -> 0x0103, Exception -> 0x015c }
        r4 = new com.tencent.mm.sdk.platformtools.MMBitmapFactory$DecodeResultLogger;	 Catch:{ IOException -> 0x0103, Exception -> 0x015c }
        r4.<init>();	 Catch:{ IOException -> 0x0103, Exception -> 0x015c }
        r3 = 0;
        r5 = 0;
        r1 = r14;
        r2 = r13;
        r3 = com.tencent.mm.sdk.platformtools.c.a(r0, r1, r2, r3, r4, r5);	 Catch:{ IOException -> 0x0103, Exception -> 0x015c }
        if (r3 == 0) goto L_0x0134;
    L_0x0078:
        r2 = 100;
        r1 = r11.length;	 Catch:{ IOException -> 0x0103, Exception -> 0x015c }
        r4 = 262144; // 0x40000 float:3.67342E-40 double:1.295163E-318;
        if (r1 <= r4) goto L_0x00af;
    L_0x007f:
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x01c4 }
        r1.<init>();	 Catch:{ Exception -> 0x01c4 }
        r4 = 100;
        r3.compress(r12, r4, r1);	 Catch:{ Exception -> 0x009f, all -> 0x01c0 }
    L_0x0089:
        r4 = r1.toByteArray();	 Catch:{ Exception -> 0x009f, all -> 0x01c0 }
        r4 = r4.length;	 Catch:{ Exception -> 0x009f, all -> 0x01c0 }
        r5 = 262144; // 0x40000 float:3.67342E-40 double:1.295163E-318;
        if (r4 <= r5) goto L_0x00f5;
    L_0x0092:
        r4 = 15;
        if (r2 < r4) goto L_0x00f5;
    L_0x0096:
        r1.reset();	 Catch:{ Exception -> 0x009f, all -> 0x01c0 }
        r2 = r2 + -5;
        r3.compress(r12, r2, r1);	 Catch:{ Exception -> 0x009f, all -> 0x01c0 }
        goto L_0x0089;
    L_0x009f:
        r4 = move-exception;
        r6 = r1;
    L_0x00a1:
        r1 = "MicroMsg.ImgInfoStorage";
        r4 = "compress bitmap failed.";
        com.tencent.mm.sdk.platformtools.x.e(r1, r4);	 Catch:{ all -> 0x00fb }
        if (r6 == 0) goto L_0x00af;
    L_0x00ac:
        r6.close();	 Catch:{ Exception -> 0x01a6, IOException -> 0x0103 }
    L_0x00af:
        r1 = 1;
        com.tencent.mm.sdk.platformtools.c.a(r3, r2, r12, r9, r1);	 Catch:{ IOException -> 0x0103, Exception -> 0x015c }
        r1 = "MicroMsg.ImgInfoStorage";
        r3 = "in ImgInfoStorage, extractThumbNail done: %s, %s, quality : %d";
        r4 = 3;
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x0103, Exception -> 0x015c }
        r5 = 0;
        r4[r5] = r0;	 Catch:{ IOException -> 0x0103, Exception -> 0x015c }
        r5 = 1;
        r4[r5] = r9;	 Catch:{ IOException -> 0x0103, Exception -> 0x015c }
        r5 = 2;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IOException -> 0x0103, Exception -> 0x015c }
        r4[r5] = r2;	 Catch:{ IOException -> 0x0103, Exception -> 0x015c }
        com.tencent.mm.sdk.platformtools.x.d(r1, r3, r4);	 Catch:{ IOException -> 0x0103, Exception -> 0x015c }
    L_0x00cc:
        r1 = com.tencent.mm.modelsfs.FileOp.cn(r0);
        if (r1 == 0) goto L_0x00de;
    L_0x00d2:
        r1 = "MicroMsg.ImgInfoStorage";
        r2 = "create thumbnail, delete tmp file";
        com.tencent.mm.sdk.platformtools.x.d(r1, r2);
        com.tencent.mm.modelsfs.FileOp.deleteFile(r0);
    L_0x00de:
        if (r7 == 0) goto L_0x00e3;
    L_0x00e0:
        r7.close();	 Catch:{ Exception -> 0x01ac }
    L_0x00e3:
        r0 = new java.lang.StringBuilder;
        r1 = "THUMBNAIL_DIRPATH://th_";
        r0.<init>(r1);
        r0 = r0.append(r8);
        r0 = r0.toString();
        goto L_0x0011;
    L_0x00f5:
        r1.close();	 Catch:{ Exception -> 0x00f9, IOException -> 0x0103 }
        goto L_0x00af;
    L_0x00f9:
        r1 = move-exception;
        goto L_0x00af;
    L_0x00fb:
        r1 = move-exception;
        r2 = r1;
    L_0x00fd:
        if (r6 == 0) goto L_0x0102;
    L_0x00ff:
        r6.close();	 Catch:{ Exception -> 0x01a9, IOException -> 0x0103 }
    L_0x0102:
        throw r2;	 Catch:{ IOException -> 0x0103, Exception -> 0x015c }
    L_0x0103:
        r1 = move-exception;
        r6 = r7;
    L_0x0105:
        r2 = "MicroMsg.ImgInfoStorage";
        r3 = "save bitmap to image error, %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x01b7 }
        r5 = 0;
        r4[r5] = r1;	 Catch:{ all -> 0x01b7 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ all -> 0x01b7 }
        r1 = 6;
        r2 = 1;
        r1 = r10.a(r1, r11, r2, r12);	 Catch:{ all -> 0x01b7 }
        r2 = com.tencent.mm.modelsfs.FileOp.cn(r0);
        if (r2 == 0) goto L_0x012c;
    L_0x0120:
        r2 = "MicroMsg.ImgInfoStorage";
        r3 = "create thumbnail, delete tmp file";
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);
        com.tencent.mm.modelsfs.FileOp.deleteFile(r0);
    L_0x012c:
        if (r6 == 0) goto L_0x0131;
    L_0x012e:
        r6.close();	 Catch:{ Exception -> 0x01af }
    L_0x0131:
        r0 = r1;
        goto L_0x0011;
    L_0x0134:
        r1 = r4.getDecodeResult();	 Catch:{ IOException -> 0x0103, Exception -> 0x015c }
        r2 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        if (r1 < r2) goto L_0x00cc;
    L_0x013c:
        r1 = "MicroMsg.ImgInfoStorage";
        r2 = "hit image hole while extractThumbNail: %s, %s";
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{ IOException -> 0x0103, Exception -> 0x015c }
        r5 = 0;
        r3[r5] = r0;	 Catch:{ IOException -> 0x0103, Exception -> 0x015c }
        r5 = 1;
        r3[r5] = r9;	 Catch:{ IOException -> 0x0103, Exception -> 0x015c }
        com.tencent.mm.sdk.platformtools.x.w(r1, r2, r3);	 Catch:{ IOException -> 0x0103, Exception -> 0x015c }
        r1 = 6;
        r1 = com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper.getKVStatString(r0, r1, r4);	 Catch:{ IOException -> 0x0103, Exception -> 0x015c }
        r2 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ IOException -> 0x0103, Exception -> 0x015c }
        r3 = 12712; // 0x31a8 float:1.7813E-41 double:6.2806E-320;
        r2.k(r3, r1);	 Catch:{ IOException -> 0x0103, Exception -> 0x015c }
        goto L_0x00cc;
    L_0x015c:
        r1 = move-exception;
    L_0x015d:
        r2 = "MicroMsg.ImgInfoStorage";
        r3 = "save bitmap to image error, %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x01b5 }
        r5 = 0;
        r4[r5] = r1;	 Catch:{ all -> 0x01b5 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ all -> 0x01b5 }
        r1 = 6;
        r2 = 1;
        r1 = r10.a(r1, r11, r2, r12);	 Catch:{ all -> 0x01b5 }
        r2 = com.tencent.mm.modelsfs.FileOp.cn(r0);
        if (r2 == 0) goto L_0x0184;
    L_0x0178:
        r2 = "MicroMsg.ImgInfoStorage";
        r3 = "create thumbnail, delete tmp file";
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);
        com.tencent.mm.modelsfs.FileOp.deleteFile(r0);
    L_0x0184:
        if (r7 == 0) goto L_0x0189;
    L_0x0186:
        r7.close();	 Catch:{ Exception -> 0x01b1 }
    L_0x0189:
        r0 = r1;
        goto L_0x0011;
    L_0x018c:
        r1 = move-exception;
        r7 = r6;
    L_0x018e:
        r2 = com.tencent.mm.modelsfs.FileOp.cn(r0);
        if (r2 == 0) goto L_0x01a0;
    L_0x0194:
        r2 = "MicroMsg.ImgInfoStorage";
        r3 = "create thumbnail, delete tmp file";
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);
        com.tencent.mm.modelsfs.FileOp.deleteFile(r0);
    L_0x01a0:
        if (r7 == 0) goto L_0x01a5;
    L_0x01a2:
        r7.close();	 Catch:{ Exception -> 0x01b3 }
    L_0x01a5:
        throw r1;
    L_0x01a6:
        r1 = move-exception;
        goto L_0x00af;
    L_0x01a9:
        r1 = move-exception;
        goto L_0x0102;
    L_0x01ac:
        r0 = move-exception;
        goto L_0x00e3;
    L_0x01af:
        r0 = move-exception;
        goto L_0x0131;
    L_0x01b1:
        r0 = move-exception;
        goto L_0x0189;
    L_0x01b3:
        r0 = move-exception;
        goto L_0x01a5;
    L_0x01b5:
        r1 = move-exception;
        goto L_0x018e;
    L_0x01b7:
        r1 = move-exception;
        r7 = r6;
        goto L_0x018e;
    L_0x01ba:
        r1 = move-exception;
        r7 = r6;
        goto L_0x015d;
    L_0x01bd:
        r1 = move-exception;
        goto L_0x0105;
    L_0x01c0:
        r2 = move-exception;
        r6 = r1;
        goto L_0x00fd;
    L_0x01c4:
        r1 = move-exception;
        goto L_0x00a1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ak.g.a(byte[], android.graphics.Bitmap$CompressFormat, int, int):java.lang.String");
    }

    public final String a(int i, byte[] bArr, boolean z, CompressFormat compressFormat) {
        return a(i, bArr, z, compressFormat, false);
    }

    public final String a(int i, byte[] bArr, boolean z, CompressFormat compressFormat, boolean z2) {
        Exception exception;
        OutputStream outputStream;
        Throwable th;
        if (bi.bC(bArr)) {
            x.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
            return null;
        }
        String u = com.tencent.mm.a.g.u((bi.VF()).getBytes());
        String o = o(u, "th_", "");
        String str = o + ".tmp";
        x.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = " + o);
        OutputStream jx;
        try {
            jx = FileOp.jx(str);
            try {
                Bitmap decodeFile;
                jx.write(bArr);
                jx.flush();
                int i2 = z ? MapRouteSectionWithName.kMaxRoadNameLength : 120;
                int i3 = z ? MapRouteSectionWithName.kMaxRoadNameLength : 120;
                DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                if (z2) {
                    decodeFile = com.tencent.mm.sdk.platformtools.c.decodeFile(str, null);
                } else {
                    decodeFile = com.tencent.mm.sdk.platformtools.c.a(str, i2, i3, false, decodeResultLogger, 0);
                }
                if (decodeFile != null) {
                    com.tencent.mm.sdk.platformtools.c.a(decodeFile, 90, compressFormat, o, true);
                    x.d("MicroMsg.ImgInfoStorage", "in ImgInfoStorage, extractThumbNail done: %s, %s", new Object[]{str, o});
                } else if (decodeResultLogger.getDecodeResult() >= 2000) {
                    x.w("MicroMsg.ImgInfoStorage", "hit image hole while extractThumbNail: %s, %s", new Object[]{str, o});
                    com.tencent.mm.plugin.report.service.h.mEJ.k(12712, KVStatHelper.getKVStatString(str, i, decodeResultLogger));
                }
                if (FileOp.cn(str)) {
                    x.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                    FileOp.deleteFile(str);
                }
                if (jx != null) {
                    try {
                        jx.close();
                    } catch (Exception e) {
                    }
                }
                return "THUMBNAIL_DIRPATH://th_" + u;
            } catch (Exception e2) {
                exception = e2;
                outputStream = jx;
                try {
                    com.tencent.mm.plugin.report.service.h.mEJ.a(111, 189, 1, false);
                    x.e("MicroMsg.ImgInfoStorage", "create thumbnail from byte failed: th_" + u + ", ex = " + exception.getMessage());
                    if (FileOp.cn(str)) {
                        x.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                        FileOp.deleteFile(str);
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e3) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    jx = outputStream;
                    if (FileOp.cn(str)) {
                        x.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                        FileOp.deleteFile(str);
                    }
                    if (jx != null) {
                        try {
                            jx.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (FileOp.cn(str)) {
                    x.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                    FileOp.deleteFile(str);
                }
                if (jx != null) {
                    try {
                        jx.close();
                    } catch (Exception e42) {
                    }
                }
                throw th;
            }
        } catch (Exception e22) {
            exception = e22;
            outputStream = null;
        } catch (Throwable th4) {
            th = th4;
            jx = null;
            if (FileOp.cn(str)) {
                x.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                FileOp.deleteFile(str);
            }
            if (jx != null) {
                try {
                    jx.close();
                } catch (Exception e422) {
                }
            }
            throw th;
        }
    }

    public final String g(int i, byte[] bArr) {
        if (bi.bC(bArr)) {
            x.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
            return null;
        }
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        if (MMBitmapFactory.checkIsImageLegal(bArr, decodeResultLogger)) {
            String u = com.tencent.mm.a.g.u((bi.VF()).getBytes());
            String o = o(u, "th_", "");
            x.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = " + o);
            FileOp.deleteFile(o);
            FileOp.l(o, bArr);
            return "THUMBNAIL_DIRPATH://th_" + u;
        } else if (decodeResultLogger.getDecodeResult() < 2000) {
            return null;
        } else {
            x.e("MicroMsg.ImgInfoStorage", "img in thumbBuf hits hole.");
            com.tencent.mm.plugin.report.service.h.mEJ.k(12712, KVStatHelper.getKVStatString(bArr, i, decodeResultLogger));
            return null;
        }
    }

    public final String E(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("THUMBNAIL://")) {
            try {
                trim = hQ(Integer.valueOf(trim.substring(12)).intValue()).dTN;
            } catch (NumberFormatException e) {
                x.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e.getMessage());
                return null;
            }
        } else if (trim.startsWith("THUMBNAIL_DIRPATH://")) {
            return b(trim.substring(20).substring(3), "th_", "", z);
        }
        return b(trim, "", "", z);
    }

    public final Bitmap a(String str, float f, boolean z) {
        return a(str, false, f, z, false, false, -1);
    }

    public final boolean a(ImageView imageView, String str, float f, int i, int i2, int i3, ImageView imageView2, int i4, int i5, View view) {
        return a(imageView, str, false, f, i, i2, i3, imageView2, i4, i5, view);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.widget.ImageView r13, java.lang.String r14, boolean r15, float r16, int r17, int r18, int r19, android.widget.ImageView r20, int r21, int r22, android.view.View r23) {
        /*
        r12 = this;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r14);
        if (r2 == 0) goto L_0x0017;
    L_0x0006:
        r2 = "MicroMsg.ImgInfoStorage";
        r3 = "invalid uri is %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r14;
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);
        r2 = 0;
    L_0x0016:
        return r2;
    L_0x0017:
        r3 = r12.dUy;
        monitor-enter(r3);
        r2 = r12.dUy;	 Catch:{ all -> 0x0041 }
        r2 = r2.containsKey(r14);	 Catch:{ all -> 0x0041 }
        r4 = 0;
        r6 = r12.d(r14, r15, r4);	 Catch:{ all -> 0x0041 }
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r6);	 Catch:{ all -> 0x0041 }
        if (r4 == 0) goto L_0x0044;
    L_0x002b:
        r2 = "MicroMsg.ImgInfoStorage";
        r4 = "getFullThumbPathByCache uri is null, uri:%s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0041 }
        r6 = 0;
        r7 = com.tencent.mm.sdk.platformtools.bi.oV(r14);	 Catch:{ all -> 0x0041 }
        r5[r6] = r7;	 Catch:{ all -> 0x0041 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r4, r5);	 Catch:{ all -> 0x0041 }
        r2 = 0;
        monitor-exit(r3);	 Catch:{ all -> 0x0041 }
        goto L_0x0016;
    L_0x0041:
        r2 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0041 }
        throw r2;
    L_0x0044:
        if (r2 != 0) goto L_0x0096;
    L_0x0046:
        r2 = "hd";
        r2 = r6.endsWith(r2);	 Catch:{ all -> 0x0041 }
        if (r2 != 0) goto L_0x0096;
    L_0x004f:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0041 }
        r2.<init>();	 Catch:{ all -> 0x0041 }
        r2 = r2.append(r6);	 Catch:{ all -> 0x0041 }
        r4 = "hd";
        r2 = r2.append(r4);	 Catch:{ all -> 0x0041 }
        r2 = r2.toString();	 Catch:{ all -> 0x0041 }
        r2 = com.tencent.mm.modelsfs.FileOp.cn(r2);	 Catch:{ all -> 0x0041 }
        if (r2 == 0) goto L_0x0096;
    L_0x0069:
        r2 = r12.dUy;	 Catch:{ all -> 0x0041 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0041 }
        r4.<init>();	 Catch:{ all -> 0x0041 }
        r4 = r4.append(r6);	 Catch:{ all -> 0x0041 }
        r5 = "hd";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0041 }
        r4 = r4.toString();	 Catch:{ all -> 0x0041 }
        r2.put(r14, r4);	 Catch:{ all -> 0x0041 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0041 }
        r2.<init>();	 Catch:{ all -> 0x0041 }
        r2 = r2.append(r6);	 Catch:{ all -> 0x0041 }
        r4 = "hd";
        r2 = r2.append(r4);	 Catch:{ all -> 0x0041 }
        r6 = r2.toString();	 Catch:{ all -> 0x0041 }
    L_0x0096:
        monitor-exit(r3);	 Catch:{ all -> 0x0041 }
        r9 = 0;
        r3 = 0;
        r2 = "hd";
        r2 = r6.endsWith(r2);
        if (r2 == 0) goto L_0x02fa;
    L_0x00a2:
        r2 = r12.dUr;
        r2 = r2.get(r6);
        r9 = r2;
        r9 = (android.graphics.Bitmap) r9;
        if (r9 != 0) goto L_0x0179;
    L_0x00ad:
        r2 = r12;
        r3 = r13;
        r4 = r20;
        r5 = r23;
        r7 = r16;
        r8 = r19;
        r2.a(r3, r4, r5, r6, r7, r8);
        r3 = 1;
        r2 = 0;
        r4 = r6.length();
        r4 = r4 + -2;
        r6 = r6.substring(r2, r4);
        r5 = r3;
        r2 = r9;
    L_0x00c8:
        if (r2 != 0) goto L_0x02f7;
    L_0x00ca:
        r2 = r12.dUr;
        r2 = r2.get(r6);
        r2 = (android.graphics.Bitmap) r2;
        r4 = r2;
    L_0x00d3:
        if (r4 == 0) goto L_0x01d0;
    L_0x00d5:
        r2 = r4.isRecycled();
        if (r2 != 0) goto L_0x01d0;
    L_0x00db:
        r2 = "MicroMsg.ImgInfoStorage";
        r3 = "[setbitmapFromUri] bitmap width %d,height %d";
        r5 = 2;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = r4.getWidth();
        r7 = java.lang.Integer.valueOf(r7);
        r5[r6] = r7;
        r6 = 1;
        r7 = r4.getHeight();
        r7 = java.lang.Integer.valueOf(r7);
        r5[r6] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r5);
        r2 = 0;
        r13.setBackgroundDrawable(r2);
        com.tencent.mm.ak.g.a.a(r4, r13);
        r2 = r13.getLayoutParams();
        r2 = r2.width;
        r3 = -2;
        if (r2 == r3) goto L_0x01a6;
    L_0x010d:
        r2 = r12.dUA;
    L_0x010f:
        if (r22 != 0) goto L_0x01ae;
    L_0x0111:
        r3 = 5;
        r2.gravity = r3;
    L_0x0114:
        r13.setLayoutParams(r2);
        r2 = r4.getWidth();
        r2 = (double) r2;
        r5 = r4.getHeight();
        r6 = (double) r5;
        r8 = 4612811918334230528; // 0x4004000000000000 float:0.0 double:2.5;
        r6 = r6 * r8;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 < 0) goto L_0x01b8;
    L_0x0128:
        r2 = 1;
    L_0x0129:
        r3 = r4.getHeight();
        r6 = (double) r3;
        r3 = r4.getWidth();
        r8 = (double) r3;
        r10 = 4612811918334230528; // 0x4004000000000000 float:0.0 double:2.5;
        r8 = r8 * r10;
        r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r3 < 0) goto L_0x01bb;
    L_0x013a:
        r3 = 1;
    L_0x013b:
        if (r2 != 0) goto L_0x013f;
    L_0x013d:
        if (r3 == 0) goto L_0x0144;
    L_0x013f:
        r2 = android.widget.ImageView.ScaleType.CENTER;
        r13.setScaleType(r2);
    L_0x0144:
        if (r20 == 0) goto L_0x015d;
    L_0x0146:
        r2 = new android.widget.FrameLayout$LayoutParams;
        r3 = r4.getWidth();
        r5 = r4.getHeight();
        r2.<init>(r3, r5);
        if (r22 != 0) goto L_0x01be;
    L_0x0155:
        r3 = 5;
        r2.gravity = r3;
    L_0x0158:
        r0 = r20;
        r0.setLayoutParams(r2);
    L_0x015d:
        if (r23 == 0) goto L_0x0176;
    L_0x015f:
        r2 = new android.widget.FrameLayout$LayoutParams;
        r3 = r4.getWidth();
        r4 = r4.getHeight();
        r2.<init>(r3, r4);
        if (r22 != 0) goto L_0x01c7;
    L_0x016e:
        r3 = 5;
        r2.gravity = r3;
    L_0x0171:
        r0 = r23;
        r0.setLayoutParams(r2);
    L_0x0176:
        r2 = 1;
        goto L_0x0016;
    L_0x0179:
        r2 = r12.dUr;
        r4 = 0;
        r5 = r6.length();
        r5 = r5 + -2;
        r4 = r6.substring(r4, r5);
        r2 = r2.remove(r4);
        if (r2 == 0) goto L_0x01a2;
    L_0x018c:
        r2 = "MicroMsg.ImgInfoStorage";
        r4 = new java.lang.StringBuilder;
        r5 = "remove low quality thumb from cacheMap, path: ";
        r4.<init>(r5);
        r4 = r4.append(r6);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.x.d(r2, r4);
    L_0x01a2:
        r5 = r3;
        r2 = r9;
        goto L_0x00c8;
    L_0x01a6:
        r2 = r13.getLayoutParams();
        r2 = (android.widget.FrameLayout.LayoutParams) r2;
        goto L_0x010f;
    L_0x01ae:
        r3 = 1;
        r0 = r22;
        if (r0 != r3) goto L_0x0114;
    L_0x01b3:
        r3 = 3;
        r2.gravity = r3;
        goto L_0x0114;
    L_0x01b8:
        r2 = 0;
        goto L_0x0129;
    L_0x01bb:
        r3 = 0;
        goto L_0x013b;
    L_0x01be:
        r3 = 1;
        r0 = r22;
        if (r0 != r3) goto L_0x0158;
    L_0x01c3:
        r3 = 3;
        r2.gravity = r3;
        goto L_0x0158;
    L_0x01c7:
        r3 = 1;
        r0 = r22;
        if (r0 != r3) goto L_0x0171;
    L_0x01cc:
        r3 = 3;
        r2.gravity = r3;
        goto L_0x0171;
    L_0x01d0:
        if (r21 <= 0) goto L_0x02a8;
    L_0x01d2:
        r0 = r21;
        r13.setBackgroundResource(r0);
        r2 = 0;
        r13.setImageDrawable(r2);
        r2 = 160; // 0xa0 float:2.24E-43 double:7.9E-322;
        r0 = r17;
        if (r0 >= r2) goto L_0x01e7;
    L_0x01e1:
        r2 = 160; // 0xa0 float:2.24E-43 double:7.9E-322;
        r0 = r18;
        if (r0 < r2) goto L_0x0281;
    L_0x01e7:
        r0 = r18;
        r1 = r17;
        if (r0 <= r1) goto L_0x0273;
    L_0x01ed:
        r2 = 1126170624; // 0x43200000 float:160.0 double:5.564022167E-315;
        r0 = r18;
        r3 = (float) r0;
        r2 = r2 / r3;
    L_0x01f3:
        r0 = r17;
        r3 = (float) r0;
        r3 = r3 * r2;
        r3 = (int) r3;
        r0 = r18;
        r4 = (float) r0;
        r2 = r2 * r4;
        r2 = (int) r2;
        if (r3 <= 0) goto L_0x027b;
    L_0x01ff:
        r3 = (float) r3;
        r3 = r3 * r16;
        r3 = (int) r3;
        if (r2 <= 0) goto L_0x027e;
    L_0x0205:
        r2 = (float) r2;
        r2 = r2 * r16;
        r2 = (int) r2;
    L_0x0209:
        r4 = (float) r3;
        r7 = 1114636288; // 0x42700000 float:60.0 double:5.507034975E-315;
        r7 = r7 * r16;
        r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1));
        if (r4 >= 0) goto L_0x02f4;
    L_0x0212:
        r4 = "MicroMsg.ImgInfoStorage";
        r7 = "pic to small width is %d ";
        r8 = 1;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r8[r9] = r3;
        com.tencent.mm.sdk.platformtools.x.d(r4, r7, r8);
        r3 = 1114636288; // 0x42700000 float:60.0 double:5.507034975E-315;
        r3 = r3 * r16;
        r3 = (int) r3;
        r4 = r3;
    L_0x022b:
        r3 = (float) r2;
        r7 = 1114636288; // 0x42700000 float:60.0 double:5.507034975E-315;
        r7 = r7 * r16;
        r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
        if (r3 >= 0) goto L_0x024c;
    L_0x0234:
        r3 = "MicroMsg.ImgInfoStorage";
        r7 = "pic to small height is %d ";
        r8 = 1;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r2 = java.lang.Integer.valueOf(r2);
        r8[r9] = r2;
        com.tencent.mm.sdk.platformtools.x.d(r3, r7, r8);
        r2 = 1114636288; // 0x42700000 float:60.0 double:5.507034975E-315;
        r2 = r2 * r16;
        r2 = (int) r2;
    L_0x024c:
        r3 = new android.widget.FrameLayout$LayoutParams;
        r3.<init>(r4, r2);
        if (r22 != 0) goto L_0x029f;
    L_0x0253:
        r2 = 5;
        r3.gravity = r2;
    L_0x0256:
        if (r23 == 0) goto L_0x02f1;
    L_0x0258:
        r0 = r23;
        r0.setLayoutParams(r3);
        r2 = r3;
    L_0x025e:
        r13.setLayoutParams(r2);
        if (r5 != 0) goto L_0x0270;
    L_0x0263:
        r2 = r12;
        r3 = r13;
        r4 = r20;
        r5 = r23;
        r7 = r16;
        r8 = r19;
        r2.a(r3, r4, r5, r6, r7, r8);
    L_0x0270:
        r2 = 0;
        goto L_0x0016;
    L_0x0273:
        r2 = 1126170624; // 0x43200000 float:160.0 double:5.564022167E-315;
        r0 = r17;
        r3 = (float) r0;
        r2 = r2 / r3;
        goto L_0x01f3;
    L_0x027b:
        r3 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        goto L_0x01ff;
    L_0x027e:
        r2 = 75;
        goto L_0x0205;
    L_0x0281:
        if (r17 <= 0) goto L_0x0299;
    L_0x0283:
        r0 = r17;
        r2 = (float) r0;
        r2 = r2 * r16;
        r3 = 1067450368; // 0x3fa00000 float:1.25 double:5.273905555E-315;
        r2 = r2 * r3;
        r3 = (int) r2;
        if (r18 <= 0) goto L_0x029c;
    L_0x028e:
        r0 = r18;
        r2 = (float) r0;
        r2 = r2 * r16;
        r4 = 1067450368; // 0x3fa00000 float:1.25 double:5.273905555E-315;
        r2 = r2 * r4;
        r2 = (int) r2;
        goto L_0x0209;
    L_0x0299:
        r17 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        goto L_0x0283;
    L_0x029c:
        r18 = 75;
        goto L_0x028e;
    L_0x029f:
        r2 = 1;
        r0 = r22;
        if (r0 != r2) goto L_0x0256;
    L_0x02a4:
        r2 = 3;
        r3.gravity = r2;
        goto L_0x0256;
    L_0x02a8:
        r2 = r12.dUB;
        if (r2 == 0) goto L_0x02b4;
    L_0x02ac:
        r2 = r12.dUB;
        r2 = r2.get();
        if (r2 != 0) goto L_0x02c3;
    L_0x02b4:
        r2 = new android.graphics.drawable.ColorDrawable;
        r3 = -1118482; // 0xffffffffffeeeeee float:NaN double:NaN;
        r2.<init>(r3);
        r3 = new java.lang.ref.SoftReference;
        r3.<init>(r2);
        r12.dUB = r3;
    L_0x02c3:
        r2 = r12.dUB;
        r2 = r2.get();
        r2 = (android.graphics.drawable.ColorDrawable) r2;
        r13.setImageDrawable(r2);
        r2 = new android.widget.FrameLayout$LayoutParams;
        if (r17 <= 0) goto L_0x02eb;
    L_0x02d2:
        r0 = r17;
        r3 = (float) r0;
        r3 = r3 * r16;
        r4 = 1067450368; // 0x3fa00000 float:1.25 double:5.273905555E-315;
        r3 = r3 * r4;
        r3 = (int) r3;
        if (r18 <= 0) goto L_0x02ee;
    L_0x02dd:
        r0 = r18;
        r4 = (float) r0;
        r4 = r4 * r16;
        r7 = 1067450368; // 0x3fa00000 float:1.25 double:5.273905555E-315;
        r4 = r4 * r7;
        r4 = (int) r4;
        r2.<init>(r3, r4);
        goto L_0x025e;
    L_0x02eb:
        r17 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        goto L_0x02d2;
    L_0x02ee:
        r18 = 75;
        goto L_0x02dd;
    L_0x02f1:
        r2 = r3;
        goto L_0x025e;
    L_0x02f4:
        r4 = r3;
        goto L_0x022b;
    L_0x02f7:
        r4 = r2;
        goto L_0x00d3;
    L_0x02fa:
        r5 = r3;
        r2 = r9;
        goto L_0x00c8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ak.g.a(android.widget.ImageView, java.lang.String, boolean, float, int, int, int, android.widget.ImageView, int, int, android.view.View):boolean");
    }

    private void a(ImageView imageView, ImageView imageView2, View view, String str, float f, int i) {
        int hashCode;
        int i2;
        int hashCode2 = str.hashCode();
        int hashCode3 = imageView.hashCode();
        for (b bVar : this.dUt) {
            if (hashCode3 == bVar.dUJ) {
                x.i("MicroMsg.ImgInfoStorage", "setbitmapFromUri  [%d, %s] ", new Object[]{Integer.valueOf(bVar.dUJ), bVar.url});
                bVar.url = str;
                if (!this.dUx.contains(Integer.valueOf(hashCode2))) {
                    this.dUx.add(Integer.valueOf(hashCode2));
                    a(str, f, i);
                    return;
                }
                return;
            }
        }
        this.dUu.put(Integer.valueOf(hashCode3), new WeakReference(imageView));
        if (imageView2 != null) {
            hashCode = imageView2.hashCode();
            this.dUv.put(Integer.valueOf(hashCode), new WeakReference(imageView2));
            i2 = hashCode;
        } else {
            i2 = 0;
        }
        if (view != null) {
            hashCode = view.hashCode();
            this.dUw.put(Integer.valueOf(hashCode), new WeakReference(view));
        } else {
            hashCode = 0;
        }
        this.dUt.add(new b(hashCode3, str, i2, hashCode));
        if (!this.dUx.contains(Integer.valueOf(hashCode2))) {
            this.dUx.add(Integer.valueOf(hashCode2));
            a(str, f, i);
        }
    }

    private void a(String str, float f, int i) {
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Em().H(new 4(this, str, f, true, i));
    }

    public final Bitmap b(String str, float f, boolean z) {
        return a(str, true, f, z, true, false, 0);
    }

    public final Bitmap a(String str, boolean z, float f, boolean z2, boolean z3, boolean z4, int i) {
        return a(str, z, f, z2, z3, z4, i, true);
    }

    public final Bitmap a(String str, boolean z, float f, boolean z2, boolean z3, boolean z4, int i, boolean z5) {
        return a(str, z, f, z2, z3, z4, i, z5, null);
    }

    public final Bitmap a(String str, boolean z, float f, boolean z2, boolean z3, boolean z4, int i, boolean z5, Bitmap bitmap) {
        if (!z) {
            str = d(str, false, true);
        }
        if (str == null) {
            return null;
        }
        String str2;
        String str3;
        Object[] objArr;
        Bitmap bitmap2 = null;
        Object obj = bitmap != null ? 1 : null;
        if (z5) {
            bitmap2 = (Bitmap) this.dUr.get(str);
            if (bitmap2 == null) {
                str2 = "MicroMsg.ImgInfoStorage";
                str3 = "bm is null:%b,  url:%s";
                objArr = new Object[2];
                objArr[0] = Boolean.valueOf(bitmap2 == null);
                objArr[1] = str;
                x.k(str2, str3, objArr);
            }
        }
        if (bitmap2 != null && !bitmap2.isRecycled() && obj == null) {
            return bitmap2;
        }
        Bitmap bitmap3;
        bi.VF();
        if (obj != null) {
            bitmap3 = bitmap;
        } else {
            bitmap3 = com.tencent.mm.sdk.platformtools.c.b(str, f, 0);
        }
        if (bitmap3 == null) {
            bitmap3 = y.oQ(str);
        }
        if (bitmap3 == null) {
            return bitmap2;
        }
        Bitmap createScaledBitmap;
        long currentTimeMillis = System.currentTimeMillis();
        int width = bitmap3.getWidth();
        int height = bitmap3.getHeight();
        if (z3) {
            if (dUq == 0) {
                dUq = a.ae(ad.getContext(), com.tencent.mm.plugin.comm.a.c.emoji_view_image_size);
            }
            if (width > dUq || height > dUq) {
                if (width > height) {
                    height = (height * dUq) / width;
                    width = dUq;
                } else if (width == height) {
                    height = dUq;
                    width = dUq;
                } else {
                    width = (width * dUq) / height;
                    height = dUq;
                }
            }
        }
        if (z4) {
            int i2;
            if (str.endsWith("hd")) {
                i2 = height;
            } else {
                width = (int) ((((float) bitmap3.getWidth()) * f) * 1.25f);
                i2 = (int) ((((float) bitmap3.getHeight()) * f) * 1.25f);
            }
            if (((float) width) >= 160.0f * f || ((float) i2) >= 160.0f * f) {
                float f2;
                if (i2 > width) {
                    f2 = (160.0f * f) / ((float) i2);
                } else {
                    f2 = (160.0f * f) / ((float) width);
                }
                width = (int) (((float) width) * f2);
                height = (int) (f2 * ((float) i2));
            } else {
                height = i2;
            }
            if (((float) width) < 60.0f * f) {
                x.d("MicroMsg.ImgInfoStorage", "pic to small width is %d ", new Object[]{Integer.valueOf(width)});
                width = (int) (60.0f * f);
            }
            if (((float) height) < 60.0f * f) {
                x.d("MicroMsg.ImgInfoStorage", "pic to small height is %d ", new Object[]{Integer.valueOf(height)});
                height = (int) (60.0f * f);
            }
            Context context = ad.getContext();
            int[] iArr = new int[2];
            float f3;
            if (height >= width) {
                f3 = ((float) height) / ((float) width);
                if (f3 <= 2.0f) {
                    height = a.ae(context, com.tencent.mm.plugin.comm.a.c.ChatImgLimitWidth);
                    width = (int) (((float) height) / f3);
                } else {
                    width = a.ae(context, com.tencent.mm.plugin.comm.a.c.ChatImgMinWidth);
                    height = (int) (((float) width) * f3);
                }
            } else {
                f3 = ((float) width) / ((float) height);
                if (f3 <= 2.0f) {
                    width = a.ae(context, com.tencent.mm.plugin.comm.a.c.ChatImgLimitWidth);
                    height = (int) (((float) width) / f3);
                } else {
                    height = a.ae(context, com.tencent.mm.plugin.comm.a.c.ChatImgMinWidth);
                    width = (int) (((float) height) * f3);
                }
            }
            iArr[0] = width;
            iArr[1] = height;
            width = iArr[0];
            height = iArr[1];
        }
        try {
            createScaledBitmap = Bitmap.createScaledBitmap(bitmap3, width, height, true);
        } catch (OutOfMemoryError e) {
            createScaledBitmap = bitmap3;
        }
        if (bitmap3 != createScaledBitmap && obj == null) {
            x.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", new Object[]{bitmap3.toString()});
            bitmap3.recycle();
        }
        if (z4) {
            bitmap2 = com.tencent.mm.sdk.platformtools.c.d(createScaledBitmap, i);
        } else if (z2) {
            bitmap2 = com.tencent.mm.sdk.platformtools.c.a(createScaledBitmap, true, (float) a.fromDPToPix(ad.getContext(), 3));
            x.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", new Object[]{createScaledBitmap.toString()});
            createScaledBitmap.recycle();
        } else {
            bitmap2 = createScaledBitmap;
        }
        str2 = "MicroMsg.ImgInfoStorage";
        str3 = "cached file :%s bitmap time:%s bitmap:%s";
        objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = (System.currentTimeMillis() - currentTimeMillis);
        objArr[2] = bitmap2 == null ? "" : bitmap2.toString();
        x.i(str2, str3, objArr);
        if (bitmap2 == null || obj != null) {
            return bitmap2;
        }
        this.dUr.m(str, bitmap2);
        return bitmap2;
    }

    public final Bitmap a(String str, float f, Context context) {
        return a(str, f, context, -1);
    }

    public final Bitmap a(String str, float f, Context context, int i) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String trim = str.trim();
        Bitmap bitmap = (Bitmap) this.dUr.get(trim);
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap e = b.e(trim, f);
        if (e == null) {
            return e;
        }
        int b;
        int i2;
        int width = e.getWidth();
        int height = e.getHeight();
        if (width >= height) {
            b = b.b(context, (float) this.dUC);
            i2 = (int) ((((float) height) / ((float) width)) * ((float) b));
        } else {
            i2 = b.b(context, (float) this.dUC);
            b = (int) ((((float) width) / ((float) height)) * ((float) i2));
        }
        if (b <= 0 || i2 <= 0 || b > 2048 || i2 > 2048) {
            x.e("MicroMsg.ImgInfoStorage", "getVideoThumb, error Scale Size %d*%d", new Object[]{Integer.valueOf(b), Integer.valueOf(i2)});
            com.tencent.mm.plugin.report.service.h.mEJ.a(111, 188, 1, false);
            bitmap = null;
        } else {
            try {
                bitmap = Bitmap.createScaledBitmap(e, b, i2, true);
            } catch (Exception e2) {
                x.e("MicroMsg.ImgInfoStorage", "getVideoThumb, Bitmap.createScaledBitmap Exception:%s", new Object[]{e2.getMessage()});
                bitmap = null;
                com.tencent.mm.plugin.report.service.h.mEJ.a(111, 188, 1, false);
            }
        }
        if (i != -1) {
            bitmap = com.tencent.mm.sdk.platformtools.c.d(bitmap, i);
        }
        if (e != bitmap) {
            x.i("MicroMsg.ImgInfoStorage", "[getVideoThumb] bitmap:%s", new Object[]{e.toString()});
            e.recycle();
        }
        x.d("MicroMsg.ImgInfoStorage", "cached file " + trim);
        this.dUr.m(trim, bitmap);
        return bitmap;
    }

    public final e q(bd bdVar) {
        e br = br(bdVar.field_msgId);
        if (br.dTK != 0) {
            return br;
        }
        br = bq(bdVar.field_msgSvrId);
        if (br.dTK != 0) {
            return br;
        }
        x.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
        return null;
    }

    public final e b(Long l) {
        e eVar = new e();
        Cursor a = a("ImgInfo2", null, "id=?", new String[]{String.valueOf(l)});
        if (a != null && a.moveToFirst()) {
            eVar.d(a);
        }
        a.close();
        return eVar;
    }

    private e N(String str, int i) {
        e eVar = new e();
        Cursor a = a("ImgInfo2", null, "origImgMD5=? AND compressType=?", new String[]{str, String.valueOf(i)});
        if (a.moveToFirst()) {
            eVar.d(a);
        }
        a.close();
        return eVar;
    }

    public final void r(bd bdVar) {
        e q = q(bdVar);
        if (q == null || q.dTK == 0) {
            x.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
            return;
        }
        FileOp.deleteFile(o(q.dTL, "", ""));
        FileOp.deleteFile(o(q.dTN, "", ""));
        FileOp.deleteFile(o(q.dTN, "", "") + "hd");
        this.dCZ.delete("ImgInfo2", "id=?", new String[]{q.dTK});
        if (q.ON()) {
            q = hQ(q.dTU);
            if (q != null) {
                FileOp.deleteFile(o(q.dTL, "", ""));
                FileOp.deleteFile(o(q.dTN, "", ""));
                FileOp.deleteFile(o(q.dTN, "", "") + "hd");
                this.dCZ.delete("ImgInfo2", "id=?", new String[]{q.dTK});
            }
        }
    }

    public final String d(e eVar) {
        String str = null;
        if (eVar != null && eVar.ON()) {
            Cursor b = b("ImgInfo2", new String[]{"bigImgPath"}, "id=? and totalLen = offset", new String[]{eVar.dTU});
            if (b.moveToFirst()) {
                str = b.getString(0);
            }
            b.close();
        }
        return str;
    }

    public final HashMap<Long, e> a(Long... lArr) {
        String str = "(";
        int length = lArr.length;
        int i = 0;
        Object obj = 1;
        while (i < length) {
            long longValue = lArr[i].longValue();
            str = str + (obj != null ? Long.valueOf(longValue) : "," + longValue);
            i++;
            obj = null;
        }
        Cursor b = b("ImgInfo2", null, "msgSvrId in " + (str + ")"), null);
        HashMap<Long, e> hashMap = new HashMap();
        while (b.moveToNext()) {
            e eVar = new e();
            eVar.d(b);
            hashMap.put(Long.valueOf(eVar.bYu), eVar);
        }
        b.close();
        return hashMap;
    }

    public final HashMap<Long, e> b(Long... lArr) {
        String str = "(";
        int length = lArr.length;
        int i = 0;
        Object obj = 1;
        while (i < length) {
            long longValue = lArr[i].longValue();
            str = str + (obj != null ? Long.valueOf(longValue) : "," + longValue);
            i++;
            obj = null;
        }
        Cursor b = b("ImgInfo2", null, "msglocalid in " + (str + ")"), null);
        HashMap<Long, e> hashMap = new HashMap();
        while (b.moveToNext()) {
            e eVar = new e();
            eVar.d(b);
            hashMap.put(Long.valueOf(eVar.bYu), eVar);
        }
        b.close();
        return hashMap;
    }

    public final e hQ(int i) {
        return b(Long.valueOf((long) i));
    }

    public final e bq(long j) {
        e eVar = new e();
        Cursor b = b("ImgInfo2", null, "msgSvrId=?", new String[]{String.valueOf(j)});
        if (b.moveToFirst()) {
            eVar.d(b);
        }
        b.close();
        return eVar;
    }

    public final e br(long j) {
        e eVar = new e();
        Cursor b = b("ImgInfo2", null, "msglocalid=?", new String[]{String.valueOf(j)});
        if (b.moveToLast()) {
            eVar.d(b);
        }
        b.close();
        return eVar;
    }

    public final e hR(int i) {
        e eVar;
        Exception e;
        Throwable th;
        Cursor b;
        try {
            b = b("ImgInfo2", null, "reserved1=?", new String[]{String.valueOf(i)});
            if (b != null) {
                try {
                    if (b.moveToFirst()) {
                        eVar = new e();
                        try {
                            eVar.d(b);
                            if (b != null) {
                                b.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                x.w("MicroMsg.ImgInfoStorage", "Exception :%s", new Object[]{e.toString()});
                                if (b != null) {
                                    b.close();
                                }
                                return eVar;
                            } catch (Throwable th2) {
                                th = th2;
                                if (b != null) {
                                    b.close();
                                }
                                throw th;
                            }
                        }
                        return eVar;
                    }
                } catch (Exception e3) {
                    e = e3;
                    eVar = null;
                    x.w("MicroMsg.ImgInfoStorage", "Exception :%s", new Object[]{e.toString()});
                    if (b != null) {
                        b.close();
                    }
                    return eVar;
                }
            }
            eVar = null;
            if (b != null) {
                b.close();
            }
        } catch (Exception e4) {
            e = e4;
            eVar = null;
            b = null;
        } catch (Throwable th3) {
            th = th3;
            b = null;
            if (b != null) {
                b.close();
            }
            throw th;
        }
        return eVar;
    }

    private Cursor a(String str, String[] strArr, String str2, String[] strArr2) {
        return this.dCZ.query(str, strArr, str2, strArr2, null, null, null);
    }

    private Cursor b(String str, String[] strArr, String str2, String[] strArr2) {
        return a(str, strArr, str2, strArr2);
    }

    public final long a(String str, int i, int i2, int i3, PString pString, PInt pInt, PInt pInt2) {
        return a(str, i, i2, i3, pString, pInt, pInt2, "", "", -1, null, null, null);
    }

    public final long a(String str, int i, int i2, int i3, PString pString, PInt pInt, PInt pInt2, String str2, String str3, long j, com.tencent.mm.a.b bVar, com.tencent.mm.a.b bVar2, n.a aVar) {
        int i4 = bi.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
        if (i4 <= 0) {
            i4 = 100;
        }
        i4 *= 1024;
        e a;
        long e;
        if (i == 0 || e.cm(str) <= i4) {
            a = a(str, 0, true, i2, i3, pInt, pInt2, pString.value, j, str2, str3, bVar2, bVar, aVar);
            if (a == null) {
                return -1;
            }
            pString.value = a.dTN;
            e = e(a);
            if (e == -1) {
                return e;
            }
            doNotify();
            return e;
        } else if (i == 1) {
            a = a(str, 1, true, i2, i3, pInt, pInt2, pString.value, j, str2, str3, bVar2, bVar, aVar);
            if (a == null) {
                return -1;
            }
            pString.value = a.dTN;
            a.bo(0);
            a.ax(0);
            a.hL((int) FileOp.mI(o(a.dTL, "", "")));
            e a2 = a(str, 0, false, i2, i3, new PInt(), new PInt(), "", j, str2, str3, bVar2, bVar, aVar);
            if (a2 == null) {
                return 0;
            }
            a2.lH(a.dTL);
            a2.lJ(a.dTN);
            a2.lI(a.dTM);
            a2.hL(0);
            long dO = this.dCZ.dO(Thread.currentThread().getId());
            a2.hM((int) e(a));
            e = e(a2);
            x.d("MicroMsg.ImgInfoStorage", "summersafecdn insert ret[%d],  getLocalId[%d], getMsgLocalId[%d], getBigImgPath[%s], getMidImgPath[%s], getTotalLen[%d]", new Object[]{Long.valueOf(e), Long.valueOf(a2.dTK), Long.valueOf(a2.dTS), a2.dTL, a2.dTM, Integer.valueOf(a2.dHI)});
            if (dO > 0) {
                com.tencent.mm.kernel.g.Ei().dqq.gp(dO);
            }
            if (e == -1) {
                return e;
            }
            doNotify();
            return e;
        } else {
            Assert.assertTrue(false);
            return 0;
        }
    }

    public final long e(e eVar) {
        long insert = this.dCZ.insert("ImgInfo2", SlookAirButtonFrequentContactAdapter.ID, eVar.wH());
        if (insert != -1) {
            eVar.OO();
        }
        x.i("MicroMsg.ImgInfoStorage", "insert img, result:%d, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d", new Object[]{Long.valueOf(insert), Long.valueOf(eVar.dTK), Long.valueOf(eVar.dTS), Long.valueOf(eVar.bYu), Integer.valueOf(eVar.dTU)});
        return insert;
    }

    private String O(String str, int i) {
        e N = N(FileOp.mO(str), i);
        if (!bi.oW(N.dTN)) {
            String E = E(N.dTN, true);
            if (FileOp.cn(E)) {
                return E;
            }
        }
        return null;
    }

    public final Bitmap a(String str, int i, int i2, PInt pInt, PInt pInt2, boolean z, String str2, com.tencent.mm.a.b bVar) {
        Bitmap l;
        x.d("MicroMsg.ImgInfoStorage", "summersafecdn getPreSendBitmap origPath[%s], compressType[%d],needSave[%b], stack[%s], thumbPath: %s", new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z), bi.cjd(), str2});
        Bitmap bitmap = (Bitmap) this.dUr.get(str);
        String str3 = null;
        if (bitmap == null || bitmap.isRecycled()) {
            String str4;
            str3 = O(str, i);
            if (bi.oW(str3)) {
                str4 = str;
            } else if (str3.endsWith("hd")) {
                str4 = str3;
            } else {
                bitmap = com.tencent.mm.sdk.platformtools.c.cU(str3, 0);
                str4 = str;
            }
            if (bitmap == null || bitmap.isRecycled()) {
                int Wn = z.Wn(str4);
                int VX = ExifHelper.VX(str4) + (i2 * 90);
                if (Wn > 0) {
                    l = z.l(str4, Wn, VX, 0);
                } else {
                    l = com.tencent.mm.sdk.platformtools.c.j(str4, 120, 120, 0);
                }
                if (l != null) {
                    this.dUr.m(str, l);
                    pInt.value = l.getWidth();
                    pInt2.value = l.getHeight();
                    if (z) {
                        String O;
                        if (str3 == null) {
                            O = O(str, i);
                        } else {
                            O = str3;
                        }
                        if (!bi.oW(O) && O.endsWith("hd")) {
                            O = O.substring(0, O.length() - 2);
                        }
                        if (bVar != null) {
                            bVar.tZ();
                        }
                        if (bi.oW(O) || !FileOp.cn(O)) {
                            try {
                                Object obj = (bi.oW(O) || !O.endsWith("hd")) ? null : 1;
                                com.tencent.mm.sdk.platformtools.c.a(l, obj != null ? 80 : 90, CompressFormat.JPEG, str2, false);
                            } catch (IOException e) {
                            }
                        } else {
                            FileOp.y(O, str2);
                            x.i("MicroMsg.ImgInfoStorage", "copy from old thumbPath %s", new Object[]{O});
                        }
                    }
                }
                return l;
            }
        }
        l = bitmap;
        if (l != null) {
            this.dUr.m(str, l);
            pInt.value = l.getWidth();
            pInt2.value = l.getHeight();
            if (z) {
                String O2;
                if (str3 == null) {
                    O2 = O(str, i);
                } else {
                    O2 = str3;
                }
                if (!bi.oW(O2) && O2.endsWith("hd")) {
                    O2 = O2.substring(0, O2.length() - 2);
                }
                if (bVar != null) {
                    bVar.tZ();
                }
                if (bi.oW(O2) || !FileOp.cn(O2)) {
                    try {
                        Object obj2 = (bi.oW(O2) || !O2.endsWith("hd")) ? null : 1;
                        com.tencent.mm.sdk.platformtools.c.a(l, obj2 != null ? 80 : 90, CompressFormat.JPEG, str2, false);
                    } catch (IOException e2) {
                    }
                } else {
                    FileOp.y(O2, str2);
                    x.i("MicroMsg.ImgInfoStorage", "copy from old thumbPath %s", new Object[]{O2});
                }
            }
        }
        return l;
    }

    public static synchronized String OQ() {
        String u;
        synchronized (g.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (dUD == currentTimeMillis) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
                currentTimeMillis = System.currentTimeMillis();
            }
            dUD = currentTimeMillis;
            u = com.tencent.mm.a.g.u(String.valueOf(currentTimeMillis).getBytes());
        }
        return u;
    }

    public final String a(String str, String str2, int i, boolean z, PString pString, PString pString2, PString pString3, PString pString4, String str3, com.tencent.mm.a.b bVar) {
        String o;
        int i2;
        int i3;
        String value;
        int indexOf;
        int i4;
        boolean z2;
        boolean z3;
        int i5;
        if (bi.oW(str3)) {
            str3 = com.tencent.mm.a.g.u((str + System.currentTimeMillis()).getBytes());
        }
        String b = b(str3, "", ".jpg", false);
        if (bVar == null) {
            b = b(str3, "", ".jpg", true);
        }
        pString.value = str3;
        pString2.value = b;
        if (z && !bi.oW(str2) && i == 0) {
            e N = N(str2, i);
            if (!bi.oW(N.dTL)) {
                o = o(N.dTL, "", "");
                if (bVar != null) {
                    bVar.tZ();
                }
                FileOp.y(o, b);
                if (FileOp.mI(o) <= 0) {
                    x.w("MicroMsg.ImgInfoStorage", "ERR: copy old match file failed ,:%s ,%s ", new Object[]{str, b});
                } else if (bi.oW(N.dTV)) {
                    return null;
                } else {
                    return N.dTV;
                }
            }
        }
        try {
            i2 = ao.isWifi(ad.getContext()) ? bi.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("CompressPicLevelForWifi"), 60) : ao.is2G(ad.getContext()) ? bi.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("CompressPicLevelFor2G"), 40) : ao.is3G(ad.getContext()) ? bi.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("CompressPicLevelFor3G"), 40) : bi.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("CompressPicLevelFor4G"), 60);
        } catch (Exception e) {
            i2 = 0;
        }
        x.i("MicroMsg.ImgInfoStorage", "genBigImg CompressPicLevel-level:%d", new Object[]{Integer.valueOf(i2)});
        if (i2 <= 10 || i2 > 100) {
            i3 = 70;
        } else {
            i3 = i2;
        }
        int i6 = 0;
        int i7 = 1080;
        try {
            if (ao.isWifi(ad.getContext())) {
                value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("CompressResolutionForWifi");
            } else if (ao.is2G(ad.getContext())) {
                value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("CompressResolutionFor2G");
            } else if (ao.is3G(ad.getContext())) {
                value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("CompressResolutionFor3G");
            } else {
                value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("CompressResolutionFor4G");
            }
            indexOf = value.indexOf("*");
            if (-1 != indexOf) {
                i6 = Integer.valueOf(value.substring(0, indexOf)).intValue();
                i2 = Integer.valueOf(value.substring(indexOf + 1)).intValue();
            } else {
                i2 = 1080;
            }
            i7 = i2;
        } catch (Exception e2) {
        }
        try {
            i4 = bi.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("UseOptImage"), 0);
            com.tencent.mm.kernel.g.Eg();
            if ((((int) (new o(com.tencent.mm.kernel.a.Df()).longValue() / 100)) % 100) + 1 <= i4) {
                z2 = true;
            } else {
                z2 = false;
            }
            x.i("MicroMsg.ImgInfoStorage", "fromPathToImgInfo useOpt:%b opt:%d uin:(%d,%d) debug:%b sdk:%d", new Object[]{Boolean.valueOf(z2), Integer.valueOf(i4), Long.valueOf(new o(com.tencent.mm.kernel.a.Df()).longValue()), Long.valueOf(new o(com.tencent.mm.kernel.a.Df()).longValue() / 100), Boolean.valueOf(com.tencent.mm.sdk.a.b.chp()), Integer.valueOf(VERSION.SDK_INT)});
        } catch (Throwable e3) {
            x.e("MicroMsg.ImgInfoStorage", "get useopt :%s", new Object[]{bi.i(e3)});
            z2 = false;
        }
        if (com.tencent.mm.sdk.a.b.chp()) {
            z2 = true;
        }
        if (d.fS(16)) {
            z3 = false;
        } else {
            z3 = z2;
        }
        x.i("MicroMsg.ImgInfoStorage", "genBigImg configLong:%d configShort:%d", new Object[]{Integer.valueOf(i6), Integer.valueOf(i7)});
        if (i6 <= 0 && i7 <= 0) {
            i6 = 0;
            i7 = 1080;
        } else if (i7 >= 2160) {
            i6 = 0;
            i7 = 1080;
        } else if (i7 <= 0 && i6 > 3240) {
            i6 = 1620;
            i7 = 0;
        }
        i2 = bi.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
        if (i2 <= 0) {
            i2 = 100;
        }
        int i8 = i2 * 1024;
        i2 = bi.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("PicCompressAvoidanceRemainderPerc"), 10);
        if (i2 <= 0 || i2 >= 100) {
            i5 = 10;
        } else {
            i5 = i2;
        }
        int queryQuality = MMNativeJpeg.queryQuality(str);
        Object obj = 1;
        if (queryQuality != 0 && queryQuality <= i3) {
            obj = null;
        }
        x.d("MicroMsg.ImgInfoStorage", "genBigImg insert : original img path: %s, fullpath:%s, needimg:%b,comresstype:%d Avoidance[%d,%d] ", new Object[]{str, b, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i8), Integer.valueOf(i5)});
        if (z) {
            Options VZ = com.tencent.mm.sdk.platformtools.c.VZ(str);
            if (VZ == null || VZ.outWidth == 0 || VZ.outHeight == 0) {
                o = "MicroMsg.ImgInfoStorage";
                String str4 = "genBigImg getImageOptions error:%s, origOptions_null:%b";
                Object[] objArr = new Object[2];
                objArr[0] = str;
                objArr[1] = Boolean.valueOf(VZ == null);
                x.w(o, str4, objArr);
                return null;
            }
            int i9;
            int i10;
            Object obj2;
            long j;
            boolean z4;
            long VF;
            int i11 = VZ.outWidth;
            int i12 = VZ.outHeight;
            indexOf = VZ.outWidth > VZ.outHeight ? VZ.outWidth : VZ.outHeight;
            if (VZ.outWidth < VZ.outHeight) {
                i9 = VZ.outWidth;
            } else {
                i9 = VZ.outHeight;
            }
            if (i7 > 0) {
                i10 = i9 / i7;
                i6 = (VZ.outHeight * i7) / i9;
                indexOf = (i7 * VZ.outWidth) / i9;
            } else {
                i7 = indexOf / i6;
                i9 = (VZ.outHeight * i6) / indexOf;
                indexOf = (i6 * VZ.outWidth) / indexOf;
                i10 = i7;
                i6 = i9;
            }
            if (i6 * indexOf > 10240000) {
                double sqrt = Math.sqrt(1.024E7d / ((double) (i6 * indexOf)));
                i6 = (int) (((double) i6) / sqrt);
                indexOf = (int) (((double) indexOf) / sqrt);
            }
            x.i("MicroMsg.ImgInfoStorage", "genBigImg [%d, %d] -> target:[h,w]:[%d,%d]", new Object[]{Integer.valueOf(VZ.outHeight), Integer.valueOf(VZ.outWidth), Integer.valueOf(i6), Integer.valueOf(indexOf)});
            o = VZ != null ? VZ.outMimeType : "";
            long mI = FileOp.mI(str);
            boolean IsJpegFile = MMNativeJpeg.IsJpegFile(str);
            if (o == null || !(o.endsWith("jpeg") || o.endsWith("jpg") || o.endsWith("bmp") || o.endsWith("png") || o.endsWith("gif"))) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (i != 0 || ((obj == null && mI <= 204800 && (VZ == null || i10 <= 0)) || mI <= ((long) i8))) {
                x.i("MicroMsg.ImgInfoStorage", "summersafecdn createThumbNail big pic no compress, calculatedQuality:%d, origLen:%d oriWidth:%d oriHeight:%d", new Object[]{Integer.valueOf(queryQuality), Long.valueOf(mI), Integer.valueOf(i11), Integer.valueOf(i12)});
                if (obj2 != null) {
                    FileOp.y(str, b);
                } else {
                    if (com.tencent.mm.sdk.platformtools.c.a(false, str, i11, i12, CompressFormat.JPEG, 100, b, bVar) != 1) {
                        com.tencent.mm.plugin.report.service.h.mEJ.a(111, 187, 1, false);
                        x.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail (for cvrt to jpg): %s", new Object[]{str});
                        return null;
                    }
                }
                com.tencent.mm.modelcdntran.g.ND();
                if (!com.tencent.mm.modelcdntran.c.hz(256)) {
                    x.d("MicroMsg.ImgInfoStorage", "summersafecdn not use CDNNEWPROTO");
                } else if (i == 1) {
                    int i13;
                    int i14;
                    int i15 = 0;
                    try {
                        i15 = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("CompressMidPicLevel")).intValue();
                    } catch (Exception e4) {
                    }
                    try {
                        i2 = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("CompressMidPicSize")).intValue();
                    } catch (Exception e5) {
                        i2 = 0;
                    }
                    x.i("MicroMsg.ImgInfoStorage", "summersafecdn CompressMidPicLevel-level:%d size:%d", new Object[]{Integer.valueOf(i15), Integer.valueOf(i2)});
                    if (i15 <= 10 || i15 > 100) {
                        i15 = 52;
                    }
                    if (i2 <= 0 || i2 > 800) {
                        i7 = 800;
                    } else {
                        i7 = i2;
                    }
                    if (indexOf > i7) {
                        i13 = i7;
                    } else {
                        i13 = indexOf;
                    }
                    if (i6 > i7) {
                        i14 = i7;
                    } else {
                        i14 = i6;
                    }
                    z2 = true;
                    if (queryQuality != 0 && queryQuality <= i15) {
                        z2 = false;
                    }
                    if (z2 || mI > 800 || (VZ != null && (i12 > i7 || i11 > i7))) {
                        pString3.value = com.tencent.mm.a.g.u((str + System.currentTimeMillis()).getBytes());
                        pString4.value = b(pString3.value, "", ".jpg", false);
                        i7 = com.tencent.mm.sdk.platformtools.c.a(false, str, i14, i13, CompressFormat.JPEG, i15, pString4.value, bVar);
                        x.d("MicroMsg.ImgInfoStorage", "summersafecdn pMidImgName[%s], pMidImgPath[%s], useOpt[%b], ret[%b] [%d, %d]", new Object[]{pString3.value, pString4.value, Boolean.valueOf(false), Integer.valueOf(i7), Integer.valueOf(i14), Integer.valueOf(i13)});
                        j = 0;
                        i9 = 38;
                        z4 = false;
                    } else {
                        pString3.value = pString.value;
                        pString4.value = pString2.value;
                        x.d("MicroMsg.ImgInfoStorage", "summersafecdn not need to compress mid pic needCompressByQuality[%b], [%d, %d; %d, %d] use big pMidImgName[%s], pMidImgPath[%s]", new Object[]{Boolean.valueOf(z2), Integer.valueOf(i12), Integer.valueOf(i11), Integer.valueOf(i14), Integer.valueOf(i13), pString3.value, pString4.value});
                        j = 0;
                        i7 = 1;
                        i9 = 38;
                        z4 = false;
                    }
                }
                j = 0;
                i7 = 1;
                i9 = 38;
                z4 = false;
            } else {
                if (queryQuality < 55 || !IsJpegFile) {
                    z2 = false;
                } else {
                    z2 = z3;
                }
                if (z2) {
                    i9 = 18;
                } else {
                    i9 = 8;
                }
                VF = bi.VF();
                i7 = com.tencent.mm.sdk.platformtools.c.a(z2, str, i6, indexOf, CompressFormat.JPEG, i3, b, bVar);
                if (i7 == 1 || !z2) {
                    z4 = z2;
                } else {
                    i9 = 28;
                    i7 = com.tencent.mm.sdk.platformtools.c.a(false, str, i6, indexOf, CompressFormat.JPEG, i3, b, bVar);
                    z4 = false;
                }
                x.i("MicroMsg.ImgInfoStorage", "genBigImg check use orig , orig:%d aftercomp:%d diff percent:[%d] picCompressAvoidanceRemainderPerc:%d  %s ", new Object[]{Long.valueOf(mI), Long.valueOf(FileOp.mI(b)), Long.valueOf((100 * FileOp.mI(b)) / mI), Integer.valueOf(i5), b});
                if (obj2 != null && (mI - r20) * 100 < ((long) i5) * mI) {
                    FileOp.y(str, b);
                    z4 = false;
                    i9 = 48;
                    i7 = 1;
                }
                j = bi.VF() - VF;
                if (i7 != 1) {
                    com.tencent.mm.plugin.report.service.h.mEJ.a(111, 187, 1, false);
                    x.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail: %s", new Object[]{str});
                    return null;
                }
            }
            Options VZ2 = com.tencent.mm.sdk.platformtools.c.VZ(b);
            i10 = VZ2 != null ? VZ2.outWidth : -1;
            indexOf = VZ2 != null ? VZ2.outHeight : -1;
            VF = FileOp.mI(b);
            i5 = MMNativeJpeg.queryQuality(b);
            boolean IsJpegFile2 = MMNativeJpeg.IsJpegFile(b);
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.mEJ;
            Integer[] numArr = new Object[13];
            numArr[0] = Integer.valueOf(i7);
            numArr[1] = Long.valueOf(j);
            numArr[2] = Integer.valueOf(i9);
            numArr[3] = Integer.valueOf(IsJpegFile ? 1 : 2);
            numArr[4] = Long.valueOf(mI);
            numArr[5] = Integer.valueOf(i11);
            numArr[6] = Integer.valueOf(i12);
            numArr[7] = Integer.valueOf(i);
            numArr[8] = Long.valueOf(VF);
            numArr[9] = Integer.valueOf(i10);
            numArr[10] = Integer.valueOf(indexOf);
            numArr[11] = Integer.valueOf(queryQuality);
            numArr[12] = Integer.valueOf(i5);
            hVar.h(11713, numArr);
            x.i("MicroMsg.ImgInfoStorage", "genBigImg ret:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", new Object[]{Integer.valueOf(i7), Boolean.valueOf(z4), Integer.valueOf(i9), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(queryQuality), Long.valueOf(mI), Boolean.valueOf(IsJpegFile), Integer.valueOf(i10), Integer.valueOf(indexOf), Integer.valueOf(i5), Long.valueOf(VF), Boolean.valueOf(IsJpegFile2), str, b});
            if (i == 0 && VF >= 40960 && IsJpegFile2 && !MMNativeJpeg.isProgressive(b)) {
                value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("EnableCDNUploadImg");
                if (!bi.oW(value) && value.equals("1")) {
                    boolean z5;
                    j = bi.VF();
                    if (z4) {
                        i4 = 19;
                        String str5 = b + ".prog";
                        FileOp.y(b, str5);
                        z2 = (bi.oW(str5) || bi.oW(b) || !new File(str5).exists()) ? false : MMJpegOptim.convertToProgressive(str5, b, i3) == 0;
                        FileOp.deleteFile(str5);
                        if (z2) {
                            z5 = z2;
                        } else {
                            z5 = MMNativeJpeg.convertToProgressive(b, i3);
                            i4 = 29;
                        }
                    } else {
                        i4 = 9;
                        z5 = MMNativeJpeg.convertToProgressive(b, i3);
                    }
                    j = bi.VF() - j;
                    long mI2 = FileOp.mI(b);
                    com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.mEJ;
                    numArr = new Object[14];
                    numArr[0] = Integer.valueOf(z5 ? 1 : -1);
                    numArr[1] = Long.valueOf(j);
                    numArr[2] = Integer.valueOf(i4);
                    numArr[3] = Integer.valueOf(IsJpegFile ? 1 : 2);
                    numArr[4] = Long.valueOf(mI);
                    numArr[5] = Integer.valueOf(i11);
                    numArr[6] = Integer.valueOf(i12);
                    numArr[7] = Integer.valueOf(i);
                    numArr[8] = Long.valueOf(VF);
                    numArr[9] = Integer.valueOf(i10);
                    numArr[10] = Integer.valueOf(indexOf);
                    numArr[11] = Integer.valueOf(queryQuality);
                    numArr[12] = Integer.valueOf(i5);
                    numArr[13] = Long.valueOf(mI2);
                    hVar2.h(11713, numArr);
                    x.i("MicroMsg.ImgInfoStorage", "genBigImg PROGRESS ret:%d progret:%b size:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", new Object[]{Integer.valueOf(i7), Boolean.valueOf(z5), Long.valueOf(mI2), Boolean.valueOf(z4), Integer.valueOf(i4), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(queryQuality), Long.valueOf(mI), Boolean.valueOf(IsJpegFile), Integer.valueOf(i10), Integer.valueOf(indexOf), Integer.valueOf(i5), Long.valueOf(VF), Boolean.valueOf(IsJpegFile2), str, b});
                    if (!z5) {
                        com.tencent.mm.plugin.report.service.h.mEJ.a(111, 186, 1, false);
                        x.e("MicroMsg.ImgInfoStorage", "genBigImg convert to progressive failed %s", new Object[]{b});
                    }
                }
            }
        }
        return null;
    }

    private e a(String str, int i, boolean z, int i2, int i3, PInt pInt, PInt pInt2, String str2, long j, String str3, String str4, com.tencent.mm.a.b bVar, com.tencent.mm.a.b bVar2, n.a aVar) {
        if (!FileOp.cn(str)) {
            return null;
        }
        String str5;
        String str6;
        PString pString;
        PString pString2;
        PString pString3;
        String a;
        String mO = FileOp.mO(str);
        x.i("MicroMsg.ImgInfoStorage", "genThumbImg, orig:%s", new Object[]{str});
        if (FileOp.cn(str)) {
            if (bi.oW(str3)) {
                str3 = OQ();
            }
            str5 = "THUMBNAIL_DIRPATH://th_" + str3;
            String b = b(str5, "th_", "", false);
            if (bVar == null) {
                b = o(str5, "th_", "");
            }
            if (z) {
                if (bi.oW(str2) || !FileOp.cn(str2)) {
                    long VG = bi.VG();
                    a(str, i, i3, pInt, pInt2, true, b, bVar);
                    if (FileOp.cn(b)) {
                        com.tencent.mm.plugin.report.service.h.mEJ.h(10921, new Object[]{Long.valueOf(FileOp.mI(b)), Long.valueOf(FileOp.mI(str)), Integer.valueOf(90), Long.valueOf(bi.bI(VG))});
                    } else {
                        x.e("MicroMsg.ImgInfoStorage", " thumbImg not exits");
                    }
                } else {
                    FileOp.y(str2, b);
                }
                x.d("MicroMsg.ImgInfoStorage", "insert: thumbName = " + str5);
            }
            str6 = str5;
        } else {
            x.e("MicroMsg.ImgInfoStorage", "file not exit:%s", new Object[]{str});
            str6 = null;
        }
        if (aVar == null || aVar.dTO != i) {
            com.tencent.mm.a.b bVar3;
            if (aVar == null || aVar.dTO == i) {
                bVar3 = bVar2;
                str5 = str4;
            } else {
                bVar3 = null;
                str5 = null;
            }
            pString = new PString();
            pString2 = new PString();
            pString3 = new PString();
            a = a(str, mO, i, z, pString, pString2, pString3, new PString(), str5, bVar3);
            x.i("MicroMsg.ImgInfoStorage", "summersafecdn user change CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i), pString3.value, r10.value});
        } else {
            n.a.a OY = aVar.OY();
            pString = OY.dWc;
            pString2 = OY.dWd;
            a = OY.dTV;
            pString3 = OY.dWe;
            PString pString4 = OY.dWf;
            x.i("MicroMsg.ImgInfoStorage", "summersafecdn found CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i), pString3.value, pString4.value});
        }
        e eVar = new e();
        eVar.bWA = -1;
        long j2 = this.dUz;
        this.dUz = 1 + j2;
        eVar.bp(j2);
        eVar.bo(j);
        if (!bi.oW(a)) {
            eVar.lK(a);
        }
        eVar.hO(0);
        eVar.source = i2;
        eVar.dUj = true;
        if (i2 == 4) {
            if (str.startsWith(com.tencent.mm.storage.y.Gf())) {
                eVar.hN(3);
            } else {
                eVar.hN(2);
            }
        } else {
            eVar.hN(1);
        }
        if (z) {
            eVar.lH(pString.value + ".jpg");
            if (!bi.oW(pString3.value)) {
                eVar.lI(pString3.value + ".jpg");
            }
            if (bi.oW(eVar.dTN)) {
                eVar.lJ(str6);
            }
            eVar.hL((int) FileOp.mI(pString2.value));
            if (eVar.dHI == 0) {
                x.i("MicroMsg.ImgInfoStorage", "thumb file totlen is 0 %s", new Object[]{pString2.value});
            }
            eVar.lG(mO);
        }
        eVar.hK((int) bi.VE());
        eVar.hP(i);
        x.d("MicroMsg.ImgInfoStorage", "fromPathToImgInfo insert: compress img size = " + eVar.dHI);
        return eVar;
    }

    public final long a(byte[] bArr, long j, boolean z, String str, PString pString, PInt pInt, PInt pInt2) {
        return a(bArr, j, z, "", 0, str, pString, pInt, pInt2);
    }

    public final long a(byte[] bArr, long j, boolean z, String str, int i, String str2, PString pString, PInt pInt, PInt pInt2) {
        String str3 = "SERVERID://" + j;
        String u = com.tencent.mm.a.g.u(str3.getBytes());
        String o = o(u, "th_", "");
        if (bArr != null && bArr.length >= 0) {
            Bitmap bt = com.tencent.mm.sdk.platformtools.c.bt(bArr);
            if (bt == null) {
                x.e("MicroMsg.ImgInfoStorage", "create decodeByteArray failed: " + new String(bArr));
            }
            if (!(z || bt == null)) {
                try {
                    bt = com.tencent.mm.sdk.platformtools.c.P(bt);
                    pInt.value = bt.getWidth();
                    pInt2.value = bt.getHeight();
                    com.tencent.mm.sdk.platformtools.c.a(bt, 90, CompressFormat.JPEG, o, true);
                } catch (IOException e) {
                    x.e("MicroMsg.ImgInfoStorage", "create thumbnail from byte failed: " + u + " " + new String(bArr));
                }
            }
        }
        e eVar = new e();
        if (bi.oW(str)) {
            str = str3;
        } else {
            eVar.setOffset(i);
            eVar.hL(i);
        }
        eVar.bWA = -1;
        long j2 = this.dUz;
        this.dUz = 1 + j2;
        eVar.bp(j2);
        eVar.lH(str);
        eVar.lJ("THUMBNAIL_DIRPATH://th_" + u);
        pString.value = eVar.dTN;
        if (z) {
            eVar.ax(0);
        } else {
            eVar.ax(j);
        }
        eVar.lK(str2);
        eVar.hK((int) bi.VE());
        long e2 = e(eVar);
        if (e2 != -1) {
            doNotify();
        }
        return e2;
    }

    public final int a(int i, e eVar) {
        return a(Long.valueOf((long) i), eVar);
    }

    public final int a(Long l, e eVar) {
        int i;
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        ContentValues wH = eVar.wH();
        if (wH.size() == 0) {
            i = 1;
        } else {
            i = this.dCZ.update("ImgInfo2", wH, "id=?", new String[]{String.valueOf(l)});
        }
        x.i("MicroMsg.ImgInfoStorage", "update last :%d values : %s", new Object[]{Long.valueOf(System.currentTimeMillis() - valueOf.longValue()), wH.toString()});
        if (i != -1) {
            eVar.OO();
            doNotify();
        }
        return i;
    }

    public final Bitmap a(long j, String str, int i, int i2, int i3, boolean z) {
        Object obj;
        if (z) {
            obj = "location_backgroup_key_from" + j;
        } else {
            String obj2 = "location_backgroup_key_tor" + j;
        }
        Bitmap bitmap = (Bitmap) this.dUr.get(obj2);
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        bitmap = com.tencent.mm.sdk.platformtools.c.k(str, i, i2, i3);
        this.dUr.m(obj2, bitmap);
        return bitmap;
    }

    public final boolean a(String str, String str2, int i, int i2, int i3, int i4) {
        x.d("MicroMsg.ImgInfoStorage", "createHDThumbNail bigPicPath%s thumbPath%s maskResId:%d, compressType:%d, stack[%s]", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), bi.cjd()});
        long currentTimeMillis = System.currentTimeMillis();
        float density = a.getDensity(ad.getContext());
        if (bi.oW(str) || bi.oW(str2)) {
            return false;
        }
        String d = d(str2, false, true);
        if (bi.oW(d)) {
            return false;
        }
        String str3;
        String substring;
        boolean a;
        if (d.endsWith("hd")) {
            str3 = d;
            substring = d.substring(0, d.length() - 2);
        } else {
            str3 = d + "hd";
            substring = d;
        }
        Options VZ = com.tencent.mm.sdk.platformtools.c.VZ(substring);
        if (VZ == null || VZ.outWidth <= 0 || VZ.outHeight <= 0) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(111, 185, 1, false);
            if (e.cm(substring) > 0) {
                return false;
            }
            VZ = new Options();
            com.tencent.mm.sdk.platformtools.c.c(VZ);
            x.i("MicroMsg.ImgInfoStorage", "createHDThumbNail old op is invaild but len is 0 need recreate[%s, %d, %d]", new Object[]{VZ, Integer.valueOf(VZ.outWidth), Integer.valueOf(VZ.outHeight)});
            com.tencent.mm.plugin.report.service.h.mEJ.a(111, 183, 1, false);
        }
        if (VZ.outWidth == 0) {
            VZ.outWidth = i3;
        }
        if (VZ.outHeight == 0) {
            VZ.outHeight = i4;
        }
        int i5 = (int) ((((float) VZ.outWidth) * density) * 1.25f);
        int i6 = (int) ((((float) VZ.outHeight) * density) * 1.25f);
        if (((float) i5) >= 160.0f * density || ((float) i6) >= 160.0f * density) {
            float f;
            if (i6 > i5) {
                f = (160.0f * density) / ((float) i6);
            } else {
                f = (160.0f * density) / ((float) i5);
            }
            i5 = (int) (((float) i5) * f);
            i6 = (int) (f * ((float) i6));
        }
        if (i2 == 0) {
            try {
                a = com.tencent.mm.sdk.platformtools.c.a(str, i6, i5, CompressFormat.JPEG, str3, new PInt(), new PInt());
            } catch (Exception e) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(111, 184, 1, false);
                x.e("MicroMsg.ImgInfoStorage", "create hd thumbnail failed. %s", new Object[]{e.toString()});
                return false;
            }
        }
        a = com.tencent.mm.sdk.platformtools.c.b(str, i6, i5, CompressFormat.JPEG, str3, new PInt(), new PInt());
        x.d("MicroMsg.ImgInfoStorage", "createHDThumbNail user time %s, height %d, width %d, hasHDThumb:%b", new Object[]{(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(i6), Integer.valueOf(i5), Boolean.valueOf(a)});
        a(substring, true, a.getDensity(ad.getContext()), true, false, true, i, false);
        if (a) {
            synchronized (this.dUy) {
                if (this.dUy.containsKey(str2) && !((String) this.dUy.get(str2)).endsWith("hd")) {
                    this.dUy.put(str2, str3);
                }
            }
            return a;
        }
        com.tencent.mm.plugin.report.service.h.mEJ.a(111, 184, 1, false);
        return a;
    }

    public final String d(String str, boolean z, boolean z2) {
        if (str != null && this.dUy.containsKey(str)) {
            return (String) this.dUy.get(str);
        }
        String str2;
        if (z) {
            str2 = str;
        } else {
            str2 = E(str, z2);
        }
        if (bi.oW(str2)) {
            return str2;
        }
        this.dUy.put(str, str2);
        return str2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String s(com.tencent.mm.storage.bd r10) {
        /*
        r6 = 0;
        r1 = 0;
        r8 = 1;
        if (r10 != 0) goto L_0x0011;
    L_0x0006:
        r0 = "MicroMsg.ImgInfoStorage";
        r2 = "[getBigPicPath] msg is null.";
        com.tencent.mm.sdk.platformtools.x.w(r0, r2);
        r0 = r1;
    L_0x0010:
        return r0;
    L_0x0011:
        r4 = java.lang.System.currentTimeMillis();
        r0 = r10.field_isSend;
        if (r0 != r8) goto L_0x0029;
    L_0x0019:
        r0 = com.tencent.mm.ak.o.Pf();
        r2 = r10.field_msgId;
        r0 = r0.br(r2);
        r2 = r0.dTK;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 != 0) goto L_0x0033;
    L_0x0029:
        r0 = com.tencent.mm.ak.o.Pf();
        r2 = r10.field_msgSvrId;
        r0 = r0.bq(r2);
    L_0x0033:
        r2 = com.tencent.mm.kernel.g.Ei();
        r2 = r2.isSDCardAvailable();
        if (r2 == 0) goto L_0x0081;
    L_0x003d:
        r2 = r10.field_isSend;
        if (r2 != r8) goto L_0x00a5;
    L_0x0041:
        r3 = com.tencent.mm.ak.f.c(r0);
        r2 = com.tencent.mm.ak.o.Pf();
        r6 = "";
        r7 = "";
        r2 = r2.o(r3, r6, r7);
        if (r3 == 0) goto L_0x0063;
    L_0x0055:
        r3 = r3.length();
        if (r3 <= 0) goto L_0x0063;
    L_0x005b:
        r3 = com.tencent.mm.modelsfs.FileOp.cn(r2);
        if (r3 == 0) goto L_0x0063;
    L_0x0061:
        r0 = r2;
        goto L_0x0010;
    L_0x0063:
        r2 = r0.dTL;
        r0 = com.tencent.mm.ak.o.Pf();
        r3 = "";
        r6 = "";
        r0 = r0.o(r2, r3, r6);
        if (r2 == 0) goto L_0x0081;
    L_0x0075:
        r2 = r2.length();
        if (r2 <= 0) goto L_0x0081;
    L_0x007b:
        r2 = com.tencent.mm.modelsfs.FileOp.cn(r0);
        if (r2 != 0) goto L_0x0010;
    L_0x0081:
        r0 = "MicroMsg.ImgInfoStorage";
        r2 = "getBigPicPath use time:%s";
        r3 = new java.lang.Object[r8];
        r6 = 0;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = java.lang.System.currentTimeMillis();
        r4 = r8 - r4;
        r4 = r7.append(r4);
        r4 = r4.toString();
        r3[r6] = r4;
        com.tencent.mm.sdk.platformtools.x.d(r0, r2, r3);
        r0 = r1;
        goto L_0x0010;
    L_0x00a5:
        r2 = r0.OM();
        if (r2 == 0) goto L_0x0081;
    L_0x00ab:
        r1 = r0.dTL;
        r2 = r0.ON();
        if (r2 == 0) goto L_0x00df;
    L_0x00b3:
        r0 = com.tencent.mm.ak.f.a(r0);
        if (r0 == 0) goto L_0x00df;
    L_0x00b9:
        r2 = r0.dTK;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 <= 0) goto L_0x00df;
    L_0x00bf:
        r2 = r0.OM();
        if (r2 == 0) goto L_0x00df;
    L_0x00c5:
        r2 = com.tencent.mm.ak.o.Pf();
        r3 = r0.dTL;
        r4 = "";
        r5 = "";
        r2 = r2.o(r3, r4, r5);
        r2 = com.tencent.mm.modelsfs.FileOp.cn(r2);
        if (r2 == 0) goto L_0x00df;
    L_0x00db:
        r0 = r0.dTL;
        goto L_0x0010;
    L_0x00df:
        r0 = r1;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ak.g.s(com.tencent.mm.storage.bd):java.lang.String");
    }
}
