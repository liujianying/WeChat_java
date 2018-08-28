package com.tencent.mm.plugin.dbbackup;

import com.tencent.mm.a.g;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.d;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.repair.BackupKit;
import com.tencent.wcdb.repair.RepairKit.MasterInfo;
import java.util.Date;

class d$1 implements Runnable {
    final /* synthetic */ String hZx;
    final /* synthetic */ b iaa;
    final /* synthetic */ c iab;
    final /* synthetic */ String iac;
    final /* synthetic */ boolean iad;
    final /* synthetic */ SQLiteDatabase iae;
    final /* synthetic */ String iaf;
    final /* synthetic */ String iag;
    final /* synthetic */ long[] iah;
    final /* synthetic */ long[] iai;
    final /* synthetic */ int iaj;
    final /* synthetic */ String[] iak;
    final /* synthetic */ String ial;
    final /* synthetic */ d iam;

    d$1(d dVar, b bVar, c cVar, String str, boolean z, SQLiteDatabase sQLiteDatabase, String str2, String str3, String str4, long[] jArr, long[] jArr2, int i, String[] strArr, String str5) {
        this.iam = dVar;
        this.iaa = bVar;
        this.iab = cVar;
        this.iac = str;
        this.iad = z;
        this.iae = sQLiteDatabase;
        this.iaf = str2;
        this.hZx = str3;
        this.iag = str4;
        this.iah = jArr;
        this.iai = jArr2;
        this.iaj = i;
        this.iak = strArr;
        this.ial = str5;
    }

    public final void run() {
        if (d.a(this.iam)) {
            d.a(this.iam, null);
            try {
                String str;
                int i;
                int i2;
                long nanoTime = System.nanoTime();
                byte[] v = g.v((q.zy() + c.Df()).getBytes());
                b bVar = new b(this.iac);
                if (!(this.iad && bVar.exists())) {
                    boolean a;
                    boolean save = MasterInfo.save(this.iae, this.iaf, v);
                    b bVar2 = new b(this.iaf);
                    if (save) {
                        bVar.delete();
                        a = bVar2.a(bVar);
                    } else {
                        bVar2.delete();
                        a = save;
                    }
                    long nanoTime2 = System.nanoTime() - nanoTime;
                    str = "MicroMsg.SubCoreDBBackup";
                    String str2 = "Master table backup %s, elapsed %.3f";
                    Object[] objArr = new Object[2];
                    objArr[0] = a ? "SUCCEEDED" : "FAILED";
                    objArr[1] = Float.valueOf(((float) nanoTime2) / 1.0E9f);
                    x.i(str, str2, objArr);
                    h.mEJ.a(181, a ? 24 : 25, 1, false);
                }
                long length = new b(this.hZx).length();
                long length2 = new b(this.iag).length();
                String str3 = "MicroMsg.SubCoreDBBackup";
                String str4 = "Backup started [%s, cursor: %d ~ %d]";
                Object[] objArr2 = new Object[3];
                objArr2[0] = this.iad ? "incremental" : "new";
                objArr2[1] = Long.valueOf(this.iah != null ? this.iah[0] : 0);
                objArr2[2] = Long.valueOf(this.iai[0]);
                x.i(str3, str4, objArr2);
                int i3 = this.iad ? 10011 : 10000;
                h hVar = h.mEJ;
                Object[] objArr3 = new Object[2];
                objArr3[0] = Integer.valueOf(i3);
                objArr3[1] = String.format("%d|%d|%s", new Object[]{Long.valueOf(length), Long.valueOf(length2), this.iam.hZW.format(new Date())});
                hVar.h(11098, objArr3);
                d.a(this.iam, new BackupKit(this.iae, this.iag, v, this.iaj, this.iak));
                int run = d.b(this.iam).run();
                nanoTime = System.nanoTime() - nanoTime;
                b bVar3 = new b(this.iag);
                long length3 = bVar3.length();
                if (run == 0) {
                    d.b(this.hZx, this.iai);
                    bVar = new b(this.ial);
                    bVar.delete();
                    bVar3.a(bVar);
                    if (this.iad) {
                        i = 10012;
                        i2 = 19;
                    } else {
                        i = 10001;
                        i2 = 16;
                    }
                } else {
                    bVar3.delete();
                    if (run == 1) {
                        if (this.iad) {
                            i = 10013;
                            i2 = 20;
                        } else {
                            i = 10002;
                            i2 = 17;
                        }
                    } else if (this.iad) {
                        i = 10014;
                        i2 = 21;
                    } else {
                        i = 10003;
                        i2 = 18;
                    }
                }
                str = "MicroMsg.SubCoreDBBackup";
                str3 = "Database %s backup %s, elapsed %.2f seconds.";
                objArr3 = new Object[3];
                objArr3[0] = this.iad ? "incremental" : "new";
                String str5 = run == 0 ? "succeeded" : run == 1 ? "canceled" : "failed";
                objArr3[1] = str5;
                objArr3[2] = Float.valueOf(((float) nanoTime) / 1.0E9f);
                x.i(str, str3, objArr3);
                h.mEJ.a(181, (long) i2, 1, false);
                h hVar2 = h.mEJ;
                Object[] objArr4 = new Object[2];
                objArr4[0] = Integer.valueOf(i);
                objArr4[1] = String.format("%d|%d|%d|%d|%d|%s", new Object[]{Long.valueOf(length), Long.valueOf(length2), Long.valueOf(length3), Integer.valueOf(d.b(this.iam).statementCount()), Long.valueOf(nanoTime / 1000000), this.iam.hZW.format(new Date())});
                hVar2.h(11098, objArr4);
                if (this.iaa != null) {
                    this.iaa.ov(run);
                }
                d.b(this.iam).release();
                d.a(this.iam, null);
                StringBuilder stringBuilder = new StringBuilder();
                com.tencent.mm.kernel.g.Ek();
                d.mL(stringBuilder.append(com.tencent.mm.kernel.g.Ei().dqp).append("dbback").toString());
                str5 = this.iac;
                StringBuilder stringBuilder2 = new StringBuilder();
                com.tencent.mm.kernel.g.Ek();
                d.y(str5, stringBuilder2.append(com.tencent.mm.kernel.g.Ei().dqp).append("dbback/EnMicroMsg.db.sm").toString());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to start database backup, path: %s", new Object[]{this.hZx});
                if (this.iaa != null) {
                    this.iaa.ov(-1);
                }
                h.mEJ.a(181, this.iad ? 18 : 21, 1, false);
            } finally {
                if (d.b(this.iam) != null) {
                    d.b(this.iam).release();
                    d.a(this.iam, null);
                }
                d.c(this.iam);
            }
        } else if (this.iaa != null) {
            this.iaa.ov(1);
        }
    }
}
