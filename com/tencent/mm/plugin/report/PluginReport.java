package com.tencent.mm.plugin.report;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.matrix.mrs.core.MatrixReport.Builder;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.report.service.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mrs.a.a;
import com.tencent.mrs.util.MatrixReportBroadcast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PluginReport extends f implements b, c, c {
    private p mDx;

    public void installed() {
        alias(c.class);
    }

    public void dependency() {
        dependsOn(o.class);
    }

    public void configure(g gVar) {
        if (ad.cic()) {
            x.i("Matrix.PluginReport", "load matrixmrs so");
            k.b("matrixmrs", PluginReport.class.getClassLoader());
        }
        this.mDx = new p(j.class);
        com.tencent.mm.kernel.g.a(p.class, new e(this.mDx));
        f fVar = f.mDy;
        x.i("MicroMsg.ReportService", "instance set %s", h.mEJ);
        fVar.mDz = r3;
        MatrixReport.setMrsCallback(new a());
        Context context = gVar.dsQ;
        com.tencent.matrix.a.a(new com.tencent.matrix.d.b.a() {
            public final void v(String str, String str2, Object... objArr) {
                x.v(str, str2, objArr);
            }

            public final void i(String str, String str2, Object... objArr) {
                x.i(str, str2, objArr);
            }

            public final void w(String str, String str2, Object... objArr) {
                x.w(str, str2, objArr);
            }

            public final void d(String str, String str2, Object... objArr) {
                x.d(str, str2, objArr);
            }

            public final void e(String str, String str2, Object... objArr) {
                x.e(str, str2, objArr);
            }

            public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                x.printErrStackTrace(str, th, str2, objArr);
            }
        });
        boolean z = d.sFx && !com.tencent.mm.protocal.d.qVO;
        com.tencent.matrix.a.a aVar = new com.tencent.matrix.a.a(context);
        com.tencent.matrix.trace.a.a.a aVar2 = new com.tencent.matrix.trace.a.a.a();
        aVar2.bth = false;
        aVar2.btg = z;
        aVar.a(new com.tencent.matrix.trace.a(new com.tencent.matrix.trace.a.a(aVar2.btg, aVar2.bth, aVar2.btj, aVar2.btk, aVar2.btm, aVar2.bto, aVar2.btl, aVar2.bti, aVar2.btp, (byte) 0)));
        com.tencent.matrix.resource.b.a.a aVar3 = new com.tencent.matrix.resource.b.a.a();
        aVar3.brx = com.tencent.mm.sdk.a.b.chn();
        aVar.a(new com.tencent.matrix.resource.c(new com.tencent.matrix.resource.b.a(aVar3.brv, aVar3.brw, aVar3.brx, (byte) 0)));
        aVar.a(new com.tencent.matrix.a.a(new com.tencent.matrix.a.a.a.a().em(1).em(4).em(8).th()));
        com.tencent.matrix.resource.c.a(context);
        aVar.a(new com.tencent.matrix.iocanary.a());
        aVar.a(new com.tencent.sqlitelint.h(new com.tencent.sqlitelint.a.a(com.tencent.sqlitelint.e.c.vnq)));
        com.tencent.mrs.a.uZP = new com.tencent.mrs.b.a(context);
        aVar.boU = com.tencent.mrs.a.uZP;
        if (aVar.boU == null) {
            aVar.boU = new com.tencent.matrix.b.a(aVar.application);
        }
        com.tencent.matrix.a.a(new com.tencent.matrix.a(aVar.application, aVar.boU, aVar.boT, (byte) 0));
        ((com.tencent.matrix.trace.a) com.tencent.matrix.a.tg().g(com.tencent.matrix.trace.a.class)).start();
        if (z) {
            ((com.tencent.matrix.resource.c) com.tencent.matrix.a.tg().g(com.tencent.matrix.resource.c.class)).start();
        }
    }

    public void execute(g gVar) {
        if (com.tencent.matrix.a.isInstalled()) {
            com.tencent.matrix.d.b.i("Matrix.Manager", "try to init matrix report", new Object[0]);
            MatrixReport.init(new Builder(ad.getContext()).clientVersion((long) com.tencent.mm.protocal.d.qVN).isDebug(false).revision(d.REV).processName(ad.getProcessName()).isReportProcess(ad.cic()).build());
            return;
        }
        com.tencent.matrix.d.b.e("Matrix.Manager", "init matrix report, matrix is not installed, just return", new Object[0]);
    }

    public List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"logcat/"});
        return linkedList;
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        if (MatrixReport.isInstalled()) {
            com.tencent.matrix.d.b.i("Matrix.Manager", "matrix report set the uin", new Object[0]);
            MatrixReport with = MatrixReport.with();
            com.tencent.mm.kernel.g.Eg();
            with.setUin((long) com.tencent.mm.kernel.a.Df());
            com.tencent.mrs.b.a aVar = com.tencent.mrs.a.uZP;
            Looper.getMainLooper();
            Looper.myQueue().addIdleHandler(new IdleHandler() {
                public final boolean queueIdle() {
                    for (String str : a.this.uZW.keySet()) {
                        com.tencent.matrix.d.b.i("Matrix.PluginListener", "matrix report pending issues tag:%s, size:%d", str, Integer.valueOf(((ArrayList) a.this.uZW.get((String) r2.next())).size()));
                        Iterator it = r1.iterator();
                        while (it.hasNext()) {
                            com.tencent.matrix.c.b bVar = (com.tencent.matrix.c.b) it.next();
                            MatrixReport.with().report(bVar.tag, bVar.brm);
                        }
                    }
                    a.this.uZW.clear();
                    return false;
                }
            });
            MatrixReportBroadcast.cEa();
            return;
        }
        com.tencent.matrix.d.b.e("Matrix.Manager", "setUin, matrix report is not installed, just return", new Object[0]);
    }

    public void onAccountRelease() {
    }

    public String toString() {
        return "plugin-report";
    }
}
