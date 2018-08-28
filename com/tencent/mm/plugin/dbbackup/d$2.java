package com.tencent.mm.plugin.dbbackup;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.a.g;
import com.tencent.mm.ak.o;
import com.tencent.mm.bt.f;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vfs.b;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.repair.RecoverKit;

class d$2 implements Runnable {
    final /* synthetic */ b iaa;
    final /* synthetic */ c iab;
    final /* synthetic */ d iam;
    final /* synthetic */ String ian;
    final /* synthetic */ long iao;

    d$2(d dVar, c cVar, String str, long j, b bVar) {
        this.iam = dVar;
        this.iab = cVar;
        this.ian = str;
        this.iao = j;
        this.iaa = bVar;
    }

    public final void run() {
        Throwable e;
        int i;
        int i2;
        Throwable e2;
        d.a(this.iam, null);
        SQLiteDatabase openDatabase;
        try {
            c.FT();
            c.FW();
            o.Pf();
            com.tencent.mm.modelvideo.o.Ta();
            long nanoTime = System.nanoTime();
            byte[] bytes = (q.zy() + c.Df()).getBytes();
            byte[] v = g.v(bytes);
            byte[] bytes2 = g.u(bytes).substring(0, 7).getBytes();
            int i3 = 268435456;
            if (f.cnW()) {
                i3 = 805306368;
            }
            openDatabase = SQLiteDatabase.openDatabase(c.FO().coa().getPath(), bytes2, d.aCH(), null, i3, null, 0);
            try {
                String[] strArr;
                if (this.ian != null) {
                    strArr = new String[]{this.ian};
                } else {
                    String[] strArr2 = new String[2];
                    strArr2[0] = c.DP() + ".bak";
                    StringBuilder stringBuilder = new StringBuilder();
                    com.tencent.mm.kernel.g.Ek();
                    strArr2[1] = stringBuilder.append(com.tencent.mm.kernel.g.Ei().dqp).append("dbback/EnMicroMsg.db.bak").toString();
                    strArr = strArr2;
                }
                try {
                    String str;
                    int length = strArr.length;
                    int i4 = 0;
                    int i5 = -3;
                    long j = 0;
                    while (i4 < length) {
                        try {
                            str = strArr[i4];
                            try {
                                b bVar = new b(str);
                                if (bVar.canRead()) {
                                    j = bVar.length();
                                    x.i("MicroMsg.SubCoreDBBackup", "[Recover] backupSize: %d, diskFreeSpace: %d", new Object[]{Long.valueOf(j), Long.valueOf(this.iao)});
                                    if (this.iao >= 10 * j) {
                                        h hVar = h.mEJ;
                                        Object[] objArr = new Object[2];
                                        objArr[0] = Integer.valueOf(10004);
                                        objArr[1] = String.format("%d|%d", new Object[]{Long.valueOf(j), Long.valueOf(this.iao)});
                                        hVar.h(11098, objArr);
                                        d.a(this.iam, new RecoverKit(openDatabase, str, v));
                                        break;
                                    }
                                    if (this.iaa != null) {
                                        this.iaa.ov(-2);
                                    }
                                    if (d.d(this.iam) != null) {
                                        d.d(this.iam).release();
                                        d.a(this.iam, null);
                                    }
                                    if (openDatabase != null) {
                                        openDatabase.close();
                                    }
                                    d.c(this.iam);
                                    au.Em().cik();
                                    return;
                                }
                                continue;
                                i4++;
                            } catch (Exception e3) {
                                x.e("MicroMsg.SubCoreDBBackup", "Initialize RecoverKit failed: " + e3.getMessage());
                                i5 = -1;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            i = i5;
                        }
                    }
                    if (d.d(this.iam) == null) {
                        i2 = -3;
                        try {
                            h.mEJ.a(181, 31, 1, true);
                            throw new RuntimeException();
                        } catch (Throwable e22) {
                            e = e22;
                            i = i2;
                            try {
                                x.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to start database recovery", new Object[0]);
                                if (this.iaa != null) {
                                    this.iaa.ov(i);
                                }
                                h.mEJ.a(181, 23, 1, true);
                                if (d.d(this.iam) != null) {
                                    d.d(this.iam).release();
                                    d.a(this.iam, null);
                                }
                                if (openDatabase != null) {
                                    openDatabase.close();
                                }
                                d.c(this.iam);
                                au.Em().cik();
                            } catch (Throwable th) {
                                e22 = th;
                                if (d.d(this.iam) != null) {
                                    d.d(this.iam).release();
                                    d.a(this.iam, null);
                                }
                                if (openDatabase != null) {
                                    openDatabase.close();
                                }
                                d.c(this.iam);
                                au.Em().cik();
                                throw e22;
                            }
                        }
                    }
                    int i6;
                    i2 = d.d(this.iam).run(false);
                    d.aCF();
                    long nanoTime2 = System.nanoTime() - nanoTime;
                    int successCount = d.d(this.iam).successCount();
                    length = d.d(this.iam).failureCount();
                    String lastError = d.d(this.iam).lastError();
                    d.d(this.iam).release();
                    d.a(this.iam, null);
                    openDatabase.close();
                    openDatabase = null;
                    str = "MicroMsg.SubCoreDBBackup";
                    String str2 = "Database recover %s, elapsed %.2f seconds. [success: %d, failure: %d]";
                    Object[] objArr2 = new Object[4];
                    String str3 = i2 == 0 ? "succeeded" : i2 == 1 ? "canceled" : "failed";
                    objArr2[0] = str3;
                    objArr2[1] = Float.valueOf(((float) nanoTime2) / 1.0E9f);
                    objArr2[2] = Integer.valueOf(successCount);
                    objArr2[3] = Integer.valueOf(length);
                    x.i(str, str2, objArr2);
                    if (i2 == 0) {
                        i6 = 10005;
                        i5 = 22;
                    } else if (i2 == 1) {
                        i6 = 10006;
                        i5 = -1;
                    } else {
                        i6 = CdnLogic.kMediaTypeFavoriteBigFile;
                        i5 = 23;
                        h.mEJ.c("DBRepair", "Backup recover failed: " + lastError, null);
                    }
                    h hVar2 = h.mEJ;
                    objArr2 = new Object[2];
                    objArr2[0] = Integer.valueOf(i6);
                    objArr2[1] = String.format("%d|%d|%d|%d", new Object[]{Long.valueOf(j), Long.valueOf(nanoTime2 / 1000000), Integer.valueOf(successCount), Integer.valueOf(length)});
                    hVar2.h(11098, objArr2);
                    if (i5 >= 0) {
                        h.mEJ.a(181, (long) i5, 1, true);
                    }
                    if (this.iaa != null) {
                        this.iaa.ov(i2);
                    }
                    if (d.d(this.iam) != null) {
                        d.d(this.iam).release();
                        d.a(this.iam, null);
                    }
                    d.c(this.iam);
                    au.Em().cik();
                } catch (Throwable e222) {
                    e = e222;
                    i = -3;
                    x.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to start database recovery", new Object[0]);
                    if (this.iaa != null) {
                        this.iaa.ov(i);
                    }
                    h.mEJ.a(181, 23, 1, true);
                    if (d.d(this.iam) != null) {
                        d.d(this.iam).release();
                        d.a(this.iam, null);
                    }
                    if (openDatabase != null) {
                        openDatabase.close();
                    }
                    d.c(this.iam);
                    au.Em().cik();
                }
            } catch (Throwable e2222) {
                e = e2222;
                i = -1;
                x.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to start database recovery", new Object[0]);
                if (this.iaa != null) {
                    this.iaa.ov(i);
                }
                h.mEJ.a(181, 23, 1, true);
                if (d.d(this.iam) != null) {
                    d.d(this.iam).release();
                    d.a(this.iam, null);
                }
                if (openDatabase != null) {
                    openDatabase.close();
                }
                d.c(this.iam);
                au.Em().cik();
            }
        } catch (Throwable e22222) {
            e = e22222;
            openDatabase = null;
            i = -1;
            x.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to start database recovery", new Object[0]);
            if (this.iaa != null) {
                this.iaa.ov(i);
            }
            h.mEJ.a(181, 23, 1, true);
            if (d.d(this.iam) != null) {
                d.d(this.iam).release();
                d.a(this.iam, null);
            }
            if (openDatabase != null) {
                openDatabase.close();
            }
            d.c(this.iam);
            au.Em().cik();
        } catch (Throwable th2) {
            e22222 = th2;
            openDatabase = null;
            if (d.d(this.iam) != null) {
                d.d(this.iam).release();
                d.a(this.iam, null);
            }
            if (openDatabase != null) {
                openDatabase.close();
            }
            d.c(this.iam);
            au.Em().cik();
            throw e22222;
        }
    }
}
