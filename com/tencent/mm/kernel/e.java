package com.tencent.mm.kernel;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.mm.a.g;
import com.tencent.mm.a.o;
import com.tencent.mm.bt.f;
import com.tencent.mm.bt.h;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.compatible.e.l;
import com.tencent.mm.model.cb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.x;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import junit.framework.Assert;

public final class e {
    private static HashMap<Integer, d> cVM;
    public String cachePath;
    private ag dqA = null;
    private volatile Boolean dqB = null;
    private a dqC = new a(this, (byte) 0);
    private long dqD = 0;
    public final w dqk = DN();
    private com.tencent.mm.kernel.api.e dql;
    public b dqm = new b();
    b dqn = new b();
    public String dqo;
    public String dqp;
    public h dqq = null;
    public h dqr = null;
    public x dqs;
    bn dqt;
    bt dqu;
    ConcurrentHashMap<Integer, String> dqv;
    boolean dqw = false;
    cb dqx;
    ConcurrentHashMap<String, SharedPreferences> dqy = new ConcurrentHashMap();
    private long dqz = 0;

    private class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(e eVar, byte b) {
            this();
        }

        public final void run() {
            e.this.DV();
        }
    }

    public static class c {
        public boolean dqH = false;
        public int dqI = 0;
    }

    static class b extends com.tencent.mm.by.a<com.tencent.mm.bt.h.a> implements com.tencent.mm.bt.h.a {
        b() {
        }

        public final void Ea() {
            a(new com.tencent.mm.by.a.a<com.tencent.mm.bt.h.a>() {
            });
        }

        public final void Eb() {
            a(new com.tencent.mm.by.a.a<com.tencent.mm.bt.h.a>() {
            });
        }

        public final void Ec() {
            a(new com.tencent.mm.by.a.a<com.tencent.mm.bt.h.a>() {
            });
        }
    }

    public e(com.tencent.mm.kernel.api.e eVar) {
        a.dpp.a(this.dqk);
        String str = aa.duN + "alphahold.ini";
        com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "initialize dkalpha client:%x  isapha:%b %s", Integer.valueOf(com.tencent.mm.protocal.d.qVN), Boolean.valueOf(com.tencent.mm.protocal.d.qVQ), str);
        if (com.tencent.mm.protocal.d.qVQ || com.tencent.mm.protocal.d.qVR) {
            String value = com.tencent.mm.sdk.e.a.getValue(str, "noneedhold");
            int i = com.tencent.mm.protocal.d.qVN;
            try {
                i = Integer.decode(com.tencent.mm.loader.stub.a.CLIENT_VERSION).intValue();
            } catch (Throwable th) {
            }
            if (!String.valueOf(i).equals(value)) {
                com.tencent.mm.sdk.platformtools.x.w("MMKernel.CoreStorage", "dkalpha version need  reset to DefaultAccount , hold it! client:%x  isapha:%b", Integer.valueOf(i), Boolean.valueOf(com.tencent.mm.protocal.d.qVQ));
                a.Dj();
                com.tencent.mm.sdk.e.a.ap(str, "noneedhold", String.valueOf(i));
            }
        } else {
            com.tencent.mm.a.e.deleteFile(str);
        }
        this.dqo = DS();
        this.dql = eVar;
    }

    private static w DN() {
        com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "initialize packageInfo:%s version:%x", com.tencent.mm.sdk.platformtools.d.avA(), Integer.valueOf(com.tencent.mm.protocal.d.qVN));
        File file = new File(aa.duN);
        if (!file.exists()) {
            file.mkdirs();
        }
        w wVar = new w(aa.duN + "systemInfo.cfg");
        String str = (String) wVar.get(258);
        if (str != null) {
            l.zh().set(258, str);
        }
        try {
            StatFs statFs = new StatFs(com.tencent.mm.compatible.util.h.getDataDirectory().getPath());
            com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "CheckData path[%s] blocksize:%d blockcount:%d availcount:%d", r0.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()));
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.e("MMKernel.CoreStorage", "check data size failed :%s", e.getMessage());
        }
        return wVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.mm.model.ai r15) {
        /*
        r14 = this;
        r12 = 0;
        r2 = 1;
        r1 = 0;
        if (r15 != 0) goto L_0x0010;
    L_0x0006:
        r0 = "MMKernel.CoreStorage";
        r2 = "tryDataTransfer, dataTransferFactory is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r2);
    L_0x000f:
        return r1;
    L_0x0010:
        r0 = r14.dqs;
        r3 = 14;
        r4 = 0;
        r0 = r0.get(r3, r4);
        r0 = (java.lang.Integer) r0;
        r3 = com.tencent.mm.sdk.platformtools.bi.f(r0);
        r0 = com.tencent.mm.protocal.d.qVN;
        r4 = "MMKernel.CoreStorage";
        r5 = new java.lang.StringBuilder;
        r6 = "tryDataTransfer, sVer = ";
        r5.<init>(r6);
        r5 = r5.append(r3);
        r6 = ", cVer = ";
        r5 = r5.append(r6);
        r5 = r5.append(r0);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.x.d(r4, r5);
        r4 = r15.getDataTransferList();
        if (r4 != 0) goto L_0x0052;
    L_0x0048:
        r0 = "MMKernel.CoreStorage";
        r2 = "tryDataTransfer, dataTransferList is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r2);
        goto L_0x000f;
    L_0x0052:
        r5 = com.tencent.mm.platformtools.af.exe;
        if (r5 <= 0) goto L_0x0110;
    L_0x0056:
        r5 = com.tencent.mm.platformtools.af.exf;
        if (r5 <= 0) goto L_0x0110;
    L_0x005a:
        r0 = "MMKernel.CoreStorage";
        r5 = "tryDataTransfer, force data transfer";
        com.tencent.mm.sdk.platformtools.x.w(r0, r5);
    L_0x0063:
        r0 = "MMKernel.CoreStorage";
        r5 = new java.lang.StringBuilder;
        r6 = "tryDataTransfer dataTransferList size = ";
        r5.<init>(r6);
        r6 = r4.size();
        r5 = r5.append(r6);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r5);
        r0 = "MMKernel.CoreStorage";
        r5 = new java.lang.StringBuilder;
        r6 = "tryDataTransfer, threadId = ";
        r5.<init>(r6);
        r6 = java.lang.Thread.currentThread();
        r6 = r6.getId();
        r5 = r5.append(r6);
        r6 = ", name = ";
        r5 = r5.append(r6);
        r6 = java.lang.Thread.currentThread();
        r6 = r6.getName();
        r5 = r5.append(r6);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r5);
        r0 = r14.dqq;
        r5 = java.lang.Thread.currentThread();
        r6 = r5.getId();
        r6 = r0.dO(r6);
        r4 = r4.iterator();	 Catch:{ Throwable -> 0x0103 }
    L_0x00c0:
        r0 = r4.hasNext();	 Catch:{ Throwable -> 0x0103 }
        if (r0 == 0) goto L_0x0166;
    L_0x00c6:
        r0 = r4.next();	 Catch:{ Throwable -> 0x0103 }
        r0 = (com.tencent.mm.model.ah) r0;	 Catch:{ Throwable -> 0x0103 }
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0103 }
        r0.transfer(r3);	 Catch:{ Throwable -> 0x0103 }
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0103 }
        r8 = r10 - r8;
        r0.dBq = r8;	 Catch:{ Throwable -> 0x0103 }
        r5 = "MicroMsg.DataTransferBase";
        r8 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0103 }
        r9 = "doTransfer, timeConsumed = ";
        r8.<init>(r9);	 Catch:{ Throwable -> 0x0103 }
        r10 = r0.dBq;	 Catch:{ Throwable -> 0x0103 }
        r8 = r8.append(r10);	 Catch:{ Throwable -> 0x0103 }
        r9 = ", tag = ";
        r8 = r8.append(r9);	 Catch:{ Throwable -> 0x0103 }
        r0 = r0.getTag();	 Catch:{ Throwable -> 0x0103 }
        r0 = r8.append(r0);	 Catch:{ Throwable -> 0x0103 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0103 }
        com.tencent.mm.sdk.platformtools.x.d(r5, r0);	 Catch:{ Throwable -> 0x0103 }
        goto L_0x00c0;
    L_0x0103:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x0105 }
    L_0x0105:
        r0 = move-exception;
        r1 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1));
        if (r1 <= 0) goto L_0x010f;
    L_0x010a:
        r1 = r14.dqq;
        r1.gp(r6);
    L_0x010f:
        throw r0;
    L_0x0110:
        if (r3 != r0) goto L_0x0135;
    L_0x0112:
        r2 = "MMKernel.CoreStorage";
        r4 = new java.lang.StringBuilder;
        r5 = "tryDataTransfer, no need to transfer, sVer = ";
        r4.<init>(r5);
        r3 = r4.append(r3);
        r4 = ", cVer = ";
        r3 = r3.append(r4);
        r0 = r3.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.x.i(r2, r0);
        goto L_0x000f;
    L_0x0135:
        r5 = r4.iterator();
        r0 = r1;
    L_0x013a:
        r6 = r5.hasNext();
        if (r6 == 0) goto L_0x014c;
    L_0x0140:
        r0 = r5.next();
        r0 = (com.tencent.mm.model.ah) r0;
        r0 = r0.gV(r3);
        if (r0 == 0) goto L_0x013a;
    L_0x014c:
        r5 = "MMKernel.CoreStorage";
        r6 = new java.lang.StringBuilder;
        r7 = "tryDataTransfer, needTransfer = ";
        r6.<init>(r7);
        r6 = r6.append(r0);
        r6 = r6.toString();
        com.tencent.mm.sdk.platformtools.x.d(r5, r6);
        if (r0 != 0) goto L_0x0063;
    L_0x0164:
        goto L_0x000f;
    L_0x0166:
        r0 = com.tencent.mm.platformtools.af.exe;	 Catch:{ Throwable -> 0x0103 }
        if (r0 == 0) goto L_0x0190;
    L_0x016a:
        r0 = com.tencent.mm.platformtools.af.exf;	 Catch:{ Throwable -> 0x0103 }
        if (r0 == 0) goto L_0x0190;
    L_0x016e:
        r0 = com.tencent.mm.platformtools.af.exe;	 Catch:{ Throwable -> 0x0103 }
        if (r1 >= r0) goto L_0x0190;
    L_0x0172:
        r0 = com.tencent.mm.platformtools.af.exf;	 Catch:{ InterruptedException -> 0x017b }
        r4 = (long) r0;	 Catch:{ InterruptedException -> 0x017b }
        java.lang.Thread.sleep(r4);	 Catch:{ InterruptedException -> 0x017b }
    L_0x0178:
        r1 = r1 + 1;
        goto L_0x016e;
    L_0x017b:
        r0 = move-exception;
        r3 = "MMKernel.CoreStorage";
        r4 = "exception:%s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x0103 }
        r8 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);	 Catch:{ Throwable -> 0x0103 }
        r5[r8] = r0;	 Catch:{ Throwable -> 0x0103 }
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);	 Catch:{ Throwable -> 0x0103 }
        goto L_0x0178;
    L_0x0190:
        r0 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1));
        if (r0 <= 0) goto L_0x0199;
    L_0x0194:
        r0 = r14.dqq;
        r0.gp(r6);
    L_0x0199:
        r1 = r2;
        goto L_0x000f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.kernel.e.a(com.tencent.mm.model.ai):boolean");
    }

    final void DO() {
        com.tencent.mm.kernel.a.c.Et().gj(this.dqp);
        File file = new File(this.dqp + ".nomedia");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.e("MMKernel.CoreStorage", "exception:%s", bi.i(e));
            }
        }
    }

    final void gg(String str) {
        File file = new File(str + "-recovery");
        if (file.isFile()) {
            com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "Recovery database found, replace original one.");
            new File(str + ".ini").delete();
            File file2 = new File(str);
            file2.delete();
            if (!file.renameTo(file2)) {
                com.tencent.mm.sdk.platformtools.x.e("MMKernel.CoreStorage", "Rename database file failed!");
            }
        }
        final String name = file.getName();
        File[] listFiles = file.getParentFile().listFiles(new FilenameFilter() {
            public final boolean accept(File file, String str) {
                return str.startsWith(name) && !str.equals(name);
            }
        });
        if (listFiles != null) {
            for (File file3 : listFiles) {
                com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "Delete temporary recovery database file: " + file3.getName());
                file3.delete();
            }
        }
    }

    public final boolean a(f fVar, HashMap<Integer, d> hashMap) {
        String str = "MMKernel.CoreStorage";
        String str2 = "createtables %d %s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(hashMap == null ? -1 : hashMap.size());
        objArr[1] = Boolean.valueOf(false);
        com.tencent.mm.sdk.platformtools.x.i(str, str2, objArr);
        com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
        if (hashMap != null && hashMap.size() > 0) {
            int i = 0;
            for (Entry entry : hashMap.entrySet()) {
                Integer num = (Integer) entry.getKey();
                d dVar = (d) entry.getValue();
                str = null;
                if (!this.dqw) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String hashCode : dVar.xb()) {
                        stringBuilder.append(hashCode.hashCode());
                    }
                    String u = g.u(stringBuilder.toString().getBytes());
                    if (this.dqv != null) {
                        str = (String) this.dqv.get(num);
                        com.tencent.mm.sdk.platformtools.x.d("MMKernel.CoreStorage", "Create tables on %s(%s) compare with %s, using table versions", num, str, u);
                        if (str == null || !u.equals(str)) {
                            str = u;
                        }
                    } else {
                        if (this.dqu != null) {
                            bs bsVar = null;
                            Cursor rawQuery = this.dqu.rawQuery("select * from TablesVersion where tableHash = " + num.intValue(), new String[0]);
                            if (rawQuery != null) {
                                if (rawQuery.moveToFirst()) {
                                    bsVar = new bs();
                                    bsVar.d(rawQuery);
                                }
                                rawQuery.close();
                            }
                            Object obj = bsVar == null ? null : bsVar.field_tableSQLMD5;
                            com.tencent.mm.sdk.platformtools.x.d("MMKernel.CoreStorage", "Create tables on %s(%s) compare with %s, using table versions storage", num, obj, u);
                            if (obj != null && u.equals(obj)) {
                            }
                        }
                        str = u;
                    }
                }
                fVar.beginTransaction();
                int i2 = i;
                for (String str3 : dVar.xb()) {
                    try {
                        fVar.execSQL(str3);
                        i2++;
                    } catch (Exception e) {
                        Matcher matcher = com.tencent.mm.bt.a.tdj.matcher(str3);
                        if (matcher == null || !matcher.matches()) {
                            com.tencent.mm.sdk.platformtools.x.w("MMKernel.CoreStorage", "CreateTable failed:[" + str3 + "][" + e.getMessage() + "]");
                        } else {
                            Assert.assertTrue("CreateTable failed:[" + str3 + "][" + e.getMessage() + "]", false);
                        }
                    }
                }
                fVar.endTransaction();
                if (!(this.dqw || this.dqu == null || str == null)) {
                    bt btVar = this.dqu;
                    int intValue = num.intValue();
                    Assert.assertTrue(intValue != 0);
                    Assert.assertNotNull(str);
                    bs bsVar2 = new bs();
                    bsVar2.field_tableHash = intValue;
                    bsVar2.field_tableSQLMD5 = str;
                    btVar.dCZ.replace("TablesVersion", "tableHash", bsVar2.wH());
                    if (!(this.dqv == null || str == null)) {
                        this.dqv.put(num, str);
                    }
                }
                i = i2;
            }
            com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "createtables end sql:%d trans:%d sqlCount:%d", Long.valueOf(aVar.Ad()), Long.valueOf(aVar.Ad()), Integer.valueOf(i));
        }
        return true;
    }

    public final String DP() {
        File file = new File(this.cachePath + "/ctest", "EnMicroMsg.db");
        if (file.isFile()) {
            return file.getAbsolutePath();
        }
        file = new File(this.cachePath + "/corrupted", "EnMicroMsg.db");
        if (file.isFile()) {
            return file.getAbsolutePath();
        }
        String[] list = new File(this.cachePath).list(new FilenameFilter() {
            public final boolean accept(File file, String str) {
                return str.startsWith("EnMicroMsg.dberr");
            }
        });
        if (list == null || list.length <= 0) {
            return null;
        }
        String str = list[0];
        for (int i = 1; i < list.length; i++) {
            String str2 = list[i];
            if (str2.compareTo(str) > 0) {
                str = str2;
            }
        }
        return this.cachePath + '/' + str;
    }

    public final void ex(String str) {
        if (this.dqr != null) {
            this.dqr.closeDB();
        }
        if (this.dqq != null) {
            this.dqq.ex(str);
        }
        this.dql.onDataBaseClosed(this.dqq, this.dqr);
        this.dqw = false;
    }

    public final String DQ() {
        return this.cachePath + "MicroMsg.db";
    }

    public final String DR() {
        return this.cachePath + "EnMicroMsg.db";
    }

    public final SharedPreferences gh(String str) {
        g.Ek();
        g.Eg();
        int Df = a.Df();
        if (Df == 0) {
            return null;
        }
        if (this.dqy.containsKey(str)) {
            return (SharedPreferences) this.dqy.get(str);
        }
        try {
            String str2 = ad.getContext().getFilesDir().getParent() + "/shared_prefs/";
            String str3 = ad.chY() + str + Df + ".xml";
            String str4 = ad.chY() + str + Df + ".xml.bak";
            File file = new File(str2 + str3);
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(str2 + str4);
            if (file2.exists()) {
                file2.delete();
            }
        } catch (Exception e) {
        }
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences(ad.chY() + str + ac.ce(Df + ac.ce(String.valueOf(Df / 2))), 0);
        this.dqy.put(str, sharedPreferences);
        return sharedPreferences;
    }

    private static String DS() {
        String str = aa.duN;
        File file = new File(com.tencent.mm.compatible.util.e.bnC);
        com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "summer buildSysPath sysPath[" + str + "] SDCARD_ROOT[" + com.tencent.mm.compatible.util.e.bnC + "] file.exists:" + file.exists() + " CUtil.isSDCardAvail():" + com.tencent.mm.compatible.util.f.zZ());
        if (file.exists() && com.tencent.mm.compatible.util.f.zZ()) {
            if (cr(com.tencent.mm.compatible.util.e.bnE)) {
                str = com.tencent.mm.compatible.util.e.bnE;
            }
            file = new File(com.tencent.mm.compatible.util.e.dgl);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(com.tencent.mm.compatible.util.e.dgm);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(com.tencent.mm.compatible.util.e.dgn);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(com.tencent.mm.compatible.util.e.dgo);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(com.tencent.mm.compatible.util.e.dgm + ".nomedia");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.x.e("MMKernel.CoreStorage", "exception:%s", bi.i(e));
                }
            }
        }
        file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "summer buildSysPath ret sysPath: " + str);
        return str;
    }

    private static final boolean cr(String str) {
        if (bi.oW(str)) {
            com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "forceMkdirs absolutePath isNullOrNil ret false");
            return false;
        }
        File file = new File(str);
        com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "forceMkdirs absolutePath[%s], f.exists[%b], f.isDirectory[%b]", str, Boolean.valueOf(file.exists()), Boolean.valueOf(file.isDirectory()));
        if (file.exists() && file.isDirectory()) {
            com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "forceMkdirs f is dir and exist ret true");
            return true;
        }
        String[] split = str.split("/");
        if (split == null || split.length < 2) {
            com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "forceMkdirs absolutePath arr len illegal ret false");
            return false;
        }
        String str2 = "/";
        com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "forceMkdirs absolutePath arr len: " + split.length);
        for (int i = 0; i < split.length; i++) {
            if (!bi.oW(split[i])) {
                str2 = str2 + "/" + split[i];
                File file2 = new File(str2);
                if (file2.isFile() && !file2.renameTo(new File(str2 + "_mmbak"))) {
                    com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "forceMkdirs renameTo false ret false file[%s]", file2.getName());
                    return false;
                } else if (!(file2.exists() || file2.mkdir())) {
                    com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "forceMkdirs mkdir false ret false file[%s]", file2.getName());
                    return false;
                }
            }
        }
        com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "forceMkdirs false ret true");
        return true;
    }

    public final x DT() {
        g.Ek();
        g.Eg().Ds();
        return this.dqs;
    }

    public final bn DU() {
        g.Ek();
        g.Eg().Ds();
        return this.dqt;
    }

    public final void DV() {
        this.dqB = Boolean.valueOf(isSDCardAvailable());
    }

    public final boolean DW() {
        if (this.dqB == null) {
            this.dqB = Boolean.valueOf(isSDCardAvailable());
        } else {
            long currentTimeMillis = System.currentTimeMillis() - this.dqD;
            if (currentTimeMillis <= 0 || currentTimeMillis >= 1000) {
                if (this.dqA == null) {
                    this.dqA = new ag(g.Em().lnJ.getLooper());
                }
                this.dqA.removeCallbacksAndMessages(null);
                this.dqA.postDelayed(this.dqC, 1000);
                this.dqD = System.currentTimeMillis();
            }
        }
        return this.dqB.booleanValue();
    }

    public final boolean isSDCardAvailable() {
        boolean startsWith = this.dqo.startsWith(com.tencent.mm.compatible.util.e.bnC);
        long VF = bi.VF();
        long j = VF - this.dqz;
        if (startsWith) {
            g.Ek();
            if (g.Eg().Dx() && j > 0 && j < 1000 && new File(this.dqo).exists()) {
                return true;
            }
        }
        this.dqz = VF;
        boolean zZ = com.tencent.mm.compatible.util.f.zZ();
        r8 = new Object[6];
        g.Ek();
        g.Eg();
        r8[1] = o.getString(a.Df());
        r8[2] = Long.valueOf(j);
        r8[3] = this.dqo;
        r8[4] = com.tencent.mm.compatible.util.e.bnC;
        r8[5] = Boolean.valueOf(g.Eg().Dx());
        com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "isSDCardAvail:%b uin:%s toNow:%d sysPath:[%s] sdRoot:[%s], acc init:[%b]", r8);
        if (!zZ) {
            return false;
        }
        if (startsWith) {
            return true;
        }
        g.Ek();
        if (!g.Eg().Dx()) {
            return true;
        }
        com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "summer isSDCardAvailable accHasReady and remount");
        DX();
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void DX() {
        /*
        r7 = this;
        com.tencent.mm.kernel.g.Ek();
        r0 = com.tencent.mm.kernel.g.Eg();
        r1 = r0.dpo;
        monitor-enter(r1);
        r0 = DS();	 Catch:{ all -> 0x009c }
        r2 = "MMKernel.CoreStorage";
        r3 = "remount begin uin:%d oldpath:[%s] newPath:[%s] init:[%b]";
        r4 = 4;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x009c }
        r5 = 0;
        r6 = com.tencent.mm.kernel.a.Df();	 Catch:{ all -> 0x009c }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x009c }
        r4[r5] = r6;	 Catch:{ all -> 0x009c }
        r5 = 1;
        r6 = r7.dqo;	 Catch:{ all -> 0x009c }
        r4[r5] = r6;	 Catch:{ all -> 0x009c }
        r5 = 2;
        r4[r5] = r0;	 Catch:{ all -> 0x009c }
        r5 = 3;
        r6 = com.tencent.mm.kernel.g.Eg();	 Catch:{ all -> 0x009c }
        r6 = r6.Dx();	 Catch:{ all -> 0x009c }
        r6 = java.lang.Boolean.valueOf(r6);	 Catch:{ all -> 0x009c }
        r4[r5] = r6;	 Catch:{ all -> 0x009c }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);	 Catch:{ all -> 0x009c }
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r0);	 Catch:{ all -> 0x009c }
        if (r2 != 0) goto L_0x0142;
    L_0x0042:
        r2 = r7.dqo;	 Catch:{ all -> 0x009c }
        r2 = r0.equalsIgnoreCase(r2);	 Catch:{ all -> 0x009c }
        if (r2 == 0) goto L_0x00bb;
    L_0x004a:
        r0 = "MMKernel.CoreStorage";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0080 }
        r3 = "testSdcardWritable done ret:";
        r2.<init>(r3);	 Catch:{ Exception -> 0x0080 }
        r3 = DY();	 Catch:{ Exception -> 0x0080 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0080 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0080 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ Exception -> 0x0080 }
    L_0x0064:
        r0 = "MMKernel.CoreStorage";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x009f }
        r3 = "testSdcardReadable done ret:";
        r2.<init>(r3);	 Catch:{ Exception -> 0x009f }
        r3 = DZ();	 Catch:{ Exception -> 0x009f }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x009f }
        r2 = r2.toString();	 Catch:{ Exception -> 0x009f }
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ Exception -> 0x009f }
    L_0x007e:
        monitor-exit(r1);	 Catch:{ all -> 0x009c }
    L_0x007f:
        return;
    L_0x0080:
        r0 = move-exception;
        r2 = "MMKernel.CoreStorage";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009c }
        r4 = "testSdcardWritable Exception e: ";
        r3.<init>(r4);	 Catch:{ all -> 0x009c }
        r0 = r0.getMessage();	 Catch:{ all -> 0x009c }
        r0 = r3.append(r0);	 Catch:{ all -> 0x009c }
        r0 = r0.toString();	 Catch:{ all -> 0x009c }
        com.tencent.mm.sdk.platformtools.x.w(r2, r0);	 Catch:{ all -> 0x009c }
        goto L_0x0064;
    L_0x009c:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x009c }
        throw r0;
    L_0x009f:
        r0 = move-exception;
        r2 = "MMKernel.CoreStorage";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009c }
        r4 = "testSdcardReadable Exception e: ";
        r3.<init>(r4);	 Catch:{ all -> 0x009c }
        r0 = r0.getMessage();	 Catch:{ all -> 0x009c }
        r0 = r3.append(r0);	 Catch:{ all -> 0x009c }
        r0 = r0.toString();	 Catch:{ all -> 0x009c }
        com.tencent.mm.sdk.platformtools.x.w(r2, r0);	 Catch:{ all -> 0x009c }
        goto L_0x007e;
    L_0x00bb:
        r2 = "MMKernel.CoreStorage";
        r3 = "remount resetSysPath sysPath:[%s] newSysPath:[%s] accPath:[%s] cachePath: [%s]";
        r4 = 4;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x009c }
        r5 = 0;
        r6 = r7.dqo;	 Catch:{ all -> 0x009c }
        r4[r5] = r6;	 Catch:{ all -> 0x009c }
        r5 = 1;
        r4[r5] = r0;	 Catch:{ all -> 0x009c }
        r5 = 2;
        r6 = r7.dqp;	 Catch:{ all -> 0x009c }
        r4[r5] = r6;	 Catch:{ all -> 0x009c }
        r5 = 3;
        r6 = r7.cachePath;	 Catch:{ all -> 0x009c }
        r4[r5] = r6;	 Catch:{ all -> 0x009c }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);	 Catch:{ all -> 0x009c }
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r0);	 Catch:{ all -> 0x009c }
        if (r2 != 0) goto L_0x0122;
    L_0x00df:
        r7.dqo = r0;	 Catch:{ all -> 0x009c }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009c }
        r2 = "mm";
        r0.<init>(r2);	 Catch:{ all -> 0x009c }
        com.tencent.mm.kernel.g.Ek();	 Catch:{ all -> 0x009c }
        com.tencent.mm.kernel.g.Eg();	 Catch:{ all -> 0x009c }
        r2 = com.tencent.mm.kernel.a.Df();	 Catch:{ all -> 0x009c }
        r0 = r0.append(r2);	 Catch:{ all -> 0x009c }
        r0 = r0.toString();	 Catch:{ all -> 0x009c }
        r0 = r0.getBytes();	 Catch:{ all -> 0x009c }
        r0 = com.tencent.mm.a.g.u(r0);	 Catch:{ all -> 0x009c }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009c }
        r2.<init>();	 Catch:{ all -> 0x009c }
        r3 = r7.dqo;	 Catch:{ all -> 0x009c }
        r2 = r2.append(r3);	 Catch:{ all -> 0x009c }
        r0 = r2.append(r0);	 Catch:{ all -> 0x009c }
        r2 = "/";
        r0 = r0.append(r2);	 Catch:{ all -> 0x009c }
        r0 = r0.toString();	 Catch:{ all -> 0x009c }
        r7.dqp = r0;	 Catch:{ all -> 0x009c }
        r7.DO();	 Catch:{ all -> 0x009c }
    L_0x0122:
        r0 = com.tencent.mm.kernel.a.c.Et();	 Catch:{ all -> 0x009c }
        r0 = r0.drz;	 Catch:{ all -> 0x009c }
        r0.Ep();	 Catch:{ all -> 0x009c }
        r0 = "MMKernel.CoreStorage";
        r2 = "remout isSDCardAvail :[%b] done";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x009c }
        r4 = 0;
        r5 = com.tencent.mm.compatible.util.f.zZ();	 Catch:{ all -> 0x009c }
        r5 = java.lang.Boolean.valueOf(r5);	 Catch:{ all -> 0x009c }
        r3[r4] = r5;	 Catch:{ all -> 0x009c }
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r3);	 Catch:{ all -> 0x009c }
    L_0x0142:
        monitor-exit(r1);	 Catch:{ all -> 0x009c }
        goto L_0x007f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.kernel.e.DX():void");
    }

    private static boolean DY() {
        boolean canWrite;
        Exception e;
        Throwable th;
        boolean z = false;
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        boolean equalsIgnoreCase = com.tencent.mm.compatible.util.e.bnC.equalsIgnoreCase(absolutePath);
        boolean equals = Environment.getExternalStorageState().equals("mounted");
        try {
            canWrite = new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canWrite();
        } catch (Exception e2) {
            com.tencent.mm.sdk.platformtools.x.w("MMKernel.CoreStorage", "testSdcardWritable 1 e: " + e2.getMessage());
            canWrite = false;
        }
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "test_writable");
        FileOutputStream fileOutputStream;
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write("test".getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
                boolean delete = file.delete();
                try {
                    fileOutputStream.close();
                    z = delete;
                } catch (Throwable e3) {
                    com.tencent.mm.sdk.platformtools.x.e("MMKernel.CoreStorage", "exception:%s", bi.i(e3));
                    z = delete;
                }
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
            try {
                com.tencent.mm.sdk.platformtools.x.w("MMKernel.CoreStorage", "testSdcardWritable 2 e: " + e.getMessage());
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e6) {
                        com.tencent.mm.sdk.platformtools.x.e("MMKernel.CoreStorage", "exception:%s", bi.i(e6));
                    }
                }
                com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + absolutePath + " CConstants.SDCARD_ROOT: " + com.tencent.mm.compatible.util.e.bnC + " isPrimaryExtStg: " + equalsIgnoreCase + " mounted: " + equals + " canWrite: " + canWrite + " canTrueWrite:" + z);
                return z;
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e62) {
                        com.tencent.mm.sdk.platformtools.x.e("MMKernel.CoreStorage", "exception:%s", bi.i(e62));
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable e622) {
                    com.tencent.mm.sdk.platformtools.x.e("MMKernel.CoreStorage", "exception:%s", bi.i(e622));
                }
            }
            throw th;
        }
        com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + absolutePath + " CConstants.SDCARD_ROOT: " + com.tencent.mm.compatible.util.e.bnC + " isPrimaryExtStg: " + equalsIgnoreCase + " mounted: " + equals + " canWrite: " + canWrite + " canTrueWrite:" + z);
        return z;
    }

    private static boolean DZ() {
        boolean canRead;
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        boolean equalsIgnoreCase = com.tencent.mm.compatible.util.e.bnC.equalsIgnoreCase(absolutePath);
        boolean equals = Environment.getExternalStorageState().equals("mounted");
        try {
            canRead = new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canRead();
        } catch (Exception e) {
            Exception exception = e;
            canRead = false;
            com.tencent.mm.sdk.platformtools.x.w("MMKernel.CoreStorage", "testSdcardReadable 1 e: " + exception.getMessage());
        }
        File file = new File(com.tencent.mm.compatible.util.e.bnE);
        boolean exists = file.exists();
        if (exists) {
            com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "testSdcardReadable testFile isDirectory:" + file.isDirectory() + " isFile:" + file.isFile());
        }
        com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + absolutePath + " CConstants.SDCARD_ROOT: " + com.tencent.mm.compatible.util.e.bnC + " CConstants.DATAROOT_SDCARD_PATH: " + com.tencent.mm.compatible.util.e.bnE + " isPrimaryExtStg: " + equalsIgnoreCase + " mounted: " + equals + " canRead: " + canRead + " canTrueRead:" + exists);
        return exists;
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("CONFIG_TABLE".hashCode()), new d() {
            public final String[] xb() {
                return x.diD;
            }
        });
        cVM.put(Integer.valueOf("TablesVersion".hashCode()), new d() {
            public final String[] xb() {
                return bt.diD;
            }
        });
    }

    static HashMap<Integer, d> Ci() {
        HashMap<Integer, d> hashMap = new HashMap();
        hashMap.putAll(cVM);
        return hashMap;
    }
}
