package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;

public final class AppBrandPrepareTask {
    PrepareParams geS = new PrepareParams();
    public volatile transient b geT;
    volatile transient WeakReference<MMActivity> geU;
    boolean geV;

    public AppBrandPrepareTask(MMActivity mMActivity, g gVar) {
        int i = 0;
        AppBrandStatObject appBrandStatObject = gVar.fcE;
        this.geU = new WeakReference(mMActivity);
        PrepareParams.a(this.geS, gVar.mAppId);
        PrepareParams.a(this.geS, gVar.fct.fig);
        PrepareParams.b(this.geS, appBrandStatObject == null ? 0 : appBrandStatObject.cbB);
        PrepareParams prepareParams = this.geS;
        if (appBrandStatObject != null) {
            i = appBrandStatObject.scene;
        }
        PrepareParams.c(prepareParams, i);
        PrepareParams.b(this.geS, gVar.fct.fqx);
        PrepareParams.a(this.geS, gVar.fct.fqA);
        PrepareParams.c(this.geS, gVar.fct.fdE);
        PrepareParams.a(this.geS, gVar.aaq());
        PrepareParams.b(this.geS, gVar.fct.fqz);
        this.geV = gVar.aaq();
    }

    public final void akB() {
        if (ah.isMainThread()) {
            e.post(new 1(this), "AppBrandPrepareTask" + this.geS.toShortString());
            return;
        }
        if (!WxaCommLibRuntimeReader.abN()) {
            x.i("MicroMsg.AppBrandPrepareTask", "startPrepare(), CommLib not loaded, %s", this.geS.toShortString());
            WxaCommLibRuntimeReader.abM();
        }
        PrepareParams.d(this.geS, WxaCommLibRuntimeReader.abP().fii);
        XIPCInvoker.a("com.tencent.mm", this.geS, a.class, new 2(this));
        x.i("MicroMsg.AppBrandPrepareTask", "[applaunch] startPrepare in appbrand %s, %d", PrepareParams.a(this.geS), Integer.valueOf(PrepareParams.b(this.geS)));
    }
}
