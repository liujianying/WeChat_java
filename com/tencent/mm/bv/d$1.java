package com.tencent.mm.bv;

import android.os.Debug;
import android.os.Process;
import com.tencent.mm.a.p;
import com.tencent.mm.bv.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

class d$1 implements Runnable {
    final /* synthetic */ a tfJ;
    final /* synthetic */ d tfK;

    d$1(d dVar, a aVar) {
        this.tfK = dVar;
        this.tfJ = aVar;
    }

    public final void run() {
        try {
            Debug.stopMethodTracing();
            String str = this.tfJ.savePath;
            int i = this.tfJ.tfM;
            if (this.tfJ.savePath == null) {
                d.b(this.tfK);
                return;
            }
            File file = new File(str);
            File file2 = new File(str.substring(0, str.lastIndexOf(46)) + ".snapshot");
            long currentTimeMillis = System.currentTimeMillis();
            file.renameTo(file2);
            file.delete();
            x.i("MicroMsg.TraceDebugManager", "TRACE xorEn last :" + (System.currentTimeMillis() - currentTimeMillis));
            Process.setThreadPriority(10);
            if (this.tfJ.ccC == 6) {
                Collection arrayList = new ArrayList();
                arrayList.add(file2);
                try {
                    p.a(arrayList, new File(file2.getAbsolutePath() + ".zip"));
                    d.dvh.sendEmptyMessage(1);
                    d.b(this.tfK);
                    return;
                } catch (Throwable e) {
                    x.e("MicroMsg.TraceDebugManager", "exception:%s", bi.i(e));
                    x.e("MicroMsg.TraceDebugManager", "zip file failed msg:%s ", e.getMessage());
                    d.b(this.tfK);
                    return;
                }
            }
            if (d.a(this.tfK) == null || d.a(this.tfK).size() == 0) {
                str = d.T(file2);
                if (!bi.oW(str)) {
                    d dVar = this.tfK;
                    if (i == 1 || (i == 3 && ao.isWifi(ad.getContext()))) {
                        dVar.ZP(str);
                    }
                }
            }
            d.b(this.tfK);
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.Crash", e2, "May cause dvmFindCatchBlock crash!", new Object[0]);
            throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2));
        } catch (Throwable th) {
            d.b(this.tfK);
        }
    }
}
