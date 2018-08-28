package com.tencent.mm.model.d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.PackageManager;
import android.os.Process;
import android.util.Base64;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.d.a.5;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class a$4 implements Runnable {
    final /* synthetic */ a dFa;

    public a$4(a aVar) {
        this.dFa = aVar;
    }

    public final void run() {
        File file = new File(a.access$1300());
        if (!file.exists()) {
            x.w("MicroMsg.HandlerTraceManager", "summer handler trace file is not exists");
        } else if (g.Eg().Dx()) {
            long j = a.k(this.dFa).getLong("handler_report_lastUploadTime", 0);
            long currentTimeMillis = System.currentTimeMillis();
            Object obj = (currentTimeMillis - j > a.l(this.dFa) || j > currentTimeMillis) ? 1 : null;
            if (a.i(this.dFa) && obj != null) {
                x.i("MicroMsg.HandlerTraceManager", "summer check need upload ,file size is %d,time out %b", new Object[]{Long.valueOf(file.length()), Boolean.valueOf(true)});
                a aVar = this.dFa;
                Context context = ad.getContext();
                String packageName = ad.getContext().getPackageName();
                try {
                    PackageManager.class.getMethod("getPackageSizeInfo", new Class[]{String.class, IPackageStatsObserver.class}).invoke(context.getPackageManager(), new Object[]{packageName, new 5(aVar)});
                } catch (Exception e) {
                    aVar.byR[0] = -1;
                    aVar.byR[1] = -1;
                    aVar.byR[2] = -1;
                }
                if (a.m(this.dFa)[1] != 0 || a.n(this.dFa) > 1) {
                    if (file.length() > a.o(this.dFa)) {
                        x.e("MicroMsg.HandlerTraceManager", "summer log file invaild format");
                    } else {
                        String je = a.je(a.access$1300());
                        a aVar2 = this.dFa;
                        Intent intent = new Intent();
                        intent.setClassName(ad.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorService");
                        intent.setAction("uncatch_exception");
                        intent.putExtra("exceptionPid", Process.myPid());
                        String str = "userName";
                        String I = at.dBv.I("login_weixin_username", "");
                        if (bi.oW(I)) {
                            I = at.dBv.I("login_user_name", "never_login_crash");
                        }
                        intent.putExtra(str, I);
                        intent.putExtra("tag", "handler");
                        intent.putExtra("exceptionMsg", Base64.encodeToString((aVar2.JB() + je).getBytes(), 2));
                        ad.getContext().startService(intent);
                    }
                    a.a(this.dFa, file);
                    a.p(this.dFa);
                    a.q(this.dFa);
                    a.k(this.dFa).edit().putLong("handler_report_lastUploadTime", System.currentTimeMillis()).commit();
                    return;
                }
                a.r(this.dFa);
            }
        } else {
            x.w("MicroMsg.HandlerTraceManager", "summer acc not ready ");
        }
    }

    public final String toString() {
        return super.toString() + "|checkAndUpload";
    }
}
