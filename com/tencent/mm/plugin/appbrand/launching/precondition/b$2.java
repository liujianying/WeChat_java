package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

class b$2 implements Runnable {
    final /* synthetic */ b ghq;
    final /* synthetic */ Runnable ghr;

    b$2(b bVar, Runnable runnable) {
        this.ghq = bVar;
        this.ghr = runnable;
    }

    public final void run() {
        1 1 = new 1(this);
        AppBrandLaunchProxyUI appBrandLaunchProxyUI = (AppBrandLaunchProxyUI) this.ghq.getBaseContext();
        if (Math.abs(bi.VE() - g.Ei().DT().i(a.sTY)) < 7200) {
            x.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "check tbs download, not exceed interval, just return");
            1.akJ();
            return;
        }
        g.Ei().DT().a(a.sTY, Long.valueOf(bi.VE()));
        long VF = bi.VF();
        x.d("MicroMsg.AppBrand.PreLaunchCheckForTBS", "check tbs download, cost = %d, cheTBSRet = %d", new Object[]{Long.valueOf(bi.VF() - VF), Integer.valueOf(u.a.cbD())});
        switch (u.a.cbD()) {
            case 0:
                x.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "check(Activity), onReady");
                1.onReady();
                return;
            case 1:
                x.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "check(Activity), goProxyUI");
                if (appBrandLaunchProxyUI == null || !appBrandLaunchProxyUI.akz()) {
                    1.akJ();
                    return;
                } else {
                    appBrandLaunchProxyUI.a(1, new Intent().setClass(appBrandLaunchProxyUI.getBaseContext(), AppBrandTBSDownloadProxyUI.class).putExtra("intent_extra_download_ignore_network_type", true), 1.bRZ);
                    return;
                }
            case 2:
                x.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "check(Activity), dealCannotDownload");
                1.akJ();
                return;
            default:
                return;
        }
    }
}
