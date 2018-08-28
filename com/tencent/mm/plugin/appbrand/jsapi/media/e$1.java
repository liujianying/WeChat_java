package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.widget.Toast;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.ad;

class e$1 implements Runnable {
    final /* synthetic */ e fVh;

    e$1(e eVar) {
        this.fVh = eVar;
    }

    public final void run() {
        Toast.makeText(ad.getContext(), ad.getContext().getString(j.cropimage_saved, new Object[]{r.Vs()}), 1).show();
    }
}
