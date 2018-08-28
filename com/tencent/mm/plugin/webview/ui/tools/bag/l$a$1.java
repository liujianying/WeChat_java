package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.plugin.webview.ui.tools.bag.j.1;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class l$a$1 implements Runnable {
    final /* synthetic */ Bundle bAE;
    final /* synthetic */ int bAM;

    public l$a$1(int i, Bundle bundle) {
        this.bAM = i;
        this.bAE = bundle;
    }

    public final void run() {
        switch (this.bAM) {
            case 1:
                String string = this.bAE.getString("key_url");
                String string2 = this.bAE.getString("key_bag_icon");
                int i = this.bAE.getInt("key_scene", 0);
                Bundle bundle = this.bAE.getBundle("key_extras");
                j jVar = j.qcm;
                if (b.bv(ad.getContext())) {
                    jVar.a(string, i, string2, bundle);
                    jVar.nd(false);
                    return;
                }
                x.w("MicroMsg.WebViewBagMgr", "showBag: no float window permission");
                Context context = ad.getContext();
                RequestFloatWindowPermissionDialog.a(context, context.getString(R.l.webview_bag_no_float_window_permission_alert), new 1(jVar, string, i, string2, bundle));
                return;
            case 2:
                j.qcm.bVg();
                return;
            case 3:
                j.qcm.nc(false);
                return;
            case 4:
                j.qcm.bWU();
                return;
            case 9:
                j.qcm.aK(this.bAE.getFloat("key_alpha", 1.0f));
                return;
            default:
                return;
        }
    }
}
