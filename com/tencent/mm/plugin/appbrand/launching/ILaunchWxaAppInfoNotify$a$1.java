package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.a;
import com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

class ILaunchWxaAppInfoNotify$a$1 implements a {
    final /* synthetic */ g fel;

    public ILaunchWxaAppInfoNotify$a$1(g gVar) {
        this.fel = gVar;
    }

    public final void bj(Object obj) {
        if (obj instanceof LaunchInfoIpcWrapper) {
            LaunchInfoIpcWrapper launchInfoIpcWrapper = (LaunchInfoIpcWrapper) obj;
            if (!this.fel.mAppId.equals(launchInfoIpcWrapper.appId) || this.fel.fct.fig != launchInfoIpcWrapper.fmv) {
                return;
            }
            if (launchInfoIpcWrapper.gfJ != null) {
                AppBrandLaunchErrorAction appBrandLaunchErrorAction = launchInfoIpcWrapper.gfJ;
                g gVar = this.fel;
                if (gVar == null) {
                    gVar = com.tencent.mm.plugin.appbrand.a.pY(appBrandLaunchErrorAction.appId);
                }
                if (gVar != null && appBrandLaunchErrorAction.fmv == gVar.fct.fig) {
                    Context context;
                    g aal = gVar.aal();
                    gVar.finish();
                    if (aal == null) {
                        context = ad.getContext();
                    } else {
                        n nVar = aal.fcz;
                        if (nVar != null) {
                            MMActivity context2 = (MMActivity) nVar.getContext();
                            if (context2.isFinishing() || context2.tlP) {
                                return;
                            }
                        }
                        return;
                    }
                    appBrandLaunchErrorAction.cE(context2);
                    return;
                }
                return;
            }
            c a = c.a(this.fel, false);
            if (a != null) {
                a.a(launchInfoIpcWrapper.fqP);
            }
        }
    }
}
