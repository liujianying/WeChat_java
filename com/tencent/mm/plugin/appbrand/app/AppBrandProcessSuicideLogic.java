package com.tencent.mm.plugin.appbrand.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.q.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.atomic.AtomicInteger;

final class AppBrandProcessSuicideLogic extends a {
    private static final AppBrandProcessSuicideLogic fet = new AppBrandProcessSuicideLogic();
    private final AtomicInteger feu = new AtomicInteger(0);

    static /* synthetic */ void a(AppBrandProcessSuicideLogic appBrandProcessSuicideLogic, Class cls) {
        int fY = bi.fY(((h) g.Ef().DM()).dsQ);
        x.i("MicroMsg.AppBrandReporterManager", "report now process mem : %d", new Object[]{Integer.valueOf(bi.fY(((h) g.Ef().DM()).dsQ))});
        int i = fY <= 90 ? 2 : fY <= 130 ? 3 : fY <= 170 ? 4 : fY <= 210 ? 5 : 6;
        com.tencent.mm.plugin.report.service.h.mEJ.a(386, 1, 1, false);
        com.tencent.mm.plugin.report.service.h.mEJ.a(386, (long) i, 1, false);
        try {
            KVCommCrossProcessReceiver.brP();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrandProcessSuicideLogic", e, "sendKV", new Object[0]);
        }
        if (!DebuggerShell.aeq()) {
            x.i("MicroMsg.AppBrandProcessSuicideLogic", "before suicide, dump DataCenter %s", new Object[]{u.Hx().toString()});
            x.i("MicroMsg.AppBrandProcessSuicideLogic", "before suicide, last activity is %s", new Object[]{cls.getName()});
            x.chS();
            if (appBrandProcessSuicideLogic.feu.get() <= 0) {
                if (AppBrandUI.class.isAssignableFrom(cls)) {
                    ProcessRestartTask processRestartTask = new ProcessRestartTask();
                    processRestartTask.dox = ad.getProcessName();
                    processRestartTask.fex = cls.getName();
                    AppBrandMainProcessService.b(processRestartTask);
                }
                System.exit(0);
            }
        }
    }

    public static void d(Application application) {
        application.registerActivityLifecycleCallbacks(fet);
    }

    private AppBrandProcessSuicideLogic() {
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.feu.incrementAndGet();
    }

    public final void onActivityDestroyed(Activity activity) {
        if (this.feu.decrementAndGet() == 0) {
            e.post(new 1(this, activity.getClass()), "CleanupWhenNoActivitiesAliveInAppBrandProcess");
        }
    }
}
