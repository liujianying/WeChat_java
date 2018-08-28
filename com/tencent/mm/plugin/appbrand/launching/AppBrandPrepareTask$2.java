package com.tencent.mm.plugin.appbrand.launching;

import android.os.Process;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.3;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.4;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.PrepareParams;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.PrepareResult;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;

class AppBrandPrepareTask$2 implements c<PrepareResult> {
    final /* synthetic */ AppBrandPrepareTask geW;

    AppBrandPrepareTask$2(AppBrandPrepareTask appBrandPrepareTask) {
        this.geW = appBrandPrepareTask;
    }

    public final /* synthetic */ void at(Object obj) {
        PrepareResult prepareResult = (PrepareResult) obj;
        AppBrandPrepareTask appBrandPrepareTask = this.geW;
        x.i("MicroMsg.AppBrandPrepareTask", "[applaunch] runInClientProcess, event = %d, %s %d", new Object[]{Integer.valueOf(PrepareResult.a(prepareResult)), PrepareParams.a(appBrandPrepareTask.geS), Integer.valueOf(PrepareParams.b(appBrandPrepareTask.geS))});
        switch (PrepareResult.a(prepareResult)) {
            case 1:
                if (appBrandPrepareTask.geT != null) {
                    appBrandPrepareTask.geT.onDownloadStarted();
                    return;
                }
                return;
            case 2:
                if (PrepareResult.b(prepareResult) == null && PrepareResult.c(prepareResult) == null) {
                    com.tencent.mm.plugin.appbrand.r.c.Em().H(new 3(appBrandPrepareTask));
                }
                if (appBrandPrepareTask.geT != null) {
                    if (PrepareResult.b(prepareResult) != null) {
                        com.tencent.mm.plugin.appbrand.r.c.Em().H(new 4(appBrandPrepareTask, PrepareResult.b(prepareResult).frm));
                        if (PrepareResult.b(prepareResult).frp != null) {
                            k.qv(PrepareResult.b(prepareResult).appId).fdK = PrepareResult.b(prepareResult).frp;
                        }
                    } else {
                        x.i("MicroMsg.AppBrandPrepareTask", "runInClientProcess, config null");
                        if (!(PrepareResult.c(prepareResult) == null || appBrandPrepareTask.geU == null || ((MMActivity) appBrandPrepareTask.geU.get()) == null)) {
                            PrepareResult.c(prepareResult).cE(ad.getContext());
                        }
                    }
                    appBrandPrepareTask.geT.b(PrepareResult.b(prepareResult));
                } else {
                    x.e("MicroMsg.AppBrandPrepareTask", "runInClientProcess, prepare done, but callback is null");
                }
                com.tencent.mm.plugin.appbrand.r.c.az(appBrandPrepareTask);
                return;
            case 3:
                WeakReference weakReference = appBrandPrepareTask.geU;
                MMActivity mMActivity = weakReference == null ? null : (MMActivity) weakReference.get();
                if (mMActivity != null) {
                    mMActivity.finish();
                    mMActivity.overridePendingTransition(0, 0);
                }
                Process.killProcess(Process.myPid());
                return;
            case 4:
                if (appBrandPrepareTask.geT != null) {
                    appBrandPrepareTask.geT.jz(PrepareResult.d(prepareResult));
                    return;
                }
                return;
            case 5:
                if (appBrandPrepareTask.geT != null) {
                    appBrandPrepareTask.geT.a(PrepareResult.e(prepareResult));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
