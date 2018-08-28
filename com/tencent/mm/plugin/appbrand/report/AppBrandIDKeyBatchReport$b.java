package com.tencent.mm.plugin.appbrand.report;

import android.os.Build;
import com.tencent.mm.a.e;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.protocal.c.bgq;
import com.tencent.mm.protocal.c.cgp;
import com.tencent.mm.protocal.c.cgq;
import com.tencent.mm.protocal.c.cgu;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

final class AppBrandIDKeyBatchReport$b {
    private static final ReentrantReadWriteLock gqD = new ReentrantReadWriteLock();
    private static volatile al gqE = null;
    private static volatile al gqF = null;
    private static volatile int gqG;

    static /* synthetic */ void Jv() {
        boolean z;
        final LinkedList amz = amz();
        if (bi.cX(amz)) {
            z = false;
        } else {
            a aVar = new a();
            aVar.dIG = new cgp();
            aVar.dIH = new cgq();
            aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/wxaappidkeybatchreport";
            aVar.dIF = 1009;
            aVar.dII = 0;
            aVar.dIJ = 0;
            b KT = aVar.KT();
            bgq bgq = new bgq();
            bgq.hcq = Build.MANUFACTURER;
            bgq.shA = 2;
            bgq.rjL = d.qVI;
            bgq.rjM = d.qVH;
            bgq.ngG = ad.getResources().getDisplayMetrics().widthPixels;
            bgq.shB = ad.getResources().getDisplayMetrics().heightPixels;
            bgq.rjN = d.qVK;
            bgq.rjO = d.qVL;
            bgq.shC = ad.getResources().getConfiguration().locale.getLanguage();
            ((cgp) KT.dID.dIL).sAP = bgq;
            ((cgp) KT.dID.dIL).sAO = amz;
            v.a(KT, new v.a() {
                public final int a(int i, int i2, String str, b bVar, l lVar) {
                    if (i == 0 && i2 == 0) {
                        AppBrandIDKeyBatchReport$b.gqG = ((cgq) bVar.dIE.dIL).sAQ;
                        AppBrandIDKeyBatchReport$b.hl(AppBrandIDKeyBatchReport$b.gqG);
                    } else {
                        Iterator it = amz.iterator();
                        while (it.hasNext()) {
                            AppBrandIDKeyBatchReport$b.d((cgu) it.next());
                        }
                    }
                    return 0;
                }
            }, true);
            z = true;
        }
        if (z) {
            int i = gqG;
            i = i <= 0 ? 300000 : (i + 5) * 60000;
            if (gqF != null) {
                gqF.SO();
                gqF = null;
            }
            al alVar = new al(new 1(), false);
            gqF = alVar;
            long j = (long) i;
            alVar.J(j, j);
        }
    }

    static /* synthetic */ void c(cgu cgu) {
        if (cgu != null) {
            c.Em().H(new 4(cgu));
        }
    }

    static /* synthetic */ void d(cgu cgu) {
        gqD.writeLock().lock();
        try {
            byte[] toByteArray = cgu.toByteArray();
            File file = new File(AppBrandIDKeyBatchReport.amw());
            if (!file.exists()) {
                file.mkdir();
            }
            file = new File(AppBrandIDKeyBatchReport.amx());
            if (!file.exists()) {
                file.createNewFile();
            }
            int length = toByteArray.length;
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new DataOutputStream(byteArrayOutputStream).writeInt(length);
            e.e(AppBrandIDKeyBatchReport.amx(), byteArrayOutputStream.toByteArray());
            e.e(AppBrandIDKeyBatchReport.amx(), toByteArray);
        } catch (Throwable e) {
            x.e("MicroMsg.AppBrandIDKeyBatchReport", "appendToFile exception:%s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", e, "", new Object[0]);
        } finally {
            gqD.writeLock().unlock();
        }
    }

    static /* synthetic */ void hl(int i) {
        int i2 = 60000;
        if (i > 0) {
            i2 = 60000 * i;
        }
        amy();
        al alVar = new al(new 2(), true);
        gqE = alVar;
        long j = (long) i2;
        alVar.J(j, j);
    }

    private static void amy() {
        if (gqE != null) {
            gqE.SO();
            gqE = null;
        }
    }

    private static LinkedList<cgu> amz() {
        ReadLock readLock = null;
        int i = 0;
        gqD.readLock().lock();
        try {
            File file = new File(AppBrandIDKeyBatchReport.amx());
            if (file.exists()) {
                LinkedList<cgu> linkedList = new LinkedList();
                long length = file.length();
                while (true) {
                    int i2 = i;
                    byte[] e = e.e(AppBrandIDKeyBatchReport.amx(), i2, 4);
                    if (e != null) {
                        int readInt = new DataInputStream(new ByteArrayInputStream(e)).readInt();
                        e = e.e(AppBrandIDKeyBatchReport.amx(), i2 + 4, readInt);
                        if (bi.bC(e)) {
                            break;
                        }
                        linkedList.add((cgu) new cgu().aG(e));
                        i = (readInt + 4) + i2;
                        if (((long) i) >= length) {
                            break;
                        }
                    } else {
                        x.e("MicroMsg.AppBrandIDKeyBatchReport", "preData is null!");
                        gqD.readLock().unlock();
                        amA();
                        return null;
                    }
                }
                gqD.readLock().unlock();
                amA();
                return linkedList;
            }
            x.d("MicroMsg.AppBrandIDKeyBatchReport", "reportFile not exist!");
            return readLock;
        } catch (Throwable e2) {
            x.e("MicroMsg.AppBrandIDKeyBatchReport", "read file error %s", new Object[]{e2.getMessage()});
            x.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", e2, "readReportData()", new Object[0]);
            return readLock;
        } finally {
            readLock = gqD.readLock();
            readLock.unlock();
            amA();
        }
    }

    private static void amA() {
        gqD.writeLock().lock();
        try {
            e.deleteFile(AppBrandIDKeyBatchReport.amx());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", e, "removeFile()", new Object[0]);
        }
        gqD.writeLock().unlock();
    }
}
