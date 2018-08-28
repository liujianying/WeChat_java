package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.SystemClock;
import com.tencent.mm.blink.a;
import com.tencent.mm.booter.c;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.b.h.AnonymousClass3;
import com.tencent.mm.kernel.b.h.AnonymousClass5;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.splash.m;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;
import com.tencent.tinker.loader.app.ApplicationLike;

public class MMApplicationWrapper implements ApplicationLifeCycle {
    private static final String TAG = "MicroMsg.MMApplicationWrapper";
    public Application app;
    private final ApplicationLike lifeCycle;
    private h profile = null;
    private String thisProcess = "";

    public MMApplicationWrapper(ApplicationLike applicationLike, String str) {
        a.aB(applicationLike.getApplicationStartMillisTime());
        this.app = applicationLike.getApplication();
        this.lifeCycle = applicationLike;
        this.thisProcess = str;
    }

    public void onBaseContextAttached(Context context) {
        com.tencent.mm.kernel.a.a.drq = SystemClock.elapsedRealtime();
        this.profile = new h(this.thisProcess, this.app, this.lifeCycle);
        n.vd();
        k.b("stlport_shared", context.getClassLoader());
        k.b("c++_shared", context.getClassLoader());
        k.b(com.tencent.mm.xlog.app.a.uZO, context.getClassLoader());
        this.profile.cXF = c.bj(this.profile.dsQ);
        setupXLogDebugger(this.profile);
        com.tencent.mm.splash.a.e(this.app);
        x.v("PreventAccessModification", "profile %s", q.bzn);
        if (n.cP(this.thisProcess)) {
            x.i(TAG, "is plain process. load nothing");
            q.a(this.profile, null);
        } else {
            q.a(this.profile, "com.tencent.mm.app.WeChatSplashStartup");
        }
        o.h(com.tencent.mm.boot.a.a.class);
        o.cQ("com.tencent.mm.boot");
    }

    private void setupXLogDebugger(h hVar) {
        c cVar = hVar.cXF;
        if (hVar.ES()) {
            cVar.ez("MM");
        } else if (hVar.gn(":push")) {
            cVar.ez("PUSH");
        } else if (hVar.gn(":tools")) {
            cVar.ez("TOOL");
        } else if (hVar.gn(":sandbox")) {
            cVar.ez("SANDBOX");
        } else if (hVar.gn(":exdevice")) {
            cVar.ez("EXDEVICE");
        } else if (hVar.gn(":patch")) {
            cVar.ez("PATCH");
        } else if (hVar.gn(":appbrand")) {
            cVar.ez("APPBRAND");
        } else if (hVar.gn(":TMAssistantDownloadSDKService")) {
            cVar.ez("TMSDK");
        } else if (hVar.gn(":dexopt")) {
            cVar.ez("DEXOPT");
        }
    }

    public void onCreate() {
        m.ckn();
    }

    public void onTerminate() {
        if (this.profile != null) {
            h hVar = this.profile;
            hVar.dsT.a(new com.tencent.mm.by.a.a<ApplicationLifeCycle>() {
            });
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.profile != null) {
            h hVar = this.profile;
            hVar.dsT.a(new AnonymousClass5(configuration));
        }
    }

    public void onLowMemory() {
        if (this.profile != null) {
            h hVar = this.profile;
            hVar.dsT.a(new com.tencent.mm.by.a.a<ApplicationLifeCycle>() {
            });
        }
    }

    public void onTrimMemory(int i) {
        if (this.profile != null) {
            h hVar = this.profile;
            hVar.dsT.a(new AnonymousClass3(i));
        }
    }
}
