package com.tencent.mm.plugin.appbrand.appcache;

import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.appcache.an.b;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;

class an$b$1 implements Runnable {
    final /* synthetic */ String bAj;
    final /* synthetic */ int fhP;
    final /* synthetic */ String fhQ;
    final /* synthetic */ b fhR;

    an$b$1(b bVar, String str, int i, String str2) {
        this.fhR = bVar;
        this.bAj = str;
        this.fhP = i;
        this.fhQ = str2;
    }

    public final void run() {
        e.aN(this.bAj, this.fhP);
        Toast.makeText(ad.getContext(), ad.getContext().getString(j.app_brand_pkg_updated_should_reboot, new Object[]{bi.aG(this.fhQ, this.bAj)}), 1).show();
    }
}
