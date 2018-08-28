package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Process;
import com.tencent.mm.a.e;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.loader.stub.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tinker.lib.e.b;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.app.DefaultApplicationLike;

public class MMApplicationLike extends DefaultApplicationLike {
    private static final String TAG = "MicroMsg.MMApplication";
    private j mMMApplicationLikeImpl = new j(this);
    private ApplicationLifeCycle wrapper;

    public MMApplicationLike(Application application, int i, boolean z, long j, long j2, Intent intent) {
        super(application, i, z, j, j2, intent);
    }

    public void onBaseContextAttached(Context context) {
        a.DEBUG = false;
        a.duK = false;
        a.PATCH_ENABLED = BaseBuildInfo.PATCH_ENABLED;
        a.REV = BaseBuildInfo.REV;
        a.CLIENT_VERSION = BaseBuildInfo.CLIENT_VERSION;
        a.DEVICE_TYPE = BaseBuildInfo.DEVICE_TYPE;
        a.TIME = BaseBuildInfo.TIME;
        a.HOSTNAME = BaseBuildInfo.HOSTNAME;
        a.BUILD_TAG = BaseBuildInfo.BUILD_TAG;
        a.OWNER = BaseBuildInfo.OWNER;
        a.COMMAND = BaseBuildInfo.COMMAND;
        a.SVNPATH = BaseBuildInfo.SVNPATH;
        a.PATCH_REV = BaseBuildInfo.PATCH_REV;
        a.PATCH_TINKER_FLAG = BaseBuildInfo.PATCH_TINKER_FLAG;
        a.ENABLE_STETHO = BaseBuildInfo.ENABLE_STETHO;
        a.EX_DEVICE_LOGIN = BaseBuildInfo.EX_DEVICE_LOGIN;
        a.duL = Boolean.valueOf(BaseBuildInfo.REDESIGN_ENTRANCE);
        d.DEBUG = false;
        d.BUILD_TAG = "MicroMessenger_Android_GIT_RELEASE_GRADLE #6878";
        d.OWNER = "amm_code_helper";
        d.HOSTNAME = "45ea8765cf33";
        d.TIME = "2018-05-31 14:12:58";
        d.COMMAND = "null";
        d.REV = "f6b4b06b7ce8bc23015c8c8704a7aaf7d858dfb6";
        d.SVNPATH = "origin/RB-2018-APR@git";
        d.CLIENT_VERSION = "0x26060736";
        d.sFx = true;
        d.EX_DEVICE_LOGIN = false;
        d.duK = false;
        d.REDESIGN_ENTRANCE = false;
        d.sFy = false;
        super.onBaseContextAttached(context);
        j jVar = this.mMMApplicationLikeImpl;
        if (b.c(j.applicationLike) && b.d(j.applicationLike)) {
            com.tencent.tinker.lib.a.a.a(j.applicationLike, "armeabi-v7a");
            com.tencent.tinker.lib.a.a.a(j.applicationLike, "armeabi");
        }
        long applicationStartMillisTime = j.applicationLike.getApplicationStartMillisTime();
        j.bya = applicationStartMillisTime;
        b.bya = applicationStartMillisTime;
        j.a(j.applicationLike);
        j.byA += "/" + jVar.hashCode();
        ad.le(false);
        ad.setContext(j.applicationLike.getApplication());
        String an = bi.an(context, Process.myPid());
        x.Da(0);
        b.bqA = an;
        if (!a.DEBUG) {
            h.a(j.applicationLike.getApplication(), an);
        }
        applicationStartMillisTime = System.currentTimeMillis();
        com.tencent.mm.sdk.e.a aVar = new com.tencent.mm.sdk.e.a(com.tencent.mm.loader.stub.b.duN + "NowRev.ini");
        jVar.byB = aVar.getValue("NowRev");
        jVar.byC = a.baseRevision();
        long currentTimeMillis = System.currentTimeMillis();
        jVar.byD = currentTimeMillis - applicationStartMillisTime;
        jVar.byE = 0;
        if (!jVar.byC.equals(jVar.byB)) {
            ad.sGA = true;
            e.l(j.applicationLike.getApplication().getDir("lib", 0));
            e.l(j.applicationLike.getApplication().getDir("dex", 0));
            e.l(j.applicationLike.getApplication().getDir("cache", 0));
            e.l(j.applicationLike.getApplication().getDir("recover_lib", 0));
            b.f(j.applicationLike);
            aVar.fT("NowRev", jVar.byC);
            jVar.byE = System.currentTimeMillis() - currentTimeMillis;
            x.w("MicroMsg.MMApplicationLikeImpl", "application hash:%s, %s", j.byA, bi.cjd().toString());
        }
        x.i("MicroMsg.MMApplicationLikeImpl", "clearOldDirIfNewVersion oldversion:%s, newversion:%s, gettime:%d, settime:%d", jVar.byB, jVar.byC, Long.valueOf(jVar.byD), Long.valueOf(jVar.byE));
        if (a.DEBUG || a.duK) {
            h.a(j.applicationLike.getApplication(), an);
        }
        String str = b.bqA;
        try {
            this.wrapper = (ApplicationLifeCycle) Class.forName(ad.getPackageName() + ".app.MMApplicationWrapper").getConstructor(new Class[]{ApplicationLike.class, String.class}).newInstance(new Object[]{this, str});
            this.wrapper.onBaseContextAttached(context);
        } catch (Throwable e) {
            x.printErrStackTrace(TAG, e, "failed to create application wrapper class", new Object[0]);
            throw new RuntimeException("failed to create application wrapper class", e);
        }
    }

    public void onCreate() {
        if (this.wrapper != null) {
            this.wrapper.aD();
        }
    }

    public void onTerminate() {
        super.onTerminate();
        if (this.wrapper != null) {
            this.wrapper.aD();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        x.d(TAG, "configuration changed");
        super.onConfigurationChanged(configuration);
        if (this.wrapper != null) {
            this.wrapper.onConfigurationChanged(configuration);
        }
    }

    public Resources getResources(Resources resources) {
        return ad.getResources() == null ? resources : ad.getResources();
    }

    public void onLowMemory() {
        super.onLowMemory();
        if (this.wrapper != null) {
            this.wrapper.aD();
        }
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (this.wrapper != null) {
            this.wrapper.onTrimMemory(i);
        }
    }
}
