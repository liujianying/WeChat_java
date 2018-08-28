package com.tencent.mm.plugin.appbrand.appcache;

import android.widget.Toast;
import com.tencent.mm.sdk.platformtools.ad;

class j$4 implements Runnable {
    final /* synthetic */ j ffE;
    final /* synthetic */ String ffJ;

    j$4(j jVar, String str) {
        this.ffE = jVar;
        this.ffJ = str;
    }

    public final void run() {
        Toast.makeText(ad.getContext(), this.ffJ, 1).show();
        this.ffE.quit();
    }
}
